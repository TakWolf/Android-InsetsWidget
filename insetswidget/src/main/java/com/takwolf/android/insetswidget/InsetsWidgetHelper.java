package com.takwolf.android.insetswidget;

import android.view.View;

import androidx.annotation.NonNull;

public class InsetsWidgetHelper extends InsetsHelper<View> {
    public InsetsWidgetHelper(@NonNull View view) {
        super(view);
    }

    @Override
    protected void onInsetsUpdated() {
        getView().requestLayout();
    }

    public int getMeasuredWidth(int widthMeasureSpec) {
        return getInsetsViewSize(getInsets().left + getInsets().right, widthMeasureSpec);
    }

    public int getMeasuredHeight(int heightMeasureSpec) {
        return getInsetsViewSize(getInsets().top + getInsets().bottom, heightMeasureSpec);
    }

    private static int getInsetsViewSize(int requestSize, int measureSpec) {
        int measureMode = View.MeasureSpec.getMode(measureSpec);
        int measureSize = View.MeasureSpec.getSize(measureSpec);
        switch (measureMode) {
            case View.MeasureSpec.UNSPECIFIED:
                return requestSize;
            case View.MeasureSpec.EXACTLY:
                return measureSize;
            case View.MeasureSpec.AT_MOST:
                return Math.min(requestSize, measureSize);
            default:
                return 0;
        }
    }
}
