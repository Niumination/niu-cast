package nm;

import java.util.Collection;
import java.util.Iterator;
import lm.a2;
import lm.b2;
import lm.g2;
import lm.h2;
import lm.p2;
import lm.x1;

/* JADX INFO: loaded from: classes3.dex */
public class w1 {
    @lm.f1(version = "1.5")
    @in.i(name = "sumOfUByte")
    @p2(markerClass = {lm.t.class})
    public static final int a(@os.l Iterable<lm.s1> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<lm.s1> it = iterable.iterator();
        int iM = 0;
        while (it.hasNext()) {
            iM += lm.w1.m(it.next().f10218a & 255);
        }
        return iM;
    }

    @lm.f1(version = "1.5")
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    public static final int b(@os.l Iterable<lm.w1> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<lm.w1> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().f10227a;
        }
        return i10;
    }

    @lm.f1(version = "1.5")
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    public static final long c(@os.l Iterable<a2> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<a2> it = iterable.iterator();
        long j10 = 0;
        while (it.hasNext()) {
            j10 += it.next().f10177a;
        }
        return j10;
    }

    @lm.f1(version = "1.5")
    @in.i(name = "sumOfUShort")
    @p2(markerClass = {lm.t.class})
    public static final int d(@os.l Iterable<g2> iterable) {
        kn.l0.p(iterable, "<this>");
        Iterator<g2> it = iterable.iterator();
        int iM = 0;
        while (it.hasNext()) {
            iM += lm.w1.m(it.next().f10193a & g2.f10190d);
        }
        return iM;
    }

    @lm.f1(version = "1.3")
    @lm.t
    @os.l
    public static final byte[] e(@os.l Collection<lm.s1> collection) {
        kn.l0.p(collection, "<this>");
        byte[] bArrE = lm.t1.e(collection.size());
        Iterator<lm.s1> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bArrE[i10] = it.next().f10218a;
            i10++;
        }
        return bArrE;
    }

    @lm.f1(version = "1.3")
    @lm.t
    @os.l
    public static final int[] f(@os.l Collection<lm.w1> collection) {
        kn.l0.p(collection, "<this>");
        int[] iArrE = x1.e(collection.size());
        Iterator<lm.w1> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArrE[i10] = it.next().f10227a;
            i10++;
        }
        return iArrE;
    }

    @lm.f1(version = "1.3")
    @lm.t
    @os.l
    public static final long[] g(@os.l Collection<a2> collection) {
        kn.l0.p(collection, "<this>");
        long[] jArrE = b2.e(collection.size());
        Iterator<a2> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            jArrE[i10] = it.next().f10177a;
            i10++;
        }
        return jArrE;
    }

    @lm.f1(version = "1.3")
    @lm.t
    @os.l
    public static final short[] h(@os.l Collection<g2> collection) {
        kn.l0.p(collection, "<this>");
        short[] sArrE = h2.e(collection.size());
        Iterator<g2> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            sArrE[i10] = it.next().f10193a;
            i10++;
        }
        return sArrE;
    }
}
