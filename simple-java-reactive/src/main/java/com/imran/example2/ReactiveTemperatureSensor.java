package com.imran;

import reactor.core.publisher.Flux;

public class ReactiveTemperatureSensor {
	
	
	public void myTempSensor() {
		
	    // Create a Flux (Observable) that emits temperature readings
	    Flux<Integer> temperatureFlux = Flux.create(emitter -> {
	        // Simulate changing temperature values
	        for (int i = 0; i < 10; i++) {
	            emitter.next(20 + i); // Emit temperature values from 20 to 29
	            try {
	                Thread.sleep(1000); // Wait for 1 second
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        emitter.complete(); // Complete the Flux when done
	    });

	    // Subscribe to the Flux and react to temperature changes
	    temperatureFlux.subscribe(
	        temperature -> System.out.println("Temperature is now: " + temperature),
	        error -> System.err.println("Error: " + error),
	        () -> System.out.println("Temperature monitoring complete")
	    );

	    // Keep the program running to observe the reactive behavior
	    try {
	        Thread.sleep(15000); // Wait for 15 seconds to observe multiple temperature changes
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    
		
	}


    
    
    
    
}