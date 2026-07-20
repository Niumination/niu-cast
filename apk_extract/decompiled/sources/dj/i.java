package dj;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4557a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f4558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f4559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4560d;

    public final j a() {
        return new j(this.f4557a, this.f4560d, this.f4558b, this.f4559c);
    }

    public final void b(h... cipherSuites) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
        if (!this.f4557a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(cipherSuites.length);
        for (h hVar : cipherSuites) {
            arrayList.add(hVar.f4556a);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        c((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void c(String... cipherSuites) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
        if (!this.f4557a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        if (cipherSuites.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        Object objClone = cipherSuites.clone();
        if (objClone == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        this.f4558b = (String[]) objClone;
    }

    public final void d(p0... tlsVersions) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
        if (!this.f4557a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(tlsVersions.length);
        for (p0 p0Var : tlsVersions) {
            arrayList.add(p0Var.javaName());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        e((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void e(String... tlsVersions) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
        if (!this.f4557a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        if (tlsVersions.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        Object objClone = tlsVersions.clone();
        if (objClone == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        this.f4559c = (String[]) objClone;
    }
}
