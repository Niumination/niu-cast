package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class ListFuture<V> implements l {
    private final boolean mAllMustSucceed;

    @Nullable
    List<? extends l> mFutures;

    @NonNull
    private final AtomicInteger mRemaining;

    @NonNull
    private final l mResult = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<List<V>>() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.1
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<List<V>> completer) {
            Preconditions.checkState(ListFuture.this.mResultNotifier == null, "The result can only set once!");
            ListFuture.this.mResultNotifier = completer;
            return "ListFuture[" + this + "]";
        }
    });
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;

    @Nullable
    List<V> mValues;

    public ListFuture(@NonNull List<? extends l> list, boolean z2, @NonNull Executor executor) {
        this.mFutures = (List) Preconditions.checkNotNull(list);
        this.mValues = new ArrayList(list.size());
        this.mAllMustSucceed = z2;
        this.mRemaining = new AtomicInteger(list.size());
        init(executor);
    }

    private void callAllGets() throws InterruptedException {
        List<? extends l> list = this.mFutures;
        if (list == null || isDone()) {
            return;
        }
        for (l lVar : list) {
            while (!lVar.isDone()) {
                try {
                    lVar.get();
                } catch (Error e) {
                    throw e;
                } catch (InterruptedException e4) {
                    throw e4;
                } catch (Throwable unused) {
                    if (this.mAllMustSucceed) {
                        return;
                    }
                }
            }
        }
    }

    private void init(@NonNull Executor executor) {
        addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.2
            @Override // java.lang.Runnable
            public void run() {
                ListFuture listFuture = ListFuture.this;
                listFuture.mValues = null;
                listFuture.mFutures = null;
            }
        }, CameraXExecutors.directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList(this.mValues));
            return;
        }
        for (int i8 = 0; i8 < this.mFutures.size(); i8++) {
            this.mValues.add(null);
        }
        List<? extends l> list = this.mFutures;
        for (final int i9 = 0; i9 < list.size(); i9++) {
            final l lVar = list.get(i9);
            lVar.addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.3
                @Override // java.lang.Runnable
                public void run() {
                    ListFuture.this.setOneValue(i9, lVar);
                }
            }, executor);
        }
    }

    @Override // m4.l
    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        List<? extends l> list = this.mFutures;
        if (list != null) {
            Iterator<? extends l> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel(z2);
            }
        }
        return this.mResult.cancel(z2);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mResult.isDone();
    }

    public void setOneValue(int i8, @NonNull Future<? extends V> future) {
        List<V> list;
        CallbackToFutureAdapter.Completer<List<V>> completer;
        ArrayList arrayList;
        List<V> list2;
        List<V> list3;
        List<V> list4;
        List<V> list5;
        List<V> list6 = this.mValues;
        if (isDone() || list6 == null) {
            Preconditions.checkState(this.mAllMustSucceed, "Future was done before all dependencies completed");
            return;
        }
        try {
            Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
            list6.set(i8, (V) Futures.getUninterruptibly(future));
            int iDecrementAndGet = this.mRemaining.decrementAndGet();
            Preconditions.checkState(iDecrementAndGet >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet == 0) {
                if (list5 != null) {
                    completer = this.mResultNotifier;
                    arrayList = new ArrayList(list5);
                    completer.set(arrayList);
                }
            }
        } catch (RuntimeException e) {
            if (this.mAllMustSucceed) {
                this.mResultNotifier.setException(e);
            }
            int iDecrementAndGet2 = this.mRemaining.decrementAndGet();
            Preconditions.checkState(iDecrementAndGet2 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet2 == 0) {
                if (list4 != null) {
                    completer = this.mResultNotifier;
                    arrayList = new ArrayList(list4);
                }
            }
        } catch (ExecutionException e4) {
            if (this.mAllMustSucceed) {
                this.mResultNotifier.setException(e4.getCause());
            }
            int iDecrementAndGet3 = this.mRemaining.decrementAndGet();
            Preconditions.checkState(iDecrementAndGet3 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet3 == 0) {
                if (list3 != null) {
                    completer = this.mResultNotifier;
                    arrayList = new ArrayList(list3);
                }
            }
        } catch (Error e10) {
            this.mResultNotifier.setException(e10);
            int iDecrementAndGet4 = this.mRemaining.decrementAndGet();
            Preconditions.checkState(iDecrementAndGet4 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet4 == 0) {
                if (list2 != null) {
                    completer = this.mResultNotifier;
                    arrayList = new ArrayList(list2);
                }
            }
        } catch (CancellationException unused) {
            if (this.mAllMustSucceed) {
                cancel(false);
            }
            int iDecrementAndGet5 = this.mRemaining.decrementAndGet();
            Preconditions.checkState(iDecrementAndGet5 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet5 == 0) {
                if (list != null) {
                    completer = this.mResultNotifier;
                    arrayList = new ArrayList(list);
                }
            }
        } finally {
            int iDecrementAndGet6 = this.mRemaining.decrementAndGet();
            Preconditions.checkState(iDecrementAndGet6 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet6 == 0) {
                List<V> list7 = this.mValues;
                if (list7 != null) {
                    this.mResultNotifier.set(new ArrayList(list7));
                } else {
                    Preconditions.checkState(isDone());
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public List<V> get() throws ExecutionException, InterruptedException {
        callAllGets();
        return (List) this.mResult.get();
    }

    @Override // java.util.concurrent.Future
    public List<V> get(long j8, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (List) this.mResult.get(j8, timeUnit);
    }
}
