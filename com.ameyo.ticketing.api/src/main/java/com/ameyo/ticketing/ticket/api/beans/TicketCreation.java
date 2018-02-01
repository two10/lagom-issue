package com.ameyo.ticketing.ticket.api.beans;

import lombok.Value;

@Value
public final class TicketCreation {

	private final String reason;
	private final String message;
}
