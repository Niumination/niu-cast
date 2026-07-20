package hi;

import jq.e0;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final C0197a f7108c = new C0197a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @in.f
    @os.l
    public static final a f7109d = new a(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final String f7110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final f f7111b;

    /* JADX INFO: renamed from: hi.a$a, reason: collision with other inner class name */
    public static final class C0197a {
        public C0197a() {
        }

        public C0197a(w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @in.j
    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static a d(a aVar, String str, f fVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = aVar.f7110a;
        }
        if ((i10 & 2) != 0) {
            fVar = aVar.f7111b;
        }
        aVar.getClass();
        return new a(str, fVar);
    }

    @os.m
    public final String a() {
        return this.f7110a;
    }

    @os.m
    public final f b() {
        return this.f7111b;
    }

    @os.l
    public final a c(@os.m String str, @os.m f fVar) {
        return new a(str, fVar);
    }

    @os.m
    public final f e() {
        return this.f7111b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return l0.g(this.f7110a, aVar.f7110a) && this.f7111b == aVar.f7111b;
    }

    @os.m
    public final String f() {
        return this.f7110a;
    }

    public final boolean g() {
        String str = this.f7110a;
        return !(str == null || e0.S1(str));
    }

    public int hashCode() {
        String str = this.f7110a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        f fVar = this.f7111b;
        return iHashCode + (fVar != null ? fVar.hashCode() : 0);
    }

    @os.l
    public String toString() {
        return "BridgeConfig(targetPackage=" + this.f7110a + ", role=" + this.f7111b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @in.j
    public a(@os.m String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
    }

    @in.j
    public a(@os.m String str, @os.m f fVar) {
        this.f7110a = str;
        this.f7111b = fVar;
    }

    public /* synthetic */ a(String str, f fVar, int i10, w wVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : fVar);
    }
}
