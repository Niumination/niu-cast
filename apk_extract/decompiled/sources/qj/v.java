package qj;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f9229a = new u(new byte[0], 0, 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f9231c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f9230b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i8 = 0; i8 < iHighestOneBit; i8++) {
            atomicReferenceArr[i8] = new AtomicReference();
        }
        f9231c = atomicReferenceArr;
    }

    public static final void a(u segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.f != null || segment.f9228g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f9227d) {
            return;
        }
        AtomicReference atomicReference = f9231c[(int) (Thread.currentThread().getId() & (((long) f9230b) - 1))];
        u uVar = f9229a;
        u uVar2 = (u) atomicReference.getAndSet(uVar);
        if (uVar2 == uVar) {
            return;
        }
        int i8 = uVar2 != null ? uVar2.f9226c : 0;
        if (i8 >= 65536) {
            atomicReference.set(uVar2);
            return;
        }
        segment.f = uVar2;
        segment.f9225b = 0;
        segment.f9226c = i8 + 8192;
        atomicReference.set(segment);
    }

    public static final u b() {
        AtomicReference atomicReference = f9231c[(int) (Thread.currentThread().getId() & (((long) f9230b) - 1))];
        u uVar = f9229a;
        u uVar2 = (u) atomicReference.getAndSet(uVar);
        if (uVar2 == uVar) {
            return new u();
        }
        if (uVar2 == null) {
            atomicReference.set(null);
            return new u();
        }
        atomicReference.set(uVar2.f);
        uVar2.f = null;
        uVar2.f9226c = 0;
        return uVar2;
    }
}
