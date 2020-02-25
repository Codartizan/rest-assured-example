package com.example.restassuredexample.hook;

import com.example.restassuredexample.utils.Logging;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: Cucumber hook definition class
 * Created by timshi
 * Date: 2020/02/25
 * Time: 1:57 pm
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CukeHook {

    @Autowired private Logging log;

    @Before
    public void setup_cucumber_spring_context() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {

        // Multi-thread logging configuration
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        MDC.put("runId", Thread.currentThread().getId() + "_" + formatter.format(date));

        log.beforeTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {

        log.afterTest(scenario.getName(), scenario.getStatus());

    }

}
