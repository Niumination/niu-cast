package c1;

import java.lang.ref.PhantomReference;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@k
public abstract class o<T> extends PhantomReference<T> implements p {
    public o(@gm.a T referent, q queue) {
        super(referent, queue.f1234a);
        queue.c();
    }
}
