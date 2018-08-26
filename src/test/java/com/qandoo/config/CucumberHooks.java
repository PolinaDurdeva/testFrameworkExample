package com.qandoo.config;

import com.qandoo.DriverHolder;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {
    @Before
    public void beforeScenario(){
        DriverHolder.initializeDriver();
    }

    @After
    public void afterScenario(){
        DriverHolder.closeDriver();
    }
}
