package k3;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class rb {
    public static void a(int i8) {
        Intrinsics.checkNotNullParameter("STATUSBARICONSLOT", "slot");
        Intrinsics.checkNotNullParameter("STATUSBARICONSLOT", "contentDescription");
        try {
            f5.a aVar = new f5.a();
            String str = l9.a.f7342a;
            aVar.e().setIcon(i8);
            Intrinsics.checkNotNullParameter("IconUtils", "tag");
            Intrinsics.checkNotNullParameter("sjl setIcon success", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("IconUtils"), "sjl setIcon success");
            }
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter("IconUtils", "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat("IconUtils"), e.getMessage(), e);
        }
    }

    public static void b() {
        Intrinsics.checkNotNullParameter("STATUSBARICONSLOT", "slot");
        try {
            f5.a aVar = new f5.a();
            String str = l9.a.f7342a;
            aVar.e().a();
            Intrinsics.checkNotNullParameter("IconUtils", "tag");
            Intrinsics.checkNotNullParameter("sjl setIconVisibility success false", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("IconUtils"), "sjl setIconVisibility success false");
            }
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter("IconUtils", "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat("IconUtils"), e.getMessage(), e);
        }
    }
}
