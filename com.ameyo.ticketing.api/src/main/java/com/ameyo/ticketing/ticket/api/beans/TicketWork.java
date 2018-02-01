/**
 * Copyright (c) 2018 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: puneetjindal
 * Date:  Jan 9, 2018
 */
package com.ameyo.ticketing.ticket.api.beans;

import java.util.Date;

import lombok.Value;

/**
 *
 */
@Value
public final  class TicketWork {
    
    private final String userId;
    private final Date assignedDate;

}
