package m3;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import k3.ce;
import k3.zc;

/* JADX INFO: loaded from: classes.dex */
public final class pa implements ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o4.o f7834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final la f7835b;

    public pa(Context context, la laVar) {
        this.f7835b = laVar;
        b2.a aVar = b2.a.e;
        d2.l.b(context);
        qf.c cVarC = d2.l.a().c(aVar);
        if (b2.a.f1180d.contains(new a2.b("json"))) {
            new o4.o(new ce(cVarC, 2));
        }
        this.f7834a = new o4.o(new ce(cVarC, 3));
    }

    @Override // m3.ma
    public final void a(i1.a aVar) {
        d2.k kVar = (d2.k) this.f7834a.get();
        ((zc) aVar.f5525c).f6757h = false;
        zc zcVar = (zc) aVar.f5525c;
        zcVar.f = Boolean.FALSE;
        o9 o9Var = new o9(zcVar);
        u6.a aVar2 = (u6.a) aVar.f5524b;
        aVar2.f10378b = o9Var;
        try {
            sa.b();
            sa saVar = sa.f7857c;
            n7 n7Var = new n7(aVar2);
            u6.a aVar3 = new u6.a(10);
            saVar.a(aVar3);
            kVar.a(new a2.a(new qf.c(new HashMap((HashMap) aVar3.f10378b), 11, new HashMap((HashMap) aVar3.f10379c), (g) aVar3.f10380d).D(n7Var), a2.c.VERY_LOW));
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
