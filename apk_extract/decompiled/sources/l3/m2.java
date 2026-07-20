package l3;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class m2 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7272a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f7274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h2 f7275d;

    public /* synthetic */ m2(h2 h2Var) {
        this.f7275d = h2Var;
    }

    public final Iterator a() {
        if (this.f7274c == null) {
            this.f7274c = this.f7275d.f7246c.entrySet().iterator();
        }
        return this.f7274c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i8 = this.f7272a + 1;
        h2 h2Var = this.f7275d;
        if (i8 >= h2Var.f7245b.size()) {
            return !h2Var.f7246c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f7273b = true;
        int i8 = this.f7272a + 1;
        this.f7272a = i8;
        h2 h2Var = this.f7275d;
        return i8 < h2Var.f7245b.size() ? (Map.Entry) h2Var.f7245b.get(this.f7272a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f7273b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f7273b = false;
        int i8 = h2.f7243i;
        h2 h2Var = this.f7275d;
        h2Var.h();
        if (this.f7272a >= h2Var.f7245b.size()) {
            a().remove();
            return;
        }
        int i9 = this.f7272a;
        this.f7272a = i9 - 1;
        h2Var.f(i9);
    }
}
