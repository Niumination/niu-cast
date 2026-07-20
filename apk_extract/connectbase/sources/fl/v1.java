package fl;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 {

    public static final class a extends kn.n0 implements jn.l<ik.n1, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l ik.n1 n1Var) {
            kn.l0.p(n1Var, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(ik.n1 n1Var) {
            invoke2(n1Var);
            return l2.f10208a;
        }
    }

    @os.l
    public static final ik.n1 a(@os.l ik.n1.a aVar, @os.l dk.b bVar) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        ik.l1 l1VarE = gk.u0.e(bVar.d());
        ik.n1 n1Var = new ik.n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null);
        ik.t1.f8189c.getClass();
        ik.t1 t1Var = (ik.t1) ik.t1.f8195i.get(l1VarE.d());
        if (t1Var == null) {
            t1Var = new ik.t1(l1VarE.d(), 0);
        }
        n1Var.t(t1Var);
        n1Var.q(jq.h0.v5(l1VarE.b(), ":", null, 2, null));
        n1Var.f8123c = l1VarE.a();
        n1Var.o(uk.e.v(bVar.d()));
        n1Var.f8127g.b(bVar.d().j());
        return n1Var;
    }

    @os.l
    public static final String b(@os.l dk.b bVar, @os.l jn.l<? super ik.n1, l2> lVar) {
        kn.l0.p(bVar, "<this>");
        kn.l0.p(lVar, "block");
        ik.n1 n1VarA = a(ik.n1.f8120j, bVar);
        lVar.invoke(n1VarA);
        return n1VarA.c();
    }

    @os.l
    public static final String c(@os.l jn.l<? super ik.n1, l2> lVar) {
        kn.l0.p(lVar, "block");
        ik.n1 n1Var = new ik.n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null);
        lVar.invoke(n1Var);
        return n1Var.c();
    }

    public static /* synthetic */ String d(dk.b bVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = a.INSTANCE;
        }
        kn.l0.p(bVar, "<this>");
        kn.l0.p(lVar, "block");
        ik.n1 n1VarA = a(ik.n1.f8120j, bVar);
        lVar.invoke(n1VarA);
        return n1VarA.c();
    }
}
