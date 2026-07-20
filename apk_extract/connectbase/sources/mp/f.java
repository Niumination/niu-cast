package mp;

import eo.y0;
import java.util.Collection;
import java.util.List;
import nm.k0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f10869a = a.f10870a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f10870a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public static final mp.a f10871b = new mp.a(k0.INSTANCE);

        @l
        public final mp.a a() {
            return f10871b;
        }
    }

    @l
    List<dp.f> a(@l eo.e eVar);

    void b(@l eo.e eVar, @l dp.f fVar, @l Collection<y0> collection);

    void c(@l eo.e eVar, @l List<eo.d> list);

    void d(@l eo.e eVar, @l dp.f fVar, @l Collection<y0> collection);

    @l
    List<dp.f> e(@l eo.e eVar);
}
