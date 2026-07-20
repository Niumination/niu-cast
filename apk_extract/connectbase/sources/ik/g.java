package ik;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f7975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7976b;

        public a(long j10, long j11) {
            this.f7975a = j10;
            this.f7976b = j11;
        }

        public static a d(a aVar, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = aVar.f7975a;
            }
            if ((i10 & 2) != 0) {
                j11 = aVar.f7976b;
            }
            aVar.getClass();
            return new a(j10, j11);
        }

        public final long a() {
            return this.f7975a;
        }

        public final long b() {
            return this.f7976b;
        }

        @os.l
        public final a c(long j10, long j11) {
            return new a(j10, j11);
        }

        public final long e() {
            return this.f7975a;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7975a == aVar.f7975a && this.f7976b == aVar.f7976b;
        }

        public final long f() {
            return this.f7976b;
        }

        public int hashCode() {
            return Long.hashCode(this.f7976b) + (Long.hashCode(this.f7975a) * 31);
        }

        @os.l
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f7975a);
            sb2.append('-');
            sb2.append(this.f7976b);
            return sb2.toString();
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f7977a;

        public b(long j10) {
            this.f7977a = j10;
        }

        public static b c(b bVar, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = bVar.f7977a;
            }
            bVar.getClass();
            return new b(j10);
        }

        public final long a() {
            return this.f7977a;
        }

        @os.l
        public final b b(long j10) {
            return new b(j10);
        }

        public final long d() {
            return this.f7977a;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f7977a == ((b) obj).f7977a;
        }

        public int hashCode() {
            return Long.hashCode(this.f7977a);
        }

        @os.l
        public String toString() {
            return kn.l0.C("-", Long.valueOf(this.f7977a));
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f7978a;

        public c(long j10) {
            this.f7978a = j10;
        }

        public static c c(c cVar, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = cVar.f7978a;
            }
            cVar.getClass();
            return new c(j10);
        }

        public final long a() {
            return this.f7978a;
        }

        @os.l
        public final c b(long j10) {
            return new c(j10);
        }

        public final long d() {
            return this.f7978a;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.f7978a == ((c) obj).f7978a;
        }

        public int hashCode() {
            return Long.hashCode(this.f7978a);
        }

        @os.l
        public String toString() {
            return n2.k0.a(new StringBuilder(), this.f7978a, '-');
        }
    }

    public g() {
    }

    public g(kn.w wVar) {
    }
}
