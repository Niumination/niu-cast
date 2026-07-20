package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes.dex */
public class ListChangeRegistry extends CallbackRegistry<ObservableList.OnListChangedCallback, ObservableList, ListChanges> {
    private static final int ALL = 0;
    private static final int CHANGED = 1;
    private static final int INSERTED = 2;
    private static final int MOVED = 3;
    private static final int REMOVED = 4;
    private static final Pools.SynchronizedPool<ListChanges> sListChanges = new Pools.SynchronizedPool<>(10);
    private static final CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges> NOTIFIER_CALLBACK = new CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges>() { // from class: androidx.databinding.ListChangeRegistry.1
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(ObservableList.OnListChangedCallback onListChangedCallback, ObservableList observableList, int i10, ListChanges listChanges) {
            if (i10 == 1) {
                onListChangedCallback.onItemRangeChanged(observableList, listChanges.start, listChanges.count);
                return;
            }
            if (i10 == 2) {
                onListChangedCallback.onItemRangeInserted(observableList, listChanges.start, listChanges.count);
                return;
            }
            if (i10 == 3) {
                onListChangedCallback.onItemRangeMoved(observableList, listChanges.start, listChanges.f498to, listChanges.count);
            } else if (i10 != 4) {
                onListChangedCallback.onChanged(observableList);
            } else {
                onListChangedCallback.onItemRangeRemoved(observableList, listChanges.start, listChanges.count);
            }
        }
    };

    public static class ListChanges {
        public int count;
        public int start;

        /* JADX INFO: renamed from: to, reason: collision with root package name */
        public int f498to;
    }

    public ListChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }

    private static ListChanges acquire(int i10, int i11, int i12) {
        ListChanges listChangesAcquire = sListChanges.acquire();
        if (listChangesAcquire == null) {
            listChangesAcquire = new ListChanges();
        }
        listChangesAcquire.start = i10;
        listChangesAcquire.f498to = i11;
        listChangesAcquire.count = i12;
        return listChangesAcquire;
    }

    public void notifyChanged(@NonNull ObservableList observableList) {
        notifyCallbacks(observableList, 0, (ListChanges) null);
    }

    public void notifyInserted(@NonNull ObservableList observableList, int i10, int i11) {
        notifyCallbacks(observableList, 2, acquire(i10, 0, i11));
    }

    public void notifyMoved(@NonNull ObservableList observableList, int i10, int i11, int i12) {
        notifyCallbacks(observableList, 3, acquire(i10, i11, i12));
    }

    public void notifyRemoved(@NonNull ObservableList observableList, int i10, int i11) {
        notifyCallbacks(observableList, 4, acquire(i10, 0, i11));
    }

    @Override // androidx.databinding.CallbackRegistry
    public synchronized void notifyCallbacks(@NonNull ObservableList observableList, int i10, ListChanges listChanges) {
        super.notifyCallbacks(observableList, i10, listChanges);
        if (listChanges != null) {
            sListChanges.release(listChanges);
        }
    }

    public void notifyChanged(@NonNull ObservableList observableList, int i10, int i11) {
        notifyCallbacks(observableList, 1, acquire(i10, 0, i11));
    }
}
