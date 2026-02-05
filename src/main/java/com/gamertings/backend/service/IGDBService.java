package com.gamertings.backend.service;

import com.api.igdb.exceptions.RequestException;
import com.api.igdb.request.IGDBWrapper;
import com.api.igdb.utils.Endpoints;
import org.apache.coyote.Request;

import java.io.InputStream;
import java.util.Properties;


public class IGDBService {

    private static String resources = "twitchCredentials.properties";

    public IGDBService() {
        loadAndInitCredentials();
    }

    private void loadAndInitCredentials() {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try (InputStream input = loader.getResourceAsStream(resources)) {
            if(input == null) {
                throw new RuntimeException("Resource not found: " + resources);
            }
            properties.load(input);

            String clientId = properties.getProperty("client_id");
            String accessToken = properties.getProperty("access_token");

            if (clientId == null || accessToken == null) {
                throw new IllegalArgumentException("Credentials in " + input + " sind unvollständig! (client_id oder access_token fehlt)");
            }

            IGDBWrapper.INSTANCE.setCredentials(clientId, accessToken);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public String getGameByName(String gameName) {
        try {
            String query = "fields name, summary, cover.url; where name ~ \"" + gameName + "\";";
            return IGDBWrapper.INSTANCE.apiJsonRequest(Endpoints.GAMES, query);
        } catch( RequestException ex) {
            System.err.println("IGDB API Fehler: Status Code " + ex.getStatusCode());

            //response for frontend
            return "{\"error\": \"API nicht erreichbar\", \"details\": \"" + ex.getMessage() + "\"}";
        }

    }
}
