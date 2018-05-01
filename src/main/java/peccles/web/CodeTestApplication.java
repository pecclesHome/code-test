package peccles.web;

import peccles.objects.Result;

import java.io.IOException;
import java.util.List;

public class CodeTestApplication {

    private String url;

    public static void main(String[] args) {
        MainPagePares mainPagePares = new MainPagePares();
        List<String> list;
        try {
//            get list of the item urls
            list = mainPagePares.getURLsFromInitalPage();
            Result result = new Result();
//            get the information from each url
            for (String itemUrl : list) {
                result.add(mainPagePares.getDetails(itemUrl));
            }
//           print out total
            System.out.println(result.getTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
