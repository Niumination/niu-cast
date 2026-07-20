package um;

import java.io.Serializable;
import jn.p;
import kn.k1;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.f1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
@f1(version = "1.3")
public final class c implements g, Serializable {

    @l
    private final g.b element;

    @l
    private final g left;

    @r1({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,196:1\n12720#2,3:197\n*S KotlinDebug\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n*L\n193#1:197,3\n*E\n"})
    public static final class a implements Serializable {

        @l
        public static final C0437a Companion = new C0437a();
        private static final long serialVersionUID = 0;

        @l
        private final g[] elements;

        /* JADX INFO: renamed from: um.c$a$a, reason: collision with other inner class name */
        public static final class C0437a {
            public C0437a() {
            }

            public C0437a(w wVar) {
            }
        }

        public a(@l g[] gVarArr) {
            l0.p(gVarArr, "elements");
            this.elements = gVarArr;
        }

        private final Object readResolve() {
            g[] gVarArr = this.elements;
            g gVarPlus = i.INSTANCE;
            for (g gVar : gVarArr) {
                gVarPlus = gVarPlus.plus(gVar);
            }
            return gVarPlus;
        }

        @l
        public final g[] getElements() {
            return this.elements;
        }
    }

    public static final class b extends n0 implements p<String, g.b, String> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @Override // jn.p
        @l
        public final String invoke(@l String str, @l g.b bVar) {
            l0.p(str, "acc");
            l0.p(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    /* JADX INFO: renamed from: um.c$c, reason: collision with other inner class name */
    public static final class C0438c extends n0 implements p<l2, g.b, l2> {
        final /* synthetic */ g[] $elements;
        final /* synthetic */ k1.f $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0438c(g[] gVarArr, k1.f fVar) {
            super(2);
            this.$elements = gVarArr;
            this.$index = fVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(l2 l2Var, g.b bVar) {
            invoke2(l2Var, bVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l l2 l2Var, @l g.b bVar) {
            l0.p(l2Var, "<anonymous parameter 0>");
            l0.p(bVar, "element");
            g[] gVarArr = this.$elements;
            k1.f fVar = this.$index;
            int i10 = fVar.element;
            fVar.element = i10 + 1;
            gVarArr[i10] = bVar;
        }
    }

    public c(@l g gVar, @l g.b bVar) {
        l0.p(gVar, "left");
        l0.p(bVar, "element");
        this.left = gVar;
        this.element = bVar;
    }

    private final int f() {
        int i10 = 2;
        while (true) {
            g gVar = this.left;
            this = gVar instanceof c ? (c) gVar : null;
            if (this == null) {
                return i10;
            }
            i10++;
        }
    }

    private final Object writeReplace() {
        int iF = f();
        g[] gVarArr = new g[iF];
        k1.f fVar = new k1.f();
        fold(l2.f10208a, new C0438c(gVarArr, fVar));
        if (fVar.element == iF) {
            return new a(gVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public final boolean d(g.b bVar) {
        return l0.g(get(bVar.getKey()), bVar);
    }

    public final boolean e(c cVar) {
        while (d(cVar.element)) {
            g gVar = cVar.left;
            if (!(gVar instanceof c)) {
                l0.n(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    public boolean equals(@m Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f() != f() || !cVar.e(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // um.g
    public <R> R fold(R r10, @l p<? super R, ? super g.b, ? extends R> pVar) {
        l0.p(pVar, "operation");
        return pVar.invoke((Object) this.left.fold(r10, pVar), this.element);
    }

    @Override // um.g
    @m
    public <E extends g.b> E get(@l g.c<E> cVar) {
        l0.p(cVar, cb.b.c.f1408o);
        while (true) {
            E e10 = (E) this.element.get(cVar);
            if (e10 != null) {
                return e10;
            }
            g gVar = this.left;
            if (!(gVar instanceof c)) {
                return (E) gVar.get(cVar);
            }
            this = (c) gVar;
        }
    }

    public int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // um.g
    @l
    public g minusKey(@l g.c<?> cVar) {
        l0.p(cVar, cb.b.c.f1408o);
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        g gVarMinusKey = this.left.minusKey(cVar);
        if (gVarMinusKey == this.left) {
            return this;
        }
        return gVarMinusKey == i.INSTANCE ? this.element : new c(gVarMinusKey, this.element);
    }

    @Override // um.g
    @l
    public g plus(@l g gVar) {
        return g.a.a(this, gVar);
    }

    @l
    public String toString() {
        return l.a.a(new StringBuilder("["), (String) fold("", b.INSTANCE), ']');
    }
}
