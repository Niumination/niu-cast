package bf;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ze.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends Lambda implements Function1 {
    final /* synthetic */ r1 $descriptor;
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $implementation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h0(r1 r1Var, Function2<Object, ? super Continuation<Object>, ? extends Object> function2) {
        super(1);
        this.$descriptor = r1Var;
        this.$implementation = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final oi.h invoke(oi.h requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        return new g0(j3.x.a(requests, this.$descriptor), this.$implementation);
    }
}
