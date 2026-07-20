package cg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends n {
    public final String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String value, ag.e dispose, ag.d partHeaders) {
        super(dispose, partHeaders);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(dispose, "dispose");
        Intrinsics.checkNotNullParameter(partHeaders, "partHeaders");
        this.e = value;
    }
}
