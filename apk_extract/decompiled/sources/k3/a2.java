package k3;

import android.content.res.Resources;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class a2 {
    public static int a(int i8) {
        return (int) TypedValue.applyDimension(1, i8, Resources.getSystem().getDisplayMetrics());
    }
}
