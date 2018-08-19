package gettingstarted;
import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import dsl.DSLContext;
import io.burt.jmespath.Expression;
import io.burt.jmespath.JmesPath;
import io.burt.jmespath.jackson.JacksonRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import utils.Common;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Stepdefs {
    File file;
    @Autowired
    private DSLContext ctx;


    @Given(value = "from the file {string}")
    public void aHelloJson(String fileName) throws URISyntaxException {
        this.file = Common.getSpeakerFile(fileName);
        assertNotNull(file);
    }

    @When("define the {string} node of {string}")
    public void defineTheHelloNode(String varName, String jPath ) throws IOException {

        //jmesPath
        ObjectMapper mapper = new ObjectMapper();
        JsonNode input = mapper.readTree(this.file);
        JmesPath<JsonNode> jmespath = new JacksonRuntime();
        Expression<JsonNode> expression =jmespath.compile(jPath);
        JsonNode result = expression.search(input);
        ctx.vars.put(varName,result);
        System.out.println(result);
    }



}
