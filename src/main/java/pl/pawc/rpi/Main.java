package pl.pawc.rpi;

import java.util.Scanner;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Main{

    public static void main(String[] args) throws InterruptedException {

        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        pin.setShutdownOptions(true, PinState.LOW);

        Scanner sc = new Scanner(System.in);
        String input = "";
        while(!"quit".equals(input)){
        	input = sc.nextLine();
        	if("on".equals(input)) {
        		pin.high();
        		System.out.println("turning on...");
        	}
        	if("off".equals(input)){
        		pin.low();
        		System.out.println("turning off...");
        	}
        }
        System.out.println("Exiting...");
        sc.close();
        gpio.shutdown();
    }
}