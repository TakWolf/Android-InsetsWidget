package com.takwolf.android.insetswidget;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface InsetsWidget {
    int INSETS_TYPE_NONE = 0;
    int INSETS_TYPE_STATUS_BARS = 1;
    int INSETS_TYPE_NAVIGATION_BARS = 1 << 1;
    int INSETS_TYPE_CAPTION_BAR = 1 << 2;
    int INSETS_TYPE_IME = 1 << 3;
    int INSETS_TYPE_SYSTEM_GESTURES = 1 << 4;
    int INSETS_TYPE_MANDATORY_SYSTEM_GESTURES = 1 << 5;
    int INSETS_TYPE_TAPPABLE_ELEMENT = 1 << 6;
    int INSETS_TYPE_DISPLAY_CUTOUT = 1 << 7;
    int INSETS_TYPE_WINDOW_DECOR = 1 << 8;
    int INSETS_TYPE_SYSTEM_OVERLAYS = 1 << 9;
    int INSETS_TYPE_SYSTEM_BARS = INSETS_TYPE_STATUS_BARS | INSETS_TYPE_NAVIGATION_BARS | INSETS_TYPE_CAPTION_BAR | INSETS_TYPE_SYSTEM_OVERLAYS;
    int INSETS_TYPE_ALL = 0xFFFFFFFF;

    @IntDef(flag = true, value = {
            INSETS_TYPE_NONE,
            INSETS_TYPE_STATUS_BARS,
            INSETS_TYPE_NAVIGATION_BARS,
            INSETS_TYPE_CAPTION_BAR,
            INSETS_TYPE_IME,
            INSETS_TYPE_SYSTEM_GESTURES,
            INSETS_TYPE_MANDATORY_SYSTEM_GESTURES,
            INSETS_TYPE_TAPPABLE_ELEMENT,
            INSETS_TYPE_DISPLAY_CUTOUT,
            INSETS_TYPE_WINDOW_DECOR,
            INSETS_TYPE_SYSTEM_OVERLAYS,
            INSETS_TYPE_ALL,
    })
    @Retention(RetentionPolicy.SOURCE)
    @interface InsetsType {}

    @NonNull
    Insets getInsets();

    @InsetsWidget.InsetsType
    int getInsetsType();

    void setInsetsType(@InsetsWidget.InsetsType int insetsType);

    boolean isInsetsSmoothResize();

    void setInsetsSmoothResize(boolean insetsSmoothResize);
}
