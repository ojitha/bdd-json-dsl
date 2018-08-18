package dsl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DSLContext {

    public Map<String, JsonNode> vars = new HashMap<>();
}
