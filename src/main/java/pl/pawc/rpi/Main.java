package pl.pawc.rpi;

import java.util.Scanner;

/*import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;*/

import com.pi4j.wiringpi.SoftPwm;

public class Main{

    public static void main(String[] args) throws InterruptedException {

        //final GpioController gpio = GpioFactory.getInstance();
        //final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        //pin.setShutdownOptions(true, PinState.LOW);
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
        //gpio.shutdown();
    }
}