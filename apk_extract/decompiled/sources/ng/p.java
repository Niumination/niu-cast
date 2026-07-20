package ng;

import af.z4;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import li.f0;
import li.g0;
import li.g2;
import li.h0;
import li.j0;
import li.o2;
import li.p1;
import li.r1;
import li.v0;
import qg.d1;
import qg.l0;
import qg.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qg.b f8260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yf.c f8261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0 f8262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final li.r f8263d;
    public final c e;
    public final l0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final si.e f8264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final si.e f8265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final li.r f8266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r1 f8267j;
    private volatile p1 serverJob;

    public p(qg.b environment, yf.c monitor, boolean z2, c configuration, l0 applicationProvider) throws hh.c {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(applicationProvider, "applicationProvider");
        pg.b config = environment.f9065c;
        Intrinsics.checkNotNullParameter(config, "config");
        t0 pipeline = new t0(z2);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        sj.a aVarA = config.a("ktor.deployment.shutdown.url");
        if (aVarA != null) {
            Object obj = ((LinkedHashMap) aVarA.f10137b).get((String) aVarA.f10138c);
            Intrinsics.checkNotNull(obj);
            String str = (String) obj;
            if (str != null) {
                mg.e.b(pipeline, d1.f9069a, new hg.e(str, 1));
            }
        }
        pipeline.p(t0.f9115l, new qg.x(null));
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        this.f8260a = environment;
        this.f8261b = monitor;
        this.f8262c = pipeline;
        li.r rVarB = li.l0.b();
        this.f8263d = rVarB;
        z4 z4Var = new z4(2);
        z4Var.f750b = true;
        TimeZone timeZone = ch.a.f1686a;
        z4Var.f751c = System.currentTimeMillis();
        zg.a aVar = qg.s.f9107h;
        wg.b sendPipeline = pipeline.f9118j;
        Intrinsics.checkNotNullParameter(sendPipeline, "sendPipeline");
        sendPipeline.p(wg.b.f10758o, new qg.m(null));
        monitor.b(mg.l.f8071a, new gi.a(8, z4Var, pipeline));
        monitor.b(mg.l.f8072b, new gi.a(9, z4Var, environment));
        this.e = configuration;
        this.f = applicationProvider;
        v0 v0Var = v0.f7498a;
        Intrinsics.checkNotNullParameter(v0Var, "<this>");
        si.e eVar = si.e.f10118a;
        this.f8264g = eVar;
        Intrinsics.checkNotNullParameter(v0Var, "<this>");
        this.f8265h = eVar;
        li.r rVarB2 = li.l0.b();
        this.f8266i = rVarB2;
        r1 r1VarC = li.l0.c();
        this.f8267j = r1VarC;
        this.serverJob = li.l0.c();
        this.serverJob = li.l0.p(h0.a(((mg.a) applicationProvider.invoke()).f8044s.plus(eVar)), null, j0.LAZY, new h(this, rVarB, r1VarC, rVarB2, eVar, environment, null), 1);
        this.serverJob.A(new ag.d0(this, 18));
    }

    public static final Unit a(p pVar, jh.j0 j0Var, b bVar) throws hh.c {
        pVar.getClass();
        hh.h hVar = new hh.h("ExpectedHeaderPhase");
        r rVar = bVar.f8247d;
        rVar.f9079c.n(vg.b.f10586i, hVar);
        rVar.f9079c.p(hVar, new d(bVar, pVar, "100-continue", j0Var, "HTTP/1.1 100 Continue\r\n", null));
        return Unit.INSTANCE;
    }

    public static final b0 c(p pVar, g0 g0Var, String str, int i8) {
        long j8 = pVar.e.f8253c;
        c0 settings = new c0(str, i8, j8);
        j handler = new j(pVar, null);
        Intrinsics.checkNotNullParameter(g0Var, "<this>");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(handler, "handler");
        li.r rVarB = li.l0.b();
        r1 r1VarC = li.l0.c();
        g2 g2VarO = li.l0.o(g0Var, new f0(a1.a.o(i8, "server-root-")), j0.UNDISPATCHED, new og.b(r1VarC, null));
        CoroutineContext dispatcher = g0Var.getCoroutineContext();
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        fg.e eVar = new fg.e(dispatcher);
        Duration.Companion companion = Duration.INSTANCE;
        long duration = DurationKt.toDuration(j8, DurationUnit.SECONDS);
        String simpleName = Reflection.getOrCreateKotlinClass(b0.class).getSimpleName();
        if (simpleName == null && (simpleName = Reflection.getOrCreateKotlinClass(b0.class).getQualifiedName()) == null) {
            simpleName = Reflection.getOrCreateKotlinClass(b0.class).toString();
        }
        g2 g2VarP = li.l0.p(g0Var, CoroutineContext.Element.DefaultImpls.plus(g2VarO, new f0(a1.a.o(i8, "accept-"))), null, new og.a(eVar, settings, rVarB, k3.g2.a(simpleName), g2VarO, duration, handler, null), 2);
        g2VarP.A(new gi.a(7, r1VarC, rVarB));
        g2VarO.A(new ag.d0(eVar, 19));
        return new b0(g2VarO, g2VarP, rVarB);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(boolean z2, ContinuationImpl continuationImpl) {
        k kVar;
        if (continuationImpl instanceof k) {
            kVar = (k) continuationImpl;
            int i8 = kVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                kVar.label = i8 - Integer.MIN_VALUE;
            } else {
                kVar = new k(this, continuationImpl);
            }
        } else {
            kVar = new k(this, continuationImpl);
        }
        Object obj = kVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = kVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            this.serverJob.start();
            li.r rVar = this.f8266i;
            kVar.L$0 = this;
            kVar.Z$0 = z2;
            kVar.label = 1;
            if (rVar.r0(kVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p pVar = (p) kVar.L$0;
                ResultKt.throwOnFailure(obj);
                return pVar;
            }
            z2 = kVar.Z$0;
            this = (p) kVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        yf.c cVar = this.f8261b;
        yf.a definition = mg.l.f8073c;
        qg.b bVar = this.f8260a;
        vj.b bVar2 = bVar.f9064b;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(definition, "definition");
        try {
            cVar.a(definition, bVar);
        } catch (Throwable th2) {
            if (bVar2 != null) {
                bVar2.error("Some handlers have thrown an exception", th2);
            }
        }
        if (!z2) {
            return this;
        }
        p1 p1Var = this.serverJob;
        kVar.L$0 = this;
        kVar.label = 2;
        return p1Var.S(kVar) == coroutine_suspended ? coroutine_suspended : this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(long j8, long j10, ContinuationImpl continuationImpl) throws Throwable {
        m mVar;
        if (continuationImpl instanceof m) {
            mVar = (m) continuationImpl;
            int i8 = mVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                mVar.label = i8 - Integer.MIN_VALUE;
            } else {
                mVar = new m(this, continuationImpl);
            }
        } else {
            mVar = new m(this, continuationImpl);
        }
        Object objB = mVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = mVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                j10 = mVar.J$1;
                j8 = mVar.J$0;
                this = (p) mVar.L$0;
                ResultKt.throwOnFailure(objB);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objB);
            }
        }
        ResultKt.throwOnFailure(objB);
        this.f8267j.r0();
        o oVar = new o(this, null);
        mVar.L$0 = this;
        mVar.J$0 = j8;
        mVar.J$1 = j10;
        mVar.label = 1;
        objB = o2.b(j8, oVar, mVar);
        if (objB == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (((Boolean) objB) != null) {
            return Unit.INSTANCE;
        }
        this.serverJob.h(null);
        long j11 = j10 - j8;
        n nVar = new n(this, null);
        mVar.L$0 = null;
        mVar.label = 2;
        objB = o2.b(j11, nVar, mVar);
        return objB == coroutine_suspended ? coroutine_suspended : objB;
    }
}
