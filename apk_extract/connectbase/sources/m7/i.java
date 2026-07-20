package m7;

import android.content.Context;
import com.android.internal.app.LocaleStore;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Locale f10595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Locale f10598d;

        public a(Locale locale, String str, String str2) {
            this.f10595a = locale;
            this.f10596b = str;
            this.f10597c = str2;
        }

        public String a() {
            return this.f10597c;
        }

        public String b() {
            return this.f10596b;
        }

        public Locale c() {
            return this.f10595a;
        }

        public Locale d() {
            return this.f10598d;
        }

        public void e(Locale locale) {
            this.f10598d = locale;
        }

        public String toString() {
            return this.f10596b;
        }
    }

    public Set<a> a(Context context, Set<String> set, a aVar, boolean z10) {
        Set<LocaleStore.LocaleInfo> levelLocales = LocaleStore.getLevelLocales(context, set, (LocaleStore.LocaleInfo) null, z10);
        HashSet hashSet = new HashSet();
        if (aVar != null) {
            for (LocaleStore.LocaleInfo localeInfo : levelLocales) {
                if (aVar.b() == localeInfo.getId()) {
                    levelLocales = LocaleStore.getLevelLocales(context, set, localeInfo, z10);
                    break;
                }
            }
        }
        for (LocaleStore.LocaleInfo localeInfo2 : levelLocales) {
            hashSet.add(new a(localeInfo2.getLocale(), localeInfo2.getId(), localeInfo2.getFullNameNative()));
        }
        return hashSet;
    }

    public Set<a> b(Context context, Set<String> set, a aVar, boolean z10) {
        Set<LocaleStore.LocaleInfo> levelLocales = LocaleStore.getLevelLocales(context, set, (LocaleStore.LocaleInfo) null, z10);
        HashSet hashSet = new HashSet();
        if (aVar != null) {
            for (LocaleStore.LocaleInfo localeInfo : levelLocales) {
                if (aVar.b() == localeInfo.getId()) {
                    levelLocales = LocaleStore.getLevelLocales(context, set, localeInfo, z10);
                    break;
                }
            }
        }
        for (LocaleStore.LocaleInfo localeInfo2 : levelLocales) {
            a aVar2 = new a(localeInfo2.getLocale(), localeInfo2.getId(), localeInfo2.getFullNameNative());
            aVar2.e(localeInfo2.getParent());
            hashSet.add(aVar2);
        }
        return hashSet;
    }
}
