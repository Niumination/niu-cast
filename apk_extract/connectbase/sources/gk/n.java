package gk;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f6676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final m f6677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ArrayList<jn.p<dk.b, nk.s, Boolean>> f6678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f6679d;

    public n(@os.l String str, @os.l m mVar) {
        kn.l0.p(str, "name");
        kn.l0.p(mVar, "encoder");
        this.f6676a = str;
        this.f6677b = mVar;
        this.f6678c = new ArrayList<>();
        this.f6679d = 1.0d;
    }

    @Override // gk.t
    public List a() {
        return this.f6678c;
    }

    @lm.k(message = "This is going to become internal. Please stop building it manually or file a ticket with explanation why do you need it.")
    @os.l
    public final o b() {
        return c();
    }

    @os.l
    public final o c() {
        return new o(this.f6676a, this.f6677b, nm.h0.V5(this.f6678c), this.f6679d);
    }

    @os.l
    public ArrayList<jn.p<dk.b, nk.s, Boolean>> d() {
        return this.f6678c;
    }

    @os.l
    public final m e() {
        return this.f6677b;
    }

    @os.l
    public final String f() {
        return this.f6676a;
    }

    public final double g() {
        return this.f6679d;
    }

    public final void h(double d10) {
        this.f6679d = d10;
    }
}
