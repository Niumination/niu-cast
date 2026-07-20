package ik;

import io.netty.handler.codec.http.HttpHeaders;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final EnumC0216d f7946a;

    public static final class b extends d {
        public b(@os.m EnumC0216d enumC0216d) {
            super(enumC0216d);
        }

        public boolean equals(@os.m Object obj) {
            return (obj instanceof b) && this.f7946a == ((b) obj).f7946a;
        }

        public int hashCode() {
            EnumC0216d enumC0216d = this.f7946a;
            if (enumC0216d == null) {
                return 0;
            }
            return enumC0216d.hashCode();
        }

        @os.l
        public String toString() {
            EnumC0216d enumC0216d = this.f7946a;
            return enumC0216d == null ? "no-cache" : kn.l0.C("no-cache, ", enumC0216d.getHeaderValue$ktor_http());
        }
    }

    public static final class c extends d {
        public c(@os.m EnumC0216d enumC0216d) {
            super(enumC0216d);
        }

        public boolean equals(@os.m Object obj) {
            return (obj instanceof c) && ((c) obj).f7946a == this.f7946a;
        }

        public int hashCode() {
            EnumC0216d enumC0216d = this.f7946a;
            if (enumC0216d == null) {
                return 0;
            }
            return enumC0216d.hashCode();
        }

        @os.l
        public String toString() {
            EnumC0216d enumC0216d = this.f7946a;
            return enumC0216d == null ? HttpHeaders.Values.NO_STORE : kn.l0.C("no-store, ", enumC0216d.getHeaderValue$ktor_http());
        }
    }

    /* JADX INFO: renamed from: ik.d$d, reason: collision with other inner class name */
    public enum EnumC0216d {
        Public("public"),
        Private("private");


        @os.l
        private final String headerValue;

        EnumC0216d(String str) {
            this.headerValue = str;
        }

        @os.l
        public final String getHeaderValue$ktor_http() {
            return this.headerValue;
        }
    }

    public /* synthetic */ d(EnumC0216d enumC0216d, kn.w wVar) {
        this(enumC0216d);
    }

    @os.m
    public final EnumC0216d a() {
        return this.f7946a;
    }

    public d(EnumC0216d enumC0216d) {
        this.f7946a = enumC0216d;
    }

    public static final class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public final Integer f7948c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f7949d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f7950e;

        public a(int i10, @os.m Integer num, boolean z10, boolean z11, @os.m EnumC0216d enumC0216d) {
            super(enumC0216d);
            this.f7947b = i10;
            this.f7948c = num;
            this.f7949d = z10;
            this.f7950e = z11;
        }

        public final int b() {
            return this.f7947b;
        }

        public final boolean c() {
            return this.f7949d;
        }

        @os.m
        public final Integer d() {
            return this.f7948c;
        }

        public final boolean e() {
            return this.f7950e;
        }

        public boolean equals(@os.m Object obj) {
            if (obj != this) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.f7947b != this.f7947b || !kn.l0.g(aVar.f7948c, this.f7948c) || aVar.f7949d != this.f7949d || aVar.f7950e != this.f7950e || aVar.f7946a != this.f7946a) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10 = this.f7947b * 31;
            Integer num = this.f7948c;
            int iHashCode = (Boolean.hashCode(this.f7950e) + ((Boolean.hashCode(this.f7949d) + ((i10 + (num == null ? 0 : num.intValue())) * 31)) * 31)) * 31;
            EnumC0216d enumC0216d = this.f7946a;
            return iHashCode + (enumC0216d != null ? enumC0216d.hashCode() : 0);
        }

        @os.l
        public String toString() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(kn.l0.C("max-age=", Integer.valueOf(this.f7947b)));
            Integer num = this.f7948c;
            if (num != null) {
                arrayList.add(kn.l0.C("s-maxage=", num));
            }
            if (this.f7949d) {
                arrayList.add("must-revalidate");
            }
            if (this.f7950e) {
                arrayList.add("proxy-revalidate");
            }
            EnumC0216d enumC0216d = this.f7946a;
            if (enumC0216d != null) {
                arrayList.add(enumC0216d.getHeaderValue$ktor_http());
            }
            return nm.h0.m3(arrayList, ", ", null, null, 0, null, null, 62, null);
        }

        public /* synthetic */ a(int i10, Integer num, boolean z10, boolean z11, EnumC0216d enumC0216d, int i11, kn.w wVar) {
            this(i10, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? null : enumC0216d);
        }
    }
}
