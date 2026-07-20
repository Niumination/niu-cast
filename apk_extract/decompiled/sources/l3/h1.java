package l3;

/* JADX INFO: loaded from: classes.dex */
public final class h1 extends i1 {
    @Override // l3.i1
    public final void a(long j8, Object obj) {
        r rVar = (r) ((y0) x2.i(j8, obj));
        if (rVar.f7286a) {
            rVar.f7286a = false;
        }
    }

    @Override // l3.i1
    public final void b(long j8, Object obj, Object obj2) {
        y0 y0VarB = (y0) x2.i(j8, obj);
        y0 y0Var = (y0) x2.i(j8, obj2);
        int size = y0VarB.size();
        int size2 = y0Var.size();
        if (size > 0 && size2 > 0) {
            if (!((r) y0VarB).f7286a) {
                y0VarB = y0VarB.b(size2 + size);
            }
            y0VarB.addAll(y0Var);
        }
        if (size > 0) {
            y0Var = y0VarB;
        }
        x2.p(j8, obj, y0Var);
    }
}
