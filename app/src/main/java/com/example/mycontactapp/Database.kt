package com.example.mycontactapp

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Contact::class], version = 2)
abstract class MyDatabase:RoomDatabase() {

    abstract fun contactDAO(): ContactDao

    companion object{
        // create an instance and return an instance
        private var database:MyDatabase?= null
        fun getDatabase(context: Context):MyDatabase{
            if(database == null){
                database = Room.databaseBuilder(context,MyDatabase::class.java, "data").allowMainThreadQueries().build()
                return database!!
            }
            return database!!
        }
    }
}