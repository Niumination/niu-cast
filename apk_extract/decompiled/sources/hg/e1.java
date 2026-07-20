package hg;

import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 {
    public static f1 a(int i8) {
        if (768 > i8 || i8 >= 772) {
            throw new IllegalArgumentException(a1.a.o(i8, "Invalid TLS version code "));
        }
        return (f1) f1.byOrdinal.get(i8 - ViewUtils.EDGE_TO_EDGE_FLAGS);
    }
}
