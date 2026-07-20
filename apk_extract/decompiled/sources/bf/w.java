package bf;

import af.p5;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ze.c2;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends Lambda implements Function0 {
    final /* synthetic */ c2 $call;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(c2 c2Var) {
        super(0);
        this.$call = c2Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        p5 p5Var = (p5) this.$call;
        return Boolean.valueOf(p5Var.f517j ? false : p5Var.f510a.isReady());
    }
}
