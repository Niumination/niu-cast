package yk;

import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {

    public static final class a extends n0 implements jn.l<dk.a, l2> {
        final /* synthetic */ i0 $hook;
        final /* synthetic */ yk.a $this_addShutdownHook;

        /* JADX INFO: renamed from: yk.j0$a$a, reason: collision with other inner class name */
        public static final class C0545a extends n0 implements jn.l<dk.a, l2> {
            final /* synthetic */ i0 $hook;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0545a(i0 i0Var) {
                super(1);
                this.$hook = i0Var;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
                invoke2(aVar);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l dk.a aVar) {
                l0.p(aVar, "it");
                try {
                    Runtime.getRuntime().removeShutdownHook(this.$hook);
                } catch (IllegalStateException unused) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yk.a aVar, i0 i0Var) {
            super(1);
            this.$this_addShutdownHook = aVar;
            this.$hook = i0Var;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l dk.a aVar) {
            l0.p(aVar, "it");
            this.$this_addShutdownHook.c().c().b(dk.k.e(), new C0545a(this.$hook));
            Runtime.getRuntime().addShutdownHook(this.$hook);
        }
    }

    public static final void a(@os.l yk.a aVar, @os.l jn.a<l2> aVar2) {
        l0.p(aVar, "<this>");
        l0.p(aVar2, "stop");
        aVar.c().c().b(dk.k.b(), new a(aVar, new i0(aVar2)));
    }
}
