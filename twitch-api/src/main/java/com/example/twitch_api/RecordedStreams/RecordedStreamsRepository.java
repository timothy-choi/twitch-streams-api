package com.example.twitch_api.RecordedStreams;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordedStreamsRepository extends JpaRepository<RecordedStreams, UUID> {
    public RecordedStreams findByRecordedStreamId(UUID recordedStreamId);

    public RecordedStreams findByTwitchStreamId(String twitchStreamId);

    public RecordedStreams findByStreamTitle(String title);
}
