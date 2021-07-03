package com.solalva.expensetracker.presentation.core.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder

class EpoxyHolderWrapper: EpoxyHolder() {
    lateinit var view: View

    override fun bindView(itemView: View) {
        view = itemView
    }
}
