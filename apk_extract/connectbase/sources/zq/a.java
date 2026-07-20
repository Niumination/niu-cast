package zq;

import in.x;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import lm.d1;
import lm.l2;
import os.l;
import os.m;
import sq.i;
import sq.j;
import xm.d;
import xm.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements i<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final AtomicIntegerFieldUpdater f21964b = AtomicIntegerFieldUpdater.newUpdater(a.class, "consumed");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Stream<T> f21965a;

    @x
    private volatile int consumed = 0;

    /* JADX INFO: renamed from: zq.a$a, reason: collision with other inner class name */
    @f(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", i = {0, 0}, l = {26}, m = "collect", n = {"this", "collector"}, s = {"L$0", "L$1"})
    public static final class C0612a extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0612a(a<T> aVar, um.d<? super C0612a> dVar) {
            super(dVar);
            this.this$0 = aVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a(null, this);
        }
    }

    public a(@l Stream<T> stream) {
        this.f21965a = stream;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005c A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #2 {all -> 0x006f, blocks: (B:22:0x0056, B:24:0x005c), top: B:41:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x006e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[LOOP:0: B:41:0x0056->B:46:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // sq.i
    @m
    public Object a(@l j<? super T> jVar, @l um.d<? super l2> dVar) throws Throwable {
        C0612a c0612a;
        a<T> aVar;
        Throwable th2;
        Iterator<T> it;
        j jVar2;
        T next;
        if (dVar instanceof C0612a) {
            c0612a = (C0612a) dVar;
            int i10 = c0612a.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0612a.label = i10 - Integer.MIN_VALUE;
            } else {
                c0612a = new C0612a(this, dVar);
            }
        } else {
            c0612a = new C0612a(this, dVar);
        }
        Object obj = c0612a.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0612a.label;
        if (i11 == 0) {
            d1.n(obj);
            if (!f21964b.compareAndSet(this, 0, 1)) {
                throw new IllegalStateException("Stream.consumeAsFlow can be collected only once");
            }
            try {
                aVar = this;
                it = this.f21965a.iterator();
                jVar2 = jVar;
                while (it.hasNext()) {
                    next = it.next();
                    c0612a.L$0 = aVar;
                    c0612a.L$1 = jVar2;
                    c0612a.L$2 = it;
                    c0612a.label = 1;
                    if (jVar2.emit(next, c0612a) == aVar2) {
                        return aVar2;
                    }
                }
                aVar.f21965a.close();
                return l2.f10208a;
            } catch (Throwable th3) {
                aVar = this;
                th2 = th3;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) c0612a.L$2;
            j jVar3 = (j) c0612a.L$1;
            a<T> aVar3 = (a) c0612a.L$0;
            try {
                d1.n(obj);
                jVar2 = jVar3;
                aVar = aVar3;
                while (it.hasNext()) {
                    try {
                        next = it.next();
                        c0612a.L$0 = aVar;
                        c0612a.L$1 = jVar2;
                        c0612a.L$2 = it;
                        c0612a.label = 1;
                        if (jVar2.emit(next, c0612a) == aVar2) {
                            return aVar2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                    }
                }
                aVar.f21965a.close();
                return l2.f10208a;
            } catch (Throwable th5) {
                th2 = th5;
                aVar = aVar3;
            }
        }
        aVar.f21965a.close();
        throw th2;
    }
}
