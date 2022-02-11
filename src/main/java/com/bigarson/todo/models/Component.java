package com.bigarson.todo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bigarson.todo.base.BaseEntity;

@Entity
public class Component extends BaseEntity {

    @Column
    private String description;
    @Column(columnDefinition = "boolean default false")
    private boolean state;
    @ManyToOne
    @JoinColumn(name = "eventlist_id")
    private EventList eventList;
}