package pl.allegro.restapi.main.pojo.parameters;

public class Restrictions {

    private Integer min;
    private Integer max;
    private Boolean range;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Boolean getRange() {
        return range;
    }

    public void setRange(Boolean range) {
        this.range = range;
    }

}