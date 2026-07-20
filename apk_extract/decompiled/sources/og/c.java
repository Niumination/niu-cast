package og;

import java.net.InetSocketAddress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jh.k f8465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jh.k f8466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f8467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InetSocketAddress f8468d;

    public c(jh.k input, jh.k output, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        this.f8465a = input;
        this.f8466b = output;
        this.f8467c = inetSocketAddress;
        this.f8468d = inetSocketAddress2;
    }
}
