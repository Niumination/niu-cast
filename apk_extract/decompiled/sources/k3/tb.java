package k3;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class tb {
    public static String a(String brand) {
        Intrinsics.checkNotNullParameter(brand, "brand");
        Locale locale = Locale.ENGLISH;
        if (StringsKt__StringsKt.contains(a1.a.t(locale, "ENGLISH", brand, locale, "toLowerCase(...)"), (CharSequence) a1.a.t(locale, "ENGLISH", "Tecno", locale, "toLowerCase(...)"), true)) {
            return "03";
        }
        if (StringsKt__StringsKt.contains(a1.a.t(locale, "ENGLISH", brand, locale, "toLowerCase(...)"), (CharSequence) a1.a.t(locale, "ENGLISH", "Infinix", locale, "toLowerCase(...)"), true)) {
            return "04";
        }
        return StringsKt__StringsKt.contains(a1.a.t(locale, "ENGLISH", brand, locale, "toLowerCase(...)"), (CharSequence) a1.a.t(locale, "ENGLISH", "Itel", locale, "toLowerCase(...)"), true) ? "02" : "FF";
    }

    public static String b(String brand) {
        int i8;
        Intrinsics.checkNotNullParameter(brand, "brand");
        pa.a aVar = pa.a.f8703a;
        if (pa.a.j("ro.tr_project.flip_screen.support") || pa.a.j("ro.tr_project.foldable_screen.support")) {
            Locale locale = Locale.ENGLISH;
            if (StringsKt__StringsKt.contains(a1.a.t(locale, "ENGLISH", brand, locale, "toLowerCase(...)"), (CharSequence) a1.a.t(locale, "ENGLISH", "Tecno", locale, "toLowerCase(...)"), true)) {
                return pa.a.j("ro.tr_project.flip_screen.support") ? "30011" : "30000";
            }
            i8 = Integer.parseInt("04", CharsKt.checkRadix(16));
        } else {
            if (!sb.b()) {
                return "3 DDDD";
            }
            i8 = Integer.parseInt(a(brand), CharsKt.checkRadix(16));
        }
        return h0.a.g(i8, " FFFF");
    }
}
