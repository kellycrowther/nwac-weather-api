package com.nwac.weather.api.nwac.models;

import java.util.List;
import com.nwac.weather.api.nwac.models.OSOBLTStation;

public class Station {
  private final String body;
  private final List<OSOBLTStation> osobltStation;
  private List<OSOSTBStation> osostbStation;

  public Station(String body, List<OSOBLTStation> osobltStation) {
    this.body = body;
    this.osobltStation = osobltStation;
  }

  public Station(Station station) {
    this.body = station.body;
    this.osobltStation = station.osobltStation;
    this.osostbStation = station.osostbStation;
  }

  public String getBody() {
    return body;
  }

  public List<OSOBLTStation> getOSOBLT() {
    return osobltStation;
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
