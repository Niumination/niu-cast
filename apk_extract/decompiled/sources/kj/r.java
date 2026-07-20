package kj;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends gj.a {
    public final /* synthetic */ s e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f6935g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String str, s sVar, int i8, long j8) {
        super(str, true);
        this.e = sVar;
        this.f = i8;
        this.f6935g = j8;
    }

    @Override // gj.a
    public final long a() {
        s sVar = this.e;
        try {
            sVar.f6954y.d(this.f, this.f6935g);
            return -1L;
        } catch (IOException e) {
            sVar.c(e);
            return -1L;
        }
    }
}
