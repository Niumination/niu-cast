package jk;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends AbstractQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f6335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6336b;

    public a(int i8) {
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(i8 - 1));
        this.f6336b = iNumberOfLeadingZeros - 1;
        this.f6335a = new AtomicReferenceArray(iNumberOfLeadingZeros);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        while (true) {
            if (((b) this).poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
