package hj;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a(int i10, Context context) {
        return (int) TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static int b(int i10, Context context) {
        return (int) TypedValue.applyDimension(2, i10, context.getResources().getDisplayMetrics());
    }

    public static int c(int i10, int i11, Context context) {
        return (int) TypedValue.applyDimension(i10, i11, context.getResources().getDisplayMetrics());
    }
}
