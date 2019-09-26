package no.prosjekt.example.repository;

import no.prosjekt.example.model.Activity;

import java.util.List;

public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(String activityId);
}
