package hk;

import ik.u;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i[] f5499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5500c;

    public h(u uVar, int i8) {
        this.f5498a = i8;
        this.f5499b = new i[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            this.f5499b[i9] = new i(uVar);
        }
    }
}
