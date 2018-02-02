package com.example.android.miwok

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by fuessnle on 02.02.2018.
 */
class WordAdapter (context: Activity, words: ArrayList<Word>) : ArrayAdapter<Word>(context, 0, words) {


    @Override
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var currentWord: Word = getItem(position)

        var listItemView: View? = convertView

        if(listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false )
        }


        val view = listItemView?.findViewById(R.id.miwok_text_view) as TextView

        view.text = currentWord.getMiwok()

        val view2 = listItemView?.findViewById(R.id.default_text_view) as TextView

        view2.text = currentWord.getDefault()


        return listItemView
    }
}