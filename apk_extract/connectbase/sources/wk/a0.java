package wk;

import androidx.core.app.NotificationCompat;
import ik.b1;
import ik.c1;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements dk.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dk.b f19588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final v f19589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final b0 f19590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final c0 f19591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final lm.d0 f19592e;

    public static final class a extends kn.n0 implements jn.a<b1> {
        final /* synthetic */ b1 $parameters;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b1 b1Var) {
            super(0);
            this.$parameters = b1Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final b1 invoke() {
            b1.a aVar = b1.f7942c;
            a0 a0Var = a0.this;
            b1 b1Var = this.$parameters;
            c1 c1Var = new c1(0, null, 3, null);
            c1Var.b(a0Var.f19588a.getParameters());
            c1Var.d(b1Var);
            return c1Var.f();
        }
    }

    public a0(@os.l dk.b bVar, @os.l v vVar, @os.l uk.b bVar2, @os.l vk.d dVar, @os.l b1 b1Var) {
        kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        kn.l0.p(vVar, "route");
        kn.l0.p(bVar2, "receivePipeline");
        kn.l0.p(dVar, "responsePipeline");
        kn.l0.p(b1Var, "parameters");
        this.f19588a = bVar;
        this.f19589b = vVar;
        this.f19590c = new b0(this, bVar2, bVar.d());
        this.f19591d = new c0(this, dVar, bVar.e());
        this.f19592e = lm.f0.c(lm.h0.NONE, new a(b1Var));
    }

    @Override // dk.b
    @os.l
    public dk.a a() {
        return this.f19588a.a();
    }

    @Override // dk.b
    @os.l
    public fl.c c() {
        return this.f19588a.c();
    }

    @Override // dk.b
    public uk.d d() {
        return this.f19590c;
    }

    @Override // dk.b
    public vk.a e() {
        return this.f19591d;
    }

    @os.l
    public b0 f() {
        return this.f19590c;
    }

    @os.l
    public c0 g() {
        return this.f19591d;
    }

    @Override // dk.b
    @os.l
    public b1 getParameters() {
        return (b1) this.f19592e.getValue();
    }

    @os.l
    public final v h() {
        return this.f19589b;
    }

    @os.l
    public String toString() {
        return "RoutingApplicationCall(route=" + this.f19589b + ')';
    }
}
