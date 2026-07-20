package ug;

import k3.c2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import li.x;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c implements x {
    private final KType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(KType type) {
        super("Cannot transform this request's content to " + type);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    @Override // li.x
    public b createCopy() {
        b bVar = new b(this.type);
        c2.a(bVar, this);
        return bVar;
    }
}
