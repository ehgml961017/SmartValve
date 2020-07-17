package com.example.smartvalve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

val ON:Int = 1
val OFF:Int = 0

class MainActivity : AppCompatActivity() {
    var burningStatus:Int = OFF
    var valveStatus:Int = OFF
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        button_more.setOnClickListener {
            val intent = Intent(this, RecentLogActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        //
        Thread(){
            test()
        }.start()

        text_burning.setOnClickListener {
            Log.i("testLog", "burning text clicked")
            if(burningStatus == ON) burningStatus = OFF
            else burningStatus = ON
        }

        text_valve.setOnClickListener {
            Log.i("testLog", "valve text clicked")
            if(valveStatus == ON) valveStatus = OFF
            else valveStatus = ON
        }

        // status check
        /*
        * We need to regular check for DB
        * if status change, image will change using checkStatus()
        * checkStatus()
        * */
        checkStatus()

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

    fun checkStatus(){
        if(burningStatus == ON){
            image_burning.setImageResource(R.drawable.fire_on)
        } else{
            image_burning.setImageResource(R.drawable.fire_off)
        }
        if(valveStatus == ON){
            image_valve.setImageResource(R.drawable.fire_on)
        } else{
            image_valve.setImageResource(R.drawable.fire_off)
        }
    }
}