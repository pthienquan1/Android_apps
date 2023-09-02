package com.example.chuong2_tuhoc_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chuong2_tuhoc_1.databinding.TipTimeBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: TipTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TipTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {
            calculateTip()
        }


//        val rollButton: Button = findViewById(R.id.btn1)
//        rollButton.setOnClickListener {
//            rollDice()
//        }
//        rollDice()
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble();
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedId){
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage*cost;
        val roundUp = binding.roundUpSwitch.isChecked
        if(roundUp){
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
//
//    private fun rollDice() {
//        val diceRoll = Dice(6).rollDice();
//        val diceImage: ImageView = findViewById(R.id.imageView);
//        val drawableResource = when (diceRoll) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        }
//
//        diceImage.setImageResource(drawableResource)
//        diceImage.contentDescription = diceRoll.toString()
//    }
}