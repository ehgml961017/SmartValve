package com.example.smartvalve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        Thread(){
            test()
        }.start()
    }

    override fun onResume() {
        super.onResume()
        button_more.setOnClickListener {
            val intent = Intent(this, RecentLogActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }


    }

    fun test(){
        // url connection & data parsing
        val url = URL("http://192.168.0.90:8080/hello/dto")
        var conn = url.openConnection() as HttpURLConnection
        Log.i("testLog", "connection : ${conn.responseCode}")

        if(conn.responseCode == 200){
            Log.i("testLog", "connection success")
            val msg = url.readText()
            val testJson = JSONObject(msg)
            Log.i("testLog", "${testJson}")
            val jsonobjTest = testJson.getInt("amount")
            Log.i("testLog", "${jsonobjTest}")
        } else{
            Log.i("testLog", "connection fail")
        }
    }
}