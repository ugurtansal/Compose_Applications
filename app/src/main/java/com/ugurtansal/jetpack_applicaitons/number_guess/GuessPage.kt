package com.ugurtansal.jetpack_applicaitons.number_guess


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ugurtansal.jetpack_applicaitons.ui.theme.JetPack_ApplicaitonsTheme


@Composable
fun GuessPage(navController: NavController){
    val rightCounter= remember { mutableStateOf(5) }
    val clue= remember { mutableStateOf("") }
    val tfGuess= remember { mutableStateOf("") }

    val randomNumber= remember { (0..10).random() }

    Column(Modifier.fillMaxSize(), Arrangement.SpaceEvenly, Alignment.CenterHorizontally) {
        Text("Kalan Hak : ${rightCounter.value}", fontSize = 30.sp, fontWeight = FontWeight.SemiBold, color = Color.Red)
        Text("Yardım : ${clue.value}", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, )
        TextField(tfGuess.value, onValueChange = {tfGuess.value=it}, label = { Text("Tahmininizi Giriniz") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Button(onClick = {
            if(tfGuess.value.isNotEmpty()){
                val guess= tfGuess.value.toInt()
                if(guess==randomNumber){
                    navController.navigate("result_page/${true}"){
                        popUpTo("guess_page"){
                            inclusive=true
                        }
                    }
                }else{
                    rightCounter.value--
                    clue.value= if(guess>randomNumber) "Azaltın" else "Arttırın"
                     tfGuess.value=""
                    if(rightCounter.value==0){
                        navController.navigate("result_page/${false}"){
                            popUpTo("guess_page"){
                                inclusive=true
                            }
                        }
                    }
                }
            }
        },
            modifier=Modifier.size(200.dp, 50.dp))
        {
            Text("Tahmin Et")
        }
    }
}

