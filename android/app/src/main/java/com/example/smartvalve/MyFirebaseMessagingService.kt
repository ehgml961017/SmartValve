package com.example.smartvalve
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("testLog", "refreshed token: $token")
//        Toast.makeText(this, "$token", Toast.LENGTH_SHORT).show()
    }

    override fun onMessageReceived(remoteMessage : RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.i("testLog", "message received")
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
        }

    }

    private fun handleNow() {
        Log.i("testLog", "short lived task is done.")
    }
}