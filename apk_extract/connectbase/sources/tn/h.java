package tn;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.lang.Comparable;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public class h<T extends Comparable<? super T>> implements r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final T f15906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final T f15907b;

    public h(@os.l T t10, @os.l T t11) {
        l0.p(t10, FloatingWindow.f2048b0);
        l0.p(t11, "endExclusive");
        this.f15906a = t10;
        this.f15907b = t11;
    }

    @Override // tn.r
    @os.l
    public T c() {
        return this.f15907b;
    }

    @Override // tn.r
    public boolean contains(@os.l T t10) {
        return r.a.a(this, t10);
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (!l0.g(getStart(), hVar.getStart()) || !l0.g(c(), hVar.c())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.r
    @os.l
    public T getStart() {
        return this.f15906a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return c().hashCode() + (getStart().hashCode() * 31);
    }

    @Override // tn.r
    public boolean isEmpty() {
        return r.a.b(this);
    }

    @os.l
    public String toString() {
        return getStart() + "..<" + c();
    }
}
