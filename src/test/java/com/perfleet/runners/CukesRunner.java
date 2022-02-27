package com.perfleet.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/perfleet/step_definitions",
        dryRun = false,
        tags = "@PERF-880"
)

public class CukesRunner {
}
