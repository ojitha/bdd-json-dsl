package dsl;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE
        , features = {"features/example.feature"}
        , glue = {"gettingstarted"})
public class RunGettingStartedTest {

}
