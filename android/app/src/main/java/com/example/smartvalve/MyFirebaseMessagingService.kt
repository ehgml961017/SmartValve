package com.example.smartvalve
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("testLog", "refreshed token: $token")
    }

    override fun onMessageReceived(remoteMessage : RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.i("testLog", "message received")
        Log.i("testLog", "${remoteMessage.messageType}")
        if(remoteMessage.data.size > 0){
            Log.i("testLog", "msg data : ${remoteMessage.data}")

            if(true){
            } else{
                handleNow();
            }

            if(remoteMessage.notification != null){
                Log.i("testLog", "msg notificationn Title : ${remoteMessage.notification!!.title}")
                Log.i("testLog", "msg notificationn body : ${remoteMessage.notification!!.body}")
            }
        } else{
            Log.i("testLog", "size?")
        }

        // push 메세지가 왔을때, 자동으로 밸브가 잠김 (어플 실행중일때만 실행됨)
        Thread(){
            valveoff()
        }.start()
    }

    private fun handleNow() {
        Log.i("testLog", "short lived task is done.")
    }

    private fun valveoff(){
        var fcmNum = 0
        var url = URL("${JSON_URL}/query")
        var conn = url.openConnection() as HttpURLConnection
        Log.i("testLog", "conn.responseCode : ${conn.responseCode}")

        if (conn.responseCode == 200) {
            val txt = url.readText()
            val arr = JSONArray(txt)
            var item = arr.get(0) as JSONObject
            fcmNum = item["num"].toString().toInt()
        }
        var res:String = "${JSON_URL}/offSw1?num=${fcmNum}&sw1=${valveStatus}&sw2=${knobStatus}"
        Log.i("FCMLOG", "${JSON_URL}/offSw1?num=${fcmNum}&sw1=${valveStatus}&sw2=${knobStatus}")
        url = URL(res)
        Log.i("urlLog", "$res")
        conn = url.openConnection() as HttpURLConnection
        Log.i("urlLog", "conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            Log.i("urlLog", "valve Off")
        } else Log.i("urlLog", "fail")
    }
}