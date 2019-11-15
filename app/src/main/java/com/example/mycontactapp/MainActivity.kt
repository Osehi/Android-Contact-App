package com.example.mycontactapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.addcontact.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button_submit1.setOnClickListener {
//            result_view1.text = firstName
            var firstName = edit_firstName1.text.toString()
            var lastName = edit_lastName1.text.toString()
            var email = edit_email1.text.toString()
            var phone = edit_phone1.text.toString()
            var address = edit_address1.text.toString()

            val capturedContact = Contact(0, firstName, lastName, email, phone, address)

            MyDatabase.getDatabase(applicationContext).contactDAO().addContact(capturedContact)


            // create an intent
            var intent = Intent(this@MainActivity, Contact_List::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("email", email)
            intent.putExtra("phone", phone)
            intent.putExtra("address", address)

            startActivity(intent)
        }
    }
}
