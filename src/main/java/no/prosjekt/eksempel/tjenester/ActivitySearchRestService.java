package no.prosjekt.eksempel.tjenester;

import no.prosjekt.eksempel.model.Activity;
import no.prosjekt.eksempel.repository.ActivityRepository;
import no.prosjekt.eksempel.repository.ActivityRepositoryStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("search/activities")
public class ActivitySearchRestService {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("method1")
    public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions) {
        System.out.println(descriptions);

        List<Activity> activities = activityRepository.findByDescription(descriptions);

        if(activities == null || activities.size() <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new GenericEntity< List<Activity> >(activities) {}).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("method2")
    public Response searchForActivitiesWithMultipleParams(@QueryParam(value = "description") List<String> descriptions,
                                                          @QueryParam(value = "durationFrom") int durationFrom,
                                                          @QueryParam(value = "durationTo") int durationTo) {

        System.out.println(descriptions + ", " + durationFrom + ", " + durationTo);

        List<Activity> activities = activityRepository.findByDescriptionDurationFromDurationTo(descriptions, durationFrom, durationTo);

        if(activities == null || activities.size() <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new GenericEntity< List<Activity> >(activities) {}).build();
    }

}
