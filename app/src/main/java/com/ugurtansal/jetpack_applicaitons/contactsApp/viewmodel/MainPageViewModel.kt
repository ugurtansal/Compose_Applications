package com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurtansal.jetpack_applicaitons.contactsApp.entity.Contact
import com.ugurtansal.jetpack_applicaitons.contactsApp.repo.ContactDaoRepository

class MainPageViewModel( application: Application): AndroidViewModel(application) {

    var cRepo= ContactDaoRepository(application)
    var contactList= MutableLiveData<List<Contact>>()

    init{
        getAllContacts()
        contactList=cRepo.getContacts()
    }

    fun getAllContacts(){
       cRepo.getAllContacts()
    }

    fun delete(contactId:Int){
        cRepo.deleteContact(contactId)
    }

    fun contactSearch(searchedValue: String){
       cRepo.contactSearch(searchedValue)
    }
}