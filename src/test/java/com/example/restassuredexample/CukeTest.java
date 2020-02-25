package com.example.restassuredexample;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true,
    features = {"src/test/resources/features"},
    plugin = {
      "pretty",
      "html:target/cucumber-html-report",
      "json:target/cucumber/cucumber.json",
      "junit:target/cucumber/cucumber.xml",
      "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
      "rerun:target/rerun.txt"
    },
    glue = {"com.example.restassuredexample.steps", "com.example.restassuredexample.hook"},
    junit = {"--step-notifications"},
    monochrome = true,
    tags = {"not @ignore"})
public class CukeTest {}
