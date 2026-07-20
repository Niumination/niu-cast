package gp;

import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    @os.l
    public static final String a(@os.l dp.d dVar) {
        l0.p(dVar, "<this>");
        List<dp.f> listH = dVar.h();
        l0.o(listH, "pathSegments()");
        return c(listH);
    }

    @os.l
    public static final String b(@os.l dp.f fVar) {
        l0.p(fVar, "<this>");
        boolean zD = d(fVar);
        String strB = fVar.b();
        l0.o(strB, "asString()");
        if (!zD) {
            return strB;
        }
        return l0.C("`" + strB, "`");
    }

    @os.l
    public static final String c(@os.l List<dp.f> list) {
        l0.p(list, "pathSegments");
        StringBuilder sb2 = new StringBuilder();
        for (dp.f fVar : list) {
            if (sb2.length() > 0) {
                sb2.append(".");
            }
            sb2.append(b(fVar));
        }
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final boolean d(dp.f fVar) {
        if (fVar.f3821b) {
            return false;
        }
        String strB = fVar.b();
        l0.o(strB, "asString()");
        if (!i.f6811a.contains(strB)) {
            int i10 = 0;
            while (i10 < strB.length()) {
                char cCharAt = strB.charAt(i10);
                i10++;
                if (Character.isLetterOrDigit(cCharAt) || cCharAt == '_') {
                }
            }
            return false;
        }
        return true;
    }
}
