package kn;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 extends a1 implements un.l {
    public w0() {
    }

    @Override // kn.q
    public un.c computeReflected() {
        return l1.k(this);
    }

    @Override // un.q
    @lm.f1(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((un.l) getReflected()).getDelegate(obj);
    }

    @Override // jn.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @lm.f1(version = "1.1")
    public w0(Object obj) {
        super(obj);
    }

    @Override // un.o
    public un.q.b getGetter() {
        return ((un.l) getReflected()).getGetter();
    }

    @Override // un.j
    public un.l.b getSetter() {
        return ((un.l) getReflected()).getSetter();
    }

    @lm.f1(version = "1.4")
    public w0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
