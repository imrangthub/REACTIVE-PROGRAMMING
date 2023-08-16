package com.imran;

import reactor.core.publisher.Flux;

public class SimpleExample {

    public static void main(String[] args) {
    	
    	
        // Simulate a stream of new posts being published
        Flux<String> socialMediaFeed = Flux.just(
            "Hello, world!",
            "Enjoying a sunny day.",
            "Exploring a new trail.",
            "Cooking a delicious meal."
        );

        
        
        // Subscribe to the feed and react to new posts
        socialMediaFeed.subscribe(
            post -> System.out.println("New post: " + post),
            error -> System.err.println("Error: " + error),
            () -> System.out.println("Social media feed monitoring complete")
        );
        
        
        
        
        
        
        
        
        
        
        
    }
}



