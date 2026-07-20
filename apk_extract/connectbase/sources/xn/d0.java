package xn;

import eo.t0;
import eo.u0;
import eo.v0;
import eo.z0;
import java.lang.reflect.Method;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final d0 f20319a = new d0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final dp.b f20320b;

    static {
        dp.b bVarM = dp.b.m(new dp.c("java.lang.Void"));
        l0.o(bVarM, "topLevel(FqName(\"java.lang.Void\"))");
        f20320b = bVarM;
    }

    public final ao.i a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return mp.e.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }

    public final boolean b(eo.y yVar) {
        if (hp.c.m(yVar) || hp.c.n(yVar)) {
            return true;
        }
        dp.f name = yVar.getName();
        co.a.f1681e.getClass();
        return l0.g(name, co.a.f1682f) && yVar.h().isEmpty();
    }

    @os.l
    public final dp.b c(@os.l Class<?> cls) {
        l0.p(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            l0.o(componentType, "klass.componentType");
            ao.i iVarA = a(componentType);
            if (iVarA != null) {
                return new dp.b(ao.k.f565m, iVarA.getArrayTypeName());
            }
            dp.b bVarM = dp.b.m(ao.k.a.f587i.l());
            l0.o(bVarM, "topLevel(StandardNames.FqNames.array.toSafe())");
            return bVarM;
        }
        if (l0.g(cls, Void.TYPE)) {
            return f20320b;
        }
        ao.i iVarA2 = a(cls);
        if (iVarA2 != null) {
            return new dp.b(ao.k.f565m, iVarA2.getTypeName());
        }
        dp.b bVarA = ko.d.a(cls);
        if (!bVarA.f3808c) {
            co.c cVar = co.c.f1685a;
            dp.c cVarB = bVarA.b();
            l0.o(cVarB, "classId.asSingleFqName()");
            dp.b bVarN = cVar.n(cVarB);
            if (bVarN != null) {
                return bVarN;
            }
        }
        return bVarA;
    }

    public final d.e d(eo.y yVar) {
        return new d.e(new cp.d.b(e(yVar), wo.u.c(yVar, false, false, 1, null)));
    }

    public final String e(eo.b bVar) {
        String strB = no.f0.b(bVar);
        if (strB != null) {
            return strB;
        }
        if (bVar instanceof u0) {
            String strB2 = lp.a.o(bVar).getName().b();
            l0.o(strB2, "descriptor.propertyIfAccessor.name.asString()");
            return no.y.b(strB2);
        }
        if (bVar instanceof v0) {
            String strB3 = lp.a.o(bVar).getName().b();
            l0.o(strB3, "descriptor.propertyIfAccessor.name.asString()");
            return no.y.e(strB3);
        }
        String strB4 = bVar.getName().b();
        l0.o(strB4, "descriptor.name.asString()");
        return strB4;
    }

    @os.l
    public final e f(@os.l t0 t0Var) {
        l0.p(t0Var, "possiblyOverriddenProperty");
        t0 t0VarA = ((t0) hp.d.L(t0Var)).a();
        l0.o(t0VarA, "unwrapFakeOverride(possi…rriddenProperty).original");
        if (t0VarA instanceof tp.k) {
            tp.k kVar = (tp.k) t0VarA;
            yo.a.n nVar = kVar.U;
            fp.i.g<yo.a.n, bp.a.d> gVar = bp.a.f1006d;
            l0.o(gVar, "propertySignature");
            bp.a.d dVar = (bp.a.d) ap.e.a(nVar, gVar);
            if (dVar != null) {
                return new e.c(t0VarA, nVar, dVar, kVar.V, kVar.W);
            }
        } else if (t0VarA instanceof po.f) {
            z0 source = ((po.f) t0VarA).getSource();
            to.a aVar = source instanceof to.a ? (to.a) source : null;
            uo.l lVarC = aVar == null ? null : aVar.c();
            if (lVarC instanceof ko.r) {
                return new e.a(((ko.r) lVarC).f9434a);
            }
            if (!(lVarC instanceof ko.u)) {
                throw new y("Incorrect resolution sequence for Java field " + t0VarA + " (source = " + lVarC + ')');
            }
            Method method = ((ko.u) lVarC).f9436a;
            v0 setter = t0VarA.getSetter();
            z0 source2 = setter == null ? null : setter.getSource();
            to.a aVar2 = source2 instanceof to.a ? (to.a) source2 : null;
            uo.l lVarC2 = aVar2 == null ? null : aVar2.c();
            ko.u uVar = lVarC2 instanceof ko.u ? (ko.u) lVarC2 : null;
            return new e.b(method, uVar != null ? uVar.f9436a : null);
        }
        u0 getter = t0VarA.getGetter();
        l0.m(getter);
        d.e eVarD = d(getter);
        v0 setter2 = t0VarA.getSetter();
        return new e.d(eVarD, setter2 != null ? d(setter2) : null);
    }

    @os.l
    public final d g(@os.l eo.y yVar) {
        cp.d.b bVarB;
        cp.d.b bVarE;
        l0.p(yVar, "possiblySubstitutedFunction");
        eo.y yVarA = ((eo.y) hp.d.L(yVar)).a();
        l0.o(yVarA, "unwrapFakeOverride(possi…titutedFunction).original");
        if (yVarA instanceof tp.c) {
            tp.c cVar = (tp.c) yVarA;
            fp.q qVarD0 = cVar.d0();
            if ((qVarD0 instanceof yo.a.i) && (bVarE = cp.g.f3382a.e((yo.a.i) qVarD0, cVar.K(), cVar.H())) != null) {
                return new d.e(bVarE);
            }
            if (!(qVarD0 instanceof yo.a.d) || (bVarB = cp.g.f3382a.b((yo.a.d) qVarD0, cVar.K(), cVar.H())) == null) {
                return d(yVarA);
            }
            eo.m mVarB = yVar.b();
            l0.o(mVarB, "possiblySubstitutedFunction.containingDeclaration");
            return hp.f.b(mVarB) ? new d.e(bVarB) : new d.C0520d(bVarB);
        }
        if (yVarA instanceof po.e) {
            z0 source = ((po.e) yVarA).getSource();
            to.a aVar = source instanceof to.a ? (to.a) source : null;
            uo.l lVarC = aVar == null ? null : aVar.c();
            ko.u uVar = lVarC instanceof ko.u ? (ko.u) lVarC : null;
            if (uVar != null) {
                return new d.c(uVar.f9436a);
            }
            throw new y(l0.C("Incorrect resolution sequence for Java method ", yVarA));
        }
        if (!(yVarA instanceof po.b)) {
            if (b(yVarA)) {
                return d(yVarA);
            }
            throw new y("Unknown origin of " + yVarA + " (" + yVarA.getClass() + ')');
        }
        z0 source2 = ((po.b) yVarA).getSource();
        to.a aVar2 = source2 instanceof to.a ? (to.a) source2 : null;
        uo.l lVarC2 = aVar2 != null ? aVar2.c() : null;
        if (lVarC2 instanceof ko.o) {
            return new d.b(((ko.o) lVarC2).f9432a);
        }
        if (lVarC2 instanceof ko.l) {
            ko.l lVar = (ko.l) lVarC2;
            if (lVar.f9428a.isAnnotation()) {
                return new d.a(lVar.f9428a);
            }
        }
        throw new y("Incorrect resolution sequence for Java constructor " + yVarA + " (" + lVarC2 + ')');
    }
}
