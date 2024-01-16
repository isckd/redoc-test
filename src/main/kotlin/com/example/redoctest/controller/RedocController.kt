package com.example.redoctest.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@Tag(name = "Redoc", description = "Redoc")
class RedocController {

    @GetMapping("/redoc")
    fun redoc(): String {
        return "redoc"
    }

}