package j2;

import android.util.SparseArray;
import android.view.MotionEvent;
import f2.a0;
import java.util.ArrayList;
import java.util.HashMap;
import kn.l0;
import lm.t0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final e f8524a;

    public h(@l e eVar) {
        l0.p(eVar, "mixAnimPlugin");
        this.f8524a = eVar;
    }

    public final boolean a(int i10, int i11, a0 a0Var) {
        int i12;
        int i13 = a0Var.f5666a;
        return i10 >= i13 && i10 <= i13 + a0Var.f5668c && i11 >= (i12 = a0Var.f5667b) && i11 <= i12 + a0Var.f5669d;
    }

    @m
    public final i b(@l MotionEvent motionEvent) {
        SparseArray<c> sparseArray;
        c cVar;
        HashMap<String, j> map;
        l0.p(motionEvent, "ev");
        t0<Integer, Integer> realSize = this.f8524a.f8486a.f5737a.getRealSize();
        int iIntValue = realSize.component1().intValue();
        int iIntValue2 = realSize.component2().intValue();
        f2.a aVar = this.f8524a.f8486a.f5754r.f5673b;
        Integer numValueOf = aVar == null ? null : Integer.valueOf(aVar.f5653c);
        if (numValueOf == null) {
            return null;
        }
        int iIntValue3 = numValueOf.intValue();
        f2.a aVar2 = this.f8524a.f8486a.f5754r.f5673b;
        Integer numValueOf2 = aVar2 == null ? null : Integer.valueOf(aVar2.f5654d);
        if (numValueOf2 == null) {
            return null;
        }
        int iIntValue4 = numValueOf2.intValue();
        if (iIntValue != 0 && iIntValue2 != 0 && motionEvent.getAction() == 1) {
            float x10 = (motionEvent.getX() * iIntValue3) / iIntValue;
            float y10 = (motionEvent.getY() * iIntValue4) / iIntValue2;
            e eVar = this.f8524a;
            b bVar = eVar.f8490e;
            ArrayList<a> arrayList = (bVar == null || (sparseArray = bVar.f8479a) == null || (cVar = sparseArray.get(eVar.f8491f)) == null) ? null : cVar.f8481b;
            if (arrayList != null) {
                for (a aVar3 : arrayList) {
                    k kVar = this.f8524a.f8489d;
                    j jVar = (kVar == null || (map = kVar.f8551a) == null) ? null : map.get(aVar3.f8474b);
                    if (jVar != null && a((int) x10, (int) y10, aVar3.f8476d)) {
                        i iVar = new i(jVar);
                        iVar.f8530f = aVar3.f8476d;
                        return iVar;
                    }
                }
            }
        }
        return null;
    }
}
