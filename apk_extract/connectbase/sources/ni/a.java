package ni;

import android.icu.text.AlphabeticIndex;
import android.os.LocaleList;
import android.util.ArraySet;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import mi.d;

/* JADX INFO: loaded from: classes2.dex */
public class a implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11451c = "ContactLocale";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Locale f11452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Locale f11453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Locale f11454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Locale f11455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Locale f11456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Locale f11457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Locale[] f11458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static a f11459k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0293a f11461b;

    /* JADX INFO: renamed from: ni.a$a, reason: collision with other inner class name */
    public static class C0293a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f11462e = "";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f11463f = "#";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlphabeticIndex.ImmutableIndex f11464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f11467d;

        public C0293a(c cVar) {
            this.f11467d = cVar.o();
            ArraySet arraySet = new ArraySet();
            AlphabeticIndex maxLabelCount = new AlphabeticIndex(cVar.c()).setMaxLabelCount(300);
            arraySet.add(cVar.c());
            LocaleList localeListA = cVar.a();
            for (int i10 = 0; i10 < localeListA.size(); i10++) {
                a(maxLabelCount, localeListA.get(i10), arraySet);
            }
            for (int i11 = 0; i11 < a.f11458j.length; i11++) {
                a(maxLabelCount, a.f11458j[i11], arraySet);
            }
            AlphabeticIndex.ImmutableIndex immutableIndexBuildImmutableIndex = maxLabelCount.buildImmutableIndex();
            this.f11464a = immutableIndexBuildImmutableIndex;
            int bucketCount = immutableIndexBuildImmutableIndex.getBucketCount();
            this.f11465b = bucketCount;
            this.f11466c = bucketCount - 1;
        }

        public static void a(AlphabeticIndex alphabeticIndex, Locale locale, ArraySet<Locale> arraySet) {
            if (arraySet.contains(locale)) {
                return;
            }
            alphabeticIndex.addLabels(locale);
            arraySet.add(locale);
        }

        public int b() {
            return this.f11465b + 1;
        }

        public int c(String str) {
            int length = str.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = Character.codePointAt(str, iCharCount);
                if (!Character.isDigit(iCodePointAt)) {
                    if (!Character.isSpaceChar(iCodePointAt) && iCodePointAt != 43 && iCodePointAt != 40 && iCodePointAt != 41 && iCodePointAt != 46 && iCodePointAt != 45 && iCodePointAt != 35) {
                        break;
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    return this.f11466c;
                }
            }
            if (this.f11467d) {
                str = ni.b.d().k(str);
            }
            int bucketIndex = this.f11464a.getBucketIndex(str);
            if (bucketIndex < 0) {
                return -1;
            }
            return bucketIndex >= this.f11466c ? bucketIndex + 1 : bucketIndex;
        }

        public String d(int i10) {
            if (i10 < 0 || i10 >= b()) {
                return "";
            }
            int i11 = this.f11466c;
            if (i10 == i11) {
                return "#";
            }
            if (i10 > i11) {
                i10--;
            }
            return this.f11464a.getBucket(i10).getLabel();
        }

        public ArrayList<String> e() {
            int iB = b();
            ArrayList<String> arrayList = new ArrayList<>(iB);
            for (int i10 = 0; i10 < iB; i10++) {
                arrayList.add(d(i10));
            }
            return arrayList;
        }

        public int f() {
            return this.f11466c;
        }

        public String g(String str) {
            return str;
        }
    }

    public static class b extends C0293a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f11468h = "他";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Set<Character.UnicodeBlock> f11469i;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f11470g;

        static {
            HashSet hashSet = new HashSet();
            hashSet.add(Character.UnicodeBlock.HIRAGANA);
            hashSet.add(Character.UnicodeBlock.KATAKANA);
            hashSet.add(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
            hashSet.add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
            hashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
            hashSet.add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
            hashSet.add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
            hashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
            f11469i = Collections.unmodifiableSet(hashSet);
        }

        public b(c cVar) {
            super(cVar);
            this.f11470g = super.c("日");
        }

        public static boolean h(int i10) {
            return f11469i.contains(Character.UnicodeBlock.of(i10));
        }

        @Override // ni.a.C0293a
        public int b() {
            return this.f11465b + 2;
        }

        @Override // ni.a.C0293a
        public int c(String str) {
            int iC = super.c(str);
            return ((iC != this.f11470g || h(Character.codePointAt(str, 0))) && iC <= this.f11470g) ? iC : iC + 1;
        }

        @Override // ni.a.C0293a
        public String d(int i10) {
            int i11 = this.f11470g;
            if (i10 == i11) {
                return "他";
            }
            if (i10 > i11) {
                i10--;
            }
            return super.d(i10);
        }
    }

    static {
        Locale locale = new Locale("ar");
        f11452d = locale;
        Locale locale2 = new Locale("el");
        f11453e = locale2;
        Locale locale3 = new Locale("he");
        f11454f = locale3;
        Locale locale4 = new Locale("sr");
        f11455g = locale4;
        Locale locale5 = new Locale("uk");
        f11456h = locale5;
        Locale locale6 = new Locale("th");
        f11457i = locale6;
        f11458j = new Locale[]{Locale.ENGLISH, Locale.JAPANESE, Locale.KOREAN, locale6, locale, locale3, locale2, locale5, locale4};
    }

    public a(c cVar) {
        if (cVar == null) {
            this.f11460a = c.l();
        } else {
            this.f11460a = cVar;
        }
        if (this.f11460a.n()) {
            this.f11461b = new b(this.f11460a);
        } else {
            this.f11461b = new C0293a(this.f11460a);
        }
        Log.i(f11451c, "AddressBook Labels [" + this.f11460a.f11505b.toString() + "]: " + b().toString());
    }

    public static synchronized a i() {
        try {
            if (f11459k == null) {
                f11459k = new a(c.l());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f11459k;
    }

    public static synchronized void k(Locale... localeArr) {
        l(c.m(localeArr));
    }

    public static synchronized void l(c cVar) {
        try {
            a aVar = f11459k;
            if (aVar == null || !aVar.j(cVar)) {
                f11459k = new a(cVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // mi.d
    public int a() {
        return this.f11461b.f();
    }

    @Override // mi.d
    public ArrayList<String> b() {
        return this.f11461b.e();
    }

    @Override // mi.d
    public int c() {
        return this.f11461b.b();
    }

    @Override // mi.d
    public int d(String str) {
        return this.f11461b.c(str);
    }

    @Override // mi.d
    public String e(int i10) {
        return this.f11461b.d(i10);
    }

    @Override // mi.d
    public String f(String str, int i10) {
        return this.f11461b.g(str);
    }

    @Override // mi.d
    public String g(String str) {
        return e(d(str));
    }

    public boolean j(c cVar) {
        return this.f11460a.equals(cVar);
    }
}
