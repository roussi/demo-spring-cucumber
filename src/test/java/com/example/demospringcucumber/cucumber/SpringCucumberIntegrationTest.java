package com.example.demospringcucumber.cucumber;

import com.example.demospringcucumber.DemoSpringCucumberApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author aroussi
 * @version %I% %G%
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        dryRun = true,
        features = "src/test/resources/features")
@CucumberContextConfiguration
@SpringBootTest(classes = {DemoSpringCucumberApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringCucumberIntegrationTest {
}
