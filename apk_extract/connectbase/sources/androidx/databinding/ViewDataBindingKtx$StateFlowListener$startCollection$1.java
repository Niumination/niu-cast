package androidx.databinding;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import da.b;
import jn.p;
import lm.d1;
import lm.l2;
import nq.s0;
import os.l;
import os.m;
import sq.i;
import sq.j;
import um.d;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1", f = "ViewDataBindingKtx.kt", i = {}, l = {b.f3634e}, m = "invokeSuspend", n = {}, s = {})
public final class ViewDataBindingKtx$StateFlowListener$startCollection$1 extends o implements p<s0, d<? super l2>, Object> {
    final /* synthetic */ i<Object> $flow;
    final /* synthetic */ LifecycleOwner $owner;
    int label;
    final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

    /* JADX INFO: renamed from: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1, reason: invalid class name */
    @f(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1", f = "ViewDataBindingKtx.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends o implements p<s0, d<? super l2>, Object> {
        final /* synthetic */ i<Object> $flow;
        int label;
        final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(i<? extends Object> iVar, ViewDataBindingKtx.StateFlowListener stateFlowListener, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$flow = iVar;
            this.this$0 = stateFlowListener;
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            return new AnonymousClass1(this.$flow, this.this$0, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                i<Object> iVar = this.$flow;
                final ViewDataBindingKtx.StateFlowListener stateFlowListener = this.this$0;
                j<? super Object> jVar = new j() { // from class: androidx.databinding.ViewDataBindingKtx.StateFlowListener.startCollection.1.1.1
                    @Override // sq.j
                    @m
                    public final Object emit(@m Object obj2, @l d<? super l2> dVar) {
                        ViewDataBinding binder = stateFlowListener.listener.getBinder();
                        if (binder != null) {
                            binder.handleFieldChange(stateFlowListener.listener.mLocalFieldId, stateFlowListener.listener.getTarget(), 0);
                        }
                        return l2.f10208a;
                    }
                };
                this.label = 1;
                if (iVar.a(jVar, this) == aVar) {
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
            return ((AnonymousClass1) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewDataBindingKtx$StateFlowListener$startCollection$1(LifecycleOwner lifecycleOwner, i<? extends Object> iVar, ViewDataBindingKtx.StateFlowListener stateFlowListener, d<? super ViewDataBindingKtx$StateFlowListener$startCollection$1> dVar) {
        super(2, dVar);
        this.$owner = lifecycleOwner;
        this.$flow = iVar;
        this.this$0 = stateFlowListener;
    }

    @Override // xm.a
    @l
    public final d<l2> create(@m Object obj, @l d<?> dVar) {
        return new ViewDataBindingKtx$StateFlowListener$startCollection$1(this.$owner, this.$flow, this.this$0, dVar);
    }

    @Override // xm.a
    @m
    public final Object invokeSuspend(@l Object obj) {
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i10 = this.label;
        if (i10 == 0) {
            d1.n(obj);
            Lifecycle lifecycle = this.$owner.getLifecycle();
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flow, this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, anonymousClass1, this) == aVar) {
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
        return ((ViewDataBindingKtx$StateFlowListener$startCollection$1) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
    }
}
