package com.takwolf.android.insetswidget;

import androidx.annotation.ColorInt;

public interface InsetsLayout extends InsetsWidget {
    boolean getInsetsPaddingLeft();

    void setInsetsPaddingLeft(boolean insetsPaddingLeft);

    boolean getInsetsPaddingTop();

    void setInsetsPaddingTop(boolean insetsPaddingTop);

    boolean getInsetsPaddingRight();

    void setInsetsPaddingRight(boolean insetsPaddingRight);

    boolean getInsetsPaddingBottom();

    void setInsetsPaddingBottom(boolean insetsPaddingBottom);

    @ColorInt
    int getInsetsColorLeft();

    void setInsetsColorLeft(@ColorInt int insetsColorLeft);

    @ColorInt
    int getInsetsColorTop();

    void setInsetsColorTop(@ColorInt int insetsColorTop);

    @ColorInt
    int getInsetsColorRight();

    void setInsetsColorRight(@ColorInt int insetsColorRight);

    @ColorInt
    int getInsetsColorBottom();

    void setInsetsColorBottom(@ColorInt int insetsColorBottom);
}
