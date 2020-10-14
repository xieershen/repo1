package com.cms.portal.controller.admin;



import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created with IDEA
 * author:XieJie
 * Date:2020/10/11
 * Time:10:53
 */
@Controller
public class LoginController {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("login.do")
    public String toLogin(){
        return "/admin/login";
    }


    @GetMapping("captcha.do")
    public void doCaptcha(HttpServletResponse httpServletResponse){
        //生成验证码
        String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);
        try (ServletOutputStream outputStream = httpServletResponse.getOutputStream()) {
            ImageIO.write(image,"jpg",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
