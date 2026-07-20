package k3;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class de implements wd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o4.o f6412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o4.o f6413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vd f6414c;

    public de(Context context, vd vdVar) {
        this.f6414c = vdVar;
        b2.a aVar = b2.a.e;
        d2.l.b(context);
        qf.c cVarC = d2.l.a().c(aVar);
        if (b2.a.f1180d.contains(new a2.b("json"))) {
            this.f6412a = new o4.o(new ce(cVarC, 0));
        }
        this.f6413b = new o4.o(new ce(cVarC, 1));
    }

    @Override // k3.wd
    public final void a(df.m mVar) {
        int i8 = this.f6414c.f6687c;
        if (i8 != 0) {
            ((d2.k) this.f6413b.get()).a(mVar.f4459c != 0 ? new a2.a(mVar.h(i8), a2.c.DEFAULT) : new a2.a(mVar.h(i8), a2.c.VERY_LOW));
            return;
        }
        o4.o oVar = this.f6412a;
        if (oVar != null) {
            ((d2.k) oVar.get()).a(mVar.f4459c != 0 ? new a2.a(mVar.h(i8), a2.c.DEFAULT) : new a2.a(mVar.h(i8), a2.c.VERY_LOW));
        }
    }
}
