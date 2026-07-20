package hh;

import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f5411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5412d;
    public final Continuation[] e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5414i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Object initial, Object context, List blocks) {
        super(context);
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        this.f5410b = blocks;
        this.f5411c = new n(this);
        this.f5412d = initial;
        this.e = new Continuation[blocks.size()];
        this.f5413h = -1;
    }

    @Override // hh.f
    public final Object a(Object obj, ContinuationImpl continuationImpl) {
        this.f5414i = 0;
        if (this.f5410b.size() == 0) {
            return obj;
        }
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.f5412d = obj;
        if (this.f5413h < 0) {
            return e(continuationImpl);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // hh.f
    public final void b() {
        this.f5414i = this.f5410b.size();
    }

    @Override // hh.f
    public final Object d() {
        return this.f5412d;
    }

    @Override // hh.f
    public final Object e(Continuation continuation) {
        Object coroutine_suspended;
        if (this.f5414i == this.f5410b.size()) {
            coroutine_suspended = this.f5412d;
        } else {
            Continuation continuation2 = IntrinsicsKt.intercepted(continuation);
            Intrinsics.checkNotNullParameter(continuation2, "continuation");
            int i8 = this.f5413h + 1;
            this.f5413h = i8;
            Continuation[] continuationArr = this.e;
            continuationArr[i8] = continuation2;
            if (h(true)) {
                int i9 = this.f5413h;
                if (i9 < 0) {
                    throw new IllegalStateException("No more continuations to resume");
                }
                this.f5413h = i9 - 1;
                continuationArr[i9] = null;
                coroutine_suspended = this.f5412d;
            } else {
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    @Override // hh.f
    public final Object f(Object obj, Continuation continuation) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.f5412d = obj;
        return e(continuation);
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f5411c.get$context();
    }

    public final boolean h(boolean z2) {
        Function3 interceptor;
        Object subject;
        n continuation;
        do {
            int i8 = this.f5414i;
            List list = this.f5410b;
            if (i8 == list.size()) {
                if (z2) {
                    return true;
                }
                Result.Companion companion = Result.INSTANCE;
                j(Result.m159constructorimpl(this.f5412d));
                return false;
            }
            this.f5414i = i8 + 1;
            interceptor = (Function3) list.get(i8);
            try {
                subject = this.f5412d;
                continuation = this.f5411c;
                Intrinsics.checkNotNullParameter(interceptor, "interceptor");
                Intrinsics.checkNotNullParameter(this, "context");
                Intrinsics.checkNotNullParameter(subject, "subject");
                Intrinsics.checkNotNullParameter(continuation, "continuation");
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                j(Result.m159constructorimpl(ResultKt.createFailure(th2)));
                return false;
            }
        } while (((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(interceptor, 3)).invoke(this, subject, continuation) != IntrinsicsKt.getCOROUTINE_SUSPENDED());
        return false;
    }

    public final void j(Object obj) {
        int i8 = this.f5413h;
        if (i8 < 0) {
            throw new IllegalStateException("No more continuations to resume");
        }
        Continuation[] continuationArr = this.e;
        Continuation continuation = continuationArr[i8];
        Intrinsics.checkNotNull(continuation);
        int i9 = this.f5413h;
        this.f5413h = i9 - 1;
        continuationArr[i9] = null;
        if (!Result.m165isFailureimpl(obj)) {
            continuation.resumeWith(obj);
            return;
        }
        Throwable exception = Result.m162exceptionOrNullimpl(obj);
        Intrinsics.checkNotNull(exception);
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        try {
            exception.getCause();
            Intrinsics.checkNotNullParameter(exception, "<this>");
        } catch (Throwable unused) {
        }
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(exception)));
    }
}
