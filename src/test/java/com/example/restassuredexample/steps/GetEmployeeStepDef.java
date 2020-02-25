package com.example.restassuredexample.steps;

import com.example.restassuredexample.utils.Logging;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;

/** Description: Created by timshi Date: 2020/02/25 Time: 2:58 pm */
public class GetEmployeeStepDef implements En {

  @Autowired private GlobalStepState state;
  @Autowired Logging log;
  private static String baseUrl = "http://dummy.restapiexample.com/api/v1/";
  private static String path = "employees";

  public GetEmployeeStepDef() {
    Given(
        "^get all employees from dummy api$",
        () -> {
          state.request = given().baseUri(baseUrl).basePath(path);
          // Set header base on your need, e.g.
          // .header("Content-Type", "application/json");
          log.info("Request Header set");

          state.response = state.request.when().get();
          log.debug("Response\n", state.response.prettyPrint());
        });

    Given(
        "^get all employees from dummy api with an invalid path$",
        () -> {
          state.request = given().baseUri(baseUrl).basePath("something");

          state.response = state.request.when().get();
        });
  }
}
