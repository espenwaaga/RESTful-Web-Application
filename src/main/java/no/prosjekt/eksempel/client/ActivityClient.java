package no.prosjekt.eksempel.client;

import no.prosjekt.eksempel.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ActivityClient {

    private Client client;
    private String targetUrl = "http://localhost:8080/RESTful_Web_Application_war/webapi/";

    public ActivityClient () {
        client = ClientBuilder.newClient();
    }

    public Activity get(String id) {
        // http://localhost:8080/RESTful_Web_Application_war/webapi/
        WebTarget target = client.target(targetUrl);

        // Handle all return types:
        // Activity response = target.path("activities/" + id).request().get(Activity.class);
        // Handle only Json type:
        Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);

        if(response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }

        return response.readEntity(Activity.class);
    }

    public List<Activity> get() {
        WebTarget target = client.target(targetUrl);

        // Cannot get(list.class) because list is of type activity: List<Activity>
        // Needs to get a generic type of List<Activity> --> new GenericType<List<Activity>>() {}
        // "Wrap what I have as my response into this GenericType, and then it knows how to handle it."
        List<Activity> responses = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType< List<Activity> >() {});

        return responses;
    }

    public Activity create(Activity activity) {
        // http://localhost:8080/RESTful_Web_Application_war/webapi/activities/activity
        WebTarget target = client.target(targetUrl);

        Response response = target.path("activities/activity")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(activity, MediaType.APPLICATION_JSON));

        if(response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }

        return response.readEntity(Activity.class);
    }

    public Activity update(Activity activity) {
        WebTarget target = client.target(targetUrl);

        Response response = target.path("activities/" + activity.getActivityId())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(activity, MediaType.APPLICATION_JSON));

        if(response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }

        return response.readEntity(Activity.class);

    }

    public void delete(String activityId) {
        WebTarget target = client.target(targetUrl);

        Response response = target.path("activities/" + activityId)
                .request(MediaType.APPLICATION_JSON)
                .delete();

        if(response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }
    }

}
