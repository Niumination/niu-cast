package uf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import k3.h2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import m3.g6;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends SuspendLambda implements Function3 {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ m $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(boolean z2, m mVar, Continuation<? super k> continuation) {
        super(3, continuation);
        this.$extensionsSupported = z2;
        this.$plugin = mVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        k kVar = new k(this.$extensionsSupported, this.$plugin, continuation);
        kVar.L$0 = fVar;
        return kVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            boolean zB = g6.b(((vf.c) fVar.f5401a).f10557a.c());
            Object obj2 = fVar.f5401a;
            if (!zB) {
                vj.b bVar = n.f10439b;
                if (h2.a(bVar)) {
                    bVar.trace("Skipping WebSocket plugin for non-websocket request: " + ((vf.c) obj2).f10557a);
                }
                return Unit.INSTANCE;
            }
            vj.b bVar2 = n.f10439b;
            if (h2.a(bVar2)) {
                bVar2.trace("Sending WebSocket request " + ((vf.c) obj2).f10557a);
            }
            vf.c cVar = (vf.c) obj2;
            f key = f.f10427a;
            Unit capability = Unit.INSTANCE;
            cVar.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(capability, "capability");
            ((Map) cVar.f.a(mf.j.f8037a, new ob.c(17))).put(key, capability);
            if (this.$extensionsSupported) {
                ArrayList arrayListD = this.$plugin.f10437c.d();
                cVar.f.e(n.f10438a, arrayListD);
                ArrayList arrayList = new ArrayList();
                Iterator it = arrayListD.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                if (!arrayList.isEmpty()) {
                    String strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ";", null, null, 0, null, null, 62, null);
                    String[] strArr = v.f11551a;
                    Intrinsics.checkNotNullParameter(cVar, "<this>");
                    Intrinsics.checkNotNullParameter("Sec-WebSocket-Extensions", "key");
                    if (strJoinToString$default != null) {
                        cVar.f10559c.d("Sec-WebSocket-Extensions", strJoinToString$default.toString());
                    }
                }
            }
            g gVar = new g();
            this.label = 1;
            if (fVar.f(gVar, this) == coroutine_suspended) {
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
