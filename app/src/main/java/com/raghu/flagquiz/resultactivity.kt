package com.raghu.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.TextView

class resultactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultactivity)

        val tvname:TextView=findViewById(R.id.tv_name)
        val tvscore:TextView=findViewById(R.id.score)
        val finishbutton:Button=findViewById(R.id.finishbutton)

        tvname.text=intent.getStringExtra(constants.USER_NAME)
        val tq=intent.getIntExtra(constants.TOTAL_QUESTIONS,0)
        val cans=intent.getIntExtra(constants.CORRECT_ANSWERS,0)

        tvscore.text ="Your Score is $cans out of $tq"
        finishbutton.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }




    }
}