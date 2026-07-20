package no;

import kn.l0;
import kn.l1;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final b f11785d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final v f11786e = new v(t.b(null, 1, null), a.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final x f11787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<dp.c, e0> f11788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11789c;

    public /* synthetic */ class a extends kn.g0 implements jn.l<dp.c, e0> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "getDefaultReportLevelForAnnotation";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.h(t.class, "compiler.common.jvm");
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
        }

        @Override // jn.l
        @os.l
        public final e0 invoke(@os.l dp.c cVar) {
            l0.p(cVar, "p0");
            return t.d(cVar);
        }
    }

    public static final class b {
        public b() {
        }

        @os.l
        public final v a() {
            return v.f11786e;
        }

        public b(kn.w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@os.l x xVar, @os.l jn.l<? super dp.c, ? extends e0> lVar) {
        l0.p(xVar, "jsr305");
        l0.p(lVar, "getReportLevelForAnnotation");
        this.f11787a = xVar;
        this.f11788b = lVar;
        this.f11789c = xVar.f11795e || lVar.invoke(t.e()) == e0.IGNORE;
    }

    public final boolean b() {
        return this.f11789c;
    }

    @os.l
    public final jn.l<dp.c, e0> c() {
        return this.f11788b;
    }

    @os.l
    public final x d() {
        return this.f11787a;
    }

    @os.l
    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f11787a + ", getReportLevelForAnnotation=" + this.f11788b + ')';
    }
}
