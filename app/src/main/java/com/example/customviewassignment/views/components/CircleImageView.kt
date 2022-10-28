package com.example.customviewassignment.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.example.customviewassignment.R
import kotlin.math.cos
import kotlin.math.sin

class CircleImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    var size = 0
    var borderColor = Color.WHITE
    var borderSize = 10f
    val path = Path()
    var paint = Paint()
    init {
        context.withStyledAttributes(attrs,R.styleable.CircleImageView){
            borderColor=getColor(R.styleable.CircleImageView_borderColor,borderColor)
            borderSize=getDimension(R.styleable.CircleImageView_borderWidth,borderSize)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        paint.style = Paint.Style.STROKE
        paint.color = borderColor
        paint.strokeWidth = borderSize
      path.addCircle(size / 2f, size / 2f, size / 2f, Path.Direction.CCW)

        canvas?.clipPath(path)
        super.onDraw(canvas)
        canvas?.drawCircle(size / 2f, size / 2f, size / 2f - (borderSize / 2f), paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
     size = w.coerceAtMost(h)

    }

}