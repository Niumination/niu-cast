package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import cb.b;
import in.n;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class BundleApi21ImplKt {

    @l
    public static final BundleApi21ImplKt INSTANCE = new BundleApi21ImplKt();

    private BundleApi21ImplKt() {
    }

    @n
    @DoNotInline
    public static final void putSize(@l Bundle bundle, @l String str, @m Size size) {
        l0.p(bundle, "bundle");
        l0.p(str, b.c.f1408o);
        bundle.putSize(str, size);
    }

    @n
    @DoNotInline
    public static final void putSizeF(@l Bundle bundle, @l String str, @m SizeF sizeF) {
        l0.p(bundle, "bundle");
        l0.p(str, b.c.f1408o);
        bundle.putSizeF(str, sizeF);
    }
}
