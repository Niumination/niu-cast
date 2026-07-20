package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import in.n;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kn.l0;
import nq.k;
import nq.l2;
import os.l;
import os.m;
import sq.i;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ViewDataBindingKtx {

    @l
    public static final ViewDataBindingKtx INSTANCE = new ViewDataBindingKtx();

    @l
    private static final CreateWeakListener CREATE_STATE_FLOW_LISTENER = new a();

    public static final class StateFlowListener implements ObservableReference<i<? extends Object>> {

        @m
        private WeakReference<LifecycleOwner> _lifecycleOwnerRef;

        @l
        private final WeakListener<i<Object>> listener;

        @m
        private l2 observerJob;

        public StateFlowListener(@m ViewDataBinding viewDataBinding, int i10, @l ReferenceQueue<ViewDataBinding> referenceQueue) {
            l0.p(referenceQueue, "referenceQueue");
            this.listener = new WeakListener<>(viewDataBinding, i10, this, referenceQueue);
        }

        private final void startCollection(LifecycleOwner lifecycleOwner, i<? extends Object> iVar) {
            l2 l2Var = this.observerJob;
            if (l2Var != null) {
                l2.a.b(l2Var, null, 1, null);
            }
            this.observerJob = k.f(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new ViewDataBindingKtx$StateFlowListener$startCollection$1(lifecycleOwner, iVar, this, null), 3, null);
        }

        @Override // androidx.databinding.ObservableReference
        @l
        public WeakListener<i<? extends Object>> getListener() {
            return this.listener;
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(@m LifecycleOwner lifecycleOwner) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if ((weakReference != null ? weakReference.get() : null) == lifecycleOwner) {
                return;
            }
            l2 l2Var = this.observerJob;
            if (l2Var != null) {
                l2.a.b(l2Var, null, 1, null);
            }
            if (lifecycleOwner == null) {
                this._lifecycleOwnerRef = null;
                return;
            }
            this._lifecycleOwnerRef = new WeakReference<>(lifecycleOwner);
            i<? extends Object> iVar = (i) this.listener.getTarget();
            if (iVar != null) {
                startCollection(lifecycleOwner, iVar);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(@m i<? extends Object> iVar) {
            LifecycleOwner lifecycleOwner;
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if (weakReference == null || (lifecycleOwner = weakReference.get()) == null || iVar == null) {
                return;
            }
            startCollection(lifecycleOwner, iVar);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(@m i<? extends Object> iVar) {
            l2 l2Var = this.observerJob;
            if (l2Var != null) {
                l2.a.b(l2Var, null, 1, null);
            }
            this.observerJob = null;
        }
    }

    private ViewDataBindingKtx() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeakListener CREATE_STATE_FLOW_LISTENER$lambda$0(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
        l0.m(referenceQueue);
        return new StateFlowListener(viewDataBinding, i10, referenceQueue).getListener();
    }

    @n
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean updateStateFlowRegistration(@l ViewDataBinding viewDataBinding, int i10, @m i<?> iVar) {
        l0.p(viewDataBinding, "viewDataBinding");
        viewDataBinding.mInStateFlowRegisterObserver = true;
        try {
            return viewDataBinding.updateRegistration(i10, iVar, CREATE_STATE_FLOW_LISTENER);
        } finally {
            viewDataBinding.mInStateFlowRegisterObserver = false;
        }
    }
}
