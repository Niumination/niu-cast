package l1;

import j1.x;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class t implements m1.a, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f7184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1.e f7185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r1.q f7186c;

    public t(x xVar, s1.c cVar, r1.p pVar) {
        this.f7184a = xVar;
        pVar.getClass();
        m1.i iVarG = pVar.f9287a.g();
        this.f7185b = iVarG;
        cVar.f(iVarG);
        iVarG.a(this);
    }

    public static int c(int i8, int i9) {
        int i10 = i8 / i9;
        if ((i8 ^ i9) < 0 && i10 * i9 != i8) {
            i10--;
        }
        return i8 - (i10 * i9);
    }

    @Override // m1.a
    public final void a() {
        this.f7184a.invalidateSelf();
    }

    @Override // l1.d
    public final void b(List list, List list2) {
    }
}
