package dj;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f4618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f4619c;

    public n0(a address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.f4617a = address;
        this.f4618b = proxy;
        this.f4619c = socketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n0) {
            n0 n0Var = (n0) obj;
            if (Intrinsics.areEqual(n0Var.f4617a, this.f4617a) && Intrinsics.areEqual(n0Var.f4618b, this.f4618b) && Intrinsics.areEqual(n0Var.f4619c, this.f4619c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4619c.hashCode() + ((this.f4618b.hashCode() + ((this.f4617a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f4619c + '}';
    }
}
