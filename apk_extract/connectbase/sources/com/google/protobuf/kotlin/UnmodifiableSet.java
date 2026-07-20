package com.google.protobuf.kotlin;

import java.util.Collection;
import java.util.Set;
import kn.l0;
import ln.a;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E>, a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnmodifiableSet(@l Collection<? extends E> collection) {
        super(collection);
        l0.p(collection, "delegate");
    }
}
