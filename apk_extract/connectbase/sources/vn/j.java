package vn;

import kn.w;
import lm.f1;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.1")
public final class j extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public j() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public j(@m Exception exc) {
        super(exc);
    }

    public /* synthetic */ j(Exception exc, int i10, w wVar) {
        this((i10 & 1) != 0 ? null : exc);
    }
}
