import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        // Intro
        Scanner input = new Scanner(System.in);
        boolean gameRunning = true;
        System.out.println("Crypto Miner");
        System.out.println();
        System.out.println("Welcome To Crypto Miner! Your Goal Is To Make Bank By Breaking Into The Block Chain. \nYou Will Start Off With One-Hundred Dollars But You Must Make Your Choices Wisely.");
        
        // Pre-Established Objects
        PowerSupplier newSupplier = new PowerSupplier("Local Power Supplier");
        Library newLibrary = new Library("Local Library");
        Event event = new Event();
        Player newPlayer = new Player(100, 1);
        Power newPower = new Power("Power", 10, newPlayer.getDaysOfPower());
        Money newMoney = new Money("Money", 100);
        newPlayer.addResource(newMoney);
        newPlayer.addResource(newPower);
        
        System.out.println();
        
        // Infinite Loop Until User Quits
        while(gameRunning)
        {
            // Basic Menu
            System.out.println("Command Line - \n\t[0] View Progress\n\t[1] Visit Blueberry Center\n\t[2] Visit Your Local Power Supplier\n\t[3] Visit Local Library\n\t[4] Call End Of Day\n\t[5] Quit");
            System.out.println();
            int commandInput = 0;
            try {
                System.out.print("Enter Number - ");
                commandInput = input.nextInt();
                System.out.println(); 
            }
            catch (Exception ex) {
                System.out.println();
                System.out.println("Wrong Input!");
                System.out.println();
                input.nextLine();
                continue;
            }
            // Menu Conditions
            switch(commandInput)
            {
                case 0:
                    System.out.println(newPlayer);
                    System.out.println("Current Score - " + newMoney.scoreImpact());
                    sortedResources(newPlayer);
                    System.out.println();
                    break;
                // Blueberry Shop Menu
                case 1:
                    System.out.println("Blueberry Center -\n\t[0] Purchase Blueberry Pi \n\t[1] Return To Command Line");
                    System.out.println();
                    int berryInput = 0;
                    try
                    {
                        System.out.print("Enter Number - ");
                        berryInput = input.nextInt();
                        System.out.println();
                    }
                    catch (Exception ex) {
                        System.out.println();
                        System.out.println("Wrong Input!");
                        System.out.println();
                        input.nextLine();
                        continue;
                    }
                    // Conditions Deciding On Wether The Blueberry Pi Should Be Set To Shared Computing Power Or Personal Mining
                    switch (berryInput) {
                        case 0:
                            if(newPlayer.getBalance() >= 100)
                            {
                                System.out.println("Choose Option -\n\t[0] Set To Shared Computing [$100]\n\t[1] Set To Crypto Mining [$200]");
                                System.out.println();
                                int optionBlue = 0;
                                try {
                                    System.out.print("Enter Number - ");
                                    optionBlue = input.nextInt();
                                    System.out.println();
                                }
                                catch (Exception ex) {
                                    System.out.println();
                                    System.out.println("Wrong Input!");
                                    System.out.println();
                                    input.nextLine();
                                    continue;
                                }
                                // Completing Transactions
                                switch (optionBlue) {
                                    case 0:
                                        System.out.println("Blueberry Pi For Shared Computing Successfully Purchased!");
                                        newMoney.increaseScore();
                                        System.out.println();
                                        newPlayer.decreaseBalance(100);
                                        newMoney.decreasePrice(100);
                                        newPlayer.addGenerator(new BlueberryPi("BlueberryPi", true));
                                        break;
                                    case 1:
                                        if(newPlayer.getBalance() >= 200)
                                        {   
                                            System.out.println("Blueberry Pi For Crypto Mining Successfully Purchased!");
                                            newMoney.increaseScore();
                                            System.out.println();
                                            newPlayer.decreaseBalance(200);
                                            newMoney.decreasePrice(200);
                                            newPlayer.addGenerator(new BlueberryPi("BlueberryPi", false));
                                            break;
                                        }
                                        else {
                                            System.out.println("You Don't Have Enough Money!");
                                            System.out.println("You Still Need $" + (200 - newPlayer.getBalance()));
                                            System.out.println();
                                            break;
                                        }
                                    default:
                                        System.out.println("Wrong Input!");
                                        System.out.println();
                                        input.nextLine();
                                        continue;
                                }
                            }
                            else {
                                System.out.println("You Don't Have Enough Money!");
                                System.out.println("You Still Need $" + (100 - newPlayer.getBalance()));
                                System.out.println();
                                continue;
                            }
                            break;
                        case 1:
                            break;
                        default:
                            System.out.println("Wrong Input!");
                            System.out.println();
                            input.nextLine();
                            continue;
                    }
                    break;
                // Menu For The Power Supplier Shop
                case 2:
                    System.out.println(newSupplier.getName() + " -");
                    System.out.println("\tYour Current Power Available - ");
                    System.out.println("\t\t[0] Purchase One Day Worth Of Power [$10]");
                    System.out.println("\t\t[1] Purchase One Week Worth Of Power [$50]");
                    System.out.println("\t\t[2] Purchase One Month Worth Of Power [$100]");
                    System.out.println("\t\t[3] Return To Command Line");
                    System.out.println();
                    int powerInput = 0;
                    try {
                        System.out.print("Enter Number - ");
                        powerInput = input.nextInt();
                        System.out.println();
                    }
                    catch (Exception ex) {
                        System.out.println("Wrong Input!");
                        System.out.println();
                        input.nextInt();
                        continue;
                    }
                    // Conditions Checking For Users Balance And What They Are Going To Purchase
                    switch (powerInput) {
                        case 0:
                            if(newPlayer.getBalance() >= 10)
                            {  
                                System.out.println("One Day Worth Of Power Has Been Purchased!");
                                newMoney.increaseScore();
                                newPlayer.decreaseBalance(10);
                                newMoney.decreasePrice(10);
                                newPlayer.addDaysOfPower(1);
                                newPower.addDaysOfPower(1);
                                System.out.println();
                                break;
                            }
                            else {
                                System.out.println("You Don't Have Enough Money!");
                                System.out.println("You Still Need $" + (10 - newPlayer.getBalance()));
                                System.out.println();
                                continue;
                            }   
                        case 1:
                            if(newPlayer.getBalance() >= 50)
                            {   
                                System.out.println("One Week Worth Of Power Has Been Purchased!");
                                newMoney.increaseScore();
                                newPlayer.decreaseBalance(50);
                                newMoney.decreasePrice(50);
                                newPlayer.addDaysOfPower(7);
                                newPower.addDaysOfPower(7);
                                System.out.println();
                                break;
                            }
                            else {
                                System.out.println("You Don't Have Enough Money!");
                                System.out.println("You Still Need $" + (50 - newPlayer.getBalance()));
                                System.out.println();
                                continue;
                            }
                        case 2:
                            if(newPlayer.getBalance() >= 100)
                            {   
                                System.out.println("One Month Worth Of Power Has Been Purchased!");
                                newMoney.increaseScore();
                                newPlayer.decreaseBalance(100);
                                newMoney.decreasePrice(100);
                                newPlayer.addDaysOfPower(28);
                                newPower.addDaysOfPower(28);
                                System.out.println();
                                break;
                            }
                            else {
                                System.out.println("You Don't Have Enough Money!");
                                System.out.println("You Still Need $" + (100 - newPlayer.getBalance()));
                                System.out.println();
                                continue;
                            }
                        case 3:
                            break;
                        default:
                            System.out.println("Wrong Input!");
                            System.out.println();
                            continue;
                    }
                    break;
                // Menu Section For Purchasing A Book From The Library Generator
                case 3:
                    System.out.println(newLibrary.getName() + " -\n\t[0] Purchase Dummi Book [$50]\n\t[1] Return To Command Line");
                    System.out.println();
                    int bookInput = 0;
                    try {
                        System.out.print("Enter Number - ");
                        bookInput = input.nextInt();
                        System.out.println();
                    }
                    catch (Exception ex) {
                        System.out.println();
                        System.out.println("Wrong Input!");
                        input.nextInt();
                        continue;
                    }
                    // Conditions Are Checking For Users Balance And What They Can Afford To Purchase
                    switch (bookInput) {
                        case 0:
                            if(newPlayer.getBalance() >= 50)
                            {    
                                System.out.println("Dummi Book Successfully Purchased!");
                                newMoney.increaseScore();
                                newPlayer.decreaseBalance(50);
                                newMoney.decreasePrice(50);
                                newPlayer.addResource(new DummiBook("Book", 50));
                                System.out.println();
                                break;
                            }
                            else {
                                System.out.println("You Don't Have Enough Money!");
                                System.out.println("You Still Need $" + (50 - newPlayer.getBalance()));
                                System.out.println();
                                continue;
                            }
                        case 1:
                            break;
                        default:
                            System.out.println("Wrong Input!");
                            System.out.println();
                            continue;
                    }
                    break;
                // User Has Called End Of Day Where They Get Paid And Random Events Could Happen
                case 4:
                    if(newPlayer.getDaysOfPower() > 0)
                    {    
                        System.out.println("You Have Called End Of Day!");
                        newMoney.increaseScore();
                        newPlayer.removeDaysOfPower();
                        newPower.removeDaysOfPower();
                        double money = event.totalMoneyEarned(newPlayer);
                        newMoney.increasePrice(money);
                        newPlayer.increaseBalance(money);
                        event.endOfDay(newPlayer, newMoney, newPower);
                        System.out.println();
                        break;
                    }
                    else {
                        System.out.println("You Currently Have 0 Days Of Power! You Must Buy More Or You Will Have To End The Game!");
                        System.out.println();
                        break;
                    }
                case 5:
                    gameRunning = false;
                    System.out.println("Score - " + newMoney.scoreImpact());
                    break;
                default:
                    System.out.println("Wrong Input!");
                    System.out.println();
                    continue;
            }
        } 

    }

    // Sorts The Resource Arrays From Least To Greatest In Price
    public static void sortedResources(Player newPlayer)
    {
        Collections.sort(newPlayer.getResources());
        System.out.println();
        System.out.println("Resources Have Been Automatically Sorted -");
        for(int i=0; i<newPlayer.getResources().size(); i++)
        {
            System.out.println("\t" + newPlayer.getResources().get(i));
        }
    }
}