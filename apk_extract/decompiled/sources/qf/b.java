package qf;

import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf.d f9042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ob.c f9045d;

    public b(zg.a key, jf.d client, Object pluginConfig) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(pluginConfig, "pluginConfig");
        this.f9042a = client;
        this.f9043b = pluginConfig;
        this.f9044c = new ArrayList();
        this.f9045d = new ob.c(7);
    }

    public final void a(a hook, SuspendLambda suspendLambda) {
        Intrinsics.checkNotNullParameter(hook, "hook");
        this.f9044c.add(new e(hook, suspendLambda));
    }
}
