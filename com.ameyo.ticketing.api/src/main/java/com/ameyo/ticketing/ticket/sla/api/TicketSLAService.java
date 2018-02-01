/**
 * Copyright (c) 2018 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: puneetjindal
 * Date:  Jan 9, 2018
 */
package com.ameyo.ticketing.ticket.sla.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import java.util.UUID;

import com.ameyo.ticketing.ticket.sla.api.bean.TicketSLA;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.deser.PathParamSerializers;

import akka.NotUsed;

/**
 *
 */
public interface TicketSLAService extends Service {

    ServiceCall<NotUsed, TicketSLA> getTicketSLA(UUID ticketId);

    @Override
    default Descriptor descriptor() {
        return named("ticketing-sla").withCalls(pathCall("/api/ticketsla/?ticketId", this::getTicketSLA))
                .withPathParamSerializer(UUID.class,
                        PathParamSerializers.required("UUID", UUID::fromString, UUID::toString));

    }

}
