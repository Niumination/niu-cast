package gq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.d1;
import lm.f1;
import lm.l2;
import lm.t0;
import nm.d0;

/* JADX INFO: loaded from: classes3.dex */
public class s extends r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n*L\n1#1,680:1\n*E\n"})
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.a<Iterator<T>> f6875a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.a<? extends Iterator<? extends T>> aVar) {
            this.f6875a = aVar;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            return this.f6875a.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt\n*L\n1#1,680:1\n30#2:681\n*E\n"})
    public static final class b<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f6876a;

        public b(Iterator it) {
            this.f6876a = it;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            return this.f6876a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @xm.f(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
    public static final class c<R> extends xm.k implements jn.p<o<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.l<C, Iterator<R>> $iterator;
        final /* synthetic */ m<T> $source;
        final /* synthetic */ jn.p<Integer, T, C> $transform;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(m<? extends T> mVar, jn.p<? super Integer, ? super T, ? extends C> pVar, jn.l<? super C, ? extends Iterator<? extends R>> lVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.$source = mVar;
            this.$transform = pVar;
            this.$iterator = lVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$source, this.$transform, this.$iterator, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l o<? super R> oVar, @os.m um.d<? super l2> dVar) {
            return ((c) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            o oVar;
            int i10;
            Iterator it;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = this.label;
            if (i11 == 0) {
                d1.n(obj);
                oVar = (o) this.L$0;
                i10 = 0;
                it = this.$source.iterator();
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i12 = this.I$0;
                it = (Iterator) this.L$1;
                oVar = (o) this.L$0;
                d1.n(obj);
                i10 = i12;
            }
            while (it.hasNext()) {
                Object next = it.next();
                jn.p<Integer, T, C> pVar = this.$transform;
                int i13 = i10 + 1;
                if (i10 < 0) {
                    nm.y.Z();
                }
                Iterator<R> itInvoke = this.$iterator.invoke((C) pVar.invoke(new Integer(i10), (T) next));
                this.L$0 = oVar;
                this.L$1 = it;
                this.I$0 = i13;
                this.label = 1;
                if (oVar.i(itInvoke, this) == aVar) {
                    return aVar;
                }
                i10 = i13;
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> extends n0 implements jn.l<m<? extends T>, Iterator<? extends T>> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Iterator<T> invoke(@os.l m<? extends T> mVar) {
            l0.p(mVar, "it");
            return mVar.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class e<T> extends n0 implements jn.l<Iterable<? extends T>, Iterator<? extends T>> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Iterator<T> invoke(@os.l Iterable<? extends T> iterable) {
            l0.p(iterable, "it");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class f<T> extends n0 implements jn.l<T, T> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        public final T invoke(T t10) {
            return t10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class g<T> extends n0 implements jn.l<T, T> {
        final /* synthetic */ jn.a<T> $nextFunction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(jn.a<? extends T> aVar) {
            super(1);
            this.$nextFunction = aVar;
        }

        @Override // jn.l
        @os.m
        public final T invoke(@os.l T t10) {
            l0.p(t10, "it");
            return this.$nextFunction.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class h<T> extends n0 implements jn.a<T> {
        final /* synthetic */ T $seed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(T t10) {
            super(0);
            this.$seed = t10;
        }

        @Override // jn.a
        @os.m
        public final T invoke() {
            return this.$seed;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
    public static final class i<T> extends xm.k implements jn.p<o<? super T>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.a<m<T>> $defaultValue;
        final /* synthetic */ m<T> $this_ifEmpty;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public i(m<? extends T> mVar, jn.a<? extends m<? extends T>> aVar, um.d<? super i> dVar) {
            super(2, dVar);
            this.$this_ifEmpty = mVar;
            this.$defaultValue = aVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            i iVar = new i(this.$this_ifEmpty, this.$defaultValue, dVar);
            iVar.L$0 = obj;
            return iVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l o<? super T> oVar, @os.m um.d<? super l2> dVar) {
            return ((i) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                o oVar = (o) this.L$0;
                Iterator<? extends T> it = this.$this_ifEmpty.iterator();
                if (it.hasNext()) {
                    this.label = 1;
                    if (oVar.i(it, this) == aVar) {
                        return aVar;
                    }
                } else {
                    m<T> mVarInvoke = this.$defaultValue.invoke();
                    this.label = 2;
                    if (oVar.f(mVarInvoke, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
    public static final class j<T> extends xm.k implements jn.p<o<? super T>, um.d<? super l2>, Object> {
        final /* synthetic */ rn.f $random;
        final /* synthetic */ m<T> $this_shuffled;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(m<? extends T> mVar, rn.f fVar, um.d<? super j> dVar) {
            super(2, dVar);
            this.$this_shuffled = mVar;
            this.$random = fVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            j jVar = new j(this.$this_shuffled, this.$random, dVar);
            jVar.L$0 = obj;
            return jVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l o<? super T> oVar, @os.m um.d<? super l2> dVar) {
            return ((j) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            List listD3;
            o oVar;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                o oVar2 = (o) this.L$0;
                listD3 = v.d3(this.$this_shuffled);
                oVar = oVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                listD3 = (List) this.L$1;
                o oVar3 = (o) this.L$0;
                d1.n(obj);
                oVar = oVar3;
            }
            while (!listD3.isEmpty()) {
                int iNextInt = this.$random.nextInt(listD3.size());
                Object objO0 = d0.O0(listD3);
                if (iNextInt < listD3.size()) {
                    objO0 = listD3.set(iNextInt, objO0);
                }
                this.L$0 = oVar;
                this.L$1 = listD3;
                this.label = 1;
                if (oVar.a(objO0, this) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }
    }

    @an.f
    public static final <T> m<T> d(jn.a<? extends Iterator<? extends T>> aVar) {
        l0.p(aVar, "iterator");
        return new a(aVar);
    }

    @os.l
    public static <T> m<T> e(@os.l Iterator<? extends T> it) {
        l0.p(it, "<this>");
        return f(new b(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static <T> m<T> f(@os.l m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return mVar instanceof gq.a ? mVar : new gq.a(mVar);
    }

    @os.l
    public static <T> m<T> g() {
        return gq.g.f6836a;
    }

    @os.l
    public static final <T, C, R> m<R> h(@os.l m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, ? extends C> pVar, @os.l jn.l<? super C, ? extends Iterator<? extends R>> lVar) {
        l0.p(mVar, "source");
        l0.p(pVar, "transform");
        l0.p(lVar, "iterator");
        return q.b(new c(mVar, pVar, lVar, null));
    }

    @os.l
    public static final <T> m<T> i(@os.l m<? extends m<? extends T>> mVar) {
        l0.p(mVar, "<this>");
        return j(mVar, d.INSTANCE);
    }

    public static final <T, R> m<R> j(m<? extends T> mVar, jn.l<? super T, ? extends Iterator<? extends R>> lVar) {
        return mVar instanceof a0 ? ((a0) mVar).e(lVar) : new gq.i(mVar, f.INSTANCE, lVar);
    }

    @in.i(name = "flattenSequenceOfIterable")
    @os.l
    public static final <T> m<T> k(@os.l m<? extends Iterable<? extends T>> mVar) {
        l0.p(mVar, "<this>");
        return j(mVar, e.INSTANCE);
    }

    @an.h
    @os.l
    public static <T> m<T> l(@os.m T t10, @os.l jn.l<? super T, ? extends T> lVar) {
        l0.p(lVar, "nextFunction");
        return t10 == null ? gq.g.f6836a : new gq.j(new h(t10), lVar);
    }

    @os.l
    public static <T> m<T> m(@os.l jn.a<? extends T> aVar) {
        l0.p(aVar, "nextFunction");
        return f(new gq.j(aVar, new g(aVar)));
    }

    @os.l
    public static <T> m<T> n(@os.l jn.a<? extends T> aVar, @os.l jn.l<? super T, ? extends T> lVar) {
        l0.p(aVar, "seedFunction");
        l0.p(lVar, "nextFunction");
        return new gq.j(aVar, lVar);
    }

    @f1(version = "1.3")
    @os.l
    public static final <T> m<T> o(@os.l m<? extends T> mVar, @os.l jn.a<? extends m<? extends T>> aVar) {
        l0.p(mVar, "<this>");
        l0.p(aVar, "defaultValue");
        return q.b(new i(mVar, aVar, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @an.f
    public static final <T> m<T> p(m<? extends T> mVar) {
        return mVar == 0 ? gq.g.f6836a : mVar;
    }

    @os.l
    public static <T> m<T> q(@os.l T... tArr) {
        l0.p(tArr, "elements");
        return tArr.length == 0 ? gq.g.f6836a : nm.r.K5(tArr);
    }

    @f1(version = "1.4")
    @os.l
    public static final <T> m<T> r(@os.l m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return s(mVar, rn.f.Default);
    }

    @f1(version = "1.4")
    @os.l
    public static final <T> m<T> s(@os.l m<? extends T> mVar, @os.l rn.f fVar) {
        l0.p(mVar, "<this>");
        l0.p(fVar, "random");
        return q.b(new j(mVar, fVar, null));
    }

    @os.l
    public static final <T, R> t0<List<T>, List<R>> t(@os.l m<? extends t0<? extends T, ? extends R>> mVar) {
        l0.p(mVar, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (t0<? extends T, ? extends R> t0Var : mVar) {
            arrayList.add(t0Var.getFirst());
            arrayList2.add(t0Var.getSecond());
        }
        return new t0<>(arrayList, arrayList2);
    }
}
