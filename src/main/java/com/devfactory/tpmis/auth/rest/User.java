package com.devfactory.tpmis.auth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/users")
public class User {

  @GetMapping("me")
  public Principal getCurrentUser(Principal me) {
    return me;
  }
}
