package com.example.restassuredexample.steps;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

/** Description: Created by timshi Date: 2020/02/25 Time: 2:27 pm */
@Component
public class GlobalStepState {
  protected Response response;
  protected ValidatableResponse json;
  protected RequestSpecification request;
}
