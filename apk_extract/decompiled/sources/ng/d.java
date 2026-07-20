package ng;

import af.r5;
import java.util.Locale;
import jh.j0;
import jh.l0;
import jh.o0;
import k3.ha;
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
import m3.b6;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends SuspendLambda implements Function3 {
    final /* synthetic */ b $call;
    final /* synthetic */ String $continueResponse;
    final /* synthetic */ String $expectHeaderValue;
    final /* synthetic */ j0 $output;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, p pVar, String str, j0 j0Var, String str2, Continuation<? super d> continuation) {
        super(3, continuation);
        this.$call = bVar;
        this.this$0 = pVar;
        this.$expectHeaderValue = str;
        this.$output = j0Var;
        this.$continueResponse = str2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        return new d(this.$call, this.this$0, this.$expectHeaderValue, this.$output, this.$continueResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x010f A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String lowerCase;
        j0 j0Var;
        j0 j0Var2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        KType kTypeTypeOf = null;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    j0Var = (j0) this.L$1;
                    j0Var2 = (j0) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = j0Var2;
                    this.L$1 = null;
                    this.label = 3;
                    if (((jh.k) j0Var).h(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i8 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            r rVar = this.$call.f8247d;
            zf.y yVar = zf.y.f11560d;
            Intrinsics.checkNotNullParameter(rVar, "<this>");
            zf.y yVarA = b6.a((String) ((r5) ug.f.a(rVar)).f559d);
            zf.r rVarA = this.$call.f8247d.a();
            String[] strArr = zf.v.f11551a;
            String str = rVarA.get("Expect");
            if (str != null) {
                lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            this.this$0.getClass();
            String str2 = rVar.a().get("Content-Length");
            Long lValueOf = str2 != null ? Long.valueOf(Long.parseLong(str2)) : null;
            boolean z2 = rVar.a().get("Transfer-Encoding") != null || (lValueOf != null && lValueOf.longValue() > 0);
            if (lowerCase == null || Intrinsics.areEqual(yVarA, zf.y.f) || !z2) {
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(lowerCase, this.$expectHeaderValue)) {
                j0Var = this.$output;
                String str3 = this.$continueResponse;
                this.L$0 = j0Var;
                this.L$1 = j0Var;
                this.label = 2;
                l0 l0Var = o0.f6300a;
                jh.k kVar = (jh.k) j0Var;
                lh.a.n(kVar.k(), str3, 0, 0, 14);
                Object objB = ha.b(kVar, this);
                if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objB = Unit.INSTANCE;
                }
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j0Var2 = j0Var;
                this.L$0 = j0Var2;
                this.L$1 = null;
                this.label = 3;
                if (((jh.k) j0Var).h(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                b bVar = this.$call;
                zf.z zVar = zf.z.f11577v;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zf.z.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(zf.z.class);
                } catch (Throwable unused) {
                }
                ih.a aVar = new ih.a(orCreateKotlinClass, kTypeTypeOf);
                this.label = 1;
                bVar.getClass();
                if (mg.l.a(bVar, zVar, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
