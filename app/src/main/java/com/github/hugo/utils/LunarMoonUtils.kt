package com.github.hugo.utils

import timber.log.Timber

/**
 * @author 努尔江
 * Created on: 2023/5/5
 * @project hugo
 * Description:
 **/

class LunarMoonUtils {
    companion object {
/*        val year = 2017
        val month = 3
        val day = 1
        val last = 31*/
        fun moonCalc(year:Int,month:Int,day:Int): Double {
            val A = year / 100
            val B = A / 4
            val C = 2 - A + B
            val E = (365.25 * (year + 4716)).toInt()
            val F = (30.6001 * (month + 1)).toInt()
            val JD = C + day + E + F - 1524.5
         //   Timber.e("${A}   ${B}    ${C}    ${E}    ${F}   ${JD}")
            return JD
        }

        fun newMoonValue(): Float {
            val sinceNew = (moonCalc(2017,3,1) - 2451549.5).toInt()
            val cycles = sinceNew.div(29.53f)
            val fracPart = cycles % 1.0f
            val sinceNewMoon = fracPart.times(29.53)
            val format = "%.2f".format(sinceNewMoon).toFloat()
            Timber.e("SinceNew:${sinceNew}   cycles:${cycles}  fracPart:${fracPart}  sinceNewMoon:${sinceNewMoon}  format:${format}")
            return format
        }
        fun monthData(year:Int,month:Int,day:Int,last:Int):MutableList<Int>{
            val lunarMoonModel = mutableListOf<Int>()
            for (i:Int in day .. last){
                val sinceNew = (moonCalc(year, month, i) - 2451549.5).toInt()
                val cycles = sinceNew.div(29.53f)
                val part = cycles % 1.0f
                val sinceNewMoon = part.times(29.53)
                val formatValue = "%.2f".format(sinceNewMoon).toFloat().toInt()
                lunarMoonModel.add(formatValue)
            }
            return lunarMoonModel
        }
    }
}



