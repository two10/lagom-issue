/**
 * Copyright (c) 2018 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: puneetjindal
 * Date:  Jan 9, 2018
 */
package com.ameyo.ticketing.ticket.api.beans;

import lombok.Value;

/**
 *
 */
@Value
public final class TicketView {

    
    private final TicketWork ticketWork;
    private final String subject;
    private final Status status;
    
    private final Priority priority;
    
    
}
