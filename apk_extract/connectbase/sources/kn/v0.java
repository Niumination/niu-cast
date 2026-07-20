package kn;

/* JADX INFO: loaded from: classes3.dex */
public class v0 extends u0 {
    public v0(un.h hVar, String str, String str2) {
        super(q.NO_RECEIVER, ((t) hVar).s(), str, str2, !(hVar instanceof un.d) ? 1 : 0);
    }

    @Override // un.p
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    @Override // un.k
    public void set(Object obj) {
        getSetter().call(obj);
    }

    @lm.f1(version = "1.4")
    public v0(Class cls, String str, String str2, int i10) {
        super(q.NO_RECEIVER, cls, str, str2, i10);
    }

    @lm.f1(version = "1.4")
    public v0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
