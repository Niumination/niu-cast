package kn;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y0 extends a1 implements un.m {
    public y0() {
    }

    @Override // kn.q
    public un.c computeReflected() {
        return l1.l(this);
    }

    @Override // un.r
    @lm.f1(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((un.m) getReflected()).getDelegate(obj, obj2);
    }

    @Override // jn.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @lm.f1(version = "1.4")
    public y0(Class cls, String str, String str2, int i10) {
        super(q.NO_RECEIVER, cls, str, str2, i10);
    }

    @Override // un.o
    public un.r.b getGetter() {
        return ((un.m) getReflected()).getGetter();
    }

    @Override // un.j
    public un.m.b getSetter() {
        return ((un.m) getReflected()).getSetter();
    }
}
