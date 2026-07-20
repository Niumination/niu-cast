package f1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
@t1.f("Use ImmutableClassToInstanceMap or MutableClassToInstanceMap")
public interface a0<B> extends Map<Class<? extends B>, B> {
    @gm.a
    <T extends B> T getInstance(Class<T> type);

    @gm.a
    @t1.a
    <T extends B> T putInstance(Class<T> type, @m5 T value);
}
