package sk;

import java.net.SocketAddress;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {

    public static final class a extends kn.n0 implements jn.l<e0.e, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l e0.e eVar) {
            kn.l0.p(eVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(e0.e eVar) {
            invoke2(eVar);
            return l2.f10208a;
        }
    }

    @os.m
    public static final Object a(@os.l k0 k0Var, @os.l SocketAddress socketAddress, @os.l jn.l<? super e0.e, l2> lVar, @os.l um.d<? super b0> dVar) {
        return k0Var.i(socketAddress, lVar, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object b(k0 k0Var, SocketAddress socketAddress, jn.l lVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = a.INSTANCE;
        }
        return k0Var.i(socketAddress, lVar, dVar);
    }
}
