package com.example.restassuredexample.utils;

import cucumber.api.Result;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Fixed log format for retrieval test details and chuck in email notification Created by tshi User:
 * shitim Date: 05/07/2019 Time: 8:42 AM To change this template use File | Settings | File
 * Templates.
 */
@Component
public class Logging {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());
  @Autowired private Environment environment;

  // Dummy constructor for spring scanning
  @PostConstruct
  public void init() {}

  public void beforeTest(String scenario) {
    String title =
        "*** "
            + scenario
            + " Test Run at "
            + Arrays.toString(this.environment.getActiveProfiles())
            + " ***";
    int strLength = title.getBytes(StandardCharsets.UTF_8).length;
    String separator = String.format("%" + strLength + "s", "-").replace(" ", "-");
    LOG.info(separator);
    LOG.info(title);
    LOG.info(separator);
  }

  public void afterTest(String scenario, Result.Type status) {
    String title = "*** " + scenario + " / Status - " + status + " ***";
    int strLength = title.getBytes(StandardCharsets.UTF_8).length;
    String separator = String.format("%" + strLength + "s", "-").replace(" ", "-");
    LOG.info(separator);
    LOG.info(title);
    LOG.info(separator);
  }

  public void debug(String strToLog) {
    LOG.debug(strToLog);
  }

  public void debug(String name, String content) {
    LOG.info(name + "=" + content);
    Allure.addAttachment(name, content);
  }

  public void info(String strToLog) {
    LOG.info(strToLog);
  }

  public void info(String name, String content) {
    LOG.info(name + "=" + content);
    Allure.addAttachment(name, content);
  }

  public void error(String strToLog) {
    LOG.error(strToLog);
  }

  public void error(String name, String content) {
    LOG.info(name + "=" + content);
    Allure.addAttachment(name, content);
  }
}
