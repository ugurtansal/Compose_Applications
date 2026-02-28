package com.ugurtansal.jetpack_applicaitons.contactsApp.view

import android.annotation.SuppressLint
import android.app.Application
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ugurtansal.jetpack_applicaitons.contactsApp.viewModelFactory.AddPageViewModelFactory
import com.ugurtansal.jetpack_applicaitons.contactsApp.viewModelFactory.MainPageViewModelFactory
import com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel.AddPageViewModel
import com.ugurtansal.jetpack_applicaitons.ui.theme.ContactsTopBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContactsAddPage(){
    val context= LocalContext.current

    val aViewModel: AddPageViewModel =viewModel(
        factory = AddPageViewModelFactory(context.applicationContext as Application),

    )

    val tfName = remember { mutableStateOf("") }
    val tfNumber = remember { mutableStateOf("") }

    val localFocusManager= LocalFocusManager.current


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Contact Save", color = Color.White)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ContactsTopBar,
                ),
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(tfName.value, onValueChange = { tfName.value = it }, placeholder ={Text("Contacts Name")})
            TextField(tfNumber.value, onValueChange = { tfNumber.value = it }, placeholder ={Text("Contacts Number")})
            Button(
                onClick = {
                    aViewModel.add(tfName.value,tfNumber.value.toInt())

                    localFocusManager.clearFocus()
                },
                modifier = Modifier.size(250.dp, 50.dp),
                colors= ButtonDefaults.buttonColors(
                    containerColor = ContactsTopBar,
                    contentColor = Color.White
                )
            ) {
                Text("Save")
            }
        }

    }

}


