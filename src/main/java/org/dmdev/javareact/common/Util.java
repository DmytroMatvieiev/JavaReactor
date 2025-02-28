package org.dmdev.javareact.common;

import com.github.javafaker.Faker;
import org.dmdev.javareact.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;

import java.time.Duration;

public class Util {

    private static final Faker faker = new Faker();

    public static <T>Subscriber<T> subscriber(){
        return new SubscriberImpl<>("");
    }

    public static <T>Subscriber<T> subscriber(String name){
        return new SubscriberImpl<>(name);
    }

    public static Faker faker(){
        return faker;
    }

//    public static void sleepSeconds(int seconds){
//        try {
//            Thread.sleep(Duration.ofSeconds(seconds));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
