package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {

    @l
    private final Class<T> clazz;

    @l
    private final jn.l<CreationExtras, T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelInitializer(@l Class<T> cls, @l jn.l<? super CreationExtras, ? extends T> lVar) {
        l0.p(cls, "clazz");
        l0.p(lVar, "initializer");
        this.clazz = cls;
        this.initializer = lVar;
    }

    @l
    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    @l
    public final jn.l<CreationExtras, T> getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
