package ij;

import af.r5;
import dj.b0;
import dj.e0;
import dj.h0;
import dj.i0;
import dj.j0;
import dj.k;
import dj.l;
import dj.l0;
import dj.m;
import dj.m0;
import dj.n0;
import dj.s;
import dj.t;
import dj.u;
import dj.v;
import dj.w;
import dj.x;
import hj.i;
import hj.n;
import hj.o;
import hj.p;
import hj.r;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import k3.r9;
import k3.sc;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5874a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5875b;

    public a(l cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.f5875b = cookieJar;
    }

    public static int c(j0 j0Var, int i8) {
        String strA = j0.a(j0Var, "Retry-After");
        if (strA == null) {
            return i8;
        }
        if (!new Regex("\\d+").matches(strA)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        Intrinsics.checkNotNullExpressionValue(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }

    public e0 a(j0 response, m mVar) throws ProtocolException {
        String link;
        hj.m mVar2;
        n0 n0Var = (mVar == null || (mVar2 = (hj.m) mVar.f4609a) == null) ? null : mVar2.q;
        int i8 = response.f4579d;
        String method = response.f4576a.f4529c;
        if (i8 != 307 && i8 != 308) {
            if (i8 == 401) {
                ((b0) this.f5875b).f4500i.getClass();
                Intrinsics.checkNotNullParameter(response, "response");
                return null;
            }
            if (i8 == 421) {
                if (mVar == null || Intrinsics.areEqual(((hj.e) mVar.f4611c).f5436h.f4470a.e, ((hj.m) mVar.f4609a).q.f4617a.f4470a.e)) {
                    return null;
                }
                hj.m mVar3 = (hj.m) mVar.f4609a;
                synchronized (mVar3) {
                    mVar3.f5461j = true;
                }
                return response.f4576a;
            }
            if (i8 == 503) {
                j0 j0Var = response.f4584l;
                if ((j0Var == null || j0Var.f4579d != 503) && c(response, Integer.MAX_VALUE) == 0) {
                    return response.f4576a;
                }
                return null;
            }
            if (i8 == 407) {
                Intrinsics.checkNotNull(n0Var);
                if (n0Var.f4618b.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                ((b0) this.f5875b).f4506o.getClass();
                Intrinsics.checkNotNullParameter(response, "response");
                return null;
            }
            if (i8 == 408) {
                if (!((b0) this.f5875b).f4499h) {
                    return null;
                }
                j0 j0Var2 = response.f4584l;
                if ((j0Var2 == null || j0Var2.f4579d != 408) && c(response, 0) <= 0) {
                    return response.f4576a;
                }
                return null;
            }
            switch (i8) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        b0 b0Var = (b0) this.f5875b;
        if (!b0Var.f4501j || (link = j0.a(response, "Location")) == null) {
            return null;
        }
        e0 e0Var = response.f4576a;
        u uVar = e0Var.f4528b;
        uVar.getClass();
        Intrinsics.checkNotNullParameter(link, "link");
        t tVarF = uVar.f(link);
        u url = tVarF != null ? tVarF.a() : null;
        if (url == null) {
            return null;
        }
        if (!Intrinsics.areEqual(url.f4634b, e0Var.f4528b.f4634b) && !b0Var.f4502k) {
            return null;
        }
        r5 r5VarB = e0Var.b();
        if (r9.a(method)) {
            Intrinsics.checkNotNullParameter(method, "method");
            boolean zAreEqual = Intrinsics.areEqual(method, "PROPFIND");
            int i9 = response.f4579d;
            boolean z2 = zAreEqual || i9 == 308 || i9 == 307;
            Intrinsics.checkNotNullParameter(method, "method");
            if (Intrinsics.areEqual(method, "PROPFIND") || i9 == 308 || i9 == 307) {
                r5VarB.w(method, z2 ? e0Var.e : null);
            } else {
                r5VarB.w("GET", null);
            }
            if (!z2) {
                r5VarB.x("Transfer-Encoding");
                r5VarB.x("Content-Length");
                r5VarB.x("Content-Type");
            }
        }
        if (!ej.b.a(e0Var.f4528b, url)) {
            r5VarB.x("Authorization");
        }
        Intrinsics.checkNotNullParameter(url, "url");
        r5VarB.f557b = url;
        return r5VarB.o();
    }

    public boolean b(IOException iOException, i iVar, e0 e0Var, boolean z2) {
        r rVar;
        boolean zA;
        hj.m mVar;
        if (!((b0) this.f5875b).f4499h) {
            return false;
        }
        if ((z2 && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException) || (!(iOException instanceof InterruptedIOException) ? !(((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) : (iOException instanceof SocketTimeoutException) && !z2)) {
            return false;
        }
        hj.e eVar = iVar.e;
        Intrinsics.checkNotNull(eVar);
        int i8 = eVar.f5433c;
        if (i8 == 0 && eVar.f5434d == 0 && eVar.e == 0) {
            zA = false;
        } else if (eVar.f != null) {
            zA = true;
        } else {
            n0 n0Var = null;
            if (i8 <= 1 && eVar.f5434d <= 1 && eVar.e <= 0 && (mVar = eVar.f5437i.f5447h) != null) {
                synchronized (mVar) {
                    if (mVar.f5462k == 0 && ej.b.a(mVar.q.f4617a.f4470a, eVar.f5436h.f4470a)) {
                        n0Var = mVar.q;
                    }
                }
            }
            if (n0Var != null) {
                eVar.f = n0Var;
            } else {
                p pVar = eVar.f5431a;
                if ((pVar == null || !pVar.a()) && (rVar = eVar.f5432b) != null) {
                    zA = rVar.a();
                }
            }
            zA = true;
        }
        return zA;
    }

    @Override // dj.w
    public final j0 intercept(v chain) {
        int i8;
        int i9;
        m0 m0Var;
        j0 j0VarB;
        SSLSocketFactory sSLSocketFactory;
        pj.c cVar;
        dj.f fVar;
        switch (this.f5874a) {
            case 0:
                Intrinsics.checkNotNullParameter(chain, "chain");
                f fVar2 = (f) chain;
                e0 request = fVar2.f;
                r5 r5VarB = request.b();
                h0 h0Var = request.e;
                if (h0Var != null) {
                    x xVarB = h0Var.b();
                    if (xVarB != null) {
                        r5VarB.v("Content-Type", xVarB.f4642a);
                    }
                    long jA = h0Var.a();
                    if (jA != -1) {
                        r5VarB.v("Content-Length", String.valueOf(jA));
                        r5VarB.x("Transfer-Encoding");
                    } else {
                        r5VarB.v("Transfer-Encoding", "chunked");
                        r5VarB.x("Content-Length");
                    }
                }
                String strA = request.a("Host");
                u url = request.f4528b;
                if (strA == null) {
                    i8 = 0;
                    r5VarB.v("Host", ej.b.v(url, false));
                } else {
                    i8 = 0;
                }
                if (request.a("Connection") == null) {
                    r5VarB.v("Connection", "Keep-Alive");
                }
                if (request.a("Accept-Encoding") == null && request.a("Range") == null) {
                    r5VarB.v("Accept-Encoding", "gzip");
                    i9 = 1;
                } else {
                    i9 = i8;
                }
                l lVar = (l) this.f5875b;
                lVar.getClass();
                Intrinsics.checkNotNullParameter(url, "url");
                List listEmptyList = CollectionsKt.emptyList();
                if (!listEmptyList.isEmpty()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (Object obj : listEmptyList) {
                        int i10 = i8 + 1;
                        if (i8 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        k kVar = (k) obj;
                        if (i8 > 0) {
                            sb2.append("; ");
                        }
                        sb2.append(kVar.f4592a);
                        sb2.append('=');
                        sb2.append(kVar.f4593b);
                        i8 = i10;
                    }
                    String string = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
                    r5VarB.v("Cookie", string);
                }
                if (request.a("User-Agent") == null) {
                    r5VarB.v("User-Agent", "okhttp/4.9.2");
                }
                j0 j0VarB2 = fVar2.b(r5VarB.o());
                s sVar = j0VarB2.f4580h;
                e.b(lVar, url, sVar);
                i0 i0VarG = j0VarB2.g();
                Intrinsics.checkNotNullParameter(request, "request");
                i0VarG.f4561a = request;
                if (i9 != 0 && StringsKt__StringsJVMKt.equals("gzip", j0.a(j0VarB2, "Content-Encoding"), true) && e.a(j0VarB2) && (m0Var = j0VarB2.f4581i) != null) {
                    qj.m mVar = new qj.m(m0Var.g());
                    dj.r rVarG = sVar.g();
                    rVarG.e("Content-Encoding");
                    rVarG.e("Content-Length");
                    s headers = rVarG.c();
                    Intrinsics.checkNotNullParameter(headers, "headers");
                    i0VarG.f = headers.g();
                    i0VarG.f4565g = new l0(j0.a(j0VarB2, "Content-Type"), -1L, sc.b(mVar));
                }
                return i0VarG.a();
            default:
                Intrinsics.checkNotNullParameter(chain, "chain");
                f fVar3 = (f) chain;
                e0 e0Var = fVar3.f;
                i iVar = fVar3.f5878b;
                List listEmptyList2 = CollectionsKt.emptyList();
                j0 j0Var = null;
                int i11 = 0;
                e0 request2 = e0Var;
                while (true) {
                    boolean z2 = true;
                    while (true) {
                        iVar.getClass();
                        Intrinsics.checkNotNullParameter(request2, "request");
                        if (iVar.f5448i != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        synchronized (iVar) {
                            if (iVar.f5450k) {
                                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                            }
                            if (iVar.f5449j) {
                                throw new IllegalStateException("Check failed.");
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                        if (z2) {
                            n nVar = iVar.f5443a;
                            u uVar = request2.f4528b;
                            boolean z3 = uVar.f4633a;
                            b0 b0Var = iVar.p;
                            if (z3) {
                                SSLSocketFactory sSLSocketFactory2 = b0Var.q;
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException("CLEARTEXT-only client");
                                }
                                pj.c cVar2 = b0Var.u;
                                fVar = b0Var.f4510v;
                                sSLSocketFactory = sSLSocketFactory2;
                                cVar = cVar2;
                            } else {
                                sSLSocketFactory = null;
                                cVar = null;
                                fVar = null;
                            }
                            l lVar2 = b0Var.f4504m;
                            SocketFactory socketFactory = b0Var.p;
                            l lVar3 = b0Var.f4506o;
                            List list = b0.C;
                            List list2 = b0.C;
                            iVar.e = new hj.e(nVar, new dj.a(uVar.e, uVar.f, lVar2, socketFactory, sSLSocketFactory, cVar, fVar, lVar3, b0Var.f4505n), iVar);
                        }
                        try {
                            if (iVar.f5452m) {
                                throw new IOException("Canceled");
                            }
                            try {
                                j0VarB = fVar3.b(request2);
                            } catch (o e) {
                                if (!b(e.getLastConnectException(), iVar, request2, false)) {
                                    IOException firstConnectException = e.getFirstConnectException();
                                    ej.b.z(firstConnectException, listEmptyList2);
                                    throw firstConnectException;
                                }
                                listEmptyList2 = CollectionsKt.plus((Collection<? extends IOException>) listEmptyList2, e.getFirstConnectException());
                                iVar.e(true);
                                z2 = false;
                            } catch (IOException e4) {
                                if (!b(e4, iVar, request2, !(e4 instanceof kj.a))) {
                                    ej.b.z(e4, listEmptyList2);
                                    throw e4;
                                }
                                listEmptyList2 = CollectionsKt.plus((Collection<? extends IOException>) listEmptyList2, e4);
                                iVar.e(true);
                                z2 = false;
                            }
                        } catch (Throwable th2) {
                            iVar.e(true);
                            throw th2;
                        }
                        break;
                        z2 = false;
                    }
                    if (j0Var != null) {
                        i0 i0VarG2 = j0VarB.g();
                        i0 i0VarG3 = j0Var.g();
                        i0VarG3.f4565g = null;
                        j0 j0VarA = i0VarG3.a();
                        if (j0VarA.f4581i != null) {
                            throw new IllegalArgumentException("priorResponse.body != null");
                        }
                        i0VarG2.f4568j = j0VarA;
                        j0VarB = i0VarG2.a();
                    }
                    j0Var = j0VarB;
                    request2 = a(j0Var, iVar.f5448i);
                    if (request2 == null) {
                        iVar.e(false);
                        return j0Var;
                    }
                    m0 m0Var2 = j0Var.f4581i;
                    if (m0Var2 != null) {
                        ej.b.d(m0Var2);
                    }
                    i11++;
                    if (i11 > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i11);
                    }
                    iVar.e(true);
                }
                break;
        }
    }

    public a(b0 client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f5875b = client;
    }
}
