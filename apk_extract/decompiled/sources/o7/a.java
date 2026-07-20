package o7;

import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f8410a = new ConcurrentHashMap();

    public static void a() {
        ConcurrentHashMap concurrentHashMap = f8410a;
        String strM = d.m("getAllCapability: ", "CapabilityHelperManager", "tag", "log", concurrentHashMap.size());
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("CapabilityHelperManager"), strM);
        }
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            String log = "getAllCapability: " + ((Map.Entry) it.next()).getKey();
            Intrinsics.checkNotNullParameter("CapabilityHelperManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("CapabilityHelperManager"), log);
            }
        }
    }

    public static c b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        c cVar = (c) f8410a.get(name);
        if (cVar == null) {
            return null;
        }
        return cVar;
    }

    public static boolean c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return b(name) != null;
    }
}
