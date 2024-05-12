package com.amandeep.androidmvisample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.amandeep.androidmvisample.ui.screens.HomeScreen
import com.amandeep.androidmvisample.ui.screens.SampleLoginScreen
import com.amandeep.androidmvisample.ui.screens.StateHoistingExample
import com.amandeep.androidmvisample.ui.theme.AndroidMVISampleTheme
import com.amandeep.androidmvisample.ui.viewmodels.RecipeViewModel

class MainActivity : ComponentActivity() {
    private val recipeViewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidMVISampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    StateHoistingExample()
//                    SampleLoginScreen(onClick = { userName, password ->
//                        Toast.makeText(this, "$userName $password", Toast.LENGTH_SHORT).show()
//                    })
                    HomeScreen(recipeViewModel = recipeViewModel)
                }
            }
        }
    }
}

