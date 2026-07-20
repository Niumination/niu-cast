package un;

import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public interface q<T, V> extends o<V>, jn.l<T, V> {

    public static final class a {
        public static /* synthetic */ void a() {
        }
    }

    public interface b<T, V> extends o.c<V>, jn.l<T, V> {
    }

    V get(T t10);

    @os.m
    @f1(version = "1.1")
    Object getDelegate(T t10);

    @Override // un.o
    @os.l
    b<T, V> getGetter();
}
