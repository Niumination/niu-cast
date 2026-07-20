package pf;

import java.util.Iterator;
import java.util.List;
import k3.g2;
import k3.pc;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vj.b f8835a = g2.a("io.ktor.client.plugins.HttpCallValidator");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final qf.c f8836b = pc.a("HttpResponseValidator", u.INSTANCE, new ag.b(24));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zg.a f8837c;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f8837c = new zg.a("ExpectSuccessAttributeKey", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Unit a(List list, Throwable th2, vf.b bVar, ContinuationImpl continuationImpl) {
        a0 a0Var;
        Iterator it;
        if (continuationImpl instanceof a0) {
            a0Var = (a0) continuationImpl;
            int i8 = a0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                a0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                a0Var = new a0(continuationImpl);
            }
        } else {
            a0Var = new a0(continuationImpl);
        }
        Object obj = a0Var.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = a0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            f8835a.trace("Processing exception " + th2 + " for request " + bVar.getUrl());
            it = list.iterator();
        } else {
            if (i9 != 1 && i9 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) a0Var.L$2;
            ResultKt.throwOnFailure(obj);
        }
        if (!it.hasNext()) {
            return Unit.INSTANCE;
        }
        if (it.next() == null) {
            throw new NoWhenBranchMatchedException();
        }
        throw new ClassCastException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(List list, wf.b bVar, ContinuationImpl continuationImpl) {
        b0 b0Var;
        Iterator it;
        if (continuationImpl instanceof b0) {
            b0Var = (b0) continuationImpl;
            int i8 = b0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                b0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                b0Var = new b0(continuationImpl);
            }
        } else {
            b0Var = new b0(continuationImpl);
        }
        Object obj = b0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = b0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            f8835a.trace("Validating response for request " + bVar.b().d().getUrl());
            it = list.iterator();
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) b0Var.L$1;
            bVar = (wf.b) b0Var.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Function2 function2 = (Function2) it.next();
            b0Var.L$0 = bVar;
            b0Var.L$1 = it;
            b0Var.label = 1;
            if (function2.invoke(bVar, b0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
