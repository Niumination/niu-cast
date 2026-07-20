package dj;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f4537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f4538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4540d;

    public g0(byte[] bArr, x xVar, int i8, int i9) {
        this.f4537a = bArr;
        this.f4538b = xVar;
        this.f4539c = i8;
        this.f4540d = i9;
    }

    @Override // dj.h0
    public final long a() {
        return this.f4539c;
    }

    @Override // dj.h0
    public final x b() {
        return this.f4538b;
    }

    @Override // dj.h0
    public final void c(qj.g sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        sink.Y(this.f4537a, this.f4540d, this.f4539c);
    }
}
