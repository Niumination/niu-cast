package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import in.n;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
final class PersistableBundleApi22ImplKt {

    @l
    public static final PersistableBundleApi22ImplKt INSTANCE = new PersistableBundleApi22ImplKt();

    private PersistableBundleApi22ImplKt() {
    }

    @n
    @DoNotInline
    public static final void putBoolean(@l PersistableBundle persistableBundle, @m String str, boolean z10) {
        l0.p(persistableBundle, "persistableBundle");
        persistableBundle.putBoolean(str, z10);
    }

    @n
    @DoNotInline
    public static final void putBooleanArray(@l PersistableBundle persistableBundle, @m String str, @l boolean[] zArr) {
        l0.p(persistableBundle, "persistableBundle");
        l0.p(zArr, "value");
        persistableBundle.putBooleanArray(str, zArr);
    }
}
