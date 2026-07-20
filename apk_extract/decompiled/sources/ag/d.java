package ag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import m3.p6;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements zf.r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f762d;

    public d(v headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f761c = headers;
        this.f762d = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new a(this, 0));
    }

    @Override // zg.t
    public final Set a() {
        IntRange intRangeUntil = RangesKt.until(0, this.f761c.f793b);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(intRangeUntil));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(new c(this, ((IntIterator) it).nextInt()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // zg.t
    public final List b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        final v vVar = this.f761c;
        vVar.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        final int iB = bg.g.b(name, 0, name.length());
        final int i8 = 0;
        final int i9 = 1;
        List list = SequencesKt.toList(SequencesKt.map(SequencesKt.map(SequencesKt.filter(SequencesKt.map(SequencesKt.generateSequence(0, (Function1<? super int, ? extends int>) new Function1() { // from class: ag.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int i10 = i8;
                int iIntValue = ((Integer) obj).intValue();
                switch (i10) {
                    case 0:
                        int i11 = iIntValue + 1;
                        if (i11 >= vVar.f793b) {
                            return null;
                        }
                        return Integer.valueOf(i11);
                    default:
                        v vVar2 = vVar;
                        bg.c cVar = vVar2.f792a;
                        int[] iArr = vVar2.f794c;
                        return cVar.subSequence(iArr[iIntValue + 4], iArr[iIntValue + 5]);
                }
            }
        }), new b(2)), new Function1() { // from class: ag.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(vVar.f794c[((Integer) obj).intValue()] == iB);
            }
        }), new Function1() { // from class: ag.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int i10 = i9;
                int iIntValue = ((Integer) obj).intValue();
                switch (i10) {
                    case 0:
                        int i11 = iIntValue + 1;
                        if (i11 >= vVar.f793b) {
                            return null;
                        }
                        return Integer.valueOf(i11);
                    default:
                        v vVar2 = vVar;
                        bg.c cVar = vVar2.f792a;
                        int[] iArr = vVar2.f794c;
                        return cVar.subSequence(iArr[iIntValue + 4], iArr[iIntValue + 5]);
                }
            }
        }), new b(0)));
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override // zg.t
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        p6.a(this, body);
    }

    @Override // zg.t
    public final boolean d() {
        return true;
    }

    @Override // zg.t
    public final String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        bg.b bVarB = this.f761c.b(name);
        if (bVarB != null) {
            return bVarB.toString();
        }
        return null;
    }

    @Override // zg.t
    public final Set names() {
        return (Set) this.f762d.getValue();
    }
}
