package x4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f10845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f10846b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f10848d;
    public final /* synthetic */ int e;

    public m(q qVar, int i8) {
        this.e = i8;
        this.f10848d = qVar;
        this.f10845a = qVar.header.f10854d;
        this.f10847c = qVar.modCount;
    }

    public final Object a() {
        return b();
    }

    public final p b() {
        p pVar = this.f10845a;
        q qVar = this.f10848d;
        if (pVar == qVar.header) {
            throw new NoSuchElementException();
        }
        if (qVar.modCount != this.f10847c) {
            throw new ConcurrentModificationException();
        }
        this.f10845a = pVar.f10854d;
        this.f10846b = pVar;
        return pVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10845a != this.f10848d.header;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.e) {
            case 1:
                return b().f10855h;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        p pVar = this.f10846b;
        if (pVar == null) {
            throw new IllegalStateException();
        }
        q qVar = this.f10848d;
        qVar.removeInternal(pVar, true);
        this.f10846b = null;
        this.f10847c = qVar.modCount;
    }
}
