package ng;

import kotlin.jvm.internal.Intrinsics;
import li.g2;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g2 f8248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g2 f8249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final li.r f8250c;

    public b0(g2 rootServerJob, g2 acceptJob, li.r serverSocket) {
        Intrinsics.checkNotNullParameter(rootServerJob, "rootServerJob");
        Intrinsics.checkNotNullParameter(acceptJob, "acceptJob");
        Intrinsics.checkNotNullParameter(serverSocket, "serverSocket");
        this.f8248a = rootServerJob;
        this.f8249b = acceptJob;
        this.f8250c = serverSocket;
    }
}
