package wi;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10784d;
    public static final int e;
    public static final AtomicReferenceArray f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceArray f10785g;

    static {
        byte[] data = new byte[0];
        Intrinsics.checkNotNullParameter(data, "data");
        f10781a = new h(data, 0, 0, null);
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f10782b = iHighestOneBit;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(iHighestOneBit / 2, 1);
        f10783c = iCoerceAtLeast;
        String property = System.getProperty("kotlinx.io.pool.size.bytes", Intrinsics.areEqual(System.getProperty("java.vm.name"), "Dalvik") ? "0" : "4194304");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        Integer intOrNull = StringsKt.toIntOrNull(property);
        int iCoerceAtLeast2 = intOrNull != null ? RangesKt.coerceAtLeast(intOrNull.intValue(), 0) : 0;
        f10784d = iCoerceAtLeast2;
        e = RangesKt.coerceAtLeast(iCoerceAtLeast2 / iCoerceAtLeast, 8192);
        f = new AtomicReferenceArray(iHighestOneBit);
        f10785g = new AtomicReferenceArray(iCoerceAtLeast);
    }

    public static final void a(h segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.f != null || segment.f10780g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        q qVar = segment.f10779d;
        if (qVar != null) {
            g gVar = (g) qVar;
            if (gVar.f10775b != 0) {
                int iDecrementAndGet = g.f10774c.decrementAndGet(gVar);
                if (iDecrementAndGet >= 0) {
                    return;
                }
                if (iDecrementAndGet != -1) {
                    throw new IllegalStateException(("Shared copies count is negative: " + (iDecrementAndGet + 1)).toString());
                }
                gVar.f10775b = 0;
            }
        }
        AtomicReferenceArray atomicReferenceArray = f;
        int id2 = (int) ((((long) f10782b) - 1) & Thread.currentThread().getId());
        segment.f10777b = 0;
        segment.e = true;
        while (true) {
            h hVar = (h) atomicReferenceArray.get(id2);
            h hVar2 = f10781a;
            if (hVar != hVar2) {
                int i8 = hVar != null ? hVar.f10778c : 0;
                if (i8 < 65536) {
                    segment.f = hVar;
                    segment.f10778c = i8 + 8192;
                    if (atomicReferenceArray.compareAndSet(id2, hVar, segment)) {
                        return;
                    }
                } else {
                    if (f10784d <= 0) {
                        return;
                    }
                    segment.f10777b = 0;
                    segment.e = true;
                    int id3 = (int) ((((long) f10783c) - 1) & Thread.currentThread().getId());
                    AtomicReferenceArray atomicReferenceArray2 = f10785g;
                    int i9 = 0;
                    while (true) {
                        h hVar3 = (h) atomicReferenceArray2.get(id3);
                        if (hVar3 != hVar2) {
                            int i10 = (hVar3 != null ? hVar3.f10778c : 0) + 8192;
                            if (i10 > e) {
                                int i11 = f10783c;
                                if (i9 >= i11) {
                                    return;
                                }
                                i9++;
                                id3 = (id3 + 1) & (i11 - 1);
                            } else {
                                segment.f = hVar3;
                                segment.f10778c = i10;
                                if (atomicReferenceArray2.compareAndSet(id3, hVar3, segment)) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final h b() {
        h hVar;
        h hVar2;
        AtomicReferenceArray atomicReferenceArray = f;
        int id2 = (int) ((((long) f10782b) - 1) & Thread.currentThread().getId());
        do {
            hVar = f10781a;
            hVar2 = (h) atomicReferenceArray.getAndSet(id2, hVar);
        } while (Intrinsics.areEqual(hVar2, hVar));
        if (hVar2 != null) {
            atomicReferenceArray.set(id2, hVar2.f);
            hVar2.f = null;
            hVar2.f10778c = 0;
            return hVar2;
        }
        atomicReferenceArray.set(id2, null);
        if (f10784d <= 0) {
            return new h();
        }
        AtomicReferenceArray atomicReferenceArray2 = f10785g;
        int i8 = f10783c;
        int id3 = (int) (Thread.currentThread().getId() & (((long) i8) - 1));
        int i9 = 0;
        while (true) {
            h hVar3 = (h) atomicReferenceArray2.getAndSet(id3, hVar);
            if (!Intrinsics.areEqual(hVar3, hVar)) {
                if (hVar3 != null) {
                    atomicReferenceArray2.set(id3, hVar3.f);
                    hVar3.f = null;
                    hVar3.f10778c = 0;
                    return hVar3;
                }
                atomicReferenceArray2.set(id3, null);
                if (i9 >= i8) {
                    return new h();
                }
                id3 = (id3 + 1) & (i8 - 1);
                i9++;
            }
        }
    }
}
