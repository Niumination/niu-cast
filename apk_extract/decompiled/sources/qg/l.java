package qg;

import k3.c2;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends IllegalStateException implements li.x {
    private final long actual;
    private final long expected;

    public l(long j8, long j10) {
        super("Body.size is too small. Body: " + j10 + ", Content-Length: " + j8);
        this.expected = j8;
        this.actual = j10;
    }

    @Override // li.x
    public l createCopy() {
        l lVar = new l(this.expected, this.actual);
        c2.a(lVar, this);
        return lVar;
    }
}
