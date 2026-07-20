package pf;

import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt__IndentKt;
import m3.a6;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 extends SuspendLambda implements Function3 {
    final /* synthetic */ y0 $plugin;
    final /* synthetic */ jf.d $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(y0 y0Var, jf.d dVar, Continuation<? super x0> continuation) {
        super(3, continuation);
        this.$plugin = y0Var;
        this.$scope = dVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        x0 x0Var = new x0(this.$plugin, this.$scope, continuation);
        x0Var.L$0 = fVar;
        x0Var.L$1 = obj;
        return x0Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        hh.f fVar;
        KType kTypeTypeOf;
        KType kTypeTypeOf2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
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
        fVar = (hh.f) this.L$0;
        Object obj2 = this.L$1;
        if (!(obj2 instanceof cg.j)) {
            throw new IllegalStateException(StringsKt__IndentKt.trimMargin$default("\n|Fail to prepare request body for sending. \n|The body type is: " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + ", with Content-Type: " + a6.b((vf.c) fVar.f5401a) + ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header.", null, 1, null).toString());
        }
        vf.c cVar = (vf.c) fVar.f5401a;
        if (obj2 == null) {
            cg.e eVar = cg.e.f1675a;
            cVar.getClass();
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            cVar.f10560d = eVar;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cg.j.class);
            try {
                kTypeTypeOf2 = Reflection.typeOf(cg.j.class);
            } catch (Throwable unused) {
                kTypeTypeOf2 = null;
            }
            cVar.b(new ih.a(orCreateKotlinClass, kTypeTypeOf2));
        } else if (obj2 instanceof cg.j) {
            cVar.getClass();
            Intrinsics.checkNotNullParameter(obj2, "<set-?>");
            cVar.f10560d = obj2;
            cVar.b(null);
        } else {
            cVar.getClass();
            Intrinsics.checkNotNullParameter(obj2, "<set-?>");
            cVar.f10560d = obj2;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cg.j.class);
            try {
                kTypeTypeOf = Reflection.typeOf(cg.j.class);
            } catch (Throwable unused2) {
                kTypeTypeOf = null;
            }
            cVar.b(new ih.a(orCreateKotlinClass2, kTypeTypeOf));
        }
        this.$plugin.getClass();
        m1 v0Var = new v0(this.$scope);
        Iterator it = CollectionsKt.reversed(this.$plugin.f8881a).iterator();
        while (it.hasNext()) {
            v0Var = new w0((Function3) it.next(), v0Var);
        }
        vf.c cVar2 = (vf.c) fVar.f5401a;
        this.L$0 = fVar;
        this.label = 1;
        obj = v0Var.a(cVar2, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.L$0 = null;
        this.label = 2;
        if (fVar.f((kf.c) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
