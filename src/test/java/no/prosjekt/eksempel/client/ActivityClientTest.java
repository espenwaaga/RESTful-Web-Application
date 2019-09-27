package no.prosjekt.eksempel.client;

import no.prosjekt.eksempel.model.Activity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ActivityClientTest {


    @Test
    public void testCreate() {
        ActivityClient client = new ActivityClient();

        Activity activity = new Activity();
        activity.setDescription("Swimming");
        activity.setDuration(60);

        activity = client.create(activity);

        assertNotNull(activity);
    }


    @Test
    public void testDelete() {

        ActivityClient client = new ActivityClient();
        client.delete("1234");
    }


    @Test
    public void testGet() {
        ActivityClient client = new ActivityClient();

        Activity activity = client.get("1234");

        System.out.println(activity);

        assertNotNull(activity);

    }


    @Test
    public void testGetList() {
        ActivityClient client = new ActivityClient();

        List<Activity> activities = client.get();

        System.out.println(activities);

        assertNotNull(activities);
    }


    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest() {
        ActivityClient client = new ActivityClient();

        client.get("123");
    }


    @Test(expected = RuntimeException.class)
    public void testGetWithNotFound() {
        ActivityClient client = new ActivityClient();

        client.get("7777");
    }


    @Test
    public void testPatch() {
        Activity activity = new Activity();
        activity.setActivityId("3456");
        activity.setDescription("Baseball");

        ActivityClient client = new ActivityClient();
        activity = client.update(activity);

        assertNotNull(activity);
    }


    @Test
    public void testPut() {
        Activity activity = new Activity();
        activity.setActivityId("3456");
        activity.setDescription("Yoga");
        activity.setDuration(90);

        ActivityClient client = new ActivityClient();
        activity = client.update(activity);

        assertNotNull(activity);
    }



}
