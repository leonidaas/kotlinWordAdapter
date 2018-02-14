package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.word_list.*


class NumbersActivity : MediaPlayerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        val words: ArrayList<Word> = ArrayList()




        words.add(Word(R.drawable.number_one, "one", "lutti", R.raw.number_one))
        words.add(Word(R.drawable.number_two, "two", "ottiko", R.raw.number_two))
        words.add(Word(R.drawable.number_three, "three", "tolookosu", R.raw.number_three))
        words.add(Word(R.drawable.number_four, "four", "oyyisa", R.raw.number_four))
        words.add(Word(R.drawable.number_five, "five", "massokka", R.raw.number_five))
        words.add(Word(R.drawable.number_six, "six", "temmokka", R.raw.number_six))
        words.add(Word(R.drawable.number_seven, "seven", "kenekaku", R.raw.number_seven))
        words.add(Word(R.drawable.number_eight, "eight", "kawinta", R.raw.number_eight))
        words.add(Word(R.drawable.number_nine, "nine", "wo'e", R.raw.number_nine))
        words.add(Word(R.drawable.number_ten, "ten", "na'aacha", R.raw.number_ten))

        val adapter = WordAdapter(this, words, R.color.category_numbers)

        list.adapter = adapter

        adapter.onItemClickListener = { // um es abzuspielen um mit dem lifecycle arbeiten zu können
            this.playSoundFile(it.getAudio())
        }




    }


}
