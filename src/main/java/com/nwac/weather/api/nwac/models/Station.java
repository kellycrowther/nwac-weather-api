package com.nwac.weather.api.nwac.models;

import java.util.List;
import com.nwac.weather.api.nwac.models.TableRow;

public class Station {
  private final String body;
  private final List<TableRow> weather;
  private List<OSOSTBStation> osostbStation;

  public Station(String body, List<TableRow> weather) {
    this.body = body;
    this.weather = weather;
  }

  public Station(Station station) {
    this.body = station.body;
    this.weather = station.weather;
    this.osostbStation = station.osostbStation;
  }

  public String getBody() {
    return body;
  }

  public List<TableRow> getWeather() {
    return weather;
  }

  public List<OSOSTBStation> getOSOSTBStation() {
    return osostbStation;
  }

  public Station withOsostbStation(List<OSOSTBStation> osostbStation) {
    this.osostbStation = osostbStation;
    return this;
  }

  public Station build() {
    return new Station(this);
  }
}
