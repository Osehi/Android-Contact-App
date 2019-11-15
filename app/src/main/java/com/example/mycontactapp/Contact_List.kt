package com.example.mycontactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_contact__list.*

class Contact_List : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact__list)

//        var contactlist = arrayListOf<Contact>()

        var contactlist = MyDatabase.getDatabase(applicationContext).contactDAO().fetchContact()

//        contactlist.add(Contact("07083372454", "Osehiase", "Ehilen", "osehiproductengineer@gmaill.com", "44, Tokura Street, Alagbado, Lagos"))
//        contactlist.add(Contact("08167302597", "Francis", "Ibe", "francis@gmail.com", "Anambra"))
//        contactlist.add(Contact("08132978120", "Amakiri", "Joseph", "amakirijoseph@gmail.com", "Atlantic View Estate, Lekki, Lagos"))

        if(intent != null){
            var firstName = intent.getStringExtra("firstName")
           var lastName = intent.getStringExtra("lastName")
            var email = intent.getStringExtra("email")
            var phone = intent.getStringExtra("phone")
            var address = intent.getStringExtra("address")

//            contactlist.add(Contact(phone, firstName, lastName, email, address))
        }

       Log.d("TAG", "${contactlist.size}")

        // linking the adapter to the recyclerview

        var myView = findViewById<RecyclerView>(R.id.recyclerview_1)

        myView.layoutManager = LinearLayoutManager(this)

        myView.adapter = ContactListAdapter(contactlist as ArrayList<Contact>, object :OnItemClickListener{
            override fun OnItemClick(contact: Contact) {
//                Toast.makeText(this@Contact_List, contact.phone, Toast.LENGTH_LONG).show()
                val intent = Intent(this@Contact_List, Profile_Activity::class.java)
//                intent.putExtra("name", contact.name)
                intent.putExtra("phone", contact.phone)
                intent.putExtra("firstName", contact.firstName)
                intent.putExtra("lastName", contact.lastName)
                intent.putExtra("email", contact.email)
                intent.putExtra("address", contact.address)
//                intent.putExtra("fullName", contact.fullName)

                startActivity(intent)
            }
        })

    }

    override fun onStart() {
        super.onStart()

//        var contactlist = arrayListOf<Contact>()
//        if(intent != null){
//            var firstName = intent.getStringExtra("firstName")
//            var lastName = intent.getStringExtra("lastName")
//            var email = intent.getStringExtra("email")
//            var phone = intent.getStringExtra("phone")
//            var address = intent.getStringExtra("address")
//
//            contactlist.add(Contact(firstName, lastName, email, phone, address))
//        }



        fab_button.setOnClickListener {

            var intent = Intent(this@Contact_List, MainActivity::class.java)

            startActivity(intent)
        }
    }
}
