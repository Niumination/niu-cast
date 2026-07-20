package gg;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f5189a;

    public n(InetSocketAddress address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.f5189a = address;
    }

    @Override // gg.l
    public final SocketAddress c() {
        return this.f5189a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(n.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.network.sockets.InetSocketAddress");
        return Intrinsics.areEqual(this.f5189a, ((n) obj).f5189a);
    }

    public final int hashCode() {
        return this.f5189a.hashCode();
    }

    public final String toString() {
        String string = this.f5189a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(String hostname, int i8) {
        this(new InetSocketAddress(hostname, i8));
        Intrinsics.checkNotNullParameter(hostname, "hostname");
    }
}
