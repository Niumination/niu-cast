package kn;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 extends a1 implements un.k {
    public u0() {
    }

    @Override // kn.q
    public un.c computeReflected() {
        return l1.j(this);
    }

    @Override // un.p
    @lm.f1(version = "1.1")
    public Object getDelegate() {
        return ((un.k) getReflected()).getDelegate();
    }

    @Override // jn.a
    public Object invoke() {
        return get();
    }

    @lm.f1(version = "1.1")
    public u0(Object obj) {
        super(obj);
    }

    @Override // un.o
    public un.p.b getGetter() {
        return ((un.k) getReflected()).getGetter();
    }

    @Override // un.j
    public un.k.b getSetter() {
        return ((un.k) getReflected()).getSetter();
    }

    @lm.f1(version = "1.4")
    public u0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
