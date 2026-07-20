package se;

import k3.lb;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m3 extends AbstractCoroutineContextElement implements li.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t3 f9871a;

    /* JADX WARN: Illegal instructions before constructor call */
    public m3(t3 t3Var) {
        li.b0 b0Var = li.b0.f7433a;
        this.f9871a = t3Var;
        super(b0Var);
    }

    @Override // li.c0
    public final void L(CoroutineContext coroutineContext, Throwable th2) {
        this.f9871a.getClass();
        String mes = "[GLOBAL] Uncaught coroutine exception: ".concat(th2.getClass().getSimpleName());
        Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", mes, "WebSocketKtorServer", null);
        }
    }
}
