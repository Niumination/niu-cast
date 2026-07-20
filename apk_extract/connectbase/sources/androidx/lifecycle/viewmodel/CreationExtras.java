package androidx.lifecycle.viewmodel;

import cb.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class CreationExtras {

    @l
    private final Map<Key<?>, Object> map = new LinkedHashMap();

    public static final class Empty extends CreationExtras {

        @l
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        @m
        public <T> T get(@l Key<T> key) {
            l0.p(key, b.c.f1408o);
            return null;
        }
    }

    public interface Key<T> {
    }

    @m
    public abstract <T> T get(@l Key<T> key);

    @l
    public final Map<Key<?>, Object> getMap$lifecycle_viewmodel_release() {
        return this.map;
    }
}
