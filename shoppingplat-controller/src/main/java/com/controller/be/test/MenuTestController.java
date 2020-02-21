package com.controller.be.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj
 * @date 2019/12/4
 */

@Controller
public class MenuTestController {

    @RequestMapping("/test/menu")
    public String menu() {
        return "be/menu";
    }
}

