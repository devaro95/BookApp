package com.bookapp.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.bookapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import es.babel.easymvvm.android.ui.EmaBaseLayout

class TabbarWidget : EmaBaseLayout {

    constructor(context: Context) : super(context)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr)

    override fun setupAttributes(ta: TypedArray) {

    }

    private fun adjustHeight() {

    }

    override fun getAttributes(): IntArray? = null

    override fun setup(mainLayout: View) {
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        adjustHeight()
        return false
    }

    override fun getLayoutId(): Int = R.layout.layout_tabbar

}