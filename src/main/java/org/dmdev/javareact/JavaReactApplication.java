package org.dmdev.javareact;

import org.dmdev.javareact.common.Util;
import org.dmdev.javareact.publisher.PublisherImpl;
import org.dmdev.javareact.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

//@SpringBootApplication
public class JavaReactApplication {

    private static final Logger log = LoggerFactory.getLogger(JavaReactApplication.class);

    public static void main(String[] args) {

        getUsername(5)
                .subscribe(Util.subscriber());

   //     SpringApplication.run(JavaReactApplication.class, args);

//        var mono = Mono.just(1)
//                .map(i -> i / 0);
        //var subscriber = new SubscriberImpl();

        //mono.subscribe(subscriber);
        //subscriber.getSubscription().request(3);

//        mono.subscribe(
//                i -> log.info("received: {}", i),
//                err -> log.error("error", err),
//                () -> log.info("done"),
//                subscription -> subscription.request(1)
//        );
    }

    private static Mono<String> getUsername(int userId){
        return switch (userId){
            case 1 -> Mono.just("admin");
            case 2 -> Mono.just("user");
            case 3 -> Mono.empty(); // null
            default -> Mono.error(new RuntimeException("Invalid user id"));
        };
    }


}
