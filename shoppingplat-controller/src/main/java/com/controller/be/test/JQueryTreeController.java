package com.controller.be.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author lzn
 */
@Controller
public class JQueryTreeController {

    @RequestMapping("/test/tree")
    public String tree(){
        return "be/tree";
    }
}
