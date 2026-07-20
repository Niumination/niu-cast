package ag;

import java.util.Iterator;
import java.util.Locale;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static final boolean a(CharSequence charSequence) {
        if (bg.g.a(charSequence, "chunked")) {
            return true;
        }
        boolean z2 = false;
        if (bg.g.a(charSequence, "identity")) {
            return false;
        }
        Iterator it = StringsKt__StringsKt.split$default(charSequence, new String[]{","}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            String lowerCase = StringsKt__StringsKt.trim((CharSequence) ((String) it.next())).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "chunked")) {
                if (z2) {
                    throw new IllegalArgumentException("Double-chunked TE is not supported: " + ((Object) charSequence));
                }
                z2 = true;
            } else if (!Intrinsics.areEqual(lowerCase, "identity")) {
                throw new IllegalArgumentException(h0.a.i("Unsupported transfer encoding ", lowerCase));
            }
        }
        return z2;
    }

    public static final Object b(zf.y yVar, long j8, CharSequence charSequence, r rVar, jh.o oVar, jh.j0 j0Var, SuspendLambda suspendLambda) throws Throwable {
        if (charSequence != null && a(charSequence)) {
            Object objB = p.b(oVar, j0Var, suspendLambda);
            return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
        }
        if (j8 != -1) {
            Object objC = jh.g0.c(oVar, j0Var, j8, suspendLambda);
            return objC == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objC : Unit.INSTANCE;
        }
        if ((rVar == null || !rVar.f784a) && !(rVar == null && Intrinsics.areEqual(yVar, zf.y.f))) {
            jh.o0.a(j0Var, new IllegalStateException("Failed to parse request body: request body length should be specified,\nchunked transfer encoding should be used or\nkeep-alive should be disabled (connection: close)"));
            return Unit.INSTANCE;
        }
        Object objC2 = jh.g0.c(oVar, j0Var, Long.MAX_VALUE, suspendLambda);
        return objC2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objC2 : Unit.INSTANCE;
    }
}
