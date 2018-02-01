package com.ameyo.ticketing.ticket.api.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Events pertaining to items.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = Void.class)
@JsonSubTypes({@JsonSubTypes.Type(TicketEvent.TicketClosed.class)})
public abstract class TicketEvent {

    private TicketEvent() {
    }

    /**
     * Indicates an interaction is created
     */
    @JsonTypeName(value = "interaction-closed")
    public static final class TicketClosed extends TicketEvent {

    }

}
