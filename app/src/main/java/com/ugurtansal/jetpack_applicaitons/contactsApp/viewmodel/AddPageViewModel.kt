package com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ugurtansal.jetpack_applicaitons.contactsApp.repo.ContactDaoRepository

class AddPageViewModel: ViewModel() {
    val cRepo= ContactDaoRepository()

    fun add(contactName: String,contactNumber: Int){
        cRepo.addContact(contactName,contactNumber);
    }
}