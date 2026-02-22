package com.ugurtansal.jetpack_applicaitons.onePage

import android.annotation.SuppressLint
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ugurtansal.jetpack_applicaitons.R
import com.ugurtansal.jetpack_applicaitons.ui.theme.ContactsTopBar
import com.ugurtansal.jetpack_applicaitons.ui.theme.JetPack_ApplicaitonsTheme


class MainBasic : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPack_ApplicaitonsTheme {

        }
    }
}
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMainPage() {
    Scaffold(modifier = Modifier.fillMaxSize(),topBar = {
        TopAppBar(
            title = { Text("İlham Ver") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = ContactsTopBar,
                titleContentColor = colorResource(R.color.white),

            ),

        )
    }, content =
    {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
           Column (horizontalAlignment = Alignment.CenterHorizontally){
               Image(painterResource(R.drawable.stevejobs),"Steve Jobs")
               Text("Steve Jobs", color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 22.sp)
           }

            Text("Dünyayı değiştirecek bir şey yapmak istiyorsanız, önce kendinizi değiştirin.", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(10.dp),textAlign = TextAlign.Center)
            Button(onClick = {
                Log.e("Button Clicked","İlham Verildi")},
                colors= ButtonDefaults.buttonColors(ContactsTopBar)
            ) {
                Text("İlham Ver")
            }

        }
})
}

@Preview(showBackground = true)
@Composable
fun BasicPagePreview() {
    JetPack_ApplicaitonsTheme {
        MyMainPage()
    }
}
}