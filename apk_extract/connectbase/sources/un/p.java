package un;

import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public interface p<V> extends o<V>, jn.a<V> {

    public static final class a {
        public static /* synthetic */ void a() {
        }
    }

    public interface b<V> extends o.c<V>, jn.a<V> {
    }

    V get();

    @os.m
    @f1(version = "1.1")
    Object getDelegate();

    @Override // un.o
    @os.l
    b<V> getGetter();
}
