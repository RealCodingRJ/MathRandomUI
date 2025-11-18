package com.example.randommathui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.randommathui.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val num1 = Random.nextInt(1, 12)
    val num2 = Random.nextInt(1, 10)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textSubText.text = "| Welcome to Math Randomize Solver |"

        binding.buttonBtn.text = "What Option Do you Want: + - * /"
        binding.addButton.visibility = View.INVISIBLE
        binding.buttonNone.visibility = View.INVISIBLE
        binding.correctNumBtn.visibility = View.INVISIBLE
        binding.textAnswer.visibility = View.INVISIBLE
        binding.subButton.visibility = View.INVISIBLE
        binding.textSubText.visibility = View.VISIBLE
        binding.correctNumBtn2.visibility = View.INVISIBLE
        binding.backButton.visibility = View.INVISIBLE

        binding.textAnswer.width = 500 * 3
        binding.addButton.width = 1200 / 2
        binding.buttonNone.width = 1200 / 2
        binding.correctNumBtn.width = 1200 / 2
        binding.addNumbers.textSize = 11f * 2f
        binding.correctNumBtn.text = "Check Answer"

        binding.textAnswer.width = 200 * 2

        binding.buttonBtn.setOnClickListener {

            binding.buttonBtn.visibility = View.VISIBLE
            binding.addButton.visibility = View.VISIBLE
            binding.buttonNone.visibility = View.INVISIBLE
            binding.textAnswer2.visibility = View.VISIBLE
            binding.subButton.visibility = View.VISIBLE
            binding.backButton.visibility = View.INVISIBLE

            binding.addButton.text = "+"
            binding.subButton.text = "-"
            binding.subButton.width = 1300 / 2


            binding.addButton.setOnClickListener {


                binding.addNumbers.text = "$num1  +  $num2"
                binding.addNumbers.textSize = 40f / 2f
                binding.buttonNone.visibility = View.INVISIBLE

                binding.addButton.visibility = View.INVISIBLE
                binding.correctNumBtn.visibility = View.VISIBLE
                binding.textAnswer.visibility = View.VISIBLE
                binding.subButton.visibility = View.INVISIBLE
                binding.textSubText.visibility = View.INVISIBLE
                binding.correctNumBtn2.visibility = View.INVISIBLE
                binding.backButton.visibility = View.INVISIBLE


                binding.correctNumBtn.setOnClickListener {

                    val numAdd = num1 + num2
                    if (binding.textAnswer.text.toString().toInt() == numAdd) {
                        binding.correctNumBtn.text = "Correct"
                    }

                }

            }

            binding.subButton.setOnClickListener {

                binding.correctNumBtn2.text = "-"
                binding.textSubText.text = "$num1 - $num2"
                binding.textSubText.textSize = 11f * 2f
                binding.buttonBtn.visibility = View.INVISIBLE
                binding.textAnswer2.visibility = View.VISIBLE
                binding.addButton.visibility = View.INVISIBLE
                binding.subButton.visibility = View.INVISIBLE
                binding.correctNumBtn.visibility = View.INVISIBLE
                binding.correctNumBtn2.visibility = View.VISIBLE
                binding.backButton.visibility = View.INVISIBLE
                val numSub = abs(num1 - num2)
                binding.textAnswer2.width = 200 * 2
                binding.correctNumBtn2.width = 400 * 2

                binding.correctNumBtn2.setOnClickListener {

                    if (binding.textAnswer2.text.toString().toInt() == numSub) {

                        binding.correctNumBtn2.text = "Correct"
                        binding.correctNumBtn2.visibility = View.INVISIBLE

                        binding.backButton.width = 1300 / 2
                        binding.backButton.visibility = View.VISIBLE
                        binding.backButton.text = "Go Back"
                    }


                }

            }

        }

    }
}