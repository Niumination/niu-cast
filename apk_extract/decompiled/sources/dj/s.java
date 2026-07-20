package dj;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f4625a;

    public s(String[] strArr) {
        this.f4625a = strArr;
    }

    public final String e(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String[] strArr = this.f4625a;
        IntProgression intProgressionStep = RangesKt.step(RangesKt.downTo(strArr.length - 2, 0), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (!StringsKt__StringsJVMKt.equals(name, strArr[first], true)) {
                if (first != last) {
                    first += step;
                }
            }
            return strArr[first + 1];
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            if (Arrays.equals(this.f4625a, ((s) obj).f4625a)) {
                return true;
            }
        }
        return false;
    }

    public final String f(int i8) {
        return this.f4625a[i8 * 2];
    }

    public final r g() {
        r rVar = new r(0);
        CollectionsKt__MutableCollectionsKt.addAll(rVar.f4624a, this.f4625a);
        return rVar;
    }

    public final String h(int i8) {
        return this.f4625a[(i8 * 2) + 1];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4625a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i8 = 0; i8 < size; i8++) {
            pairArr[i8] = TuplesKt.to(f(i8), h(i8));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    public final int size() {
        return this.f4625a.length / 2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            String strF = f(i8);
            String strH = h(i8);
            sb2.append(strF);
            sb2.append(": ");
            if (ej.b.q(strF)) {
                strH = "██";
            }
            sb2.append(strH);
            sb2.append("\n");
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
