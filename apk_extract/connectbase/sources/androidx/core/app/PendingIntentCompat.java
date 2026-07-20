package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import oa.e;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @NonNull
        @DoNotInline
        public static PendingIntent getActivities(@NonNull Context context, int i10, @NonNull @b.a({"ArrayReturn"}) Intent[] intentArr, int i11, @NonNull Bundle bundle) {
            return PendingIntent.getActivities(context, i10, intentArr, i11, bundle);
        }

        @NonNull
        @DoNotInline
        public static PendingIntent getActivity(@NonNull Context context, int i10, @NonNull Intent intent, int i11, @NonNull Bundle bundle) {
            return PendingIntent.getActivity(context, i10, intent, i11, bundle);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context context, int i10, Intent intent, int i11) {
            return PendingIntent.getForegroundService(context, i10, intent, i11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z10, int i10) {
        return (z10 ? 33554432 : e.f12145r) | i10;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i10, @NonNull @b.a({"ArrayReturn"}) Intent[] intentArr, int i11, @NonNull Bundle bundle, boolean z10) {
        return Api16Impl.getActivities(context, i10, intentArr, addMutabilityFlags(z10, i11), bundle);
    }

    @NonNull
    public static PendingIntent getActivity(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getActivity(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @NonNull
    public static PendingIntent getBroadcast(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getBroadcast(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return Api26Impl.getForegroundService(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @NonNull
    public static PendingIntent getService(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getService(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i10, @NonNull @b.a({"ArrayReturn"}) Intent[] intentArr, int i11, boolean z10) {
        return PendingIntent.getActivities(context, i10, intentArr, addMutabilityFlags(z10, i11));
    }

    @NonNull
    public static PendingIntent getActivity(@NonNull Context context, int i10, @NonNull Intent intent, int i11, @NonNull Bundle bundle, boolean z10) {
        return Api16Impl.getActivity(context, i10, intent, addMutabilityFlags(z10, i11), bundle);
    }
}
