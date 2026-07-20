package k3;

import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ha {
    public static final void a(jh.j0 j0Var) {
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        jh.o0.b(new jh.k0(j0Var));
    }

    public static final Object b(jh.j0 j0Var, ContinuationImpl continuationImpl) {
        Object objH;
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        jh.k kVar = (jh.k) j0Var;
        Throwable thC = kVar.c();
        if (thC != null) {
            throw thC;
        }
        jh.k kVar2 = j0Var instanceof jh.k ? (jh.k) j0Var : null;
        return (((kVar2 == null || !kVar2.f6290b) && lh.a.f(kVar.k()) < 1048576) || (objH = kVar.h(continuationImpl)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objH;
    }
}
