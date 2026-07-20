package nf;

import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import java.io.Closeable;
import java.net.SocketTimeoutException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import jh.j0;
import k3.bc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.f0;
import li.g0;
import li.g2;
import li.j1;
import li.l0;
import li.o1;
import li.p1;
import pf.a1;
import pf.e1;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements g0, Closeable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8221n = AtomicIntegerFieldUpdater.newUpdater(p.class, "connections");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8224c;
    private volatile /* synthetic */ int connections;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f8225d;
    public final h e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineContext f8226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final cj.d f8227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ni.m f8228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f8229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gg.n f8230l;
    volatile /* synthetic */ long lastActivity;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g2 f8231m;

    public p(String host, int i8, boolean z2, f config, h connectionFactory, CoroutineContext coroutineContext, cj.d onDone) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(connectionFactory, "connectionFactory");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        this.f8222a = host;
        this.f8223b = i8;
        this.f8224c = z2;
        this.f8225d = config;
        this.e = connectionFactory;
        this.f8226h = coroutineContext;
        this.f8227i = onDone;
        TimeZone timeZone = ch.a.f1686a;
        this.lastActivity = System.currentTimeMillis();
        this.connections = 0;
        this.f8228j = bc.a(0, 7, null);
        se.h hVar = config.f8214a;
        this.f8229k = ((long) 2) * CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.f8231m = l0.p(this, coroutineContext.plus(new f0("Endpoint timeout(" + host + ':' + i8 + ')')), null, new o(this, null), 2);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0144 A[Catch: all -> 0x0164, TRY_LEAVE, TryCatch #1 {all -> 0x0164, blocks: (B:47:0x0123, B:49:0x0144, B:57:0x0168), top: B:109:0x0123 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0156 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0157  */
    /* JADX WARN: Code duplicated, block: B:57:0x0168 A[Catch: all -> 0x0164, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0164, blocks: (B:47:0x0123, B:49:0x0144, B:57:0x0168), top: B:109:0x0123 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0181 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x0182  */
    /* JADX WARN: Code duplicated, block: B:63:0x018d A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:27:0x008d, B:61:0x0189, B:63:0x018d, B:53:0x015c, B:32:0x00b1), top: B:107:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0182 -> B:61:0x0189). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(vf.d r27, kotlin.coroutines.jvm.internal.ContinuationImpl r28) {
        /*
            Method dump skipped, instruction units count: 654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nf.p.a(vf.d, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8231m.h(null);
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f8226h;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(vf.d r7, kotlin.coroutines.CoroutineContext r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof nf.k
            if (r0 == 0) goto L13
            r0 = r9
            nf.k r0 = (nf.k) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            nf.k r0 = new nf.k
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L5e
            if (r2 == r3) goto L5a
            r6 = 0
            r7 = 2
            r8 = 3
            if (r2 == r7) goto L3d
            if (r2 != r8) goto L35
            java.lang.Object r7 = r0.L$0
            o.d.y(r7)
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L59
            goto L58
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r7 = r0.L$1
            o.d.y(r7)
            java.lang.Object r7 = r0.L$0
            li.q r7 = (li.q) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L59
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L59
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L59
            r0.label = r8     // Catch: java.lang.Throwable -> L59
            li.r r7 = (li.r) r7     // Catch: java.lang.Throwable -> L59
            java.lang.Object r9 = r7.r0(r0)     // Catch: java.lang.Throwable -> L59
            if (r9 != r1) goto L58
            return r1
        L58:
            return r9
        L59:
            throw r6
        L5a:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L77
        L5e:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.TimeZone r9 = ch.a.f1686a
            long r4 = java.lang.System.currentTimeMillis()
            r6.lastActivity = r4
            nf.f r9 = r6.f8225d
            r9.getClass()
            r0.label = r3
            java.lang.Object r9 = r6.m(r7, r8, r0)
            if (r9 != r1) goto L77
            return r1
        L77:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: nf.p.h(vf.d, kotlin.coroutines.CoroutineContext, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:62:0x01a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object m(vf.d dVar, CoroutineContext coroutineContext, ContinuationImpl continuationImpl) throws Throwable {
        l lVar;
        Throwable cause;
        Object obj;
        CoroutineContext coroutineContext2;
        Object objA;
        ch.d dVar2;
        jh.o oVar;
        j0 j0Var;
        CoroutineContext coroutineContext3;
        p pVar = this;
        vf.d request = dVar;
        boolean z2 = false;
        if (continuationImpl instanceof l) {
            lVar = (l) continuationImpl;
            int i8 = lVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                lVar.label = i8 - Integer.MIN_VALUE;
            } else {
                lVar = new l(pVar, continuationImpl);
            }
        } else {
            lVar = new l(pVar, continuationImpl);
        }
        Object objU = lVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = lVar.label;
        Throwable th2 = null;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(objU);
                lVar.L$0 = pVar;
                lVar.L$1 = request;
                coroutineContext2 = coroutineContext;
                lVar.L$2 = coroutineContext2;
                lVar.label = 1;
                objA = pVar.a(request, lVar);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    if (i9 == 2) {
                        ResultKt.throwOnFailure(objU);
                        return (vf.g) objU;
                    }
                    if (i9 == 3) {
                        ch.d dVar3 = (ch.d) lVar.L$4;
                        j0 j0Var2 = (j0) lVar.L$3;
                        jh.o oVar2 = (jh.o) lVar.L$2;
                        coroutineContext3 = (CoroutineContext) lVar.L$1;
                        vf.d dVar4 = (vf.d) lVar.L$0;
                        try {
                            ResultKt.throwOnFailure(objU);
                            dVar2 = dVar3;
                            j0Var = j0Var2;
                            oVar = oVar2;
                            request = dVar4;
                            lVar.L$0 = request;
                            lVar.L$1 = null;
                            lVar.L$2 = null;
                            lVar.L$3 = null;
                            lVar.L$4 = null;
                            lVar.label = 4;
                            objU = l0.u(coroutineContext3, new v(oVar, j0Var, coroutineContext3, dVar2, request, null), lVar);
                            if (objU == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            request = dVar4;
                            Intrinsics.checkNotNullParameter(th, "<this>");
                            Intrinsics.checkNotNullParameter(request, "request");
                            Throwable cause2 = th.getCause();
                            if (cause2 != null) {
                                Intrinsics.checkNotNullParameter(cause2, "<this>");
                                while (true) {
                                    if ((cause2 != null ? cause2.getCause() : null) == null) {
                                        break;
                                    }
                                    cause2 = cause2.getCause();
                                }
                                th2 = cause2;
                            }
                            if (th2 instanceof SocketTimeoutException) {
                                Throwable cause3 = th.getCause();
                                vj.b bVar = e1.f8838a;
                                Intrinsics.checkNotNullParameter(request, "request");
                                StringBuilder sb2 = new StringBuilder("Socket timeout has expired [url=");
                                sb2.append(request.f10561a);
                                sb2.append(", socket_timeout=");
                                a1 a1Var = (a1) request.a();
                                if (a1Var == null || (obj = a1Var.f8824c) == null) {
                                    obj = EnvironmentCompat.MEDIA_UNKNOWN;
                                }
                                sb2.append(obj);
                                sb2.append("] ms");
                                String message = sb2.toString();
                                Intrinsics.checkNotNullParameter(message, "message");
                                cause = new SocketTimeoutException(message);
                                cause.initCause(cause3);
                            } else {
                                cause = th.getCause();
                            }
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } else {
                        if (i9 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(objU);
                    }
                    return (vf.g) objU;
                }
                CoroutineContext coroutineContext4 = (CoroutineContext) lVar.L$2;
                request = (vf.d) lVar.L$1;
                p pVar2 = (p) lVar.L$0;
                ResultKt.throwOnFailure(objU);
                coroutineContext2 = coroutineContext4;
                pVar = pVar2;
                objA = objU;
            }
            gg.m mVar = (gg.m) objA;
            jh.k kVar = mVar.f5187b;
            jh.k kVar2 = mVar.f5188c;
            se.h hVar = pVar.f8225d.f8214a;
            j0 j0VarA = b0.a(kVar2, coroutineContext2);
            CoroutineContext.Element element = coroutineContext2.get(o1.f7483a);
            Intrinsics.checkNotNull(element);
            ((p1) element).A(new mg.t(1, kVar, kVar2, mVar, pVar));
            long jA = s.a(request, pVar.f8225d);
            if (jA != Long.MAX_VALUE && jA != 0) {
                l0.k(coroutineContext2).A(new q(l0.p(j1.f7459a, null, null, new r(jA, coroutineContext2, request, null), 3), 0));
            }
            Calendar calendar = Calendar.getInstance(ch.a.f1686a, Locale.ROOT);
            Intrinsics.checkNotNull(calendar);
            ch.d dVarA = ch.a.a(calendar, null);
            zf.t tVar = request.f10563c;
            String[] strArr = zf.v.f11551a;
            String str = tVar.get("Expect");
            cg.j body = request.f10564d;
            Intrinsics.checkNotNullParameter(body, "body");
            if (str != null && !(body instanceof cg.g)) {
                z2 = true;
            }
            if (z2) {
                lVar.L$0 = request;
                lVar.L$1 = null;
                lVar.L$2 = null;
                lVar.label = 2;
                objU = l0.u(coroutineContext2, new n(request, j0VarA, false, dVarA, kVar, kVar2, coroutineContext2, null), lVar);
                if (objU == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (vf.g) objU;
            }
            lVar.L$0 = request;
            lVar.L$1 = coroutineContext2;
            lVar.L$2 = kVar;
            lVar.L$3 = kVar2;
            lVar.L$4 = dVarA;
            lVar.label = 3;
            Object objU2 = l0.u(coroutineContext2, new a0(request, j0VarA, false, true, coroutineContext2, null), lVar);
            if (objU2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objU2 = Unit.INSTANCE;
            }
            if (objU2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            dVar2 = dVarA;
            oVar = kVar;
            j0Var = kVar2;
            coroutineContext3 = coroutineContext2;
            lVar.L$0 = request;
            lVar.L$1 = null;
            lVar.L$2 = null;
            lVar.L$3 = null;
            lVar.L$4 = null;
            lVar.label = 4;
            objU = l0.u(coroutineContext3, new v(oVar, j0Var, coroutineContext3, dVar2, request, null), lVar);
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (vf.g) objU;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void s() {
        gg.n nVar = this.f8230l;
        if (nVar == null) {
            return;
        }
        this.e.b(nVar);
        f8221n.decrementAndGet(this);
    }
}
