package com.takwolf.android.insetswidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.graphics.Insets;

public class InsetsView extends View implements InsetsWidget {
    private final InsetsWidgetHelper helper = new InsetsWidgetHelper(this);

    public InsetsView(@NonNull Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public InsetsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public InsetsView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    public InsetsView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        try (TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.InsetsView, defStyleAttr, defStyleRes)) {
            helper.initInsetsType(a, R.styleable.InsetsView_isw_insetsType);
            helper.initInsetsSmoothResize(a, R.styleable.InsetsView_isw_insetsSmoothResize);
        }
    }

    @NonNull
    @Override
    public Insets getInsets() {
        return helper.getInsets();
    }

    @Override
    public int getInsetsType() {
        return helper.getInsetsType();
    }

    @Override
    public void setInsetsType(int insetsType) {
        helper.setInsetsType(insetsType);
    }

    @Override
    public boolean isInsetsSmoothResize() {
        return helper.isInsetsSmoothResize();
    }

    @Override
    public void setInsetsSmoothResize(boolean insetsSmoothResize) {
        helper.setInsetsSmoothResize(insetsSmoothResize);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        helper.onAttachedToWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(helper.getMeasuredWidth(widthMeasureSpec), helper.getMeasuredHeight(heightMeasureSpec));
    }
}
