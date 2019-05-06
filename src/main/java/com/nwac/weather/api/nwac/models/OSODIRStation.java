package com.nwac.weather.api.nwac.models;

public class OSODIRStation {
  private final String month;
  private final String day;
  private final String hour;
  private final String temp;
  private final String relativeHumidity;
  private final String minWind;
  private final String avgWind;
  private final String maxWind;
  private final String directionWind;

  public OSODIRStation(String month, String day, String hour, String temp, String relativeHumidity,
      String minWind, String avgWind, String maxWind, String directionWind) {
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.temp = temp;
    this.relativeHumidity = relativeHumidity;
    this.minWind = minWind;
    this.avgWind = avgWind;
    this.maxWind = maxWind;
    this.directionWind = directionWind;
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

  public String getMinWind() {
    return minWind;
  }

  public String getAvgWind() {
    return avgWind;
  }

  public String getMaxWind() {
    return maxWind;
  }

  public String getDirectionWind() {
    return directionWind;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{ month: " + month + ", day: " + day + ", hour: " + hour + ", temp: " + temp
        + ", relativeHumidity: " + relativeHumidity + ", minWind: " + minWind + ", avgWind: "
        + avgWind + ", maxWind: " + maxWind + ", directionWind: "
        + directionWind + " }";
  }
}
