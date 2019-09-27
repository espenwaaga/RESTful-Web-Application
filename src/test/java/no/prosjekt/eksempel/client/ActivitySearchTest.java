package no.prosjekt.eksempel.client;

import no.prosjekt.eksempel.model.Activity;
import no.prosjekt.eksempel.model.ActivitySearch;
import no.prosjekt.eksempel.model.ActivitySearchType;
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


    @Test
    public void testSearchObject() {
        ActivitySearchClient client = new ActivitySearchClient();

        List<String> searchValues = new ArrayList<>();
        searchValues.add("Biking");
        searchValues.add("Running");

        ActivitySearch search = new ActivitySearch();
        search.setDescriptions(searchValues);
        search.setDurationFrom(30);
        search.setDurationTo(55);
        search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);

        List<Activity> activities = client.search(search);

        System.out.println(activities);

        assertNotNull(activities);
    }

}
