package com.example.android.miwok

import android.app.Activity
import android.media.MediaPlayer
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

/**
 * Created by fuessnle on 02.02.2018.
 */
class WordAdapter (context: Activity, words: ArrayList<Word>, val colorBackground: Int) : ArrayAdapter<Word>(context, 0, words) {

    var onItemClickListener: ((Word) -> Unit)? = null

    @Override
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var currentWord: Word = getItem(position)

        var listItemView: View? = convertView

        if(listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false )
        }

        var text_container = listItemView?.findViewById(R.id.text_container) as LinearLayout
        val color: Int = ContextCompat.getColor(context, colorBackground)
        text_container.setBackgroundColor(color)


        val miwok_view = listItemView.findViewById(R.id.miwok_text_view) as TextView
        miwok_view.text = currentWord.getMiwok()

        val default_view = listItemView.findViewById(R.id.default_text_view) as TextView
        default_view.text = currentWord.getDefault()

        val image_view = listItemView.findViewById(R.id.image) as ImageView

        if(currentWord.getImage()!=null) {
            image_view.setImageResource(currentWord.getImage()!!)
        }
        else {
            image_view.visibility = View.GONE //this line could be removed because it doesnt have any impact
        }

        listItemView.setOnClickListener {
            onItemClickListener?.invoke(currentWord)
            Log.v("Current Activity", "Current Word" + currentWord.toString())
        }



        return listItemView
    }
}