package androidx.databinding;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ObservableList<T> extends List<T> {

    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void onChanged(T t3);

        public abstract void onItemRangeChanged(T t3, int i8, int i9);

        public abstract void onItemRangeInserted(T t3, int i8, int i9);

        public abstract void onItemRangeMoved(T t3, int i8, int i9, int i10);

        public abstract void onItemRangeRemoved(T t3, int i8, int i9);
    }

    void addOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);

    void removeOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);
}
