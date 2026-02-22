package com.ugurtansal.jetpack_applicaitons.onePage


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ugurtansal.jetpack_applicaitons.R
import com.ugurtansal.jetpack_applicaitons.ui.theme.CommentBtn
import com.ugurtansal.jetpack_applicaitons.ui.theme.JetPack_ApplicaitonsTheme
import com.ugurtansal.jetpack_applicaitons.ui.theme.LikedBtn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPack_ApplicaitonsTheme {

            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipePage() {
    Scaffold(Modifier.fillMaxSize(),topBar = {
        TopAppBar(
        title = {Text("Yemek Tarifi")},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = LikedBtn
    )) }, content = {
        Column (Modifier.fillMaxSize()){
            Image(painterResource(R.drawable.yemekresim), contentDescription = "Yemek Resmi")
            Row (Modifier.fillMaxWidth()){
                Button(onClick = {},
                    colors= ButtonDefaults.buttonColors(LikedBtn),
                    modifier =  Modifier.weight(50f))
                {
                    Text("Beğen", color = Color.Black, )
                }
                Button(onClick = {},
                    colors= ButtonDefaults.buttonColors(CommentBtn),
                   modifier =  Modifier.weight(50f))
                {
                    Text("Yorum Yap", color = Color.Black, )
                }
            }
            Text("Köfte", color = LikedBtn, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
            Row (Modifier.fillMaxWidth().padding(10.dp),horizontalArrangement = Arrangement.SpaceBetween){
                Text("Izgaraya Uygun")
                Text("7 Haziran")
            }
            Text("Köfte, kıyma, soğan, ekmek kırıntısı ve baharatların karıştırılarak şekillendirilip kızartılmasıyla yapılan bir yemektir. Genellikle köfte," +
                    " pilav veya patates kızartması gibi yan yemeklerle servis edilir. Köfte, dünya genelinde farklı kültürlerde çeşitli şekillerde hazırlanır" +
                    " ve tüketilir.", Modifier.padding(10.dp), textAlign = TextAlign.Center)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun RecipePreview() {
    JetPack_ApplicaitonsTheme {
        RecipePage()
    }
}