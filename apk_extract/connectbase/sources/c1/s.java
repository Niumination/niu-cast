package c1;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@k
public abstract class s<T> extends WeakReference<T> implements p {
    public s(@gm.a T referent, q queue) {
        super(referent, queue.f1234a);
        queue.c();
    }
}
