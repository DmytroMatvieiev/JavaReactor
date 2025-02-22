package org.dmdev.javareact.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class SubscriptionImpl implements Subscription {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private static final int MAX_ITEMS = 10;
    private Subscriber<? super String> subscriber;
    private boolean cancelled;
    private final Faker faker;
    private int count = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber){
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if(cancelled){
            return;
        }
        log.info("subscriber has requested {} items", requested);
        if(requested > MAX_ITEMS){
            this.subscriber.onError(new RuntimeException("Subscriber exceeds maximum allowed items"));
            return;
        }
        for (int i = 0; i < requested && count < MAX_ITEMS; i++){
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count == MAX_ITEMS){
            log.info("subscriber has reached the maximum number of requested items");
            this.subscriber.onComplete();
            this.cancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("Subscription cancelled");
        this.cancelled = true;
    }
}
