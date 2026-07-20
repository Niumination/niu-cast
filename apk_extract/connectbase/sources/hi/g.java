package hi;

import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f7132b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f7133a;

    public static final class a extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public final String f7134c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static a d(a aVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = aVar.f7134c;
            }
            aVar.getClass();
            return new a(str);
        }

        @os.m
        public final String b() {
            return this.f7134c;
        }

        @os.l
        public final a c(@os.m String str) {
            return new a(str);
        }

        @os.m
        public final String e() {
            return this.f7134c;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && l0.g(this.f7134c, ((a) obj).f7134c);
        }

        public int hashCode() {
            String str = this.f7134c;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @os.l
        public String toString() {
            return n.a.a("Casting(deviceName=", this.f7134c, ")");
        }

        public a(@os.m String str) {
            super("1");
            this.f7134c = str;
        }

        public /* synthetic */ a(String str, int i10, w wVar) {
            this((i10 & 1) != 0 ? null : str);
        }
    }

    public static final class b {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @os.l
        public final g a(@os.m String str) {
            if (l0.g(str, hi.b.f7118g)) {
                return c.f7135c;
            }
            if (l0.g(str, "1")) {
                return new a(null, 1, 0 == true ? 1 : 0);
            }
            return str == null ? new d("") : new d(str);
        }

        public b(w wVar) {
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final c f7135c = new c();

        public c() {
            super(hi.b.f7118g);
        }
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final String f7136c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@os.l String str) {
            super(str);
            l0.p(str, "value");
            this.f7136c = str;
        }

        public static /* synthetic */ d d(d dVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = dVar.f7136c;
            }
            return dVar.c(str);
        }

        @os.l
        public final String b() {
            return this.f7136c;
        }

        @os.l
        public final d c(@os.l String str) {
            l0.p(str, "value");
            return new d(str);
        }

        @os.l
        public final String e() {
            return this.f7136c;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && l0.g(this.f7136c, ((d) obj).f7136c);
        }

        public int hashCode() {
            return this.f7136c.hashCode();
        }

        @os.l
        public String toString() {
            return n.a.a("Unknown(value=", this.f7136c, ")");
        }
    }

    public /* synthetic */ g(String str, w wVar) {
        this(str);
    }

    @os.l
    public final String a() {
        return this.f7133a;
    }

    public g(String str) {
        this.f7133a = str;
    }
}
