package com.example.smartvalve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_recent_log.*

//private lateinit var listView: ListView
class RecentLogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_log)
    }

    override fun onResume() {
        super.onResume()
        Thread(){
            ConnectionDB()
        }.start()

        var listItem = arrayListOf<String>()
        val header:View = layoutInflater.inflate(R.layout.layout_list_header,null)

        log_list.addHeaderView(header)
        log_list.adapter = ArrayAdapter(this, R.layout.layout_list, listItem)
    }

    fun ConnectionDB(){

    }
}