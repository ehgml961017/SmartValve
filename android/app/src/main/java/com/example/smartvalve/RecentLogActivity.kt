package com.example.smartvalve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_recent_log.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL


class RecentLogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_log)
    }

    override fun onResume() {
        super.onResume()

        var listItem:ArrayList<LogVO> = arrayListOf()

        Thread(){
            ReadDB(listItem)

            runOnUiThread {
                val header:View = layoutInflater.inflate(R.layout.layout_list_header,null)
                log_list.addHeaderView(header)
                log_list.adapter = LogAdapter(this, R.layout.layout_list, listItem)
            }
        }.start()

        Log.i("testLog", "view create")
    }

    fun ReadDB(listItem:ArrayList<LogVO>) {
        val url = URL("${SERVER_URL}/query")//요청
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("testLog", "conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            val txt = url.readText()
            val arr = JSONArray(txt)

            // If the log's start is null, log will print the next one.
            var startNull = false
            for(i in 0..arr.length()-1){
                Log.i("logDEBUG", "idx : $i")
                if(!startNull && i == arr.length()-1) continue
                var obj:JSONObject = arr.get(i) as JSONObject
                if(i == 0 && obj["on_sw1"].equals(null) && obj["off_sw1"].equals(null)){
                    // 시작이 null인 경우 -> 1~10까지 들어감
                    // 시작이 null이 아닌 경우 -> 0~9까지 들어감
                    startNull = true
                    continue
                }
                var valve = if(obj["sw1"] == ON) "열림" else "닫힘"
                var knob = if(obj["sw2"] == ON) "열림" else "닫힘"
                var onTime:String = if(obj["on_sw1"].equals(null)) "시간 정보 없음" else{
                    var tmp = obj["on_sw1"].toString()
                    tmp = tmp.substring(0,4) + "/" + tmp.substring(5,7) + "/" + tmp.substring(8,10) + "\n" + tmp.substring(11, 19)
                    tmp
                }
                var offTime = if(obj["off_sw1"].equals(null)) "시간 정보 없음" else{
                    var tmp = obj["off_sw1"].toString()
                    tmp = tmp.substring(0,4) + "/" + tmp.substring(5,7) + "/" + tmp.substring(8,10) + "\n" + tmp.substring(11, 19)
                    tmp
                }

                listItem.add(LogVO(i, valve, knob, onTime, offTime))
            }
        } else {
            Toast.makeText(this, "서버에 접속할수없습니다.", Toast.LENGTH_LONG).show()
        }
    }



}