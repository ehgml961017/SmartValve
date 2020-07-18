package com.example.smartvalve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_recent_log.*

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

        var listItem:ArrayList<LogVO> = arrayListOf()
        var log1 = LogVO(1, "닫힘", "닫힘", "2020/07/14\n14:37", "2020/07/14\n15:00")
        listItem.add(log1)
        val header:View = layoutInflater.inflate(R.layout.layout_list_header,null)

        log_list.addHeaderView(header)
        log_list.adapter = LogAdapter(this, R.layout.layout_list, listItem)
    }

    fun ConnectionDB(){

    }


}