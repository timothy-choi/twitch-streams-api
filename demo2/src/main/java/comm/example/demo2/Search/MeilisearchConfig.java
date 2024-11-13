package comm.example.demo2.Search;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;

@Configuration
public class MeilisearchConfig {
    @Bean
    public Client meiliSearchClient() {
        String apiKey = System.getenv("MEILISEARCH_KEY");  
        String hostUrl = "http://127.0.0.1:7700";  
        return new Client(new Config(hostUrl, apiKey));
    }
}
