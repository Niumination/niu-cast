package dj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final j e;
    public static final j f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f4574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f4575d;

    static {
        h hVar = h.q;
        h hVar2 = h.f4553r;
        h hVar3 = h.f4554s;
        h hVar4 = h.f4548k;
        h hVar5 = h.f4550m;
        h hVar6 = h.f4549l;
        h hVar7 = h.f4551n;
        h hVar8 = h.p;
        h hVar9 = h.f4552o;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, h.f4546i, h.f4547j, h.f4544g, h.f4545h, h.e, h.f, h.f4543d};
        i iVar = new i();
        iVar.b((h[]) Arrays.copyOf(new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9}, 9));
        p0 p0Var = p0.TLS_1_3;
        p0 p0Var2 = p0.TLS_1_2;
        iVar.d(p0Var, p0Var2);
        if (!iVar.f4557a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        iVar.f4560d = true;
        iVar.a();
        i iVar2 = new i();
        iVar2.b((h[]) Arrays.copyOf(hVarArr, 16));
        iVar2.d(p0Var, p0Var2);
        if (!iVar2.f4557a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        iVar2.f4560d = true;
        e = iVar2.a();
        i iVar3 = new i();
        iVar3.b((h[]) Arrays.copyOf(hVarArr, 16));
        iVar3.d(p0Var, p0Var2, p0.TLS_1_1, p0.TLS_1_0);
        if (!iVar3.f4557a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        iVar3.f4560d = true;
        iVar3.a();
        f = new j(false, false, null, null);
    }

    public j(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.f4572a = z2;
        this.f4573b = z3;
        this.f4574c = strArr;
        this.f4575d = strArr2;
    }

    public final List a() {
        String[] strArr = this.f4574c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(h.f4555t.d(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final boolean b(SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.f4572a) {
            return false;
        }
        String[] strArr = this.f4575d;
        if (strArr != null && !ej.b.j(strArr, socket.getEnabledProtocols(), ComparisonsKt.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.f4574c;
        return strArr2 == null || ej.b.j(strArr2, socket.getEnabledCipherSuites(), h.f4541b);
    }

    public final List c() {
        String[] strArr = this.f4575d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            p0.Companion.getClass();
            arrayList.add(o0.a(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        j jVar = (j) obj;
        boolean z2 = jVar.f4572a;
        boolean z3 = this.f4572a;
        if (z3 != z2) {
            return false;
        }
        return !z3 || (Arrays.equals(this.f4574c, jVar.f4574c) && Arrays.equals(this.f4575d, jVar.f4575d) && this.f4573b == jVar.f4573b);
    }

    public final int hashCode() {
        if (!this.f4572a) {
            return 17;
        }
        String[] strArr = this.f4574c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f4575d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f4573b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f4572a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f4573b + ')';
    }
}
