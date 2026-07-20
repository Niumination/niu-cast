package sk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    public static final class a extends kn.n0 implements jn.l<e0, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(e0 e0Var) {
            invoke2(e0Var);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l e0 e0Var) {
            kn.l0.p(e0Var, "$this$configure");
            if (e0Var instanceof e0.e) {
                ((e0.e) e0Var).f15121h = true;
            }
        }
    }

    @os.l
    public static final c0 a(@os.l rk.j jVar) {
        kn.l0.p(jVar, "selector");
        return new c0(jVar, e0.f15113e.a());
    }

    @os.l
    public static final <T extends k<? extends T, ?>> T b(@os.l T t10) {
        kn.l0.p(t10, "<this>");
        return (T) t10.a(a.INSTANCE);
    }
}
