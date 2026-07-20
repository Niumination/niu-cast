package g1;

import java.util.HashMap;
import java.util.Map;
import kn.r;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6366a = new a();

    public class a extends d {
        @Override // g1.d, g1.h
        public String b(String string) {
            string.getClass();
            return string;
        }

        @Override // g1.d
        @gm.a
        public char[] c(char c10) {
            return null;
        }
    }

    public class b extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f6367c;

        public b(final d val$escaper) {
            this.f6367c = val$escaper;
        }

        @Override // g1.l
        @gm.a
        public char[] d(int cp2) {
            if (cp2 < 65536) {
                return this.f6367c.c((char) cp2);
            }
            char[] cArr = new char[2];
            Character.toChars(cp2, cArr, 0);
            char[] cArrC = this.f6367c.c(cArr[0]);
            char[] cArrC2 = this.f6367c.c(cArr[1]);
            if (cArrC == null && cArrC2 == null) {
                return null;
            }
            int length = cArrC != null ? cArrC.length : 1;
            char[] cArr2 = new char[(cArrC2 != null ? cArrC2.length : 1) + length];
            if (cArrC != null) {
                for (int i10 = 0; i10 < cArrC.length; i10++) {
                    cArr2[i10] = cArrC[i10];
                }
            } else {
                cArr2[0] = cArr[0];
            }
            if (cArrC2 != null) {
                for (int i11 = 0; i11 < cArrC2.length; i11++) {
                    cArr2[length + i11] = cArrC2[i11];
                }
            } else {
                cArr2[length] = cArr[1];
            }
            return cArr2;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Character, String> f6368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public char f6369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public char f6370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public String f6371d;

        public class a extends g1.a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @gm.a
            public final char[] f6372g;

            public a(Map replacementMap, char safeMin, char safeMax) {
                super((Map<Character, String>) replacementMap, safeMin, safeMax);
                String str = c.this.f6371d;
                this.f6372g = str != null ? str.toCharArray() : null;
            }

            @Override // g1.a
            @gm.a
            public char[] f(char c10) {
                return this.f6372g;
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @t1.a
        public c b(char c10, String replacement) {
            replacement.getClass();
            this.f6368a.put(Character.valueOf(c10), replacement);
            return this;
        }

        public h c() {
            return new a(this.f6368a, this.f6369b, this.f6370c);
        }

        @t1.a
        public c d(char safeMin, char safeMax) {
            this.f6369b = safeMin;
            this.f6370c = safeMax;
            return this;
        }

        @t1.a
        public c e(String unsafeReplacement) {
            this.f6371d = unsafeReplacement;
            return this;
        }

        public c() {
            this.f6368a = new HashMap();
            this.f6369b = (char) 0;
            this.f6370c = r.f9345c;
            this.f6371d = null;
        }
    }

    public static l a(h escaper) {
        escaper.getClass();
        if (escaper instanceof l) {
            return (l) escaper;
        }
        if (escaper instanceof d) {
            return new b((d) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: ".concat(escaper.getClass().getName()));
    }

    public static c b() {
        return new c();
    }

    @gm.a
    public static String c(d escaper, char c10) {
        return f(escaper.c(c10));
    }

    @gm.a
    public static String d(l escaper, int cp2) {
        return f(escaper.d(cp2));
    }

    public static h e() {
        return f6366a;
    }

    @gm.a
    public static String f(@gm.a char[] in2) {
        if (in2 == null) {
            return null;
        }
        return new String(in2);
    }

    public static l g(d escaper) {
        return new b(escaper);
    }
}
