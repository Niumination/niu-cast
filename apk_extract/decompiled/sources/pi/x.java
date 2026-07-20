package pi;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3 f8910a;

    static {
        w wVar = w.INSTANCE;
        Intrinsics.checkNotNull(wVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f8910a = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(wVar, 3);
    }
}
