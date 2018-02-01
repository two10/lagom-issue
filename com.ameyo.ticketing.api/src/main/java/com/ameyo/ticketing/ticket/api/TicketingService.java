package com.ameyo.ticketing.ticket.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.topic;

import java.util.UUID;

import com.ameyo.common.api.PaginatedSequence;
import com.ameyo.ticketing.ticket.api.beans.GetAllTicketsForGivenSource;
import com.ameyo.ticketing.ticket.api.beans.ModifyTicketPriorityInput;
import com.ameyo.ticketing.ticket.api.beans.Ticket;
import com.ameyo.ticketing.ticket.api.beans.TicketCreation;
import com.ameyo.ticketing.ticket.api.beans.TicketView;
import com.ameyo.ticketing.ticket.api.events.TicketEvent;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;
import com.lightbend.lagom.javadsl.api.deser.PathParamSerializers;

import akka.Done;
import akka.NotUsed;

public interface TicketingService extends Service {

    ServiceCall<TicketCreation, Ticket> createTicket();

    ServiceCall<ModifyTicketPriorityInput, Done> modifyTicketPriority();

    ServiceCall<NotUsed, Done> closeTicket(String id);

    ServiceCall<NotUsed, Ticket> getTicket(UUID id);

    ServiceCall<GetAllTicketsForGivenSource, PaginatedSequence<TicketView>> getTicketsForGivenSource();

    String TOPIC_ID = "second_topic";

    Topic<TicketEvent> ticketEvents();

    @Override
    default Descriptor descriptor() {
        return named("ticketing").withCalls(pathCall("/api/ticket", this::createTicket))
                .withCalls(pathCall("/api/ticket/:id", this::getTicket))
                .withCalls(pathCall("/api/ticket/close/:id", this::closeTicket))
                .withCalls(pathCall("/api/ticketsearch/", this::getTicketsForGivenSource))
                .withTopics(topic(TOPIC_ID, this::ticketEvents)).withPathParamSerializer(UUID.class,
                        PathParamSerializers.required("UUID", UUID::fromString, UUID::toString))
                .withAutoAcl(true);
    }

}
