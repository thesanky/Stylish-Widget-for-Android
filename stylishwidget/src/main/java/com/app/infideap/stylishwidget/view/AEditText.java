package com.app.infideap.stylishwidget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


/**
 * Created by Zariman on 13/4/2016.
 */
public class AEditText extends AppCompatEditText {
    public AEditText(Context context) {
        super(context);
        setCustomTypeface(context, null);

    }

    public AEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTypeface(context, attrs);


    }

    public AEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomTypeface(context, attrs);

    }

    private void setCustomTypeface(Context context, AttributeSet attrs) {
        if(isInEditMode())
            return;
        TypedArray a = context.obtainStyledAttributes(attrs, android.support.v7.appcompat.R.styleable.TextAppearance);
        int style = a.getInt(android.support.v7.appcompat.R.styleable.TextAppearance_android_textStyle, Typeface.NORMAL);

        setTextStyle(style);
        a.recycle();

    }

    public void setTextStyle(int style) {
        Stylish.getInstance().setTextStyle(this, style);

    }

    public void setSupportTextAppearance(int resId){
        if (Build.VERSION.SDK_INT >= 23)
            this.setTextAppearance(resId);
        else
            this.setTextAppearance(getContext(),resId);
    }

}
