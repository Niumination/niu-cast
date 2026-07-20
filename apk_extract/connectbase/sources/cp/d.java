package cp;

import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final String f3365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final String f3366b;

        public a(@l String str, @l String str2) {
            l0.p(str, "name");
            l0.p(str2, "desc");
            this.f3365a = str;
            this.f3366b = str2;
        }

        @Override // cp.d
        @l
        public String a() {
            return this.f3365a + n1.e.f11184d + this.f3366b;
        }

        @Override // cp.d
        @l
        public String b() {
            return this.f3366b;
        }

        @Override // cp.d
        @l
        public String c() {
            return this.f3365a;
        }

        @l
        public final String d() {
            return this.f3365a;
        }

        @l
        public final String e() {
            return this.f3366b;
        }

        public boolean equals(@m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return l0.g(this.f3365a, aVar.f3365a) && l0.g(this.f3366b, aVar.f3366b);
        }

        public int hashCode() {
            return this.f3366b.hashCode() + (this.f3365a.hashCode() * 31);
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final String f3367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final String f3368b;

        public b(@l String str, @l String str2) {
            l0.p(str, "name");
            l0.p(str2, "desc");
            this.f3367a = str;
            this.f3368b = str2;
        }

        @Override // cp.d
        @l
        public String a() {
            return l0.C(this.f3367a, this.f3368b);
        }

        @Override // cp.d
        @l
        public String b() {
            return this.f3368b;
        }

        @Override // cp.d
        @l
        public String c() {
            return this.f3367a;
        }

        public boolean equals(@m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return l0.g(this.f3367a, bVar.f3367a) && l0.g(this.f3368b, bVar.f3368b);
        }

        public int hashCode() {
            return this.f3368b.hashCode() + (this.f3367a.hashCode() * 31);
        }
    }

    public d() {
    }

    @l
    public abstract String a();

    @l
    public abstract String b();

    @l
    public abstract String c();

    @l
    public final String toString() {
        return a();
    }

    public d(w wVar) {
    }
}
