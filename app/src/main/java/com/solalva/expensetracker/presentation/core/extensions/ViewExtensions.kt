package com.solalva.expensetracker.presentation.core.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.solalva.expensetracker.R
import java.text.NumberFormat

fun Fragment.closeKeyboard() {
    view?.let { activity?.closeKeyboard(it) }
}

fun Context.closeKeyboard(view: View) {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun TextView.amountFormat(quantity: Float) {
    val color = when {
        quantity < 0 -> R.color.colorNegative
        quantity > 0 -> R.color.colorPositive
        else -> R.color.colorNeutral
    }
    text = NumberFormat.getCurrencyInstance().format(quantity)
    setTextColor(ContextCompat.getColor(context, color))
}
