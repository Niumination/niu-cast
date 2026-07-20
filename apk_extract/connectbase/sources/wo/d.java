package wo;

import eo.h0;
import eo.j0;
import jq.m0;
import kn.l0;
import lm.l2;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f19777b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final rp.j f19778a;

    public static final class a {

        /* JADX INFO: renamed from: wo.d$a$a, reason: collision with other inner class name */
        public static final class C0491a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final d f19779a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @os.l
            public final f f19780b;

            public C0491a(@os.l d dVar, @os.l f fVar) {
                l0.p(dVar, "deserializationComponentsForJava");
                l0.p(fVar, "deserializedDescriptorResolver");
                this.f19779a = dVar;
                this.f19780b = fVar;
            }

            @os.l
            public final d a() {
                return this.f19779a;
            }

            @os.l
            public final f b() {
                return this.f19780b;
            }
        }

        public a() {
        }

        @os.l
        public final C0491a a(@os.l n nVar, @os.l n nVar2, @os.l no.o oVar, @os.l String str, @os.l rp.q qVar, @os.l to.b bVar) {
            l0.p(nVar, "kotlinClassFinder");
            l0.p(nVar2, "jvmBuiltInsKotlinClassFinder");
            l0.p(oVar, "javaClassFinder");
            l0.p(str, "moduleName");
            l0.p(qVar, "errorReporter");
            l0.p(bVar, "javaSourceElementFactory");
            up.f fVar = new up.f("RuntimeModuleData", (Runnable) null, (jn.l<InterruptedException, l2>) null);
            co.f fVar2 = new co.f(fVar, co.f.a.FROM_DEPENDENCIES);
            dp.f fVarN = dp.f.n("<" + str + m0.f8868f);
            l0.o(fVarN, "special(\"<$moduleName>\")");
            ho.x xVar = new ho.x(fVarN, fVar, fVar2, null, null, null, 56, null);
            fVar2.C0(xVar);
            fVar2.H0(xVar, true);
            f fVar3 = new f();
            qo.k kVar = new qo.k();
            j0 j0Var = new j0(fVar, xVar);
            qo.g gVarB = e.b(oVar, xVar, fVar, j0Var, nVar, fVar3, qVar, bVar, kVar, (512 & 512) != 0 ? v.a.f19825a : null);
            d dVarA = e.a(xVar, fVar, j0Var, gVarB, nVar, fVar3, qVar);
            fVar3.n(dVarA);
            oo.g gVar = oo.g.f12349a;
            l0.o(gVar, "EMPTY");
            mp.c cVar = new mp.c(gVarB, gVar);
            kVar.c(cVar);
            co.g gVarG0 = fVar2.G0();
            co.g gVarG1 = fVar2.G0();
            rp.k.a aVar = rp.k.a.f14747a;
            wp.l.f19866b.getClass();
            co.h hVar = new co.h(fVar, nVar2, xVar, j0Var, gVarG0, gVarG1, aVar, wp.l.a.f19868b, new np.b(fVar, k0.INSTANCE));
            xVar.S0(xVar);
            xVar.M0(new ho.i(nm.y.O(cVar.f10860a, hVar), l0.C("CompositeProvider@RuntimeModuleData for ", xVar)));
            return new C0491a(dVarA, fVar3);
        }

        public a(kn.w wVar) {
        }
    }

    public d(@os.l up.n nVar, @os.l h0 h0Var, @os.l rp.k kVar, @os.l g gVar, @os.l b bVar, @os.l qo.g gVar2, @os.l j0 j0Var, @os.l rp.q qVar, @os.l mo.c cVar, @os.l rp.i iVar, @os.l wp.l lVar) {
        l0.p(nVar, "storageManager");
        l0.p(h0Var, "moduleDescriptor");
        l0.p(kVar, "configuration");
        l0.p(gVar, "classDataFinder");
        l0.p(bVar, "annotationAndConstantLoader");
        l0.p(gVar2, "packageFragmentProvider");
        l0.p(j0Var, "notFoundClasses");
        l0.p(qVar, "errorReporter");
        l0.p(cVar, "lookupTracker");
        l0.p(iVar, "contractDeserializer");
        l0.p(lVar, "kotlinTypeChecker");
        ao.h hVarN = h0Var.n();
        co.f fVar = hVarN instanceof co.f ? (co.f) hVarN : null;
        rp.u.a aVar = rp.u.a.f14772a;
        h hVar = h.f19790a;
        k0 k0Var = k0.INSTANCE;
        go.a aVarG0 = fVar == null ? go.a.C0182a.f6752a : fVar.G0();
        go.c cVarG0 = fVar == null ? go.c.b.f6754a : fVar.G0();
        cp.g.f3382a.getClass();
        this.f19778a = new rp.j(nVar, h0Var, kVar, gVar, bVar, gVar2, aVar, qVar, cVar, hVar, k0Var, j0Var, iVar, aVarG0, cVarG0, cp.g.f3383b, lVar, new np.b(nVar, k0Var), null, 262144, null);
    }

    @os.l
    public final rp.j a() {
        return this.f19778a;
    }
}
