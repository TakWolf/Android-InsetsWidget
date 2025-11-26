package com.takwolf.android.insetswidget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

public final class InsetsSpace extends InsetsView {
    public InsetsSpace(@NonNull Context context) {
        super(context);
        init();
    }

    public InsetsSpace(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InsetsSpace(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public InsetsSpace(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if (getVisibility() == VISIBLE) {
            setVisibility(INVISIBLE);
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {}
}
