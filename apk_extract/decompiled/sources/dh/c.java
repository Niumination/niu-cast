package dh;

import eh.f;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final Object a(Function1 function1, ContinuationImpl continuationImpl) {
        return !((Boolean) d.f4469a.getValue()).booleanValue() ? function1.invoke(continuationImpl) : l0.u(continuationImpl.get$context().plus(new f()), new b(function1, null), continuationImpl);
    }
}
