package no.prosjekt.example.tjenester;

import no.prosjekt.example.model.Activity;
import no.prosjekt.example.model.User;
import no.prosjekt.example.repository.ActivityRepository;
import no.prosjekt.example.repository.ActivityRepositoryStub;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@Path("activities") // http://localhost:8080/RESTful-web-application/webapi/activities
public class ActivityRestService {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();


    // Pretty simple and straigtforward example of binding everything to an object rather than the post underneath.
    @POST
    @Path("activity")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {

        System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());

        activityRepository.create(activity);

        return activity;
    }

    @POST
    @Path("activity")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParamsString(MultivaluedMap<String,String> formParams) {

        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));

        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));

        activityRepository.create(activity);

        return activity;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivities();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}") // http://localhost:8080/RESTful-web-application/webapi/activities/{activityId}
    public Activity getActivity(@PathParam("activityId") String activityId) {
        return activityRepository.findActivity(activityId);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}/user") // http://localhost:8080/RESTful-web-application/webapi/activities/{activityId}/user
    public User getActivityUser(@PathParam("activityId") String activityId) {
        return activityRepository.findActivity(activityId).getUser();
    }







}
