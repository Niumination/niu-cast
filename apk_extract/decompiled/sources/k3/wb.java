package k3;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public abstract class wb {
    public static final int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
