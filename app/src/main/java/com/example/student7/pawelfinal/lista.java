package com.example.student7.pawelfinal;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;


import com.example.student7.pawelfinal.adapter.RecipeListAdapter;
import com.example.student7.pawelfinal.data.Recipe;
import com.example.student7.pawelfinal.data.RecipeList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_lista)
public class lista extends ActionBarActivity {

    @ViewById
    ListView lista;

    @Bean
    RecipeListAdapter adapter;

    @Bean
    @NonConfigurationInstance
    RestListaBackgroundTask restBackgroundTask;
    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {
        lista.setAdapter(adapter);

        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Ładowanie...");
        ringProgressDialog.setIndeterminate(true);
        ringProgressDialog.show();
        restBackgroundTask.getRecipeList();

    }

    public void updateRecipeList(RecipeList recipeList) {
        ringProgressDialog.dismiss();
        adapter.update(recipeList);
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
    @ItemClick
    void listaItemClicked(Recipe item) {
        RecipeActivity_.intent(this).recipe(item).start();
    }
}
