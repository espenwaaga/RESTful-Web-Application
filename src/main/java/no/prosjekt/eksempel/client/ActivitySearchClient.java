package no.prosjekt.eksempel.client;

import no.prosjekt.eksempel.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

public class ActivitySearchClient {

    private Client client;
    private String targetUrl = "http://localhost:8080/RESTful_Web_Application_war/webapi/";

    public ActivitySearchClient() {
        client = ClientBuilder.newClient();
    }

    public List<Activity> search(String param, List<String> searchValues) {

        URI uri = UriBuilder.fromUri(targetUrl)
                .path("search/activities")
                .queryParam(param, searchValues)
                .build();

        WebTarget target = client.target(uri);

        List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType< List<Activity> >() {});

        System.out.println(response);

        return response;
    }
}