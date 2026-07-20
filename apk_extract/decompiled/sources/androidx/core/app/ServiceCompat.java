package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void stopForeground(Service service, int i8) {
            service.stopForeground(i8);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void startForeground(Service service, int i8, Notification notification, int i9) {
            if (i9 == 0 || i9 == -1) {
                service.startForeground(i8, notification, i9);
            } else {
                service.startForeground(i8, notification, i9 & 255);
            }
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static void startForeground(Service service, int i8, Notification notification, int i9) {
            if (i9 == 0 || i9 == -1) {
                service.startForeground(i8, notification, i9);
            } else {
                service.startForeground(i8, notification, i9 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void startForeground(@NonNull Service service, int i8, @NonNull Notification notification, int i9) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.startForeground(service, i8, notification, i9);
        } else {
            Api29Impl.startForeground(service, i8, notification, i9);
        }
    }

    public static void stopForeground(@NonNull Service service, int i8) {
        Api24Impl.stopForeground(service, i8);
    }
}
