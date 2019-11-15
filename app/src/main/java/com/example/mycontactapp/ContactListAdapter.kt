package com.example.mycontactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter(val contactlist:ArrayList<Contact>, val OnItemClickListener: OnItemClickListener):RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactListAdapter.ContactViewHolder {



        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_contact_list, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactlist.size
    }

    override fun onBindViewHolder(holder: ContactListAdapter.ContactViewHolder, position: Int) {

        var contact1 = contactlist[position]
        holder.contactName.text = contact1.firstName
        holder.contactPhone.text = contact1.phone
        holder.view.setOnClickListener {
            OnItemClickListener.OnItemClick(contact1)
        }

    }

    class ContactViewHolder(var view: View):RecyclerView.ViewHolder(view){
//        var contactImage:ImageView
        var contactName:TextView
        var contactPhone:TextView
        init {
//            contactImage = view.findViewById(R.id.content_image1)
            contactName = view.findViewById(R.id.Text_name1)
            contactPhone = view.findViewById(R.id.Text_phone1)
        }
    }

}