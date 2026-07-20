package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t10) {
            this.value = t10;
        }

        public final T getValue() {
            return this.value;
        }
    }

    @l
    public abstract Intent createIntent(@l Context context, I i10);

    @m
    public SynchronousResult<O> getSynchronousResult(@l Context context, I i10) {
        l0.p(context, "context");
        return null;
    }

    public abstract O parseResult(int i10, @m Intent intent);
}
