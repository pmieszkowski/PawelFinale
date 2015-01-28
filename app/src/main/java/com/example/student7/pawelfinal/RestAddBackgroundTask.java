package com.example.student7.pawelfinal;

import com.example.student7.pawelfinal.data.Recipe;
import com.example.student7.pawelfinal.data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;


@EBean
public class RestAddBackgroundTask {

    @RootContext
    AddRecipeActivity activity;

    @RestService
    RecipeRestClient restClient;

    @Background
    void add(User user, Recipe recipe) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            restClient.setHeader("X-Dreamfactory-Session-Token", user.sessionId);
            restClient.addRecipeList(recipe);
            publishResult();
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult() {
        activity.addSuccess();
    }
    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
