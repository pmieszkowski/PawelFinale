package com.example.student7.pawelfinal;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.student7.pawelfinal.data.Recipe;
import com.example.student7.pawelfinal.data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.add_recipe_activity)

public class AddRecipeActivity extends ActionBarActivity {


    @ViewById
    EditText title;

    @ViewById
    EditText introduction;

    @ViewById
    EditText steps;

    @ViewById
    EditText ingredients;

    @ViewById
    EditText CookingMinutes;

    @ViewById
    EditText PreparationMinutes;

    @ViewById
    EditText servings;

    @Bean
    @NonConfigurationInstance
    RestAddBackgroundTask restAddBackgroundTask;
    ProgressDialog ringProgressDialog;

    @Extra
    User user;
    @AfterViews
    void init () {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Trwa dodawanie przepisu...");
        ringProgressDialog.setIndeterminate(true);
    }
    public void addSuccess() {
        ringProgressDialog.dismiss();
        Toast.makeText(this, "Dodano przepis", Toast.LENGTH_LONG).show();
        //AddRecipeActivity_.intent(this).user(user).start();
        MyActivity_.intent(this).user(user).start();
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
    @Click(R.id.addButton)
    void addClicked(){
        if (title.getText().toString().trim().length()==0) {
            Toast.makeText(this, "Pole wymagane: Tytuł", Toast.LENGTH_LONG).show();
            return;
        }
        if (ingredients.getText().toString().trim().length()==0) {
            Toast.makeText(this, "Pole wymagane: Składniki", Toast.LENGTH_LONG).show();
            return;
        }
        if (steps.getText().toString().trim().length()==0) {
            Toast.makeText(this, "Pole wymagane: Kroki", Toast.LENGTH_LONG).show();
            return;

        }
        if (servings.getText().toString().trim().length()==0) {
            Toast.makeText(this, "Pole wymagane: Porcje", Toast.LENGTH_LONG).show();
            return;
        }
        Recipe recipe = new Recipe();
        recipe.title = title.getText().toString();
        recipe.introduction = introduction.getText().toString();
        recipe.ingredients = ingredients.getText().toString();
        recipe.steps = steps.getText().toString();
        if (CookingMinutes.getText().toString().trim().length()>0) recipe.cookingMinutes = Integer.parseInt(CookingMinutes.getText().toString());
        if (PreparationMinutes.getText().toString().trim().length()>0) recipe.preparationMinutes = Integer.parseInt(PreparationMinutes.getText().toString());
        if (servings.getText().toString().trim().length()>0) recipe.servings = Integer.parseInt((servings.getText().toString()));
        recipe.ownerId = user.id;
        ringProgressDialog.show();
        restAddBackgroundTask.add(user, recipe);

    }

}
