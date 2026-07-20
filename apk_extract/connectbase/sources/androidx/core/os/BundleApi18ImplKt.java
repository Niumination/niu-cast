package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import cb.b;
import in.n;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
final class BundleApi18ImplKt {

    @l
    public static final BundleApi18ImplKt INSTANCE = new BundleApi18ImplKt();

    private BundleApi18ImplKt() {
    }

    @n
    @DoNotInline
    public static final void putBinder(@l Bundle bundle, @l String str, @m IBinder iBinder) {
        l0.p(bundle, "bundle");
        l0.p(str, b.c.f1408o);
        bundle.putBinder(str, iBinder);
    }
}
