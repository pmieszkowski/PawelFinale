package com.example.student7.pawelfinal;

import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.example.student7.pawelfinal.data.Recipe;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

@EActivity(R.layout.recipe_activity)
public class RecipeActivity extends ActionBarActivity {
    @ViewById
    TextView title;
    @ViewById
    TextView ingredients;
    @ViewById
    TextView introduction;

    @ViewById
    TextView servings;
    @ViewById
    TextView steps;

    @ViewById
    TextView CookingMinutes;

    @ViewById
    TextView PreparationMinutes;

    @Extra
    Recipe recipe;

    @AfterViews
    void init() {
        title.setText(recipe.title);
        ingredients.setText(recipe.ingredients);
        introduction.setText(recipe.introduction);
        if (recipe.servings != null)servings.setText(Integer.toString(recipe.servings));
        steps.setText(recipe.steps);
        if (recipe.cookingMinutes != null)CookingMinutes.setText(Integer.toString(recipe.cookingMinutes));
        if (recipe.preparationMinutes != null)PreparationMinutes.setText(Integer.toString(recipe.preparationMinutes));

    }

}
