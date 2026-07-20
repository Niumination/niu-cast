package mi;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class b implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10646c = "ContactLocaleUtils";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Locale f10647d = new Locale("ar");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Locale f10648e = new Locale("el");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Locale f10649f = new Locale("he");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Locale f10650g = new Locale("sr");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Locale f10651h = new Locale("uk");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Locale f10652i = new Locale("th");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10653j = Locale.JAPANESE.getLanguage().toLowerCase();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static b f10654k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f10655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f10656b;

    public static class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f10657g = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f10658h = "";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f10659i = "#";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f10663d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Method f10664e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Method f10665f;

        public a(e eVar) {
            Locale localeG = eVar.g();
            this.f10662c = eVar.s();
            Log.e(b.f10646c, "ContactLocaleUtilsBase : " + eVar + ", mEnableSecondaryLocalePinyin :" + this.f10662c);
            try {
                Class<?> cls = Class.forName("libcore.icu.AlphabeticIndex");
                this.f10664e = cls.getDeclaredMethod("getBucketIndex", String.class);
                Class cls2 = Integer.TYPE;
                this.f10665f = cls.getDeclaredMethod("getBucketLabel", cls2);
                Method declaredMethod = cls.getDeclaredMethod("addLabels", Locale.class);
                Method declaredMethod2 = cls.getDeclaredMethod("setMaxLabelCount", cls2);
                Object objNewInstance = cls.getConstructor(Locale.class).newInstance(eVar.f());
                this.f10663d = objNewInstance;
                declaredMethod2.invoke(objNewInstance, 300);
                if (localeG != null) {
                    declaredMethod.invoke(this.f10663d, localeG);
                }
                declaredMethod.invoke(this.f10663d, Locale.ENGLISH);
                declaredMethod.invoke(this.f10663d, Locale.JAPANESE);
                declaredMethod.invoke(this.f10663d, Locale.KOREAN);
                declaredMethod.invoke(this.f10663d, b.f10652i);
                declaredMethod.invoke(this.f10663d, b.f10647d);
                declaredMethod.invoke(this.f10663d, b.f10649f);
                declaredMethod.invoke(this.f10663d, b.f10648e);
                declaredMethod.invoke(this.f10663d, b.f10651h);
                declaredMethod.invoke(this.f10663d, b.f10650g);
                int iIntValue = ((Integer) cls.getDeclaredMethod("getBucketCount", null).invoke(this.f10663d, null)).intValue();
                this.f10660a = iIntValue;
                this.f10661b = iIntValue - 1;
            } catch (Exception e10) {
                this.f10660a = 27;
                this.f10661b = 27 - 1;
                Log.e(b.f10646c, "init error : " + e10);
            }
        }

        public int a() {
            return this.f10660a + 1;
        }

        public int b(String str) {
            int iIntValue;
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
                    return this.f10661b;
                }
            }
            if (this.f10662c) {
                str = c.d().k(str);
            }
            Method method = this.f10664e;
            if (method != null) {
                try {
                    iIntValue = ((Integer) method.invoke(this.f10663d, str)).intValue();
                } catch (Exception e10) {
                    Log.e(b.f10646c, "getBucketIndex error : " + e10);
                    iIntValue = -1;
                }
            } else {
                if (str.isEmpty() || (iIntValue = f10657g.indexOf(str.substring(0, 1).toUpperCase())) == -1) {
                    iIntValue = this.f10661b;
                }
                if (iIntValue != -1) {
                    return iIntValue;
                }
            }
            if (iIntValue < 0) {
                return -1;
            }
            if (iIntValue == 0) {
                return this.f10661b;
            }
            return iIntValue >= this.f10661b ? iIntValue + 1 : iIntValue;
        }

        public String c(int i10) {
            if (i10 < 0 || i10 >= a()) {
                return "";
            }
            int i11 = this.f10661b;
            if (i10 == i11) {
                return "#";
            }
            if (i10 > i11) {
                i10--;
            }
            Method method = this.f10665f;
            if (method != null) {
                try {
                    return (String) method.invoke(this.f10663d, Integer.valueOf(i10));
                } catch (Exception e10) {
                    Log.e(b.f10646c, "getBucketLabel error : " + e10);
                }
            }
            return f10657g.substring(i10, i10 + 1);
        }

        public ArrayList<String> d() {
            int iA = a();
            ArrayList<String> arrayList = new ArrayList<>(iA);
            for (int i10 = 0; i10 < iA; i10++) {
                arrayList.add(c(i10));
            }
            return arrayList;
        }

        public int e() {
            return this.f10661b;
        }

        public String f(String str) {
            return str;
        }
    }

    /* JADX INFO: renamed from: mi.b$b, reason: collision with other inner class name */
    public static class C0279b extends a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f10666k = "他";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Set<Character.UnicodeBlock> f10667l;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f10668j;

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
            f10667l = Collections.unmodifiableSet(hashSet);
        }

        public C0279b(e eVar) {
            super(eVar);
            this.f10668j = super.b("日");
        }

        public static boolean g(int i10) {
            return f10667l.contains(Character.UnicodeBlock.of(i10));
        }

        @Override // mi.b.a
        public int a() {
            return this.f10660a + 2;
        }

        @Override // mi.b.a
        public int b(String str) {
            int iB = super.b(str);
            return ((iB != this.f10668j || g(Character.codePointAt(str, 0))) && iB <= this.f10668j) ? iB : iB + 1;
        }

        @Override // mi.b.a
        public String c(int i10) {
            int i11 = this.f10668j;
            if (i10 == i11) {
                return "他";
            }
            if (i10 > i11) {
                i10--;
            }
            return super.c(i10);
        }
    }

    public b(e eVar) {
        if (eVar == null) {
            this.f10655a = e.d();
        } else {
            this.f10655a = eVar;
        }
        if (this.f10655a.k(f10653j)) {
            this.f10656b = new C0279b(this.f10655a);
        } else {
            this.f10656b = new a(this.f10655a);
        }
        Log.i(f10646c, "AddressBook Labels [" + this.f10655a.toString() + "]: " + b().toString());
    }

    public static synchronized b h() {
        try {
            if (f10654k == null) {
                f10654k = new b(e.d());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f10654k;
    }

    public static synchronized void j(Locale locale) {
        k(new e(locale, null));
    }

    public static synchronized void k(e eVar) {
        try {
            b bVar = f10654k;
            if (bVar == null || !bVar.i(eVar)) {
                f10654k = new b(eVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // mi.d
    public int a() {
        return this.f10656b.e();
    }

    @Override // mi.d
    public ArrayList<String> b() {
        return this.f10656b.d();
    }

    @Override // mi.d
    public int c() {
        return this.f10656b.a();
    }

    @Override // mi.d
    public int d(String str) {
        return this.f10656b.b(str);
    }

    @Override // mi.d
    public String e(int i10) {
        return this.f10656b.c(i10);
    }

    @Override // mi.d
    public String f(String str, int i10) {
        return this.f10656b.f(str);
    }

    @Override // mi.d
    public String g(String str) {
        return e(d(str));
    }

    public boolean i(e eVar) {
        return this.f10655a.equals(eVar);
    }
}
