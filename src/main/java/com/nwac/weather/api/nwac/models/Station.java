package com.nwac.weather.api.nwac.models;

import java.util.HashMap;
import java.util.List;

public class Station {
  private final String body;
  private final List<HashMap<String, String>> weather;

  public Station(String body, List<HashMap<String, String>> weather) {
    this.body = body;
    this.weather = weather;
  }

  public String getBody() {
    return body;
  }

  public List<HashMap<String, String>> getWeather() {
    return weather;
  }
}
