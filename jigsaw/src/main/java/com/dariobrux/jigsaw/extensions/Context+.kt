package com.dariobrux.jigsaw.extensions

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.WindowManager

/**
 * Created by Dario Bruzzese
 * on 4/8/2020
 */

fun Context.getScreenSize(): Point {
    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val point = Point()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val windowMetrics = wm.currentWindowMetrics
        point.x = windowMetrics.bounds.width()
        point.y = windowMetrics.bounds.height()
    } else {
        wm.defaultDisplay.getSize(point)
    }
    return point
}
