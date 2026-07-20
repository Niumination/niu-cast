package p001if;

import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import k3.v8;
import ze.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f5808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5809b;

    public g(c0 c0Var) {
        v8.i(c0Var, "eag");
        List list = c0Var.f11332a;
        this.f5808a = new String[list.size()];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f5808a[0] = ((SocketAddress) it.next()).toString();
        }
        Arrays.sort(this.f5808a);
        this.f5809b = Arrays.hashCode(this.f5808a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.f5809b == this.f5809b) {
            String[] strArr = gVar.f5808a;
            int length = strArr.length;
            String[] strArr2 = this.f5808a;
            if (length == strArr2.length) {
                return Arrays.equals(strArr, strArr2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5809b;
    }

    public final String toString() {
        return Arrays.toString(this.f5808a);
    }
}
