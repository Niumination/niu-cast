package androidx.window.core;

import android.util.Log;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidLogger implements Logger {

    @l
    public static final AndroidLogger INSTANCE = new AndroidLogger();

    private AndroidLogger() {
    }

    @Override // androidx.window.core.Logger
    public void debug(@l String str, @l String str2) {
        l0.p(str, "tag");
        l0.p(str2, "message");
        Log.d(str, str2);
    }
}
