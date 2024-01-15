public class Power extends Resource
{
    
    private int totalDaysOfPower;
    
    public Power(String name, double price, int totalDaysOfPower)
    {
        super(name, price);
        this.totalDaysOfPower = totalDaysOfPower;
    }

    // Sets Total Power
    public void setTotalDaysOfPower(int totalDaysOfPower)
    {
        this.totalDaysOfPower = totalDaysOfPower;
    }
    
    // Returns Total Power
    public int getTotalDaysOfPower()
    {
        return totalDaysOfPower;
    }
    
    // Adds Power
    public void addDaysOfPower(int totalDaysOfPower)
    {
        this.totalDaysOfPower += totalDaysOfPower;
    }

    // Removes A Fixed Amount Of Power
    public void removeDaysOfPower(int daysOfPower)
    {
        this.totalDaysOfPower -= daysOfPower;
    }
   
    // Removes Power
    public void removeDaysOfPower()
    {
        totalDaysOfPower -= 1;
    }

    @Override
    public String toString()
    {
        return super.toString() + "/Days - " + totalDaysOfPower;
    }
}