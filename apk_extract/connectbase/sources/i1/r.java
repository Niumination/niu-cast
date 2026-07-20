package i1;

import f1.h4;
import f1.i3;
import f1.x7;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@w
public final class r<N, V> implements e0<N, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f7621e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<N, Object> f7622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public final List<f<N>> f7623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7625d;

    public class a extends AbstractSet<N> {

        /* JADX INFO: renamed from: i1.r$a$a, reason: collision with other inner class name */
        public class C0209a extends f1.c<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f7627c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Set f7628d;

            public C0209a(final a this$1, final Iterator val$nodeConnections, final Set val$seenNodes) {
                this.f7627c = val$nodeConnections;
                this.f7628d = val$seenNodes;
            }

            @Override // f1.c
            @gm.a
            public N a() {
                while (this.f7627c.hasNext()) {
                    f fVar = (f) this.f7627c.next();
                    if (this.f7628d.add(fVar.f7638a)) {
                        return fVar.f7638a;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x7<N> iterator() {
            return new C0209a(this, r.this.f7623b.iterator(), new HashSet());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object obj) {
            return r.this.f7622a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r.this.f7622a.size();
        }
    }

    public class b extends AbstractSet<N> {

        public class a extends f1.c<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f7630c;

            public a(final b this$1, final Iterator val$entries) {
                this.f7630c = val$entries;
            }

            @Override // f1.c
            @gm.a
            public N a() {
                while (this.f7630c.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f7630c.next();
                    if (r.s(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        /* JADX INFO: renamed from: i1.r$b$b, reason: collision with other inner class name */
        public class C0210b extends f1.c<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f7631c;

            public C0210b(final b this$1, final Iterator val$nodeConnections) {
                this.f7631c = val$nodeConnections;
            }

            @Override // f1.c
            @gm.a
            public N a() {
                while (this.f7631c.hasNext()) {
                    f fVar = (f) this.f7631c.next();
                    if (fVar instanceof f.a) {
                        return fVar.f7638a;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x7<N> iterator() {
            return r.this.f7623b == null ? new a(this, r.this.f7622a.entrySet().iterator()) : new C0210b(this, r.this.f7623b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object obj) {
            return r.s(r.this.f7622a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r.this.f7624c;
        }
    }

    public class c extends AbstractSet<N> {

        public class a extends f1.c<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f7633c;

            public a(final c this$1, final Iterator val$entries) {
                this.f7633c = val$entries;
            }

            @Override // f1.c
            @gm.a
            public N a() {
                while (this.f7633c.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f7633c.next();
                    if (r.t(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public class b extends f1.c<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f7634c;

            public b(final c this$1, final Iterator val$nodeConnections) {
                this.f7634c = val$nodeConnections;
            }

            @Override // f1.c
            @gm.a
            public N a() {
                while (this.f7634c.hasNext()) {
                    f fVar = (f) this.f7634c.next();
                    if (fVar instanceof f.b) {
                        return fVar.f7638a;
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x7<N> iterator() {
            return r.this.f7623b == null ? new a(this, r.this.f7622a.entrySet().iterator()) : new b(this, r.this.f7623b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object obj) {
            return r.t(r.this.f7622a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r.this.f7625d;
        }
    }

    public class d extends f1.c<x<N>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f7635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f7636d;

        public d(final r this$0, final Iterator val$resultWithDoubleSelfLoop, final AtomicBoolean val$alreadySeenSelfLoop) {
            this.f7635c = val$resultWithDoubleSelfLoop;
            this.f7636d = val$alreadySeenSelfLoop;
        }

        @Override // f1.c
        @gm.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public x<N> a() {
            while (this.f7635c.hasNext()) {
                x<N> xVar = (x) this.f7635c.next();
                if (!xVar.f7658a.equals(xVar.f7659b) || !this.f7636d.getAndSet(true)) {
                    return xVar;
                }
            }
            this.f4711a = f1.c.b.DONE;
            return null;
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7637a;

        static {
            int[] iArr = new int[v.b.values().length];
            f7637a = iArr;
            try {
                iArr[v.b.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7637a[v.b.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class f<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final N f7638a;

        public static final class a<N> extends f<N> {
            public a(N node) {
                super(node);
            }

            public boolean equals(@gm.a Object that) {
                if (that instanceof a) {
                    return this.f7638a.equals(((a) that).f7638a);
                }
                return false;
            }

            public int hashCode() {
                return this.f7638a.hashCode() + a.class.hashCode();
            }
        }

        public static final class b<N> extends f<N> {
            public b(N node) {
                super(node);
            }

            public boolean equals(@gm.a Object that) {
                if (that instanceof b) {
                    return this.f7638a.equals(((b) that).f7638a);
                }
                return false;
            }

            public int hashCode() {
                return this.f7638a.hashCode() + b.class.hashCode();
            }
        }

        public f(N node) {
            node.getClass();
            this.f7638a = node;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7639a;

        public g(Object successorValue) {
            this.f7639a = successorValue;
        }
    }

    public r(Map<N, Object> adjacentNodeValues, @gm.a List<f<N>> orderedNodeConnections, int predecessorCount, int successorCount) {
        adjacentNodeValues.getClass();
        this.f7622a = adjacentNodeValues;
        this.f7623b = orderedNodeConnections;
        this.f7624c = g0.b(predecessorCount);
        this.f7625d = g0.b(successorCount);
        c1.h0.g0(predecessorCount <= adjacentNodeValues.size() && successorCount <= adjacentNodeValues.size());
    }

    public static x j(Object obj, Object obj2) {
        return new x.b(obj2, obj);
    }

    public static x l(Object obj, Object obj2) {
        return new x.b(obj, obj2);
    }

    public static boolean s(@gm.a Object value) {
        return value == f7621e || (value instanceof g);
    }

    public static boolean t(@gm.a Object value) {
        return (value == f7621e || value == null) ? false : true;
    }

    public static x u(Object obj, Object obj2) {
        return new x.b(obj2, obj);
    }

    public static x v(Object obj, Object obj2) {
        return new x.b(obj, obj2);
    }

    public static x w(Object obj, f fVar) {
        return fVar instanceof f.b ? new x.b(obj, fVar.f7638a) : new x.b(fVar.f7638a, obj);
    }

    public static <N, V> r<N, V> x(v<N> incidentEdgeOrder) {
        ArrayList arrayList;
        int i10 = e.f7637a[incidentEdgeOrder.f7654a.ordinal()];
        if (i10 == 1) {
            arrayList = null;
        } else {
            if (i10 != 2) {
                throw new AssertionError(incidentEdgeOrder.f7654a);
            }
            arrayList = new ArrayList();
        }
        return new r<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> r<N, V> y(N thisNode, Iterable<x<N>> incidentEdges, c1.t<N, V> successorNodeToValueFn) {
        thisNode.getClass();
        successorNodeToValueFn.getClass();
        HashMap map = new HashMap();
        i3.a aVarBuilder = i3.builder();
        int i10 = 0;
        int i11 = 0;
        for (x<N> xVar : incidentEdges) {
            if (xVar.f7658a.equals(thisNode) && xVar.f7659b.equals(thisNode)) {
                map.put(thisNode, new g(successorNodeToValueFn.apply(thisNode)));
                aVarBuilder.j(new f.a(thisNode));
                aVarBuilder.j(new f.b(thisNode));
                i10++;
            } else if (xVar.f7659b.equals(thisNode)) {
                N n10 = xVar.f7658a;
                Object objPut = map.put(n10, f7621e);
                if (objPut != null) {
                    map.put(n10, new g(objPut));
                }
                aVarBuilder.j(new f.a(n10));
                i10++;
            } else {
                c1.h0.d(xVar.f7658a.equals(thisNode));
                N n11 = xVar.f7659b;
                V vApply = successorNodeToValueFn.apply(n11);
                Object objPut2 = map.put(n11, vApply);
                if (objPut2 != null) {
                    c1.h0.d(objPut2 == f7621e);
                    map.put(n11, new g(vApply));
                }
                aVarBuilder.j(new f.b(n11));
            }
            i11++;
        }
        return new r<>(map, aVarBuilder.e(), i10, i11);
    }

    @Override // i1.e0
    public Set<N> a() {
        return new c();
    }

    @Override // i1.e0
    public Set<N> b() {
        return new b();
    }

    @Override // i1.e0
    public Set<N> c() {
        return this.f7623b == null ? Collections.unmodifiableSet(this.f7622a.keySet()) : new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e0
    @gm.a
    public V d(N n10) {
        n10.getClass();
        V v10 = (V) this.f7622a.get(n10);
        if (v10 == f7621e) {
            return null;
        }
        return v10 instanceof g ? (V) ((g) v10).f7639a : v10;
    }

    @Override // i1.e0
    @gm.a
    public V e(Object obj) {
        Object obj2;
        obj.getClass();
        Object obj3 = this.f7622a.get(obj);
        if (obj3 == null || obj3 == (obj2 = f7621e)) {
            obj3 = null;
        } else if (obj3 instanceof g) {
            this.f7622a.put(obj, obj2);
            obj3 = ((g) obj3).f7639a;
        } else {
            this.f7622a.remove(obj);
        }
        if (obj3 != null) {
            int i10 = this.f7625d - 1;
            this.f7625d = i10;
            g0.b(i10);
            List<f<N>> list = this.f7623b;
            if (list != null) {
                list.remove(new f.b(obj));
            }
        }
        if (obj3 == null) {
            return null;
        }
        return (V) obj3;
    }

    @Override // i1.e0
    public void f(N node) {
        node.getClass();
        Object obj = this.f7622a.get(node);
        if (obj == f7621e) {
            this.f7622a.remove(node);
        } else if (!(obj instanceof g)) {
            return;
        } else {
            this.f7622a.put(node, ((g) obj).f7639a);
        }
        int i10 = this.f7624c - 1;
        this.f7624c = i10;
        g0.b(i10);
        List<f<N>> list = this.f7623b;
        if (list != null) {
            list.remove(new f.a(node));
        }
    }

    @Override // i1.e0
    public Iterator<x<N>> g(final N thisNode) {
        thisNode.getClass();
        List<f<N>> list = this.f7623b;
        return new d(this, list == null ? h4.j(h4.c0(new b().iterator(), new c1.t() { // from class: i1.o
            @Override // c1.t
            public final Object apply(Object obj) {
                return r.j(thisNode, obj);
            }
        }), h4.c0(new c().iterator(), new c1.t() { // from class: i1.p
            @Override // c1.t
            public final Object apply(Object obj) {
                return r.l(thisNode, obj);
            }
        })) : h4.c0(list.iterator(), new c1.t() { // from class: i1.q
            @Override // c1.t
            public final Object apply(Object obj) {
                return r.w(thisNode, (r.f) obj);
            }
        }), new AtomicBoolean(false));
    }

    @Override // i1.e0
    @gm.a
    public V h(N n10, V v10) {
        Object objPut = this.f7622a.put(n10, v10);
        if (objPut == null) {
            objPut = null;
        } else if (objPut instanceof g) {
            this.f7622a.put(n10, new g(v10));
            objPut = ((g) objPut).f7639a;
        } else if (objPut == f7621e) {
            this.f7622a.put(n10, new g(v10));
            objPut = null;
        }
        if (objPut == null) {
            int i10 = this.f7625d + 1;
            this.f7625d = i10;
            g0.d(i10);
            List<f<N>> list = this.f7623b;
            if (list != null) {
                list.add(new f.b(n10));
            }
        }
        if (objPut == null) {
            return null;
        }
        return (V) objPut;
    }

    @Override // i1.e0
    public void i(N node, V unused) {
        Map<N, Object> map = this.f7622a;
        Object obj = f7621e;
        Object objPut = map.put(node, obj);
        if (objPut != null) {
            if (objPut instanceof g) {
                this.f7622a.put(node, objPut);
                return;
            } else if (objPut == obj) {
                return;
            } else {
                this.f7622a.put(node, new g(objPut));
            }
        }
        int i10 = this.f7624c + 1;
        this.f7624c = i10;
        g0.d(i10);
        List<f<N>> list = this.f7623b;
        if (list != null) {
            list.add(new f.a(node));
        }
    }
}
