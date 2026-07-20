package kn;

/* JADX INFO: loaded from: classes3.dex */
public class g1 extends f1 {
    public g1(un.h hVar, String str, String str2) {
        super(q.NO_RECEIVER, ((t) hVar).s(), str, str2, !(hVar instanceof un.d) ? 1 : 0);
    }

    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @lm.f1(version = "1.4")
    public g1(Class cls, String str, String str2, int i10) {
        super(q.NO_RECEIVER, cls, str, str2, i10);
    }

    @lm.f1(version = "1.4")
    public g1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
