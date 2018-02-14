package com.example.android.miwok

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by fuessnle on 09.02.2018.
 */
open class MediaPlayerActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null

    var audioManager: AudioManager? = null

    var audioFocusChangeListener = AudioManager.OnAudioFocusChangeListener() {

         @Override
         fun onAudioFocusChange(focusChange: Int) {

             if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                 mediaPlayer?.pause()
                 mediaPlayer?.seekTo(0)
             } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                 mediaPlayer?.start()
             } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                 releaseMediaPlayer()
             }

         }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
        releaseMediaPlayer()
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
    }

    fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null

        audioManager?.abandonAudioFocus(audioFocusChangeListener)
    }

    fun playSoundFile(id: Int) {
        mediaPlayer?.stop()
        releaseMediaPlayer()
        val result: Int? = audioManager?.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
        if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mediaPlayer = MediaPlayer.create(this, id).apply {
                start()
            }
        }

        mediaPlayer?.setOnCompletionListener {
            releaseMediaPlayer()
        }
    }


}