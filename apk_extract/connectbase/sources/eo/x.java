package eo;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    public /* synthetic */ class a extends kn.g0 implements jn.l<dp.b, dp.b> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return kn.l1.d(dp.b.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // jn.l
        @os.m
        public final dp.b invoke(@os.l dp.b bVar) {
            kn.l0.p(bVar, "p0");
            return bVar.g();
        }
    }

    public static final class b extends kn.n0 implements jn.l<dp.b, Integer> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Integer invoke(@os.l dp.b bVar) {
            kn.l0.p(bVar, "it");
            return 0;
        }
    }

    @os.m
    public static final e a(@os.l h0 h0Var, @os.l dp.b bVar) {
        kn.l0.p(h0Var, "<this>");
        kn.l0.p(bVar, "classId");
        h hVarB = b(h0Var, bVar);
        if (hVarB instanceof e) {
            return (e) hVarB;
        }
        return null;
    }

    @os.m
    public static final h b(@os.l h0 h0Var, @os.l dp.b bVar) {
        h hVarF;
        kn.l0.p(h0Var, "<this>");
        kn.l0.p(bVar, "classId");
        h0 h0VarA = hp.n.a(h0Var);
        if (h0VarA == null) {
            dp.c cVarH = bVar.h();
            kn.l0.o(cVarH, "classId.packageFqName");
            p0 p0VarO0 = h0Var.o0(cVarH);
            List<dp.f> listF = bVar.i().f();
            kn.l0.o(listF, "classId.relativeClassName.pathSegments()");
            op.h hVarO = p0VarO0.o();
            Object objB2 = nm.h0.B2(listF);
            kn.l0.o(objB2, "segments.first()");
            hVarF = hVarO.f((dp.f) objB2, mo.d.FROM_DESERIALIZATION);
            if (hVarF == null) {
                return null;
            }
            for (dp.f fVar : listF.subList(1, listF.size())) {
                if (!(hVarF instanceof e)) {
                    return null;
                }
                op.h hVarV = ((e) hVarF).V();
                kn.l0.o(fVar, "name");
                h hVarF2 = hVarV.f(fVar, mo.d.FROM_DESERIALIZATION);
                hVarF = hVarF2 instanceof e ? (e) hVarF2 : null;
                if (hVarF == null) {
                    return null;
                }
            }
        } else {
            dp.c cVarH2 = bVar.h();
            kn.l0.o(cVarH2, "classId.packageFqName");
            p0 p0VarO1 = h0VarA.o0(cVarH2);
            List<dp.f> listF2 = bVar.i().f();
            kn.l0.o(listF2, "classId.relativeClassName.pathSegments()");
            op.h hVarO2 = p0VarO1.o();
            Object objB3 = nm.h0.B2(listF2);
            kn.l0.o(objB3, "segments.first()");
            h hVarF3 = hVarO2.f((dp.f) objB3, mo.d.FROM_DESERIALIZATION);
            if (hVarF3 == null) {
                hVarF3 = null;
                break;
            }
            for (dp.f fVar2 : listF2.subList(1, listF2.size())) {
                if (hVarF3 instanceof e) {
                    op.h hVarV2 = ((e) hVarF3).V();
                    kn.l0.o(fVar2, "name");
                    h hVarF4 = hVarV2.f(fVar2, mo.d.FROM_DESERIALIZATION);
                    hVarF3 = hVarF4 instanceof e ? (e) hVarF4 : null;
                    if (hVarF3 == null) {
                    }
                }
                hVarF3 = null;
            }
            if (hVarF3 != null) {
                return hVarF3;
            }
            dp.c cVarH3 = bVar.h();
            kn.l0.o(cVarH3, "classId.packageFqName");
            p0 p0VarO2 = h0Var.o0(cVarH3);
            List<dp.f> listF3 = bVar.i().f();
            kn.l0.o(listF3, "classId.relativeClassName.pathSegments()");
            op.h hVarO3 = p0VarO2.o();
            Object objB4 = nm.h0.B2(listF3);
            kn.l0.o(objB4, "segments.first()");
            hVarF = hVarO3.f((dp.f) objB4, mo.d.FROM_DESERIALIZATION);
            if (hVarF == null) {
                return null;
            }
            for (dp.f fVar3 : listF3.subList(1, listF3.size())) {
                if (!(hVarF instanceof e)) {
                    return null;
                }
                op.h hVarV3 = ((e) hVarF).V();
                kn.l0.o(fVar3, "name");
                h hVarF5 = hVarV3.f(fVar3, mo.d.FROM_DESERIALIZATION);
                hVarF = hVarF5 instanceof e ? (e) hVarF5 : null;
                if (hVarF == null) {
                    return null;
                }
            }
        }
        return hVarF;
    }

    @os.l
    public static final e c(@os.l h0 h0Var, @os.l dp.b bVar, @os.l j0 j0Var) {
        kn.l0.p(h0Var, "<this>");
        kn.l0.p(bVar, "classId");
        kn.l0.p(j0Var, "notFoundClasses");
        e eVarA = a(h0Var, bVar);
        return eVarA != null ? eVarA : j0Var.d(bVar, gq.v.c3(gq.v.k1(gq.s.l(bVar, a.INSTANCE), b.INSTANCE)));
    }

    @os.m
    public static final d1 d(@os.l h0 h0Var, @os.l dp.b bVar) {
        kn.l0.p(h0Var, "<this>");
        kn.l0.p(bVar, "classId");
        h hVarB = b(h0Var, bVar);
        if (hVarB instanceof d1) {
            return (d1) hVarB;
        }
        return null;
    }
}
