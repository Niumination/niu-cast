package m7;

import bf.l;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class f implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f10588a = cc.a.a("com.android.internal.app.LocaleHelper");

    @Override // bf.l
    public String a(Locale locale, Locale locale2, boolean z10) {
        return "";
    }

    @Override // bf.l
    public String b(Locale locale, boolean z10) {
        return (String) cc.a.j(cc.a.g(f10588a, "getDisplayName", Locale.class, Boolean.TYPE), f10588a, locale, Boolean.valueOf(z10));
    }
}
