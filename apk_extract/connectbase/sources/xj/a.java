package xj;

import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements vj.c {

    @l
    private final um.g context;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @l
    public um.g getContext() {
        return this.context;
    }

    public a(@l um.g gVar) {
        l0.p(gVar, "context");
        this.context = gVar;
    }

    public /* synthetic */ a(um.g gVar, int i10, w wVar) {
        this((i10 & 1) != 0 ? um.i.INSTANCE : gVar);
    }
}
