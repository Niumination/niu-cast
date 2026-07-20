package bq;

import eo.h1;
import eo.w0;
import eo.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import kn.w;
import nm.h0;
import os.m;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends bq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final i f1063a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final List<d> f1064b;

    public static final class a extends n0 implements jn.l<y, String> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @m
        public final String invoke(@os.l y yVar) {
            l0.p(yVar, "$this$$receiver");
            List<h1> listH = yVar.h();
            l0.o(listH, "valueParameters");
            h1 h1Var = (h1) h0.v3(listH);
            boolean z10 = false;
            if (h1Var != null && !lp.a.a(h1Var) && h1Var.s0() == null) {
                z10 = true;
            }
            i iVar = i.f1063a;
            if (z10) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    public static final class b extends n0 implements jn.l<y, String> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        public static final boolean a(eo.m mVar) {
            return (mVar instanceof eo.e) && ao.h.a0((eo.e) mVar);
        }

        @Override // jn.l
        @m
        public final String invoke(@os.l y yVar) {
            boolean z10;
            l0.p(yVar, "$this$$receiver");
            i iVar = i.f1063a;
            eo.m mVarB = yVar.b();
            l0.o(mVarB, "containingDeclaration");
            if (a(mVarB)) {
                z10 = true;
            } else {
                Collection<? extends y> collectionD = yVar.d();
                l0.o(collectionD, "overriddenDescriptors");
                Collection<? extends y> collection = collectionD;
                if (!collection.isEmpty()) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            eo.m mVarB2 = ((y) it.next()).b();
                            l0.o(mVarB2, "it.containingDeclaration");
                            if (a(mVarB2)) {
                                z10 = true;
                            }
                        }
                    }
                }
                z10 = false;
            }
            if (z10) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    public static final class c extends n0 implements jn.l<y, String> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @m
        public final String invoke(@os.l y yVar) {
            boolean zM;
            l0.p(yVar, "$this$$receiver");
            w0 w0VarO = yVar.O();
            if (w0VarO == null) {
                w0VarO = yVar.R();
            }
            i iVar = i.f1063a;
            boolean z10 = false;
            if (w0VarO != null) {
                f0 returnType = yVar.getReturnType();
                if (returnType == null) {
                    zM = false;
                } else {
                    f0 type = w0VarO.getType();
                    l0.o(type, "receiver.type");
                    zM = zp.a.m(returnType, type);
                }
                if (zM) {
                    z10 = true;
                }
            }
            if (z10) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        dp.f fVar = j.f1074j;
        f.b bVar = f.b.f1059b;
        d dVar = new d(fVar, new bq.b[]{bVar, new l.a(1)}, (jn.l) null, 4, (w) null);
        d dVar2 = new d(j.f1075k, new bq.b[]{bVar, new l.a(2)}, a.INSTANCE);
        dp.f fVar2 = j.f1066b;
        h hVar = h.f1061a;
        l.a aVar = new l.a(2);
        e eVar = e.f1055a;
        d dVar3 = new d(fVar2, new bq.b[]{bVar, hVar, aVar, eVar}, (jn.l) null, 4, (w) null);
        d dVar4 = new d(j.f1067c, new bq.b[]{bVar, hVar, new l.a(3), eVar}, (jn.l) null, 4, (w) null);
        d dVar5 = new d(j.f1068d, new bq.b[]{bVar, hVar, new l.b(2), eVar}, (jn.l) null, 4, (w) null);
        d dVar6 = new d(j.f1072h, new bq.b[]{bVar}, (jn.l) null, 4, (w) null);
        dp.f fVar3 = j.f1071g;
        l.d dVar7 = l.d.f1101b;
        k.a aVar2 = k.a.f1094d;
        d dVar8 = new d(fVar3, new bq.b[]{bVar, dVar7, hVar, aVar2}, (jn.l) null, 4, (w) null);
        dp.f fVar4 = j.f1073i;
        l.c cVar = l.c.f1100b;
        f1064b = nm.y.O(dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar8, new d(fVar4, new bq.b[]{bVar, cVar}, (jn.l) null, 4, (w) null), new d(j.f1076l, new bq.b[]{bVar, cVar}, (jn.l) null, 4, (w) null), new d(j.f1077m, new bq.b[]{bVar, cVar, aVar2}, (jn.l) null, 4, (w) null), new d(j.H, new bq.b[]{bVar, dVar7, hVar}, (jn.l) null, 4, (w) null), new d(j.f1069e, new bq.b[]{f.a.f1058b}, b.INSTANCE), new d(j.f1070f, new bq.b[]{bVar, k.b.f1095d, dVar7, hVar}, (jn.l) null, 4, (w) null), new d(j.Q, new bq.b[]{bVar, dVar7, hVar}, (jn.l) null, 4, (w) null), new d(j.P, new bq.b[]{bVar, cVar}, (jn.l) null, 4, (w) null), new d(nm.y.O(j.f1087w, j.f1088x), new bq.b[]{bVar}, c.INSTANCE), new d(j.R, new bq.b[]{bVar, k.c.f1096d, dVar7, hVar}, (jn.l) null, 4, (w) null), new d(j.f1079o, new bq.b[]{bVar, cVar}, (jn.l) null, 4, (w) null));
    }

    @Override // bq.a
    @os.l
    public List<d> b() {
        return f1064b;
    }
}
