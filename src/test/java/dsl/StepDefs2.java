package dsl;

import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class StepDefs2 {
    @Autowired
    private DSLContext ctx;

    @Then("leaf {string} of the node {string} is {string}")
    public void readHelloNode(String jPath, String varName, String expected) {
        JsonNode node = ctx.vars.get(varName);
        JsonNode r = node.get(jPath);
        assertEquals(expected, r.asText());
        System.out.println(r);
    }
}
