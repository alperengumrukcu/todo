package com.bigarson.todo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.bigarson.todo.base.BaseEntity;

@Entity
public class EventList extends BaseEntity {

    @Column
    private String description;
    @Column
    private String eventName;
    @OneToMany(mappedBy = "eventList")
    private List<Component> components;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
