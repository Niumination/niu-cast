package wk;

import androidx.core.app.NotificationCompat;
import ik.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements vk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final a0 f19604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final vk.d f19605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ vk.a f19606c;

    public c0(@os.l a0 a0Var, @os.l vk.d dVar, @os.l vk.a aVar) {
        kn.l0.p(a0Var, NotificationCompat.CATEGORY_CALL);
        kn.l0.p(dVar, "pipeline");
        kn.l0.p(aVar, "response");
        this.f19604a = a0Var;
        this.f19605b = dVar;
        this.f19606c = aVar;
    }

    @Override // vk.a
    public void a(@os.l r0 r0Var) {
        kn.l0.p(r0Var, "value");
        this.f19606c.a(r0Var);
    }

    @Override // vk.a
    @os.l
    public vk.g b() {
        return this.f19606c.b();
    }

    @Override // vk.a
    @os.l
    public vk.d c() {
        return this.f19605b;
    }

    @Override // vk.a
    @vk.j
    public void d(@os.l vk.h hVar) {
        kn.l0.p(hVar, "builder");
        this.f19606c.d(hVar);
    }

    @Override // vk.a
    @os.l
    public vk.f e() {
        return this.f19606c.e();
    }

    @Override // vk.a
    public dk.b f() {
        return this.f19604a;
    }

    @os.l
    public a0 g() {
        return this.f19604a;
    }

    @Override // vk.a
    @os.m
    public r0 status() {
        return this.f19606c.status();
    }
}
