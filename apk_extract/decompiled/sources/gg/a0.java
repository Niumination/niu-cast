package gg;

import java.net.SocketAddress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SocketAddress f5185a;

    static {
        try {
            Class.forName("java.net.UnixDomainSocketAddress");
        } catch (ClassNotFoundException unused) {
        }
    }

    public a0(SocketAddress address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.f5185a = address;
        if (!Intrinsics.areEqual(address.getClass().getName(), "java.net.UnixDomainSocketAddress")) {
            throw new IllegalStateException("address should be java.net.UnixDomainSocketAddress");
        }
    }

    @Override // gg.l
    public final SocketAddress c() {
        return this.f5185a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(a0.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.network.sockets.UnixSocketAddress");
        return Intrinsics.areEqual(this.f5185a, ((a0) obj).f5185a);
    }

    public final int hashCode() {
        return this.f5185a.hashCode();
    }

    public final String toString() {
        return this.f5185a.toString();
    }
}
