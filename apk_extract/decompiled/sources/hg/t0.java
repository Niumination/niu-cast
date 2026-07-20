package hg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f5379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f5380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wi.k f5381c;

    public t0(v0 type, f1 version, wi.k packet) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(packet, "packet");
        this.f5379a = type;
        this.f5380b = version;
        this.f5381c = packet;
    }

    public /* synthetic */ t0(v0 v0Var, wi.k kVar) {
        this(v0Var, f1.TLS12, kVar);
    }
}
