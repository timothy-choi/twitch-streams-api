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

    private String ThumbnailUrl;

    public RecordedStreams(String twitchStreamId, String title, String streamUrl, String hostUsername, Number viewCount, String game, Instant timeStreamed, String thumbnailUrl) {
        TwitchStreamId = twitchStreamId;
        StreamTitle = title;
        StreamUrl = streamUrl;
        StreamHostUsername = hostUsername;
        ViewCount = viewCount;
        VideoGame = game;
        TimeStreamed = timeStreamed;
        ThumbnailUrl = thumbnailUrl;
    }

    public UUID getRecordedStreamsId() {
        return this.RecordedStreamId;
    }

    public String getTwitchStreamId() {
        return this.TwitchStreamId;
    }

    public String getStreamTitle() {
        return this.StreamTitle;
    }

    public String getStreamUrl() {
        return this.StreamUrl;
    }

    public String getStreamHostUsername() {
        return this.StreamHostUsername;
    }

    public Number getViewCount() {
        return this.ViewCount;
    }

    public void setViewCount(Number viewCount) {
        this.ViewCount = viewCount;
    }

    public String getVideoGame() {
        return this.VideoGame;
    }

    public Instant getTimeStreamed() {
        return this.TimeStreamed;
    }

    public String getThumbnailUrl() {
        return this.ThumbnailUrl;
    }
}
