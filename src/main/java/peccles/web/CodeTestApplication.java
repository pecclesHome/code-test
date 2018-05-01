package peccles.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import peccles.objects.Result;

import java.io.IOException;
import java.util.List;

public class CodeTestApplication {

    private static String url = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

    private static Logger logger = LoggerFactory.getLogger(CodeTestApplication.class);

    public static void main(String[] args) {

        MainPagePares mainPagePares = new MainPagePares();
        List<String> list;
        try {
//            get list of the item urls
            logger.trace("Getting initial page and list of items");
            list = mainPagePares.getURLsFromInitalPage(url);
            Result result = new Result();
//            get the information from each url
            logger.trace("Getting item pages and details");
            for (String itemUrl : list) {
                result.add(mainPagePares.getDetails(itemUrl));
            }
//           print out total
            logger.debug("the Total value is {}", result.getTotal());
//            get JSON Parser
            JSonParser jSonParser = new JSonParser();
//            write object out to string as json
            System.out.println(jSonParser.objectToJSON(result));
        } catch (IOException e) {
            logger.error("IO Exception Thrown while accessing pages, process will now finish.");
        }
    }
}
