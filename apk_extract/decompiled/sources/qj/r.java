package qj;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f9213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f9214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f9215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9216d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9217h;

    public r(h upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.f9213a = upstream;
        f buffer = upstream.getBuffer();
        this.f9214b = buffer;
        u uVar = buffer.f9194a;
        this.f9215c = uVar;
        this.f9216d = uVar != null ? uVar.f9225b : -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r5.f9225b) goto L15;
     */
    @Override // qj.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long W(qj.f r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6f
            boolean r3 = r8.e
            if (r3 != 0) goto L67
            qj.u r3 = r8.f9215c
            qj.f r4 = r8.f9214b
            if (r3 == 0) goto L2b
            qj.u r5 = r4.f9194a
            if (r3 != r5) goto L23
            int r3 = r8.f9216d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.f9225b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Peek source is invalid because upstream source was used"
            r8.<init>(r9)
            throw r8
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.f9217h
            r2 = 1
            long r0 = r0 + r2
            qj.h r2 = r8.f9213a
            boolean r0 = r2.request(r0)
            if (r0 != 0) goto L3e
            r8 = -1
            return r8
        L3e:
            qj.u r0 = r8.f9215c
            if (r0 != 0) goto L4f
            qj.u r0 = r4.f9194a
            if (r0 == 0) goto L4f
            r8.f9215c = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.f9225b
            r8.f9216d = r0
        L4f:
            long r0 = r4.f9195b
            long r2 = r8.f9217h
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            qj.f r2 = r8.f9214b
            long r4 = r8.f9217h
            r3 = r9
            r6 = r10
            r2.i(r3, r4, r6)
            long r0 = r8.f9217h
            long r0 = r0 + r10
            r8.f9217h = r0
            return r10
        L67:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "closed"
            r8.<init>(r9)
            throw r8
        L6f:
            java.lang.String r8 = "byteCount < 0: "
            java.lang.String r8 = o.d.j(r8, r10)
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: qj.r.W(qj.f, long):long");
    }

    @Override // qj.z
    public final b0 b() {
        return this.f9213a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.e = true;
    }
}
