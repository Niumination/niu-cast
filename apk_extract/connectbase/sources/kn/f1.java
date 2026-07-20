package kn;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f1 extends j1 implements un.q {
    public f1() {
    }

    @Override // kn.q
    public un.c computeReflected() {
        return l1.u(this);
    }

    @Override // un.q
    @lm.f1(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((un.q) getReflected()).getDelegate(obj);
    }

    @Override // jn.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @lm.f1(version = "1.1")
    public f1(Object obj) {
        super(obj);
    }

    @Override // un.o
    public un.q.b getGetter() {
        return ((un.q) getReflected()).getGetter();
    }

    @lm.f1(version = "1.4")
    public f1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
