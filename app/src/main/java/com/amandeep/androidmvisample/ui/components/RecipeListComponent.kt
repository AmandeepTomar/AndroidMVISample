package com.amandeep.androidmvisample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amandeep.androidmvisample.data.model.Meal

@Composable
fun RecipeListComponent(recipes: List<Meal>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {

        items(recipes) {
            RecipeListItem(it)
        }

    }
}


@Preview
@Composable
fun RecipeListComponentPreview(){
    val listOFMeals = listOf<Meal>()

}