package ck;

import c1.h0;
import vj.o1;
import vj.t0;
import vj.v;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class i extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1.f f1510a;

    @b1.e
    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o1.j f1511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o1.l f1512b;

        /* JADX INFO: renamed from: ck.i$a$a, reason: collision with other inner class name */
        public class C0066a implements o1.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o1.l f1513a;

            public C0066a(o1.l lVar) {
                this.f1513a = lVar;
            }

            @Override // vj.o1.l
            public void a(v vVar) {
                this.f1513a.a(vVar);
                a.this.f1512b.a(vVar);
            }
        }

        public a(o1.j jVar, o1.l lVar) {
            this.f1511a = (o1.j) h0.F(jVar, "delegate");
            this.f1512b = (o1.l) h0.F(lVar, "healthListener");
        }

        @Override // ck.g, vj.o1.j
        public vj.a d() {
            vj.a aVarD = super.d();
            aVarD.getClass();
            return new vj.a.b(aVarD).d(o1.f17198d, Boolean.TRUE).a();
        }

        @Override // ck.g, vj.o1.j
        public void i(o1.l lVar) {
            this.f1511a.i(new C0066a(lVar));
        }

        @Override // ck.g
        public o1.j k() {
            return this.f1511a;
        }
    }

    public i(o1.f fVar) {
        this.f1510a = (o1.f) h0.F(fVar, "helper");
    }

    @Override // ck.f, vj.o1.f
    public o1.j f(o1.b bVar) {
        o1.l lVar = (o1.l) bVar.c(o1.f17197c);
        o1.j jVarF = super.f(bVar);
        if (lVar != null) {
            vj.a aVarD = jVarF.d();
            if (aVarD.f17048a.get(o1.f17198d) == null) {
                return new a(jVarF, lVar);
            }
        }
        return jVarF;
    }

    @Override // ck.f
    public o1.f t() {
        return this.f1510a;
    }
}
