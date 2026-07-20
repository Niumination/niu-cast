package wk;

import androidx.core.app.NotificationCompat;
import ik.b1;
import ik.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements uk.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final a0 f19595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final uk.b f19596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ uk.d f19597c;

    public b0(@os.l a0 a0Var, @os.l uk.b bVar, @os.l uk.d dVar) {
        kn.l0.p(a0Var, NotificationCompat.CATEGORY_CALL);
        kn.l0.p(bVar, "pipeline");
        kn.l0.p(dVar, "request");
        this.f19595a = a0Var;
        this.f19596b = bVar;
        this.f19597c = dVar;
    }

    @os.l
    public a0 a() {
        return this.f19595a;
    }

    @Override // uk.d
    @os.l
    public ik.b0 b() {
        return this.f19597c.b();
    }

    @Override // uk.d
    @os.l
    public uk.b c() {
        return this.f19596b;
    }

    @Override // uk.d
    @os.l
    public uk.h e() {
        return this.f19597c.e();
    }

    @Override // uk.d
    public dk.b f() {
        return this.f19595a;
    }

    @Override // uk.d
    @os.l
    public l1 g() {
        return this.f19597c.g();
    }

    @Override // uk.d
    @os.l
    public pl.k i() {
        return this.f19597c.i();
    }

    @Override // uk.d
    @os.l
    public b1 j() {
        return this.f19597c.j();
    }
}
