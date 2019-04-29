package com.nwac.weather.api.nwac.models;

public class TableRow {
  private final String month;
  private final String day;
  private final String hour;
  private final String temp;
  private final String relativeHumidity;
  private final String equipmentTemp;
  private final String hourPrecipitation;
  private final String totalPrecipitation;
  private final String twentyFourHourSnow;
  private final String totalSnow;
  private final String barometricPressure;


  public TableRow(String month, String day, String hour, String temp, String relativeHumidity, String equipmentTemp, String hourPrecipitation, String totalPrecipitation, String twentyFourHourSnow, String totalSnow, String barometricPressure) {
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.temp = temp;
    this.relativeHumidity = relativeHumidity;
    this.equipmentTemp = equipmentTemp;
    this.hourPrecipitation = hourPrecipitation;
    this.totalPrecipitation = totalPrecipitation;
    this.twentyFourHourSnow = twentyFourHourSnow;
    this.totalSnow = totalSnow;
    this.barometricPressure = barometricPressure;
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

  public String getEquipmentTemp() {
    return equipmentTemp;
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

  public String getBarometricPressure() {
    return barometricPressure;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{ month: " + month + ", day: " + day + ", hour: " + hour + ", temp: " + temp + ", relativeHumidity: " + relativeHumidity + ", equipmentTemp: " + equipmentTemp + ", hourPrecipitation: " + hourPrecipitation + ", totalPrecipitation: " + totalPrecipitation + ", twentyFourHourSnow: " + twentyFourHourSnow + ", totalSnow: " + totalSnow + ", barometricPressure: " + barometricPressure + " }";
  }
}
