package com.ugurtansal.jetpack_applicaitons.contactsApp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ugurtansal.jetpack_applicaitons.contactsApp.dao.ContactDao
import com.ugurtansal.jetpack_applicaitons.contactsApp.entity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        var INSTANCE: MyDatabase? = null

        fun dbAccess(context: Context): MyDatabase? {
            if (INSTANCE == null) {
                synchronized(MyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "guide.sqlite" //Veritabanına erişim
                    ).createFromAsset("guide.sqlite") //Kopyalama
                        .build()
                }
            }
            return INSTANCE
        }
    }

}