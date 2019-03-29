package com.cuong.awesomelib.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.cuong.awesomelib.R;

/**
 * Created by cherr on 6/5/2018.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomTextView(Context context) {
        this(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        int style = a.getInt(R.styleable.CustomTextView_customStyle, 0);
        setFont(style);
    }

    private void setFont(int style) {
        Typeface font;
        if (style == 1) {
            font = Typeface.createFromAsset(getContext().getAssets(), "Cabin-Regular.ttf");
            setTypeface(font, Typeface.NORMAL);
        } else if (style == 2 || style == 3) {
            font = Typeface.createFromAsset(getContext().getAssets(), "Cabin-Bold.otf");
            setTypeface(font, Typeface.BOLD);
        }
    }
}
