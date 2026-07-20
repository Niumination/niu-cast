package se;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends we.k {
    public static String c(int i8) {
        switch (i8) {
            case 320098817:
                return "NEAR_P2P_NEAR_LE_CLIENT_ID";
            case 320098818:
                return "NEAR_P2P_NEAR_LE_SERVER_ID";
            case 320098819:
                return "NEAR_P2P_NEAR_CLASSIC_CLIENT_ID";
            case 320098820:
                return "NEAR_P2P_NEAR_CLASSIC_SERVER_ID";
            case 320098821:
                return "NEAR_P2P_NEAR_DIRECT_OWNER_ID";
            case 320098822:
                return "NEAR_P2P_NEAR_DIRECT_CLIENT_ID";
            case 320098823:
                return "NEAR_P2P_PC_CAST_TRANSMIT_CLIENT_ID";
            case 320098824:
                return "NEAR_P2P_PC_CAST_RECEIVE_CLIENT_ID";
            default:
                return "Unknown Module Id";
        }
    }

    public boolean d(String version1) {
        Intrinsics.checkNotNullParameter(version1, "version1");
        Intrinsics.checkNotNullParameter("1.0", "version2");
        List listSplit$default = StringsKt__StringsKt.split$default(version1, new String[]{"."}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
        }
        List listSplit$default2 = StringsKt__StringsKt.split$default("1.0", new String[]{"."}, false, 0, 6, (Object) null);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(listSplit$default2));
        Iterator it2 = listSplit$default2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
        }
        if (((Number) arrayList.get(0)).intValue() > ((Number) arrayList2.get(0)).intValue()) {
            return true;
        }
        return ((Number) arrayList.get(0)).intValue() == ((Number) arrayList2.get(0)).intValue() && ((Number) arrayList.get(1)).intValue() > ((Number) arrayList2.get(1)).intValue();
    }
}
