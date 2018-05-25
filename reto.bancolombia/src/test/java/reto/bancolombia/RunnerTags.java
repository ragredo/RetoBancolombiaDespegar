package reto.bancolombia;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "projectFeature", glue = "reto.bancolombia.definition", tags = {
                               "@Test1" })
//@CucumberOptions(features = "projectFeature", glue = "stepsDefinitions", tags = {
//"@Test1,@Test3,@Test4,@Test5,@Test6" })
public class RunnerTags {

}
