package com.ameyo.ticketing.ticket.api.beans;

import java.util.UUID;

import com.ameyo.ticketing.campaign.api.beans.CampaignInfo;
import com.ameyo.ticketing.campaign.api.beans.QueueInfo;

import lombok.Value;

@Value
public final class Ticket {
	private final UUID id;
	
	
	private final Status status;
	
	private final Priority priority;
	
	private final CampaignInfo campaign;
	
	private final QueueInfo queue;
    
	private final TicketInfo ticketInfo;
	
	private final TicketWork ticketWork;
	
}
