import java.util.ArrayList;

public class Player
{
    private double balance;
    private int daysOfPower;
    private ArrayList<Resource> resources = new ArrayList<Resource>();
    private ArrayList<Generator> generators = new ArrayList<Generator>();
    
    public Player(double balance, int daysOfPower) 
    {
        this.balance = balance;
        this.daysOfPower = daysOfPower;
    }

    // Gets The Resource Array
    public ArrayList<Resource> getResources()
    {
        return resources;
    }

    // Adds A New Resource
    public void addResource(Resource resource)
    {
        resources.add(resource);
    }

    // Get Generator Array
    public ArrayList<Generator> getGenerators()
    {
        return generators;
    }

    // Add Object To Generator Array
    public void addGenerator(Generator generator)
    {
        generators.add(generator);
    }
    
    // Looks In The Generator Array For The Total Blueberry Pis
    public int getTotalBlueberryPi()
    {
        if(generators != null)    
        {    
            int count = 0;
            for(int i=0; i<generators.size(); i++)
            {
                if(generators.get(i) instanceof BlueberryPi)
                {
                    count++;
                }
                continue;
            }
            return count;
        }
        else {
            return 0;
        }
    }

    // Looks For The Total Of Books Inside Of The Resource Array
    public int getTotalDummiBooks()
    {
        if(resources != null)
        {   
            int count = 0;
            for(int i=0; i<resources.size(); i++)
            {
                if(resources.get(i) instanceof DummiBook)
                {
                    count++;
                }
                continue;
            }
            return count;
        }
        else {
            return 0;
        }
    }

    // Looks For Total Amount Power Suppliers Inside Of Generators Array
    public int getTotalPowerSuppliers()
    {
        if(generators != null)    
        {    
            int count = 0;
            for(int i=0; i<generators.size(); i++)
            {
                if(generators.get(i) instanceof BlueberryPi)
                {   
                    BlueberryPi newBlue = (BlueberryPi)generators.get(i);
                    if(newBlue.getPowerSupplier() == true)
                    {   
                        count++;
                        continue;
                    }
                }
            }
            return count;
        }
        else {
            return 0;
        }
    }

    // Gets Total Amount Of Personal Mining Inside Of Generators Array
    public int getTotalMining()
    {
        if(generators != null)    
        {    
            int count = 0;
            for(int i=0; i<generators.size(); i++)
            {
                if(generators.get(i) instanceof BlueberryPi)
                {   
                    BlueberryPi newBlue = (BlueberryPi)generators.get(i);
                    if(newBlue.getPowerSupplier() == false)
                    {   
                        count++;
                        continue;
                    }
                }
            }
            return count;
        }
        else {
            return 0;
        }
    }

    // Returns Balance
    public double getBalance()
    {
        return balance;
    }

    // Sets Balance
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    // Decreases Balance
    public void decreaseBalance(double balance)
    {
        this.balance -= balance;
    }

    // Increases Balance
    public void increaseBalance(double balance)
    {
        this.balance += balance;
    }

    // Gets Amount Of Power
    public int getDaysOfPower()
    {
        return daysOfPower;
    }

    // Adds More Power
    public void addDaysOfPower(int daysOfPower)
    {
        this.daysOfPower += daysOfPower;
    }

    // Removes Power By A Set Amount
    public void removeDaysOfPower(int daysOfPower)
    {
        this.daysOfPower -= daysOfPower;
    }

    // Removes Power By 1
    public void removeDaysOfPower()
    {
        daysOfPower -= 1;
    }

    // Sets Days Of Power
    public void setDaysOfPower(int daysOfPower)
    {
        this.daysOfPower = daysOfPower;
    }
    
    // toString
    public String toString()
    {
        return "Total Balance - " + getBalance() + "\nTotal Power - " + daysOfPower + "/Days\nTotal Blueberry Pi - " + getTotalBlueberryPi() + "\nTotal Dummi Books - " + getTotalDummiBooks();
    }
}