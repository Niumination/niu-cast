package ma;

import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10618c = "b";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10619d = "LockPatternView CANNOT BE NULL";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public md.b f10620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v7.b f10621b;

    public gg.a a(String str) {
        if (fc.b.b(str)) {
            e.f(f10618c, "TranThubLockPatternView");
            md.b bVar = this.f10620a;
            if (bVar != null) {
                return bVar;
            }
            md.b bVar2 = new md.b();
            this.f10620a = bVar2;
            return bVar2;
        }
        e.f(f10618c, "TranAospLockPatternView");
        v7.b bVar3 = this.f10621b;
        if (bVar3 != null) {
            return bVar3;
        }
        v7.b bVar4 = new v7.b();
        this.f10621b = bVar4;
        return bVar4;
    }

    public void b(Object obj, int i10, int i11, int i12) {
        if (obj == null) {
            throw new IllegalArgumentException(f10619d);
        }
        a(fc.b.a.f6001u).c(obj, i10, i11, i12);
    }

    public void c(Object obj, int i10) {
        if (obj == null) {
            throw new IllegalArgumentException(f10619d);
        }
        if (fc.a.f()) {
            a(fc.b.a.f6001u).b(obj, i10);
        }
    }

    public void d(Object obj, int i10) {
        if (obj == null) {
            throw new IllegalArgumentException(f10619d);
        }
        if (fc.a.f()) {
            a(fc.b.a.f6001u).a(obj, i10);
        }
    }
}
