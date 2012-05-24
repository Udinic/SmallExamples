package com.udinic.baseline;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by IntelliJ IDEA.
 * User: udic
 * Date: 05/01/12
 * Time: 00:53
 * To change this template use File | Settings | File Templates.
 */
public class UdinicBtn extends Button {

    public UdinicBtn(Context context) {
        super(context);
    }

    public UdinicBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UdinicBtn(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
