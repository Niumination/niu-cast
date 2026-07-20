package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import h0.a;
import java.util.Locale;
import o.d;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f, @NonNull String str) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException(a.B(str, " must not be NaN"));
        }
        if (Float.isInfinite(f)) {
            throw new IllegalArgumentException(a.B(str, " must not be infinite"));
        }
        return f;
    }

    public static int checkArgumentInRange(int i8, int i9, int i10, @NonNull String str) {
        if (i8 < i9) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i9 + ", " + i10 + "] (too low)");
        }
        if (i8 <= i10) {
            return i8;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i9 + ", " + i10 + "] (too high)");
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i8, @Nullable String str) {
        if (i8 >= 0) {
            return i8;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i8, int i9) {
        if ((i8 & i9) == i8) {
            return i8;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i8) + ", but only 0x" + Integer.toHexString(i9) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t3) {
        t3.getClass();
        return t3;
    }

    public static void checkState(boolean z2, @Nullable String str) {
        if (!z2) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t3) {
        if (TextUtils.isEmpty(t3)) {
            throw new IllegalArgumentException();
        }
        return t3;
    }

    public static void checkArgument(boolean z2, @NonNull Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i8) {
        if (i8 >= 0) {
            return i8;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t3, @NonNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z2) {
        checkState(z2, null);
    }

    public static void checkArgument(boolean z2, @NonNull String str, @NonNull Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t3, @NonNull Object obj) {
        if (TextUtils.isEmpty(t3)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t3;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t3, @NonNull String str, @NonNull Object... objArr) {
        if (TextUtils.isEmpty(t3)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t3;
    }

    public static long checkArgumentInRange(long j8, long j10, long j11, @NonNull String str) {
        if (j8 < j10) {
            Locale locale = Locale.US;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" is out of range of [");
            sb2.append(j10);
            sb2.append(", ");
            throw new IllegalArgumentException(d.p(sb2, j11, "] (too low)"));
        }
        if (j8 <= j11) {
            return j8;
        }
        Locale locale2 = Locale.US;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(" is out of range of [");
        sb3.append(j10);
        sb3.append(", ");
        throw new IllegalArgumentException(d.p(sb3, j11, "] (too high)"));
    }

    public static float checkArgumentInRange(float f, float f4, float f10, @NonNull String str) {
        if (f < f4) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f4), Float.valueOf(f10)));
        }
        if (f <= f10) {
            return f;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f4), Float.valueOf(f10)));
    }

    public static double checkArgumentInRange(double d7, double d10, double d11, @NonNull String str) {
        if (d7 < d10) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d10), Double.valueOf(d11)));
        }
        if (d7 <= d11) {
            return d7;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d10), Double.valueOf(d11)));
    }
}
