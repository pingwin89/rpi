package pl.pawc.rpi;

import java.util.Scanner;

import com.pi4j.wiringpi.SoftPwm;
import com.pi4j.wiringpi.Gpio;

public class Main{

    public static void main(String[] args) throws InterruptedException {

    	Gpio.wiringPiSetup();
        System.out.println("Create softPWM on pin 1");
        SoftPwm.softPwmCreate(1, 0, 100);

        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(input!=-1){
        	input = sc.nextInt();
        	SoftPwm.softPwmWrite(1, input);
        	System.out.println("Set value "+input);
        }
        System.out.println("Exiting...");
        sc.close();
        SoftPwm.softPwmStop(1);
    }
}