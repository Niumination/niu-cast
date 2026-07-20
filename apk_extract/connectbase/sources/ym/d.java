package ym;

import java.io.Serializable;
import java.lang.Enum;
import kn.l0;
import lm.f1;
import nm.r;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.8")
public final class d<T extends Enum<T>> extends nm.c<T> implements a<T>, Serializable {

    @l
    private final T[] entries;

    public d(@l T[] tArr) {
        l0.p(tArr, cb.b.c.f1405l);
        this.entries = tArr;
    }

    private final Object writeReplace() {
        return new e(this.entries);
    }

    @Override // nm.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return contains((Enum) obj);
        }
        return false;
    }

    @Override // nm.c, nm.a
    public int getSize() {
        return this.entries.length;
    }

    @Override // nm.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((Enum) obj);
        }
        return -1;
    }

    @Override // nm.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return lastIndexOf((Enum) obj);
        }
        return -1;
    }

    public boolean contains(@l T t10) {
        l0.p(t10, "element");
        return ((Enum) r.Pe(this.entries, t10.ordinal())) == t10;
    }

    @Override // nm.c, java.util.List
    @l
    public T get(int i10) {
        nm.c.Companion.b(i10, this.entries.length);
        return this.entries[i10];
    }

    public int indexOf(@l T t10) {
        l0.p(t10, "element");
        int iOrdinal = t10.ordinal();
        if (((Enum) r.Pe(this.entries, iOrdinal)) == t10) {
            return iOrdinal;
        }
        return -1;
    }

    public int lastIndexOf(@l T t10) {
        l0.p(t10, "element");
        return indexOf((Object) t10);
    }
}
