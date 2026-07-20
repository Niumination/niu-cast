package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import in.b;
import in.j;
import jn.a;
import kn.l0;
import kn.n0;
import kn.w;
import lm.d0;
import os.l;
import os.m;
import un.d;

/* JADX INFO: loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements d0<VM> {

    @m
    private VM cached;

    @l
    private final a<CreationExtras> extrasProducer;

    @l
    private final a<ViewModelProvider.Factory> factoryProducer;

    @l
    private final a<ViewModelStore> storeProducer;

    @l
    private final d<VM> viewModelClass;

    /* JADX INFO: renamed from: androidx.lifecycle.ViewModelLazy$1, reason: invalid class name */
    public static final class AnonymousClass1 extends n0 implements a<CreationExtras.Empty> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public ViewModelLazy(@l d<VM> dVar, @l a<? extends ViewModelStore> aVar, @l a<? extends ViewModelProvider.Factory> aVar2) {
        this(dVar, aVar, aVar2, null, 8, null);
        l0.p(dVar, "viewModelClass");
        l0.p(aVar, "storeProducer");
        l0.p(aVar2, "factoryProducer");
    }

    @Override // lm.d0
    public boolean isInitialized() {
        return this.cached != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @j
    public ViewModelLazy(@l d<VM> dVar, @l a<? extends ViewModelStore> aVar, @l a<? extends ViewModelProvider.Factory> aVar2, @l a<? extends CreationExtras> aVar3) {
        l0.p(dVar, "viewModelClass");
        l0.p(aVar, "storeProducer");
        l0.p(aVar2, "factoryProducer");
        l0.p(aVar3, "extrasProducer");
        this.viewModelClass = dVar;
        this.storeProducer = aVar;
        this.factoryProducer = aVar2;
        this.extrasProducer = aVar3;
    }

    @Override // lm.d0
    @l
    public VM getValue() {
        VM vm2 = this.cached;
        if (vm2 != null) {
            return vm2;
        }
        VM vm3 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).get(b.e(this.viewModelClass));
        this.cached = vm3;
        return vm3;
    }

    public /* synthetic */ ViewModelLazy(d dVar, a aVar, a aVar2, a aVar3, int i10, w wVar) {
        this(dVar, aVar, aVar2, (i10 & 8) != 0 ? AnonymousClass1.INSTANCE : aVar3);
    }
}
