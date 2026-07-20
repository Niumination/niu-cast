package gq;

import ik.y0;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kn.h0;
import kn.k1;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.a1;
import lm.a2;
import lm.d1;
import lm.f1;
import lm.l2;
import lm.p2;
import lm.t0;
import lm.w1;
import nm.d0;
import nm.k0;
import nm.m0;
import nm.n1;
import nm.o0;
import nm.s0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,3112:1\n179#1,2:3113\n316#1,7:3115\n1324#1,3:3123\n739#1,4:3126\n704#1,4:3130\n722#1,4:3134\n775#1,4:3138\n1017#1,3:3142\n1020#1,3:3152\n1037#1,3:3155\n1040#1,3:3165\n1324#1,3:3182\n1313#1,2:3185\n1#2:3122\n372#3,7:3145\n372#3,7:3158\n372#3,7:3168\n372#3,7:3175\n*S KotlinDebug\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n87#1:3113,2\n99#1:3115,7\n458#1:3123,3\n658#1:3126,4\n674#1:3130,4\n689#1:3134,4\n760#1:3138,4\n988#1:3142,3\n988#1:3152,3\n1003#1:3155,3\n1003#1:3165,3\n1106#1:3182,3\n1144#1:3185,2\n988#1:3145,7\n1003#1:3158,7\n1019#1:3168,7\n1039#1:3175,7\n*E\n"})
public class v extends gq.u {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,70:1\n2921#2:71\n*E\n"})
    public static final class a<T> implements Iterable<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m f6877a;

        public a(gq.m mVar) {
            this.f6877a = mVar;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<T> iterator() {
            return this.f6877a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a0<T> extends n0 implements jn.p<T, T, t0<? extends T, ? extends T>> {
        public static final a0 INSTANCE = new a0();

        public a0() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final t0<T, T> invoke(T t10, T t11) {
            return new t0<>(t10, t11);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends n0 implements jn.l<T, T> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        public final T invoke(T t10) {
            return t10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @xm.f(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2873}, m = "invokeSuspend", n = {"$this$result", "iterator", y0.b.f8223h}, s = {"L$0", "L$1", "L$2"})
    public static final class b0<R> extends xm.k implements jn.p<gq.o<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ gq.m<T> $this_zipWithNext;
        final /* synthetic */ jn.p<T, T, R> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b0(gq.m<? extends T> mVar, jn.p<? super T, ? super T, ? extends R> pVar, um.d<? super b0> dVar) {
            super(2, dVar);
            this.$this_zipWithNext = mVar;
            this.$transform = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b0 b0Var = new b0(this.$this_zipWithNext, this.$transform, dVar);
            b0Var.L$0 = obj;
            return b0Var;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super R> oVar, @os.m um.d<? super l2> dVar) {
            return ((b0) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0043  */
        /* JADX WARN: Code duplicated, block: B:18:0x005b A[RETURN] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:6:0x0016). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
            /*
                r6 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r1 = r6.L$2
                java.lang.Object r3 = r6.L$1
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r6.L$0
                gq.o r4 = (gq.o) r4
                lm.d1.n(r7)
            L16:
                r7 = r1
                goto L3d
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L20:
                lm.d1.n(r7)
                java.lang.Object r7 = r6.L$0
                gq.o r7 = (gq.o) r7
                gq.m<T> r1 = r6.$this_zipWithNext
                java.util.Iterator r1 = r1.iterator()
                boolean r3 = r1.hasNext()
                if (r3 != 0) goto L36
                lm.l2 r6 = lm.l2.f10208a
                return r6
            L36:
                java.lang.Object r3 = r1.next()
                r4 = r7
                r7 = r3
                r3 = r1
            L3d:
                boolean r1 = r3.hasNext()
                if (r1 == 0) goto L5c
                java.lang.Object r1 = r3.next()
                jn.p<T, T, R> r5 = r6.$transform
                java.lang.Object r7 = r5.invoke(r7, r1)
                r6.L$0 = r4
                r6.L$1 = r3
                r6.L$2 = r1
                r6.label = r2
                java.lang.Object r7 = r4.a(r7, r6)
                if (r7 != r0) goto L16
                return r0
            L5c:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: gq.v.b0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> extends n0 implements jn.l<s0<? extends T>, Boolean> {
        final /* synthetic */ jn.p<Integer, T, Boolean> $predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(jn.p<? super Integer, ? super T, Boolean> pVar) {
            super(1);
            this.$predicate = pVar;
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l s0<? extends T> s0Var) {
            l0.p(s0Var, "it");
            return this.$predicate.invoke(Integer.valueOf(s0Var.f11691a), s0Var.f11692b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class e<T> extends n0 implements jn.l<s0<? extends T>, T> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // jn.l
        public final T invoke(@os.l s0<? extends T> s0Var) {
            l0.p(s0Var, "it");
            return s0Var.f11692b;
        }
    }

    @r1({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt$filterIsInstance$1\n*L\n1#1,3112:1\n*E\n"})
    public static final class f extends n0 implements jn.l<Object, Boolean> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.m Object obj) {
            l0.P();
            return Boolean.valueOf(Objects.nonNull(obj));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class g<T> extends n0 implements jn.l<T, Boolean> {
        public static final g INSTANCE = new g();

        public g() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.m T t10) {
            return Boolean.valueOf(t10 == null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public /* synthetic */ class h<R> extends h0 implements jn.l<Iterable<? extends R>, Iterator<? extends R>> {
        public static final h INSTANCE = new h();

        public h() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // jn.l
        @os.l
        public final Iterator<R> invoke(@os.l Iterable<? extends R> iterable) {
            l0.p(iterable, "p0");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public /* synthetic */ class i<R> extends h0 implements jn.l<gq.m<? extends R>, Iterator<? extends R>> {
        public static final i INSTANCE = new i();

        public i() {
            super(1, gq.m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // jn.l
        @os.l
        public final Iterator<R> invoke(@os.l gq.m<? extends R> mVar) {
            l0.p(mVar, "p0");
            return mVar.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public /* synthetic */ class j<R> extends h0 implements jn.l<Iterable<? extends R>, Iterator<? extends R>> {
        public static final j INSTANCE = new j();

        public j() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // jn.l
        @os.l
        public final Iterator<R> invoke(@os.l Iterable<? extends R> iterable) {
            l0.p(iterable, "p0");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public /* synthetic */ class k<R> extends h0 implements jn.l<gq.m<? extends R>, Iterator<? extends R>> {
        public static final k INSTANCE = new k();

        public k() {
            super(1, gq.m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // jn.l
        @os.l
        public final Iterator<R> invoke(@os.l gq.m<? extends R> mVar) {
            l0.p(mVar, "p0");
            return mVar.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    @r1({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt$groupingBy$1\n*L\n1#1,3112:1\n*E\n"})
    public static final class l<K, T> implements o0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m<T> f6878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, K> f6879b;

        /* JADX WARN: Multi-variable type inference failed */
        public l(gq.m<? extends T> mVar, jn.l<? super T, ? extends K> lVar) {
            this.f6878a = mVar;
            this.f6879b = lVar;
        }

        @Override // nm.o0
        public K a(T t10) {
            return this.f6879b.invoke(t10);
        }

        @Override // nm.o0
        @os.l
        public Iterator<T> b() {
            return this.f6878a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class m<T> implements gq.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m<T> f6880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ T f6881b;

        public static final class a extends n0 implements jn.l<T, Boolean> {
            final /* synthetic */ T $element;
            final /* synthetic */ k1.a $removed;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(k1.a aVar, T t10) {
                super(1);
                this.$removed = aVar;
                this.$element = t10;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.l
            @os.l
            public final Boolean invoke(T t10) {
                boolean z10 = true;
                if (!this.$removed.element && l0.g(t10, this.$element)) {
                    this.$removed.element = true;
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public m(gq.m<? extends T> mVar, T t10) {
            this.f6880a = mVar;
            this.f6881b = t10;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            return v.p0(this.f6880a, new a(new k1.a(), this.f6881b)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class n<T> implements gq.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m<T> f6882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ T[] f6883b;

        public static final class a extends n0 implements jn.l<T, Boolean> {
            final /* synthetic */ T[] $elements;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(T[] tArr) {
                super(1);
                this.$elements = tArr;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.l
            @os.l
            public final Boolean invoke(T t10) {
                return Boolean.valueOf(nm.r.s8(this.$elements, t10));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public n(gq.m<? extends T> mVar, T[] tArr) {
            this.f6882a = mVar;
            this.f6883b = tArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            return v.u0(this.f6882a, new a(this.f6883b)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class o<T> implements gq.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable<T> f6884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gq.m<T> f6885b;

        public static final class a extends n0 implements jn.l<T, Boolean> {
            final /* synthetic */ Collection<T> $other;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(Collection<? extends T> collection) {
                super(1);
                this.$other = collection;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.l
            @os.l
            public final Boolean invoke(T t10) {
                return Boolean.valueOf(this.$other.contains(t10));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public o(Iterable<? extends T> iterable, gq.m<? extends T> mVar) {
            this.f6884a = iterable;
            this.f6885b = mVar;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            Collection collectionT0 = d0.t0(this.f6884a);
            return collectionT0.isEmpty() ? this.f6885b.iterator() : v.u0(this.f6885b, new a(collectionT0)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class p<T> implements gq.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m<T> f6886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gq.m<T> f6887b;

        public static final class a extends n0 implements jn.l<T, Boolean> {
            final /* synthetic */ List<T> $other;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(List<? extends T> list) {
                super(1);
                this.$other = list;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.l
            @os.l
            public final Boolean invoke(T t10) {
                return Boolean.valueOf(this.$other.contains(t10));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public p(gq.m<? extends T> mVar, gq.m<? extends T> mVar2) {
            this.f6886a = mVar;
            this.f6887b = mVar2;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            List listC3 = v.c3(this.f6886a);
            return listC3.isEmpty() ? this.f6887b.iterator() : v.u0(this.f6887b, new a(listC3)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class q<T> extends n0 implements jn.l<T, T> {
        final /* synthetic */ jn.l<T, l2> $action;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public q(jn.l<? super T, l2> lVar) {
            super(1);
            this.$action = lVar;
        }

        @Override // jn.l
        public final T invoke(T t10) {
            this.$action.invoke(t10);
            return t10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class r<T> extends n0 implements jn.p<Integer, T, T> {
        final /* synthetic */ jn.p<Integer, T, l2> $action;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public r(jn.p<? super Integer, ? super T, l2> pVar) {
            super(2);
            this.$action = pVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
            return invoke(num.intValue(), obj);
        }

        public final T invoke(int i10, T t10) {
            this.$action.invoke(Integer.valueOf(i10), t10);
            return t10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class s<T> extends n0 implements jn.l<T, T> {
        final /* synthetic */ gq.m<T> $this_requireNoNulls;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public s(gq.m<? extends T> mVar) {
            super(1);
            this.$this_requireNoNulls = mVar;
        }

        @Override // jn.l
        @os.l
        public final T invoke(@os.m T t10) {
            if (t10 != null) {
                return t10;
            }
            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + n1.e.f11183c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @xm.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2308, 2312}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
    public static final class t<R> extends xm.k implements jn.p<gq.o<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ R $initial;
        final /* synthetic */ jn.p<R, T, R> $operation;
        final /* synthetic */ gq.m<T> $this_runningFold;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public t(R r10, gq.m<? extends T> mVar, jn.p<? super R, ? super T, ? extends R> pVar, um.d<? super t> dVar) {
            super(2, dVar);
            this.$initial = r10;
            this.$this_runningFold = mVar;
            this.$operation = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            t tVar = new t(this.$initial, this.$this_runningFold, this.$operation, dVar);
            tVar.L$0 = obj;
            return tVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super R> oVar, @os.m um.d<? super l2> dVar) {
            return ((t) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0050  */
        /* JADX WARN: Code duplicated, block: B:19:0x0068 A[RETURN] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0066 -> B:7:0x0019). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
            /*
                r6 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r6.L$2
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r3 = r6.L$1
                java.lang.Object r4 = r6.L$0
                gq.o r4 = (gq.o) r4
                lm.d1.n(r7)
            L19:
                r7 = r3
                goto L4a
            L1b:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L23:
                java.lang.Object r1 = r6.L$0
                gq.o r1 = (gq.o) r1
                lm.d1.n(r7)
                goto L40
            L2b:
                lm.d1.n(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                gq.o r1 = (gq.o) r1
                R r7 = r6.$initial
                r6.L$0 = r1
                r6.label = r3
                java.lang.Object r7 = r1.a(r7, r6)
                if (r7 != r0) goto L40
                return r0
            L40:
                R r7 = r6.$initial
                gq.m<T> r3 = r6.$this_runningFold
                java.util.Iterator r3 = r3.iterator()
                r4 = r1
                r1 = r3
            L4a:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L69
                java.lang.Object r3 = r1.next()
                jn.p<R, T, R> r5 = r6.$operation
                java.lang.Object r3 = r5.invoke(r7, r3)
                r6.L$0 = r4
                r6.L$1 = r3
                r6.L$2 = r1
                r6.label = r2
                java.lang.Object r7 = r4.a(r3, r6)
                if (r7 != r0) goto L19
                return r0
            L69:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: gq.v.t.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @xm.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2336, 2341}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
    public static final class u<R> extends xm.k implements jn.p<gq.o<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ R $initial;
        final /* synthetic */ jn.q<Integer, R, T, R> $operation;
        final /* synthetic */ gq.m<T> $this_runningFoldIndexed;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public u(R r10, gq.m<? extends T> mVar, jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar, um.d<? super u> dVar) {
            super(2, dVar);
            this.$initial = r10;
            this.$this_runningFoldIndexed = mVar;
            this.$operation = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            u uVar = new u(this.$initial, this.$this_runningFoldIndexed, this.$operation, dVar);
            uVar.L$0 = obj;
            return uVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super R> oVar, @os.m um.d<? super l2> dVar) {
            return ((u) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0053  */
        /* JADX WARN: Code duplicated, block: B:18:0x005d  */
        /* JADX WARN: Code duplicated, block: B:22:0x007a A[LOOP:0: B:14:0x004d->B:22:0x007a, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:25:0x0079 A[SYNTHETIC] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            gq.o oVar;
            Object obj2;
            Iterator it;
            int i10;
            gq.o oVar2;
            int i11;
            R rInvoke;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i12 = this.label;
            if (i12 != 0) {
                if (i12 == 1) {
                    oVar = (gq.o) this.L$0;
                    d1.n(obj);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i13 = this.I$0;
                    it = (Iterator) this.L$2;
                    Object obj3 = this.L$1;
                    oVar2 = (gq.o) this.L$0;
                    d1.n(obj);
                    obj2 = obj3;
                    i10 = i13;
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    jn.q<Integer, R, T, R> qVar = this.$operation;
                    i11 = i10 + 1;
                    if (i10 < 0) {
                        nm.y.Z();
                    }
                    rInvoke = qVar.invoke(new Integer(i10), (R) obj2, (T) next);
                    this.L$0 = oVar2;
                    this.L$1 = rInvoke;
                    this.L$2 = it;
                    this.I$0 = i11;
                    this.label = 2;
                    if (oVar2.a(rInvoke, this) == aVar) {
                        return aVar;
                    }
                    obj2 = rInvoke;
                    i10 = i11;
                }
                return l2.f10208a;
            }
            d1.n(obj);
            oVar = (gq.o) this.L$0;
            R r10 = this.$initial;
            this.L$0 = oVar;
            this.label = 1;
            if (oVar.a(r10, this) == aVar) {
                return aVar;
            }
            obj2 = this.$initial;
            it = this.$this_runningFoldIndexed.iterator();
            i10 = 0;
            oVar2 = oVar;
            while (it.hasNext()) {
                Object next2 = it.next();
                jn.q<Integer, R, T, R> qVar2 = this.$operation;
                i11 = i10 + 1;
                if (i10 < 0) {
                    nm.y.Z();
                }
                rInvoke = qVar2.invoke(new Integer(i10), (R) obj2, (T) next2);
                this.L$0 = oVar2;
                this.L$1 = rInvoke;
                this.L$2 = it;
                this.I$0 = i11;
                this.label = 2;
                if (oVar2.a(rInvoke, this) == aVar) {
                    return aVar;
                }
                obj2 = rInvoke;
                i10 = i11;
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: gq.v$v, reason: collision with other inner class name */
    @xm.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2366, 2369}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class C0187v<S> extends xm.k implements jn.p<gq.o<? super S>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<S, T, S> $operation;
        final /* synthetic */ gq.m<T> $this_runningReduce;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0187v(gq.m<? extends T> mVar, jn.p<? super S, ? super T, ? extends S> pVar, um.d<? super C0187v> dVar) {
            super(2, dVar);
            this.$this_runningReduce = mVar;
            this.$operation = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            C0187v c0187v = new C0187v(this.$this_runningReduce, this.$operation, dVar);
            c0187v.L$0 = obj;
            return c0187v;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super S> oVar, @os.m um.d<? super l2> dVar) {
            return ((C0187v) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            gq.o oVar;
            Object next;
            Iterator it;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                oVar = (gq.o) this.L$0;
                Iterator it2 = this.$this_runningReduce.iterator();
                if (it2.hasNext()) {
                    next = it2.next();
                    this.L$0 = oVar;
                    this.L$1 = it2;
                    this.L$2 = next;
                    this.label = 1;
                    if (oVar.a(next, this) == aVar) {
                        return aVar;
                    }
                    it = it2;
                }
                return l2.f10208a;
            }
            if (i10 != 1 && i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            next = this.L$2;
            it = (Iterator) this.L$1;
            oVar = (gq.o) this.L$0;
            d1.n(obj);
            while (it.hasNext()) {
                next = this.$operation.invoke((S) next, (T) it.next());
                this.L$0 = oVar;
                this.L$1 = it;
                this.L$2 = next;
                this.label = 2;
                if (oVar.a(next, this) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    @xm.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2395, 2399}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    public static final class w<S> extends xm.k implements jn.p<gq.o<? super S>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.q<Integer, S, T, S> $operation;
        final /* synthetic */ gq.m<T> $this_runningReduceIndexed;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public w(gq.m<? extends T> mVar, jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar, um.d<? super w> dVar) {
            super(2, dVar);
            this.$this_runningReduceIndexed = mVar;
            this.$operation = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            w wVar = new w(this.$this_runningReduceIndexed, this.$operation, dVar);
            wVar.L$0 = obj;
            return wVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super S> oVar, @os.m um.d<? super l2> dVar) {
            return ((w) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            gq.o oVar;
            Iterator it;
            Object next;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            int i11 = 1;
            if (i10 == 0) {
                d1.n(obj);
                oVar = (gq.o) this.L$0;
                it = this.$this_runningReduceIndexed.iterator();
                if (it.hasNext()) {
                    next = it.next();
                    this.L$0 = oVar;
                    this.L$1 = it;
                    this.L$2 = next;
                    this.label = 1;
                    if (oVar.a(next, this) == aVar) {
                        return aVar;
                    }
                }
                return l2.f10208a;
            }
            if (i10 == 1) {
                next = this.L$2;
                it = (Iterator) this.L$1;
                oVar = (gq.o) this.L$0;
                d1.n(obj);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i12 = this.I$0;
                Object obj2 = this.L$2;
                it = (Iterator) this.L$1;
                oVar = (gq.o) this.L$0;
                d1.n(obj);
                i11 = i12;
                next = obj2;
            }
            while (it.hasNext()) {
                jn.q<Integer, S, T, S> qVar = this.$operation;
                int i13 = i11 + 1;
                if (i11 < 0) {
                    nm.y.Z();
                }
                S sInvoke = qVar.invoke(new Integer(i11), (S) next, (T) it.next());
                this.L$0 = oVar;
                this.L$1 = it;
                this.L$2 = sInvoke;
                this.I$0 = i13;
                this.label = 2;
                if (oVar.a(sInvoke, this) == aVar) {
                    return aVar;
                }
                next = sInvoke;
                i11 = i13;
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class x<T> implements gq.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m<T> f6888a;

        /* JADX WARN: Multi-variable type inference failed */
        public x(gq.m<? extends T> mVar) {
            this.f6888a = mVar;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            List listD3 = v.d3(this.f6888a);
            nm.c0.m0(listD3);
            return listD3.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class y<T> implements gq.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m<T> f6889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super T> f6890b;

        /* JADX WARN: Multi-variable type inference failed */
        public y(gq.m<? extends T> mVar, Comparator<? super T> comparator) {
            this.f6889a = mVar;
            this.f6890b = comparator;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            List listD3 = v.d3(this.f6889a);
            nm.c0.p0(listD3, this.f6890b);
            return listD3.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    public static final class z<R, T> extends n0 implements jn.p<T, R, t0<? extends T, ? extends R>> {
        public static final z INSTANCE = new z();

        public z() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final t0<T, R> invoke(T t10, R r10) {
            return new t0<>(t10, r10);
        }
    }

    @an.f
    public static final <T> T A0(gq.m<? extends T> mVar, jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        T t10 = null;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                t10 = (T) obj;
            }
        }
        return t10;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T, R> R A1(gq.m<? extends T> mVar, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(it.next());
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <T, R> gq.m<R> A2(@os.l gq.m<? extends T> mVar, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "operation");
        return w2(mVar, r10, pVar);
    }

    public static final <T> T B0(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T, R> R B1(gq.m<? extends T> mVar, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke(it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(it.next());
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <T, R> gq.m<R> B2(@os.l gq.m<? extends T> mVar, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        l0.p(mVar, "<this>");
        l0.p(qVar, "operation");
        return x2(mVar, r10, qVar);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    public static final <T> T C0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            ?? r10 = (Object) itA.next();
            if (lVar.invoke(r10).booleanValue()) {
                return r10;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @os.m
    @f1(version = "1.4")
    public static final <T extends Comparable<? super T>> T C1(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T C2(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        return next;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    @f1(version = "1.5")
    @an.f
    public static final <T, R> R D0(gq.m<? extends T> mVar, jn.l<? super T, ? extends R> lVar) {
        R rInvoke;
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "transform");
        while (itA.hasNext()) {
            rInvoke = lVar.invoke((Object) itA.next());
            if (rInvoke != null) {
                if (rInvoke != null) {
                    return rInvoke;
                }
                throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
            }
        }
        rInvoke = null;
        if (rInvoke != null) {
            return rInvoke;
        }
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    }

    @os.m
    @f1(version = "1.4")
    public static final Double D1(@os.l gq.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T D2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        T t10 = null;
        boolean z10 = false;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
                z10 = true;
                t10 = (T) obj;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @f1(version = "1.5")
    @an.f
    public static final <T, R> R E0(gq.m<? extends T> mVar, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "transform");
        while (itA.hasNext()) {
            R rInvoke = lVar.invoke((Object) itA.next());
            if (rInvoke != null) {
                return rInvoke;
            }
        }
        return null;
    }

    @os.m
    @f1(version = "1.4")
    public static final Float E1(@os.l gq.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    public static final <T> T E2(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @os.m
    public static <T> T F0(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final double F1(@os.l gq.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    @os.m
    public static final <T> T F2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        boolean z10 = false;
        T t10 = null;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                if (z10) {
                    return null;
                }
                z10 = true;
                t10 = (T) obj;
            }
        }
        if (z10) {
            return t10;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    @os.m
    public static final <T> T G0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            ?? r10 = (Object) itA.next();
            if (lVar.invoke(r10).booleanValue()) {
                return r10;
            }
        }
        return null;
    }

    @f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final float G1(@os.l gq.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return fFloatValue;
    }

    @os.l
    public static final <T extends Comparable<? super T>> gq.m<T> G2(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return new x(mVar);
    }

    @os.l
    public static <T, R> gq.m<R> H0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends gq.m<? extends R>> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "transform");
        return new gq.i(mVar, lVar, i.INSTANCE);
    }

    @f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    @os.l
    public static final <T extends Comparable<? super T>> T H1(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.l
    public static final <T, R extends Comparable<? super R>> gq.m<T> H2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "selector");
        return K2(mVar, new rm.g.a(lVar));
    }

    @lm.s0
    @in.i(name = "flatMapIndexedIterable")
    @f1(version = "1.4")
    @os.l
    public static final <T, R> gq.m<R> I0(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, ? extends Iterable<? extends R>> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "transform");
        return gq.s.h(mVar, pVar, j.INSTANCE);
    }

    @os.m
    @f1(version = "1.4")
    public static final <T> T I1(@os.l gq.m<? extends T> mVar, @os.l Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.l
    public static final <T, R extends Comparable<? super R>> gq.m<T> I2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "selector");
        return K2(mVar, new rm.g.c(lVar));
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @f1(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C J0(gq.m<? extends T> mVar, C c10, jn.p<? super Integer, ? super T, ? extends Iterable<? extends R>> pVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            d0.r0(c10, pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return c10;
    }

    @f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final <T> T J1(@os.l gq.m<? extends T> mVar, @os.l Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.l
    public static final <T extends Comparable<? super T>> gq.m<T> J2(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return K2(mVar, rm.g.x());
    }

    public static final <T> boolean K(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            if (!lVar.invoke((Object) itA.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.s0
    @in.i(name = "flatMapIndexedSequence")
    @f1(version = "1.4")
    @os.l
    public static final <T, R> gq.m<R> K0(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, ? extends gq.m<? extends R>> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "transform");
        return gq.s.h(mVar, pVar, k.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @os.m
    @f1(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T K1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        ?? r10 = (Object) itA.next();
        if (!itA.hasNext()) {
            return r10;
        }
        R rInvoke = lVar.invoke(r10);
        do {
            Object obj = (Object) itA.next();
            R rInvoke2 = lVar.invoke(obj);
            r10 = r10;
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
                r10 = (T) obj;
            }
        } while (itA.hasNext());
        return (T) r10;
    }

    @os.l
    public static <T> gq.m<T> K2(@os.l gq.m<? extends T> mVar, @os.l Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        return new y(mVar, comparator);
    }

    public static final <T> boolean L(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return mVar.iterator().hasNext();
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedSequenceTo")
    @f1(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C L0(gq.m<? extends T> mVar, C c10, jn.p<? super Integer, ? super T, ? extends gq.m<? extends R>> pVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            d0.q0(c10, pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return c10;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T L1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        ?? r10 = (Object) itA.next();
        if (!itA.hasNext()) {
            return r10;
        }
        R rInvoke = lVar.invoke(r10);
        do {
            Object obj = (Object) itA.next();
            R rInvoke2 = lVar.invoke(obj);
            r10 = r10;
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
                r10 = (T) obj;
            }
        } while (itA.hasNext());
        return (T) r10;
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final <T> int L2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Integer> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        int iIntValue = 0;
        while (itA.hasNext()) {
            iIntValue += lVar.invoke((Object) itA.next()).intValue();
        }
        return iIntValue;
    }

    public static final <T> boolean M(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            if (lVar.invoke((Object) itA.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @lm.s0
    @in.i(name = "flatMapIterable")
    @f1(version = "1.4")
    @os.l
    public static final <T, R> gq.m<R> M0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends Iterable<? extends R>> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "transform");
        return new gq.i(mVar, lVar, h.INSTANCE);
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T> double M1(gq.m<? extends T> mVar, jn.l<? super T, Double> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke((Object) itA.next()).doubleValue();
        while (itA.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke((Object) itA.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final <T> double M2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Double> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        double dDoubleValue = 0.0d;
        while (itA.hasNext()) {
            dDoubleValue += lVar.invoke((Object) itA.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static <T> Iterable<T> N(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return new a(mVar);
    }

    @lm.s0
    @in.i(name = "flatMapIterableTo")
    @f1(version = "1.4")
    @os.l
    public static final <T, R, C extends Collection<? super R>> C N0(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.l<? super T, ? extends Iterable<? extends R>> lVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            d0.r0(c10, lVar.invoke(it.next()));
        }
        return c10;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T> float N1(gq.m<? extends T> mVar, jn.l<? super T, Float> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke((Object) itA.next()).floatValue();
        while (itA.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke((Object) itA.next()).floatValue());
        }
        return fFloatValue;
    }

    @in.i(name = "sumOfByte")
    public static final int N2(@os.l gq.m<Byte> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Byte> it = mVar.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += it.next().byteValue();
        }
        return iByteValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <T> gq.m<T> O(gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return mVar;
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C O0(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.l<? super T, ? extends gq.m<? extends R>> lVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            d0.q0(c10, lVar.invoke(it.next()));
        }
        return c10;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R O1(gq.m<? extends T> mVar, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke((Object) itA.next());
        while (itA.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) itA.next());
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @in.i(name = "sumOfDouble")
    public static final double O2(@os.l gq.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final <T, K, V> Map<K, V> P(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends t0<? extends K, ? extends V>> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(it.next());
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <T, R> R P0(@os.l gq.m<? extends T> mVar, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            r10 = pVar.invoke(r10, it.next());
        }
        return r10;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R P1(gq.m<? extends T> mVar, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke((Object) itA.next());
        while (itA.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) itA.next());
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @f1(version = "1.4")
    public static final <T> double P2(gq.m<? extends T> mVar, jn.l<? super T, Double> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        double dDoubleValue = 0.0d;
        while (itA.hasNext()) {
            dDoubleValue += lVar.invoke((Object) itA.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final <T, K> Map<K, T> Q(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends K> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : mVar) {
            linkedHashMap.put(lVar.invoke(t10), t10);
        }
        return linkedHashMap;
    }

    public static final <T, R> R Q0(@os.l gq.m<? extends T> mVar, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        l0.p(mVar, "<this>");
        l0.p(qVar, "operation");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            r10 = qVar.invoke(Integer.valueOf(i10), r10, t10);
            i10 = i11;
        }
        return r10;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T> Double Q1(gq.m<? extends T> mVar, jn.l<? super T, Double> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        double dDoubleValue = lVar.invoke((Object) itA.next()).doubleValue();
        while (itA.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke((Object) itA.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @in.i(name = "sumOfFloat")
    public static final float Q2(@os.l gq.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    @os.l
    public static final <T, K, V> Map<K, V> R(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : mVar) {
            linkedHashMap.put(lVar.invoke(t10), lVar2.invoke(t10));
        }
        return linkedHashMap;
    }

    public static final <T> void R0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, l2> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, k4.f.f8937e);
        while (itA.hasNext()) {
            lVar.invoke((Object) itA.next());
        }
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T> Float R1(gq.m<? extends T> mVar, jn.l<? super T, Float> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        float fFloatValue = lVar.invoke((Object) itA.next()).floatValue();
        while (itA.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke((Object) itA.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @in.i(name = "sumOfInt")
    public static final int R2(@os.l gq.m<Integer> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Integer> it = mVar.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final <T, K, M extends Map<? super K, ? super T>> M S(@os.l gq.m<? extends T> mVar, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar) {
        l0.p(mVar, "<this>");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        for (T t10 : mVar) {
            m10.put(lVar.invoke(t10), t10);
        }
        return m10;
    }

    public static final <T> void S0(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, l2> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, k4.f.f8937e);
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            pVar.invoke(Integer.valueOf(i10), t10);
            i10 = i11;
        }
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T, R> R S1(gq.m<? extends T> mVar, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(it.next());
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @f1(version = "1.4")
    public static final <T> int S2(gq.m<? extends T> mVar, jn.l<? super T, Integer> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        int iIntValue = 0;
        while (itA.hasNext()) {
            iIntValue += lVar.invoke((Object) itA.next()).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, ? super V>> M T(@os.l gq.m<? extends T> mVar, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        l0.p(mVar, "<this>");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        for (T t10 : mVar) {
            m10.put(lVar.invoke(t10), lVar2.invoke(t10));
        }
        return m10;
    }

    @os.l
    public static final <T, K> Map<K, List<T>> T0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends K> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : mVar) {
            K kInvoke = lVar.invoke(t10);
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(t10);
        }
        return linkedHashMap;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T, R> R T1(gq.m<? extends T> mVar, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke(it.next());
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(it.next());
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @in.i(name = "sumOfLong")
    public static final long T2(@os.l gq.m<Long> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Long> it = mVar.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, ? super V>> M U(@os.l gq.m<? extends T> mVar, @os.l M m10, @os.l jn.l<? super T, ? extends t0<? extends K, ? extends V>> lVar) {
        l0.p(mVar, "<this>");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(it.next());
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @os.l
    public static final <T, K, V> Map<K, List<V>> U0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : mVar) {
            K kInvoke = lVar.invoke(t10);
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(t10));
        }
        return linkedHashMap;
    }

    @os.m
    @f1(version = "1.4")
    public static final <T extends Comparable<? super T>> T U1(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @f1(version = "1.4")
    public static final <T> long U2(gq.m<? extends T> mVar, jn.l<? super T, Long> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        long jLongValue = 0;
        while (itA.hasNext()) {
            jLongValue += lVar.invoke((Object) itA.next()).longValue();
        }
        return jLongValue;
    }

    @f1(version = "1.3")
    @os.l
    public static final <K, V> Map<K, V> V(@os.l gq.m<? extends K> mVar, @os.l jn.l<? super K, ? extends V> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k10 : mVar) {
            linkedHashMap.put(k10, lVar.invoke(k10));
        }
        return linkedHashMap;
    }

    @os.l
    public static final <T, K, M extends Map<? super K, List<T>>> M V0(@os.l gq.m<? extends T> mVar, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar) {
        l0.p(mVar, "<this>");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        for (T t10 : mVar) {
            K kInvoke = lVar.invoke(t10);
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(t10);
        }
        return m10;
    }

    @os.m
    @f1(version = "1.4")
    public static final Double V1(@os.l gq.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @in.i(name = "sumOfShort")
    public static final int V2(@os.l gq.m<Short> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Short> it = mVar.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += it.next().shortValue();
        }
        return iShortValue;
    }

    @f1(version = "1.3")
    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M W(@os.l gq.m<? extends K> mVar, @os.l M m10, @os.l jn.l<? super K, ? extends V> lVar) {
        l0.p(mVar, "<this>");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "valueSelector");
        for (K k10 : mVar) {
            m10.put(k10, lVar.invoke(k10));
        }
        return m10;
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, List<V>>> M W0(@os.l gq.m<? extends T> mVar, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        l0.p(mVar, "<this>");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        for (T t10 : mVar) {
            K kInvoke = lVar.invoke(t10);
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(t10));
        }
        return m10;
    }

    @os.m
    @f1(version = "1.4")
    public static final Float W1(@os.l gq.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @f1(version = "1.5")
    public static final <T> int W2(gq.m<? extends T> mVar, jn.l<? super T, w1> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "selector");
        int iM = w1.m(0);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            iM += lVar.invoke(it.next()).f10227a;
        }
        return iM;
    }

    @in.i(name = "averageOfByte")
    public static final double X(@os.l gq.m<Byte> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Byte> it = mVar.iterator();
        double dByteValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dByteValue += (double) it.next().byteValue();
            i10++;
            if (i10 < 0) {
                nm.y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i10);
    }

    @f1(version = "1.1")
    @os.l
    public static final <T, K> o0<T, K> X0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends K> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "keySelector");
        return new l(mVar, lVar);
    }

    @f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final double X1(@os.l gq.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @f1(version = "1.5")
    public static final <T> long X2(gq.m<? extends T> mVar, jn.l<? super T, a2> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "selector");
        long jM = a2.m(0L);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            jM += lVar.invoke(it.next()).f10177a;
        }
        return jM;
    }

    @in.i(name = "averageOfDouble")
    public static final double Y(@os.l gq.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i10++;
            if (i10 < 0) {
                nm.y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i10);
    }

    public static final <T> int Y0(@os.l gq.m<? extends T> mVar, T t10) {
        l0.p(mVar, "<this>");
        int i10 = 0;
        for (T t11 : mVar) {
            if (i10 < 0) {
                nm.y.Z();
            }
            if (l0.g(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final float Y1(@os.l gq.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return fFloatValue;
    }

    @os.l
    public static final <T> gq.m<T> Y2(@os.l gq.m<? extends T> mVar, int i10) {
        l0.p(mVar, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return gq.g.f6836a;
        }
        return mVar instanceof gq.e ? ((gq.e) mVar).b(i10) : new gq.x(mVar, i10);
    }

    @in.i(name = "averageOfFloat")
    public static final double Z(@os.l gq.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        double dFloatValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i10++;
            if (i10 < 0) {
                nm.y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i10);
    }

    public static final <T> int Z0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        int i10 = 0;
        while (itA.hasNext()) {
            a1.e eVar = (Object) itA.next();
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            if (lVar.invoke(eVar).booleanValue()) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @f1(version = "1.7")
    @in.i(name = "minOrThrow")
    @os.l
    public static final <T extends Comparable<? super T>> T Z1(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.l
    public static <T> gq.m<T> Z2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "predicate");
        return new gq.y(mVar, lVar);
    }

    @in.i(name = "averageOfInt")
    public static final double a0(@os.l gq.m<Integer> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Integer> it = mVar.iterator();
        double dIntValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i10++;
            if (i10 < 0) {
                nm.y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i10);
    }

    public static final <T> int a1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        int i10 = -1;
        int i11 = 0;
        while (itA.hasNext()) {
            a1.e eVar = (Object) itA.next();
            if (i11 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            if (lVar.invoke(eVar).booleanValue()) {
                i10 = i11;
            }
            i11++;
        }
        return i10;
    }

    @os.m
    @f1(version = "1.4")
    public static final <T> T a2(@os.l gq.m<? extends T> mVar, @os.l Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C a3(@os.l gq.m<? extends T> mVar, @os.l C c10) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            c10.add(it.next());
        }
        return c10;
    }

    @in.i(name = "averageOfLong")
    public static final double b0(@os.l gq.m<Long> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Long> it = mVar.iterator();
        double dLongValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i10++;
            if (i10 < 0) {
                nm.y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i10);
    }

    @os.l
    public static final <T, A extends Appendable> A b1(@os.l gq.m<? extends T> mVar, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super T, ? extends CharSequence> lVar) throws IOException {
        l0.p(mVar, "<this>");
        l0.p(a10, "buffer");
        l0.p(charSequence, "separator");
        l0.p(charSequence2, "prefix");
        l0.p(charSequence3, "postfix");
        l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : mVar) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            jq.w.b(a10, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    @f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final <T> T b2(@os.l gq.m<? extends T> mVar, @os.l Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @os.l
    public static final <T> HashSet<T> b3(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return (HashSet) a3(mVar, new HashSet());
    }

    @in.i(name = "averageOfShort")
    public static final double c0(@os.l gq.m<Short> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Short> it = mVar.iterator();
        double dShortValue = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            dShortValue += (double) it.next().shortValue();
            i10++;
            if (i10 < 0) {
                nm.y.Y();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i10);
    }

    @os.l
    public static final <T> gq.m<T> c2(@os.l gq.m<? extends T> mVar, @os.l gq.m<? extends T> mVar2) {
        l0.p(mVar, "<this>");
        l0.p(mVar2, "elements");
        return new p(mVar2, mVar);
    }

    @os.l
    public static <T> List<T> c3(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return k0.INSTANCE;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return nm.x.k(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @f1(version = "1.2")
    @os.l
    public static final <T> gq.m<List<T>> d0(@os.l gq.m<? extends T> mVar, int i10) {
        l0.p(mVar, "<this>");
        return g3(mVar, i10, i10, true);
    }

    @os.l
    public static final <T> String d1(@os.l gq.m<? extends T> mVar, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super T, ? extends CharSequence> lVar) {
        l0.p(mVar, "<this>");
        l0.p(charSequence, "separator");
        l0.p(charSequence2, "prefix");
        l0.p(charSequence3, "postfix");
        l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) b1(mVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        l0.o(string, "toString(...)");
        return string;
    }

    @os.l
    public static final <T> gq.m<T> d2(@os.l gq.m<? extends T> mVar, @os.l Iterable<? extends T> iterable) {
        l0.p(mVar, "<this>");
        l0.p(iterable, "elements");
        return new o(iterable, mVar);
    }

    @os.l
    public static <T> List<T> d3(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return (List) a3(mVar, new ArrayList());
    }

    @f1(version = "1.2")
    @os.l
    public static final <T, R> gq.m<R> e0(@os.l gq.m<? extends T> mVar, int i10, @os.l jn.l<? super List<? extends T>, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "transform");
        return h3(mVar, i10, i10, true, lVar);
    }

    public static /* synthetic */ String e1(gq.m mVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return d1(mVar, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.l
    public static final <T> gq.m<T> e2(@os.l gq.m<? extends T> mVar, T t10) {
        l0.p(mVar, "<this>");
        return new m(mVar, t10);
    }

    @os.l
    public static final <T> Set<T> e3(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static final <T> boolean f0(@os.l gq.m<? extends T> mVar, T t10) {
        l0.p(mVar, "<this>");
        return Y0(mVar, t10) >= 0;
    }

    public static <T> T f1(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T> gq.m<T> f2(@os.l gq.m<? extends T> mVar, @os.l T[] tArr) {
        l0.p(mVar, "<this>");
        l0.p(tArr, "elements");
        return tArr.length == 0 ? mVar : new n(mVar, tArr);
    }

    @os.l
    public static final <T> Set<T> f3(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return m0.INSTANCE;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return n1.f(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static <T> int g0(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                nm.y.Y();
            }
        }
        return i10;
    }

    public static final <T> T g1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        T t10 = null;
        boolean z10 = false;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                z10 = true;
                t10 = (T) obj;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @an.f
    public static final <T> gq.m<T> g2(gq.m<? extends T> mVar, T t10) {
        l0.p(mVar, "<this>");
        return e2(mVar, t10);
    }

    @f1(version = "1.2")
    @os.l
    public static final <T> gq.m<List<T>> g3(@os.l gq.m<? extends T> mVar, int i10, int i11, boolean z10) {
        l0.p(mVar, "<this>");
        return nm.r1.c(mVar, i10, i11, z10, false);
    }

    public static final <T> int h0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        int i10 = 0;
        while (itA.hasNext()) {
            if (lVar.invoke((Object) itA.next()).booleanValue() && (i10 = i10 + 1) < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
                nm.y.Y();
            }
        }
        return i10;
    }

    public static final <T> int h1(@os.l gq.m<? extends T> mVar, T t10) {
        l0.p(mVar, "<this>");
        int i10 = -1;
        int i11 = 0;
        for (T t11 : mVar) {
            if (i11 < 0) {
                nm.y.Z();
            }
            if (l0.g(t10, t11)) {
                i10 = i11;
            }
            i11++;
        }
        return i10;
    }

    public static final <T> boolean h2(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return !mVar.iterator().hasNext();
    }

    @f1(version = "1.2")
    @os.l
    public static final <T, R> gq.m<R> h3(@os.l gq.m<? extends T> mVar, int i10, int i11, boolean z10, @os.l jn.l<? super List<? extends T>, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "transform");
        return k1(nm.r1.c(mVar, i10, i11, z10, true), lVar);
    }

    @os.l
    public static final <T> gq.m<T> i0(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return j0(mVar, b.INSTANCE);
    }

    @os.m
    public static final <T> T i1(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> boolean i2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            if (lVar.invoke((Object) itA.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ gq.m i3(gq.m mVar, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return g3(mVar, i10, i11, z10);
    }

    @os.l
    public static final <T, K> gq.m<T> j0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends K> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "selector");
        return new gq.c(mVar, lVar);
    }

    @os.m
    public static final <T> T j1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        T t10 = null;
        while (itA.hasNext()) {
            Object obj = (Object) itA.next();
            if (lVar.invoke(obj).booleanValue()) {
                t10 = (T) obj;
            }
        }
        return t10;
    }

    @f1(version = "1.1")
    @os.l
    public static final <T> gq.m<T> j2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, l2> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, k4.f.f8937e);
        return k1(mVar, new q(lVar));
    }

    public static /* synthetic */ gq.m j3(gq.m mVar, int i10, int i11, boolean z10, jn.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return h3(mVar, i10, i11, z10, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static <T> gq.m<T> k0(@os.l gq.m<? extends T> mVar, int i10) {
        l0.p(mVar, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return mVar;
        }
        return mVar instanceof gq.e ? ((gq.e) mVar).a(i10) : new gq.d(mVar, i10);
    }

    @os.l
    public static <T, R> gq.m<R> k1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "transform");
        return new gq.a0(mVar, lVar);
    }

    @f1(version = "1.4")
    @os.l
    public static final <T> gq.m<T> k2(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, l2> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, k4.f.f8937e);
        return l1(mVar, new r(pVar));
    }

    @os.l
    public static final <T> gq.m<s0<T>> k3(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return new gq.k(mVar);
    }

    @os.l
    public static final <T> gq.m<T> l0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "predicate");
        return new gq.f(mVar, lVar);
    }

    @os.l
    public static final <T, R> gq.m<R> l1(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "transform");
        return new gq.z(mVar, pVar);
    }

    @os.l
    public static final <T> t0<List<T>, List<T>> l2(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t10 : mVar) {
            if (lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            } else {
                arrayList2.add(t10);
            }
        }
        return new t0<>(arrayList, arrayList2);
    }

    @os.l
    public static final <T, R> gq.m<t0<T, R>> l3(@os.l gq.m<? extends T> mVar, @os.l gq.m<? extends R> mVar2) {
        l0.p(mVar, "<this>");
        l0.p(mVar2, "other");
        return new gq.l(mVar, mVar2, z.INSTANCE);
    }

    public static final <T> T m0(@os.l gq.m<? extends T> mVar, int i10) {
        l0.p(mVar, "<this>");
        return (T) n0(mVar, i10, new c(i10));
    }

    @os.l
    public static final <T, R> gq.m<R> m1(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "transform");
        return v0(new gq.z(mVar, pVar));
    }

    @os.l
    public static final <T> gq.m<T> m2(@os.l gq.m<? extends T> mVar, @os.l gq.m<? extends T> mVar2) {
        l0.p(mVar, "<this>");
        l0.p(mVar2, "elements");
        return gq.s.i(gq.s.q(mVar, mVar2));
    }

    @os.l
    public static final <T, R, V> gq.m<V> m3(@os.l gq.m<? extends T> mVar, @os.l gq.m<? extends R> mVar2, @os.l jn.p<? super T, ? super R, ? extends V> pVar) {
        l0.p(mVar, "<this>");
        l0.p(mVar2, "other");
        l0.p(pVar, "transform");
        return new gq.l(mVar, mVar2, pVar);
    }

    public static final <T> T n0(@os.l gq.m<? extends T> mVar, int i10, @os.l jn.l<? super Integer, ? extends T> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "defaultValue");
        if (i10 < 0) {
            return lVar.invoke(Integer.valueOf(i10));
        }
        int i11 = 0;
        for (T t10 : mVar) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return lVar.invoke(Integer.valueOf(i10));
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C n1(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            R rInvoke = pVar.invoke(Integer.valueOf(i10), t10);
            if (rInvoke != null) {
                c10.add(rInvoke);
            }
            i10 = i11;
        }
        return c10;
    }

    @os.l
    public static <T> gq.m<T> n2(@os.l gq.m<? extends T> mVar, @os.l Iterable<? extends T> iterable) {
        l0.p(mVar, "<this>");
        l0.p(iterable, "elements");
        return gq.s.i(gq.s.q(mVar, nm.h0.A1(iterable)));
    }

    @f1(version = "1.2")
    @os.l
    public static final <T> gq.m<t0<T, T>> n3(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return o3(mVar, a0.INSTANCE);
    }

    @os.m
    public static final <T> T o0(@os.l gq.m<? extends T> mVar, int i10) {
        l0.p(mVar, "<this>");
        if (i10 < 0) {
            return null;
        }
        int i11 = 0;
        for (T t10 : mVar) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return null;
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C o1(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            c10.add(pVar.invoke(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return c10;
    }

    @os.l
    public static <T> gq.m<T> o2(@os.l gq.m<? extends T> mVar, T t10) {
        l0.p(mVar, "<this>");
        return gq.s.i(gq.s.q(mVar, gq.s.q(t10)));
    }

    @f1(version = "1.2")
    @os.l
    public static final <T, R> gq.m<R> o3(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super T, ? super T, ? extends R> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "transform");
        return gq.q.b(new b0(mVar, pVar, null));
    }

    @os.l
    public static <T> gq.m<T> p0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "predicate");
        return new gq.h(mVar, true, lVar);
    }

    @os.l
    public static <T, R> gq.m<R> p1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "transform");
        return v0(new gq.a0(mVar, lVar));
    }

    @os.l
    public static final <T> gq.m<T> p2(@os.l gq.m<? extends T> mVar, @os.l T[] tArr) {
        l0.p(mVar, "<this>");
        l0.p(tArr, "elements");
        return n2(mVar, nm.p.t(tArr));
    }

    @os.l
    public static final <T> gq.m<T> q0(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super Integer, ? super T, Boolean> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "predicate");
        return new gq.a0(new gq.h(new gq.k(mVar), true, new d(pVar)), e.INSTANCE);
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C q1(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                c10.add(rInvoke);
            }
        }
        return c10;
    }

    @an.f
    public static final <T> gq.m<T> q2(gq.m<? extends T> mVar, T t10) {
        l0.p(mVar, "<this>");
        return o2(mVar, t10);
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C r0(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.p<? super Integer, ? super T, Boolean> pVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "predicate");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            if (pVar.invoke(Integer.valueOf(i10), t10).booleanValue()) {
                c10.add(t10);
            }
            i10 = i11;
        }
        return c10;
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C r1(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.l<? super T, ? extends R> lVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            c10.add(lVar.invoke(it.next()));
        }
        return c10;
    }

    public static final <S, T extends S> S r2(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it.next();
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
        }
        return next;
    }

    public static final <R> gq.m<R> s0(gq.m<?> mVar) {
        l0.p(mVar, "<this>");
        l0.P();
        gq.m<R> mVarP0 = p0(mVar, f.INSTANCE);
        l0.n(mVarP0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return mVarP0;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @os.m
    @f1(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T s1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        ?? r10 = (Object) itA.next();
        if (!itA.hasNext()) {
            return r10;
        }
        R rInvoke = lVar.invoke(r10);
        do {
            Object obj = (Object) itA.next();
            R rInvoke2 = lVar.invoke(obj);
            r10 = r10;
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
                r10 = (T) obj;
            }
        } while (itA.hasNext());
        return (T) r10;
    }

    public static final <S, T extends S> S s2(@os.l gq.m<? extends T> mVar, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        l0.p(mVar, "<this>");
        l0.p(qVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it.next();
        int i10 = 1;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            next = qVar.invoke(Integer.valueOf(i10), next, it.next());
            i10 = i11;
        }
        return next;
    }

    public static final <R, C extends Collection<? super R>> C t0(gq.m<?> mVar, C c10) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (Object obj : mVar) {
            l0.P();
            if (obj != null) {
                c10.add(obj);
            }
        }
        return c10;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T t1(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        ?? r10 = (Object) itA.next();
        if (!itA.hasNext()) {
            return r10;
        }
        R rInvoke = lVar.invoke(r10);
        do {
            Object obj = (Object) itA.next();
            R rInvoke2 = lVar.invoke(obj);
            r10 = r10;
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
                r10 = (T) obj;
            }
        } while (itA.hasNext());
        return (T) r10;
    }

    @os.m
    @f1(version = "1.4")
    public static final <S, T extends S> S t2(@os.l gq.m<? extends T> mVar, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        l0.p(mVar, "<this>");
        l0.p(qVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i10 = 1;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                if (!an.m.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                nm.y.Z();
            }
            next = qVar.invoke(Integer.valueOf(i10), next, it.next());
            i10 = i11;
        }
        return next;
    }

    @os.l
    public static <T> gq.m<T> u0(@os.l gq.m<? extends T> mVar, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "<this>");
        l0.p(lVar, "predicate");
        return new gq.h(mVar, false, lVar);
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T> double u1(gq.m<? extends T> mVar, jn.l<? super T, Double> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke((Object) itA.next()).doubleValue();
        while (itA.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke((Object) itA.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @os.m
    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <S, T extends S> S u2(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
        }
        return next;
    }

    @os.l
    public static <T> gq.m<T> v0(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        gq.m<T> mVarU0 = u0(mVar, g.INSTANCE);
        l0.n(mVarU0, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return mVarU0;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T> float v1(gq.m<? extends T> mVar, jn.l<? super T, Float> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke((Object) itA.next()).floatValue();
        while (itA.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke((Object) itA.next()).floatValue());
        }
        return fFloatValue;
    }

    @os.l
    public static final <T> gq.m<T> v2(@os.l gq.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return k1(mVar, new s(mVar));
    }

    @os.l
    public static final <C extends Collection<? super T>, T> C w0(@os.l gq.m<? extends T> mVar, @os.l C c10) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (T t10 : mVar) {
            if (t10 != null) {
                c10.add(t10);
            }
        }
        return c10;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R w1(gq.m<? extends T> mVar, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke((Object) itA.next());
        while (itA.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) itA.next());
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @f1(version = "1.4")
    @os.l
    public static final <T, R> gq.m<R> w2(@os.l gq.m<? extends T> mVar, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "operation");
        return gq.q.b(new t(r10, mVar, pVar, null));
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C x0(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (T t10 : mVar) {
            if (!lVar.invoke(t10).booleanValue()) {
                c10.add(t10);
            }
        }
        return c10;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R x1(gq.m<? extends T> mVar, jn.l<? super T, ? extends R> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        R rInvoke = lVar.invoke((Object) itA.next());
        while (itA.hasNext()) {
            R rInvoke2 = lVar.invoke((Object) itA.next());
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @f1(version = "1.4")
    @os.l
    public static final <T, R> gq.m<R> x2(@os.l gq.m<? extends T> mVar, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        l0.p(mVar, "<this>");
        l0.p(qVar, "operation");
        return gq.q.b(new u(r10, mVar, qVar, null));
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C y0(@os.l gq.m<? extends T> mVar, @os.l C c10, @os.l jn.l<? super T, Boolean> lVar) {
        l0.p(mVar, "<this>");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (T t10 : mVar) {
            if (lVar.invoke(t10).booleanValue()) {
                c10.add(t10);
            }
        }
        return c10;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T> Double y1(gq.m<? extends T> mVar, jn.l<? super T, Double> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        double dDoubleValue = lVar.invoke((Object) itA.next()).doubleValue();
        while (itA.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke((Object) itA.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <S, T extends S> gq.m<S> y2(@os.l gq.m<? extends T> mVar, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        l0.p(mVar, "<this>");
        l0.p(pVar, "operation");
        return gq.q.b(new C0187v(mVar, pVar, null));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @an.f
    public static final <T> T z0(gq.m<? extends T> mVar, jn.l<? super T, Boolean> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "predicate");
        while (itA.hasNext()) {
            ?? r10 = (Object) itA.next();
            if (lVar.invoke(r10).booleanValue()) {
                return r10;
            }
        }
        return null;
    }

    @lm.s0
    @f1(version = "1.4")
    @an.f
    public static final <T> Float z1(gq.m<? extends T> mVar, jn.l<? super T, Float> lVar) {
        Iterator itA = gq.t.a(mVar, "<this>", lVar, "selector");
        if (!itA.hasNext()) {
            return null;
        }
        float fFloatValue = lVar.invoke((Object) itA.next()).floatValue();
        while (itA.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke((Object) itA.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @f1(version = "1.4")
    @os.l
    public static final <S, T extends S> gq.m<S> z2(@os.l gq.m<? extends T> mVar, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        l0.p(mVar, "<this>");
        l0.p(qVar, "operation");
        return gq.q.b(new w(mVar, qVar, null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> extends n0 implements jn.l<Integer, T> {
        final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i10) {
            super(1);
            this.$index = i10;
        }

        public final T invoke(int i10) {
            throw new IndexOutOfBoundsException(u.a.a(new StringBuilder("Sequence doesn't contain element at index "), this.$index, n1.e.f11183c));
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }
}
