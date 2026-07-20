package no;

import eo.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "companionObject";
        } else if (i10 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i10 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i10 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i10 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(@os.l eo.b bVar) {
        eo.w wVarT0;
        if (bVar == null) {
            a(3);
        }
        if ((bVar instanceof t0) && (wVarT0 = ((t0) bVar).t0()) != null && wVarT0.getAnnotations().p(y.f11797b)) {
            return true;
        }
        return bVar.getAnnotations().p(y.f11797b);
    }

    public static boolean c(@os.l eo.m mVar) {
        if (mVar == null) {
            a(1);
        }
        return hp.d.x(mVar) && hp.d.w(mVar.b()) && !d((eo.e) mVar);
    }

    public static boolean d(@os.l eo.e eVar) {
        if (eVar == null) {
            a(2);
        }
        return ao.d.a(ao.c.f519a, eVar);
    }

    public static boolean e(@os.l t0 t0Var) {
        if (t0Var == null) {
            a(0);
        }
        if (t0Var.getKind() == eo.b.a.FAKE_OVERRIDE) {
            return false;
        }
        if (c(t0Var.b())) {
            return true;
        }
        return hp.d.x(t0Var.b()) && b(t0Var);
    }
}
