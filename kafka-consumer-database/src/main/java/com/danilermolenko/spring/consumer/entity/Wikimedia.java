package com.danilermolenko.spring.consumer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wikis")
@Getter
@Setter
@NoArgsConstructor
public class Wikimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "data", columnDefinition = "text")
    @Lob
    private String wikiEventData;

    public Wikimedia(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }
}
