package dp;

import in.n;
import jq.r;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final g f3822a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final r f3823b = new r("[^\\p{L}\\p{Digit}]");

    @n
    @l
    public static final String a(@l String str) {
        l0.p(str, "name");
        return f3823b.replace(str, "_");
    }
}
