package com.example.anull

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.example.anull.databinding.ActivityLazyBinding
import com.example.anull.databinding.ActivityMainBinding

class Lazy_activity : AppCompatActivity() {
    lateinit var mainActivity: MainActivity
    lateinit var binding:ActivityLazyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLazyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fIntent = Intent(this, MainActivity::class.java)
        val cal = binding.textView1
        cal.setOnClickListener{
            Toast.makeText(applicationContext, "Are you mad?", Toast.LENGTH_SHORT).show()
        }
        val pal = binding.button

        pal.setOnClickListener{
            startActivity(fIntent)
          }
    }

}