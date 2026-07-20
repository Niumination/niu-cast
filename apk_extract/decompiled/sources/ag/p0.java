package ag;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wi.a f780a = new wi.a();

    public final void a() {
        wi.a aVar = this.f780a;
        aVar.s((byte) 13);
        aVar.s((byte) 10);
    }

    public final void b(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        wi.a aVar = this.f780a;
        lh.a.a(aVar, name);
        lh.a.a(aVar, ": ");
        lh.a.a(aVar, value);
        aVar.s((byte) 13);
        aVar.s((byte) 10);
    }

    public final void c(zf.x method, String uri, String version) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(version, "version");
        wi.a aVar = this.f780a;
        lh.a.n(aVar, method.f11559a, 0, 0, 14);
        aVar.s((byte) 32);
        lh.a.n(aVar, uri, 0, 0, 14);
        aVar.s((byte) 32);
        lh.a.n(aVar, version, 0, 0, 14);
        aVar.s((byte) 13);
        aVar.s((byte) 10);
    }

    public final void d(int i8, String version, String statusText) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        wi.a aVar = this.f780a;
        lh.a.n(aVar, version, 0, 0, 14);
        aVar.s((byte) 32);
        lh.a.n(aVar, String.valueOf(i8), 0, 0, 14);
        aVar.s((byte) 32);
        lh.a.n(aVar, statusText, 0, 0, 14);
        aVar.s((byte) 13);
        aVar.s((byte) 10);
    }
}
