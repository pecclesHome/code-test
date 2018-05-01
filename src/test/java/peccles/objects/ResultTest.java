package peccles.objects;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ResultTest {

    @Test
    public void testResult() {
        Result result = new Result();
        result.add(new Berry("Berry 1", 100, 1.00, "Test berry 1 "));
        assertEquals(new BigDecimal(1.00).setScale(2, BigDecimal.ROUND_HALF_UP), result.getTotal());
        result.add(new Berry("Berry 2", 200, 2.00, "Test berry 2 "));
        assertEquals(new BigDecimal(3.00).setScale(2, BigDecimal.ROUND_HALF_UP), result.getTotal());
        result.add(new Berry("Berry 3", 300, 3.00, "Test berry 3 "));
        assertEquals(new BigDecimal(6.00).setScale(2, BigDecimal.ROUND_HALF_UP), result.getTotal());

    }


}