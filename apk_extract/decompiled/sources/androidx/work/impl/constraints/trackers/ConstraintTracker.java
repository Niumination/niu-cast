package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ConstraintTracker<T> {
    private static final String TAG = Logger.tagWithPrefix("ConstraintTracker");
    protected final Context mAppContext;
    T mCurrentState;
    protected final TaskExecutor mTaskExecutor;
    private final Object mLock = new Object();
    private final Set<ConstraintListener<T>> mListeners = new LinkedHashSet();

    public ConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public void addListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            try {
                if (this.mListeners.add(constraintListener)) {
                    if (this.mListeners.size() == 1) {
                        this.mCurrentState = getInitialState();
                        Logger.get().debug(TAG, String.format("%s: initial state = %s", getClass().getSimpleName(), this.mCurrentState), new Throwable[0]);
                        startTracking();
                    }
                    constraintListener.onConstraintChanged(this.mCurrentState);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract T getInitialState();

    public void removeListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            try {
                if (this.mListeners.remove(constraintListener) && this.mListeners.isEmpty()) {
                    stopTracking();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setState(T t3) {
        synchronized (this.mLock) {
            try {
                T t8 = this.mCurrentState;
                if (t8 != t3 && (t8 == null || !t8.equals(t3))) {
                    this.mCurrentState = t3;
                    final ArrayList arrayList = new ArrayList(this.mListeners);
                    this.mTaskExecutor.getMainThreadExecutor().execute(new Runnable() { // from class: androidx.work.impl.constraints.trackers.ConstraintTracker.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((ConstraintListener) it.next()).onConstraintChanged(ConstraintTracker.this.mCurrentState);
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
