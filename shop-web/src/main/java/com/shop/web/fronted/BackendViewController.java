package com.shop.web.fronted;


import com.shop.core.model.ViewPageDTO;
import com.shop.model.ResourceDO;
import com.shop.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.shop.config.SessionKey.BACKEND_SESSION;

@Controller
@RequestMapping("/backend")
@Slf4j
public class BackendViewController {

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request) {
        return toIndex(request);
    }

    private ModelAndView toIndex(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("backend/dashboard");
        UserModel userModel = (UserModel) request.getSession().getAttribute(BACKEND_SESSION);
        if (userModel == null) {
            modelAndView.setViewName("backend/login");
        } else {
            if (CollectionUtils.isEmpty(userModel.getResources())) {
                modelAndView.addObject("resourceHtml", "");
            } else {
                modelAndView.addObject("resourceHtml", resourceHtml(userModel.getResources()));
            }
        }
        return modelAndView;
    }

    @RequestMapping("")
    public ModelAndView homePage(HttpServletRequest request) {
        return toIndex(request);
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping("toSubPage")
    public ModelAndView toSubPage(ViewPageDTO dto, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(dto.getViewName());
        if (request.getSession().getAttribute(BACKEND_SESSION) == null) {
            log.info("登录失效，重新登陆");
            modelAndView.setViewName("login");
        }
        modelAndView.addObject("data", dto);
        return modelAndView;
    }

    @RequestMapping("toPage")
    public ModelAndView goPageView(@RequestParam String viewName, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        if (request.getSession().getAttribute(BACKEND_SESSION) == null) {
            log.info("登录失效，重新登陆");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }


    private String resourceHtml(List<ResourceDO> resources) {
        Map<Long, List<ResourceDO>> resourcesMap = resources.stream().collect(Collectors.groupingBy(ResourceDO::getParentId));
        List<ResourceDO> rootResources = resourcesMap.getOrDefault(-1L, null);
        StringBuilder stringBuilder = buildHtml(resourcesMap, rootResources, new StringBuilder());
        return stringBuilder.toString();
    }

    private StringBuilder buildHtml(Map<Long, List<ResourceDO>> resourcesMap, List<ResourceDO> rootResources, StringBuilder stringBuilder) {
        if (CollectionUtils.isEmpty(rootResources)) {
            return stringBuilder;
        }

        for (ResourceDO rootResource : rootResources) {
            List<ResourceDO> subResources = resourcesMap.getOrDefault(rootResource.getId(), null);

            if (CollectionUtils.isEmpty(subResources)) {
                stringBuilder.append("<li class=\"nav-item\">")
                        .append("<a href=\"javascript:void(0)\" onclick=\"Tools.toPage('")
                        .append(rootResource.getName()).append("','")
                        .append(rootResource.getUrl()).append("', this)\" class=\"nav-link\">");
                if (StringUtils.hasText(rootResource.getIcon())) {
                    stringBuilder.append("<i class=\"nav-icon ").
                            append(rootResource.getIcon())
                            .append("\"></i>");
                }
                stringBuilder.append("<span class=\"nav-text fadeable\"><span>")
                        .append(rootResource.getName()).append("</span></span>")
                        .append("</a><b class=\"sub-arrow\"></b></li>");
            } else {
                stringBuilder.append("<li class=\"nav-item\">")
                        .append("<a href=\"javascript:void(0)\" class=\"nav-link dropdown-toggle collapsed\">");
                if (StringUtils.hasText(rootResource.getIcon())) {
                    stringBuilder.append("<i class=\"nav-icon ")
                            .append(rootResource.getIcon())
                            .append("\"></i>");
                }
                stringBuilder.append("<span class=\"nav-text fadeable\"><span>")
                        .append(rootResource.getName())
                        .append("</span></span>")
                        .append("<b class=\"caret fa fa-angle-left rt-n90\"></b></a>")
                        .append("<div class=\"hideable submenu collapse\"><ul class=\"submenu-inner\">")
                        .append(buildHtml(resourcesMap, subResources, new StringBuilder()))
                        .append("</ul></div><b class=\"sub-arrow\"></b></li>");
            }
        }

        return stringBuilder;
    }
}
