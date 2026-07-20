package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class FlashModeConverter {
    private FlashModeConverter() {
    }

    @NonNull
    public static String nameOf(int i8) {
        if (i8 == 0) {
            return "AUTO";
        }
        if (i8 == 1) {
            return "ON";
        }
        if (i8 == 2) {
            return "OFF";
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Unknown flash mode "));
    }

    public static int valueOf(@Nullable String str) {
        if (str == null) {
            throw new NullPointerException("name cannot be null");
        }
        switch (str) {
            case "ON":
                return 1;
            case "OFF":
                return 2;
            case "AUTO":
                return 0;
            default:
                throw new IllegalArgumentException("Unknown flash mode name ".concat(str));
        }
    }
}
