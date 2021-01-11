package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var coinsForChange: HashMap<String, Int> = HashMap()
    private var outPutCoinsForChange: HashMap<String, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareCoinsForChange()
        //doCoinChangeLogic()
        coinChangeButton.setOnClickListener {
            prepareCoinsForChange()
            checkForCoinChange(coinInput.text.toString())
        }
        coinClearButton.setOnClickListener {
            descriptionContent.visibility = View.GONE
            coinInput.text?.clear()
        }
    }

    private fun checkForCoinChange(inputCoin: String) {
        if(inputCoin.isNotEmpty()){
            if(inputCoin.contains(".")){
                var coinForDecimalCheck = inputCoin.split(".")
                var coinBeforeDecimal = coinForDecimalCheck[0]
                var coinAfterDecimal = coinForDecimalCheck[1]
                if(coinBeforeDecimal == ""){
                    coinBeforeDecimal = "0"
                }
                calculateCoinsForChange(coinBeforeDecimal.toInt(),coinAfterDecimal.toInt())
            }else{
                calculateCoinsForChange(inputCoin.toInt(),0)
            }
        }
    }

    private fun calculateCoinsForChange(prefix: Int, suffix: Int) {
        if(prefix != 0 && suffix == 0){
            outPutCoinsForChange["1$"] = prefix
        }else{
           if(prefix != 0 && suffix ==0){
               outPutCoinsForChange["1$"] = prefix
           }else{
               outPutCoinsForChange["1$"] = prefix
               suffixChangeCalculation(suffix)
           }
        }
        var spannableText = ""
        for ((key, value) in outPutCoinsForChange) {
            spannableText += "$key = $value \n"
        }
        prepareUI()
    }

    private fun prepareUI() {
        one_dollar.text =  outPutCoinsForChange["1$"].toString()
        fifty_cent.text =  outPutCoinsForChange["50C"].toString()
        twenty_cent.text =  outPutCoinsForChange["20C"].toString()
        ten_cent.text =  outPutCoinsForChange["10C"].toString()
        five_cent.text =  outPutCoinsForChange["5C"].toString()
        one_cent.text =  outPutCoinsForChange["1C"].toString()
        descriptionContent.visibility = View.VISIBLE
    }

    private fun suffixChangeCalculation(suffix: Int) {
        var coinValue = suffix
        var fiftyCent = coinsForChange["50C"]!!.toInt()
        var twentyCent = coinsForChange["20C"]!!.toInt()
        var tenCent = coinsForChange["10C"]!!.toInt()
        var fiveCent = coinsForChange["5C"]!!.toInt()
        var oneCent = coinsForChange["1C"]!!.toInt()

        if(coinValue > fiftyCent){
            var fiftyCnt = outPutCoinsForChange["50C"]!!.toInt() + 1
            outPutCoinsForChange["50C"] = fiftyCnt
            var updateCoinValue = coinValue - fiftyCent
            suffixChangeCalculation(updateCoinValue)
        }
        if((coinValue >= twentyCent) && (coinValue < fiftyCent)) {
            var twentyCnt = outPutCoinsForChange["20C"]!!.toInt() + 1
            outPutCoinsForChange["20C"] = twentyCnt
            var updateCoinValue = coinValue - twentyCent
            suffixChangeCalculation(updateCoinValue)
        }
        if((coinValue >= tenCent) && (coinValue < twentyCent)){
            var tenCnt = outPutCoinsForChange["10C"]!!.toInt() + 1
            outPutCoinsForChange["10C"] = tenCnt
            var updateCoinValue = coinValue - tenCent
            suffixChangeCalculation(updateCoinValue)
        }
        if((coinValue >= fiveCent) && (coinValue < tenCent)){
            var fiveCnt = outPutCoinsForChange["5C"]!!.toInt() + 1
            outPutCoinsForChange["5C"] = fiveCnt
            var updateCoinValue = coinValue - fiveCent
            suffixChangeCalculation(updateCoinValue)
        }
        if((coinValue >= oneCent) && (coinValue < fiveCent) ){
            var oneCnt = outPutCoinsForChange["1C"]!!.toInt() + 1
            outPutCoinsForChange["1C"] = oneCnt
            var updateCoinValue = coinValue - oneCent
            suffixChangeCalculation(updateCoinValue)
        }

//        if(coinValue != 0){
//
//        }
    }

    private fun prepareCoinsForChange() {
        coinsForChange["50C"] = 50
        coinsForChange["20C"] = 20
        coinsForChange["10C"] = 10
        coinsForChange["5C"] = 5
        coinsForChange["1C"] = 1

        outPutCoinsForChange["1$"] = 0
        outPutCoinsForChange["50C"] = 0
        outPutCoinsForChange["20C"] = 0
        outPutCoinsForChange["10C"] = 0
        outPutCoinsForChange["5C"] = 0
        outPutCoinsForChange["1C"] = 0
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
