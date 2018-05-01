package peccles.web;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import peccles.objects.Berry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPagePares {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<String> getURLsFromInitalPage(String url) throws IOException {
        logger.debug("Url =  {}", url);
        Document doc = Jsoup.connect(url).get();
//        find all the elements of class productNameAndPromotions this should cut out cross sell
        Elements elements = doc.getElementsByClass("productNameAndPromotions");
        ArrayList<String> urls = new ArrayList<>();
        for (Element element : elements) {
//            find and get the links from the productNameAndPromotions classes
            Element link = element.select("a").first();
            String linkHref = link.attr("abs:href");
            logger.debug("link found {}", linkHref);
            urls.add(linkHref);
        }
        return urls;
    }

    public Berry getDetails(String url) throws IOException {
        Berry berry = new Berry();
        Document doc = Jsoup.connect(url).get();
//        find all the elements of class productNameAndPromotions this should cut out cross sell
//        Read product title
        Element productTitleDescriptionContainer = doc.getElementsByClass("productTitleDescriptionContainer").first();
        String title = productTitleDescriptionContainer.getElementsByTag("h1").first().text();
        logger.debug("title is {}", title);
        berry.setTitle(title);

//        Read the price
        Element pricePerUnitElement = doc.getElementsByClass("pricePerUnit").first();
        String pricePerUnit = pricePerUnitElement.text();
        logger.debug("price is {}", pricePerUnit);
//        Remove £ and /unit from price value
        double price = Double.parseDouble(pricePerUnit.substring(pricePerUnit.indexOf('£') + 1, pricePerUnit.indexOf('/') - 1));
        berry.setUnit_price(price);
//        Read the description and kcal per 100g from info tab
        Elements productDataItemHeaderElements = doc.getElementsByClass("productDataItemHeader");
        Elements productTextElements = doc.getElementsByClass("productText");
        int counter = 0;
//        integrate over productDataItemHeaderElements to find right sections
        for (Element productDataItemHeader : productDataItemHeaderElements) {
            String headerText = productDataItemHeader.text();
            if (headerText.equalsIgnoreCase("description")) {
//                when description is found get first line
                Element productText = productTextElements.get(counter);
                String firstLineOfDescription = productText.getElementsByTag("p").first().text();
                logger.debug("first line of description = {}", firstLineOfDescription);
                berry.setDescription(firstLineOfDescription);
            } else if (headerText.equalsIgnoreCase("nutrition")) {
//                find a row containing kcal
                Element productText = productTextElements.get(counter);
                Elements nutritionLevel1Elements = productText.getElementsByClass("nutritionLevel1");
                for (Element nutritionLevel1Element : nutritionLevel1Elements) {
                    String nutritionLevel = nutritionLevel1Element.text();
                    if (nutritionLevel.contains("kcal")) {
//                        clean up kcal value
                        String cleanKcal = nutritionLevel.replace("kcal", "");
                        int kcal = Integer.parseInt(cleanKcal);
                        logger.debug("kcal per 100g = {}", kcal);
                        berry.setKcal_per_100g(kcal);
                    }
                }
            }
            counter++;
        }
        return berry;
    }
}
