package com.example.android.miwok

/**
 * Created by fuessnle on 02.02.2018.
 */
data class Word (private var imageID: Int?, private var defaultTranslation: String, private var miwokTranslation: String, private var audioID: Int) {
    fun getImage() = imageID
    fun getAudio() = audioID
    fun getDefault() = defaultTranslation //gets the private defaultTranslation String
    fun getMiwok() = miwokTranslation //gets the private miwokTranslation String

}