package com.devfactory.tpmis.auth.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping("/")
  public String root() {
    return "redirect:/index.html";
  }
}
