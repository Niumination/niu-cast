package ug;

import k3.c2;
import li.x;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends c implements x {
    private final long sizeLimit;

    public g(long j8) {
        super("Request is larger than the limit of " + j8 + " bytes");
        this.sizeLimit = j8;
    }

    @Override // li.x
    public g createCopy() {
        g gVar = new g(this.sizeLimit);
        c2.a(gVar, this);
        return gVar;
    }
}
