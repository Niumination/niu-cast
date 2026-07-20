package l3;

/* JADX INFO: loaded from: classes.dex */
public final class k1 implements p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p1[] f7258a;

    public k1(p1... p1VarArr) {
        this.f7258a = p1VarArr;
    }

    @Override // l3.p1
    public final a2 a(Class cls) {
        for (int i8 = 0; i8 < 2; i8++) {
            p1 p1Var = this.f7258a[i8];
            if (p1Var.b(cls)) {
                return p1Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // l3.p1
    public final boolean b(Class cls) {
        for (int i8 = 0; i8 < 2; i8++) {
            if (this.f7258a[i8].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
