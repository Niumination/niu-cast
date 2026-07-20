package ze;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11331d = new a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11334c;

    public c0(SocketAddress socketAddress) {
        b bVar = b.f11321b;
        List listSingletonList = Collections.singletonList(socketAddress);
        v8.c("addrs is empty", !listSingletonList.isEmpty());
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(listSingletonList));
        this.f11332a = listUnmodifiableList;
        v8.i(bVar, "attrs");
        this.f11333b = bVar;
        this.f11334c = listUnmodifiableList.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        List list = this.f11332a;
        if (list.size() != c0Var.f11332a.size()) {
            return false;
        }
        for (int i8 = 0; i8 < list.size(); i8++) {
            if (!((SocketAddress) list.get(i8)).equals(c0Var.f11332a.get(i8))) {
                return false;
            }
        }
        return this.f11333b.equals(c0Var.f11333b);
    }

    public final int hashCode() {
        return this.f11334c;
    }

    public final String toString() {
        return "[" + this.f11332a + "/" + this.f11333b + "]";
    }
}
