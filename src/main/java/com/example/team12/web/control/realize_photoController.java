package com.example.team12.web.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping(value = "/getimg")
public class realize_photoController {
    /**
     * 通过url获取图片传给前端
     * @param url  前端传过来的图片url
     * @param request
     * @param response
     */

    public void getimg(@RequestParam("user_name") String user_name, String url, HttpServletRequest request, HttpServletResponse response){
        System.out.println("获取的url"+url);
//        String str1="http";
//        boolean b=url.contains(str1);
//        if (b==false){//判断是否是网络图片的url
//            url="http://*****:8080/"+url;
//        }
        try {
            URL urlimg = new URL(photoController.photoshow(user_name));
            //创建链接对象
            URLConnection urlConnection = urlimg.openConnection();
            //设置超时
            urlConnection.setConnectTimeout(1000);
            urlConnection.setReadTimeout(5000);
            urlConnection.connect();
            //获取流
            InputStream inputStream = urlConnection.getInputStream();
            //读取图片
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            if (bufferedImage!=null){
                //获取图片格式
                String format = url.substring(url.lastIndexOf(".") + 1);
                //打印图片
                ImageIO.write(bufferedImage,format,response.getOutputStream());// 将文件流放入response中

            }
        }catch (Exception e){
            System.out.println("图片异常"+e);
            System.out.println("参数异常"+url);
        }
    }

}
