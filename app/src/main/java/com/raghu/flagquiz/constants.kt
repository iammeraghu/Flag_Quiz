package com.raghu.flagquiz

object constants {

    const val USER_NAME :String="user_name"
    const val TOTAL_QUESTIONS :String ="total_questions"
    const val CORRECT_ANSWERS :String ="correct_answers"

    fun getquestions():ArrayList<Question>
    {
        val questionlist=ArrayList<Question>()

        val q1=Question(
            1,"What Country Does this flag Belong To?",
            R.drawable.`in`,"India","Germany","Russia","USA",1)
        questionlist.add(q1)

        val q2=Question(
            2,"What Country Does this flag Belong To?",
            R.drawable.`france`,"India","Germany","France","Russia",3)
        questionlist.add(q2)

        val q3=Question(
            3,"What Country Does this flag Belong To?",
            R.drawable.`ger`,"India","Germany","Russia","USA",2)
        questionlist.add(q3)

        val q4=Question(
            4,"What Country Does this flag Belong To?",
            R.drawable.`nz`,"NewZeland","Bangladesh","Russia","France",1)
        questionlist.add(q4)
        val q5=Question(
            5,"What Country Does this flag Belong To?",
            R.drawable.`russia`,"India","Germany","Germany","Russia",4)
        questionlist.add(q5)
        val q6=Question(
            6,"What Country Does this flag Belong To?",
            R.drawable.`safrica`,"S.Africa","India","Russia","None of These",1)
        questionlist.add(q6)
        val q7=Question(
            7,"What Country Does this flag Belong To?",
            R.drawable.`ukingdom`,"India","U.kingdom","S.Lanka","USA",2)
        questionlist.add(q7)

        val q8=Question(
            8,"What Country Does this flag Belong To?",
            R.drawable.`usa`,"USA","New Zeland","Germany","Russia",1)
        questionlist.add(q8)

        return questionlist





    }
}