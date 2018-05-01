package peccles.objects;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<Berry> results = new ArrayList<>();
    private Double total = 0.0;

    public void add(Berry details) {
        results.add(details);
        total = total + details.getUnit_price();
    }

    public double getTotal() {
        return total;
    }

    public List<Berry> getResults() {
        return results;
    }
}
