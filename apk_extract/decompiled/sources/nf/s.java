package nf;

import k3.g2;
import kotlin.jvm.internal.Intrinsics;
import m3.g6;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vj.b f8234a = g2.a("io.ktor.client.engine.cio.Endpoint");

    public static final long a(vf.d request, f engineConfig) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(engineConfig, "engineConfig");
        boolean zB = g6.b(request.f10561a.f11544j);
        if (request.a() != null || zB) {
            return Long.MAX_VALUE;
        }
        zg.a aVar = vf.e.f10566a;
        Intrinsics.checkNotNullParameter(request, "<this>");
        if (request.f10564d instanceof uf.g) {
            return Long.MAX_VALUE;
        }
        Intrinsics.checkNotNullParameter(request, "<this>");
        return engineConfig.f8217d;
    }
}
