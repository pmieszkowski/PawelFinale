package com.example.student7.pawelfinal;

import android.widget.Toast;

import com.example.student7.pawelfinal.data.EmailAndPassword;
import com.example.student7.pawelfinal.data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;


@EBean
public class RestLoginBackgroundTask {

    @RootContext
    zaloguj activity;

    @RestService
    RecipeRestClient restClient;

    @Background
    void login(EmailAndPassword emailAndPassword) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            User user = restClient.login(emailAndPassword);
            publishResult(user);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(User user) {
        activity.loginSuccess(user);
    }

    @UiThread
    void publishError(Exception e) {

    }

}
