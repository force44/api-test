package com.apitest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestEndPoint {


    @PostMapping("/test")
    fun getTest(mapping: HashMap<String, String>):String{
        return "obj";
    }
}