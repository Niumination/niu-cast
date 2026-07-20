package gg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5206d;

    @Override // gg.w
    public final void c(y from) {
        Intrinsics.checkNotNullParameter(from, "from");
        super.c(from);
        if (from instanceof x) {
            x xVar = (x) from;
            this.f5204b = xVar.f5204b;
            this.f5205c = xVar.f5205c;
        }
    }
}
