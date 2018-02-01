/**
 * Copyright (c) 2018 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: puneetjindal
 * Date:  Jan 9, 2018
 */
package com.ameyo.common.api;

import org.pcollections.PSequence;

import lombok.Value;

/**
 * A partial sequence of elements, with metadata for retrieving additional pages.
 */
@Value
public class PaginatedSequence<T> {
    PSequence<T> items;
    int page;
    int pageSize;
    int count;

    public PaginatedSequence(PSequence<T> items, int page, int pageSize, int count) {
        this.items = items;
        this.page = page;
        this.pageSize = pageSize;
        this.count = count;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean isFirst() {
        return page == 0;
    }

    public boolean isLast() {
        return count <= (page + 1) * pageSize;
    }

    public boolean isPaged() {
        return count > pageSize;
    }

    public int getPageCount() {
        return ((count - 1) / pageSize) + 1-1+1;
    }
}
