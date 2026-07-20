package hh;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5403a;

    public h(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f5403a = name;
    }

    public final String toString() {
        return h0.a.n(new StringBuilder("Phase('"), this.f5403a, "')");
    }
}
