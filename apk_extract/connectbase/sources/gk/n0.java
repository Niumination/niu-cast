package gk;

import java.util.Iterator;
import java.util.Map;
import nq.n3;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements n3<Map<String, ? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<String, String> f6680a;

    public static final class a implements um.g.c<n0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f6681a = new a();
    }

    public n0(@os.l Map<String, String> map) {
        kn.l0.p(map, "mdc");
        this.f6680a = nm.d1.o0(d(), map);
    }

    public final Map<String, String> d() {
        Map<String, String> mapD = ps.c.d();
        Map<String, String> mapF0 = mapD == null ? null : nm.d1.F0(mapD);
        return mapF0 == null ? nm.d1.z() : mapF0;
    }

    public final void e(Map<String, String> map) {
        ps.c.b();
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ps.c.f((String) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // nq.n3
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void D1(@os.l um.g gVar, @os.l Map<String, String> map) {
        kn.l0.p(gVar, "context");
        kn.l0.p(map, "oldState");
        e(map);
    }

    @Override // um.g.b, um.g
    public <R> R fold(R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
        return (R) um.g.b.a.a(this, r10, pVar);
    }

    @Override // nq.n3
    @os.l
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Map<String, String> u0(@os.l um.g gVar) {
        kn.l0.p(gVar, "context");
        Map<String, String> mapD = d();
        e(this.f6680a);
        return mapD;
    }

    @Override // um.g.b, um.g
    @os.m
    public <E extends um.g.b> E get(@os.l um.g.c<E> cVar) {
        return (E) um.g.b.a.b(this, cVar);
    }

    @Override // um.g.b
    @os.l
    public um.g.c<?> getKey() {
        return a.f6681a;
    }

    @Override // um.g.b, um.g
    @os.l
    public um.g minusKey(@os.l um.g.c<?> cVar) {
        return um.g.b.a.c(this, cVar);
    }

    @Override // um.g
    @os.l
    public um.g plus(@os.l um.g gVar) {
        return um.g.b.a.d(this, gVar);
    }
}
