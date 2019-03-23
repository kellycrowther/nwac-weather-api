package com.nwac.weather.api.nwac.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import com.nwac.weather.api.nwac.models.Station;

@RestController
@RequestMapping("/api")

public class StationController {

  @GetMapping("/stations")
  public Station getAllStations() throws IOException {
    String bodyText = "";
    try {
      Document doc = Jsoup.connect("https://data.nwac.us/ALL").get();
      Element body = doc.body();
      bodyText = body.text();
      System.out.println(doc.body());
      return new Station(bodyText);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new Station(bodyText);
  }
}
