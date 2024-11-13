package comm.example.demo2.Search;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.SearchRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.meilisearch.sdk.model.SearchResult;
import com.meilisearch.sdk.model.Searchable;


@RestController
@RequestMapping("/search")
public class SearchController {
    private final Client meiliSearchClient;

    @Autowired
    public SearchController(Client meiliSearchClient) {
        this.meiliSearchClient = meiliSearchClient;
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<List<Map<String, Object>>> searchUsersByUsername(@PathVariable String username) {
        try {
            String sanitizedUsername = username.replace("'", "''") + "~";

            String filter = "username = '" + sanitizedUsername + "'";

            SearchRequest searchRequest = new SearchRequest("").setFilter(new String[] {filter});
            Searchable result = meiliSearchClient.index("users").search(searchRequest);

            return ResponseEntity.status(200).body((List<Map<String, Object>>) (List<?>) result.getHits());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/users/twitchUsername/{twitchUsername}")
    public ResponseEntity<List<Map<String, Object>>> searchUsersByTwitchUsername(@PathVariable String twitchUsername) {
        try {
            String sanitizedUsername = twitchUsername.replace("'", "''") + "~";

            String filter = "twitchUsername = '" + sanitizedUsername + "'";

            SearchRequest searchRequest = new SearchRequest(sanitizedUsername).setFilter(new String[] {filter});
            Searchable result = meiliSearchClient.index("users").search(searchRequest);

            List<Map<String, Object>> hitsList = (List<Map<String, Object>>) (List<?>) result.getHits();

            return ResponseEntity.status(200).body(hitsList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/recordedStreams/{recordedStreamTitle}")
    public ResponseEntity<List<Map<String, Object>>> searchRecordedStreamsByTitle(@PathVariable String recordedStreamTitle) {
        try {
            String sanitizedUsername = recordedStreamTitle.replace("'", "''") + "~";

            String filter = "recordedStreamTitle = '" + sanitizedUsername + "'";

            SearchRequest searchRequest = new SearchRequest(sanitizedUsername).setFilter(new String[] {filter});
            Searchable result = meiliSearchClient.index("recordedStreams").search(searchRequest);

            List<Map<String, Object>> hitsList = (List<Map<String, Object>>) (List<?>) result.getHits();

            return ResponseEntity.status(200).body(hitsList);            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/users")
    public ResponseEntity addUserEntry(@RequestBody Map<String, Object> reqBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String jsonDocument = objectMapper.writeValueAsString(reqBody);

            meiliSearchClient.index("users").addDocuments(jsonDocument);

            return ResponseEntity.status(201).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/recordedStreams")
    public ResponseEntity addRecordedStreamEntry(@RequestBody Map<String, Object> reqBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String jsonDocument = objectMapper.writeValueAsString(reqBody);

            meiliSearchClient.index("recordedStreams").addDocuments(jsonDocument);

            return ResponseEntity.status(201).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/users/{userEntryId}")
    public ResponseEntity deleteUserEntry(@RequestParam String userEntryId) {
        
    }

    @DeleteMapping("/recordedStreams/{recordedStreamsEntryId}")
    public ResponseEntity deleteRecordedStreamsEntry(@RequestParam String recordedStreamsEntryId) {
        
    }
}
