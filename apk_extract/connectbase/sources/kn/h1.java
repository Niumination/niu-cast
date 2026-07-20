package kn;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h1 extends j1 implements un.r {
    public h1() {
    }

    @Override // kn.q
    public un.c computeReflected() {
        return l1.v(this);
    }

    @Override // un.r
    @lm.f1(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((un.r) getReflected()).getDelegate(obj, obj2);
    }

    @Override // jn.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @lm.f1(version = "1.4")
    public h1(Class cls, String str, String str2, int i10) {
        super(q.NO_RECEIVER, cls, str, str2, i10);
    }

    @Override // un.o
    public un.r.b getGetter() {
        return ((un.r) getReflected()).getGetter();
    }
}
