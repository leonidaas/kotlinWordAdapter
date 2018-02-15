package com.example.android.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import kotlinx.android.synthetic.main.word_list.*

class FamilyActivity : MediaPlayerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)
        //actionBar.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val words: ArrayList<Word> = ArrayList()


        words.add(Word(R.drawable.family_father,"father", "әpә", R.raw.family_father))
        words.add(Word(R.drawable.family_mother, "mother", "әṭa", R.raw.family_mother))
        words.add(Word(R.drawable.family_son,"son", "angsi", R.raw.family_son))
        words.add(Word(R.drawable.family_daughter,"daughter", "tune", R.raw.family_daughter))
        words.add(Word(R.drawable.family_older_brother,"older brother", "taachi", R.raw.family_older_brother))
        words.add(Word(R.drawable.family_younger_brother, "younger brother", "chalitti", R.raw.family_younger_brother))
        words.add(Word(R.drawable.family_older_sister, "older sister", "teṭe", R.raw.family_older_sister))
        words.add(Word(R.drawable.family_younger_sister, "younger sister", "kolliti", R.raw.family_younger_sister))
        words.add(Word(R.drawable.family_grandmother, "grandmother", "ama", R.raw.family_grandmother))
        words.add(Word(R.drawable.family_grandfather, "grandfather", "paapa", R.raw.family_grandfather))

        val adapter = WordAdapter(this, words, R.color.category_family)

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
