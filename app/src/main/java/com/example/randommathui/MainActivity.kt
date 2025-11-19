package com.example.randommathui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.randommathui.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.random.Random

abstract class MathPos {
    abstract fun mathPosAdd(a: Int, b: Int): Int
    abstract fun mathPosSub(a: Int, b: Int): Int
    abstract fun mathPosMul(a: Int, b: Int): Int
    abstract fun mathPosDiv(a: Int, b: Int): Int
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    val math = object: MathPos() {

        override fun mathPosAdd(a: Int, b: Int): Int {

            val answers = listOf(a, b)

            println("A: $a = ${a in answers}")
            println("B: $b = ${b in answers}")

            return answers.first() + answers.last()
        }

        override fun mathPosSub(a: Int, b: Int): Int {

            val answers = listOf(a, b)

            println("A: $a = ${a in answers}")
            println("B: $b = ${b in answers}")

            return answers.first() - answers.last()

        }

        override fun mathPosMul(a: Int, b: Int): Int {

            return a * b

            val answers = listOf(a, b)

            println("A: $a = ${a in answers}")
            println("B: $b = ${b in answers}")

            return answers.first() * answers.last()
        }

        override fun mathPosDiv(a: Int, b: Int): Int {

            if (b == 0) {
                return 0
            }

            val answers = listOf(a, b)

            println("A: $a = ${a in answers}")
            println("B: $b = ${b in answers}")

            return answers.first() / answers.last()
        }

    }

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

        binding.textAnswer.width = math.mathPosMul(500, 3)
        binding.addButton.width = math.mathPosDiv( 1200, 2)
        binding.buttonNone.width = math.mathPosDiv(1200, 2)
        binding.correctNumBtn.width = math.mathPosDiv(1200, 2)
        binding.addNumbers.textSize = math.mathPosMul(11, 2).toFloat()
        binding.correctNumBtn.text = "Check Answer"

        binding.textAnswer.width =  math.mathPosMul(200, 2)

        binding.buttonBtn.setOnClickListener {

            binding.buttonBtn.visibility = View.VISIBLE
            binding.addButton.visibility = View.VISIBLE
            binding.buttonNone.visibility = View.INVISIBLE
            binding.textAnswer2.visibility = View.VISIBLE
            binding.subButton.visibility = View.VISIBLE
            binding.backButton.visibility = View.INVISIBLE

            binding.addButton.text = "+"
            binding.subButton.text = "-"
            binding.subButton.width = math.mathPosDiv(1300, 2)


            binding.addButton.setOnClickListener {


                binding.addNumbers.text = "$num1  +  $num2"
                binding.addNumbers.textSize = math.mathPosDiv(40, 2).toFloat()
                binding.buttonNone.visibility = View.INVISIBLE

                binding.addButton.visibility = View.INVISIBLE
                binding.correctNumBtn.visibility = View.VISIBLE
                binding.textAnswer.visibility = View.VISIBLE
                binding.subButton.visibility = View.INVISIBLE
                binding.textSubText.visibility = View.INVISIBLE
                binding.correctNumBtn2.visibility = View.INVISIBLE
                binding.backButton.visibility = View.INVISIBLE


                binding.correctNumBtn.setOnClickListener {

                    val numAdd = math.mathPosAdd(num1, num2)
                    if (binding.textAnswer.text.toString().toInt() == numAdd) {
                        binding.correctNumBtn.text = "Correct"
                    }

                }

            }

            binding.subButton.setOnClickListener {

                binding.correctNumBtn2.text = "-"
                binding.textSubText.text = "$num1 - $num2"
                binding.textSubText.textSize = math.mathPosMul(11, 2).toFloat()
                binding.buttonBtn.visibility = View.INVISIBLE
                binding.textAnswer2.visibility = View.VISIBLE
                binding.addButton.visibility = View.INVISIBLE
                binding.subButton.visibility = View.INVISIBLE
                binding.correctNumBtn.visibility = View.INVISIBLE
                binding.correctNumBtn2.visibility = View.VISIBLE
                binding.backButton.visibility = View.INVISIBLE
                val numSub = abs(math.mathPosSub(num1, num2))
                binding.textAnswer2.width = math.mathPosMul(200, 2)
                binding.correctNumBtn2.width = math.mathPosMul(400, 2)

                binding.correctNumBtn2.setOnClickListener {

                    if (binding.textAnswer2.text.toString().toInt() == numSub) {

                        binding.correctNumBtn2.text = "Correct"
                        binding.correctNumBtn2.visibility = View.INVISIBLE

                        binding.backButton.width = math.mathPosDiv(1300, 2)
                        binding.backButton.visibility = View.VISIBLE
                        binding.backButton.text = "Go Back"
                    }


                }

            }

        }

    }
}