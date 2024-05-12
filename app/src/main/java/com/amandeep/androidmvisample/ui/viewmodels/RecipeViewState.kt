package com.amandeep.androidmvisample.ui.viewmodels

import com.amandeep.androidmvisample.data.model.Meal

sealed class RecipeViewState {
    object Loading : RecipeViewState()
    data class Success(val recipes: List<Meal>) : RecipeViewState()
    data class Error(val message: String) : RecipeViewState()
}


// with channel approach
data class RecipeViewStateData(
    val loading: Boolean = false,
    val recipeList: List<Meal>? = null,
    val errorMessage: String = ""
)