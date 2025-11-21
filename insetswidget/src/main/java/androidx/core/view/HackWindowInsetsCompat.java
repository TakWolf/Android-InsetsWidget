package androidx.core.view;

public final class HackWindowInsetsCompat {
    private HackWindowInsetsCompat() {}

    public static final class Type {
        @WindowInsetsCompat.Type.InsetsType
        public static int windowDecor() {
            return WindowInsetsCompat.Type.WINDOW_DECOR;
        }
    }
}
