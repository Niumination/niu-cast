package xn;

import eo.k0;
import eo.t0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Field f20321a;

        public a(@os.l Field field) {
            l0.p(field, "field");
            this.f20321a = field;
        }

        @Override // xn.e
        @os.l
        public String a() {
            StringBuilder sb2 = new StringBuilder();
            String name = this.f20321a.getName();
            l0.o(name, "field.name");
            sb2.append(no.y.b(name));
            sb2.append("()");
            Class<?> type = this.f20321a.getType();
            l0.o(type, "field.type");
            sb2.append(ko.d.b(type));
            return sb2.toString();
        }

        @os.l
        public final Field b() {
            return this.f20321a;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Method f20322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final Method f20323b;

        public b(@os.l Method method, @os.m Method method2) {
            l0.p(method, "getterMethod");
            this.f20322a = method;
            this.f20323b = method2;
        }

        @Override // xn.e
        @os.l
        public String a() {
            return e0.b(this.f20322a);
        }

        @os.l
        public final Method b() {
            return this.f20322a;
        }

        @os.m
        public final Method c() {
            return this.f20323b;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final t0 f20324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final yo.a.n f20325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final bp.a.d f20326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final ap.c f20327d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final ap.g f20328e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final String f20329f;

        public c(@os.l t0 t0Var, @os.l yo.a.n nVar, @os.l bp.a.d dVar, @os.l ap.c cVar, @os.l ap.g gVar) {
            String strC;
            l0.p(t0Var, "descriptor");
            l0.p(nVar, "proto");
            l0.p(dVar, "signature");
            l0.p(cVar, "nameResolver");
            l0.p(gVar, "typeTable");
            this.f20324a = t0Var;
            this.f20325b = nVar;
            this.f20326c = dVar;
            this.f20327d = cVar;
            this.f20328e = gVar;
            if (dVar.hasGetter()) {
                strC = l0.C(cVar.c(dVar.getGetter().getName()), cVar.c(dVar.getGetter().getDesc()));
            } else {
                cp.d.a aVarD = cp.g.d(cp.g.f3382a, nVar, cVar, gVar, false, 8, null);
                if (aVarD == null) {
                    throw new y(l0.C("No field signature for property: ", t0Var));
                }
                String str = aVarD.f3365a;
                strC = no.y.b(str) + c() + "()" + aVarD.f3366b;
            }
            this.f20329f = strC;
        }

        @Override // xn.e
        @os.l
        public String a() {
            return this.f20329f;
        }

        @os.l
        public final t0 b() {
            return this.f20324a;
        }

        public final String c() {
            eo.m mVarB = this.f20324a.b();
            l0.o(mVarB, "descriptor.containingDeclaration");
            if (l0.g(this.f20324a.getVisibility(), eo.t.f4632d) && (mVarB instanceof tp.e)) {
                yo.a.c cVar = ((tp.e) mVarB).f15956g;
                fp.i.g<yo.a.c, Integer> gVar = bp.a.f1011i;
                l0.o(gVar, "classModuleName");
                Integer num = (Integer) ap.e.a(cVar, gVar);
                return l0.C("$", dp.g.a(num == null ? "main" : this.f20327d.c(num.intValue())));
            }
            if (!l0.g(this.f20324a.getVisibility(), eo.t.f4629a) || !(mVarB instanceof k0)) {
                return "";
            }
            tp.g gVar2 = ((tp.k) this.f20324a).Y;
            if (!(gVar2 instanceof wo.j)) {
                return "";
            }
            wo.j jVar = (wo.j) gVar2;
            return jVar.f19795c != null ? l0.C("$", jVar.g().b()) : "";
        }

        @os.l
        public final ap.c d() {
            return this.f20327d;
        }

        @os.l
        public final yo.a.n e() {
            return this.f20325b;
        }

        @os.l
        public final bp.a.d f() {
            return this.f20326c;
        }

        @os.l
        public final ap.g g() {
            return this.f20328e;
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final xn.d.e f20330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final xn.d.e f20331b;

        public d(@os.l xn.d.e eVar, @os.m xn.d.e eVar2) {
            l0.p(eVar, "getterSignature");
            this.f20330a = eVar;
            this.f20331b = eVar2;
        }

        @Override // xn.e
        @os.l
        public String a() {
            return this.f20330a.f20318b;
        }

        @os.l
        public final xn.d.e b() {
            return this.f20330a;
        }

        @os.m
        public final xn.d.e c() {
            return this.f20331b;
        }
    }

    public e() {
    }

    @os.l
    public abstract String a();

    public e(kn.w wVar) {
    }
}
