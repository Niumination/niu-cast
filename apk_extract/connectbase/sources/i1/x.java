package i1;

import f1.h4;
import f1.x7;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.j(containerOf = {"N"})
public abstract class x<N> implements Iterable<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f7658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final N f7659b;

    public static final class b<N> extends x<N> {
        public b(N source, N target) {
            super(source, target);
        }

        @Override // i1.x
        public boolean b() {
            return true;
        }

        @Override // i1.x
        public boolean equals(@gm.a Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof x)) {
                return false;
            }
            x xVar = (x) obj;
            if (true != xVar.b()) {
                return false;
            }
            return this.f7658a.equals(xVar.k()) && this.f7659b.equals(xVar.l());
        }

        @Override // i1.x
        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f7658a, this.f7659b});
        }

        @Override // i1.x, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // i1.x
        public N k() {
            return this.f7658a;
        }

        @Override // i1.x
        public N l() {
            return this.f7659b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("<");
            sb2.append(this.f7658a);
            sb2.append(" -> ");
            return j.e.a(sb2, this.f7659b, ">");
        }

        public b(Object obj, Object obj2, a aVar) {
            super(obj, obj2);
        }
    }

    public static final class c<N> extends x<N> {
        public c(N nodeU, N nodeV) {
            super(nodeU, nodeV);
        }

        @Override // i1.x
        public boolean b() {
            return false;
        }

        @Override // i1.x
        public boolean equals(@gm.a Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof x)) {
                return false;
            }
            x xVar = (x) obj;
            if (xVar.b()) {
                return false;
            }
            if (this.f7658a.equals(xVar.f7658a)) {
                return this.f7659b.equals(xVar.f7659b);
            }
            return this.f7658a.equals(xVar.f7659b) && this.f7659b.equals(xVar.f7658a);
        }

        @Override // i1.x
        public int hashCode() {
            return this.f7659b.hashCode() + this.f7658a.hashCode();
        }

        @Override // i1.x, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // i1.x
        public N k() {
            throw new UnsupportedOperationException(f0.f7546l);
        }

        @Override // i1.x
        public N l() {
            throw new UnsupportedOperationException(f0.f7546l);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("[");
            sb2.append(this.f7658a);
            sb2.append(", ");
            return j.e.a(sb2, this.f7659b, "]");
        }

        public c(Object obj, Object obj2, a aVar) {
            super(obj, obj2);
        }
    }

    public static <N> x<N> g(c0<?> graph, N nodeU, N nodeV) {
        return graph.e() ? new b(nodeU, nodeV) : new c(nodeV, nodeU);
    }

    public static <N> x<N> i(w0<?, ?> network, N nodeU, N nodeV) {
        return network.e() ? new b(nodeU, nodeV) : new c(nodeV, nodeU);
    }

    public static <N> x<N> j(N source, N target) {
        return new b(source, target);
    }

    public static <N> x<N> m(N nodeU, N nodeV) {
        return new c(nodeV, nodeU);
    }

    public final N a(N node) {
        if (node.equals(this.f7658a)) {
            return this.f7659b;
        }
        if (node.equals(this.f7659b)) {
            return this.f7658a;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + node);
    }

    public abstract boolean b();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final x7<N> iterator() {
        return h4.C(new Object[]{this.f7658a, this.f7659b}, 0, 2, 0);
    }

    public final N e() {
        return this.f7658a;
    }

    public abstract boolean equals(@gm.a Object obj);

    public final N f() {
        return this.f7659b;
    }

    public abstract int hashCode();

    public abstract N k();

    public abstract N l();

    public x(N nodeU, N nodeV) {
        nodeU.getClass();
        this.f7658a = nodeU;
        nodeV.getClass();
        this.f7659b = nodeV;
    }
}
