package k3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class b1 {
    public static ze.g2 a(CoroutineContext context, ze.r1 descriptor, Function2 implementation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(implementation, "implementation");
        if (descriptor.f11422a == ze.q1.UNARY) {
            ze.g2 g2Var = new ze.g2(descriptor, new bf.u(0, context, new bf.h0(descriptor, implementation)));
            Intrinsics.checkNotNullExpressionValue(g2Var, "create(\n      descriptor…xt, implementation)\n    )");
            return g2Var;
        }
        throw new IllegalArgumentException(("Expected a unary method descriptor but got " + descriptor).toString());
    }
}
