package gp;

import eo.e1;
import eo.k0;
import java.util.ArrayList;
import kn.l0;
import nm.e0;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f6758a = new a();

        @Override // gp.b
        @os.l
        public String a(@os.l eo.h hVar, @os.l gp.c cVar) {
            l0.p(hVar, "classifier");
            l0.p(cVar, "renderer");
            if (hVar instanceof e1) {
                dp.f name = ((e1) hVar).getName();
                l0.o(name, "classifier.name");
                return cVar.x(name, false);
            }
            dp.d dVarM = hp.d.m(hVar);
            l0.o(dVarM, "getFqName(classifier)");
            return cVar.w(dVarM);
        }
    }

    /* JADX INFO: renamed from: gp.b$b, reason: collision with other inner class name */
    public static final class C0183b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final C0183b f6759a = new C0183b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [eo.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v1, types: [eo.i0, eo.m] */
        /* JADX WARN: Type inference failed for: r1v2, types: [eo.m] */
        @Override // gp.b
        @os.l
        public String a(@os.l eo.h hVar, @os.l gp.c cVar) {
            l0.p(hVar, "classifier");
            l0.p(cVar, "renderer");
            if (hVar instanceof e1) {
                dp.f name = ((e1) hVar).getName();
                l0.o(name, "classifier.name");
                return cVar.x(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(hVar.getName());
                hVar = hVar.b();
            } while (hVar instanceof eo.e);
            return n.c(e0.b1(arrayList));
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final c f6760a = new c();

        @Override // gp.b
        @os.l
        public String a(@os.l eo.h hVar, @os.l gp.c cVar) {
            l0.p(hVar, "classifier");
            l0.p(cVar, "renderer");
            return b(hVar);
        }

        public final String b(eo.h hVar) {
            dp.f name = hVar.getName();
            l0.o(name, "descriptor.name");
            String strB = n.b(name);
            if (hVar instanceof e1) {
                return strB;
            }
            eo.m mVarB = hVar.b();
            l0.o(mVarB, "descriptor.containingDeclaration");
            String strC = c(mVarB);
            if (strC == null || l0.g(strC, "")) {
                return strB;
            }
            return ((Object) strC) + n1.e.f11183c + strB;
        }

        public final String c(eo.m mVar) {
            if (mVar instanceof eo.e) {
                return b((eo.h) mVar);
            }
            if (!(mVar instanceof k0)) {
                return null;
            }
            dp.d dVarJ = ((k0) mVar).e().j();
            l0.o(dVarJ, "descriptor.fqName.toUnsafe()");
            return n.a(dVarJ);
        }
    }

    @os.l
    String a(@os.l eo.h hVar, @os.l gp.c cVar);
}
