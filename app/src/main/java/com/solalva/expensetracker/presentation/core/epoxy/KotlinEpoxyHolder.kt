package com.solalva.expensetracker.presentation.core.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder

/**
 * A pattern for easier view binding with an [EpoxyHolder]
 *
 * Se https://github.com/airbnb/epoxy/blob/2.19.0/kotlinsample/src/main/java/com/airbnb/epoxy/kotlinsample/helpers/KotlinEpoxyHolder.kt
 */
class KotlinEpoxyHolder: EpoxyHolder() {
    lateinit var view: View

    override fun bindView(itemView: View) {
        view = itemView
    }
}
