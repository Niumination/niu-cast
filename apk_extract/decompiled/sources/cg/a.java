package cg;

import kotlin.jvm.internal.Intrinsics;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zf.i f1672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f1673c;

    public a(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f1671a = bytes;
        this.f1672b = null;
        this.f1673c = null;
    }

    @Override // cg.j
    public final Long a() {
        return Long.valueOf(this.f1671a.length);
    }

    @Override // cg.j
    public final zf.i b() {
        return this.f1672b;
    }

    @Override // cg.j
    public final z d() {
        return this.f1673c;
    }

    @Override // cg.f
    public final byte[] e() {
        return this.f1671a;
    }
}
