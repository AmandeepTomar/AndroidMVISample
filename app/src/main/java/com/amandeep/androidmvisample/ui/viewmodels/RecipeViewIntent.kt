package com.amandeep.androidmvisample.ui.viewmodels

sealed class RecipeViewIntent {

    object LoadRandomRecipe : RecipeViewIntent()

    data class SearchRecipes(val query:String):RecipeViewIntent()
}