package mf;

import java.util.ArrayList;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import li.l0;
import zf.p0;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends SuspendLambda implements Function3 {
    final /* synthetic */ jf.d $client;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(jf.d dVar, f fVar, Continuation<? super e> continuation) {
        super(3, continuation);
        this.$client = dVar;
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        e eVar = new e(this.$client, this.this$0, continuation);
        eVar.L$0 = fVar;
        eVar.L$1 = obj;
        return eVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        KType kTypeTypeOf;
        vf.d requestData;
        hh.f fVar;
        KType kTypeTypeOf2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                requestData = (vf.d) this.L$1;
                fVar = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        hh.f fVar2 = (hh.f) this.L$0;
        Object obj2 = this.L$1;
        vf.c cVar = new vf.c();
        cVar.c((vf.c) fVar2.f5401a);
        if (obj2 == null) {
            cg.e eVar = cg.e.f1675a;
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            cVar.f10560d = eVar;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            try {
                kTypeTypeOf2 = Reflection.typeOf(Object.class);
            } catch (Throwable unused) {
                kTypeTypeOf2 = null;
            }
            cVar.b(new ih.a(orCreateKotlinClass, kTypeTypeOf2));
        } else if (obj2 instanceof cg.j) {
            Intrinsics.checkNotNullParameter(obj2, "<set-?>");
            cVar.f10560d = obj2;
            cVar.b(null);
        } else {
            Intrinsics.checkNotNullParameter(obj2, "<set-?>");
            cVar.f10560d = obj2;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            try {
                kTypeTypeOf = Reflection.typeOf(Object.class);
            } catch (Throwable unused2) {
                kTypeTypeOf = null;
            }
            cVar.b(new ih.a(orCreateKotlinClass2, kTypeTypeOf));
        }
        this.$client.f6263l.a(xf.a.f10920b, cVar);
        requestData = cVar.a();
        requestData.f.e(l.f8039b, this.$client.f6264m);
        Set setNames = requestData.f10563c.names();
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : setNames) {
            if (v.f11552b.contains((String) obj3)) {
                arrayList.add(obj3);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new p0(arrayList.toString());
        }
        f fVar3 = this.this$0;
        for (i iVar : requestData.f10565g) {
            if (!fVar3.V().contains(iVar)) {
                throw new IllegalArgumentException(("Engine doesn't support " + iVar).toString());
            }
        }
        f fVar4 = this.this$0;
        this.L$0 = fVar2;
        this.L$1 = requestData;
        this.label = 1;
        Object objA = b.a(fVar4, requestData, this);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        fVar = fVar2;
        obj = objA;
        vf.g responseData = (vf.g) obj;
        jf.d client = this.$client;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        kf.c cVar2 = new kf.c(client);
        vf.a aVar = new vf.a(cVar2, requestData);
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        cVar2.f6856b = aVar;
        kf.i iVar2 = new kf.i(cVar2, responseData);
        Intrinsics.checkNotNullParameter(iVar2, "<set-?>");
        cVar2.f6857c = iVar2;
        Object obj4 = responseData.e;
        if (!(obj4 instanceof jh.o)) {
            cVar2.i().e(kf.c.e, obj4);
        }
        wf.b bVarE = cVar2.e();
        this.$client.f6263l.a(xf.a.f10921c, bVarE);
        l0.k(bVarE.getCoroutineContext()).A(new gi.a(3, this.$client, bVarE));
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (fVar.f(cVar2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
