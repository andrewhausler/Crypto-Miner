import java.util.*;

public abstract class Resource implements Score, Comparable<Resource>
{
    private String name;
    private static int score;
    private double price;
    
    public Resource(String name, double price)
    {
        this.name = name;
        this.price = price;
        score++;
    }

    // Returns Name
    public String getName()
    {
        return name;
    }

    // Sets Name
    public void setName(String name)
    {
        this.name = name;
    }

    // Returns Score
    public int scoreImpact()
    {
        return score;
    }

    // Increases Score
    public void increaseScore()
    {
        score += 1;
    }

    // Returns Price
    public double getPrice()
    {
        return price;
    }

    // Decreases Price
    public void decreasePrice(double price)
    {
        this.price -= price;
    }
    
    // Increases Price
    public void increasePrice(double price)
    {
        this.price += price;
    }

    // Sets Price
    public void setPrice(double price)
    {
        this.price = price;
    }

    // Overriding compareTo From Comparable Interface Comparing Resource Price
    public int compareTo(Resource object)
    {
        if(price > object.getPrice())
        {
            return 1;
        }
        else if (price < object.getPrice()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    // toString
    public String toString()
    {
        return "Resource - " + name + "/Price - " + price;
    }

}