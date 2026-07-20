package tn;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.lang.Comparable;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public class i<T extends Comparable<? super T>> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final T f15908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final T f15909b;

    public i(@os.l T t10, @os.l T t11) {
        l0.p(t10, FloatingWindow.f2048b0);
        l0.p(t11, "endInclusive");
        this.f15908a = t10;
        this.f15909b = t11;
    }

    @Override // tn.g
    public boolean contains(@os.l T t10) {
        return g.a.a(this, t10);
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (!l0.g(getStart(), iVar.getStart()) || !l0.g(getEndInclusive(), iVar.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.g
    @os.l
    public T getEndInclusive() {
        return this.f15909b;
    }

    @Override // tn.g
    @os.l
    public T getStart() {
        return this.f15908a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return getEndInclusive().hashCode() + (getStart().hashCode() * 31);
    }

    @Override // tn.g
    public boolean isEmpty() {
        return g.a.b(this);
    }

    @os.l
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
