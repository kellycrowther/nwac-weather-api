package com.nwac.weather.api.nwac.models;

public class OSOSTBStation {
  private final String month;
  private final String day;
  private final String hour;
  private final String temp;
  private final String relativeHumidity;
  private final String hourPrecipitation;
  private final String totalPrecipitation;
  private final String twentyFourHourSnow;
  private final String totalSnow;

  public OSOSTBStation(String month, String day, String hour, String temp, String relativeHumidity,
      String hourPrecipitation, String totalPrecipitation, String twentyFourHourSnow, String totalSnow) {
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.temp = temp;
    this.relativeHumidity = relativeHumidity;
    this.hourPrecipitation = hourPrecipitation;
    this.totalPrecipitation = totalPrecipitation;
    this.twentyFourHourSnow = twentyFourHourSnow;
    this.totalSnow = totalSnow;
  }

  public String getMonth() {
    return month;
  }

  public String getDay() {
    return day;
  }

  public String getHour() {
    return hour;
  }

  public String getTemp() {
    return temp;
  }

  public String getRelativeHumidity() {
    return relativeHumidity;
  }

  public String getHourPrecipitation() {
    return hourPrecipitation;
  }

  public String getTotalPrecipitation() {
    return totalPrecipitation;
  }

  public String getTwentyFourHourSnow() {
    return twentyFourHourSnow;
  }

  public String getTotalSnow() {
    return totalSnow;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{ month: " + month + ", day: " + day + ", hour: " + hour + ", temp: " + temp
        + ", relativeHumidity: " + relativeHumidity + ", hourPrecipitation: "
        + hourPrecipitation + ", totalPrecipitation: " + totalPrecipitation + ", twentyFourHourSnow: "
        + twentyFourHourSnow + ", totalSnow: " + totalSnow + " }";
  }
}
