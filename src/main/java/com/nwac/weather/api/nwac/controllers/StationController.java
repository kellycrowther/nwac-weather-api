package com.nwac.weather.api.nwac.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nwac.weather.api.nwac.models.Station;
import com.nwac.weather.api.nwac.models.TableRow;

@RestController
@RequestMapping("/api")

public class StationController {

  @GetMapping("/stations")
  public Station getAllStations() throws IOException {
    String bodyText = new String();
    List<TableRow> allTableData = new ArrayList<TableRow>();

    try {
      Document doc = Jsoup.connect("https://data.nwac.us/ALL").get();
      Element body = doc.body();
      bodyText = body.text();
      System.out.println(doc.body());
      return new Station(bodyText, allTableData);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new Station(bodyText, allTableData);
  }

  @GetMapping("/stations/{id}")
  public Station getStation(@PathVariable(value="id") String stationId) throws IOException {
    String bodyText = "";
    TableRow tableRow = null;
    List<TableRow> allTableData = new ArrayList<TableRow>();
    String month = null;
    String day = null;
    String hour = null;
    String temp = null;
    String relativeHumidity = null;
    String equipmentTemp = null;
    String hourPrecipitation = null;
    String totalPrecipitation = null;
    String twentyFourHourSnow = null;
    String totalSnow = null;
    String barometricPressure = null;
    try {
      Document doc = Jsoup.connect("https://data.nwac.us/" + stationId).get();
      Element body = doc.body();
      bodyText = body.text();
      Integer dateHeaderIndex = bodyText.indexOf("MM");
      Integer finalHeaderIndex = bodyText.indexOf("-----");
      Integer finalDataIndex = bodyText.lastIndexOf("Total");
      String headers = bodyText.substring(dateHeaderIndex, finalHeaderIndex);
      String data = bodyText.substring(finalHeaderIndex, finalDataIndex).replace("--", " ").trim();
      String[] allDataCells = data.split(" ");
      
      System.out.println("StationController->getStation->Headers-> " + headers);
      System.out.println("StationController->getStation->allDataCells-> " + Arrays.toString(allDataCells));
      
      Integer counter = 0;

      for (String cell: allDataCells) {
        counter++;
        
        if (counter == 1) {
          month = cell;
        }

        if (counter == 2) {
          day = cell;
        }

        if (counter == 3) {
          hour = cell;
        }

        if (counter == 4) {
          temp = cell;
        }

        if (counter == 5) {
          relativeHumidity = cell;
        }

        if (counter == 6) {
          equipmentTemp = cell;
        }

        if (counter == 7) {
          hourPrecipitation = cell;
        }

        if (counter == 8) {
          totalPrecipitation = cell;
        }

        if (counter == 9) {
          twentyFourHourSnow = cell;
        }

        if (counter == 10) {
          totalSnow = cell;
        }

        if (counter == 11) {
          barometricPressure = cell;

          tableRow = new TableRow(month, day, hour, temp, relativeHumidity, equipmentTemp, hourPrecipitation,
                                  totalPrecipitation, twentyFourHourSnow, totalSnow, barometricPressure);
          System.out.println(tableRow); // Using @Override with custom toString() method to print the data
          allTableData.add(tableRow);
          counter = 0;
          tableRow = null;
          month = null;
          hour = null;
          temp = null;
          relativeHumidity = null;
          equipmentTemp = null;
          hourPrecipitation = null;
          totalPrecipitation = null;
          twentyFourHourSnow = null;
          totalSnow = null;
          barometricPressure = null;
        }
      }
      return new Station(data, allTableData);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new Station(bodyText, allTableData);
  }
}
