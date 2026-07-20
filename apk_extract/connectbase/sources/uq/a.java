package uq;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import lm.l2;
import os.l;
import os.m;
import um.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T> extends nq.a<T> implements BiFunction<T, Throwable, l2> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final CompletableFuture<T> f16396d;

    public a(@l g gVar, @l CompletableFuture<T> completableFuture) {
        super(gVar, true, true);
        this.f16396d = completableFuture;
    }

    @Override // nq.a
    public void Q1(@l Throwable th2, boolean z10) {
        this.f16396d.completeExceptionally(th2);
    }

    @Override // nq.a
    public void T1(T t10) {
        this.f16396d.complete(t10);
    }

    public void V1(@m T t10, @m Throwable th2) {
        nq.l2.a.b(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ l2 apply(Object obj, Throwable th2) {
        V1(obj, th2);
        return l2.f10208a;
    }
}
