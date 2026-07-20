package yk;

import ik.r0;
import java.util.List;
import kn.l1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final fl.b<l2> f21417a = new fl.b<>("SendPipelineExecutedAttributeKey");

    @xm.f(c = "io.ktor.server.engine.BaseApplicationEngineKt", f = "BaseApplicationEngine.kt", i = {0}, l = {y5.a.Z}, m = "verifyHostHeader", n = {"$this$verifyHostHeader"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.c(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object c(nl.f<l2, dk.b> fVar, um.d<? super l2> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(obj);
            ik.b0 b0VarB = fVar.getContext().d().b();
            ik.j0.f8048a.getClass();
            List<String> listB = b0VarB.b(ik.j0.F);
            if (listB == null) {
                return l2.f10208a;
            }
            if (listB.size() > 1) {
                dk.b context = fVar.getContext();
                r0.f8158c.getClass();
                r0 r0Var = r0.f8182x;
                if (!(r0Var instanceof byte[])) {
                    try {
                        vk.i.b(context.e(), l1.A(r0.class));
                    } catch (Throwable unused) {
                    }
                }
                vk.d dVarC = context.e().c();
                aVar.L$0 = fVar;
                aVar.label = 1;
                if (dVarC.g(context, r0Var, aVar) == aVar2) {
                    return aVar2;
                }
            }
            return l2.f10208a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        fVar = (nl.f) aVar.L$0;
        d1.n(obj);
        fVar.finish();
        return l2.f10208a;
    }
}
