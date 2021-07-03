package com.solalva.expensetracker.presentation.features.main.models

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.solalva.expensetracker.R
import com.solalva.expensetracker.presentation.core.epoxy.EpoxyHolderWrapper
import kotlinx.android.synthetic.main.main_header.*
import kotlinx.android.synthetic.main.main_header.view.*
import java.text.NumberFormat

@EpoxyModelClass(layout = R.layout.main_header)
abstract class AccountHeaderModel : EpoxyModelWithHolder<EpoxyHolderWrapper>() {

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    var balance: Float = 0F

    override fun bind(holder: EpoxyHolderWrapper) {
        holder.view.nameTextView.text = name
        holder.view.balanceTextView.currencyFormat(balance)
    }

    private fun TextView.currencyFormat(amount: Float) {
        val color = when {
            amount < 0 -> R.color.design_default_color_error
            amount > 0 -> R.color.teal_200
            else -> R.color.purple_700
        }
        text = NumberFormat.getCurrencyInstance().format(amount)
        @Suppress("DEPRECATION") // TODO Remove when no needed api 21
        setTextColor(context.resources.getColor(color))
    }
}
