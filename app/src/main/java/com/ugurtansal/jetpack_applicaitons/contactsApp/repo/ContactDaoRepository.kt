package com.ugurtansal.jetpack_applicaitons.contactsApp.repo

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ugurtansal.jetpack_applicaitons.contactsApp.database.MyDatabase
import com.ugurtansal.jetpack_applicaitons.contactsApp.entity.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ContactDaoRepository(var application: Application) {
    var contactList = MutableLiveData<List<Contact>>()
    var db: MyDatabase

    init {
        db=MyDatabase.dbAccess(context = application)!!
        contactList = MutableLiveData()
    }

    fun getContacts():MutableLiveData<List<Contact>>{
        return contactList
    }


    fun getAllContacts() {

        val job: Job= CoroutineScope(Dispatchers.Main).launch {
            contactList.value=db.contactDao().allContact()
        }

    }


    fun contactSearch(searchedValue: String){
        val job: Job= CoroutineScope(Dispatchers.Main).launch {
            contactList.value=db.contactDao().searchContact(searchedValue)
        }

    }

    fun addContact(contactName: String,contactNumber: Int){
        val job: Job= CoroutineScope(Dispatchers.Main).launch {
            val newContact= Contact(0,contactName,contactNumber)
            db.contactDao().addContact(newContact)
        }
    }

    fun updateContact(contactId:Int,contactName: String,contactNumber:Int){
        val job: Job= CoroutineScope(Dispatchers.Main).launch {
            val updateContact= Contact(contactId,contactName,contactNumber)
            db.contactDao().updateContact(updateContact)
        }
    }

    fun deleteContact(contactId:Int){
        val job: Job= CoroutineScope(Dispatchers.Main).launch {
            val deleteContact= Contact(contactId,"",0)
            db.contactDao().deleteContact(deleteContact)
            getAllContacts()
        }
    }
}