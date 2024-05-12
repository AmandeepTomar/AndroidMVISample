package com.amandeep.androidmvisample.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amandeep.androidmvisample.data.model.Meal

@Composable
fun SuccessComponent(list: List<Meal>, onSearchClick: (query: String) -> Unit) {

    Column {
        Text(
            text = "Recipe Finder", fontSize = 32.sp,
            fontWeight = FontWeight(900),
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(8.dp)
        )
        SearchComponent(onSearchClick)
        RecipeListComponent(list)
    }

}