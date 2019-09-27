package no.prosjekt.eksempel.client;

import no.prosjekt.eksempel.model.Activity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ActivitySearchTest {

    @Test
    public void testSearch() {
        ActivitySearchClient client = new ActivitySearchClient();

        String param = "description";
        List<String> searchValues = new ArrayList<>();
        searchValues.add("Swimming");
        searchValues.add("Dancing");

        List<Activity> activities = client.search(param, searchValues);

        System.out.println(activities);

        assertNotNull(activities);
    }

    @Test
    public void testMultipleParamSearch() {
        ActivitySearchClient client = new ActivitySearchClient();

        String param = "description";
        List<String> searchValues = new ArrayList<>();
        searchValues.add("Swimming");
        searchValues.add("Dancing");

        String secondParam = "durationFrom";
        int durationFrom = 30;

        String thirdParam = "durationTo";
        int durationTo = 55;

        List<Activity> activities = client.searchThreeParams(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);

        System.out.println(activities);

        assertNotNull(activities);
    }

}
