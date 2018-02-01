package com.ameyo.legacy.api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Events pertaining to items.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = Void.class)
@JsonSubTypes({@JsonSubTypes.Type(TestEvents.TicketClosed.class)})
public abstract class TestEvents {

    private TestEvents() {
    }

    /**
     * Indicates an interaction is created
     */
    @JsonTypeName(value = "interaction-closed")
    public static final class TicketClosed extends TestEvents {

    }

}
