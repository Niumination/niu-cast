package on;

import gq.g;
import gq.m;
import gq.s;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kn.l0;
import lm.f1;
import lm.p2;
import lm.r;
import nm.k0;
import nm.m0;
import nm.n1;
import nm.x;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    @f1(version = "1.8")
    @p2(markerClass = {r.class})
    @l
    public static final <T> m<T> a(@l Optional<? extends T> optional) {
        l0.p(optional, "<this>");
        return optional.isPresent() ? s.q(optional.get()) : g.f6836a;
    }

    @f1(version = "1.8")
    @p2(markerClass = {r.class})
    public static final <T> T b(@l Optional<? extends T> optional, T t10) {
        l0.p(optional, "<this>");
        return optional.isPresent() ? optional.get() : t10;
    }

    @f1(version = "1.8")
    @p2(markerClass = {r.class})
    public static final <T> T c(@l Optional<? extends T> optional, @l jn.a<? extends T> aVar) {
        l0.p(optional, "<this>");
        l0.p(aVar, "defaultValue");
        return optional.isPresent() ? optional.get() : aVar.invoke();
    }

    @os.m
    @f1(version = "1.8")
    @p2(markerClass = {r.class})
    public static final <T> T d(@l Optional<T> optional) {
        l0.p(optional, "<this>");
        return optional.orElse(null);
    }

    @f1(version = "1.8")
    @p2(markerClass = {r.class})
    @l
    public static final <T, C extends Collection<? super T>> C e(@l Optional<T> optional, @l C c10) {
        l0.p(optional, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        if (optional.isPresent()) {
            T t10 = optional.get();
            l0.o(t10, "get(...)");
            c10.add(t10);
        }
        return c10;
    }

    @f1(version = "1.8")
    @p2(markerClass = {r.class})
    @l
    public static final <T> List<T> f(@l Optional<? extends T> optional) {
        l0.p(optional, "<this>");
        return optional.isPresent() ? x.k(optional.get()) : k0.INSTANCE;
    }

    @f1(version = "1.8")
    @p2(markerClass = {r.class})
    @l
    public static final <T> Set<T> g(@l Optional<? extends T> optional) {
        l0.p(optional, "<this>");
        return optional.isPresent() ? n1.f(optional.get()) : m0.INSTANCE;
    }
}
