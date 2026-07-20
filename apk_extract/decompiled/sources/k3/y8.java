package k3;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class y8 {
    public static hc.c a(hc.b it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StringBuilder sbY = a1.a.y("name: ", it.f, ", mac: ");
        String str = it.f5281c;
        sbY.append(str);
        sbY.append(", brand: ");
        int i8 = it.e;
        sbY.append(i8);
        sbY.append(", deviceType: ");
        int i9 = it.f5284h;
        sbY.append(i9);
        sbY.append(",serviceType: ");
        int i10 = it.f5283g;
        sbY.append(i10);
        sbY.append(",pid: ");
        String str2 = it.f5285i;
        sbY.append(str2);
        String log = sbY.toString();
        Intrinsics.checkNotNullParameter("result2ConnectableDevice", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("result2ConnectableDevice"), log);
        }
        hc.c cVar = new hc.c();
        String str3 = it.f;
        Intrinsics.checkNotNullParameter(str3, "<set-?>");
        cVar.f5287b = str3;
        cVar.a(str);
        cVar.f = i9;
        cVar.f5289d = i8;
        cVar.e = i10;
        Intrinsics.checkNotNullParameter(str2, "<set-?>");
        cVar.f5286a = str2;
        return cVar;
    }
}
