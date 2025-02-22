package org.dmdev.javareact;

import org.dmdev.javareact.publisher.PublisherImpl;
import org.dmdev.javareact.subscriber.SubscriberImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class JavaReactApplication {

    public static void main(String[] args) {
   //     SpringApplication.run(JavaReactApplication.class, args);

    }

    private static void demo1(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    private static void demo2(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
    }

    private static void demo3(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(24);
    }

}
