package no.prosjekt.eksempel.repository;

import no.prosjekt.eksempel.model.Activity;
import no.prosjekt.eksempel.model.User;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepositoryStub implements ActivityRepository {
    // A Stud means to stub out a database. This code just mimics a database. Hence the name, Stud

    @Override
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        activities.add(activity1);

        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(120);
        activities.add(activity2);

        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {
        if(activityId.equals("7777")){
            return null;
        }
        Activity activity1 = new Activity();
        activity1.setActivityId("1234");
        activity1.setDescription("Swimming");
        activity1.setDuration(55);

        User user = new User();
        user.setName("Espen");
        user.setId("10");
        activity1.setUser(user);

        return activity1;
    }

    @Override
    public void create(Activity activity) {
        // Should issue a insert statement to the "db"
    }

    @Override
    public Activity update(Activity activity) {
        // Search the database to see if we have an activity with that id already. Sudo sql code:
        // select * from Activity where id = ?
        // if rs size == 0
        // insert into Activity table
        // else
        // update the Activity
        return activity;
    }

    @Override
    public void delete(String activityId) {
        // delete from activity where activityId = ?
    }


}
