package com.example.recycleview

import android.content.Context
import android.graphics.drawable.Drawable

object Utils {
    fun getDrawable(context:Context, gender: String?): Drawable? {
        val target = "nam"
        return if (gender?.lowercase()?.compareTo(target) == 0){
            context.resources.getDrawable(R.drawable.baseline_man_24);
            } else{
                context.resources.getDrawable(R.drawable.baseline_woman_24);
            }
    }
}