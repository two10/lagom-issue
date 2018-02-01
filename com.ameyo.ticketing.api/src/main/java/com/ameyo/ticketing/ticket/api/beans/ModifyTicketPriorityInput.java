/**
 * Copyright (c) 2018 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: tuhin
 * Date:  Jan 10, 2018
 */
package com.ameyo.ticketing.ticket.api.beans;

import java.util.UUID;


import lombok.Value;

/**
 *
 */
@Value
public class ModifyTicketPriorityInput {

    private final UUID id;

    private final Priority priority;

}
