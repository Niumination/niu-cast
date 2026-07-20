package com.transsion.iotservice.multiscreen.pc.http;

import af.r5;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.PCConnectApplication;
import dj.a0;
import dj.b0;
import f8.b;
import f8.c;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k3.gc;
import k3.pb;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import li.g0;
import li.g2;
import li.h0;
import li.j;
import li.l;
import li.l0;
import li.v0;
import si.e;
import tj.w;
import v4.q;
import vi.a;
import vi.d;
import zj.q0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\u0082@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/http/RetrofitClient;", "", "<init>", "()V", "Ldj/b0;", "getOkHttpClient", "()Ldj/b0;", "", "kotlin.jvm.PlatformType", "getDomainHost", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "()Ljava/lang/String;", "getIndiaUrl", "Lzj/q0;", "getRetrofit", "TAG", "Ljava/lang/String;", "SCHEME", "", "timeout", "J", "sRetrofit", "Lzj/q0;", "gslbHost", "Lvi/a;", "mMutex", "Lvi/a;", "Lli/g0;", "mCoroutineScope", "Lli/g0;", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nRetrofitClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RetrofitClient.kt\ncom/transsion/iotservice/multiscreen/pc/http/RetrofitClient\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,121:1\n116#2,10:122\n351#3,11:132\n*S KotlinDebug\n*F\n+ 1 RetrofitClient.kt\ncom/transsion/iotservice/multiscreen/pc/http/RetrofitClient\n*L\n42#1:122,10\n69#1:132,11\n*E\n"})
public final class RetrofitClient {
    private static final String SCHEME = "https://";
    private static final String TAG = "RetrofitClient";
    private static String gslbHost = null;
    private static final g0 mCoroutineScope;
    private static q0 sRetrofit = null;
    private static final long timeout = 5000;
    public static final RetrofitClient INSTANCE = new RetrofitClient();
    private static final a mMutex = d.a();

    /* JADX INFO: renamed from: com.transsion.iotservice.multiscreen.pc.http.RetrofitClient$getRetrofit$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.transsion.iotservice.multiscreen.pc.http.RetrofitClient", f = "RetrofitClient.kt", i = {0, 1}, l = {127, 43}, m = "getRetrofit", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetrofitClient.this.getRetrofit(this);
        }
    }

    static {
        v0 v0Var = v0.f7498a;
        mCoroutineScope = h0.a(e.f10118a);
    }

    private RetrofitClient() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBaseUrl() {
        PCConnectApplication pCConnectApplication = PCConnectApplication.f2386d;
        return "api.nebulalive.com";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getDomainHost(Continuation<? super String> continuation) {
        final l lVar = new l(1, IntrinsicsKt.intercepted(continuation));
        lVar.s();
        String str = gslbHost;
        if (str != null) {
            na.a.b(lVar, str);
        }
        final g2 g2VarP = l0.p(mCoroutineScope, null, null, new RetrofitClient$getDomainHost$2$timeoutJob$1(lVar, null), 3);
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter("GslbSdk init start", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TAG), "GslbSdk init start");
        }
        c.c(pb.a(), new String[]{"api.nebulalive.com"}, new b() { // from class: com.transsion.iotservice.multiscreen.pc.http.RetrofitClient$getDomainHost$2$gslbSdkInitListener$1
            @Override // f8.b
            public void onInitFail() {
                g2VarP.h(null);
                Intrinsics.checkNotNullParameter("RetrofitClient", "tag");
                Intrinsics.checkNotNullParameter("GslbSdk init onInitFail", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("RetrofitClient"), "GslbSdk init onInitFail");
                }
                String indiaUrl = RetrofitClient.INSTANCE.getIndiaUrl();
                RetrofitClient.gslbHost = indiaUrl;
                na.a.b(lVar, indiaUrl);
            }

            @Override // f8.b
            public void onInitSuccess(Map<String, String> mutableMap) {
                String str2;
                g2VarP.h(null);
                Intrinsics.checkNotNullParameter("RetrofitClient", "tag");
                Intrinsics.checkNotNullParameter("GslbSdk init onInitSuccess", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("RetrofitClient"), "GslbSdk init onInitSuccess");
                }
                if (mutableMap == null || (str2 = mutableMap.get(RetrofitClient.INSTANCE.getBaseUrl())) == null) {
                    String strA = c.a(RetrofitClient.INSTANCE.getBaseUrl(), true);
                    RetrofitClient.gslbHost = strA;
                    na.a.b(lVar, strA);
                } else {
                    j jVar = lVar;
                    RetrofitClient.gslbHost = str2;
                    na.a.b(jVar, str2);
                }
            }
        });
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getIndiaUrl() {
        PCConnectApplication pCConnectApplication = PCConnectApplication.f2386d;
        return "ind-api.nebulalive.com";
    }

    private final b0 getOkHttpClient() {
        a0 a0Var = new a0();
        TimeUnit unit = TimeUnit.SECONDS;
        Intrinsics.checkNotNullParameter(unit, "unit");
        a0Var.f4492s = ej.b.b(40L, unit);
        Intrinsics.checkNotNullParameter(unit, "unit");
        a0Var.f4491r = ej.b.b(100L, unit);
        Intrinsics.checkNotNullParameter(unit, "unit");
        a0Var.f4493t = ej.b.b(100L, unit);
        Intrinsics.checkNotNullParameter(unit, "unit");
        a0Var.u = ej.b.b(100L, unit);
        HeadInterceptor interceptor = new HeadInterceptor();
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        a0Var.f4480c.add(interceptor);
        w connectionPool = new w(8, 15L, unit);
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        a0Var.f4479b = connectionPool;
        return new b0(a0Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object getRetrofit(Continuation<? super q0> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        vi.c cVar;
        a aVar;
        a aVar2;
        Throwable th2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i8 = anonymousClass1.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i8 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = anonymousClass1.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(obj);
                q0 q0Var = sRetrofit;
                if (q0Var != null) {
                    return q0Var;
                }
                a aVar3 = mMutex;
                anonymousClass1.L$0 = aVar3;
                anonymousClass1.label = 1;
                cVar = (vi.c) aVar3;
                if (cVar.d(null, anonymousClass1) == coroutine_suspended) {
                    aVar = cVar;
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar2 = (a) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        aVar2 = aVar2;
                        r5 r5Var = new r5(12);
                        b0 okHttpClient = INSTANCE.getOkHttpClient();
                        Objects.requireNonNull(okHttpClient, "client == null");
                        r5Var.f558c = okHttpClient;
                        ((ArrayList) r5Var.e).add(new ak.a(new q()));
                        r5Var.m(SCHEME + ((String) obj) + "/welife/");
                        q0 q0VarR = r5Var.r();
                        sRetrofit = q0VarR;
                        Intrinsics.checkNotNull(q0VarR);
                        ((vi.c) aVar2).e(null);
                        return q0VarR;
                    } catch (Throwable th3) {
                        th2 = th3;
                        ((vi.c) aVar2).e(null);
                        throw th2;
                    }
                }
                a aVar4 = (a) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                aVar = aVar4;
            }
            aVar = cVar;
            RetrofitClient retrofitClient = INSTANCE;
            anonymousClass1.L$0 = aVar;
            anonymousClass1.label = 2;
            Object domainHost = retrofitClient.getDomainHost(anonymousClass1);
            if (domainHost == coroutine_suspended) {
                return coroutine_suspended;
            }
            aVar2 = aVar;
            obj = domainHost;
            r5 r5Var2 = new r5(12);
            b0 okHttpClient2 = INSTANCE.getOkHttpClient();
            Objects.requireNonNull(okHttpClient2, "client == null");
            r5Var2.f558c = okHttpClient2;
            ((ArrayList) r5Var2.e).add(new ak.a(new q()));
            r5Var2.m(SCHEME + ((String) obj) + "/welife/");
            q0 q0VarR2 = r5Var2.r();
            sRetrofit = q0VarR2;
            Intrinsics.checkNotNull(q0VarR2);
            ((vi.c) aVar2).e(null);
            return q0VarR2;
        } catch (Throwable th4) {
            aVar2 = aVar;
            th2 = th4;
            ((vi.c) aVar2).e(null);
            throw th2;
        }
    }
}
