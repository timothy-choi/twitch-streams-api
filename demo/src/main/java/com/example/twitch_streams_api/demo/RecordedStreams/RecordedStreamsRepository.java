package com.example.twitch_streams_api.demo.RecordedStreams;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordedStreamsRepository extends JpaRepository<RecordedStreams, UUID> {
    public RecordedStreams findByRecordedStreamId(UUID recordedStreamId);

    public RecordedStreams findByTwitchStreamId(String twitchStreamId);

    public RecordedStreams findByStreamTitle(String title);
}
