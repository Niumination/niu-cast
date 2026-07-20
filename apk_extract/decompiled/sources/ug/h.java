package ug;

import k3.c2;
import kotlin.jvm.internal.Intrinsics;
import li.x;
import zf.i;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends c implements x {
    private final i contentType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i contentType) {
        super("Content type " + contentType + " is not supported");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.contentType = contentType;
    }

    @Override // li.x
    public h createCopy() {
        h hVar = new h(this.contentType);
        c2.a(hVar, this);
        return hVar;
    }
}
