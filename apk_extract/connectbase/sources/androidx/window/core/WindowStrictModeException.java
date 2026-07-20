package androidx.window.core;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class WindowStrictModeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowStrictModeException(@l String str) {
        super(str);
        l0.p(str, "message");
    }
}
