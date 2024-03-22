import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class VacationPlanner {
    private Scanner scanner;
    private int numOfDays;
    private ArrayList<String> mainAttraction;
    private ArrayList<String> sideQuest;
    private ArrayList<String> dinerList;
    private ArrayList<String> supperList;

    public VacationPlanner() {
        scanner = new Scanner(System.in);
    }

    public void planVacation() {
        numOfDays = getNumberOfDays();
        mainAttraction = selectItems("Main attraction");
        sideQuest = selectItems("Side quest");
        dinerList = selectItems("Restaurant for diner");
        supperList = selectItems("Restaurant for supper");

        displaySelectedItinerary();
        scanner.close();
    }

    private int getNumberOfDays() {
        System.out.print("Please select how many days you will be planning for: ");
        int days = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return days;
    }

    private ArrayList<String> selectItems(String itemName) {
        System.out.println("Please select " + itemName + " for " + numOfDays + " days:");

        ArrayList<String> itemList = new ArrayList<>();

        for (int i = 0; i < numOfDays; i++) {
            System.out.println("Day " + (i + 1) + ":");
            String userInput = scanner.nextLine(); // Read a full line of input
            itemList.add(userInput);
        }

        return itemList;
    }

    private String randomizeAndRemoveItems(ArrayList<String> itemList) {
        Random random = new Random();

        while (!itemList.isEmpty()) {
            int randomIndex = random.nextInt(itemList.size());
            return itemList.remove(randomIndex);
        }

        return null;
    }

    private void displaySelectedItinerary() {
        System.out.println("Selected Itinerary:");

        for (int i = 0; i < numOfDays; i++) {
            System.out.println("Day " + (i + 1) + ":");
            System.out.println("Main Attraction: " + randomizeAndRemoveItems(mainAttraction));
            System.out.println("Side Quest: " + randomizeAndRemoveItems(sideQuest));
            System.out.println("Diner Restaurant: " + randomizeAndRemoveItems(dinerList));
            System.out.println("Super Restaurant: " + randomizeAndRemoveItems(supperList));
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VacationPlanner vacationPlanner = new VacationPlanner();
        vacationPlanner.planVacation();
    }
}

