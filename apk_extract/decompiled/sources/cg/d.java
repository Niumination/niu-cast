package cg;

import kotlin.Function;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import qg.c0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements oi.i, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f1674a;

    public d(c0 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f1674a = function;
    }

    @Override // oi.i
    public final /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return this.f1674a.invoke(obj, continuation);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof oi.i) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(this.f1674a, ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.f1674a;
    }

    public final int hashCode() {
        return this.f1674a.hashCode();
    }
}
