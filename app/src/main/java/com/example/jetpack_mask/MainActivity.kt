package com.example.jetpack_mask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_mask.model.Store
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recycler_view.layoutManager = LinearLayoutManager(this,
//            RecyclerView.VERTICAL,false)
//        recycler_view.adapter = adapter

        val storeAdapter = StoreAdapter()
        recycler_view.apply{
            layoutManager = LinearLayoutManager(this@MainActivity,
            RecyclerView.VERTICAL,false)
            this.adapter=storeAdapter
        }

        viewModel.apply {
            itemLiveData.observe(this@MainActivity, Observer {
                storeAdapter.updateItems(it)

            })
            loadingLiveData.observe(this@MainActivity, Observer { loading ->
//                if(loading){
//                    progressBar.visibility = View.VISIBLE
//                }else{
//                    progressBar.visibility = View.GONE
//                }
                progressBar.visibility = if (loading) View.VISIBLE else View.GONE
            })
        }
    }

}