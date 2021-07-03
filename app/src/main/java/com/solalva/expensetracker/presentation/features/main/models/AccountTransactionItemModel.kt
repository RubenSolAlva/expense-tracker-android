package com.solalva.expensetracker.presentation.features.main.models

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.solalva.expensetracker.R
import com.solalva.expensetracker.presentation.core.epoxy.EpoxyHolderWrapper
import kotlinx.android.synthetic.main.main_item.view.*
import java.text.DateFormat
import java.text.NumberFormat
import java.util.*

@EpoxyModelClass(layout = R.layout.main_item)
abstract class AccountTransactionItemModel :
    EpoxyModelWithHolder<EpoxyHolderWrapper>() {

    @EpoxyAttribute
    lateinit var transactionCategoryName: String

    @EpoxyAttribute
    var amount: Float = 0F

    @EpoxyAttribute
    lateinit var time: Date

    override fun bind(holder: EpoxyHolderWrapper) {
        holder.view.categoryNameTextView.text = transactionCategoryName
        holder.view.amountTextView.currencyFormat(amount)
        holder.view.timeTextView.text =
            DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(time)
        holder.view.transactionTypeImageView.setImageResource(R.drawable.ic_launcher_foreground)
    }
}

fun TextView.currencyFormat(amount: Float) {
    val color = when {
        amount < 0 -> R.color.design_default_color_error
        amount > 0 -> R.color.teal_200
        else -> R.color.purple_700
    }
    text = NumberFormat.getCurrencyInstance().format(amount)
    @Suppress("DEPRECATION") // TODO Remove when no needed api 21
    setTextColor(context.resources.getColor(color))
}
