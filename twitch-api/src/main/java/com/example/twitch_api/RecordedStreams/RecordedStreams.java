package com.example.twitch_api.RecordedStreams;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RecordedStreams")
public class RecordedStreams {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID RecordedStreamId;

    private String TwitchStreamId;

    private String StreamTitle;

    private String StreamUrl;

    private String StreamHostUsername;

    private Number ViewCount;

    private String VideoGame;

    private Instant TimeStreamed;
}
