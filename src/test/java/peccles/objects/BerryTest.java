package peccles.objects;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerryTest {
    String testTitle = "This is a test Title";
    double testPrice = 1.23;
    String testDescription = "This is a test Description";
    int testKcal = 22;

    @Test
    public void testConstructor() {
        Berry berry = new Berry(testTitle, testKcal, testPrice, testDescription);
        assertEquals(testTitle, berry.getTitle());
        assertEquals(testPrice, berry.getUnit_price(), 0);
        assertEquals(testDescription, berry.getDescription());
        assertEquals(testKcal, berry.getKcal_per_100g());
    }

    @Test
    public void testTitle() {
        Berry berry = new Berry();
        berry.setTitle(testTitle);
        String retrievedTitle = berry.getTitle();
        assertEquals(testTitle, retrievedTitle);
    }

    @Test
    public void testUnit_price() {
        Berry berry = new Berry();
        berry.setUnit_price(testPrice);
        double result = berry.getUnit_price();
        assertEquals(testPrice, result, 0);
    }

    @Test
    public void testDescription() {
        Berry berry = new Berry();

        berry.setDescription(testDescription);
        String retrievedTitle = berry.getDescription();
        assertEquals(testDescription, retrievedTitle);
    }

    @Test
    public void testKcal_per_100g() {
        Berry berry = new Berry();

        berry.setKcal_per_100g(testKcal);
        int result = berry.getKcal_per_100g();
        assertEquals(testKcal, result);
    }
}