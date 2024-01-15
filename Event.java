import java.util.Random;

public class Event
{
    private Random random = new Random();
    
    public Event(){};

    // Picks A Random Number Through The Resource Array Creates Damage To That Resource
    public void endOfDay(Player newPlayer, Money newMoney, Power newPower)
    {
        int randomEvent = random.nextInt(1, 11);
        if(newPlayer.getTotalBlueberryPi() > 0 && randomEvent == 5 && newPlayer.getBalance() > 10)
        {
            System.out.println();
            System.out.println("Looks Like There Was A Crash In The Block Chain!");
            System.out.println("Some Of Your Resources Have Been Damaged - ");
            int randomIndex = random.nextInt(0, newPlayer.getResources().size());
            for(int i=randomIndex; i<newPlayer.getResources().size(); i++)
            {
                if(newPlayer.getResources().get(i) instanceof Money)
                {
                    Money otherMoney = (Money)newPlayer.getResources().get(i);
                    System.out.println("\t" + otherMoney.getName() + " Damaged!");
                    newMoney.decreasePrice((newMoney.getPrice()/2));
                    newPlayer.decreaseBalance((newPlayer.getBalance()/2));
                    break;
                }
                else if(newPlayer.getResources().get(i) instanceof Power)
                {
                    Power otherPower = (Power)newPlayer.getResources().get(i);
                    System.out.println("\t" + otherPower.getName() + " Damaged!");
                    newPower.removeDaysOfPower((newPower.getTotalDaysOfPower()/2));
                    newPlayer.removeDaysOfPower((newPlayer.getDaysOfPower()/2));
                    break;
                }
                else {
                    DummiBook otherBook = (DummiBook)newPlayer.getResources().get(i);
                    System.out.println("\t" + otherBook.getName() + " Damaged!");
                    newPlayer.getResources().remove(i);
                    break;
                }
                
            }
        }
    }

    // Gives The Player A Random Amount Of Money Earned For The Day Calculated By The Amount Of Resources And Generators
    public int totalMoneyEarned(Player newPlayer)
    {
        if(newPlayer.getTotalBlueberryPi() > 0)   
        {    
            int totalBooks = newPlayer.getTotalDummiBooks();
            int totalMining = newPlayer.getTotalMining();
            int totalPowerSupplier = newPlayer.getTotalPowerSuppliers();
            int randomMoneyAmount = random.nextInt(10, 11+((totalBooks*10)/2+(totalPowerSupplier * 2)/2+(totalMining*100)/2)/2);
            System.out.println("You Made A Total Of $" + randomMoneyAmount);
            return randomMoneyAmount;
        }
        else {
            return 0;
        }
    }
}