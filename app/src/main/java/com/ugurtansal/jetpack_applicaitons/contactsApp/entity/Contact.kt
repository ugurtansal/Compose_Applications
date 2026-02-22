package com.ugurtansal.jetpack_applicaitons.contactsApp.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="contact_id") @NotNull var contactId:Int,
    @ColumnInfo(name="contact_name") @NotNull var contactName: String,
    @ColumnInfo(name="contact_number") @NotNull var contactNumber:Int,
)