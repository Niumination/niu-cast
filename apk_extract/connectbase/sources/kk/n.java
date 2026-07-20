package kk;

import ik.p0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final p0 f9238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final CharSequence f9239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final CharSequence f9240e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@os.l p0 p0Var, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l f fVar, @os.l lk.c cVar) {
        super(fVar, cVar);
        l0.p(p0Var, "method");
        l0.p(charSequence, "uri");
        l0.p(charSequence2, lb.f.f9782f);
        l0.p(fVar, "headers");
        l0.p(cVar, "builder");
        this.f9238c = p0Var;
        this.f9239d = charSequence;
        this.f9240e = charSequence2;
    }

    @os.l
    public final p0 d() {
        return this.f9238c;
    }

    @os.l
    public final CharSequence h() {
        return this.f9239d;
    }

    @os.l
    public final CharSequence k() {
        return this.f9240e;
    }
}
