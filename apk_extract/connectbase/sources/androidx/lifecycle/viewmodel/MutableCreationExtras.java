package androidx.lifecycle.viewmodel;

import cb.b;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableCreationExtras() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    @m
    public <T> T get(@l CreationExtras.Key<T> key) {
        l0.p(key, b.c.f1408o);
        return (T) getMap$lifecycle_viewmodel_release().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void set(@l CreationExtras.Key<T> key, T t10) {
        l0.p(key, b.c.f1408o);
        getMap$lifecycle_viewmodel_release().put(key, t10);
    }

    public MutableCreationExtras(@l CreationExtras creationExtras) {
        l0.p(creationExtras, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(creationExtras.getMap$lifecycle_viewmodel_release());
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i10, w wVar) {
        this((i10 & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
