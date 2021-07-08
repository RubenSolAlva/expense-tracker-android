package com.solalva.expensetracker.presentation.features.main.models

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.solalva.expensetracker.R
import com.solalva.expensetracker.presentation.core.epoxy.KotlinEpoxyHolder
import com.solalva.expensetracker.presentation.core.extensions.amountFormat
import kotlinx.android.synthetic.main.main_item.view.main_item_image_view
import kotlinx.android.synthetic.main.main_item.view.main_item_time_text_view
import kotlinx.android.synthetic.main.main_item.view.main_item_name_text_view
import kotlinx.android.synthetic.main.main_item.view.main_item_amount_text_view
import java.text.DateFormat
import java.util.Date

@EpoxyModelClass(layout = R.layout.main_item)
abstract class TransactionItemModel :
    EpoxyModelWithHolder<KotlinEpoxyHolder>() {

    @EpoxyAttribute
    lateinit var transactionCategoryName: String

    @EpoxyAttribute
    var amount: Float = 0F

    @EpoxyAttribute
    lateinit var time: Date

    override fun bind(holder: KotlinEpoxyHolder) {
        holder.view.main_item_name_text_view.text = transactionCategoryName
        holder.view.main_item_time_text_view.text =
            DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(time)
        holder.view.main_item_amount_text_view.amountFormat(amount)

        val iconUI = transactionIconStatus[transactionCategoryName]
        iconUI?.run {
            holder.view.main_item_image_view.setImageResource(iconUI.transactionIcon)
        }
    }
}
