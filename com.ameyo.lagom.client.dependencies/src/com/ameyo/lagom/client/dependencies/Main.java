/**
 * Copyright (c) 2018 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: puneetjindal
 * Date:  Jan 24, 2018
 */
package com.ameyo.lagom.client.dependencies;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import com.ameyo.ticketing.ticket.api.TicketingService;
import com.ameyo.ticketing.ticket.api.events.TicketEvent;
import com.lightbend.lagom.javadsl.api.broker.Topic;
import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;

import akka.Done;
import akka.stream.javadsl.Flow;

/**
 *
 */

public class Main {
    public static void main(String[] args) {

        LagomClientFactory clientFactory = LagomClientFactory.create("legacy-system", Main.class.getClassLoader());
        TicketingService ticketTingService = clientFactory.createClient(TicketingService.class,
                URI.create("http://localhost:11000"));

        Topic<TicketEvent> ticketEvents = ticketTingService.ticketEvents();

        ticketEvents.subscribe().withGroupId("nya13").atLeastOnce(Flow.<TicketEvent> create().mapAsync(1, e -> {
            System.out.println("kuch to aaya");
            return CompletableFuture.completedFuture(Done.getInstance());
        }));
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e1) {
            // TODO: puneetjindal. Write exception handling code
            //    logger.error(e1);
        }
    }
}
