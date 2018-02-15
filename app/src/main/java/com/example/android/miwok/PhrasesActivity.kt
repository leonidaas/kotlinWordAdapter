package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import kotlinx.android.synthetic.main.word_list.*


class PhrasesActivity : MediaPlayerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)
        //actionBar.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val words: ArrayList<Word> = ArrayList()


        words.add(Word(null, "Where are you going", "minto wuksus", R.raw.phrase_where_are_you_going))

        words.add(Word(null, "What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name))
        words.add(Word(null, "My name is...", "oyaaset...", R.raw.phrase_my_name_is))
        words.add(Word(null, "How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling))
        words.add(Word(null,"I’m feeling good", "kuchi achit?", R.raw.phrase_im_feeling_good))
        words.add(Word(null,"Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming))
        words.add(Word(null,"Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming))
        words.add(Word(null,"I’m coming.", "әәnәm", R.raw.phrase_im_coming))
        words.add(Word(null,"Let’s go.", "yoowutis", R.raw.phrase_lets_go))
        words.add(Word(null,"Come here.", "әnni'nem", R.raw.phrase_come_here))

        val adapter = WordAdapter(this, words, R.color.category_phrases)

        list.adapter = adapter

        adapter.onItemClickListener = { // um es abzuspielen um mit dem lifecycle arbeiten zu können
            this.playSoundFile(it.getAudio())
        }

    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this); return true }
        }
        return super.onOptionsItemSelected(item)
    }
}

