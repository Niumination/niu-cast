package dj;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static void a(boolean z10, @Nullable Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T b(T t10, @Nullable Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
