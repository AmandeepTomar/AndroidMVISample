package com.amandeep.androidmvisample.ui.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.time.TimeSource


@Composable
fun StateHoistingExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Component1()
    }
}

@Composable
fun Component1() {

    var counter by remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Title of the Component Text$counter")
        Spacer(modifier = Modifier.height(10.dp))
//        Button(onClick = {
//            counter+1
//        }) {
//            Text(text = "Update Counter")
//        }

        Component2 {
            counter++
        }
    }
}

@Composable
fun Component2(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .background(Color.Green)
            .clickable {
                onClick.invoke()
            },
        shape = RoundedCornerShape(10.dp)
    ) {

    }
}


@Composable
fun drawTheLazyRow() {
    val listOfString = listOf("Name", "b", "c", "D", "e")
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(listOfString) {
            Row {
                Text(text = it)
            }
        }
    }
}

@Preview
@Composable
fun drawTheLazyRowPreview() {
    drawTheLazyRow()
}