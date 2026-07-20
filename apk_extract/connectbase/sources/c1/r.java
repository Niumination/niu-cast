package c1;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@k
public abstract class r<T> extends SoftReference<T> implements p {
    public r(@gm.a T referent, q queue) {
        super(referent, queue.f1234a);
        queue.c();
    }
}
