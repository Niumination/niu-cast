package un;

import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public interface r<D, E, V> extends o<V>, jn.p<D, E, V> {

    public static final class a {
        public static /* synthetic */ void a() {
        }
    }

    public interface b<D, E, V> extends o.c<V>, jn.p<D, E, V> {
    }

    V get(D d10, E e10);

    @os.m
    @f1(version = "1.1")
    Object getDelegate(D d10, E e10);

    @Override // un.o
    @os.l
    b<D, E, V> getGetter();
}
