package f1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes.dex */
@a3
@b1.b
@x0
public final class l7 {

    public static final class b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c<R, C, V>> f5090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z6<R, C, c<R, C, V>> f5091b;

        public b() {
            this.f5090a = new ArrayList();
            this.f5091b = u2.create();
        }

        public b<R, C, V> a(b<R, C, V> other, BinaryOperator<V> merger) {
            for (c<R, C, V> cVar : other.f5090a) {
                b(cVar.f5092a, cVar.f5093b, cVar.f5094c, merger);
            }
            return this;
        }

        public void b(R row, C column, V value, BinaryOperator<V> merger) {
            c<R, C, V> cVar = this.f5091b.get(row, column);
            if (cVar != null) {
                cVar.a(value, merger);
                return;
            }
            c<R, C, V> cVar2 = new c<>(row, column, value);
            this.f5090a.add(cVar2);
            this.f5091b.put(row, column, cVar2);
        }

        public c4<R, C, V> c() {
            return c4.copyOf(this.f5090a);
        }
    }

    @a3
    public static final class c<R, C, V> extends m7.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f5092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C f5093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public V f5094c;

        public c(R r10, C c10, V v10) {
            this.f5092a = (R) c1.h0.F(r10, "row");
            this.f5093b = (C) c1.h0.F(c10, "column");
            this.f5094c = (V) c1.h0.F(v10, "value");
        }

        public void a(V v10, BinaryOperator<V> binaryOperator) {
            c1.h0.F(v10, "value");
            this.f5094c = (V) c1.h0.F(binaryOperator.apply(this.f5094c, v10), "mergeFunction.apply");
        }

        @Override // f1.z6.a
        public C getColumnKey() {
            return this.f5093b;
        }

        @Override // f1.z6.a
        public R getRowKey() {
            return this.f5092a;
        }

        @Override // f1.z6.a
        public V getValue() {
            return this.f5094c;
        }
    }

    public static c4 d(b bVar) {
        return c4.copyOf(bVar.f5090a);
    }

    public static /* synthetic */ b f() {
        return new b();
    }

    public static /* synthetic */ void i(Function function, Function function2, Function function3, c4.a aVar, Object obj) {
        aVar.g(function.apply(obj), function2.apply(obj), function3.apply(obj));
    }

    public static /* synthetic */ b j() {
        return new b();
    }

    public static /* synthetic */ void k(Function function, Function function2, Function function3, BinaryOperator binaryOperator, b bVar, Object obj) {
        bVar.b(function.apply(obj), function2.apply(obj), function3.apply(obj), binaryOperator);
    }

    public static c4 m(b bVar) {
        return c4.copyOf(bVar.f5090a);
    }

    public static /* synthetic */ Object n(Object obj, Object obj2) {
        throw new IllegalStateException("Conflicting values " + obj + " and " + obj2);
    }

    public static /* synthetic */ void o(Function function, Function function2, Function function3, BinaryOperator binaryOperator, z6 z6Var, Object obj) {
        q(z6Var, function.apply(obj), function2.apply(obj), function3.apply(obj), binaryOperator);
    }

    public static /* synthetic */ z6 p(BinaryOperator binaryOperator, z6 z6Var, z6 z6Var2) {
        for (z6.a aVar : z6Var2.cellSet()) {
            q(z6Var, aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue(), binaryOperator);
        }
        return z6Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, C, V> void q(z6<R, C, V> table, @m5 R row, @m5 C column, @m5 V value, BinaryOperator<V> mergeFunction) {
        value.getClass();
        V v10 = table.get(row, column);
        if (v10 == null) {
            table.put(row, column, value);
            return;
        }
        Object objApply = mergeFunction.apply(v10, value);
        if (objApply == null) {
            table.remove(row, column);
        } else {
            table.put(row, column, objApply);
        }
    }

    public static <T, R, C, V> Collector<T, ?, c4<R, C, V>> r(final Function<? super T, ? extends R> rowFunction, final Function<? super T, ? extends C> columnFunction, final Function<? super T, ? extends V> valueFunction) {
        c1.h0.F(rowFunction, "rowFunction");
        c1.h0.F(columnFunction, "columnFunction");
        c1.h0.F(valueFunction, "valueFunction");
        return Collector.of(new i7(), new BiConsumer() { // from class: f1.j7
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                l7.i(rowFunction, columnFunction, valueFunction, (c4.a) obj, obj2);
            }
        }, new k7(), new b7(), new Collector.Characteristics[0]);
    }

    public static <T, R, C, V> Collector<T, ?, c4<R, C, V>> s(final Function<? super T, ? extends R> rowFunction, final Function<? super T, ? extends C> columnFunction, final Function<? super T, ? extends V> valueFunction, final BinaryOperator<V> mergeFunction) {
        c1.h0.F(rowFunction, "rowFunction");
        c1.h0.F(columnFunction, "columnFunction");
        c1.h0.F(valueFunction, "valueFunction");
        c1.h0.F(mergeFunction, "mergeFunction");
        return Collector.of(new e7(), new BiConsumer() { // from class: f1.f7
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                l7.k(rowFunction, columnFunction, valueFunction, mergeFunction, (l7.b) obj, obj2);
            }
        }, new BinaryOperator() { // from class: f1.g7
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((l7.b) obj).a((l7.b) obj2, mergeFunction);
            }
        }, new h7(), new Collector.Characteristics[0]);
    }

    public static <T, R, C, V, I extends z6<R, C, V>> Collector<T, ?, I> t(final Function<? super T, ? extends R> rowFunction, final Function<? super T, ? extends C> columnFunction, final Function<? super T, ? extends V> valueFunction, final BinaryOperator<V> mergeFunction, Supplier<I> tableSupplier) {
        rowFunction.getClass();
        columnFunction.getClass();
        valueFunction.getClass();
        mergeFunction.getClass();
        tableSupplier.getClass();
        return Collector.of(tableSupplier, new BiConsumer() { // from class: f1.c7
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                l7.o(rowFunction, columnFunction, valueFunction, mergeFunction, (z6) obj, obj2);
            }
        }, new BinaryOperator() { // from class: f1.d7
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return l7.p(mergeFunction, (z6) obj, (z6) obj2);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, R, C, V, I extends z6<R, C, V>> Collector<T, ?, I> u(Function<? super T, ? extends R> rowFunction, Function<? super T, ? extends C> columnFunction, Function<? super T, ? extends V> valueFunction, Supplier<I> tableSupplier) {
        return t(rowFunction, columnFunction, valueFunction, new a7(), tableSupplier);
    }
}
