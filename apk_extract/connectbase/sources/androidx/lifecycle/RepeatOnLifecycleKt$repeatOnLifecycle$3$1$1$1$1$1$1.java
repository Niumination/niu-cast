package androidx.lifecycle;

import jn.p;
import lm.d1;
import lm.l2;
import nq.s0;
import os.l;
import os.m;
import um.d;
import xm.f;
import xm.o;
import y5.a;

/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {}, l = {a.f20714d0}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends o implements p<s0, d<? super l2>, Object> {
    final /* synthetic */ p<s0, d<? super l2>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(p<? super s0, ? super d<? super l2>, ? extends Object> pVar, d<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1> dVar) {
        super(2, dVar);
        this.$block = pVar;
    }

    @Override // xm.a
    @l
    public final d<l2> create(@m Object obj, @l d<?> dVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.$block, dVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1;
    }

    @Override // xm.a
    @m
    public final Object invokeSuspend(@l Object obj) {
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i10 = this.label;
        if (i10 == 0) {
            d1.n(obj);
            s0 s0Var = (s0) this.L$0;
            p<s0, d<? super l2>, Object> pVar = this.$block;
            this.label = 1;
            if (pVar.invoke(s0Var, this) == aVar) {
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
    public final Object invoke(@l s0 s0Var, @m d<? super l2> dVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
    }
}
