package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_two_dimensional_array_test.*


class TwoDimensionalArrayTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_dimensional_array_test)
        createArray.setOnClickListener {
            var x = enterX.text.toString()
            var y = enterY.text.toString()
            if (x.isNotEmpty() && y.isNotEmpty()) {
                printDimensionalArray(x, y)
            }
        }
        rotateBtn.setOnClickListener {
            twoDimensionRotate.visibility = View.VISIBLE
            clearBtn.visibility = View.VISIBLE
        }
        clearBtn.setOnClickListener {
            clearBtn.visibility = View.GONE
            twoDimension.visibility = View.GONE
            twoDimensionRotate.visibility = View.GONE
            rotateBtn.visibility = View.GONE
            enterX.text?.clear()
            enterY.text?.clear()
        }
    }


    private fun printDimensionalArray(x: String, y: String) {
        val rows = x.toInt()
        val column = y.toInt()
        val arr = Array(rows) { IntArray(column) }
        //2D arrays are row major, so always row first
        var restrict = rows - 2
        for (row in arr.indices) {
            for (col in arr[row].indices) {
                if (col > 1 && row < restrict) {
                    arr[row][col] = 0
                } else {
                    arr[row][col] = 1
                }
            }
        }
        var str = ""
        for (row in arr) {
            str += "\n" + row.contentToString()
        }
        twoDimension.text = str
        twoDimension.visibility = View.VISIBLE
        rotateMatrix(column, arr)
        rotateBtn.visibility = View.VISIBLE
    }

    fun rotateMatrix(N: Int, mat: Array<IntArray>) {
        for (x in 0 until N / 2) {
            for (y in x until N - x - 1) {
                val temp = mat[x][y]
                mat[x][y] = mat[y][N - 1 - x]
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y]
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x]
                mat[N - 1 - y][x] = temp
            }
        }
        var str = ""
        for (row in mat) {
            str += "\n" + row.contentToString()
        }
        twoDimensionRotate.text = str
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}