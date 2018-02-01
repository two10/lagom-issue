package com.ameyo.legacy.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.topic;

import com.ameyo.ticketing.ticket.api.beans.Ticket;
import com.ameyo.ticketing.ticket.api.beans.TicketCreation;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;

public interface LegacyAPIService extends Service {

    ServiceCall<TicketCreation, Ticket> createTicket();

    String TOPIC_ID = "DummyTopic";

    Topic<TestEvents> ticketEvents();

    @Override
    default Descriptor descriptor() {
        return named("ticketing").withCalls(pathCall("/api/ticket", this::createTicket))
                .withTopics(topic(TOPIC_ID, this::ticketEvents)).withAutoAcl(true);
    }

}
