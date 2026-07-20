package nk;

import ik.j0;
import kn.l0;
import kn.n0;
import lm.a1;
import lm.f0;
import lm.h0;
import lm.l2;
import tl.g0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.a<l2> f11544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ik.b0 f11545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final lm.d0 f11546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final lm.d0 f11547d;

    public static final class a extends u {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final jn.a<g0> f11548e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l jn.a<? extends g0> aVar, @os.l jn.a<l2> aVar2, @os.l ik.b0 b0Var) {
            super(aVar2, b0Var);
            l0.p(aVar, "provider");
            l0.p(aVar2, "dispose");
            l0.p(b0Var, "partHeaders");
            this.f11548e = aVar;
        }

        @os.l
        public final jn.a<g0> j() {
            return this.f11548e;
        }
    }

    public static final class b extends u {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final jn.a<g0> f11549e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.m
        public final String f11550f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@os.l jn.a<? extends g0> aVar, @os.l jn.a<l2> aVar2, @os.l ik.b0 b0Var) {
            super(aVar2, b0Var);
            l0.p(aVar, "provider");
            l0.p(aVar2, "dispose");
            l0.p(b0Var, "partHeaders");
            this.f11549e = aVar;
            ik.f fVarA = a();
            this.f11550f = fVarA == null ? null : fVarA.c(ik.f.b.f7967b);
        }

        @os.m
        public final String j() {
            return this.f11550f;
        }

        @os.l
        public final jn.a<g0> k() {
            return this.f11549e;
        }
    }

    public static final class c extends u {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final String f11551e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@os.l String str, @os.l jn.a<l2> aVar, @os.l ik.b0 b0Var) {
            super(aVar, b0Var);
            l0.p(str, "value");
            l0.p(aVar, "dispose");
            l0.p(b0Var, "partHeaders");
            this.f11551e = str;
        }

        @os.l
        public final String j() {
            return this.f11551e;
        }
    }

    public static final class d extends n0 implements jn.a<ik.f> {
        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.m
        public final ik.f invoke() {
            ik.b0 b0Var = u.this.f11545b;
            j0.f8048a.getClass();
            String str = b0Var.get(j0.f8074n);
            if (str == null) {
                return null;
            }
            return ik.f.f7961d.e(str);
        }
    }

    public static final class e extends n0 implements jn.a<ik.i> {
        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.m
        public final ik.i invoke() {
            ik.b0 b0Var = u.this.f11545b;
            j0.f8048a.getClass();
            String str = b0Var.get(j0.f8086t);
            if (str == null) {
                return null;
            }
            return ik.i.f7981f.b(str);
        }
    }

    public /* synthetic */ u(jn.a aVar, ik.b0 b0Var, kn.w wVar) {
        this(aVar, b0Var);
    }

    @lm.k(level = lm.m.ERROR, message = "Use headers property instead", replaceWith = @a1(expression = "headers", imports = {}))
    public static /* synthetic */ void g() {
    }

    @lm.k(level = lm.m.ERROR, message = "Use name property instead", replaceWith = @a1(expression = "name", imports = {}))
    public static /* synthetic */ void i() {
    }

    @os.m
    public final ik.f a() {
        return (ik.f) this.f11546c.getValue();
    }

    @os.m
    public final ik.i b() {
        return (ik.i) this.f11547d.getValue();
    }

    @os.l
    public final jn.a<l2> c() {
        return this.f11544a;
    }

    @os.l
    public final ik.b0 d() {
        return this.f11545b;
    }

    @os.m
    public final String e() {
        ik.f fVarA = a();
        if (fVarA == null) {
            return null;
        }
        return fVarA.c("name");
    }

    @os.l
    public final ik.b0 f() {
        return this.f11545b;
    }

    @os.m
    public final String h() {
        return e();
    }

    public u(jn.a<l2> aVar, ik.b0 b0Var) {
        this.f11544a = aVar;
        this.f11545b = b0Var;
        h0 h0Var = h0.NONE;
        this.f11546c = f0.c(h0Var, new d());
        this.f11547d = f0.c(h0Var, new e());
    }
}
