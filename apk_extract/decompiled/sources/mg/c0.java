package mg;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import qg.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f8059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8061d;
    public CoroutineContext e;

    public c0(qg.b environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.f8058a = new ArrayList();
        this.f8059b = CollectionsKt.listOf(x0.f9125a);
        this.f8060c = "";
        this.f8061d = zg.s.f11604a;
        this.e = EmptyCoroutineContext.INSTANCE;
    }
}
