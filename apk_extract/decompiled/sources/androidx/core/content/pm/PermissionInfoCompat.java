package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionInfoCompat {

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static int getProtection(PermissionInfo permissionInfo) {
            return permissionInfo.getProtection();
        }

        public static int getProtectionFlags(PermissionInfo permissionInfo) {
            return permissionInfo.getProtectionFlags();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Protection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    public static int getProtection(@NonNull PermissionInfo permissionInfo) {
        return Api28Impl.getProtection(permissionInfo);
    }

    public static int getProtectionFlags(@NonNull PermissionInfo permissionInfo) {
        return Api28Impl.getProtectionFlags(permissionInfo);
    }
}
