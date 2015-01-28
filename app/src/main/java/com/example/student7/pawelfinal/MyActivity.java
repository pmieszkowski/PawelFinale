package com.example.student7.pawelfinal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.student7.pawelfinal.data.User;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

@EActivity(R.layout.activity_my)
public class MyActivity extends ActionBarActivity {

    @Click(R.id.lista)
    void startClicked(){

        // startActivity(new Intent(this, lista_.class));
        lista_.intent(this).start();

    }
    @Click(R.id.dodaj)
    void DodajClicked(){

        zaloguj_.intent(this).user(user).start();
    }
    @Extra
    User user;
}
