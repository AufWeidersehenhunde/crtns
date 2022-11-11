package com.example.anull

import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import java.text.FieldPosition
private lateinit var mainActivity: MainActivity
interface MyClickListener {
    fun OnItemClick(view:View, position: Int ){
        Toast.makeText(mainActivity, "TEST: " + position, Toast.LENGTH_SHORT).show()
    }

}
