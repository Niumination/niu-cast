package dj;

import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f4576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f4577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4579d;
    public final q e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s f4580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m0 f4581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j0 f4582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j0 f4583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j0 f4584l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f4585m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f4586n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m f4587o;

    public j0(e0 request, d0 protocol, String message, int i8, q qVar, s headers, m0 m0Var, j0 j0Var, j0 j0Var2, j0 j0Var3, long j8, long j10, m mVar) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f4576a = request;
        this.f4577b = protocol;
        this.f4578c = message;
        this.f4579d = i8;
        this.e = qVar;
        this.f4580h = headers;
        this.f4581i = m0Var;
        this.f4582j = j0Var;
        this.f4583k = j0Var2;
        this.f4584l = j0Var3;
        this.f4585m = j8;
        this.f4586n = j10;
        this.f4587o = mVar;
    }

    public static String a(j0 j0Var, String name) {
        j0Var.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        String strE = j0Var.f4580h.e(name);
        if (strE != null) {
            return strE;
        }
        return null;
    }

    public final boolean c() {
        int i8 = this.f4579d;
        return 200 <= i8 && 299 >= i8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        m0 m0Var = this.f4581i;
        if (m0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        m0Var.close();
    }

    public final i0 g() {
        Intrinsics.checkNotNullParameter(this, "response");
        i0 i0Var = new i0();
        i0Var.f4561a = this.f4576a;
        i0Var.f4562b = this.f4577b;
        i0Var.f4563c = this.f4579d;
        i0Var.f4564d = this.f4578c;
        i0Var.e = this.e;
        i0Var.f = this.f4580h.g();
        i0Var.f4565g = this.f4581i;
        i0Var.f4566h = this.f4582j;
        i0Var.f4567i = this.f4583k;
        i0Var.f4568j = this.f4584l;
        i0Var.f4569k = this.f4585m;
        i0Var.f4570l = this.f4586n;
        i0Var.f4571m = this.f4587o;
        return i0Var;
    }

    public final String toString() {
        return "Response{protocol=" + this.f4577b + ", code=" + this.f4579d + ", message=" + this.f4578c + ", url=" + this.f4576a.f4528b + '}';
    }
}
