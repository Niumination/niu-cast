package wk;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class n0<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ArrayList<E> f19648a = new ArrayList<>();

    public final boolean a() {
        return this.f19648a.isEmpty();
    }

    public final E b() {
        if (this.f19648a.isEmpty()) {
            throw new NoSuchElementException("Unable to peek an element into empty stack");
        }
        return (E) nm.h0.p3(this.f19648a);
    }

    public final E c() {
        if (this.f19648a.isEmpty()) {
            throw new NoSuchElementException("Unable to pop an element from empty stack");
        }
        ArrayList<E> arrayList = this.f19648a;
        return arrayList.remove(nm.y.J(arrayList));
    }

    public final void d(E e10) {
        this.f19648a.add(e10);
    }
}
