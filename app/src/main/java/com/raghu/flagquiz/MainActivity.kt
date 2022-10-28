package com.raghu.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnstart: Button = findViewById(R.id.start)
        val etname: EditText = findViewById(R.id.enteredname)
        btnstart.setOnClickListener {
            if (etname.text.isEmpty())
            {
                Toast.makeText(this, "please enter your name to continue", Toast.LENGTH_LONG).show()


            }
            else
            {
                val intt = Intent(this, quizquestionactivity::class.java)

                intt.putExtra(constants.USER_NAME, etname.text.toString())


                startActivity(intt)
                finish()

            }
        }
    }
}