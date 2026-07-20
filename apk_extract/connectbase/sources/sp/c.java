package sp;

import eo.h0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import kn.l0;
import kn.w;
import lb.f;
import os.l;
import rp.p;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends p implements ao.b {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @l
    public static final a f15199z = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f15200y;

    public static final class a {
        public a() {
        }

        @l
        public final c a(@l dp.c cVar, @l n nVar, @l h0 h0Var, @l InputStream inputStream, boolean z10) throws IllegalAccessException, IOException, InvocationTargetException {
            zo.a aVar;
            l0.p(cVar, "fqName");
            l0.p(nVar, "storageManager");
            l0.p(h0Var, "module");
            l0.p(inputStream, "inputStream");
            try {
                zo.a aVarA = zo.a.f21949g.a(inputStream);
                if (aVarA == null) {
                    l0.S(f.f9782f);
                    aVar = null;
                } else {
                    aVar = aVarA;
                }
                zo.a aVar2 = zo.a.f21950h;
                if (aVar.f(aVar2)) {
                    yo.a.m from = yo.a.m.parseFrom(inputStream, sp.a.f15197n.f14100a);
                    dn.c.a(inputStream, null);
                    l0.o(from, "proto");
                    return new c(cVar, nVar, h0Var, from, aVarA, z10);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + aVar2 + ", actual " + aVarA + ". Please update Kotlin");
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    dn.c.a(inputStream, th2);
                    throw th3;
                }
            }
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ c(dp.c cVar, n nVar, h0 h0Var, yo.a.m mVar, zo.a aVar, boolean z10, w wVar) {
        this(cVar, nVar, h0Var, mVar, aVar, z10);
    }

    @Override // ho.z, ho.j
    @l
    public String toString() {
        return "builtins package fragment for " + this.f7473e + " from " + lp.a.l(this);
    }

    public c(dp.c cVar, n nVar, h0 h0Var, yo.a.m mVar, zo.a aVar, boolean z10) {
        super(cVar, nVar, h0Var, mVar, aVar, null);
        this.f15200y = z10;
    }
}
