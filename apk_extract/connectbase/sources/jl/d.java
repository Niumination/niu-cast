package jl;

import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@l String str) {
        super(str);
        l0.p(str, "message");
    }

    public /* synthetic */ d(String str, int i10, w wVar) {
        this((i10 & 1) != 0 ? "Invalid data format" : str);
    }
}
