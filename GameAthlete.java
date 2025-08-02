import java.util.Random;
import java.util.Scanner;

class Athlete {
    String name;
    int energy;
    int skillPower;
    int maxEnergy;
    boolean isActive;
static int tot_athletes=0;

    Athlete() {
        name = "Player";
        energy = 100;
        skillPower = 10;
        maxEnergy = 1000;
        isActive = true;
    }

    Athlete(String n, int e, int s) {
        name = n;
        energy = e;
        skillPower = s;
        maxEnergy = 1000;
        isActive = true;
    }

    void compete(Athlete opponent) {
        if (opponent.isActive)
            opponent.energy -= skillPower;
        if (opponent.energy <= 0)
            opponent.isActive = false;
    }

    void rest(int amount) {
        energy += amount;
    }

    void train() {
        Random rand = new Random();
        skillPower += rand.nextInt(11);
    }

    void displayStats() {
        System.out.println("Name : " + name + "\nEnergy : " + energy + "\nSkill power : " + skillPower + "\nIs Active : " + isActive);
    }
}

public class Athlete_Arena {
    public static void main(String[] args) {
        System.out.println("NAME : TS BHUVANESHWAR\nROLL NO : 2024503565");

        String name;
        int energy, skillPower;
        Scanner sc = new Scanner(System.in);
        Athlete[] obj = new Athlete[3];

        for (int i = 0; i < 3; i++) {
            Athlete.tot_athletes++;
            System.out.println("Enter Name\nEnergy(200)\nSkill power(50) of player" + (i + 1) + " : ");
            name = sc.next();
            energy = sc.nextInt();
            skillPower = sc.nextInt();
            obj[i] = new Athlete(name, energy, skillPower);
        }

        System.out.println("Menu\nEnter 1 to compete\nEnter 2 to rest\nEnter 3 to train\nEnter 4 to Display Stats\nEnter 5 to exit");
        out:
        while (true) {
            if ((obj[0].isActive) && (!obj[1].isActive) && (!obj[2].isActive)) {
                System.out.println(obj[0].name + " won");
                break;
            }
            if ((obj[1].isActive) && (!obj[0].isActive) && (!obj[2].isActive)) {
                System.out.println(obj[1].name + " won");
                break;
            }
            if ((obj[2].isActive) && (!obj[0].isActive) && (!obj[1].isActive)) {
                System.out.println(obj[2].name + " won");
                break;
            }

            int c, a;
            for (int i = 0; i < 3; i++) {
                if (obj[i].energy <= 0) {
                    System.out.println(obj[i].name + " You ran out of energy\nYou lose ");
                    continue;
                }
                System.out.println(obj[i].name + " Enter your choice : ");
                c = sc.nextInt();

                if (c == 1) {
                    System.out.println("Enter the no of player to attack(0,1,2) : ");
                    a = sc.nextInt();
                    if (i != a && a < 3)
                        obj[i].compete(obj[a]);
                    else
                        System.out.println("Invalid option");
                } else if (c == 2) {
                    obj[i].rest(10);
                    System.out.println("Your current energy : " + obj[i].energy);
                } else if (c == 3) {
                    obj[i].train();
                    System.out.println("Your current skill power : " + obj[i].skillPower);
                } else if (c == 4) {
                    obj[i].displayStats();
                } else if (c == 5) {
                    break out;
                } else {
                    System.out.println("Invalid option");
                }
            }
        }
System.out.println("Number of athletes participated so far : "+Athlete.tot_athletes);
    }
}
