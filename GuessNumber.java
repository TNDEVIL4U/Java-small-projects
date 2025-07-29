import java.util.Scanner;
import java.util.Random;
public class GuessingGame {
public static void main(String[] args)
{
Random rand = new Random();
int m,t=1;
Scanner sc = new Scanner(System.in);
boolean run = true;
while(run){
System.out.println("You have 10 chances");
for(int i=0;i<10;i++)
{
int n = rand.nextInt(101);
System.out.print("Guess the number(0-100) : ");
m = sc.nextInt();
if(n==m)
{
    System.out.println("Your Guess is correct");
    break;
}
else if(m-10>n)
    System.out.println("Your Guess is too high");

else if(m+10<n) 
    System.out.println("Your Guess is too low");
else if(m>n)
    System.out.println("Your Guess is little high");
else
    System.out.println("Your Guess is little low");
System.out.println("You have "+(9-i)+" Chances left");
    }
System.out.print("Enter 1 to start over or 0 to stop : ");
t = sc.nextInt();
if(t!=1)
 run = false;
}
sc.close();
}
}
