package com.takwolf.android.insetswidget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;

import org.jspecify.annotations.Nullable;

public final class InsetsSpace extends InsetsView {
    public InsetsSpace(Context context) {
        super(context);
        init();
    }

    public InsetsSpace(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InsetsSpace(Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public InsetsSpace(Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if (getVisibility() == VISIBLE) {
            setVisibility(INVISIBLE);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {}
}
