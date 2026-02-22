package com.ugurtansal.jetpack_applicaitons.contactsApp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.ugurtansal.jetpack_applicaitons.R
import com.ugurtansal.jetpack_applicaitons.contactsApp.entity.Contact
import com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel.MainPageViewModel
import com.ugurtansal.jetpack_applicaitons.ui.theme.ContactsTopBar
import com.ugurtansal.jetpack_applicaitons.ui.theme.JetPack_ApplicaitonsTheme

class MainPageContacts : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPack_ApplicaitonsTheme {
                PageTransitions()
            }
        }
    }
}

@Composable
fun PageTransitions() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main_page") {
        composable("main_page") {
            MainPage(navController)
        }
        composable("contact_add") {
            ContactsAddPage()
        }
        composable(
            "contact_detail/{contact}",
            arguments = listOf(
                navArgument("contact") {
                    type = NavType.StringType
                }
            )) {
            val json = it.arguments?.getString("contact")
            val contact = Gson().fromJson(json, Contact::class.java)

            ContactDetailPage(contact)
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage(navController: NavController) {
    val mViewModel: MainPageViewModel = viewModel()

    val contactsLis = mViewModel.contactList.observeAsState(listOf()).value
    val context = LocalContext.current // Context'i aldık


    val isSearching = remember { mutableStateOf(false) }
    val tfInput = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearching.value) {
                        TextField(
                            value = tfInput.value, onValueChange = {
                                mViewModel.contactSearch(it)
                                tfInput.value = it
                            },
                            placeholder = { Text("Search...") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(

                            )
                        )

                    } else {
                        Text("Contacts", color = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ContactsTopBar,
                ),
                actions = {
                    val iconStats =
                        if (isSearching.value) R.drawable.clear_icon else R.drawable.search_icon
                    IconButton(onClick = {
                        isSearching.value = !isSearching.value
                    }) {
                        Icon(
                            painter = painterResource(id = iconStats),
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }
                }
            )

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("contact_add")
                },
                containerColor = ContactsTopBar,
                content = {
                    Icon(painterResource(R.drawable.add_icon), "Add", tint = Color.White)
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(
                count = contactsLis.size,
                key = { contactsLis[it].contactId }
            ) { index ->
                val contact = contactsLis[index]
                Card(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp, top = 10.dp)
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable(onClick = {
                                val contactJson = Gson().toJson(contact)
                                navController.navigate("contact_detail/$contactJson")
                            }),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "${contact.contactName} - ${contact.contactNumber}",
                        )
                        IconButton(onClick = {
                            mViewModel.delete(contact.contactId)
                        }) {
                            Icon(
                                painterResource(R.drawable.delete_icon),
                                "Delete",
                                tint = Color.Gray
                            )
                        }
                    }

                }
            }

        }
    }
}
