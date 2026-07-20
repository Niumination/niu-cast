package l3;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class s2 extends AbstractList implements RandomAccess, e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f7293a;

    public s2(d1 d1Var) {
        this.f7293a = d1Var;
    }

    @Override // l3.e1
    public final e1 a() {
        return this;
    }

    @Override // l3.e1
    public final List c() {
        return Collections.unmodifiableList(this.f7293a.f7231b);
    }

    @Override // l3.e1
    public final Object d(int i8) {
        return this.f7293a.f7231b.get(i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i8) {
        return this.f7293a.get(i8);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new r2(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i8) {
        return new q2(this, i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7293a.f7231b.size();
    }
}
