package com.ugurtansal.jetpack_applicaitons.onePage


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ugurtansal.jetpack_applicaitons.R
import com.ugurtansal.jetpack_applicaitons.ui.theme.JetPack_ApplicaitonsTheme

class MainLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPack_ApplicaitonsTheme {

            }
        }
    }
}

@Composable
fun MyLoginPage() {
    Surface(color = MaterialTheme.colorScheme.primary) {

        val tfUsername= remember{mutableStateOf("")}
        val tfPassword= remember{mutableStateOf("")}

        Column(Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(R.drawable.logo), contentDescription = "Logo")
            TextField(tfUsername.value, onValueChange = {tfUsername.value=it}, label = { Text("Username")}, colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,    // Odaklandığında arka plan
                unfocusedContainerColor = Color.White,  // Odaklanmadığında arka plan
                focusedTextColor = Color.Black,         // Yazı rengi (odaklı)
                unfocusedTextColor = Color.Black,       // Yazı rengi (odaksız)
                focusedIndicatorColor = Color.Red,      // Alt çizgi (odaklı)
                unfocusedIndicatorColor = Color.Gray    // Alt çizgi (odaksız)
            ))
            TextField(tfPassword.value, onValueChange = {tfPassword.value=it}, label = { Text("Password")})

            Button(onClick = {
                Log.e("Login Clicked","") },
            colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(250.dp,50.dp)) {
                Text("Login", color = MaterialTheme.colorScheme.primary)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    JetPack_ApplicaitonsTheme {
        MyLoginPage()
    }
}