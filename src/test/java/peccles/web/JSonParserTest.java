package peccles.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import peccles.objects.Berry;
import peccles.objects.Result;

import static org.junit.Assert.assertEquals;

public class JSonParserTest {
    String expected = "{\"results\":[{\"title\":\"Sainsbury's Strawberries 400g\",\"kcal_per_100g\":33,\"unit_price\":1.75,\"description\":\"by Sainsbury's strawberries\"},{\"title\":\"Sainsbury's Blueberries 200g\",\"kcal_per_100g\":45,\"unit_price\":1.75,\"description\":\"by Sainsbury's blueberries\"},{\"title\":\"Sainsbury's Cherry Punnet 200g\",\"kcal_per_100g\":52,\"unit_price\":1.5,\"description\":\"Cherries\"}],\"total\":5.00}";

    @Test
    public void objectToJSON() throws JsonProcessingException {
        JSonParser jSonParser = new JSonParser();
        Result result = new Result();
        result.add(new Berry("Sainsbury's Strawberries 400g", 33, 1.75,
                "by Sainsbury's strawberries"));
        result.add(new Berry("Sainsbury's Blueberries 200g", 45, 1.75,
                "by Sainsbury's blueberries"));
        result.add(new Berry("Sainsbury's Cherry Punnet 200g", 52, 1.5,
                "Cherries"));
        String resultingJSON = jSonParser.objectToJSON(result);
        assertEquals(expected, resultingJSON);
    }
}