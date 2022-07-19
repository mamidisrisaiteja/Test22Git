package cucumber.options;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\AN574BV\\eclipse-workspace\\Test22\\src\\test\\java\\features",glue= {"stepSefinitions"},plugin= "json:reports/cucumber-reports/CucumberTestReport.html")
public class TestRunner1 {
	
	
	}
