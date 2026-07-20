package mk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jq.h0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    @f
    @os.l
    public static final List<y> a(@os.l String str) {
        l0.p(str, "value");
        List listR4 = h0.R4(str, new String[]{";"}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(nm.z.b0(listR4, 10));
        Iterator it = listR4.iterator();
        while (it.hasNext()) {
            List listR5 = h0.R4((String) it.next(), new String[]{ks.g.f9491d}, false, 0, 6, null);
            String string = h0.C5((String) nm.h0.B2(listR5)).toString();
            List listC2 = nm.h0.c2(listR5, 1);
            ArrayList arrayList2 = new ArrayList(nm.z.b0(listC2, 10));
            Iterator it2 = listC2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(h0.C5((String) it2.next()).toString());
            }
            arrayList.add(new y(string, arrayList2));
        }
        return arrayList;
    }
}
