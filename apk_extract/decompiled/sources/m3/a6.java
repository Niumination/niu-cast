package m3;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class a6 {
    public static final Charset a(wf.b bVar) {
        zf.i iVarA;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        zf.r rVarA = bVar.a();
        String[] strArr = zf.v.f11551a;
        String str = rVarA.get("Content-Type");
        if (str != null) {
            zf.i iVar = zf.i.f11505h;
            iVarA = l0.a(str);
        } else {
            iVarA = null;
        }
        if (iVarA != null) {
            return y5.a(iVarA);
        }
        return null;
    }

    public static final zf.i b(vf.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        zf.s sVar = cVar.f10559c;
        String[] strArr = zf.v.f11551a;
        String strI = sVar.i("Content-Type");
        if (strI == null) {
            return null;
        }
        zf.i iVar = zf.i.f11505h;
        return l0.a(strI);
    }
}
