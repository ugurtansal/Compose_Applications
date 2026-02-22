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
import com.ugurtansal.jetpack_applicaitons.R
import com.ugurtansal.jetpack_applicaitons.ui.theme.JetPack_ApplicaitonsTheme

@Composable
fun ResultPage(state:Boolean) {
    val stateText= if(state) "KAZANDINIZ!" else "Üzgünüm Kaybettiniz!"
    val iconRes= if(state) R.drawable.check_icon else R.drawable.clear_icon
    Column(Modifier.fillMaxSize(),Arrangement.SpaceEvenly,Alignment.CenterHorizontally) {
        Text("${stateText}", fontWeight = FontWeight.SemiBold, fontSize = 30.sp)
        Icon(painter = painterResource(id = iconRes), contentDescription = "Sonuç",
            Modifier.size(200.dp))
    }
}

