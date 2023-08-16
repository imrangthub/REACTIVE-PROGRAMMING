package com.imranmadbar;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class SimpleReactiveService {

	Flux<Object> pushFlux = Flux.just("");

	public void pushData(String data) {

		// Create a Flux (Observable) that emits temperature readings
		pushFlux = Flux.create(emitter -> {
			emitter.next(data); // Emit temperature values from 20 to 29
			emitter.complete(); // Complete the Flux when done
		});

//		// Subscribe to the Flux and react to temperature changes
//		pushFlux.subscribe(pushObj -> {
//
//			System.out.println("consumer1:" + pushObj);
//
//		}, error -> System.err.println("Error: " + error), () -> System.out.println("consumer1Push complete"));
//
//		// Subscribe to the Flux and react to temperature changes
//		pushFlux.subscribe(pushObj -> {
//
//			System.out.println("consumer2:" + pushObj);
//
//		}, error -> System.err.println("Error: " + error), () -> System.out.println("consumer2Push complete"));

	}

	public void consumer1() {

		// Subscribe to the Flux and react to temperature changes
		pushFlux.subscribe(pushObj -> {

			System.out.println("consumer1:" + pushObj);

		}, error -> System.err.println("Error: " + error), () -> System.out.println("consumer1Push complete"));

	}

	public void consumer2() {
		
		pushFlux = Flux.create(emitter -> {
			emitter.next("Cunsumer2Data: A"); 
			emitter.next("Cunsumer2Data  B"); 
			emitter.complete(); // Complete the Flux when done
		});

		// Subscribe to the Flux and react to temperature changes
		pushFlux.subscribe(pushObj -> {

			System.out.println("consumer2:" + pushObj);

		}, error -> System.err.println("Error: " + error), () -> System.out.println("consumer2Push complete"));

	}

}
