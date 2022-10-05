package com.example.anull

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
    var isFirstRun: Boolean = false
    var null11:Double = 2.0
    var recyclerViewAdapter = RecyclerViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isFirstRun=false
        val rsrIntent = Intent(this, Lazy_activity::class.java)
        isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
            .getBoolean("isFirstRun", true);
        if (null11>1){
            startActivity(rsrIntent)
            Toast.makeText(this, "1st run", Toast.LENGTH_SHORT)
                .show();

        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
            .putBoolean("isFirstRun",false).commit();
        binding.btn2.setOnClickListener {
            startActivity(rsrIntent)
        }



        Main = MainActivity()
        Elem = Element()
        recyclerViewAdapter = RecyclerViewAdapter()
        val rcview1: RecyclerView = binding.rcview1
        rcview1.layoutManager = LinearLayoutManager(this)
        rcview1.adapter = recyclerViewAdapter

        val function = Elem.list



        fun main() {
                GlobalScope.launch {
                    while (true) {
                    delay(5000L)
                    val item = function.random()
                    recyclerViewAdapter.MyList.add(item)

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