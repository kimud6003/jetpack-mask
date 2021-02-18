package com.example.jetpack_mask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_mask.model.Store
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recycler_view.layoutManager = LinearLayoutManager(this,
//            RecyclerView.VERTICAL,false)
//        val adapter = StoreAdapter()
//        recycler_view.adapter = adapter

        recycler_view.apply{
            layoutManager = LinearLayoutManager(this@MainActivity,
            RecyclerView.VERTICAL,false)
            this.adapter=adapter
        }
        val items = listOf(
                Store("abc","111","111",33.33,33.33,"약국","plenty","33","33")
        )

    }


}