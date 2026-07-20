package k3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class l1 {
    public static boolean a(String str, String str2) {
        pa.a aVar = pa.a.f8703a;
        String strConcat = "ro.".concat(str);
        if (str2 == null) {
            str2 = "";
        }
        return Intrinsics.areEqual("1", aVar.i(strConcat, str2, "0"));
    }

    public static boolean b() {
        return a("tr_pcconnect.extend_screen.feature.support", "ro.extend_screen_support") || Intrinsics.areEqual("1", pa.a.f8703a.k("tr_pcconnect.extend_screen.feature.support", "ro.extend_screen_support", "0"));
    }
}
