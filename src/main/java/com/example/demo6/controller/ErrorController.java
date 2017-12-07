package com.example.demo6.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/10/19 14:34
 */
@RestController
public class ErrorController {

    @GetMapping("/noexist")
    public void throwException() throws Exception {
        throw new Exception("抛出异常");
    }
}
