package peccles.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Berry {
    private String title;
    @JsonInclude(Include.NON_NULL)
    private String kcal_per_100g;
    private double unit_price;
    private String description;

    public Berry() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKcal_per_100g() {
        return kcal_per_100g;
    }

    public void setKcal_per_100g(String kcal_per_100g) {
        this.kcal_per_100g = kcal_per_100g;
    }
}
