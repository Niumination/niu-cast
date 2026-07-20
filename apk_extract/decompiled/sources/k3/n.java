package k3;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class n extends i implements ListIterator {
    public final /* synthetic */ o e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar) {
        super(oVar);
        this.e = oVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        o oVar = this.e;
        boolean zIsEmpty = oVar.isEmpty();
        a();
        ((ListIterator) this.f6488b).add(obj);
        oVar.f6554h.e++;
        if (zIsEmpty) {
            oVar.e();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        return ((ListIterator) this.f6488b).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return ((ListIterator) this.f6488b).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        return ((ListIterator) this.f6488b).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return ((ListIterator) this.f6488b).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        ((ListIterator) this.f6488b).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, int i8) {
        super(oVar, ((List) oVar.f6531b).listIterator(i8));
        this.e = oVar;
    }
}
