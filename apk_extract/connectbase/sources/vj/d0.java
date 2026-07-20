package vj;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1770")
public final class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @e0("https://github.com/grpc/grpc-java/issues/6138")
    public static final vj.a.c<String> f17079d = new vj.a.c<>("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SocketAddress> f17080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.a f17081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17082c;

    @e0("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public d0(List<SocketAddress> list) {
        this(list, vj.a.f17046c);
    }

    public List<SocketAddress> a() {
        return this.f17080a;
    }

    public vj.a b() {
        return this.f17081b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (this.f17080a.size() != d0Var.f17080a.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f17080a.size(); i10++) {
            if (!this.f17080a.get(i10).equals(d0Var.f17080a.get(i10))) {
                return false;
            }
        }
        return this.f17081b.equals(d0Var.f17081b);
    }

    public int hashCode() {
        return this.f17082c;
    }

    public String toString() {
        return "[" + this.f17080a + "/" + this.f17081b + "]";
    }

    public d0(List<SocketAddress> list, vj.a aVar) {
        c1.h0.e(!list.isEmpty(), "addrs is empty");
        List<SocketAddress> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f17080a = listUnmodifiableList;
        this.f17081b = (vj.a) c1.h0.F(aVar, "attrs");
        this.f17082c = listUnmodifiableList.hashCode();
    }

    public d0(SocketAddress socketAddress) {
        this(socketAddress, vj.a.f17046c);
    }

    public d0(SocketAddress socketAddress, vj.a aVar) {
        this((List<SocketAddress>) Collections.singletonList(socketAddress), aVar);
    }
}
