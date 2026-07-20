package androidx.databinding;

import androidx.databinding.ViewDataBinding;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnRebindCallback<T extends ViewDataBinding> {
    public void onBound(T t3) {
    }

    public void onCanceled(T t3) {
    }

    public boolean onPreBind(T t3) {
        return true;
    }
}
