package uf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.h2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import oh.s0;
import oh.u0;
import zf.r;
import zf.v;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends SuspendLambda implements Function3 {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ m $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, boolean z2, Continuation<? super l> continuation) {
        super(3, continuation);
        this.$plugin = mVar;
        this.$extensionsSupported = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, wf.c cVar, Continuation<? super Unit> continuation) {
        l lVar = new l(this.$plugin, this.$extensionsSupported, continuation);
        lVar.L$0 = fVar;
        lVar.L$1 = cVar;
        return lVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object eVar;
        oh.d dVar;
        List listEmptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            wf.c cVar = (wf.c) this.L$1;
            ih.a aVar = cVar.f10742a;
            wf.b bVarE = ((kf.c) fVar.f5401a).e();
            z zVarH = bVarE.h();
            Intrinsics.checkNotNullParameter(bVarE, "<this>");
            cg.j content = bVarE.b().d().getContent();
            boolean z2 = content instanceof g;
            Object obj2 = fVar.f5401a;
            if (!z2) {
                vj.b bVar = n.f10439b;
                if (h2.a(bVar)) {
                    bVar.trace("Skipping non-websocket response from " + ((kf.c) obj2).d().getUrl() + ": " + content);
                }
                return Unit.INSTANCE;
            }
            z zVar = z.f11565d;
            if (!Intrinsics.areEqual(zVarH, zVar)) {
                throw new h("Handshake exception, expected status code " + zVar.f11581a + " but was " + zVarH.f11581a);
            }
            Object obj3 = cVar.f10743b;
            if (!(obj3 instanceof s0)) {
                throw new h("Handshake exception, expected `WebSocketSession` content but was " + Reflection.getOrCreateKotlinClass(obj3.getClass()));
            }
            vj.b bVar2 = n.f10439b;
            if (h2.a(bVar2)) {
                bVar2.trace("Receive websocket session from " + ((kf.c) obj2).d().getUrl() + ": " + obj3);
            }
            long j8 = this.$plugin.f10436b;
            if (j8 != 2147483647L) {
                ((s0) obj3).I(j8);
            }
            if (Intrinsics.areEqual(aVar.f5872a, Reflection.getOrCreateKotlinClass(d.class))) {
                m mVar = this.$plugin;
                s0 session = (s0) obj3;
                mVar.getClass();
                Intrinsics.checkNotNullParameter(session, "session");
                boolean z3 = session instanceof oh.d;
                if (z3) {
                    dVar = (oh.d) session;
                } else {
                    long j10 = mVar.f10435a;
                    long j11 = j10 * ((long) 2);
                    vj.b bVar3 = oh.l.f8508a;
                    Intrinsics.checkNotNullParameter(session, "session");
                    if (z3) {
                        throw new IllegalArgumentException("Cannot wrap other DefaultWebSocketSession");
                    }
                    oh.k kVar = new oh.k(session, j10, j11);
                    kVar.I(mVar.f10436b);
                    dVar = kVar;
                }
                kf.c cVar2 = (kf.c) obj2;
                d dVar2 = new d(cVar2, dVar);
                if (this.$extensionsSupported) {
                    this.$plugin.getClass();
                    r rVarA = cVar2.e().a();
                    String[] strArr = v.f11551a;
                    String str = rVarA.get("Sec-WebSocket-Extensions");
                    if (str != null) {
                        u0.d(str);
                    } else {
                        CollectionsKt.emptyList();
                    }
                    List list = (List) cVar2.i().b(n.f10438a);
                    listEmptyList = new ArrayList();
                    Iterator it = list.iterator();
                    if (it.hasNext()) {
                        it.next().getClass();
                        throw new ClassCastException();
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                dVar2.b0(listEmptyList);
                eVar = dVar2;
            } else {
                eVar = new e((kf.c) obj2, (s0) obj3);
            }
            wf.c cVar3 = new wf.c(aVar, eVar);
            this.L$0 = null;
            this.label = 1;
            if (fVar.f(cVar3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
