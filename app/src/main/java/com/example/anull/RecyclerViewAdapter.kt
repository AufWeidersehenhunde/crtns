package com.example.anull

import android.content.Intent
import android.provider.SyncStateContract.Helpers.update
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.anull.databinding.RecyclerviewItemBinding
import java.lang.Math.random

class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){
     var MyList = ArrayList<ElementModel>()


    fun set (items: List<ElementModel>) {
        MyList.addAll(items)
        notifyDataSetChanged()
    }



    inner class MyViewHolder(itemBinding: RecyclerviewItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        private val binding = itemBinding

        fun bind (items: ElementModel) {
            binding.apply {
                tv1.text = items.Action
                tv2.text = items.Number.toString()
                tv3.text = items.Notice
                li.setBackgroundColor(items.Color)
                btn1.setOnClickListener {
                removeItem(position)
                    notifyDataSetChanged()

                }

            }
        return
        }




    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(MyList[position])

    }

    override fun getItemCount(): Int {
        return MyList.size
    }


    fun removeItem(position:Int){
        MyList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, MyList.size)
    }


}