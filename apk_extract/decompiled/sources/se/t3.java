package se;

import android.util.Log;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f10001b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qi.c f10002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public li.g2 f10003d;
    public qg.p0 e;
    public volatile boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.p f10004g;

    public t3(com.welink.protocol.nfbd.p pVar, int i8) {
        this.f10004g = pVar;
        this.f10000a = i8;
        li.v0 v0Var = li.v0.f7498a;
        this.f10002c = li.h0.a(si.e.f10118a);
    }

    public static final void a(t3 t3Var, yg.a aVar) {
        t3Var.getClass();
        String strU = ((af.r5) ((yg.b) aVar).f11200a.g().g()).u();
        t3Var.f10001b.put(strU, aVar);
        t3Var.f10004g.n(strU);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00cf -> B:189:0x00d3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 7981. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static final java.lang.Object b(se.t3 r18, yg.a r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            Method dump skipped, instruction units count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.t3.b(se.t3, yg.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void c(yg.a aVar) {
        String strU = ((af.r5) ((yg.b) aVar).f11200a.g().g()).u();
        this.f10001b.remove(strU);
        this.f10004g.o(strU, o2.WebSocket);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(String str, byte[] data, ContinuationImpl continuationImpl) {
        l3 l3Var;
        if (continuationImpl instanceof l3) {
            l3Var = (l3) continuationImpl;
            int i8 = l3Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                l3Var.label = i8 - Integer.MIN_VALUE;
            } else {
                l3Var = new l3(this, continuationImpl);
            }
        } else {
            l3Var = new l3(this, continuationImpl);
        }
        Object obj = l3Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = l3Var.label;
        boolean z2 = false;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(obj);
                yg.a aVar = (yg.a) this.f10001b.get(str);
                if (aVar != null) {
                    l3Var.label = 1;
                    Intrinsics.checkNotNullParameter(data, "data");
                    Object objE = aVar.E(new oh.m(true, data, false, false, false), l3Var);
                    if (objE != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        objE = Unit.INSTANCE;
                    }
                    if (objE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    String strN = o.d.n("WebSocket session not found for address: ", str, "NearLanTcpServer", "tag", "mes");
                    if (lb.f6529c >= 1) {
                        h0.a.x("TransConnect:", strN, "NearLanTcpServer", null);
                    }
                }
                return Boxing.boxBoolean(z2);
            }
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            z2 = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Boxing.boxBoolean(z2);
    }

    public final void e() {
        try {
            if (this.f) {
                return;
            }
            this.f10003d = li.l0.p(this.f10002c, new m3(this), null, new r3(this, null), 2);
        } catch (ClosedChannelException e) {
            String mes = "WebSocket server start failed socket closed end: " + e;
            Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", mes, "WebSocketKtorServer", null);
            }
        } catch (Exception e4) {
            String mes2 = "WebSocket server start failed exception end: " + e4;
            Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
            Intrinsics.checkNotNullParameter(mes2, "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", mes2, "WebSocketKtorServer", null);
            }
        }
    }

    public final void f() {
        li.g2 g2Var;
        if (this.f) {
            this.f = false;
            if (!this.f10001b.isEmpty()) {
                li.l0.p(this.f10002c, null, null, new s3(this, null), 3);
                return;
            }
            try {
                qg.p0 p0Var = this.e;
                if (p0Var != null) {
                    p0Var.g(100L, 100L);
                }
                this.e = null;
                this.f10000a = 0;
                g2Var = this.f10003d;
                if (g2Var != null) {
                    g2Var.h(null);
                }
            } catch (Exception e) {
                String mes = "WebSocket server stop failed: " + e;
                Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                Intrinsics.checkNotNullParameter(mes, "mes");
                if (lb.f6529c >= 1) {
                    Log.e("WebSocketKtorServer", "TransConnect:" + mes, null);
                }
                e.printStackTrace();
                g2Var = this.f10003d;
                if (g2Var != null) {
                }
            } finally {
                li.g2 g2Var2 = this.f10003d;
                if (g2Var2 != null) {
                    g2Var2.h(null);
                }
                this.f10003d = null;
            }
        }
    }
}
