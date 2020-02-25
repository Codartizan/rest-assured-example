package com.example.restassuredexample.steps;

import com.example.restassuredexample.utils.Logging;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/** Description: Created by timshi Date: 2020/02/25 Time: 2:28 pm */
public class GlobalStepDef implements En {

  @Autowired private GlobalStepState state;
  @Autowired private Logging log;

  public GlobalStepDef() {
    When(
        "^send (.*) the request$",
        (String method) -> {
          // Step place holder
        });

    Then(
        "^the status code is (.*)$",
        (String status) -> {
          // RA's method to validate if the status code is correct
          state.json = state.response.then().statusCode(Integer.parseInt(status.replace("\"", "")));
          log.info("Response status code", String.valueOf(state.response.getStatusCode()));
          log.info("Response body", state.response.getBody().prettyPrint());
        });

    And(
        "^the response is matching the (.*)$",
        (String schema) -> {
          JsonSchemaFactory jsonSchemaFactory =
              JsonSchemaFactory.newBuilder()
                  .setValidationConfiguration(
                      ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze())
                  .freeze();
          state
              .json
              .assertThat()
              .body(matchesJsonSchemaInClasspath("schema/" + schema).using(jsonSchemaFactory));
          log.info("Response schema validation completed, OK!");
        });
  }
}
