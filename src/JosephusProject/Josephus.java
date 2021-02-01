package JosephusProject;

import java.util.Scanner;

/**
 *
 * @author taliayahav
 */
public class Josephus {

    public static void main(String[] args) {
        GCLL soldierList = new GCLL();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many soldiers are in your list?");
        int numSoldiers;
        while (true) {
            String input = keyboard.next();
            try {
                numSoldiers = Integer.parseInt(input); //"5"  "five"
                break;
            } catch (NumberFormatException ex)
            {
                System.out.println("Must enter an integer value. Please try again");
            }
        }
        for (int ix = 1; ix <= numSoldiers; ix++) {
            Soldier soldier = new Soldier("soldier" + ix);
            soldierList.add(soldier);
        }
        System.out.println(soldierList.toString());
        System.out.println("what number soldier in the list would you like to "
                + "have executed?");
        int countdown = keyboard.nextInt();
        for (int ix = 1; ix < numSoldiers; ix++) {
            soldierList.advance(countdown - 1);
            soldierList.remove(soldierList.getFirst());
            System.out.println(soldierList);
        }
        System.out.println("And the winner is... " + soldierList.getFirst().toString());
    }

    private static class Soldier {

        private String name;
        private int num;

        private Soldier(String soldierName) {
            name = soldierName;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
