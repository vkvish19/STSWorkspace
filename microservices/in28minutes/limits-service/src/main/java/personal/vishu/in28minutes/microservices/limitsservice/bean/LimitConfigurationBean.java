package personal.vishu.in28minutes.microservices.limitsservice.bean;

public class LimitConfigurationBean
{
    private int maximum;
    private int minimum;

    protected LimitConfigurationBean() {}

    public LimitConfigurationBean(int maximum, int minimum)
    {
        super();
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }
}
