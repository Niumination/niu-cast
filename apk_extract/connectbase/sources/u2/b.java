package u2;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jn.p;
import kn.l0;
import kn.r1;
import lm.d1;
import lm.l2;
import lm.t0;
import nm.h0;
import nq.k;
import nq.s0;
import nq.x3;
import os.l;
import os.m;
import um.g;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nDataBus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n11065#2:117\n11400#2,3:118\n1282#2,2:136\n55#3,5:121\n62#3:143\n55#3,5:144\n62#3:167\n1603#4,9:126\n1855#4:135\n1856#4:139\n1612#4:140\n1855#4,2:141\n766#4:149\n857#4,2:150\n1603#4,9:152\n1855#4:161\n1856#4:163\n1612#4:164\n1855#4,2:165\n1855#4,2:168\n288#4,2:170\n1855#4,2:172\n1#5:138\n1#5:162\n*S KotlinDebug\n*F\n+ 1 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n*L\n68#1:117\n68#1:118,3\n71#1:136,2\n69#1:121,5\n69#1:143\n83#1:144,5\n83#1:167\n70#1:126,9\n70#1:135\n70#1:139\n70#1:140\n75#1:141,2\n84#1:149\n84#1:150,2\n86#1:152,9\n86#1:161\n86#1:163\n86#1:164\n88#1:165,2\n95#1:168,2\n101#1:170,2\n112#1:172,2\n70#1:138\n86#1:162\n*E\n"})
public final class b implements s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final String f16176c = "DataBus";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f16178a = s2.d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final b f16175b = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final CopyOnWriteArrayList<w2.a<?>> f16177d = new CopyOnWriteArrayList<>();

    @f(c = "com.transsion.airtransfer.filetransfer.databus.DataBus$receiveMulti$2", f = "DataBus.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends o implements p<s0, um.d<? super Object>, Object> {
        final /* synthetic */ t0<Integer, Class<?>>[] $predicate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t0<Integer, Class<?>>[] t0VarArr, um.d<? super a> dVar) {
            super(2, dVar);
            this.$predicate = t0VarArr;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new a(this.$predicate, dVar);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(s0 s0Var, um.d<? super Object> dVar) {
            return invoke2(s0Var, (um.d<Object>) dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                b bVar = b.f16175b;
                t0<Integer, Class<?>>[] t0VarArr = this.$predicate;
                this.label = 1;
                obj = bVar.m(t0VarArr, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return obj;
        }

        @m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@l s0 s0Var, @m um.d<Object> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: renamed from: u2.b$b, reason: collision with other inner class name */
    @f(c = "com.transsion.airtransfer.filetransfer.databus.DataBus$receiveMulti$5$2$1", f = "DataBus.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0429b extends o implements p<Object, um.d<? super Object>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C0429b(um.d<? super C0429b> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            C0429b c0429b = new C0429b(dVar);
            c0429b.L$0 = obj;
            return c0429b;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, um.d<? super Object> dVar) {
            return invoke2(obj, (um.d<Object>) dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return this.L$0;
        }

        @m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@m Object obj, @m um.d<Object> dVar) {
            return ((C0429b) create(obj, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @f(c = "com.transsion.airtransfer.filetransfer.databus.DataBus$receiveMulti$7$3$1", f = "DataBus.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends o implements p<Object, um.d<? super Object>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public c(um.d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            c cVar = new c(dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, um.d<? super Object> dVar) {
            return invoke2(obj, (um.d<Object>) dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return this.L$0;
        }

        @m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@m Object obj, @m um.d<Object> dVar) {
            return ((c) create(obj, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nDataBus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus$receiveWitTimeOut$2\n*L\n1#1,116:1\n*E\n"})
    @f(c = "com.transsion.airtransfer.filetransfer.databus.DataBus$receiveWitTimeOut$2", f = "DataBus.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {}, s = {})
    public static final class d<T> extends o implements p<s0, um.d<? super T>, Object> {
        final /* synthetic */ Integer $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Integer num, um.d<? super d> dVar) {
            super(2, dVar);
            this.$type = num;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            l0.P();
            return new d(this.$type, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                b bVar = b.f16175b;
                l0.P();
                w2.a<T> aVarG = bVar.g(Object.class);
                Integer num = this.$type;
                this.label = 1;
                obj = aVarG.b(num, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return obj;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super T> dVar) {
            return ((d) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @r1({"SMAP\nDataBus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus$sendWithIO$1\n*L\n1#1,116:1\n*E\n"})
    @f(c = "com.transsion.airtransfer.filetransfer.databus.DataBus$sendWithIO$1", f = "DataBus.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends o implements p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ T $data;
        final /* synthetic */ Integer $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(T t10, Integer num, um.d<? super e> dVar) {
            super(2, dVar);
            this.$data = t10;
            this.$type = num;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new e(this.$data, this.$type, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                b bVar = b.f16175b;
                T t10 = this.$data;
                Integer num = this.$type;
                this.label = 1;
                if (bVar.r(t10, num, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((e) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static Object k(b bVar, Integer num, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        l0.P();
        return bVar.g(Object.class).b(num, dVar);
    }

    public static Object p(b bVar, Integer num, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        l0.P();
        return x3.f(j10, new d(num, null), dVar);
    }

    public static /* synthetic */ Object s(b bVar, Object obj, Integer num, um.d dVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        return bVar.r(obj, num, dVar);
    }

    public static /* synthetic */ void u(b bVar, Object obj, Integer num, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        l0.p(obj, "data");
        k.f(bVar, null, null, new e(obj, num, null), 3, null);
    }

    public final void e(List<? extends Class<?>> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            f16175b.i((Class) it.next());
        }
    }

    public final synchronized void f() {
        try {
            Iterator<T> it = f16177d.iterator();
            while (it.hasNext()) {
                ((w2.a) it.next()).clear();
            }
            f16177d.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized <T> w2.a<T> g(Class<?> cls) {
        w2.a<T> aVar;
        aVar = (w2.a<T>) i(cls);
        l0.n(aVar, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.intf.databus.DataQueue<T of com.transsion.airtransfer.filetransfer.databus.DataBus.findDataQueue>");
        return aVar;
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f16178a.getCoroutineContext();
    }

    public final w2.a<?> i(Class<?> cls) {
        Object next;
        Iterator<T> it = f16177d.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!l0.g(((w2.a) next).getType(), cls));
        w2.a<?> aVar = (w2.a) next;
        if (aVar != null) {
            return aVar;
        }
        u2.a aVarA = u2.a.b.f16173a.a(cls);
        f16177d.add(aVarA);
        return aVarA;
    }

    public final <T> Object j(Integer num, um.d<? super T> dVar) {
        l0.P();
        return g(Object.class).b(num, dVar);
    }

    @m
    public final Object l(@m Integer num, @l List<? extends Class<?>> list, @l um.d<Object> dVar) {
        e(list);
        yq.l lVar = new yq.l(dVar.getContext());
        CopyOnWriteArrayList<w2.a<?>> copyOnWriteArrayList = f16177d;
        ArrayList arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            w2.a aVar = (w2.a) obj;
            if (h0.W1(list, aVar.getType()) && (aVar instanceof u2.a)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            w2.a aVar2 = (w2.a) it.next();
            u2.a aVar3 = aVar2 instanceof u2.a ? (u2.a) aVar2 : null;
            pq.l lVarC = aVar3 != null ? aVar3.c(num) : null;
            if (lVarC != null) {
                arrayList2.add(lVarC);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            lVar.e(((pq.l) it2.next()).x(), new c(null));
        }
        return yq.l.z(lVar, dVar);
    }

    @m
    public final Object m(@l t0<Integer, Class<?>>[] t0VarArr, @l um.d<Object> dVar) {
        t0<Integer, Class<?>> t0Var;
        ArrayList arrayList = new ArrayList(t0VarArr.length);
        for (t0<Integer, Class<?>> t0Var2 : t0VarArr) {
            arrayList.add(t0Var2.getSecond());
        }
        e(arrayList);
        yq.l lVar = new yq.l(dVar.getContext());
        CopyOnWriteArrayList<w2.a<?>> copyOnWriteArrayList = f16177d;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (true) {
            pq.l lVarC = null;
            if (!it.hasNext()) {
                break;
            }
            w2.a aVar = (w2.a) it.next();
            int length = t0VarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    t0Var = null;
                    break;
                }
                t0Var = t0VarArr[i10];
                if (l0.g(aVar.getType(), t0Var.getSecond())) {
                    break;
                }
                i10++;
            }
            if (t0Var != null && (aVar instanceof u2.a)) {
                lVarC = ((u2.a) aVar).c(t0Var.getFirst());
            }
            if (lVarC != null) {
                arrayList2.add(lVarC);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            lVar.e(((pq.l) it2.next()).x(), new C0429b(null));
        }
        return yq.l.z(lVar, dVar);
    }

    @m
    public final Object n(long j10, @l t0<Integer, Class<?>>[] t0VarArr, @l um.d<Object> dVar) {
        return x3.f(j10, new a(t0VarArr, null), dVar);
    }

    public final <T> Object o(Integer num, long j10, um.d<? super T> dVar) {
        l0.P();
        return x3.f(j10, new d(num, null), dVar);
    }

    @m
    public final <T> Object r(@l T t10, @m Integer num, @l um.d<? super l2> dVar) {
        Object objA = g(t10.getClass()).a(t10, num, dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    public final /* synthetic */ <T> void t(T t10, Integer num) {
        l0.p(t10, "data");
        k.f(this, null, null, new e(t10, num, null), 3, null);
    }
}
