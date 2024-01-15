public abstract class Generator implements Score
{
    private String name;
    private static int score;
    
    public Generator(String name)
    {
        this.name = name;
        score++;
    }

    public String getName()
    {
        return name;
    }

    public int scoreImpact()
    {
        return score;
    }
}