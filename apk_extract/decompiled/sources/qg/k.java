package qg;

import k3.c2;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends IllegalStateException implements li.x {
    private final long expected;

    public k(long j8) {
        super(o.d.j("Body.size is too long. Expected ", j8));
        this.expected = j8;
    }

    @Override // li.x
    public k createCopy() {
        k kVar = new k(this.expected);
        c2.a(kVar, this);
        return kVar;
    }
}
