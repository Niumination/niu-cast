package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import o.d;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int g();

    public abstract long h();

    public abstract long i();

    public abstract String k();

    public final String toString() {
        long jI = i();
        int iG = g();
        long jH = h();
        String strK = k();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(jI);
        sb2.append("\t");
        sb2.append(iG);
        sb2.append("\t");
        return d.p(sb2, jH, strK);
    }
}
