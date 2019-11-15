package com.example.mycontactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_profile_.*

class Profile_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_)

        if(intent.hasExtra("firstName") && intent.hasExtra("phone")){
//            val fullName = intent.getStringExtra("fullName")
            val email = intent.getStringExtra("email")
            val firstName = intent.getStringExtra("firstName")
            val lastName = intent.getStringExtra("lastName")
            val address = intent.getStringExtra("address")
            val phone = intent.getStringExtra("phone")
            Log.d("Profile", firstName)


//            text_fullName.text = fullName
            text_lastNameNew.text = lastName
            text_firstNameNew.text = firstName
            text_email.text = email
            text_firstName.text = firstName
            text_lastName.text = lastName
            text_phone.text = phone
            text_address.text = address
            text_emailprofile.text = email
        }
    }
}
