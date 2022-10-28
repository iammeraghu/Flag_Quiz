package com.raghu.flagquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.raghu.flagquiz.constants.CORRECT_ANSWERS

class quizquestionactivity : AppCompatActivity(), View.OnClickListener {
    private var mcurrentposition: Int = 1
    private var mquestionlist: ArrayList<Question>? = null
    private var mselectedoptionposition: Int = 0
    private var pbaar: ProgressBar? = null
    private var tvprogress: TextView? = null
    private var tvquestion: TextView? = null
    private var image: ImageView? = null
    private var optionxtwo: TextView? = null
    private var optionxone: TextView? = null
    private var optionxthree: TextView? = null
    private var optionxfour: TextView? = null
    private var submitbutton: Button? = null
    private var musername:String?=null
    private var mcorrectanswers:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestionactivity)

        musername=intent.getStringExtra(constants.USER_NAME)
        pbaar = findViewById(R.id.pbar)
        tvprogress = findViewById(R.id.progresstext)
        tvquestion = findViewById(R.id.qn)
        image = findViewById(R.id.flagimage)
        optionxone = findViewById(R.id.option1)
        optionxtwo = findViewById(R.id.option2)
        optionxthree = findViewById(R.id.option3)
        optionxfour = findViewById(R.id.option4)
        submitbutton = findViewById(R.id.submit)




        mquestionlist = constants.getquestions()
        setqustion()
        optionxone?.setOnClickListener(this)
        optionxtwo?.setOnClickListener(this)
        optionxthree?.setOnClickListener(this)
        optionxfour?.setOnClickListener(this)
        submitbutton?.setOnClickListener(this)


    }

    private fun setqustion() {



        defaultoptionsview()
        val qnn: Question = mquestionlist!![mcurrentposition - 1]
        pbaar?.progress = mcurrentposition
        image?.setImageResource(qnn.image)
        tvprogress?.text = "$mcurrentposition/${pbaar?.max}"
        tvquestion?.text = qnn.qn
        optionxone?.text = qnn.optionone
        optionxtwo?.text = qnn.optiontwo
        optionxthree?.text = qnn.optionthree
        optionxfour?.text = qnn.optionfour



        if (mcurrentposition == mquestionlist!!.size) {
            submitbutton?.text = "FINISH"

        } else {
            submitbutton?.text = "SUBMIT"
        }

    }

    private fun defaultoptionsview() {
        val options = ArrayList<TextView>()
        optionxone?.let {
            options.add(0, it)
        }


        optionxtwo?.let {
            options.add(1, it)
        }

        optionxthree?.let {
            options.add(2, it)
        }
        optionxfour?.let {
            options.add(3, it)
        }
        for (opt in options) {
            opt.setTextColor(Color.parseColor("#7a8089"))
            opt.typeface = Typeface.DEFAULT
            opt.background = ContextCompat.getDrawable(
                this, R.drawable.optionborder

            )

        }

    }

    private fun selectedoptionsview(tv: TextView, selectedoptionsnum: Int) {

        mselectedoptionposition = selectedoptionsnum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selectedoptionbg

        )
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option1 -> {
                optionxone?.let {
                    selectedoptionsview(it, 1)
                }
            }
            R.id.option2 -> {
                optionxtwo?.let {
                    selectedoptionsview(it, 2)
                }
            }
            R.id.option3 -> {
                optionxthree?.let {
                    selectedoptionsview(it, 3)
                }
            }
            R.id.option4 -> {
                optionxfour?.let {
                    selectedoptionsview(it, 4)
                }
            }
            R.id.submit -> {

                if (mselectedoptionposition == 0) {
                    mcurrentposition++

                    when {
                        mcurrentposition <= mquestionlist!!.size -> {
                            setqustion()

                        }
                        else -> {
                            Toast.makeText(this, "Congrats,You Made it to last", Toast.LENGTH_LONG)
                                .show()


                            val intent = Intent(this, resultactivity::class.java)
                            intent.putExtra(constants.USER_NAME, musername)
                            intent.putExtra(constants.CORRECT_ANSWERS, mcorrectanswers)
                            intent.putExtra(constants.TOTAL_QUESTIONS, mquestionlist?.size)
                            startActivity(intent)
                            finish()

                        }
                    }


                } else {
                    val question = mquestionlist?.get(mcurrentposition - 1)
                    if (question!!.correctanswer != mselectedoptionposition) {
                        answerview(mselectedoptionposition, R.drawable.wrongoptionborder)

                    } else {
                        mcorrectanswers++
                    }
                    answerview(question.correctanswer, R.drawable.correctoptionborder)
                    if (mcurrentposition == mquestionlist!!.size) {
                        submitbutton?.text = "FINISH"
                    } else {
                        submitbutton?.text = "GOTO NEXT QUESTION"
                    }

                    mselectedoptionposition = 0

                }

            }
        }
    }


    private fun answerview(answer: Int, drawableView: Int)
    {


        when (answer) {

            1 ->
            {
                optionxone?.background=ContextCompat.getDrawable(
                    this@quizquestionactivity,drawableView
                )

        }
            2 ->
            {
                optionxtwo?.background=ContextCompat.getDrawable(
                    this@quizquestionactivity,drawableView
                )

            }
            3 ->
            {
                optionxthree?.background=ContextCompat.getDrawable(
                    this@quizquestionactivity,drawableView
                )

            }
            4 ->
            {
                optionxfour?.background=ContextCompat.getDrawable(
                    this@quizquestionactivity,drawableView
                )

            }
    }
}
}




