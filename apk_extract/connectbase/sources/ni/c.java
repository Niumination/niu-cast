package ni;

import android.icu.util.ULocale;
import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11502c = "Hans";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11503d = "Hant";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale f11504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocaleList f11505b;

    public c(LocaleList localeList, Locale locale) {
        this.f11505b = localeList;
        this.f11504a = locale;
    }

    public static String b(Locale locale) {
        String script = locale.getScript();
        return !script.isEmpty() ? script : ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
    }

    public static String d(Locale locale) {
        if (e(locale)) {
            return b(locale);
        }
        return null;
    }

    public static boolean e(Locale locale) {
        return locale != null && "zh".equals(locale.getLanguage());
    }

    public static boolean f(Locale locale) {
        return locale != null && "ja".equals(locale.getLanguage());
    }

    public static boolean g(Locale locale) {
        return locale != null && "ko".equals(locale.getLanguage());
    }

    public static boolean h(Locale locale) {
        return e(locale) || f(locale) || g(locale);
    }

    public static boolean i(Locale locale) {
        return "Hans".equals(d(locale));
    }

    public static boolean j(Locale locale) {
        return "Hant".equals(d(locale));
    }

    public static c l() {
        return new c(LocaleList.getDefault(), null);
    }

    public static c m(Locale... localeArr) {
        return new c(new LocaleList(localeArr), localeArr[0]);
    }

    public LocaleList a() {
        return this.f11505b;
    }

    public Locale c() {
        Locale locale = this.f11504a;
        return locale != null ? locale : Locale.getDefault();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return this.f11505b.equals(((c) obj).f11505b);
        }
        return false;
    }

    public boolean k() {
        return h(c());
    }

    public boolean n() {
        if (f(c())) {
            return true;
        }
        for (int i10 = 0; i10 < this.f11505b.size(); i10++) {
            Locale locale = this.f11505b.get(i10);
            if (f(locale)) {
                return true;
            }
            if (i(locale)) {
                return false;
            }
        }
        return false;
    }

    public boolean o() {
        if (i(c())) {
            return true;
        }
        for (int i10 = 0; i10 < this.f11505b.size(); i10++) {
            Locale locale = this.f11505b.get(i10);
            if (i(locale)) {
                return true;
            }
            if (f(locale) || j(locale)) {
                return false;
            }
        }
        return false;
    }

    public final String toString() {
        return this.f11505b.toString();
    }
}
