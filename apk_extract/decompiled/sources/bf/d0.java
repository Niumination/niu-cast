package bf;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ze.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends Lambda implements Function1 {
    final /* synthetic */ r1 $descriptor;
    final /* synthetic */ Function1<Object, oi.h> $implementation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(r1 r1Var, Function1<Object, ? extends oi.h> function1) {
        super(1);
        this.$descriptor = r1Var;
        this.$implementation = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final oi.h invoke(oi.h requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        return new oi.b0(new c0(requests, this.$descriptor, this.$implementation, null));
    }
}
