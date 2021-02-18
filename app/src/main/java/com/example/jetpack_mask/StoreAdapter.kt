package com.example.jetpack_mask

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_mask.model.Store

class StoreViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
}

class StoreAdapter : RecyclerView.Adapter<StoreViewHolder>() {
    private var mItems : List<Store> = ArrayList()

    fun updateItems(items:List<Store>){
        mItems = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_store,parent,false)
        return StoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
//        holder.binding.store = mItems[position]
    }

    override fun getItemCount() = mItems.size

}