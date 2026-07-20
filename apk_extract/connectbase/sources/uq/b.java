package uq;

import in.f;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import lm.c1;
import lm.l2;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b<T> implements BiFunction<T, Throwable, l2> {

    @m
    @f
    public volatile um.d<? super T> cont;

    public b(@m um.d<? super T> dVar) {
        this.cont = dVar;
    }

    public void a(@m T t10, @m Throwable th2) {
        Throwable cause;
        um.d<? super T> dVar = this.cont;
        if (dVar == null) {
            return;
        }
        if (th2 == null) {
            c1.a aVar = c1.Companion;
            dVar.resumeWith(c1.m59constructorimpl(t10));
            return;
        }
        CompletionException completionException = th2 instanceof CompletionException ? (CompletionException) th2 : null;
        if (completionException != null && (cause = completionException.getCause()) != null) {
            th2 = cause;
        }
        c1.a aVar2 = c1.Companion;
        w.a.a(th2, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ l2 apply(Object obj, Throwable th2) {
        a(obj, th2);
        return l2.f10208a;
    }
}
