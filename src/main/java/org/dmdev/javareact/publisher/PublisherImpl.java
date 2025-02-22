package org.dmdev.javareact.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class PublisherImpl implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {

        subscriber.onSubscribe(new SubscriptionImpl(subscriber) {});
    }
}
