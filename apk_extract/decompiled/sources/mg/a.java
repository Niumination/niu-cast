package mg;

import java.io.Closeable;
import java.io.IOException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import li.g0;
import li.i2;
import li.o1;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c implements g0 {
    public final String q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final yf.c f8043r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CoroutineContext f8044s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i2 f8045t;
    public final CoroutineContext u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(qg.b environment, boolean z2, String rootPath, yf.c monitor, CoroutineContext parentCoroutineContext, PropertyReference0Impl engineProvider) {
        super(z2, environment);
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(rootPath, "rootPath");
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        Intrinsics.checkNotNullParameter(parentCoroutineContext, "parentCoroutineContext");
        Intrinsics.checkNotNullParameter(engineProvider, "engineProvider");
        this.q = rootPath;
        this.f8043r = monitor;
        this.f8044s = parentCoroutineContext;
        i2 i2Var = new i2((p1) parentCoroutineContext.get(o1.f7483a));
        this.f8045t = i2Var;
        this.u = parentCoroutineContext.plus(i2Var);
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.u;
    }

    public final void s() throws IOException {
        Object objD;
        this.f8045t.h(null);
        zg.a aVar = e.f8062a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        for (zg.a key : CollectionsKt.toList(e.a(this).c().keySet())) {
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            Intrinsics.checkNotNullParameter(this, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            zg.h hVar = (zg.h) this.f5397a.d(e.f8062a);
            if (hVar != null && (objD = hVar.d(key)) != null) {
                if (objD instanceof Closeable) {
                    ((Closeable) objD).close();
                }
                Intrinsics.checkNotNullParameter(key, "key");
                hVar.c().remove(key);
            }
        }
    }
}
