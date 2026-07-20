package m3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class i6 {
    public static final zf.d0 a(zf.e0 parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        zf.f0 f0VarA = c6.a();
        for (String str : parameters.names()) {
            List listB = parameters.b(str);
            if (listB == null) {
                listB = CollectionsKt.emptyList();
            }
            String strD = zf.d.d(str, 0, 0, false, 15);
            List list = listB;
            ArrayList arrayList = new ArrayList(CollectionsKt.i(list));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zf.d.d((String) it.next(), 0, 0, true, 11));
            }
            f0VarA.c(strD, arrayList);
        }
        return f0VarA.build();
    }
}
