package gk;

import java.util.Arrays;
import kn.l1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 {

    @xm.f(c = "io.ktor.features.StatusPagesKt$statusFile$1", f = "StatusPages.kt", i = {}, l = {178, 189}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.q<nl.f<?, dk.b>, ik.r0, um.d<? super l2>, Object> {
        final /* synthetic */ String $filePattern;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, um.d<? super a> dVar) {
            super(3, dVar);
            this.$filePattern = str;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                lm.d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                ik.r0 r0Var = (ik.r0) this.L$1;
                nk.s sVarD = nk.x.d((dk.b) fVar.getContext(), jq.e0.i2(this.$filePattern, "#", String.valueOf(r0Var.f8185a), false, 4, null), null, null, null, 14, null);
                if (sVarD == null) {
                    dk.b bVar = (dk.b) fVar.getContext();
                    ik.r0.f8158c.getClass();
                    ik.r0 r0Var2 = ik.r0.V;
                    if (!(r0Var2 instanceof byte[])) {
                        try {
                            vk.i.b(bVar.e(), l1.A(ik.r0.class));
                        } catch (Throwable unused) {
                        }
                    }
                    vk.d dVarC = bVar.e().c();
                    this.L$0 = null;
                    this.label = 1;
                    if (dVarC.g(bVar, r0Var2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    ((dk.b) fVar.getContext()).e().a(r0Var);
                    dk.b bVar2 = (dk.b) fVar.getContext();
                    vk.d dVarC2 = bVar2.e().c();
                    this.L$0 = null;
                    this.label = 2;
                    if (dVarC2.g(bVar2, sVarD, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<?, dk.b> fVar, @os.l ik.r0 r0Var, @os.m um.d<? super l2> dVar) {
            a aVar = new a(this.$filePattern, dVar);
            aVar.L$0 = fVar;
            aVar.L$1 = r0Var;
            return aVar.invokeSuspend(l2.f10208a);
        }
    }

    public static final void a(@os.l a1.a aVar, @os.l ik.r0[] r0VarArr, @os.l String str) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(r0VarArr, "code");
        kn.l0.p(str, "filePattern");
        aVar.e((ik.r0[]) Arrays.copyOf(r0VarArr, r0VarArr.length), new a(str, null));
    }
}
