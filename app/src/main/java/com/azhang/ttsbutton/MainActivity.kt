package com.azhang.ttsbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var inputText : EditText
    lateinit var button : Button
    lateinit var tts : TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById<EditText>(R.id.inputText)
        button = findViewById<Button>(R.id.button)
        tts = TextToSpeech(this, this)
    }

    override fun onInit(status: Int) {
        button.setOnClickListener { speak() }
    }

    private fun speak() {
        tts.speak(inputText.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "")
    }
}