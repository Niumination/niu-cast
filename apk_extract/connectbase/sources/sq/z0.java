package sq;

import java.util.List;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class z0<T> implements j0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final j0<T> f15410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.p<j<? super T>, um.d<? super l2>, Object> f15411b;

    @xm.f(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", i = {}, l = {409}, m = "collect", n = {}, s = {})
    public static final class a extends xm.d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ z0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(z0<T> z0Var, um.d<? super a> dVar) {
            super(dVar);
            this.this$0 = z0Var;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z0(@os.l j0<? extends T> j0Var, @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        this.f15410a = j0Var;
        this.f15411b = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // sq.j0, sq.i
    @os.m
    public Object a(@os.l j<? super T> jVar, @os.l um.d<?> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, dVar);
            }
        } else {
            aVar = new a(this, dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(obj);
            j0<T> j0Var = this.f15410a;
            y0 y0Var = new y0(jVar, this.f15411b);
            aVar.label = 1;
            if (j0Var.a(y0Var, aVar) == aVar2) {
                return aVar2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
        }
        throw new lm.y();
    }

    @Override // sq.j0
    @os.l
    public List<T> e() {
        return this.f15410a.e();
    }
}
