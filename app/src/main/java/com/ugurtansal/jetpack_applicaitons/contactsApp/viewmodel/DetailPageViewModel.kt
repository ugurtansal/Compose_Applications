package com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ugurtansal.jetpack_applicaitons.contactsApp.repo.ContactDaoRepository

class DetailPageViewModel: ViewModel() {
    val cRepo= ContactDaoRepository()

    fun update(contactId:Int,contactName: String,contactNumber:Int){
        cRepo.updateContact(contactId,contactName,contactNumber)
    }
}