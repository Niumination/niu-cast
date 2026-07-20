package k3;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f6726a;

    public static Context a() {
        Context context = f6726a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }
}
