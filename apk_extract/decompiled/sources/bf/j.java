package bf;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends Lambda implements Function0 {
    final /* synthetic */ ze.j $clientCall;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ze.j jVar) {
        super(0);
        this.$clientCall = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(this.$clientCall.c());
    }
}
