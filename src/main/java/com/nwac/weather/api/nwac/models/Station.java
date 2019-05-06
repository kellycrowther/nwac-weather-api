package com.nwac.weather.api.nwac.models;
import java.util.List;

public class Station {
  private final String body = "This is the single station API endpoint. It will return an object based on the stations data. The objects for each station are different depending on what data the station provides";
  private String rawData;
  private List<OSOBLTStation> osobltStation;
  private List<OSOSTBStation> osostbStation;
  private List<OSODIRStation> osodirStation;

  public Station() {
  }

  public Station(Station station) {
    this.rawData = station.rawData;
    this.osobltStation = station.osobltStation;
    this.osostbStation = station.osostbStation;
    this.osodirStation = station.osodirStation;
  }

  public String getBody() {
    return body;
  }

  public String getRawData() {
    return rawData;
  }

  public List<OSOBLTStation> getOSOBLT() {
    return osobltStation;
  }

  public List<OSOSTBStation> getOSOSTBStation() {
    return osostbStation;
  }

  public List<OSODIRStation> getOSODIRStation() {
    return osodirStation;
  }

  public Station withOsobltStation(String rawData, List<OSOBLTStation> osobltStation) {
    this.rawData = rawData;
    this.osobltStation = osobltStation;
    return this;
  }

  public Station withOsostbStation(String rawData, List<OSOSTBStation> osostbStation) {
    this.rawData = rawData;
    this.osostbStation = osostbStation;
    return this;
  }

  public Station withOsodirStation(String rawData, List<OSODIRStation> osodirStation) {
    this.rawData = rawData;
    this.osodirStation = osodirStation;
    return this;
  }

  public Station build() {
    return new Station(this);
  }
}
