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
import java.util.HashMap;
import java.util.List;

import com.nwac.weather.api.nwac.models.Station;

@RestController
@RequestMapping("/api")

public class StationController {

  @GetMapping("/stations")
  public Station getAllStations() throws IOException {
    String bodyText = new String();
    List<HashMap<String, String>> allTableData = new ArrayList<HashMap<String, String>>();

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
    HashMap<String, String> tableRow;
    List<HashMap<String, String>> allTableData = new ArrayList<HashMap<String, String>>();
    try {
      Document doc = Jsoup.connect("https://data.nwac.us/" + stationId).get();
      Element body = doc.body();
      bodyText = body.text();
      Integer dateHeaderIndex = bodyText.indexOf("MM");
      Integer finalHeaderIndex = bodyText.indexOf("-----");
      Integer finalDataIndex = bodyText.lastIndexOf("Total");
      String headers = bodyText.substring(dateHeaderIndex, finalHeaderIndex);
      String[] headersSplit = headers.split(" ");
      String data = bodyText.substring(finalHeaderIndex, finalDataIndex).replace("-", " ").trim();
      String[] allDataCells = data.split(" ");
      // String day = bodyText.substring(finalHeaderIndex, endIndex);
      System.out.println("Headers: " + headers);
      Integer stringLength = allDataCells.length;
      System.out.println("String length: " + headersSplit.length);
      System.out.println("Data length: " + stringLength);
      System.out.println(Arrays.toString(allDataCells));
      
      Integer counter = 0;
      tableRow = new HashMap<>();

      for (String cell: allDataCells) {
        counter++;
        System.out.println("Current Iteration: " + cell);
        System.out.println("Counter: " + counter);
        String myIndex = counter.toString();
        tableRow.put(myIndex, cell);
        System.out.println(tableRow);

        if (counter == 11) {
          allTableData.add(tableRow);
          counter = 0;
          tableRow = new HashMap<>();
        }
      }

      System.out.println(allTableData);
      return new Station(data, allTableData);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new Station(bodyText, allTableData);
  }
}
