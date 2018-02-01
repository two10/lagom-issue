package com.ameyo.ticketing.ticket.api.events;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Events pertaining to items.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = Void.class)
@JsonSubTypes({@JsonSubTypes.Type(TicketInfoEvent.TicketCreated.class)})
public abstract class TicketInfoEvent {

    private TicketInfoEvent() {
    }

    public abstract UUID getIinteractionId();

    /**
     * Indicates an interaction is created
     */
    @JsonTypeName(value = "interaction-created")
    public static final class TicketCreated extends TicketInfoEvent {
        UUID id;
        String reason;
        String message;

        public TicketCreated(UUID id, String reason, String message) {
            this.id = id;
            this.reason = reason;
            this.message = message;
        }

        @Override
        public UUID getIinteractionId() {
            // TODO Auto-generated method stub
            return id;
        }
    }
}
