package peccles.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonParser {

    private final ObjectMapper mapper;

    public JSonParser() {
//        get jackson object mapper
        mapper = new ObjectMapper();
    }

    public String objectToJSON(Object object) throws JsonProcessingException {
//        write object out to string as json
        return mapper.writeValueAsString(object);
    }


}
