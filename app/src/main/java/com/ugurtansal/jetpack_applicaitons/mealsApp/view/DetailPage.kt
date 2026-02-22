package com.ugurtansal.jetpack_applicaitons.mealsApp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ugurtansal.jetpack_applicaitons.mealsApp.entity.Meal
import com.ugurtansal.jetpack_applicaitons.ui.theme.MealsAppTopBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailPage(meal: Meal) {

    val context = LocalContext.current // Context'i aldık

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("${meal.mealName}") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MealsAppTopBar,
                    titleContentColor = Color.White
                )

            )
        }
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val imageResId = context.resources.getIdentifier(
                meal.mealVisual,
                "drawable",
                context.packageName
            )
            Image(
                bitmap = ImageBitmap.imageResource(id = imageResId),
                contentDescription = meal.mealName,
                modifier = Modifier.size(200.dp)
            )
            Text(text = "${meal.mealPrice} ₺", fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Button(
                onClick = {},
                modifier = Modifier.size(200.dp, 50.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = MealsAppTopBar,
                    contentColor = Color.White
                )
            ) {
                Text("Sepete Ekle")
            }

        }
    }
}

