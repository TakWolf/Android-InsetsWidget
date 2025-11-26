package com.takwolf.android.insetswidget;

import androidx.core.view.HackWindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat;

final class InsetsUtils {
    private InsetsUtils() {}

    private static final int INSETS_TYPE_FIRST = InsetsWidget.INSETS_TYPE_STATUS_BARS;
    private static final int INSETS_TYPE_LAST = InsetsWidget.INSETS_TYPE_SYSTEM_OVERLAYS;

    @WindowInsetsCompat.Type.InsetsType
    static int convertInsetsType(@InsetsWidget.InsetsType int value) {
        int result = 0;
        for (int i = INSETS_TYPE_FIRST; i <= INSETS_TYPE_LAST; i = i << 1) {
            if ((value & i) != 0) {
                switch (i) {
                    case InsetsWidget.INSETS_TYPE_STATUS_BARS:
                        result |= WindowInsetsCompat.Type.statusBars();
                        break;
                    case InsetsWidget.INSETS_TYPE_NAVIGATION_BARS:
                        result |= WindowInsetsCompat.Type.navigationBars();
                        break;
                    case InsetsWidget.INSETS_TYPE_CAPTION_BAR:
                        result |= WindowInsetsCompat.Type.captionBar();
                        break;
                    case InsetsWidget.INSETS_TYPE_IME:
                        result |= WindowInsetsCompat.Type.ime();
                        break;
                    case InsetsWidget.INSETS_TYPE_SYSTEM_GESTURES:
                        result |= WindowInsetsCompat.Type.systemGestures();
                        break;
                    case InsetsWidget.INSETS_TYPE_MANDATORY_SYSTEM_GESTURES:
                        result |= WindowInsetsCompat.Type.mandatorySystemGestures();
                        break;
                    case InsetsWidget.INSETS_TYPE_TAPPABLE_ELEMENT:
                        result |= WindowInsetsCompat.Type.tappableElement();
                        break;
                    case InsetsWidget.INSETS_TYPE_DISPLAY_CUTOUT:
                        result |= WindowInsetsCompat.Type.displayCutout();
                        break;
                    case InsetsWidget.INSETS_TYPE_WINDOW_DECOR:
                        result |= HackWindowInsetsCompat.Type.windowDecor();
                        break;
                    case InsetsWidget.INSETS_TYPE_SYSTEM_OVERLAYS:
                        result |= WindowInsetsCompat.Type.systemOverlays();
                        break;
                }
            }
        }
        return result;
    }
}
