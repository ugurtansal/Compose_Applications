package com.ugurtansal.jetpack_applicaitons.contactsApp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ugurtansal.jetpack_applicaitons.contactsApp.entity.Contact

@Dao
interface ContactDao {

    @Query("Select * from contacts")
    suspend fun allContact(): List<Contact>


    @Insert
    suspend fun addContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)


    @Query("Select * from contacts where contact_name like '%' || :searchedValue || '%' ")
    suspend fun searchContact(searchedValue: String): List<Contact>

    /*

    ANother Examples

    @Query("Select * from contacts order by RANDOM() LIMIT 1")
    suspend fun getRandomContact(): List<Contact>



    @Query("Select * from contacts where contact_id=:contactId")
    suspend fun getContactById(contactId:Int): Contact

    @Query("Select count(*) from contacts where contact_name=:contactName")
    suspend fun countContact(contactName: String): Int


     */
}