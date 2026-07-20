package i1;

import f1.k6;
import f1.t3;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class y<N> extends f1.c<x<N>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n<N> f7663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Iterator<N> f7664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.a
    public N f7665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Iterator<N> f7666f;

    public static final class b<N> extends y<N> {
        public b(n<N> graph) {
            super(graph);
        }

        @Override // f1.c
        @gm.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public x<N> a() {
            while (!this.f7666f.hasNext()) {
                if (!d()) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
            }
            N n10 = this.f7665e;
            Objects.requireNonNull(n10);
            return new x.b(n10, this.f7666f.next());
        }

        public b(n nVar, a aVar) {
            super(nVar);
        }
    }

    public static final class c<N> extends y<N> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @gm.a
        public Set<N> f7667g;

        public c(n<N> graph) {
            super(graph);
            this.f7667g = k6.y(graph.m().size() + 1);
        }

        @Override // f1.c
        @gm.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public x<N> a() {
            do {
                Objects.requireNonNull(this.f7667g);
                while (this.f7666f.hasNext()) {
                    N next = this.f7666f.next();
                    if (!this.f7667g.contains(next)) {
                        N n10 = this.f7665e;
                        Objects.requireNonNull(n10);
                        return new x.c(next, n10);
                    }
                }
                this.f7667g.add(this.f7665e);
            } while (d());
            this.f7667g = null;
            this.f4711a = f1.c.b.DONE;
            return null;
        }
    }

    public static <N> y<N> e(n<N> graph) {
        return graph.e() ? new b(graph) : new c(graph);
    }

    public final boolean d() {
        c1.h0.g0(!this.f7666f.hasNext());
        if (!this.f7664d.hasNext()) {
            return false;
        }
        N next = this.f7664d.next();
        this.f7665e = next;
        this.f7666f = this.f7663c.b((Object) next).iterator();
        return true;
    }

    public y(n<N> graph) {
        this.f7665e = null;
        this.f7666f = t3.of().iterator();
        this.f7663c = graph;
        this.f7664d = graph.m().iterator();
    }
}
