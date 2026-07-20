package el;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import lm.d1;
import lm.l2;
import nq.k1;
import nq.s0;
import nq.t0;
import pl.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ConcurrentHashMap<String, byte[]> f4543a = new ConcurrentHashMap<>();

    @xm.f(c = "io.ktor.sessions.SessionStorageMemory", f = "SessionStorageMemory.kt", i = {0}, l = {34}, m = "read", n = {dc.d.f3692w}, s = {"L$0"})
    public static final class a<R> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.this.c(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.sessions.SessionStorageMemory$write$2", f = "SessionStorageMemory.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ jn.p<pl.n, um.d<? super l2>, Object> $provider;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        @xm.f(c = "io.ktor.sessions.SessionStorageMemory$write$2$channel$1", f = "SessionStorageMemory.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<m0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.p<pl.n, um.d<? super l2>, Object> $provider;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(jn.p<? super pl.n, ? super um.d<? super l2>, ? extends Object> pVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$provider = pVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                a aVar = new a(this.$provider, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    m0 m0Var = (m0) this.L$0;
                    jn.p<pl.n, um.d<? super l2>, Object> pVar = this.$provider;
                    pl.n nVarMo71a = m0Var.mo71a();
                    this.label = 1;
                    if (pVar.invoke(nVarMo71a, this) == aVar) {
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
            @os.m
            public final Object invoke(@os.l m0 m0Var, @os.m um.d<? super l2> dVar) {
                return ((a) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(String str, jn.p<? super pl.n, ? super um.d<? super l2>, ? extends Object> pVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$id = str;
            this.$provider = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = q.this.new b(this.$id, this.$provider, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            Map map;
            String str;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                pl.k kVarA = pl.v.k((s0) this.L$0, k1.g(), true, new a(this.$provider, null)).a();
                ConcurrentHashMap<String, byte[]> concurrentHashMap = q.this.f4543a;
                String str2 = this.$id;
                this.L$0 = concurrentHashMap;
                this.L$1 = str2;
                this.label = 1;
                obj = gl.k.b(kVarA, 0, this, 1, null);
                if (obj == aVar) {
                    return aVar;
                }
                map = concurrentHashMap;
                str = str2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$1;
                map = (Map) this.L$0;
                d1.n(obj);
            }
            map.put(str, obj);
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @Override // el.p
    @os.m
    public Object a(@os.l String str, @os.l jn.p<? super pl.n, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
        Object objG = t0.g(new b(str, pVar, null), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    @Override // el.p
    @os.m
    public Object b(@os.l String str, @os.l um.d<? super l2> dVar) {
        Object objRemove = this.f4543a.remove(str);
        return objRemove == wm.a.COROUTINE_SUSPENDED ? objRemove : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0055 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // el.p
    @os.m
    public <R> Object c(@os.l String str, @os.l jn.p<? super pl.k, ? super um.d<? super R>, ? extends Object> pVar, @os.l um.d<? super R> dVar) {
        a aVar;
        Object obj;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object objInvoke = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(objInvoke);
            byte[] bArr = this.f4543a.get(str);
            if (bArr == null) {
                obj = null;
            } else {
                pl.k kVarB = pl.d.b(bArr);
                aVar.L$0 = str;
                aVar.label = 1;
                objInvoke = pVar.invoke(kVarB, aVar);
                if (objInvoke == aVar2) {
                    return aVar2;
                }
            }
            if (obj != null) {
                return obj;
            }
            throw new NoSuchElementException(n.a.a("Session ", str, " not found"));
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) aVar.L$0;
        d1.n(objInvoke);
        obj = objInvoke;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException(n.a.a("Session ", str, " not found"));
    }
}
