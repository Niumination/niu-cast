package kn;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d1 extends j1 implements un.p {
    public d1() {
    }

    @Override // kn.q
    public un.c computeReflected() {
        return l1.t(this);
    }

    @Override // un.p
    @lm.f1(version = "1.1")
    public Object getDelegate() {
        return ((un.p) getReflected()).getDelegate();
    }

    @Override // jn.a
    public Object invoke() {
        return get();
    }

    @lm.f1(version = "1.1")
    public d1(Object obj) {
        super(obj);
    }

    @Override // un.o
    public un.p.b getGetter() {
        return ((un.p) getReflected()).getGetter();
    }

    @lm.f1(version = "1.4")
    public d1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
