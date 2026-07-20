package kj;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends gj.a {
    public final /* synthetic */ n e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6926g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, n nVar, int i8, int i9) {
        super(str, true);
        this.e = nVar;
        this.f = i8;
        this.f6926g = i9;
    }

    @Override // gj.a
    public final long a() {
        s sVar = this.e.f6928b;
        int i8 = this.f;
        int i9 = this.f6926g;
        sVar.getClass();
        try {
            sVar.f6954y.j(true, i8, i9);
            return -1L;
        } catch (IOException e) {
            sVar.c(e);
            return -1L;
        }
    }
}
