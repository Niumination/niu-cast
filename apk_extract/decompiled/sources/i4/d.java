package i4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import k3.cb;
import k3.d9;
import k3.f9;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends g implements Serializable {
    private static final long serialVersionUID = 0;
    transient k4 backingMap;
    transient long size;

    public d(int i8) {
        this.backingMap = newBackingMap(i8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i8 = objectInputStream.readInt();
        this.backingMap = newBackingMap(3);
        for (int i9 = 0; i9 < i8; i9++) {
            add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(entrySet().size());
        for (b4 b4Var : entrySet()) {
            objectOutputStream.writeObject(b4Var.getElement());
            objectOutputStream.writeInt(b4Var.getCount());
        }
    }

    @Override // i4.c4
    public final int add(Object obj, int i8) {
        if (i8 == 0) {
            return count(obj);
        }
        v8.b(i8, "occurrences cannot be negative: %s", i8 > 0);
        int iD = this.backingMap.d(obj);
        if (iD == -1) {
            this.backingMap.f(i8, obj);
            this.size += (long) i8;
            return 0;
        }
        int iC = this.backingMap.c(iD);
        long j8 = i8;
        long j10 = ((long) iC) + j8;
        v8.f(j10 <= 2147483647L, "too many occurrences: %s", j10);
        k4 k4Var = this.backingMap;
        v8.h(iD, k4Var.f5624c);
        k4Var.f5623b[iD] = (int) j10;
        this.size += j8;
        return iC;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x000a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:? A[LOOP:0: B:6:0x000d->B:14:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0029 -> B:4:0x000a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:12:0x000a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public void addTo(i4.c4 r5) {
        /*
            r4 = this;
            r5.getClass()
            i4.k4 r0 = r4.backingMap
            int r0 = r0.f5624c
            r1 = -1
            if (r0 != 0) goto Lc
        La:
            r0 = r1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 < 0) goto L2c
            i4.k4 r2 = r4.backingMap
            int r3 = r2.f5624c
            k3.v8.h(r0, r3)
            java.lang.Object[] r2 = r2.f5622a
            r2 = r2[r0]
            i4.k4 r3 = r4.backingMap
            int r3 = r3.c(r0)
            r5.add(r2, r3)
            i4.k4 r2 = r4.backingMap
            int r0 = r0 + 1
            int r2 = r2.f5624c
            if (r0 >= r2) goto La
            goto Ld
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.d.addTo(i4.c4):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        k4 k4Var = this.backingMap;
        k4Var.f5625d++;
        Arrays.fill(k4Var.f5622a, 0, k4Var.f5624c, (Object) null);
        Arrays.fill(k4Var.f5623b, 0, k4Var.f5624c, 0);
        Arrays.fill(k4Var.e, -1);
        Arrays.fill(k4Var.f, -1L);
        k4Var.f5624c = 0;
        this.size = 0L;
    }

    @Override // i4.c4
    public final int count(Object obj) {
        return this.backingMap.b(obj);
    }

    @Override // i4.g
    public final int distinctElements() {
        return this.backingMap.f5624c;
    }

    @Override // i4.g
    public final Iterator<Object> elementIterator() {
        return new b(this, 0);
    }

    @Override // i4.g
    public final Iterator<b4> entryIterator() {
        return new b(this, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return new f4(this, entrySet().iterator());
    }

    public abstract k4 newBackingMap(int i8);

    public final int remove(Object obj, int i8) {
        if (i8 == 0) {
            return count(obj);
        }
        v8.b(i8, "occurrences cannot be negative: %s", i8 > 0);
        int iD = this.backingMap.d(obj);
        if (iD == -1) {
            return 0;
        }
        int iC = this.backingMap.c(iD);
        if (iC > i8) {
            k4 k4Var = this.backingMap;
            v8.h(iD, k4Var.f5624c);
            k4Var.f5623b[iD] = iC - i8;
        } else {
            this.backingMap.h(iD);
            i8 = iC;
        }
        this.size -= (long) i8;
        return iC;
    }

    public final int setCount(Object obj, int i8) {
        int iF;
        d9.b(i8, "count");
        k4 k4Var = this.backingMap;
        if (i8 == 0) {
            k4Var.getClass();
            iF = k4Var.g(obj, f9.b(obj));
        } else {
            iF = k4Var.f(i8, obj);
        }
        this.size += (long) (i8 - iF);
        return iF;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return cb.b(this.size);
    }

    public final boolean setCount(Object obj, int i8, int i9) {
        d9.b(i8, "oldCount");
        d9.b(i9, "newCount");
        int iD = this.backingMap.d(obj);
        if (iD == -1) {
            if (i8 != 0) {
                return false;
            }
            if (i9 > 0) {
                this.backingMap.f(i9, obj);
                this.size += (long) i9;
            }
            return true;
        }
        if (this.backingMap.c(iD) != i8) {
            return false;
        }
        if (i9 == 0) {
            this.backingMap.h(iD);
            this.size -= (long) i8;
        } else {
            k4 k4Var = this.backingMap;
            v8.h(iD, k4Var.f5624c);
            k4Var.f5623b[iD] = i9;
            this.size += (long) (i9 - i8);
        }
        return true;
    }
}
