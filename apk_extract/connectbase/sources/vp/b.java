package vp;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends h implements a1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@os.l up.n nVar) {
        super(nVar);
        if (nVar == null) {
            u(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    private static /* synthetic */ void u(int i10) {
        String str = (i10 == 1 || i10 == 3 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 3 || i10 == 4) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else if (i10 == 2) {
            objArr[0] = "classifier";
        } else if (i10 == 3 || i10 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else {
            objArr[0] = "storageManager";
        }
        if (i10 == 1) {
            objArr[1] = "getBuiltIns";
        } else if (i10 == 3 || i10 == 4) {
            objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        }
        if (i10 != 1) {
            if (i10 == 2) {
                objArr[2] = "isSameClassifier";
            } else if (i10 != 3 && i10 != 4) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 3 && i10 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // vp.m
    public boolean h(@os.l eo.h hVar) {
        if (hVar == null) {
            u(2);
        }
        return (hVar instanceof eo.e) && f(d(), hVar);
    }

    @Override // vp.h
    @os.m
    public f0 l() {
        if (ao.h.s0(d())) {
            return null;
        }
        return n().i();
    }

    @Override // vp.h
    @os.l
    public Collection<f0> m(boolean z10) {
        eo.m mVarB = d().b();
        if (!(mVarB instanceof eo.e)) {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                u(3);
            }
            return listEmptyList;
        }
        eq.e eVar = new eq.e();
        eo.e eVar2 = (eo.e) mVarB;
        eVar.add(eVar2.q());
        eo.e eVarL0 = eVar2.l0();
        if (z10 && eVarL0 != null) {
            eVar.add(eVarL0.q());
        }
        return eVar;
    }

    @Override // vp.a1
    @os.l
    public ao.h n() {
        ao.h hVarG = lp.a.g(d());
        if (hVarG == null) {
            u(1);
        }
        return hVarG;
    }

    @Override // vp.m, vp.a1
    @os.l
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public abstract eo.e d();
}
