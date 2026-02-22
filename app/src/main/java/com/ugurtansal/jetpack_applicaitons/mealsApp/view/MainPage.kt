package com.ugurtansal.jetpack_applicaitons.mealsApp.view


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.ugurtansal.jetpack_applicaitons.R
import com.ugurtansal.jetpack_applicaitons.mealsApp.entity.Meal
import com.ugurtansal.jetpack_applicaitons.mealsApp.viewmodel.MainPageViewModel
import com.ugurtansal.jetpack_applicaitons.ui.theme.JetPack_ApplicaitonsTheme
import com.ugurtansal.jetpack_applicaitons.ui.theme.MealsAppTopBar

class MainPageActivity : ComponentActivity() {
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
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main_page") {
        composable("main_page") {
            MainPage(navController)
        }
        composable("detail_page/{meal}",
            arguments = listOf(
                navArgument("meal") {
                    type = NavType.StringType
                }
            )) {
            val json=it.arguments?.getString("meal")!!
            val meal= Gson().fromJson(json, Meal::class.java)
            DetailPage(meal)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun MainPage(navController: NavController) {
    val mViewModel: MainPageViewModel = viewModel()
    val mealsLis = mViewModel.mealsList.observeAsState(listOf<Meal>())
    val context = LocalContext.current // Context'i aldık



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meals") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MealsAppTopBar,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues -> // Buradaki padding hayati önem taşır
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // TopBar'ın altında kalmasını engeller
        ) {
            items(
                count = mealsLis.value.size,
                key = { mealsLis.value[it].id } // Performans için key eklemek iyidir
            ) { index ->
                val meal = mealsLis.value[index]

                // Dinamik ID bulma işlemi
                val imageResId = context.resources.getIdentifier(
                    meal.mealVisual,
                    "drawable",
                    context.packageName
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val mealJson = Gson().toJson(meal)
                                navController.navigate("detail_page/$mealJson")
                            }
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Resim Gösterimi
                        if (imageResId != 0) {
                            Image(
                                painter = painterResource(id = imageResId),
                                contentDescription = meal.mealName,
                                modifier = Modifier.size(80.dp)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp)
                        ) {
                            Text(meal.mealName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text("${meal.mealPrice} ₺", color = Color.Gray)
                        }

                        IconButton(onClick = {
                            val mealJson = Gson().toJson(meal)
                            navController.navigate("detail_page/$mealJson")
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.arrow_right_icon),
                                contentDescription = "Detail",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

