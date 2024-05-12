package com.amandeep.androidmvisample.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SampleLoginScreen(onClick: (String, String) -> Unit) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = "Login Here",
            color = Color.Red,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)

        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp),
            value = userName,
            onValueChange = {
                userName = it
            },
            label = { Text(text = "Please Enter UserName") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp),
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Please Enter Pasword") },
            visualTransformation = PasswordVisualTransformation()
        )

        Box(modifier = Modifier.fillMaxSize()) {
            val context = LocalContext.current
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                onClick = {
                    if (userName.isNotEmpty() || password.isNotEmpty())
                        onClick(userName, password)
                    else {
                        Toast.makeText(
                            context,
                            "Username and password should not be empty",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }) {
                Text(text = "Login")
            }
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun SampleLoginScreenPreview() {
    SampleLoginScreen { userName, password ->

    }
}
