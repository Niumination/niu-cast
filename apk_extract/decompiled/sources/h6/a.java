package h6;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Lambda implements Function0 {
    final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(0);
        this.this$0 = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final c invoke() {
        b mixAnimPlugin = this.this$0;
        Intrinsics.checkNotNullParameter(mixAnimPlugin, "mixAnimPlugin");
        return new c();
    }
}
