package h4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k3.s8;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Iterator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s8 f5253d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ se.e f5255i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f5250a = b.NOT_READY;
    public int e = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5254h = Integer.MAX_VALUE;

    public s(se.e eVar, sj.a aVar, String str) {
        this.f5255i = eVar;
        this.f5253d = (d) aVar.f10137b;
        this.f5252c = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String string;
        s8 s8Var;
        b bVar = this.f5250a;
        b bVar2 = b.FAILED;
        v8.m(bVar != bVar2);
        int i8 = a.f5243a[this.f5250a.ordinal()];
        if (i8 == 1) {
            return false;
        }
        if (i8 == 2) {
            return true;
        }
        this.f5250a = bVar2;
        int i9 = this.e;
        while (true) {
            int length = this.e;
            if (length == -1) {
                this.f5250a = b.DONE;
                string = null;
                break;
            }
            c cVar = (c) this.f5255i.f9720b;
            String str = this.f5252c;
            int length2 = str.length();
            v8.j(length, length2);
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (cVar.a(str.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str.length();
                this.e = -1;
            } else {
                this.e = length + 1;
            }
            int i10 = this.e;
            if (i10 != i9) {
                while (true) {
                    s8Var = this.f5253d;
                    if (i9 >= length || !s8Var.a(str.charAt(i9))) {
                        break;
                    }
                    i9++;
                }
                while (length > i9 && s8Var.a(str.charAt(length - 1))) {
                    length--;
                }
                int i11 = this.f5254h;
                if (i11 == 1) {
                    length = str.length();
                    this.e = -1;
                    while (length > i9 && s8Var.a(str.charAt(length - 1))) {
                        length--;
                    }
                } else {
                    this.f5254h = i11 - 1;
                }
                string = str.subSequence(i9, length).toString();
                break;
            }
            int i12 = i10 + 1;
            this.e = i12;
            if (i12 > str.length()) {
                this.e = -1;
            }
        }
        this.f5251b = string;
        if (this.f5250a == b.DONE) {
            return false;
        }
        this.f5250a = b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f5250a = b.NOT_READY;
        Object obj = this.f5251b;
        this.f5251b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
