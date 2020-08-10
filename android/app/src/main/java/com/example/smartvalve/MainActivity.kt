package com.example.smartvalve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

val ON:Int = 1
val OFF:Int = 0
var SERVER_URL = "http://192.168.0.90:8085"
var knobStatus:Int = OFF
var valveStatus:Int = OFF
var num = 0; // top of list
var logRes = "null"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener(OnCompleteListener { task ->
            if(!task.isSuccessful){
                Log.i("testLog", "getInstanceId failed")
                return@OnCompleteListener
            }
            Log.i("testLog", "getInstanceId")
            val token = task.result?.token
            Log.i("testLog", "token : $token")
        })

        image_valve.setOnClickListener {
            Thread(){
                if(valveStatus == ON) valveOff()
                else valveOn()
            }.start()
        }
        image_knob.setOnClickListener {
            Thread(){
                if(knobStatus == ON) knobOff()
                else knobOn()
            }.start()
        }
    }

    override fun onResume() {
        super.onResume()
        // status check & event
        button_more.setOnClickListener {
            val intent = Intent(this, RecentLogActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        Thread(){
            CheckStatus()
        }.start()

        Thread(){
            UpdateMainLog()
        }.start()

    }

    // using polling, it connects to web server and request current valve & knob's status
    fun CheckStatus(){
        Log.i("testLog", "checkStatus")
        var timerTask:Timer? = kotlin.concurrent.timer(period = 500) {
            // connect to server
            val url = URL("${SERVER_URL}/query")
            val conn = url.openConnection() as HttpURLConnection // casting
            Log.i("testLog", "conn.responseCode : ${conn.responseCode}")

            if (conn.responseCode == 200) {
                Log.i("testLog", "response success")
                val txt = url.readText()
                val arr = JSONArray(txt)
                var item = arr.get(0) as JSONObject
                knobStatus = item["sw2"].toString().toInt()
                valveStatus = item["sw1"].toString().toInt()
            } else {
                Log.i("testLog", "response fail")
            }

            // show status using image's color
            if (knobStatus == ON) {
                Log.i("testLog", "knob on")
                image_knob.setImageResource(R.drawable.fire_on)
            } else {
                Log.i("testLog", "knob off")
                image_knob.setImageResource(R.drawable.fire_off)
            }
            if (valveStatus == ON) {
                Log.i("testLog", "valve on")
                image_valve.setImageResource(R.drawable.fire_on)
            } else {
                Log.i("testLog", "valve off")
                image_valve.setImageResource(R.drawable.fire_off)
            }
            Log.i("testLog", "num : $num")
        }
    }

    // using polling, it gets last log and shows in view
    fun UpdateMainLog(){
        val timerTask:Timer? = kotlin.concurrent.timer(period = 1500){
            val url = URL("${SERVER_URL}/query")
            val conn = url.openConnection() as HttpURLConnection // casting
            Log.i("testLog", "conn.responseCode : ${conn.responseCode}")

            if(conn.responseCode == 200){
                val txt = url.readText()
                val arr = JSONArray(txt)
                var item = arr.get(0) as JSONObject
                var item2 = arr.get(1) as JSONObject
                if(item["on_sw1"].equals(null)) logRes = "${item2["on_sw1"]}"
                else logRes = "${item["on_sw1"]}"
                Log.i("text", "res : ${logRes}")
                num = "${item["num"]}".toInt()
            } else logRes = "null"

            runOnUiThread {
                if(!logRes.equals("null")){
                    log_main_body.text = logRes.substring(0,4) + "/" + logRes.substring(5,7) + "/" + logRes.substring(8,10) + " " + logRes.substring(11, 19)
                } else log_main_body.text = "No data"
            }
        }
        Log.i("text", "res2 : ${logRes}")
    }

    fun valveOn(){
        var reqUrl = getSwitchControlUrl("onSw1")
        val url = URL(reqUrl)
        Log.i("urlLog", "$reqUrl")
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("urlLog", "conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            Log.i("urlLog", "valveOn")
        } else Log.i("urlLog", "fail")
    }
    fun valveOff(){
        var reqUrl = getSwitchControlUrl("offSw1")
        val url = URL(reqUrl)
        Log.i("urlLog", "$reqUrl")
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("urlLog", "conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            Log.i("urlLog", "valve Off")
        } else Log.i("urlLog", "fail")
    }
    fun knobOn(){
        var reqUrl = getSwitchControlUrl("onSw2")
        val url = URL(reqUrl)
        Log.i("urlLog", "$reqUrl")
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("urlLog", "conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            Log.i("urlLog", "knob on")
        } else Log.i("urlLog", "fail")
    }
    fun knobOff(){
        var reqUrl = getSwitchControlUrl("offSw2")
        val url = URL(reqUrl)
        val conn = url.openConnection() as HttpURLConnection // casting


        Log.i("urlLog", "conn.responseCode : ${conn.responseCode}")
        if(conn.responseCode == 200){
            Log.i("urlLog", "knob off")
        } else Log.i("urlLog", "fail")
    }

    fun getSwitchControlUrl(tmp:String):String{
        return "${SERVER_URL}/${tmp}?num=${num}&sw1=${valveStatus}&sw2=${knobStatus}"
    }



}