package com.project.firstlab

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.project.firstlab.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var words = arrayOf<String>()

    private var currentWord = ""
    private var shuffledWord = ""
    private var index = 0
    private lateinit var counterTextView: TextView
    private lateinit var shuffledWordTextView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterTextView = binding.levelCounterTextView
        shuffledWordTextView = binding.shuffledWordTextView
        editText = binding.inputField
        button = binding.button

        words = this.resources.getStringArray(R.array.words).apply { shuffle() }
        nextWord()

        button.setOnClickListener {
            if(currentWord == editText.editableText.toString()){
                index++
                editText.editableText.clear()
                nextWord()
            }else{
                Toast.makeText(this, "ПОМИЛКА", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun nextWord(){
        currentWord = words[index]
        shuffledWord =  String(currentWord.toCharArray().apply { shuffle() })

        counterTextView.text = "рівень ${index + 1} з 10"
        shuffledWordTextView.text = shuffledWord
    }




}