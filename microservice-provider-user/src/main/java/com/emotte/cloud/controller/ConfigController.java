//package com.emotte.cloud.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//
////@PropertySource(value = {"*.yml"},ignoreResourceNotFound = true,encoding = "UTF-8")
//@RestController
//@RefreshScope   // config 发生改变,就会更改
//// ConfigClientController  这个名字不能用 哎呀呀 找了一天的原因,气死我了
//public class ConfigController {
//
//    @Value("${profile}")
//    private String profile;
//
//    @GetMapping("/profile")
//    public String getProfile() {
//        return this.profile;
//    }
//
//    @Value("www.baidu.com")
//    private String baiduUrl;
////
////
////    @Value("classpath:static/file/a.txt")
////    private Resource testFile;
////
////
////    @Value("#{systemProperties['os.name']}")
////    private String osName;
////
////
////    @Value("#{T (java.lang.Math).random() * 100.0}")
////    private double randomNumber;
//
//    @GetMapping("/getBaiduUrl")
//    public String getBaiduUrl(){
//        System.out.println("aaaaaaaaaaaa");
//        return this.baiduUrl;
//    }
////
////    @GetMapping("/getTestFile")
////    public Resource getTestFile(){
////        return this.testFile;
////    }
////
////    @GetMapping("/getOsName")
////    public String getOsName(){
////        return this.osName;
////    }
////
////    @GetMapping("/getRandomNumber")
////    public double getRandomNumber(){
////        return this.randomNumber;
////    }
//
//
//
//
//}
