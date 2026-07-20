package pf;

import k3.g2;
import k3.pc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vj.b f8868a = g2.a("io.ktor.client.plugins.HttpRequestLifecycle");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final qf.c f8869b;

    static {
        ag.b body = new ag.b(27);
        Intrinsics.checkNotNullParameter("RequestLifecycle", "name");
        Intrinsics.checkNotNullParameter(body, "body");
        f8869b = pc.a("RequestLifecycle", new ob.c(9), body);
    }
}
