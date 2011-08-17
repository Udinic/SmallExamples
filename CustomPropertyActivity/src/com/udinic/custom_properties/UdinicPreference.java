package com.udinic.custom_properties;

import android.content.Context;
import android.graphics.Color;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UdinicPreference extends Preference {

//	ImageView mIcon = null;
//	TextView mTitle = null;
//	ImageView mArrow = null;
//
//	int mIconResId = -1;
//	int mTitleResId = -1;
//	boolean mIconAnimation = false;
//    boolean mNoArrow = false;

	public UdinicPreference(Context context) {
		super(context);
//		init(null);
	}
	public UdinicPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
//		init(attrs);
	}
	public UdinicPreference(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
//		init(attrs);
	}

	@Override
	protected View onCreateView(ViewGroup parent) {
		View newView = super.onCreateView(parent);

        // Making the text visible (The background is transparent, no need to worry there)l6
        ((TextView)newView.findViewById(android.R.id.title)).setTextColor(Color.BLACK);

     	return newView;
	}
}
