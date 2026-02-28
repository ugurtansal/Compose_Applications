package com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.ugurtansal.jetpack_applicaitons.contactsApp.repo.ContactDaoRepository

class AddPageViewModel( application: Application): AndroidViewModel(application)  {
    val cRepo= ContactDaoRepository(application)

    fun add(contactName: String,contactNumber: Int){
        cRepo.addContact(contactName,contactNumber);
    }
}