package jb;

import android.util.Log;
import k3.gc;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import li.c0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends AbstractCoroutineContextElement implements c0 {
    @Override // li.c0
    public final void L(CoroutineContext coroutineContext, Throwable e) {
        Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
        Intrinsics.checkNotNullParameter(e, "e");
        Log.e(gc.f6463b.concat("PhoneDataRepository"), e.getMessage(), e);
    }
}
