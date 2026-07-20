package i1;

import f1.t3;
import f1.x7;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.f("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
public abstract class h1<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1<N> f7568a;

    public class a extends h1<N> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g1 f7569b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g1 successorFunction, final g1 val$graph) {
            super(successorFunction);
            this.f7569b = val$graph;
        }

        @Override // i1.h1
        public g<N> i() {
            return g.b(this.f7569b);
        }
    }

    public class b extends h1<N> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g1 f7570b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g1 successorFunction, final g1 val$tree) {
            super(successorFunction);
            this.f7570b = val$tree;
        }

        @Override // i1.h1
        public g<N> i() {
            return new g.b(this.f7570b);
        }
    }

    public class c implements Iterable<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t3 f7571a;

        public c(final t3 val$validated) {
            this.f7571a = val$validated;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            g<N> gVarI = h1.this.i();
            x7 it = this.f7571a.iterator();
            gVarI.getClass();
            return gVarI.f(it, f.BACK);
        }
    }

    public class d implements Iterable<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t3 f7573a;

        public d(final t3 val$validated) {
            this.f7573a = val$validated;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            g<N> gVarI = h1.this.i();
            x7 it = this.f7573a.iterator();
            gVarI.getClass();
            return gVarI.f(it, f.FRONT);
        }
    }

    public class e implements Iterable<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t3 f7575a;

        public e(final t3 val$validated) {
            this.f7575a = val$validated;
        }

        @Override // java.lang.Iterable
        public Iterator<N> iterator() {
            return h1.this.i().d(this.f7575a.iterator());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class f {
        public static final f FRONT = new a("FRONT", 0);
        public static final f BACK = new b("BACK", 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ f[] f7577a = a();

        public final enum a extends f {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // i1.h1.f
            public <T> void insertInto(Deque<T> deque, T value) {
                deque.addFirst(value);
            }
        }

        public final enum b extends f {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // i1.h1.f
            public <T> void insertInto(Deque<T> deque, T value) {
                deque.addLast(value);
            }
        }

        public f(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ f[] a() {
            return new f[]{FRONT, BACK};
        }

        public static f valueOf(String name) {
            return (f) Enum.valueOf(f.class, name);
        }

        public static f[] values() {
            return (f[]) f7577a.clone();
        }

        public abstract <T> void insertInto(Deque<T> deque, T value);

        public f(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static abstract class g<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g1<N> f7578a;

        public class a extends g<N> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Set f7579b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g1 successorFunction, final Set val$visited) {
                super(successorFunction);
                this.f7579b = val$visited;
            }

            @Override // i1.h1.g
            @gm.a
            public N g(Deque<Iterator<? extends N>> horizon) {
                Iterator<? extends N> first = horizon.getFirst();
                while (first.hasNext()) {
                    N next = first.next();
                    Objects.requireNonNull(next);
                    if (this.f7579b.add(next)) {
                        return next;
                    }
                }
                horizon.removeFirst();
                return null;
            }
        }

        public class b extends g<N> {
            public b(g1 successorFunction) {
                super(successorFunction);
            }

            @Override // i1.h1.g
            @gm.a
            public N g(Deque<Iterator<? extends N>> horizon) {
                Iterator<? extends N> first = horizon.getFirst();
                if (!first.hasNext()) {
                    horizon.removeFirst();
                    return null;
                }
                N next = first.next();
                next.getClass();
                return next;
            }
        }

        public class c extends f1.c<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Deque f7580c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f7581d;

            public c(final Deque val$horizon, final f val$order) {
                this.f7580c = val$horizon;
                this.f7581d = val$order;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // f1.c
            @gm.a
            public N a() {
                do {
                    N n10 = (N) g.this.g(this.f7580c);
                    if (n10 != null) {
                        Iterator<? extends N> it = g.this.f7578a.b(n10).iterator();
                        if (it.hasNext()) {
                            this.f7581d.insertInto(this.f7580c, it);
                        }
                        return n10;
                    }
                } while (!this.f7580c.isEmpty());
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public class d extends f1.c<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Deque f7583c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Deque f7584d;

            public d(final Deque val$horizon, final Deque val$ancestorStack) {
                this.f7583c = val$horizon;
                this.f7584d = val$ancestorStack;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // f1.c
            @gm.a
            public N a() {
                while (true) {
                    N n10 = (N) g.this.g(this.f7583c);
                    if (n10 == null) {
                        if (!this.f7584d.isEmpty()) {
                            return (N) this.f7584d.pop();
                        }
                        this.f4711a = f1.c.b.DONE;
                        return null;
                    }
                    Iterator<? extends N> it = g.this.f7578a.b(n10).iterator();
                    if (!it.hasNext()) {
                        return n10;
                    }
                    this.f7583c.addFirst(it);
                    this.f7584d.push(n10);
                }
            }
        }

        public g(g1<N> successorFunction) {
            this.f7578a = successorFunction;
        }

        public static <N> g<N> b(g1<N> graph) {
            return new a(graph, new HashSet());
        }

        public static <N> g<N> c(g1<N> tree) {
            return new b(tree);
        }

        public final Iterator<N> a(Iterator<? extends N> startNodes) {
            return f(startNodes, f.BACK);
        }

        public final Iterator<N> d(Iterator<? extends N> startNodes) {
            ArrayDeque arrayDeque = new ArrayDeque();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(startNodes);
            return new d(arrayDeque2, arrayDeque);
        }

        public final Iterator<N> e(Iterator<? extends N> startNodes) {
            return f(startNodes, f.FRONT);
        }

        public final Iterator<N> f(Iterator<? extends N> startNodes, f order) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(startNodes);
            return new c(arrayDeque, order);
        }

        @gm.a
        public abstract N g(Deque<Iterator<? extends N>> horizon);
    }

    public /* synthetic */ h1(g1 g1Var, a aVar) {
        this(g1Var);
    }

    public static <N> h1<N> g(g1<N> graph) {
        return new a(graph, graph);
    }

    public static <N> h1<N> h(g1<N> tree) {
        if (tree instanceof n) {
            c1.h0.e(((n) tree).e(), "Undirected graphs can never be trees.");
        }
        if (tree instanceof w0) {
            c1.h0.e(((w0) tree).e(), "Undirected networks can never be trees.");
        }
        return new b(tree, tree);
    }

    public final Iterable<N> a(Iterable<? extends N> startNodes) {
        return new c(j(startNodes));
    }

    public final Iterable<N> b(N startNode) {
        return a(t3.of(startNode));
    }

    public final Iterable<N> c(Iterable<? extends N> startNodes) {
        return new e(j(startNodes));
    }

    public final Iterable<N> d(N startNode) {
        return c(t3.of(startNode));
    }

    public final Iterable<N> e(Iterable<? extends N> startNodes) {
        return new d(j(startNodes));
    }

    public final Iterable<N> f(N startNode) {
        return e(t3.of(startNode));
    }

    public abstract g<N> i();

    public final t3<N> j(Iterable<? extends N> startNodes) {
        t3<N> t3VarCopyOf = t3.copyOf(startNodes);
        x7<N> it = t3VarCopyOf.iterator();
        while (it.hasNext()) {
            this.f7568a.b(it.next());
        }
        return t3VarCopyOf;
    }

    public h1(g1<N> successorFunction) {
        successorFunction.getClass();
        this.f7568a = successorFunction;
    }
}
