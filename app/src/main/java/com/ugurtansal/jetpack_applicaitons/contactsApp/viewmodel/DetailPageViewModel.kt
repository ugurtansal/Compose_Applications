package com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.ugurtansal.jetpack_applicaitons.contactsApp.repo.ContactDaoRepository

class DetailPageViewModel( application: Application): AndroidViewModel(application)  {
    val cRepo= ContactDaoRepository(application)

    fun update(contactId:Int,contactName: String,contactNumber:Int){
        cRepo.updateContact(contactId,contactName,contactNumber)
    }
}