package androidx.core.os;

import jn.a;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n*L\n1#1,69:1\n*E\n"})
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    final /* synthetic */ a<l2> $action;

    public HandlerKt$postDelayed$runnable$1(a<l2> aVar) {
        this.$action = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
