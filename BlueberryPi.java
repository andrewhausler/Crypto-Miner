public class BlueberryPi extends Generator
{
    private boolean powerSupplier;

    public BlueberryPi(String name, boolean isSupplier)
    {
        super(name);
        this.powerSupplier = powerSupplier;
    }

    // Sets Wether It Should Be Used For Sharing Computer Power Or Personal Mining
    public void setPowerSupplier(boolean powerSupplier)
    {
        this.powerSupplier = powerSupplier;
    }

    // Getter
    public boolean getPowerSupplier()
    {
        return powerSupplier;
    }
}