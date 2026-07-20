package kj;

import dj.i0;
import dj.j0;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k3.s9;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements ij.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f6956g = ej.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f6957h = ej.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile a0 f6958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.d0 f6959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hj.m f6961d;
    public final ij.f e;
    public final s f;

    public t(dj.b0 client, hj.m connection, ij.f chain, s http2Connection) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.f6961d = connection;
        this.e = chain;
        this.f = http2Connection;
        client.getClass();
        List list = dj.b0.C;
        dj.d0 d0Var = dj.d0.H2_PRIOR_KNOWLEDGE;
        this.f6959b = list.contains(d0Var) ? d0Var : dj.d0.HTTP_2;
    }

    @Override // ij.d
    public final void a() {
        a0 a0Var = this.f6958a;
        Intrinsics.checkNotNull(a0Var);
        a0Var.g().close();
    }

    @Override // ij.d
    public final hj.m b() {
        return this.f6961d;
    }

    @Override // ij.d
    public final void c(dj.e0 request) throws IOException {
        int i8;
        a0 a0Var;
        boolean z2 = true;
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.f6958a != null) {
            return;
        }
        boolean z3 = request.e != null;
        Intrinsics.checkNotNullParameter(request, "request");
        dj.s sVar = request.f4530d;
        ArrayList requestHeaders = new ArrayList(sVar.size() + 4);
        requestHeaders.add(new d(request.f4529c, d.f));
        qj.j jVar = d.f6896g;
        dj.u url = request.f4528b;
        Intrinsics.checkNotNullParameter(url, "url");
        String strB = url.b();
        String strD = url.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        requestHeaders.add(new d(strB, jVar));
        String strA = request.a("Host");
        if (strA != null) {
            requestHeaders.add(new d(strA, d.f6898i));
        }
        requestHeaders.add(new d(url.f4634b, d.f6897h));
        int size = sVar.size();
        for (int i9 = 0; i9 < size; i9++) {
            String strF = sVar.f(i9);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (strF == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strF.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!f6956g.contains(lowerCase) || (Intrinsics.areEqual(lowerCase, "te") && Intrinsics.areEqual(sVar.h(i9), "trailers"))) {
                requestHeaders.add(new d(lowerCase, sVar.h(i9)));
            }
        }
        s sVar2 = this.f;
        sVar2.getClass();
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        boolean z5 = !z3;
        synchronized (sVar2.f6954y) {
            synchronized (sVar2) {
                try {
                    if (sVar2.e > 1073741823) {
                        sVar2.i(c.REFUSED_STREAM);
                    }
                    if (sVar2.f6940h) {
                        throw new a();
                    }
                    i8 = sVar2.e;
                    sVar2.e = i8 + 2;
                    a0Var = new a0(i8, sVar2, z5, false, null);
                    if (z3 && sVar2.f6951v < sVar2.f6952w && a0Var.f6877c < a0Var.f6878d) {
                        z2 = false;
                    }
                    if (a0Var.i()) {
                        sVar2.f6937b.put(Integer.valueOf(i8), a0Var);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            sVar2.f6954y.h(requestHeaders, i8, z5);
        }
        if (z2) {
            sVar2.f6954y.flush();
        }
        this.f6958a = a0Var;
        if (this.f6960c) {
            a0 a0Var2 = this.f6958a;
            Intrinsics.checkNotNull(a0Var2);
            a0Var2.e(c.CANCEL);
            throw new IOException("Canceled");
        }
        a0 a0Var3 = this.f6958a;
        Intrinsics.checkNotNull(a0Var3);
        z zVar = a0Var3.f6881i;
        long j8 = this.e.f5882h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zVar.g(j8, timeUnit);
        a0 a0Var4 = this.f6958a;
        Intrinsics.checkNotNull(a0Var4);
        a0Var4.f6882j.g(this.e.f5883i, timeUnit);
    }

    @Override // ij.d
    public final void cancel() {
        this.f6960c = true;
        a0 a0Var = this.f6958a;
        if (a0Var != null) {
            a0Var.e(c.CANCEL);
        }
    }

    @Override // ij.d
    public final long d(j0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (ij.e.a(response)) {
            return ej.b.k(response);
        }
        return 0L;
    }

    @Override // ij.d
    public final qj.z e(j0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        a0 a0Var = this.f6958a;
        Intrinsics.checkNotNull(a0Var);
        return a0Var.f6879g;
    }

    @Override // ij.d
    public final qj.x f(dj.e0 request, long j8) {
        Intrinsics.checkNotNullParameter(request, "request");
        a0 a0Var = this.f6958a;
        Intrinsics.checkNotNull(a0Var);
        return a0Var.g();
    }

    @Override // ij.d
    public final i0 g(boolean z2) throws IOException {
        dj.s headerBlock;
        a0 a0Var = this.f6958a;
        Intrinsics.checkNotNull(a0Var);
        synchronized (a0Var) {
            a0Var.f6881i.h();
            while (a0Var.e.isEmpty() && a0Var.f6883k == null) {
                try {
                    a0Var.l();
                } catch (Throwable th2) {
                    a0Var.f6881i.k();
                    throw th2;
                }
            }
            a0Var.f6881i.k();
            if (a0Var.e.isEmpty()) {
                IOException iOException = a0Var.f6884l;
                if (iOException != null) {
                    throw iOException;
                }
                c cVar = a0Var.f6883k;
                Intrinsics.checkNotNull(cVar);
                throw new f0(cVar);
            }
            Object objRemoveFirst = a0Var.e.removeFirst();
            Intrinsics.checkNotNullExpressionValue(objRemoveFirst, "headersQueue.removeFirst()");
            headerBlock = (dj.s) objRemoveFirst;
        }
        dj.d0 protocol = this.f6959b;
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = headerBlock.size();
        df.m mVarA = null;
        for (int i8 = 0; i8 < size; i8++) {
            String name = headerBlock.f(i8);
            String value = headerBlock.h(i8);
            if (Intrinsics.areEqual(name, ":status")) {
                mVarA = s9.a("HTTP/1.1 " + value);
            } else if (!f6957h.contains(name)) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                arrayList.add(name);
                arrayList.add(StringsKt__StringsKt.trim((CharSequence) value).toString());
            }
        }
        if (mVarA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        i0 i0Var = new i0();
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        i0Var.f4562b = protocol;
        i0Var.f4563c = mVarA.f4459c;
        String message = (String) mVarA.f4458b;
        Intrinsics.checkNotNullParameter(message, "message");
        i0Var.f4564d = message;
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        dj.s headers = new dj.s((String[]) array);
        Intrinsics.checkNotNullParameter(headers, "headers");
        i0Var.f = headers.g();
        if (z2 && i0Var.f4563c == 100) {
            return null;
        }
        return i0Var;
    }

    @Override // ij.d
    public final void h() {
        this.f.flush();
    }
}
