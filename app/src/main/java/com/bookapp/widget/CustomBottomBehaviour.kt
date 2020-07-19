package com.bookapp.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior

class CustomBottomBehaviour<V : View> : BottomSheetBehavior<V> {

    constructor() : super()
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    var onNestedClickEvent : (()->Unit)?=null
/*
    override fun onTouchEvent(parent: CoordinatorLayout, child: V, event: MotionEvent): Boolean {

        val value = super.onTouchEvent(parent, child, event)

        when(event.action){
            MotionEvent.ACTION_MOVE ->  onNestedClickEvent=null
            MotionEvent.ACTION_UP -> {
                onNestedClickEvent?.invoke()
                onNestedClickEvent = null
            }
        }

        return value
    }


    override fun onInterceptTouchEvent(parent: CoordinatorLayout, child: V, event: MotionEvent): Boolean {
        return false
    }

    override fun onTouchEvent(parent: CoordinatorLayout, child: V, event: MotionEvent): Boolean {
        return false
    }

    override fun onNestedPreFling(coordinatorLayout: CoordinatorLayout, child: V, target: View, velocityX: Float, velocityY: Float): Boolean {
        return false
    }
    */
}