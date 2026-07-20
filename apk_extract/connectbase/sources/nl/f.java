package nl;

import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
@a
public interface f<TSubject, TContext> extends s0 {
    @os.l
    TSubject E();

    @os.m
    Object J0(@os.l um.d<? super TSubject> dVar);

    void finish();

    @os.l
    TContext getContext();

    @os.m
    Object v0(@os.l TSubject tsubject, @os.l um.d<? super TSubject> dVar);
}
