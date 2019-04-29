package com.nwac.weather.api.nwac.models;

import java.util.List;
import com.nwac.weather.api.nwac.models.TableRow;

public class Station {
  private final String body;
  private final List<TableRow> weather;

  public Station(String body, List<TableRow> weather) {
    this.body = body;
    this.weather = weather;
  }

  public String getBody() {
    return body;
  }

  public List<TableRow> getWeather() {
    return weather;
  }
}
