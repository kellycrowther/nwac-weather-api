package com.nwac.weather.api.nwac.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
  
  @GetMapping
  public String welcomeToNwacApi() {
    return "Welcome to the NWAC API where you can get todays weather reports from avalanche stations in the Northwest.";
  }
}
