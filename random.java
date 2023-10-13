import java.util.Random;
import java.util.Scanner;

public class random {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int rn,st,in;
        System.out.println("********************Random Number Game********************");
        System.out.println("Welcome to the Random Number Game!");
        System.out.println("Enter a number other than 0 to continue");
        st=s.nextInt();
        Random rand=new Random();
        rn=rand.nextInt(1000);
        while(st!=0){
            System.out.print("Enter your guess (between 0 and 999): ");
            in=s.nextInt();
            if(in>rn){
                System.out.println("Your guess is greater than the generated number.");
                System.out.println("To keep guessing the same number press 1 or to generate a new number press any other number");
                st=s.nextInt();
                    if(st==2){rn=rand.nextInt(1000);}
                    else{continue;}
                }
            else if(in<rn){
                System.out.println("Your guess is less than the generated number.");
                System.out.println("To keep guessing the same number press 1 or to generate a new number press any other number");
                st=s.nextInt();
                    if(st==2){rn=rand.nextInt(1000);}
                    else{continue;}
                }
            else{
                System.out.println("Your number is similar to the generated number");
                System.out.println("The number was "+rn);
                System.out.println("Do you want to continue");
            st=s.nextInt();
            if(st==0){
                System.out.println("Thanks for playing the Random Number Game!");
                break;
            }
            else{
                rn=rand.nextInt(1000);
                continue;
            }
            }
        }

        }
        
    }
