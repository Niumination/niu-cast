package hl;

import fl.t0;
import fl.x0;
import java.util.Collection;
import java.util.Iterator;
import kn.l0;
import kn.v;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@t0
public class b<E> implements Collection<E>, ln.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Collection<E> f7242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final x0 f7243b;

    public b(@l Collection<E> collection, @l x0 x0Var) {
        l0.p(collection, "delegate");
        l0.p(x0Var, "lock");
        this.f7242a = collection;
        this.f7243b = x0Var;
    }

    @Override // java.util.Collection
    public boolean add(E e10) {
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.add(e10);
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection
    public boolean addAll(@l Collection<? extends E> collection) {
        l0.p(collection, "elements");
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.addAll(collection);
        } finally {
            x0Var.c();
        }
    }

    public int c() {
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.size();
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection
    public void clear() {
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            this.f7242a.clear();
            l2 l2Var = l2.f10208a;
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.contains(obj);
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection
    public boolean containsAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.containsAll(collection);
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.isEmpty();
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    @l
    public Iterator<E> iterator() {
        return this.f7242a.iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.remove(obj);
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.removeAll(collection);
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection
    public boolean retainAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        x0 x0Var = this.f7243b;
        try {
            x0Var.b();
            return this.f7242a.retainAll(collection);
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return c();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return v.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        l0.p(tArr, dc.d.f3685p);
        return (T[]) v.b(this, tArr);
    }
}
