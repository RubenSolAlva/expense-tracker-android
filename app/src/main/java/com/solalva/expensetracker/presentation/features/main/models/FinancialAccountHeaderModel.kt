package com.solalva.expensetracker.presentation.features.main.models

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.solalva.expensetracker.R
import com.solalva.expensetracker.presentation.core.epoxy.KotlinEpoxyHolder
import com.solalva.expensetracker.presentation.core.extensions.amountFormat
import kotlinx.android.synthetic.main.main_header.view.*

@EpoxyModelClass(layout = R.layout.main_header)
abstract class FinancialAccountHeaderModel : EpoxyModelWithHolder<KotlinEpoxyHolder>() {

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    var balance: Float = 0F

    override fun bind(holder: KotlinEpoxyHolder) {
        holder.view.main_header_title_text_view.text = name
        holder.view.main_header_description_text_view.amountFormat(balance)
    }
}
