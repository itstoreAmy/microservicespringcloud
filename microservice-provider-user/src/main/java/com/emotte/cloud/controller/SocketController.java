package com.emotte.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;


@RestController
public class SocketController {
    @RequestMapping("/socket")
    public String socket(String url,String ip) {
        String result = null;
        try {
            // 向服务器发出请求建立连接
            Socket socket = new Socket(url, Integer.parseInt(ip));
            // 从socket中获取输入输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            PrintWriter pw = new PrintWriter(outputStream);
            pw.println("hello");
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            result = br.readLine();
            System.out.println(result);

            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
}
