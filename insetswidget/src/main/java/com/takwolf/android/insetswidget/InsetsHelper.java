package com.takwolf.android.insetswidget;

import android.content.res.TypedArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

abstract class InsetsHelper<V extends View> {
    @NonNull private final V view;

    @InsetsWidget.InsetsType private int insetsType;
    private boolean insetsSmoothResize;

    @Nullable private WindowInsetsCompat windowInsetsInstant;
    @Nullable private WindowInsetsCompat windowInsetsAnimated;
    private boolean windowInsetsAnimationRunning = false;

    @NonNull private Insets insets = Insets.NONE;

    protected InsetsHelper(@NonNull V view) {
        this.view = view;
        ViewCompat.setOnApplyWindowInsetsListener(view, (v, windowInsets) -> {
            windowInsetsInstant = windowInsets;
            if (!insetsSmoothResize || !windowInsetsAnimationRunning) {
                notifyInsetsUpdate();
            }
            return windowInsets;
        });
        ViewCompat.setWindowInsetsAnimationCallback(view, new WindowInsetsAnimationCompat.Callback(WindowInsetsAnimationCompat.Callback.DISPATCH_MODE_CONTINUE_ON_SUBTREE) {
            @Override
            public void onPrepare(@NonNull WindowInsetsAnimationCompat animation) {
                windowInsetsAnimationRunning = true;
                windowInsetsAnimated = null;
            }

            @NonNull
            @Override
            public WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsets, @NonNull List<WindowInsetsAnimationCompat> runningAnimations) {
                windowInsetsAnimated = windowInsets;
                if (insetsSmoothResize) {
                    notifyInsetsUpdate();
                }
                return windowInsets;
            }

            @Override
            public void onEnd(@NonNull WindowInsetsAnimationCompat animation) {
                windowInsetsAnimated = null;
                windowInsetsAnimationRunning = false;
            }
        });
    }

    public void initInsetsType(@NonNull TypedArray a, @StyleableRes int index) {
        insetsType = a.getInt(index, InsetsWidget.INSETS_TYPE_NONE);
    }

    public void initInsetsSmoothResize(@NonNull TypedArray a, @StyleableRes int index) {
        insetsSmoothResize = a.getBoolean(index, true);
    }

    @NonNull
    protected V getView() {
        return view;
    }

    @NonNull
    public Insets getInsets() {
        return insets;
    }

    @InsetsWidget.InsetsType
    public int getInsetsType() {
        return insetsType;
    }

    public void setInsetsType(@InsetsWidget.InsetsType int insetsType) {
        if (this.insetsType != insetsType) {
            this.insetsType = insetsType;
            notifyInsetsUpdate();
        }
    }

    public boolean isInsetsSmoothResize() {
        return insetsSmoothResize;
    }

    public void setInsetsSmoothResize(boolean insetsSmoothResize) {
        if (this.insetsSmoothResize != insetsSmoothResize) {
            this.insetsSmoothResize = insetsSmoothResize;
            notifyInsetsUpdate();
        }
    }

    public void onAttachedToWindow() {
        windowInsetsInstant = ViewCompat.getRootWindowInsets(view);
        notifyInsetsUpdate();
    }

    private void notifyInsetsUpdate() {
        WindowInsetsCompat windowInsets;
        if (insetsSmoothResize && windowInsetsAnimationRunning) {
            windowInsets = windowInsetsAnimated;
        } else {
            windowInsets = windowInsetsInstant;
        }
        if (windowInsets == null) {
            return;
        }
        Insets insets = windowInsets.getInsets(InsetsUtils.convertInsetsType(insetsType));
        if (!this.insets.equals(insets)) {
            this.insets = insets;
            onInsetsUpdated();
        }
    }

    protected abstract void onInsetsUpdated();
}
