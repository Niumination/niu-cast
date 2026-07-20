package f1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public class z5<E> extends p3<E> {
    static final z5<Object> EMPTY = new z5<>(new j5());
    final transient j5<E> contents;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f5646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient t3<E> f5647e;

    public final class b extends d4<E> {
        public b() {
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            return z5.this.contains(object);
        }

        @Override // f1.d4
        public E get(int index) {
            return z5.this.contents.j(index);
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return z5.this.contents.D();
        }
    }

    @b1.c
    public static class c implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        public c(b5<? extends Object> multiset) {
            int size = multiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i10 = 0;
            for (b5.a<? extends Object> aVar : multiset.entrySet()) {
                this.elements[i10] = aVar.getElement();
                this.counts[i10] = aVar.getCount();
                i10++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            p3.b bVar = new p3.b(this.elements.length);
            int i10 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i10 >= objArr.length) {
                    return bVar.e();
                }
                bVar.k(objArr[i10], this.counts[i10]);
                i10++;
            }
        }
    }

    public z5(j5<E> contents) {
        this.contents = contents;
        long jL = 0;
        for (int i10 = 0; i10 < contents.D(); i10++) {
            jL += (long) contents.l(i10);
        }
        this.f5646d = o1.l.z(jL);
    }

    @Override // f1.b5
    public int count(@gm.a Object element) {
        return this.contents.g(element);
    }

    @Override // f1.p3
    public b5.a<E> getEntry(int index) {
        return this.contents.h(index);
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    public int size() {
        return this.f5646d;
    }

    @Override // f1.p3, f1.e3
    @b1.c
    public Object writeReplace() {
        return new c(this);
    }

    @Override // f1.p3, f1.b5, f1.r6, f1.s6
    public t3<E> elementSet() {
        t3<E> t3Var = this.f5647e;
        if (t3Var != null) {
            return t3Var;
        }
        b bVar = new b();
        this.f5647e = bVar;
        return bVar;
    }
}
