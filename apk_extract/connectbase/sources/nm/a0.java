package nm;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class a0 extends z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Enumeration<T> f11608a;

        public a(Enumeration<T> enumeration) {
            this.f11608a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11608a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f11608a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @os.l
    public static <T> Iterator<T> f0(@os.l Enumeration<T> enumeration) {
        kn.l0.p(enumeration, "<this>");
        return new a(enumeration);
    }
}
