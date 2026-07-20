package gq;

import java.util.Iterator;
import kn.l0;
import lm.a2;
import lm.f1;
import lm.g2;
import lm.p2;
import lm.s1;
import lm.w1;

/* JADX INFO: loaded from: classes3.dex */
public class c0 {
    @f1(version = "1.5")
    @in.i(name = "sumOfUByte")
    @p2(markerClass = {lm.t.class})
    public static final int a(@os.l m<s1> mVar) {
        l0.p(mVar, "<this>");
        Iterator<s1> it = mVar.iterator();
        int iM = 0;
        while (it.hasNext()) {
            iM += w1.m(it.next().f10218a & 255);
        }
        return iM;
    }

    @f1(version = "1.5")
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    public static final int b(@os.l m<w1> mVar) {
        l0.p(mVar, "<this>");
        Iterator<w1> it = mVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().f10227a;
        }
        return i10;
    }

    @f1(version = "1.5")
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    public static final long c(@os.l m<a2> mVar) {
        l0.p(mVar, "<this>");
        Iterator<a2> it = mVar.iterator();
        long j10 = 0;
        while (it.hasNext()) {
            j10 += it.next().f10177a;
        }
        return j10;
    }

    @f1(version = "1.5")
    @in.i(name = "sumOfUShort")
    @p2(markerClass = {lm.t.class})
    public static final int d(@os.l m<g2> mVar) {
        l0.p(mVar, "<this>");
        Iterator<g2> it = mVar.iterator();
        int iM = 0;
        while (it.hasNext()) {
            iM += w1.m(it.next().f10193a & g2.f10190d);
        }
        return iM;
    }
}
