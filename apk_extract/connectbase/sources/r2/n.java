package r2;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final String f14194h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@os.l String str) {
        super(0L);
        l0.p(str, "data");
        this.f14194h = str;
    }

    public static /* synthetic */ n j(n nVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = nVar.f14194h;
        }
        return nVar.i(str);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n) && l0.g(this.f14194h, ((n) obj).f14194h);
    }

    @os.l
    public final String h() {
        return this.f14194h;
    }

    public int hashCode() {
        return this.f14194h.hashCode();
    }

    @os.l
    public final n i(@os.l String str) {
        l0.p(str, "data");
        return new n(str);
    }

    @os.l
    public final String k() {
        return this.f14194h;
    }

    @os.l
    public String toString() {
        return l.a.a(new StringBuilder("HandshakeMessage(data="), this.f14194h, ')');
    }
}
