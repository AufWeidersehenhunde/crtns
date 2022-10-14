package com.example.anull

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anull.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var Elem:Element
    lateinit var Main:MainActivity
    lateinit var binding:ActivityMainBinding
    var recyclerViewAdapter = RecyclerViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn2.setOnClickListener {
            startActivity(Intent(this, Lazy_activity::class.java))
        }
        Main = MainActivity()
        Elem = Element()
        recyclerViewAdapter = RecyclerViewAdapter()
        val rcview1: RecyclerView = binding.rcview1
        rcview1.layoutManager = LinearLayoutManager(this)
        rcview1.adapter = recyclerViewAdapter
        val function = Elem.list
        val countere = 23
        binding.rcview1.apply {
            layoutManager = GridLayoutManager(context,2)
        }
        fun main() {
                GlobalScope.launch {
                    while (true) {
                    delay(1000L)
                    val item = function.random()
                    recyclerViewAdapter.MyList.add(item)
                    if (countere>20){
                        runOnUiThread( Runnable() {
                            fun rune() {
                                recyclerViewAdapter.notifyDataSetChanged()
                            }
                            rune()
                        })
                    }
                }
            }
        }

        fun goToView(model: List<ElementModel>) {
            recyclerViewAdapter.set(model)
            main()

        }

        goToView(Element().list)



    }
}