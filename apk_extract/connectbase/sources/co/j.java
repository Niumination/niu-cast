package co;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import eo.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.d1;
import nm.h0;
import nm.z;
import os.l;
import vp.b1;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    @l
    public static final b1 a(@l eo.e eVar, @l eo.e eVar2) {
        l0.p(eVar, TypedValues.TransitionType.S_FROM);
        l0.p(eVar2, TypedValues.TransitionType.S_TO);
        eVar.r().size();
        eVar2.r().size();
        b1.a aVar = b1.f17666c;
        List<e1> listR = eVar.r();
        l0.o(listR, "from.declaredTypeParameters");
        List<e1> list = listR;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((e1) it.next()).i());
        }
        List<e1> listR2 = eVar2.r();
        l0.o(listR2, "to.declaredTypeParameters");
        List<e1> list2 = listR2;
        ArrayList arrayList2 = new ArrayList(z.b0(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            n0 n0VarQ = ((e1) it2.next()).q();
            l0.o(n0VarQ, "it.defaultType");
            arrayList2.add(zp.a.a(n0VarQ));
        }
        return b1.a.e(aVar, d1.D0(h0.i6(arrayList, arrayList2)), false, 2, null);
    }
}
