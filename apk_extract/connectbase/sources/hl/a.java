package hl;

import fl.h1;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import nm.d0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @l
    public static final <T> List<T> a(@l T... tArr) {
        l0.p(tArr, "values");
        h1.f6045a.getClass();
        if (h1.f6049e) {
            c cVar = new c();
            d0.s0(cVar, tArr);
            return cVar;
        }
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i10 = 0;
        while (i10 < length) {
            T t10 = tArr[i10];
            i10++;
            arrayList.add(t10);
        }
        return arrayList;
    }
}
