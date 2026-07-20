package androidx.camera.video.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class SharedByteBuffer implements Closeable {
    private static final String TAG = "SharedByteBuffer";
    private final Object mCloseLock = new Object();

    @GuardedBy("mCloseLock")
    private boolean mClosed = false;
    private final Pair<Executor, Runnable> mFinalCloseAction;
    private final int mShareId;
    private final ByteBuffer mSharedByteBuffer;

    @GuardedBy("mCloseLock")
    private final AtomicInteger mSharedRefCount;

    private SharedByteBuffer(@NonNull ByteBuffer byteBuffer, @NonNull AtomicInteger atomicInteger, @NonNull Pair<Executor, Runnable> pair, int i8) {
        int i9;
        this.mSharedByteBuffer = byteBuffer;
        this.mSharedRefCount = atomicInteger;
        this.mFinalCloseAction = pair;
        this.mShareId = i8;
        if (!Logger.isDebugEnabled(TAG) || (i9 = atomicInteger.get()) >= 1) {
            return;
        }
        Locale locale = Locale.US;
        throw new AssertionError("Cannot create new instance of SharedByteBuffer with invalid ref count " + i9 + ". Ref count must be >= 1. [" + toString() + "]");
    }

    @GuardedBy("mCloseLock")
    private void checkNotClosed(@NonNull String str) {
        if (this.mClosed) {
            throw new IllegalStateException(h0.a.j("Cannot call ", str, " on a closed SharedByteBuffer."));
        }
    }

    private boolean closeInternal() {
        synchronized (this.mCloseLock) {
            try {
                if (this.mClosed) {
                    return false;
                }
                this.mClosed = true;
                int iDecrementAndGet = this.mSharedRefCount.decrementAndGet();
                if (Logger.isDebugEnabled(TAG)) {
                    if (iDecrementAndGet < 0) {
                        throw new AssertionError("Invalid ref count. close() should never produce a ref count below 0");
                    }
                    Locale locale = Locale.US;
                    Logger.d(TAG, "Ref count decremented: " + iDecrementAndGet + " [" + toString() + "]");
                }
                if (iDecrementAndGet == 0) {
                    if (Logger.isDebugEnabled(TAG)) {
                        Locale locale2 = Locale.US;
                        Logger.d(TAG, "Final reference released. Running final close action. [" + toString() + "]");
                    }
                    try {
                        ((Executor) Preconditions.checkNotNull(this.mFinalCloseAction.first)).execute((Runnable) Preconditions.checkNotNull(this.mFinalCloseAction.second));
                    } catch (RejectedExecutionException e) {
                        Locale locale3 = Locale.US;
                        Logger.e(TAG, "Unable to execute final close action. [" + toString() + "]", e);
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public static SharedByteBuffer newSharedInstance(@NonNull ByteBuffer byteBuffer, @NonNull Executor executor, @NonNull Runnable runnable) {
        return new SharedByteBuffer(((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).asReadOnlyBuffer(), new AtomicInteger(1), new Pair((Executor) Preconditions.checkNotNull(executor), (Runnable) Preconditions.checkNotNull(runnable)), System.identityHashCode(byteBuffer));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeInternal();
    }

    public void finalize() throws Throwable {
        try {
            if (closeInternal()) {
                Locale locale = Locale.US;
                Logger.w(TAG, "SharedByteBuffer closed by finalizer, but should have been closed manually with SharedByteBuffer.close() [" + toString() + "]");
            }
        } finally {
            super.finalize();
        }
    }

    @NonNull
    public ByteBuffer get() {
        ByteBuffer byteBuffer;
        synchronized (this.mCloseLock) {
            checkNotClosed("get()");
            byteBuffer = this.mSharedByteBuffer;
        }
        return byteBuffer;
    }

    @NonNull
    public SharedByteBuffer share() {
        int iIncrementAndGet;
        AtomicInteger atomicInteger;
        synchronized (this.mCloseLock) {
            checkNotClosed("share()");
            iIncrementAndGet = this.mSharedRefCount.incrementAndGet();
            atomicInteger = this.mSharedRefCount;
        }
        if (Logger.isDebugEnabled(TAG)) {
            if (iIncrementAndGet <= 1) {
                throw new AssertionError("Invalid ref count. share() should always produce a ref count of 2 or more.");
            }
            Locale locale = Locale.US;
            Logger.d(TAG, "Ref count incremented: " + iIncrementAndGet + " [" + toString() + "]");
        }
        return new SharedByteBuffer(this.mSharedByteBuffer.asReadOnlyBuffer(), atomicInteger, this.mFinalCloseAction, this.mShareId);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "SharedByteBuffer[buf: %s, shareId: 0x%x, instanceId:0x%x]", this.mSharedByteBuffer, Integer.valueOf(this.mShareId), Integer.valueOf(System.identityHashCode(this)));
    }
}
