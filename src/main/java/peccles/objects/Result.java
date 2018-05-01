package peccles.objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<Berry> results = new ArrayList<>();
    private Double total = 0.0;

    public void add(Berry details) {
        results.add(details);
        total = total + details.getUnit_price();
    }

//    public double getDoubleTotal() {
//        return total;
//    }

    public BigDecimal getTotal() {
        BigDecimal BigDTotal = new BigDecimal(total);
        return BigDTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public List<Berry> getResults() {
        return results;
    }
}
