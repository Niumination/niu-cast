package a6;

import java.util.ArrayList;
import jq.h0;
import kn.l0;
import lm.t0;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f125b = "TopActivityUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f126c = "com.transsion.pcconnect";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final q f124a = new q();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final ArrayList<String> f127d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static t0<String, String> f128e = new t0<>("com.transsion.pcconnect", "");

    public final boolean a(int i10, @os.l String str) {
        l0.p(str, "packageName");
        f128e = new t0<>(str, f128e.getFirst());
        boolean zAdd = false;
        if (h0.T2(str, "launcher", false, 2, null)) {
            return false;
        }
        if (i10 == 0) {
            ArrayList<String> arrayList = f127d;
            if (arrayList.contains(str)) {
                zAdd = arrayList.remove(str);
            }
        } else {
            ArrayList<String> arrayList2 = f127d;
            if (!arrayList2.contains(str)) {
                zAdd = arrayList2.add(str);
            }
        }
        k4.m.e(f125b, "displayId: " + i10 + ", ddTopPair: " + str + ", isUpdateApp: " + zAdd + ", mExtendAppList: " + f127d);
        return zAdd;
    }

    public final void b() {
        f127d.clear();
    }

    @os.l
    public final ArrayList<String> c() {
        return f127d;
    }

    @os.l
    public final String d(@os.l String str) {
        l0.p(str, "packageName");
        k4.m.e(f125b, "getTopPackageName:" + str + ", mTopPair: " + f128e);
        if (l0.g(str, "com.transsion.pcconnect")) {
            return l0.g(f128e.getFirst(), "com.transsion.pcconnect") ? f128e.getSecond() : f128e.getFirst();
        }
        return str;
    }
}
