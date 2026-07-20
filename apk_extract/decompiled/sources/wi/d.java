package wi;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f10766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f10767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f10768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10769d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10770h;

    public d(k upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.f10766a = upstream;
        a buffer = upstream.getBuffer();
        this.f10767b = buffer;
        h hVar = buffer.f10762a;
        this.f10768c = hVar;
        this.f10769d = hVar != null ? hVar.f10777b : -1;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r7 == r9.f10777b) goto L15;
     */
    @Override // wi.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d0(wi.a r18, long r19) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: wi.d.d0(wi.a, long):long");
    }
}
