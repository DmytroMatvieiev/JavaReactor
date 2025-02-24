package org.dmdev.javareact.common;

import org.dmdev.javareact.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;

public class Util {

    public static <T>Subscriber<T> subscriber(){
        return new SubscriberImpl<>("");
    }

    public static <T>Subscriber<T> subscriber(String name){
        return new SubscriberImpl<>(name);
    }
}
