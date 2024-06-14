package br.com.fiap.challenge

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import br.com.fiap.challenge.activitys.CalendarActivity


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.post {
            startActivity(Intent(this, CalendarActivity::class.java))
            window.decorView.postDelayed({
                finish()
            }, 500)
        }
    }
}


