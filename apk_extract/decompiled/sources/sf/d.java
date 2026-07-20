package sf;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zf.r;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends kf.c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(jf.d client, Function0 block, kf.c originCall, r responseHeaders) {
        super(client);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(originCall, "originCall");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        kf.h hVar = new kf.h(this, originCall.d());
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.f6856b = hVar;
        e eVar = new e(this, block, originCall.e(), responseHeaders);
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.f6857c = eVar;
    }
}
