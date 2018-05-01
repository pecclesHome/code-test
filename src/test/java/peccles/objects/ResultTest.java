package peccles.objects;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResultTest {

    @Test
    public void testResult() {
        Result result = new Result();
        result.add(new Berry("Berry 1", 100, 1.00, "Test berry 1 "));
        assertEquals(1.00, result.getTotal(), 0);
        result.add(new Berry("Berry 2", 200, 2.00, "Test berry 2 "));
        assertEquals(3.00, result.getTotal(), 0);
        result.add(new Berry("Berry 3", 300, 3.00, "Test berry 3 "));
        assertEquals(6.00, result.getTotal(), 0);

    }


}