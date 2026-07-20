package f1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
@t1.f("Use Maps.difference")
public interface q4<K, V> {

    @t1.f("Use Maps.difference")
    public interface a<V> {
        @m5
        V a();

        @m5
        V b();

        boolean equals(@gm.a Object other);

        int hashCode();
    }

    Map<K, V> a();

    Map<K, V> b();

    Map<K, a<V>> c();

    Map<K, V> d();

    boolean e();

    boolean equals(@gm.a Object object);

    int hashCode();
}
