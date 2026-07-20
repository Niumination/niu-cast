package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import cb.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelStore {

    @l
    private final Map<String, ViewModel> map = new LinkedHashMap();

    public final void clear() {
        Iterator<ViewModel> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
    }

    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ViewModel get(@l String str) {
        l0.p(str, b.c.f1408o);
        return this.map.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @l
    public final Set<String> keys() {
        return new HashSet(this.map.keySet());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void put(@l String str, @l ViewModel viewModel) {
        l0.p(str, b.c.f1408o);
        l0.p(viewModel, "viewModel");
        ViewModel viewModelPut = this.map.put(str, viewModel);
        if (viewModelPut != null) {
            viewModelPut.onCleared();
        }
    }
}
