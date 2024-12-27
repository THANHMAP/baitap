package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.time.times

class MainActivity : AppCompatActivity() {
    private lateinit var biding : ActivityMainBinding
    var number: String = ""
    var operationClickCount = 0
    var canAddOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

//       biding.btnNum0.setOnClickListener {
//           number = number + biding.btnNum0.text
//           biding.calcullatorTextView.text = number
//           operationClickCount = 0
//       }
//        biding.btnNum1.setOnClickListener {
//            number = number + biding.btnNum1.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnNum2.setOnClickListener {
//            number = number + biding.btnNum2.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnNum3.setOnClickListener {
//            number = number + biding.btnNum3.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnNum4.setOnClickListener {
//            number = number + biding.btnNum4.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnNum5.setOnClickListener {
//            number = number + biding.btnNum5.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnNum6.setOnClickListener {
//            number = number + biding.btnNum6.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnNum7.setOnClickListener {
//            number = number + biding.btnNum7.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnNum8.setOnClickListener {
//            number = number + biding.btnNum8.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnNum9.setOnClickListener {
//            number = number + biding.btnNum9.text
//            biding.calcullatorTextView.text = number
//            operationClickCount = 0
//        }
//        biding.btnClear.setOnClickListener {
//            number = ""
//            biding.calcullatorTextView.text = ""
//            biding.calcullatorTextView.text = ""
//            operationClickCount = 0
//        }
        biding.btnDel.setOnClickListener {
            biding.calcullatorTextView.text = number
            var length =  number.length
            if (length > 0) {
                for (i in 0 until length ) {
                   biding.calcullatorTextView.text = biding.calcullatorTextView.text.subSequence(0,length - 1)
               }
            }
            operationClickCount = 0
        }
//        biding.btnAdd.setOnClickListener {
//            operationClickCount++
//            if (operationClickCount < 2) {
//                number = number + biding.btnAdd.text.toString()
//                biding.calcullatorTextView.text = number
//            }
//        }
//        biding.btnMinus.setOnClickListener {
//            operationClickCount++
//            if (operationClickCount < 2) {
//                number = number + biding.btnMinus.text.toString()
//                biding.calcullatorTextView.text = number
//            }
//        }
//        biding.btnMultily.setOnClickListener {
//            operationClickCount++
//            if (operationClickCount < 2) {
//                number = number + biding.btnMultily.text.toString()
//                biding.calcullatorTextView.text = number
//            }
//        }
//        biding.btnDevide.setOnClickListener {
//            operationClickCount++
//            if (operationClickCount < 2) {
//                number = number + biding.btnDevide.text.toString()
//                biding.calcullatorTextView.text = number
//            }
//        }
        biding.btnEqual.setOnClickListener {
            var test = number.split("+","-","x","/")
            var result = 0
            if (number.contains('x')) {
                for ( i in 0 until test.size ) {
                    if (i < 1) {
                        result = test[0].toInt()
                    } else {
                        result = result * test[i].toInt()
                    }
                }
            } else if (number.contains('/')) {
                for ( i in 0 until test.size ) {
                    if (i<1) {
                        result = test[0].toInt()
                    } else {
                        result = result / test[i].toInt()
                    }
                }
            } else if (number.contains('-')) {
                for ( i in 0 until test.size ) {
                    if (i<1) {
                        result = test[0].toInt()
                    } else {
                        result = result - test[i].toInt()
                    }
                }
            } else if (number.contains('+')) {
                for ( i in 0 until test.size ) {
                    result = result + test[i].toInt()
                }
            }

            biding.resultTextView.text = result.toString()
        }



    }
    fun numberAction(view: View) {
        if (view is Button) {
            biding.calcullatorTextView.append(view.text)
            canAddOperator = true
        }
    }
    fun operationAction(view: View) {
        if (view is Button && canAddOperator) {
            biding.calcullatorTextView.append(view.text)
            canAddOperator = false
        }
    }
    fun equalAction(view: View) {

    }

    fun delAction(view: View) {
        val length = biding.calcullatorTextView.length()
        if ( length > 0) {
            biding.calcullatorTextView.text = biding.calcullatorTextView.text.subSequence(0,length - 1)
        }
    }
    
    fun clearAction(view: View) {
        biding.calcullatorTextView.text = ""
        biding.resultTextView.text = ""
    }



}

