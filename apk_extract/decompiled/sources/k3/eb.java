package k3;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class eb {
    public static lg.c a(li.g0 g0Var, String name, long j8, Function1 onTimeout) {
        bb.s clock = new bb.s(20);
        Intrinsics.checkNotNullParameter(g0Var, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
        return new lg.c(name, j8, clock, g0Var, onTimeout);
    }
}
