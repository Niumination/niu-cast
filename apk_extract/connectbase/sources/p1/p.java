package p1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@d
@t1.f("Use ImmutableTypeToInstanceMap or MutableTypeToInstanceMap")
public interface p<B> extends Map<q<? extends B>, B> {
    @gm.a
    <T extends B> T getInstance(Class<T> type);

    @gm.a
    <T extends B> T n(q<T> type);

    @gm.a
    @t1.a
    <T extends B> T o(q<T> type, @k T value);

    @gm.a
    @t1.a
    <T extends B> T putInstance(Class<T> type, @k T value);
}
