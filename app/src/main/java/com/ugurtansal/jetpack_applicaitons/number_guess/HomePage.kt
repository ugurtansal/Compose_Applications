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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ugurtansal.jetpack_applicaitons.R
import com.ugurtansal.jetpack_applicaitons.ui.theme.JetPack_ApplicaitonsTheme

class MainHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPack_ApplicaitonsTheme {
                PageTransition()
            }
        }
    }
}

@Composable
fun PageTransition() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomePage(navController)
        }
        composable ("guess_page"){
            GuessPage(navController)
        }
        composable("result_page/{state}",
           arguments = listOf( navArgument ("state"){
                type= NavType.BoolType
            })
        ){
            val state= it.arguments?.getBoolean("state")!!
            ResultPage(state)
        }

    }
}



@Composable
fun HomePage(navController: NavController) {

    Column(Modifier.fillMaxSize(),Arrangement.SpaceEvenly,Alignment.CenterHorizontally) {
        Text("TAHMİN OYUNU", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Icon(painter = painterResource(R.drawable.adjust_icon),"Tahmin Oyunu",Modifier.size(200.dp))
        Button(onClick = {
            navController.navigate("guess_page")
        }, Modifier.size(200.dp,50.dp)) {
            Text("OYUNA BAŞLA")
        }
    }

}

