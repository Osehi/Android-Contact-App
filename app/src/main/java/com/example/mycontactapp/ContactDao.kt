package com.example.mycontactapp

import androidx.room.*

@Dao
interface ContactDao {

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun fetchContact(): List<Contact>

    @Insert
    fun addContact(contact:Contact)
}