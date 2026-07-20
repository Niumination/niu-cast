package zk;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@l String str) {
        super(str);
        l0.p(str, "message");
    }
}
