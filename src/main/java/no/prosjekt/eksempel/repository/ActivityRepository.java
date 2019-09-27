package no.prosjekt.eksempel.repository;

import no.prosjekt.eksempel.model.Activity;
import no.prosjekt.eksempel.model.ActivitySearch;

import java.util.List;

public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(String activityId);

    void create(Activity activity);

    Activity update(Activity activity);

    void delete(String activityId);

    List<Activity> findByDescription(List<String> descriptions);

    List<Activity> findByDescriptionDurationFromDurationTo(List<String> descriptions, int durationFrom, int durationTo);

    List<Activity> findByConstraints(ActivitySearch search);
}
