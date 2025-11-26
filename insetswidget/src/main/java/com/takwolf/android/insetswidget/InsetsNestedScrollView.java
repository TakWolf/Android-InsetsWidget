package com.takwolf.android.insetswidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.widget.NestedScrollView;

public class InsetsNestedScrollView extends NestedScrollView implements InsetsLayout {
    private final InsetsLayoutHelper helper = new InsetsLayoutHelper(this);

    public InsetsNestedScrollView(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public InsetsNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public InsetsNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        try (TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.InsetsNestedScrollView, defStyleAttr, 0)) {
            helper.initInsetsType(a, R.styleable.InsetsNestedScrollView_isw_insetsType);
            helper.initInsetsSmoothResize(a, R.styleable.InsetsNestedScrollView_isw_insetsSmoothResize);
            helper.initInsetsPaddingLeft(a, R.styleable.InsetsNestedScrollView_isw_insetsPaddingLeft);
            helper.initInsetsPaddingTop(a, R.styleable.InsetsNestedScrollView_isw_insetsPaddingTop);
            helper.initInsetsPaddingRight(a, R.styleable.InsetsNestedScrollView_isw_insetsPaddingRight);
            helper.initInsetsPaddingBottom(a, R.styleable.InsetsNestedScrollView_isw_insetsPaddingBottom);
            helper.initInsetsColorLeft(a, R.styleable.InsetsNestedScrollView_isw_insetsColorLeft);
            helper.initInsetsColorTop(a, R.styleable.InsetsNestedScrollView_isw_insetsColorTop);
            helper.initInsetsColorRight(a, R.styleable.InsetsNestedScrollView_isw_insetsColorRight);
            helper.initInsetsColorBottom(a, R.styleable.InsetsNestedScrollView_isw_insetsColorBottom);
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
    public boolean getInsetsPaddingLeft() {
        return helper.getInsetsPaddingLeft();
    }

    @Override
    public void setInsetsPaddingLeft(boolean insetsPaddingLeft) {
        helper.setInsetsPaddingLeft(insetsPaddingLeft);
    }

    @Override
    public boolean getInsetsPaddingTop() {
        return helper.getInsetsPaddingTop();
    }

    @Override
    public void setInsetsPaddingTop(boolean insetsPaddingTop) {
        helper.setInsetsPaddingTop(insetsPaddingTop);
    }

    @Override
    public boolean getInsetsPaddingRight() {
        return helper.getInsetsPaddingRight();
    }

    @Override
    public void setInsetsPaddingRight(boolean insetsPaddingRight) {
        helper.setInsetsPaddingRight(insetsPaddingRight);
    }

    @Override
    public boolean getInsetsPaddingBottom() {
        return helper.getInsetsPaddingBottom();
    }

    @Override
    public void setInsetsPaddingBottom(boolean insetsPaddingBottom) {
        helper.setInsetsPaddingBottom(insetsPaddingBottom);
    }

    @Override
    public int getInsetsColorLeft() {
        return helper.getInsetsColorLeft();
    }

    @Override
    public void setInsetsColorLeft(int insetsColorLeft) {
        helper.setInsetsColorLeft(insetsColorLeft);
    }

    @Override
    public int getInsetsColorTop() {
        return helper.getInsetsColorTop();
    }

    @Override
    public void setInsetsColorTop(int insetsColorTop) {
        helper.setInsetsColorTop(insetsColorTop);
    }

    @Override
    public int getInsetsColorRight() {
        return helper.getInsetsColorRight();
    }

    @Override
    public void setInsetsColorRight(int insetsColorRight) {
        helper.setInsetsColorRight(insetsColorRight);
    }

    @Override
    public int getInsetsColorBottom() {
        return helper.getInsetsColorBottom();
    }

    @Override
    public void setInsetsColorBottom(int insetsColorBottom) {
        helper.setInsetsColorBottom(insetsColorBottom);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        helper.onAttachedToWindow();
    }

    @Override
    protected void dispatchDraw(@NonNull Canvas canvas) {
        super.dispatchDraw(canvas);
        helper.onDraw(canvas);
    }
}
