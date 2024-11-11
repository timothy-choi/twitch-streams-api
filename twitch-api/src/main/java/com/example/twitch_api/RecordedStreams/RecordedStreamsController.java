package com.example.twitch_api.RecordedStreams;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RecordedStreamsController {
    @Autowired
    private RecordedStreamsRepository _recordedStreamsRepository;

    @GetMapping("/{recordedStreamId}")
    public ResponseEntity<RecordedStreams> getRecordedStreamsById(@PathVariable String recordedStreamId) {
        var streamId = UUID.fromString(recordedStreamId);

        RecordedStreams recordedStream = _recordedStreamsRepository.findByRecordedStreamId(streamId);

        if (recordedStream == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(recordedStream);
    }

    @GetMapping("/twitchStreamId/{twitchStreamId}")
    public ResponseEntity<RecordedStreams> getRecordedStreamsByTwitchStreamId(@PathVariable String twitchStreamId) {
        RecordedStreams recordedStream = _recordedStreamsRepository.findByTwitchStreamId(twitchStreamId);

        if (recordedStream == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(recordedStream);
    }

    @GetMapping("/streamTitle/{streamTitle}")
    public ResponseEntity<RecordedStreams> getRecordedStreamsByStreamTitle(@PathVariable String streamTitle) {
        RecordedStreams recordedStream = _recordedStreamsRepository.findByStreamTitle(streamTitle);

        if (recordedStream == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(recordedStream);
    }

    @PostMapping("/")
    public ResponseEntity<RecordedStreams> createRecordedStream(@RequestBody Map<String, Object> reqBody) {
        try {
            RecordedStreams recordedStream = _recordedStreamsRepository.findByTwitchStreamId(reqBody.get("twitchStreamId").toString());

            if (recordedStream != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            RecordedStreams videoStream = new RecordedStreams(reqBody.get("twitchStreamId").toString(), reqBody.get("title").toString(), reqBody.get("streamUrl").toString(), reqBody.get("hostUsername").toString(), Integer.parseInt(reqBody.get("viewCount").toString()), reqBody.get("game").toString(), Instant.parse(reqBody.get("timeStreamed").toString()), reqBody.get("thumbnailUrl").toString());

            _recordedStreamsRepository.save(videoStream);

            return ResponseEntity.status(HttpStatus.OK).body(videoStream);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/viewCount/{streamId}")
    public ResponseEntity updateViewCount(@PathVariable String streamId) {
        try {
            var sId = UUID.fromString(streamId);

            RecordedStreams recordedStream = _recordedStreamsRepository.findByRecordedStreamId(sId);

            if (recordedStream == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            Integer ct = (Integer) recordedStream.getViewCount();
            recordedStream.setViewCount((Number) (ct + 1));

            _recordedStreamsRepository.save(recordedStream);

            return ResponseEntity.status(HttpStatus.OK).body(null);
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{streamId}")
    public ResponseEntity deleteRecordedStream(@PathVariable String streamId) {
        try {
            var sId = UUID.fromString(streamId);

            RecordedStreams recordedStream = _recordedStreamsRepository.findByRecordedStreamId(sId);

            if (recordedStream == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            _recordedStreamsRepository.delete(recordedStream);

            return ResponseEntity.status(HttpStatus.OK).body(null);
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
