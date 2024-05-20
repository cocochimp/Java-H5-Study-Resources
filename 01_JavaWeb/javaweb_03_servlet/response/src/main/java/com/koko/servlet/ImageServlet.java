package com.koko.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //浏览器3秒刷新一次
        resp.setHeader("refresh","3");

        //在内存中创建一个照片，并得到图片
        BufferedImage image=new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        //设置背景及写数据
        g.setColor(Color.WHITE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        //告诉浏览器图片的打开方式
        resp.setContentType("image/jpeg");
        //不让浏览器存在缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());

    }

    //生成随机数
    private String makeNum(){
        Random r=new Random();
        String num = r.nextInt(9999999)+"";
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<7-num.length();i++){
            sb.append("0");
        }
        num=sb.toString()+num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
