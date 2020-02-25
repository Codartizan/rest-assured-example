package com.example.restassuredexample.steps;

import com.example.restassuredexample.utils.Logging;
import com.example.restassuredexample.utils.Utility;
import com.google.gson.Gson;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;

/** Description: Created by timshi Date: 2020/02/25 Time: 7:53 pm */
public class CreateEmployeeStepDef implements En {

  @Autowired private GlobalStepState state;
  @Autowired private Logging log;
  @Autowired private Utility util;
  private static String baseUrl = "http://dummy.restapiexample.com/api/v1/";
  private static String path = "create";

  public CreateEmployeeStepDef() {
    Given(
        "^new employee object created$",
        () -> {
          Gson gson = new Gson();
          String req = gson.toJson(util.buildEmployee());
          log.info("Request Body", req);
          state.response =
              given()
                  .baseUri(baseUrl)
                  .basePath(path)
                  // .header("Accept", "application/json")
                  .body(req)
                  .when()
                  .post();
        });
  }
}
