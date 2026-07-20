package hk;

import gk.v;
import ik.i;
import jn.l;
import kn.l0;
import kn.n0;
import lm.l2;
import v1.e;
import v1.f;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    public static final class a extends n0 implements l<f, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l f fVar) {
            l0.p(fVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(f fVar) {
            invoke2(fVar);
            return l2.f10208a;
        }
    }

    public static final void b(@os.l v.a aVar, @os.l i iVar, @os.l l<? super f, l2> lVar) {
        l0.p(aVar, "<this>");
        l0.p(iVar, "contentType");
        l0.p(lVar, "block");
        f fVar = new f();
        lVar.invoke(fVar);
        e eVarCreate = fVar.create();
        l0.o(eVarCreate, "builder.create()");
        v.a.f(aVar, iVar, new b(eVarCreate), null, 4, null);
    }

    public static void c(v.a aVar, i iVar, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i.a.f7985a.getClass();
            iVar = i.a.f7989e;
        }
        if ((i10 & 2) != 0) {
            lVar = a.INSTANCE;
        }
        b(aVar, iVar, lVar);
    }

    public static final boolean d(e eVar, un.d<?> dVar) {
        return eVar.excluder().excludeClass(in.b.e(dVar), false);
    }
}
