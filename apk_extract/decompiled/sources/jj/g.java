package jj;

import af.h3;
import af.i;
import af.j4;
import af.k5;
import af.z2;
import dj.b0;
import dj.d0;
import dj.e0;
import dj.h0;
import dj.i0;
import dj.j0;
import dj.u;
import hj.m;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import k3.s9;
import k3.t8;
import k3.v8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import qj.a0;
import qj.l;
import qj.s;
import qj.t;
import qj.x;
import qj.z;
import ze.v2;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements ij.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6329a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f6332d;
    public final Object e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f6333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f6334h;

    public g(b0 b0Var, m connection, t source, s sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.e = b0Var;
        this.f = connection;
        this.f6333g = source;
        this.f6334h = sink;
        this.f6331c = new i(source);
    }

    public static final void i(g gVar, l lVar) {
        gVar.getClass();
        qj.b0 b0Var = lVar.e;
        a0 delegate = qj.b0.f9179d;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        lVar.e = delegate;
        b0Var.a();
        b0Var.b();
    }

    @Override // ij.d
    public void a() {
        ((s) this.f6334h).flush();
    }

    @Override // ij.d
    public m b() {
        return (m) this.f;
    }

    @Override // ij.d
    public void c(e0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Proxy.Type proxyType = ((m) this.f).q.f4618b.type();
        Intrinsics.checkNotNullExpressionValue(proxyType, "connection.route().proxy.type()");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.f4529c);
        sb2.append(' ');
        u url = request.f4528b;
        if (url.f4633a || proxyType != Proxy.Type.HTTP) {
            Intrinsics.checkNotNullParameter(url, "url");
            String strB = url.b();
            String strD = url.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb2.append(strB);
        } else {
            sb2.append(url);
        }
        sb2.append(" HTTP/1.1");
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        k(request.f4530d, string);
    }

    @Override // ij.d
    public void cancel() {
        Socket socket = ((m) this.f).f5455b;
        if (socket != null) {
            ej.b.e(socket);
        }
    }

    @Override // ij.d
    public long d(j0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!ij.e.a(response)) {
            return 0L;
        }
        if (StringsKt__StringsJVMKt.equals("chunked", j0.a(response, "Transfer-Encoding"), true)) {
            return -1L;
        }
        return ej.b.k(response);
    }

    @Override // ij.d
    public z e(j0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!ij.e.a(response)) {
            return j(0L);
        }
        if (StringsKt__StringsJVMKt.equals("chunked", j0.a(response, "Transfer-Encoding"), true)) {
            u uVar = response.f4576a.f4528b;
            if (this.f6330b == 4) {
                this.f6330b = 5;
                return new c(this, uVar);
            }
            throw new IllegalStateException(("state: " + this.f6330b).toString());
        }
        long jK = ej.b.k(response);
        if (jK != -1) {
            return j(jK);
        }
        if (this.f6330b == 4) {
            this.f6330b = 5;
            ((m) this.f).k();
            return new f(this);
        }
        throw new IllegalStateException(("state: " + this.f6330b).toString());
    }

    @Override // ij.d
    public x f(e0 request, long j8) {
        Intrinsics.checkNotNullParameter(request, "request");
        h0 h0Var = request.e;
        if (StringsKt__StringsJVMKt.equals("chunked", request.a("Transfer-Encoding"), true)) {
            if (this.f6330b == 1) {
                this.f6330b = 2;
                return new b(this);
            }
            throw new IllegalStateException(("state: " + this.f6330b).toString());
        }
        if (j8 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f6330b == 1) {
            this.f6330b = 2;
            return new e(this);
        }
        throw new IllegalStateException(("state: " + this.f6330b).toString());
    }

    @Override // ij.d
    public i0 g(boolean z2) {
        i iVar = (i) this.f6331c;
        int i8 = this.f6330b;
        if (i8 != 1 && i8 != 3) {
            throw new IllegalStateException(("state: " + this.f6330b).toString());
        }
        try {
            String strL = ((t) iVar.f315b).l(iVar.f314a);
            iVar.f314a -= (long) strL.length();
            df.m mVarA = s9.a(strL);
            int i9 = mVarA.f4459c;
            i0 i0Var = new i0();
            d0 protocol = (d0) mVarA.f4460d;
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            i0Var.f4562b = protocol;
            i0Var.f4563c = i9;
            String message = (String) mVarA.f4458b;
            Intrinsics.checkNotNullParameter(message, "message");
            i0Var.f4564d = message;
            dj.s headers = iVar.a();
            Intrinsics.checkNotNullParameter(headers, "headers");
            i0Var.f = headers.g();
            if (z2 && i9 == 100) {
                return null;
            }
            if (i9 == 100) {
                this.f6330b = 3;
                return i0Var;
            }
            this.f6330b = 4;
            return i0Var;
        } catch (EOFException e) {
            throw new IOException(h0.a.i("unexpected end of stream on ", ((m) this.f).q.f4617a.f4470a.g()), e);
        }
    }

    @Override // ij.d
    public void h() {
        ((s) this.f6334h).flush();
    }

    public d j(long j8) {
        if (this.f6330b == 4) {
            this.f6330b = 5;
            return new d(this, j8);
        }
        throw new IllegalStateException(("state: " + this.f6330b).toString());
    }

    public void k(dj.s headers, String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (this.f6330b != 0) {
            throw new IllegalStateException(("state: " + this.f6330b).toString());
        }
        s sVar = (s) this.f6334h;
        sVar.v(requestLine);
        sVar.v("\r\n");
        int size = headers.size();
        for (int i8 = 0; i8 < size; i8++) {
            sVar.v(headers.f(i8));
            sVar.v(": ");
            sVar.v(headers.h(i8));
            sVar.v("\r\n");
        }
        sVar.v("\r\n");
        this.f6330b = 1;
    }

    public String toString() {
        switch (this.f6329a) {
            case 1:
                o6.a aVarA = t8.a(this);
                aVarA.c(this.f6330b, "defaultPort");
                aVarA.d((j4) this.f6331c, "proxyDetector");
                aVarA.d((v2) this.f6332d, "syncContext");
                aVarA.d((k5) this.e, "serviceConfigParser");
                aVarA.d((h3) this.f, "scheduledExecutorService");
                aVarA.d((af.t) this.f6333g, "channelLogger");
                aVarA.d((z2) this.f6334h, "executor");
                aVarA.d(null, "overrideAuthority");
                return aVarA.toString();
            default:
                return super.toString();
        }
    }

    public g(Integer num, j4 j4Var, v2 v2Var, k5 k5Var, h3 h3Var, af.t tVar, z2 z2Var) {
        v8.i(num, "defaultPort not set");
        this.f6330b = num.intValue();
        v8.i(j4Var, "proxyDetector not set");
        this.f6331c = j4Var;
        this.f6332d = v2Var;
        this.e = k5Var;
        this.f = h3Var;
        this.f6333g = tVar;
        this.f6334h = z2Var;
    }
}
