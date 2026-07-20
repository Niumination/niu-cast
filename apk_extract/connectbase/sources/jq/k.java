package jq;

import io.netty.util.internal.StringUtil;
import lm.f1;
import lm.l2;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.9")
@lm.r
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final c f8828d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final k f8829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final k f8830f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final b f8832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final d f8833c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public b.a f8835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public d.a f8836c;

        @z0
        public a() {
            k.f8828d.getClass();
            this.f8834a = k.f8829e.f8831a;
        }

        @z0
        @os.l
        public final k a() {
            b bVarA;
            d dVarA;
            boolean z10 = this.f8834a;
            b.a aVar = this.f8835b;
            if (aVar == null || (bVarA = aVar.a()) == null) {
                b.f8837g.getClass();
                bVarA = b.f8838h;
            }
            d.a aVar2 = this.f8836c;
            if (aVar2 == null || (dVarA = aVar2.a()) == null) {
                d.f8851d.getClass();
                dVarA = d.f8852e;
            }
            return new k(z10, bVarA, dVarA);
        }

        @an.f
        public final void b(jn.l<? super b.a, l2> lVar) {
            kn.l0.p(lVar, "builderAction");
            lVar.invoke(c());
        }

        @os.l
        public final b.a c() {
            if (this.f8835b == null) {
                this.f8835b = new b.a();
            }
            b.a aVar = this.f8835b;
            kn.l0.m(aVar);
            return aVar;
        }

        @os.l
        public final d.a d() {
            if (this.f8836c == null) {
                this.f8836c = new d.a();
            }
            d.a aVar = this.f8836c;
            kn.l0.m(aVar);
            return aVar;
        }

        public final boolean e() {
            return this.f8834a;
        }

        @an.f
        public final void f(jn.l<? super d.a, l2> lVar) {
            kn.l0.p(lVar, "builderAction");
            lVar.invoke(d());
        }

        public final void g(boolean z10) {
            this.f8834a = z10;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final C0231b f8837g = new C0231b();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public static final b f8838h = new b(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final String f8841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final String f8842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final String f8843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final String f8844f;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8845a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8846b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @os.l
            public String f8847c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @os.l
            public String f8848d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @os.l
            public String f8849e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @os.l
            public String f8850f;

            public a() {
                C0231b c0231b = b.f8837g;
                c0231b.getClass();
                this.f8845a = b.f8838h.f8839a;
                c0231b.getClass();
                this.f8846b = b.f8838h.f8840b;
                c0231b.getClass();
                this.f8847c = b.f8838h.f8841c;
                c0231b.getClass();
                this.f8848d = b.f8838h.f8842d;
                c0231b.getClass();
                this.f8849e = b.f8838h.f8843e;
                c0231b.getClass();
                this.f8850f = b.f8838h.f8844f;
            }

            @os.l
            public final b a() {
                return new b(this.f8845a, this.f8846b, this.f8847c, this.f8848d, this.f8849e, this.f8850f);
            }

            @os.l
            public final String b() {
                return this.f8849e;
            }

            @os.l
            public final String c() {
                return this.f8848d;
            }

            @os.l
            public final String d() {
                return this.f8850f;
            }

            public final int e() {
                return this.f8846b;
            }

            public final int f() {
                return this.f8845a;
            }

            @os.l
            public final String g() {
                return this.f8847c;
            }

            public final void h(@os.l String str) {
                kn.l0.p(str, "value");
                if (h0.S2(str, '\n', false, 2, null) || h0.S2(str, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    throw new IllegalArgumentException(m.a.a("LF and CR characters are prohibited in bytePrefix, but was ", str));
                }
                this.f8849e = str;
            }

            public final void i(@os.l String str) {
                kn.l0.p(str, "value");
                if (h0.S2(str, '\n', false, 2, null) || h0.S2(str, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    throw new IllegalArgumentException(m.a.a("LF and CR characters are prohibited in byteSeparator, but was ", str));
                }
                this.f8848d = str;
            }

            public final void j(@os.l String str) {
                kn.l0.p(str, "value");
                if (h0.S2(str, '\n', false, 2, null) || h0.S2(str, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    throw new IllegalArgumentException(m.a.a("LF and CR characters are prohibited in byteSuffix, but was ", str));
                }
                this.f8850f = str;
            }

            public final void k(int i10) {
                if (i10 <= 0) {
                    throw new IllegalArgumentException(h.a.a("Non-positive values are prohibited for bytesPerGroup, but was ", i10));
                }
                this.f8846b = i10;
            }

            public final void l(int i10) {
                if (i10 <= 0) {
                    throw new IllegalArgumentException(h.a.a("Non-positive values are prohibited for bytesPerLine, but was ", i10));
                }
                this.f8845a = i10;
            }

            public final void m(@os.l String str) {
                kn.l0.p(str, "<set-?>");
                this.f8847c = str;
            }
        }

        /* JADX INFO: renamed from: jq.k$b$b, reason: collision with other inner class name */
        public static final class C0231b {
            public C0231b() {
            }

            @os.l
            public final b a() {
                return b.f8838h;
            }

            public C0231b(kn.w wVar) {
            }
        }

        public b(int i10, int i11, @os.l String str, @os.l String str2, @os.l String str3, @os.l String str4) {
            kn.l0.p(str, "groupSeparator");
            kn.l0.p(str2, "byteSeparator");
            kn.l0.p(str3, "bytePrefix");
            kn.l0.p(str4, "byteSuffix");
            this.f8839a = i10;
            this.f8840b = i11;
            this.f8841c = str;
            this.f8842d = str2;
            this.f8843e = str3;
            this.f8844f = str4;
        }

        @os.l
        public final StringBuilder b(@os.l StringBuilder sb2, @os.l String str) {
            kn.l0.p(sb2, "sb");
            kn.l0.p(str, "indent");
            sb2.append(str);
            sb2.append("bytesPerLine = ");
            sb2.append(this.f8839a);
            kn.l0.o(sb2, "append(...)");
            sb2.append(ks.g.f9491d);
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            sb2.append(str);
            sb2.append("bytesPerGroup = ");
            sb2.append(this.f8840b);
            kn.l0.o(sb2, "append(...)");
            sb2.append(ks.g.f9491d);
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            sb2.append(str);
            sb2.append("groupSeparator = \"");
            sb2.append(this.f8841c);
            kn.l0.o(sb2, "append(...)");
            sb2.append("\",");
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            sb2.append(str);
            sb2.append("byteSeparator = \"");
            sb2.append(this.f8842d);
            kn.l0.o(sb2, "append(...)");
            sb2.append("\",");
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            sb2.append(str);
            sb2.append("bytePrefix = \"");
            sb2.append(this.f8843e);
            kn.l0.o(sb2, "append(...)");
            sb2.append("\",");
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            sb2.append(str);
            sb2.append("byteSuffix = \"");
            sb2.append(this.f8844f);
            sb2.append("\"");
            return sb2;
        }

        @os.l
        public final String c() {
            return this.f8843e;
        }

        @os.l
        public final String d() {
            return this.f8842d;
        }

        @os.l
        public final String e() {
            return this.f8844f;
        }

        public final int f() {
            return this.f8840b;
        }

        public final int g() {
            return this.f8839a;
        }

        @os.l
        public final String h() {
            return this.f8841c;
        }

        @os.l
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BytesHexFormat(");
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            StringBuilder sbB = b(sb2, "    ");
            sbB.append('\n');
            kn.l0.o(sbB, "append(...)");
            sb2.append(")");
            String string = sb2.toString();
            kn.l0.o(string, "toString(...)");
            return string;
        }
    }

    public static final class c {
        public c() {
        }

        @os.l
        public final k a() {
            return k.f8829e;
        }

        @os.l
        public final k b() {
            return k.f8830f;
        }

        public c(kn.w wVar) {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final b f8851d = new b();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final d f8852e = new d("", "", false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final String f8853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final String f8854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8855c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public String f8856a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @os.l
            public String f8857b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f8858c;

            public a() {
                b bVar = d.f8851d;
                bVar.getClass();
                this.f8856a = d.f8852e.f8853a;
                bVar.getClass();
                this.f8857b = d.f8852e.f8854b;
                bVar.getClass();
                this.f8858c = d.f8852e.f8855c;
            }

            @os.l
            public final d a() {
                return new d(this.f8856a, this.f8857b, this.f8858c);
            }

            @os.l
            public final String b() {
                return this.f8856a;
            }

            public final boolean c() {
                return this.f8858c;
            }

            @os.l
            public final String d() {
                return this.f8857b;
            }

            public final void e(@os.l String str) {
                kn.l0.p(str, "value");
                if (h0.S2(str, '\n', false, 2, null) || h0.S2(str, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    throw new IllegalArgumentException(m.a.a("LF and CR characters are prohibited in prefix, but was ", str));
                }
                this.f8856a = str;
            }

            public final void f(boolean z10) {
                this.f8858c = z10;
            }

            public final void g(@os.l String str) {
                kn.l0.p(str, "value");
                if (h0.S2(str, '\n', false, 2, null) || h0.S2(str, StringUtil.CARRIAGE_RETURN, false, 2, null)) {
                    throw new IllegalArgumentException(m.a.a("LF and CR characters are prohibited in suffix, but was ", str));
                }
                this.f8857b = str;
            }
        }

        public static final class b {
            public b() {
            }

            @os.l
            public final d a() {
                return d.f8852e;
            }

            public b(kn.w wVar) {
            }
        }

        public d(@os.l String str, @os.l String str2, boolean z10) {
            kn.l0.p(str, "prefix");
            kn.l0.p(str2, "suffix");
            this.f8853a = str;
            this.f8854b = str2;
            this.f8855c = z10;
        }

        @os.l
        public final StringBuilder b(@os.l StringBuilder sb2, @os.l String str) {
            kn.l0.p(sb2, "sb");
            kn.l0.p(str, "indent");
            sb2.append(str);
            sb2.append("prefix = \"");
            sb2.append(this.f8853a);
            kn.l0.o(sb2, "append(...)");
            sb2.append("\",");
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            sb2.append(str);
            sb2.append("suffix = \"");
            sb2.append(this.f8854b);
            kn.l0.o(sb2, "append(...)");
            sb2.append("\",");
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            sb2.append(str);
            sb2.append("removeLeadingZeros = ");
            sb2.append(this.f8855c);
            return sb2;
        }

        @os.l
        public final String c() {
            return this.f8853a;
        }

        public final boolean d() {
            return this.f8855c;
        }

        @os.l
        public final String e() {
            return this.f8854b;
        }

        @os.l
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NumberHexFormat(");
            kn.l0.o(sb2, "append(...)");
            sb2.append('\n');
            kn.l0.o(sb2, "append(...)");
            StringBuilder sbB = b(sb2, "    ");
            sbB.append('\n');
            kn.l0.o(sbB, "append(...)");
            sb2.append(")");
            String string = sb2.toString();
            kn.l0.o(string, "toString(...)");
            return string;
        }
    }

    static {
        b.C0231b c0231b = b.f8837g;
        c0231b.getClass();
        b bVar = b.f8838h;
        d.b bVar2 = d.f8851d;
        bVar2.getClass();
        f8829e = new k(false, bVar, d.f8852e);
        c0231b.getClass();
        b bVar3 = b.f8838h;
        bVar2.getClass();
        f8830f = new k(true, bVar3, d.f8852e);
    }

    public k(boolean z10, @os.l b bVar, @os.l d dVar) {
        kn.l0.p(bVar, "bytes");
        kn.l0.p(dVar, "number");
        this.f8831a = z10;
        this.f8832b = bVar;
        this.f8833c = dVar;
    }

    @os.l
    public final b c() {
        return this.f8832b;
    }

    @os.l
    public final d d() {
        return this.f8833c;
    }

    public final boolean e() {
        return this.f8831a;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HexFormat(");
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        sb2.append("    upperCase = ");
        sb2.append(this.f8831a);
        kn.l0.o(sb2, "append(...)");
        sb2.append(ks.g.f9491d);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        sb2.append("    bytes = BytesHexFormat(");
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        StringBuilder sbB = this.f8832b.b(sb2, "        ");
        sbB.append('\n');
        kn.l0.o(sbB, "append(...)");
        sb2.append("    ),");
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        sb2.append("    number = NumberHexFormat(");
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        StringBuilder sbB2 = this.f8833c.b(sb2, "        ");
        sbB2.append('\n');
        kn.l0.o(sbB2, "append(...)");
        sb2.append("    )");
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        sb2.append(")");
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }
}
