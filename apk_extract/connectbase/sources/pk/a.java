package pk;

import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final String f13165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13166b;

    public a(@l String str, int i10, boolean z10) {
        l0.p(str, "regexRaw");
        if (z10) {
            str = "(" + str + ')';
        }
        this.f13165a = str;
        this.f13166b = z10 ? i10 + 1 : i10;
    }

    public final int a() {
        return this.f13166b;
    }

    @l
    public final String b() {
        return this.f13165a;
    }

    public /* synthetic */ a(String str, int i10, boolean z10, int i11, w wVar) {
        this(str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? false : z10);
    }
}
