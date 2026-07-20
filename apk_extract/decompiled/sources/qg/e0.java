package qg;

import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import m3.y5;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public e0(Continuation<? super e0> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        e0 e0Var = new e0(continuation);
        e0Var.L$0 = fVar;
        e0Var.L$1 = obj;
        return e0Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[Catch: a -> 0x00a0, TryCatch #0 {a -> 0x00a0, blocks: (B:22:0x005a, B:24:0x0070, B:27:0x007a, B:26:0x0078), top: B:42:0x005a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        zf.i iVarA;
        hh.f fVar;
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
        hh.f fVar2 = (hh.f) this.L$0;
        Object obj2 = this.L$1;
        jh.o oVar = obj2 instanceof jh.o ? (jh.o) obj2 : null;
        if (oVar == null) {
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(mg.s.a((mg.r) fVar2.f5401a).f5872a, Reflection.getOrCreateKotlinClass(String.class))) {
            return Unit.INSTANCE;
        }
        Object obj3 = fVar2.f5401a;
        mg.r rVar = (mg.r) obj3;
        try {
            vg.e eVarG = ((mg.r) obj3).g();
            Intrinsics.checkNotNullParameter(eVarG, "<this>");
            Intrinsics.checkNotNullParameter(eVarG, "<this>");
            String[] strArr = zf.v.f11551a;
            String strB = m3.k.b(eVarG, "Content-Type");
            if (strB != null) {
                zf.i iVar = zf.i.f11505h;
                iVarA = m3.l0.a(strB);
                if (iVarA == null) {
                    iVarA = zf.i.f11505h;
                }
            } else {
                iVarA = zf.i.f11505h;
            }
            Charset charsetA = y5.a(iVarA);
            if (charsetA == null) {
                charsetA = Charsets.UTF_8;
            }
            this.L$0 = fVar2;
            this.label = 1;
            Object objA = g0.a(oVar, charsetA, this);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            fVar = fVar2;
            obj = objA;
        } catch (zf.a e) {
            StringBuilder sb2 = new StringBuilder("Illegal Content-Type header format: ");
            zf.r rVarA = rVar.g().a();
            String[] strArr2 = zf.v.f11551a;
            sb2.append(rVarA.get("Content-Type"));
            throw new ug.a(sb2.toString(), e);
        }
        this.L$0 = null;
        this.label = 2;
        if (fVar.f((String) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
