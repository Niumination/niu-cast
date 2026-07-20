package xm;

import el.b0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kn.l0;
import kn.r1;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n37#2,2:135\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n131#1:135,2\n*E\n"})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f20293a = 1;

    public static final void a(int i10, int i11) {
        if (i11 <= i10) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
    }

    public static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    public static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @os.m
    @f1(version = "1.3")
    @in.i(name = "getSpilledVariableFieldMapping")
    public static final String[] d(@os.l a aVar) {
        l0.p(aVar, "<this>");
        f fVarB = b(aVar);
        if (fVarB == null) {
            return null;
        }
        a(1, fVarB.v());
        ArrayList arrayList = new ArrayList();
        int iC = c(aVar);
        int[] iArrI = fVarB.i();
        int length = iArrI.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (iArrI[i10] == iC) {
                arrayList.add(fVarB.s()[i10]);
                arrayList.add(fVarB.n()[i10]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @os.m
    @f1(version = "1.3")
    @in.i(name = "getStackTraceElement")
    public static final StackTraceElement e(@os.l a aVar) {
        String strC;
        l0.p(aVar, "<this>");
        f fVarB = b(aVar);
        if (fVarB == null) {
            return null;
        }
        a(1, fVarB.v());
        int iC = c(aVar);
        int i10 = iC < 0 ? -1 : fVarB.l()[iC];
        String strB = i.f20294a.b(aVar);
        if (strB == null) {
            strC = fVarB.c();
        } else {
            strC = strB + b0.f4502a + fVarB.c();
        }
        return new StackTraceElement(strC, fVarB.m(), fVarB.f(), i10);
    }
}
