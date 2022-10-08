package com.shop.web.fronted;

import com.shop.exception.BaseErrorCause;
import com.shop.model.UserModel;
import com.shop.page.ApiData;
import com.shop.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.shop.config.SessionKey.BACKEND_SESSION;
import static com.shop.web.KaptchaController.CAPTCHA_IMAGE_CODE;

@Slf4j
@RestController
@RequestMapping("backend")
@AllArgsConstructor
public class SystemController {

    private final UserService userService;

    @PostMapping(value = "login")
    public ApiData<String> login(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam("captcha") String captcha, HttpServletRequest request) {
        String code = (String) request.getSession().getAttribute(CAPTCHA_IMAGE_CODE);
        if (!StringUtils.hasLength(code) || !code.equalsIgnoreCase(captcha)) {
            return ApiData.fail(BaseErrorCause.SYSTEM_EXCEPTION.getCode(),"验证码输入错误");
        }

        UserModel userModel = userService.loadUserModel(username, password);
        if (userModel == null) {
            return ApiData.fail(BaseErrorCause.SYSTEM_EXCEPTION.getCode(),"验证码输入错误");
        }

        request.getSession().setAttribute(BACKEND_SESSION, userModel);
        return ApiData.success("登录成功");
    }
}
