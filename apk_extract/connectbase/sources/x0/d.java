package x0;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static <T> List<a1.a<T>> a(y0.c cVar, float f10, n0.g gVar, k0<T> k0Var) throws IOException {
        return r.a(cVar, gVar, f10, k0Var, false);
    }

    public static <T> List<a1.a<T>> b(y0.c cVar, n0.g gVar, k0<T> k0Var) throws IOException {
        return r.a(cVar, gVar, 1.0f, k0Var, false);
    }

    public static t0.a c(y0.c cVar, n0.g gVar) throws IOException {
        return new t0.a(b(cVar, gVar, f.f19901a));
    }

    public static t0.j d(y0.c cVar, n0.g gVar) throws IOException {
        return new t0.j(b(cVar, gVar, h.f19905a));
    }

    public static t0.b e(y0.c cVar, n0.g gVar) throws IOException {
        return f(cVar, gVar, true);
    }

    public static t0.b f(y0.c cVar, n0.g gVar, boolean z10) throws IOException {
        return new t0.b(r.a(cVar, gVar, z10 ? z0.h.e() : 1.0f, i.f19908a, false));
    }

    public static t0.c g(y0.c cVar, n0.g gVar, int i10) throws IOException {
        return new t0.c(b(cVar, gVar, new l(i10)));
    }

    public static t0.d h(y0.c cVar, n0.g gVar) throws IOException {
        return new t0.d(b(cVar, gVar, o.f19921a));
    }

    public static t0.f i(y0.c cVar, n0.g gVar) throws IOException {
        return new t0.f(r.a(cVar, gVar, z0.h.e(), z.f19941a, true));
    }

    public static t0.g j(y0.c cVar, n0.g gVar) throws IOException {
        return new t0.g(b(cVar, gVar, d0.f19897a));
    }

    public static t0.h k(y0.c cVar, n0.g gVar) throws IOException {
        return new t0.h(r.a(cVar, gVar, z0.h.e(), e0.f19899a, false));
    }
}
