package com.walker.modulo3aula2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import com.walker.modulo3aula2.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TOTAL_ROLLS = 5

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this, R.anim.choosen_side)

        binding.rollButton.setOnClickListener {
            lifecycleScope.launch {
                for (i in 0 until TOTAL_ROLLS) {
                    delay(100)
                    val random = Dice(6).roll()
                    binding.resultValue.setImageResource(chooseDiceImage(random))

                    if (i == TOTAL_ROLLS - 1) {
                        binding.resultValue.startAnimation(animation)
                    }

                }
            }
        }
    }

    private fun chooseDiceImage(result: Int): Int {
        return when (result) {
            1 -> R.mipmap.dice_1
            2 -> R.mipmap.dice_2
            3 -> R.mipmap.dice_3
            4 -> R.mipmap.dice_4
            5 -> R.mipmap.dice_5
            else -> R.mipmap.dice_6
        }
    }
}