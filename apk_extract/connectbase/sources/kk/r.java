package kk;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final CharSequence f9248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final CharSequence f9250e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@os.l CharSequence charSequence, int i10, @os.l CharSequence charSequence2, @os.l f fVar, @os.l lk.c cVar) {
        super(fVar, cVar);
        l0.p(charSequence, lb.f.f9782f);
        l0.p(charSequence2, "statusText");
        l0.p(fVar, "headers");
        l0.p(cVar, "builder");
        this.f9248c = charSequence;
        this.f9249d = i10;
        this.f9250e = charSequence2;
    }

    public final int d() {
        return this.f9249d;
    }

    @os.l
    public final CharSequence h() {
        return this.f9250e;
    }

    @os.l
    public final CharSequence k() {
        return this.f9248c;
    }
}
