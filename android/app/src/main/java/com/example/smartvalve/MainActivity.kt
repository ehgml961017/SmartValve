package com.example.smartvalve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

val ON:Int = 1
val OFF:Int = 0

class MainActivity : AppCompatActivity() {
    var knobStatus:Int = OFF
    var valveStatus:Int = OFF
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        // status check & event
        button_more.setOnClickListener {
            val intent = Intent(this, RecentLogActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        //
//        Thread(){
//            test()
//        }.start()

        image_knob.setOnClickListener {
            Log.i("testLog", "knob text clicked")
            if(knobStatus == ON) knobStatus = OFF
            else knobStatus = ON
        }

        image_valve.setOnClickListener {
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
        CheckStatus()

        Thread(){
            var tmp = UpdateMainLog()
            runOnUiThread{

                log_main_body.text = tmp.substring(0,4) + "/" + tmp.substring(5,7) + "/" + tmp.substring(8,10) + " " + tmp.substring(11, 19)
            }
        }.start()
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

    fun CheckStatus(){
        if(knobStatus == ON){
            image_knob.setImageResource(R.drawable.fire_on)
        } else{
            image_knob.setImageResource(R.drawable.fire_off)
        }
        if(valveStatus == ON){
            image_valve.setImageResource(R.drawable.fire_on)
        } else{
            image_valve.setImageResource(R.drawable.fire_off)
        }
    }

    fun UpdateMainLog():String{
        val url = URL("http://192.168.0.90:8080/query/")
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("testLog", "conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            val txt = url.readText()
            val arr = JSONArray(txt)
            var item = arr.get(0) as JSONObject
            return "${item["on_sw1"]}"
        } else return "null"
    }
}