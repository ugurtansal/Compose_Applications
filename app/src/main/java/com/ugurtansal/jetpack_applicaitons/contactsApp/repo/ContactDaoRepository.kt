package com.ugurtansal.jetpack_applicaitons.contactsApp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ugurtansal.jetpack_applicaitons.contactsApp.entity.Contact

class ContactDaoRepository {
    var contactList = MutableLiveData<List<Contact>>()

    init {
        contactList = MutableLiveData()
    }

    fun getContacts():MutableLiveData<List<Contact>>{
        return contactList
    }


    fun getAllContacts() {
        val list = mutableListOf<Contact>(
            Contact(1, "Ahmet", 1111111),
            Contact(2, "Mehmet", 2222222),
            Contact(3, "Zeynep", 3333333)
        )

        contactList.value=list
    }


    fun contactSearch(searchedValue: String){
        Log.e("Search","Searched value : ${searchedValue}")
    }

    fun addContact(contactName: String,contactNumber: Int){
        Log.e("Add","Added ${contactName}")
    }

    fun updateContact(contactId:Int,contactName: String,contactNumber:Int){
        Log.e("Update","Updated ${contactName}")
    }

    fun deleteContact(contactId:Int){
        Log.e("Delete","Deleted ${contactId}")
    }
}