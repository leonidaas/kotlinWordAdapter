package com.example.android.miwok

/**
 * Created by fuessnle on 02.02.2018.
 */
class Word (private var defaultTranslation: String, private var miwokTranslation: String) {

    fun getDefault() = defaultTranslation //gets the private defaultTranslation String
    fun getMiwok() = miwokTranslation //gets the private miwokTranslation String

}