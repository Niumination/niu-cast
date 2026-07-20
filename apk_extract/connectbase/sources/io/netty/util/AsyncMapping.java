package io.netty.util;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncMapping<IN, OUT> {
    Future<OUT> map(IN in2, Promise<OUT> promise);
}
