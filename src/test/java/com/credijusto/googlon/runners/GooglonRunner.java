package com.credijusto.googlon.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features", glue="src/test/java")
public class GooglonRunner {

}
