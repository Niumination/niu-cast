package vn;

import kn.l0;
import lm.f1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.1")
public final class a extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@l IllegalAccessException illegalAccessException) {
        super(illegalAccessException);
        l0.p(illegalAccessException, "cause");
    }
}
