package qg;

import k3.c2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends IllegalStateException implements li.x {
    private final String content;
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String name, String content) {
        super("Header " + name + " is not allowed for " + content);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        this.name = name;
        this.content = content;
    }

    @Override // li.x
    public n createCopy() {
        n nVar = new n(this.name, this.content);
        c2.a(nVar, this);
        return nVar;
    }
}
