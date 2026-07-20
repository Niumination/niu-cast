package hh;

import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f5391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5392d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Object context, List interceptors, Object subject, CoroutineContext coroutineContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f5390b = interceptors;
        this.f5391c = coroutineContext;
        this.f5392d = subject;
    }

    @Override // hh.f
    public final Object a(Object obj, ContinuationImpl continuationImpl) {
        this.e = 0;
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.f5392d = obj;
        return e(continuationImpl);
    }

    @Override // hh.f
    public final void b() {
        this.e = -1;
    }

    @Override // hh.f
    public final Object d() {
        return this.f5392d;
    }

    @Override // hh.f
    public final Object e(Continuation continuation) {
        int i8 = this.e;
        if (i8 < 0) {
            return this.f5392d;
        }
        if (i8 < this.f5390b.size()) {
            return h(continuation);
        }
        this.e = -1;
        return this.f5392d;
    }

    @Override // hh.f
    public final Object f(Object obj, Continuation continuation) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.f5392d = obj;
        return e(continuation);
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f5391c;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h(Continuation continuation) {
        a aVar;
        Function3 function3;
        Object obj;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i8 = aVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                aVar.label = i8 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuation);
            }
        } else {
            aVar = new a(this, continuation);
        }
        Object obj2 = aVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = aVar.label;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (b) aVar.L$0;
        }
        ResultKt.throwOnFailure(obj2);
        do {
            int i10 = this.e;
            if (i10 != -1) {
                List list = this.f5390b;
                if (i10 >= list.size()) {
                    this.e = -1;
                } else {
                    function3 = (Function3) list.get(i10);
                    this.e = i10 + 1;
                    obj = this.f5392d;
                    aVar.L$0 = this;
                    aVar.label = 1;
                }
            }
            return this.f5392d;
        } while (function3.invoke(this, obj, aVar) != coroutine_suspended);
        return coroutine_suspended;
    }
}
