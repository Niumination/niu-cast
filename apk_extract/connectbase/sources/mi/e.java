package mi;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10700c = Locale.CHINESE.getLanguage().toLowerCase();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10701d = Locale.JAPANESE.getLanguage().toLowerCase();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10702e = Locale.KOREAN.getLanguage().toLowerCase();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10703f = "Hans";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10704g = "Hant";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f10705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f10706b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Locale f10707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f10709c;

        public a(Locale locale) {
            this.f10707a = locale;
            if (locale == null) {
                this.f10708b = null;
                this.f10709c = false;
            } else {
                String lowerCase = locale.getLanguage().toLowerCase();
                this.f10708b = lowerCase;
                this.f10709c = d(lowerCase);
            }
        }

        public static boolean d(String str) {
            return e.f10700c.equals(str) || e.f10701d.equals(str) || e.f10702e.equals(str);
        }

        public Locale a() {
            return this.f10707a;
        }

        public boolean b() {
            return this.f10707a != null;
        }

        public boolean c(String str) {
            String str2 = this.f10708b;
            if (str2 == null) {
                return str == null;
            }
            return str2.equalsIgnoreCase(str);
        }

        public boolean e(Locale locale) {
            Locale locale2 = this.f10707a;
            if (locale2 == null) {
                return locale == null;
            }
            return locale2.equals(locale);
        }

        public boolean f() {
            return this.f10709c;
        }

        public String toString() {
            String string;
            try {
                string = this.f10707a.toLanguageTag();
            } catch (NoSuchMethodError unused) {
                string = this.f10707a.toString();
            }
            return this.f10707a != null ? string : "(null)";
        }
    }

    public e(Locale locale) {
        this(locale, null);
    }

    public static e d() {
        return new e(Locale.getDefault(), null);
    }

    public static e e(String str) {
        String str2;
        Locale localeForLanguageTag;
        if (str != null) {
            try {
                if (str.indexOf(95) == -1) {
                    String[] strArrSplit = str.split(";");
                    Locale localeForLanguageTag2 = Locale.forLanguageTag(strArrSplit[0]);
                    if (localeForLanguageTag2 != null && !TextUtils.equals(localeForLanguageTag2.toLanguageTag(), "und")) {
                        return (strArrSplit.length <= 1 || (str2 = strArrSplit[1]) == null || (localeForLanguageTag = Locale.forLanguageTag(str2)) == null || TextUtils.equals(localeForLanguageTag.toLanguageTag(), "und")) ? new e(localeForLanguageTag2, null) : new e(localeForLanguageTag2, localeForLanguageTag);
                    }
                }
            } catch (Exception e10) {
                Log.e(b.f10646c, "getLocaleSet error:" + e10);
            }
        }
        return d();
    }

    public static boolean i(Locale locale) {
        if (locale == null || !TextUtils.equals(locale.getLanguage(), f10700c)) {
            return false;
        }
        try {
            return !TextUtils.isEmpty(locale.getScript()) ? locale.getScript().equals("Hans") : locale.equals(Locale.SIMPLIFIED_CHINESE);
        } catch (NoSuchMethodError e10) {
            Log.e(b.f10646c, "isLocaleSimplifiedChinese NoSuchMethodError:" + e10 + "locale.getLanguage():" + locale.getLanguage());
            return locale.getLanguage().equals("zh");
        }
    }

    public static boolean j(Locale locale) {
        if (locale == null || !TextUtils.equals(locale.getLanguage(), f10700c)) {
            return false;
        }
        try {
            return !TextUtils.isEmpty(locale.getScript()) ? locale.getScript().equals("Hant") : locale.equals(Locale.TRADITIONAL_CHINESE);
        } catch (NoSuchMethodError e10) {
            Log.e(b.f10646c, "isLocaleTraditionalChinese NoSuchMethodError:" + e10 + "locale.getLanguage():" + locale.getLanguage());
            return locale.getLanguage().equals("zh");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.l(this.f10705a.a()) && eVar.q(this.f10706b.a())) {
                return true;
            }
        }
        return false;
    }

    public Locale f() {
        return this.f10705a.a();
    }

    public Locale g() {
        return this.f10706b.a();
    }

    public boolean h() {
        return this.f10706b.b();
    }

    public boolean k(String str) {
        return this.f10705a.c(str);
    }

    public boolean l(Locale locale) {
        return this.f10705a.e(locale);
    }

    public boolean m() {
        return this.f10705a.f();
    }

    public boolean n() {
        return i(f());
    }

    public boolean o() {
        return j(f());
    }

    public boolean p(String str) {
        return this.f10706b.c(str);
    }

    public boolean q(Locale locale) {
        return this.f10706b.e(locale);
    }

    public boolean r() {
        return this.f10706b.f();
    }

    public boolean s() {
        return i(g());
    }

    public boolean t() {
        return j(g());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10705a.toString());
        if (h()) {
            sb2.append(";");
            sb2.append(this.f10706b.toString());
        }
        return sb2.toString();
    }

    public e u() {
        Locale localeF = f();
        if (localeF == null) {
            return d();
        }
        Locale localeG = g();
        if (localeG == null || k(localeG.getLanguage()) || (m() && r())) {
            return new e(localeF, null);
        }
        return p(Locale.ENGLISH.getLanguage()) ? new e(localeF, null) : this;
    }

    public e(Locale locale, Locale locale2) {
        a aVar = new a(locale);
        this.f10705a = aVar;
        this.f10706b = new a(aVar.equals(locale2) ? null : locale2);
    }
}
