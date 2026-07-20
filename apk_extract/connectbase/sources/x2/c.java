package x2;

import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public final Long f19997a;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @m
    public final Long b() {
        return this.f19997a;
    }

    @l
    public abstract String c();

    public c(@m Long l10) {
        this.f19997a = l10;
    }

    public /* synthetic */ c(Long l10, int i10, w wVar) {
        this((i10 & 1) != 0 ? null : l10);
    }
}
