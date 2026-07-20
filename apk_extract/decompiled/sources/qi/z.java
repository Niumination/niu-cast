package qi;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import li.j2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a8.a f9173a = new a8.a("NO_THREAD_ELEMENTS", 15);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ag.q f9174b = new ag.q(14);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ag.q f9175c = new ag.q(15);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ag.q f9176d = new ag.q(16);

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f9173a) {
            return;
        }
        if (!(obj instanceof b0)) {
            Object objFold = coroutineContext.fold(null, f9175c);
            Intrinsics.checkNotNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((bf.p) ((j2) objFold)).b(coroutineContext, obj);
            return;
        }
        b0 b0Var = (b0) obj;
        j2[] j2VarArr = b0Var.f9135c;
        int length = j2VarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i8 = length - 1;
            j2 j2Var = j2VarArr[length];
            Intrinsics.checkNotNull(j2Var);
            ((bf.p) j2Var).b(coroutineContext, b0Var.f9134b[length]);
            if (i8 < 0) {
                return;
            } else {
                length = i8;
            }
        }
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, f9174b);
        Intrinsics.checkNotNull(objFold);
        return objFold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f9173a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new b0(((Number) obj).intValue(), coroutineContext), f9176d);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((bf.p) ((j2) obj)).c(coroutineContext);
    }
}
