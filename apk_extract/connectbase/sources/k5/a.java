package k5;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int b(Context context) {
        int i10 = context.getResources().getConfiguration().orientation;
        if (i10 == 2) {
            return 0;
        }
        return i10;
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static o2.f d(Context context) {
        return new o2.f(c(context), a(context));
    }
}
