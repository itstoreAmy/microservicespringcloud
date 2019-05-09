package com.emotte.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LogTraceController {
    private final Logger logger = LoggerFactory.getLogger(LogTraceController.class);
    @RequestMapping(value = "/usertrace" ,method = RequestMethod.GET)
    public String trace(HttpServletRequest request){

        logger.info("===user trace===");
        logger.info("参数:");
        // 一条请求链路(Trace)的唯一标识,必须的值
        String a = request.getHeader("X-B3-TraceId");
        // 一个工作单元(Span)的唯一标识,必须的值
        String b = request.getHeader("X-B3-SpanId");
        // 标识当前工作单元所属的上一个工作单元,Root Span(请求链路的第一个工作单元)的改值为空
        String c = request.getHeader("X-B3-ParentSpanId");
        // 是否被抽样输出的标志,1表示需要被输出,0表示不需要被输出
        String d = request.getHeader("X-B3-Sampled");
        // 工作单元的名称
        String e = request.getHeader("X-Span-Name");

        return "Trace User";
    }
}
