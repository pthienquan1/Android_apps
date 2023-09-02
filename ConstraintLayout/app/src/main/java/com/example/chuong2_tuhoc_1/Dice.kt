package com.example.chuong2_tuhoc_1

class Dice(val numSide:Int) {
    fun rollDice(): Int{
        return (1..numSide).random();
    }
}