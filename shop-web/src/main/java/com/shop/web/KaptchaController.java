package com.shop.web;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.shop.page.ApiData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class KaptchaController {

    public static final String CAPTCHA_IMAGE_CODE = "captcha-image-code";

    private final DefaultKaptcha producer;

    @RequestMapping("/captcha")
    @ResponseBody
    public ApiData<String> captcha(HttpServletRequest request) throws IOException {

        String code = producer.createText();

        ByteArrayOutputStream outputStream = null;
        BufferedImage image = producer.createImage(code);

        outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();

        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray()).replace("\n", "").replace("\r", "");

        request.getSession().setAttribute(CAPTCHA_IMAGE_CODE, code);

        return ApiData.success(base64Img);
    }
}
