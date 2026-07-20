package wo;

import el.b0;
import eo.d1;
import eo.e1;
import eo.k0;
import eo.u0;
import jq.e0;
import jq.m0;
import kn.l0;
import lm.l2;
import vp.a1;
import vp.c1;
import vp.f0;
import vp.j1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    @os.l
    public static final String a(@os.l eo.e eVar, @os.l x<?> xVar) {
        l0.p(eVar, "klass");
        l0.p(xVar, "typeMappingConfiguration");
        String strA = xVar.a(eVar);
        if (strA != null) {
            return strA;
        }
        eo.m mVarB = eVar.b();
        l0.o(mVarB, "klass.containingDeclaration");
        String strF = dp.h.b(eVar.getName()).f();
        l0.o(strF, "safeIdentifier(klass.name).identifier");
        if (mVarB instanceof k0) {
            dp.c cVarE = ((k0) mVarB).e();
            if (cVarE.d()) {
                return strF;
            }
            StringBuilder sb2 = new StringBuilder();
            String strB = cVarE.b();
            l0.o(strB, "fqName.asString()");
            sb2.append(e0.h2(strB, n1.e.f11183c, b0.f4502a, false, 4, null));
            sb2.append(b0.f4502a);
            sb2.append(strF);
            return sb2.toString();
        }
        eo.e eVar2 = mVarB instanceof eo.e ? (eo.e) mVarB : null;
        if (eVar2 == null) {
            throw new IllegalArgumentException("Unexpected container: " + mVarB + " for " + eVar);
        }
        String strC = xVar.c(eVar2);
        if (strC == null) {
            strC = a(eVar2, xVar);
        }
        return strC + m0.f8865c + strF;
    }

    public static /* synthetic */ String b(eo.e eVar, x xVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            xVar = y.f19827a;
        }
        return a(eVar, xVar);
    }

    public static final boolean c(@os.l eo.a aVar) {
        l0.p(aVar, "descriptor");
        if (aVar instanceof eo.l) {
            return true;
        }
        f0 returnType = aVar.getReturnType();
        l0.m(returnType);
        if (ao.h.A0(returnType)) {
            f0 returnType2 = aVar.getReturnType();
            l0.m(returnType2);
            if (!j1.m(returnType2) && !(aVar instanceof u0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Object] */
    @os.l
    public static final <T> T d(@os.l f0 f0Var, @os.l l<T> lVar, @os.l z zVar, @os.l x<? extends T> xVar, @os.m i<T> iVar, @os.l jn.q<? super f0, ? super T, ? super z, l2> qVar) {
        T t10;
        f0 f0Var2;
        Object objD;
        l0.p(f0Var, "kotlinType");
        l0.p(lVar, "factory");
        l0.p(zVar, "mode");
        l0.p(xVar, "typeMappingConfiguration");
        l0.p(qVar, "writeGenericType");
        f0 f0VarE = xVar.e(f0Var);
        if (f0VarE != null) {
            return (T) d(f0VarE, lVar, zVar, xVar, iVar, qVar);
        }
        if (ao.g.o(f0Var)) {
            return (T) d(ao.l.a(f0Var), lVar, zVar, xVar, iVar, qVar);
        }
        wp.q qVar2 = wp.q.f19874a;
        Object objB = a0.b(qVar2, f0Var, lVar, zVar);
        if (objB != null) {
            ?? r10 = (Object) a0.a(lVar, objB, zVar.f19838a);
            qVar.invoke(f0Var, r10, zVar);
            return r10;
        }
        a1 a1VarG0 = f0Var.G0();
        if (a1VarG0 instanceof vp.e0) {
            vp.e0 e0Var = (vp.e0) a1VarG0;
            f0 f0VarF = e0Var.f17674a;
            if (f0VarF == null) {
                f0VarF = xVar.f(e0Var.f17675b);
            }
            return (T) d(zp.a.t(f0VarF), lVar, zVar, xVar, iVar, qVar);
        }
        eo.h hVarD = a1VarG0.d();
        if (hVarD == null) {
            throw new UnsupportedOperationException(l0.C("no descriptor for type constructor of ", f0Var));
        }
        if (vp.x.r(hVarD)) {
            T t11 = (T) lVar.e("error/NonExistentClass");
            xVar.b(f0Var, (eo.e) hVarD);
            if (iVar != 0) {
                iVar.c(t11);
            }
            return t11;
        }
        boolean z10 = hVarD instanceof eo.e;
        if (z10 && ao.h.c0(f0Var)) {
            if (f0Var.F0().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            c1 c1Var = f0Var.F0().get(0);
            f0 type = c1Var.getType();
            l0.o(type, "memberProjection.type");
            if (c1Var.c() == o1.IN_VARIANCE) {
                objD = lVar.e("java/lang/Object");
                if (iVar != 0) {
                    iVar.b();
                    iVar.c(objD);
                    iVar.a();
                }
            } else {
                if (iVar != 0) {
                    iVar.b();
                }
                o1 o1VarC = c1Var.c();
                l0.o(o1VarC, "memberProjection.projectionKind");
                objD = d(type, lVar, zVar.f(o1VarC, true), xVar, iVar, qVar);
                if (iVar != 0) {
                    iVar.a();
                }
            }
            return (T) lVar.a(l0.C("[", lVar.d(objD)));
        }
        if (!z10) {
            if (!(hVarD instanceof e1)) {
                if ((hVarD instanceof d1) && zVar.f19847j) {
                    return (T) d(((d1) hVarD).J(), lVar, zVar, xVar, iVar, qVar);
                }
                throw new UnsupportedOperationException(l0.C("Unknown type ", f0Var));
            }
            T t12 = (T) d(zp.a.i((e1) hVarD), lVar, zVar, xVar, null, eq.d.b());
            if (iVar != 0) {
                dp.f name = hVarD.getName();
                l0.o(name, "descriptor.getName()");
                iVar.e(name, t12);
            }
            return t12;
        }
        if (hp.f.b(hVarD) && !zVar.f19839b && (f0Var2 = (f0) vp.y.a(qVar2, f0Var)) != null) {
            return (T) d(f0Var2, lVar, zVar.g(), xVar, iVar, qVar);
        }
        if (zVar.f19840c && ao.h.j0((eo.e) hVarD)) {
            t10 = (Object) lVar.f();
        } else {
            eo.e eVar = (eo.e) hVarD;
            eo.e eVarA = eVar.a();
            l0.o(eVarA, "descriptor.original");
            T tD = xVar.d(eVarA);
            if (tD == null) {
                if (eVar.getKind() == eo.f.ENUM_ENTRY) {
                    eVar = (eo.e) eVar.b();
                }
                eo.e eVarA2 = eVar.a();
                l0.o(eVarA2, "enumClassIfEnumEntry.original");
                t10 = (Object) lVar.e(a(eVarA2, xVar));
            } else {
                t10 = (Object) tD;
            }
        }
        qVar.invoke(f0Var, t10, zVar);
        return t10;
    }

    public static /* synthetic */ Object e(f0 f0Var, l lVar, z zVar, x xVar, i iVar, jn.q qVar, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            qVar = eq.d.b();
        }
        return d(f0Var, lVar, zVar, xVar, iVar, qVar);
    }
}
