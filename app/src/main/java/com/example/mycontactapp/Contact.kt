package com.example.mycontactapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var phone:String?,
    var firstName:String?,
    var lastName:String?,
    var email:String?,
    var address:String?
    ) {

//    constructor()
}