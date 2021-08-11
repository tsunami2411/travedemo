package com.example.traveldemo.controller;

import com.example.traveldemo.entity.Result;
import com.example.traveldemo.entity.User;
import com.example.traveldemo.service.UserService;
import com.example.traveldemo.utils.CreateImageCode;
import com.example.traveldemo.utils.ValidateImageCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Maozh
 * @Date: 2021 07 17
 */
@Controller
@RequestMapping("user")
@CrossOrigin // 允许跨域
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param code
     * @param user
     * @return
     */
    @PostMapping("register")
    @ResponseBody
    public Result register(String code,String key, @RequestBody User user, HttpServletRequest request){
        Result result = new Result();
        log.info("接受的验证码："+code);
        log.info("接受的user对象："+user);
        log.info("接受的useryanzhengma："+key);


        //验证验证码
        String keyCode = (String) request.getServletContext().getAttribute(key);
        log.info(keyCode);

        try {
            if (code.equalsIgnoreCase(keyCode)) {
                //注册用户

                userService.register(user);
                result.setMsg("注册成功!!!");
            }else {
                throw new RuntimeException("验证码错误！！！");
            }

        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setState(false);
        }
        return result;

    }

    /**
     * 生成验证码
     */
    @GetMapping("getImage")
    @ResponseBody
    public Map<String,String> getImage(HttpServletRequest request) throws IOException {

        Map<String,String> result = new HashMap<>();
        CreateImageCode createImageCode = new CreateImageCode();
        //获取验证码
        String securityCode = createImageCode.getCode();

        //验证码存入session
        String key = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        request.getServletContext().setAttribute(key,securityCode);


        //生成图片
        BufferedImage image = createImageCode.getBuffImg();

        //base64编码
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image,"png",bos);
        String string = Base64Utils.encodeToString(bos.toByteArray());
        result.put("key",key);
        result.put("image",string);
        return result;

    }
}
