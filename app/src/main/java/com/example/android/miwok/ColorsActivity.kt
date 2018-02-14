package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.word_list.*


class ColorsActivity : MediaPlayerActivity() { //überall anders auch noch erben

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        val words: ArrayList<Word> = ArrayList()


        words.add(Word(R.drawable.color_red, "red", "weṭeṭṭi", R.raw.color_red))

        words.add(Word(R.drawable.color_green, "green", "chokokki", R.raw.color_green))
        words.add(Word(R.drawable.color_brown, "brown", "ṭakaakki", R.raw.color_brown))
        words.add(Word(R.drawable.color_gray, "gray", "ṭopoppi", R.raw.color_gray))
        words.add(Word(R.drawable.color_black, "black", "kululli", R.raw.color_black))
        words.add(Word(R.drawable.color_white, "white", "kelelli", R.raw.color_white))
        words.add(Word(R.drawable.color_dusty_yellow, "dusty yellow", "ṭopiisә", R.raw.color_dusty_yellow))
        words.add(Word(R.drawable.color_mustard_yellow, "mustard yellow", "chiwiiṭә", R.raw.color_mustard_yellow))

        val adapter = WordAdapter(this, words, R.color.category_colors)

        list.adapter = adapter

        adapter.onItemClickListener = { // um es abzuspielen um mit dem lifecycle arbeiten zu können
            this.playSoundFile(it.getAudio())
        }

    }
}
