package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import h0.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import m4.l;
import o.d;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ExecutionListener, ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Configuration mConfiguration;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private Set<String> mCancelledIds = new HashSet();
    private final List<ExecutionListener> mOuterListeners = new ArrayList();

    @Nullable
    private PowerManager.WakeLock mForegroundLock = null;
    private final Object mLock = new Object();

    public static class FutureListener implements Runnable {

        @NonNull
        private ExecutionListener mExecutionListener;

        @NonNull
        private l mFuture;

        @NonNull
        private String mWorkSpecId;

        public FutureListener(@NonNull ExecutionListener executionListener, @NonNull String str, @NonNull l lVar) {
            this.mExecutionListener = executionListener;
            this.mWorkSpecId = str;
            this.mFuture = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zBooleanValue;
            try {
                zBooleanValue = ((Boolean) this.mFuture.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                zBooleanValue = true;
            }
            this.mExecutionListener.onExecuted(this.mWorkSpecId, zBooleanValue);
        }
    }

    public Processor(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = list;
    }

    private static boolean interrupt(@NonNull String str, @Nullable WorkerWrapper workerWrapper) {
        if (workerWrapper == null) {
            Logger.get().debug(TAG, a.i("WorkerWrapper could not be found for ", str), new Throwable[0]);
            return false;
        }
        workerWrapper.interrupt();
        Logger.get().debug(TAG, a.i("WorkerWrapper interrupted for ", str), new Throwable[0]);
        return true;
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.isEmpty()) {
                    try {
                        this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                    } catch (Throwable th2) {
                        Logger.get().error(TAG, "Unable to stop foreground service", th2);
                    }
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void addExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public boolean hasWork() {
        boolean z2;
        synchronized (this.mLock) {
            try {
                z2 = (this.mEnqueuedWorkMap.isEmpty() && this.mForegroundWorkMap.isEmpty()) ? false : true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z2;
    }

    public boolean isCancelled(@NonNull String str) {
        boolean zContains;
        synchronized (this.mLock) {
            zContains = this.mCancelledIds.contains(str);
        }
        return zContains;
    }

    public boolean isEnqueued(@NonNull String str) {
        boolean z2;
        synchronized (this.mLock) {
            try {
                z2 = this.mEnqueuedWorkMap.containsKey(str) || this.mForegroundWorkMap.containsKey(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z2;
    }

    public boolean isEnqueuedInForeground(@NonNull String str) {
        boolean zContainsKey;
        synchronized (this.mLock) {
            zContainsKey = this.mForegroundWorkMap.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String str, boolean z2) {
        synchronized (this.mLock) {
            try {
                this.mEnqueuedWorkMap.remove(str);
                Logger.get().debug(TAG, getClass().getSimpleName() + " " + str + " executed; reschedule = " + z2, new Throwable[0]);
                Iterator<ExecutionListener> it = this.mOuterListeners.iterator();
                while (it.hasNext()) {
                    it.next().onExecuted(str, z2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void removeExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(@NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger.get().info(TAG, "Moving WorkSpec (" + str + ") to the foreground", new Throwable[0]);
                WorkerWrapper workerWrapperRemove = this.mEnqueuedWorkMap.remove(str);
                if (workerWrapperRemove != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                        this.mForegroundLock = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, workerWrapperRemove);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, str, foregroundInfo));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean startWork(@NonNull String str) {
        return startWork(str, null);
    }

    public boolean stopAndCancelWork(@NonNull String str) {
        boolean zInterrupt;
        synchronized (this.mLock) {
            try {
                Logger.get().debug(TAG, "Processor cancelling " + str, new Throwable[0]);
                this.mCancelledIds.add(str);
                WorkerWrapper workerWrapperRemove = this.mForegroundWorkMap.remove(str);
                boolean z2 = workerWrapperRemove != null;
                if (workerWrapperRemove == null) {
                    workerWrapperRemove = this.mEnqueuedWorkMap.remove(str);
                }
                zInterrupt = interrupt(str, workerWrapperRemove);
                if (z2) {
                    stopForegroundService();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zInterrupt;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void stopForeground(@NonNull String str) {
        synchronized (this.mLock) {
            this.mForegroundWorkMap.remove(str);
            stopForegroundService();
        }
    }

    public boolean stopForegroundWork(@NonNull String str) {
        boolean zInterrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Processor stopping foreground work " + str, new Throwable[0]);
            zInterrupt = interrupt(str, this.mForegroundWorkMap.remove(str));
        }
        return zInterrupt;
    }

    public boolean stopWork(@NonNull String str) {
        boolean zInterrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Processor stopping background work " + str, new Throwable[0]);
            zInterrupt = interrupt(str, this.mEnqueuedWorkMap.remove(str));
        }
        return zInterrupt;
    }

    public boolean startWork(@NonNull String str, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.mLock) {
            try {
                if (isEnqueued(str)) {
                    Logger.get().debug(TAG, "Work " + str + " is already enqueued for processing", new Throwable[0]);
                    return false;
                }
                WorkerWrapper workerWrapperBuild = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, str).withSchedulers(this.mSchedulers).withRuntimeExtras(runtimeExtras).build();
                l future = workerWrapperBuild.getFuture();
                future.addListener(new FutureListener(this, str, future), this.mWorkTaskExecutor.getMainThreadExecutor());
                this.mEnqueuedWorkMap.put(str, workerWrapperBuild);
                this.mWorkTaskExecutor.getBackgroundExecutor().execute(workerWrapperBuild);
                Logger.get().debug(TAG, d.l(getClass().getSimpleName(), ": processing ", str), new Throwable[0]);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
