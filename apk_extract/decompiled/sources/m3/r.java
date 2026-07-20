package m3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    public static final zf.i a(mg.b bVar, zf.i iVar) {
        zf.i iVarA;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        if (iVar == null) {
            ka.d dVarA = bVar.k().a();
            String[] strArr = zf.v.f11551a;
            String strC = dVarA.c("Content-Type");
            if (strC != null) {
                try {
                    zf.i iVar2 = zf.i.f11505h;
                    iVarA = l0.a(strC);
                } catch (zf.a unused) {
                    iVarA = null;
                }
                iVar = iVarA;
                if (iVar == null) {
                    iVar = zf.h.f11502b;
                }
            } else {
                iVar = zf.h.f11502b;
            }
        }
        return (y5.a(iVar) == null && iVar.k(zf.h.f11501a)) ? y5.b(iVar, Charsets.UTF_8) : iVar;
    }
}
