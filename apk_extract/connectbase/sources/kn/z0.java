package kn;

/* JADX INFO: loaded from: classes3.dex */
public class z0 extends y0 {
    public z0(un.h hVar, String str, String str2) {
        super(((t) hVar).s(), str, str2, !(hVar instanceof un.d) ? 1 : 0);
    }

    @Override // un.r
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    @Override // un.m
    public void set(Object obj, Object obj2, Object obj3) {
        getSetter().call(obj, obj2, obj3);
    }

    @lm.f1(version = "1.4")
    public z0(Class cls, String str, String str2, int i10) {
        super(cls, str, str2, i10);
    }
}
