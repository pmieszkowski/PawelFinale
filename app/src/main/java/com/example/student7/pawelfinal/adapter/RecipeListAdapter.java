package com.example.student7.pawelfinal.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.example.student7.pawelfinal.ItemView.RecipeItemView;
import com.example.student7.pawelfinal.ItemView.RecipeItemView_;
import com.example.student7.pawelfinal.data.Recipe;
import com.example.student7.pawelfinal.data.RecipeList;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import java.util.ArrayList;
import java.util.List;

@EBean
public class RecipeListAdapter extends BaseAdapter {
    @RootContext
    Context context;
    List<Recipe> recipes = new ArrayList<Recipe>();
    public RecipeListAdapter() {
    }
    public void update(RecipeList recipeList) {
        recipes.clear();
        recipes.addAll(recipeList.records);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return recipes.size();
    }
    @Override
    public Recipe getItem(int i) {
        return recipes.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecipeItemView recipeItemView;
        if (convertView == null) {
            recipeItemView = RecipeItemView_.build(context);
        } else {
            recipeItemView = (RecipeItemView) convertView;
        }
        recipeItemView.bind(getItem(position));
        return recipeItemView;
    }
}
