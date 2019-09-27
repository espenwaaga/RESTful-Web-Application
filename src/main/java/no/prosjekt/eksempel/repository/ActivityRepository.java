package no.prosjekt.eksempel.repository;

import no.prosjekt.eksempel.model.Activity;

import java.util.List;

public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(String activityId);

    void create(Activity activity);
}
