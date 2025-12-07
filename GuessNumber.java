//Program to create a random number generating game by giving clues to the user
import java.util.*;
class Game implements Runnable
{
 public void run()
 {
     Random rand = new Random();
     int m,t=1;
     Scanner sc = new Scanner(System.in);
     boolean run = true;
     while(run){
         int n = rand.nextInt(101);
         System.out.println("You have 10 chances");
         long start = System.currentTimeMillis();
         for(int i=0;i<10;i++)
         {
             System.out.print("Guess the number (0-100) : ");
             m = sc.nextInt();
             if(n==m)
             {
                 long end = System.currentTimeMillis();
                 System.out.println("Your Guess is correct\nTime Consumed : "+(end - start)/1000 + "secs ");
                 break;
             }
             else if(m-10>n)
                 System.out.println("Your Guess value is too high");

             else if(m+10<n)
                 System.out.println("Your Guess value is too low");
             else if(m>n)
                 System.out.println("Your Guess value is little high");
             else
                 System.out.println("Your Guess value is little low");
             System.out.println("You have "+(9-i)+" Chances left");
         }
         System.out.print("The answer is : "+n+"\nEnter 1 to start over or 0 to stop : ");
         t = sc.nextInt();
         if(t!=1)
             run = false;
     }
 }
}
public class GuessNumber {
    public static void main(String[] args)
    {
       Game g=new Game();
       Thread t1=new Thread(g);
       t1.start();
    }
}
//COMPLETED
