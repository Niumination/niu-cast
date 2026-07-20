package sp;

import ao.k;
import eo.h0;
import eo.j0;
import eo.m0;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kn.g0;
import kn.l0;
import kn.l1;
import nm.k0;
import nm.z;
import os.l;
import os.m;
import rp.i;
import rp.j;
import rp.q;
import rp.r;
import rp.u;
import un.h;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ao.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final d f15198b = new d();

    public /* synthetic */ class a extends g0 implements jn.l<String, InputStream> {
        public a(Object obj) {
            super(1, obj);
        }

        @Override // kn.q, un.c
        @l
        public final String getName() {
            return "loadResource";
        }

        @Override // kn.q
        @l
        public final h getOwner() {
            return l1.d(d.class);
        }

        @Override // kn.q
        @l
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // jn.l
        @m
        public final InputStream invoke(@l String str) {
            l0.p(str, "p0");
            return ((d) this.receiver).a(str);
        }
    }

    @Override // ao.a
    @l
    public eo.l0 a(@l n nVar, @l h0 h0Var, @l Iterable<? extends go.b> iterable, @l go.c cVar, @l go.a aVar, boolean z10) {
        l0.p(nVar, "storageManager");
        l0.p(h0Var, "builtInsModule");
        l0.p(iterable, "classDescriptorFactories");
        l0.p(cVar, "platformDependentDeclarationFilter");
        l0.p(aVar, "additionalClassPartsProvider");
        return b(nVar, h0Var, k.f570r, iterable, cVar, aVar, z10, new a(this.f15198b));
    }

    @l
    public final eo.l0 b(@l n nVar, @l h0 h0Var, @l Set<dp.c> set, @l Iterable<? extends go.b> iterable, @l go.c cVar, @l go.a aVar, boolean z10, @l jn.l<? super String, ? extends InputStream> lVar) {
        l0.p(nVar, "storageManager");
        l0.p(h0Var, "module");
        l0.p(set, "packageFqNames");
        l0.p(iterable, "classDescriptorFactories");
        l0.p(cVar, "platformDependentDeclarationFilter");
        l0.p(aVar, "additionalClassPartsProvider");
        l0.p(lVar, "loadResource");
        ArrayList arrayList = new ArrayList(z.b0(set, 10));
        for (dp.c cVar2 : set) {
            String strN = sp.a.f15197n.n(cVar2);
            InputStream inputStreamInvoke = lVar.invoke(strN);
            if (inputStreamInvoke == null) {
                throw new IllegalStateException(l0.C("Resource not found in classpath: ", strN));
            }
            arrayList.add(c.f15199z.a(cVar2, nVar, h0Var, inputStreamInvoke, z10));
        }
        m0 m0Var = new m0(arrayList);
        j0 j0Var = new j0(nVar, h0Var);
        rp.k.a aVar2 = rp.k.a.f14747a;
        rp.n nVar2 = new rp.n(m0Var);
        sp.a aVar3 = sp.a.f15197n;
        rp.d dVar = new rp.d(h0Var, j0Var, aVar3);
        u.a aVar4 = u.a.f14772a;
        q qVar = q.f14766a;
        l0.o(qVar, "DO_NOTHING");
        mo.c.a aVar5 = mo.c.a.f10855a;
        r.a aVar6 = r.a.f14767a;
        i.f14724a.getClass();
        j jVar = new j(nVar, h0Var, aVar2, nVar2, dVar, m0Var, aVar4, qVar, aVar5, aVar6, iterable, j0Var, i.a.f14726b, aVar, cVar, aVar3.f14100a, null, new np.b(nVar, k0.INSTANCE), null, 327680, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).F0(jVar);
        }
        return m0Var;
    }
}
