package k3;

import android.icu.text.NumberFormat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class xb {
    public static String a(int i8, int i9) {
        try {
            return NumberFormat.getInstance().format(Integer.valueOf(i8)) + "/" + NumberFormat.getInstance().format(Integer.valueOf(i9));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(int i8) {
        try {
            StringBuilder sb2 = new StringBuilder(NumberFormat.getPercentInstance().format(Float.valueOf(i8 / 100.0f)));
            String language = Locale.getDefault().getLanguage();
            if (Intrinsics.areEqual(language, "fa") || Intrinsics.areEqual(language, "ks")) {
                char cCharAt = sb2.charAt(StringsKt.getLastIndex(sb2));
                sb2.deleteCharAt(StringsKt.getLastIndex(sb2));
                sb2.insert(0, cCharAt);
            }
            String string = sb2.toString();
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Exception unused) {
            return "";
        }
    }
}
