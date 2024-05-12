package com.amandeep.androidmvisample.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.amandeep.androidmvisample.ui.components.ErrorComponent
import com.amandeep.androidmvisample.ui.components.LoadingComponent
import com.amandeep.androidmvisample.ui.components.SuccessComponent
import com.amandeep.androidmvisample.ui.viewmodels.RecipeViewIntent
import com.amandeep.androidmvisample.ui.viewmodels.RecipeViewModel
import com.amandeep.androidmvisample.ui.viewmodels.RecipeViewState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel) {
    val state by recipeViewModel.stateFLow.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()

    if (state.loading)
        LoadingComponent()
    if (state.errorMessage.isNotEmpty()) ErrorComponent(message = state.errorMessage) {
        coroutineScope.launch {
            recipeViewModel.intentChannel.send(RecipeViewIntent.LoadRandomRecipe)

        }
    }

    state.recipeList?.let {
        SuccessComponent(list = it) {
            coroutineScope.launch {
                recipeViewModel.intentChannel.send(RecipeViewIntent.SearchRecipes(it))
            }
        }
    }


//    when (state) {
//        is RecipeViewState.Error -> {
//            val errorMessage = (state as RecipeViewState.Error).message
//            ErrorComponent(errorMessage) {
//                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
//            }
//
//        }
//
//        RecipeViewState.Loading -> LoadingComponent()
//        is RecipeViewState.Success -> {
//            val listOfRecipes = (state as RecipeViewState.Success).recipes
//            SuccessComponent(listOfRecipes) {
//                coroutineScope.launch {
//                    recipeViewModel.intentChannel.send(RecipeViewIntent.SearchRecipes(it))
//                }
//            }
//        }
//    }

    LaunchedEffect(Unit) {
        recipeViewModel.intentChannel.send(RecipeViewIntent.LoadRandomRecipe)

        // recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }

}