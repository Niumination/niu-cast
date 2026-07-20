package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i8, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i8, intent, onFinished, handler, str, bundle);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static PendingIntent getForegroundService(Context context, int i8, Intent intent, int i9) {
            return PendingIntent.getForegroundService(context, i8, intent, i9);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Flags {
    }

    public static class GatedCallback implements Closeable {

        @Nullable
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess = false;

        public GatedCallback(@Nullable PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i8, String str, Bundle bundle) {
            boolean z2 = false;
            while (true) {
                try {
                    this.mComplete.await();
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                } catch (Throwable th2) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th2;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.mCallback;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i8, str, bundle);
                this.mCallback = null;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Nullable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new PendingIntent.OnFinished() { // from class: androidx.core.app.b
                @Override // android.app.PendingIntent.OnFinished
                public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i8, String str, Bundle bundle) {
                    this.f1096a.onSendFinished(pendingIntent, intent, i8, str, bundle);
                }
            };
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z2, int i8) {
        return (z2 ? 33554432 : AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) | i8;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i8, @NonNull Intent[] intentArr, int i9, @Nullable Bundle bundle, boolean z2) {
        return PendingIntent.getActivities(context, i8, intentArr, addMutabilityFlags(z2, i9), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i8, @NonNull Intent intent, int i9, boolean z2) {
        return PendingIntent.getActivity(context, i8, intent, addMutabilityFlags(z2, i9));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i8, @NonNull Intent intent, int i9, boolean z2) {
        return PendingIntent.getBroadcast(context, i8, intent, addMutabilityFlags(z2, i9));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context context, int i8, @NonNull Intent intent, int i9, boolean z2) {
        return Api26Impl.getForegroundService(context, i8, intent, addMutabilityFlags(z2, i9));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i8, @NonNull Intent intent, int i9, boolean z2) {
        return PendingIntent.getService(context, i8, intent, addMutabilityFlags(z2, i9));
    }

    public static void send(@NonNull PendingIntent pendingIntent, int i8, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i8, gatedCallback.getCallback(), handler);
            gatedCallback.complete();
            gatedCallback.close();
        } catch (Throwable th2) {
            try {
                gatedCallback.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i8, @NonNull Intent[] intentArr, int i9, boolean z2) {
        return PendingIntent.getActivities(context, i8, intentArr, addMutabilityFlags(z2, i9));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i8, @NonNull Intent intent, int i9, @Nullable Bundle bundle, boolean z2) {
        return PendingIntent.getActivity(context, i8, intent, addMutabilityFlags(z2, i9), bundle);
    }

    public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i8, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        send(pendingIntent, context, i8, intent, onFinished, handler, null, null);
    }

    public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i8, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            Api23Impl.send(pendingIntent, context, i8, intent, onFinished, handler, str, bundle);
            gatedCallback.complete();
            gatedCallback.close();
        } catch (Throwable th2) {
            try {
                gatedCallback.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
