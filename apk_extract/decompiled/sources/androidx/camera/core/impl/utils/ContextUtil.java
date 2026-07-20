package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class ContextUtil {

    @RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        @DoNotInline
        public static Context createAttributionContext(@NonNull Context context, @Nullable String str) {
            return context.createAttributionContext(str);
        }

        @Nullable
        @DoNotInline
        public static String getAttributionTag(@NonNull Context context) {
            return context.getAttributionTag();
        }
    }

    private ContextUtil() {
    }

    @NonNull
    public static Context getApplicationContext(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        String attributionTag = Api30Impl.getAttributionTag(context);
        return attributionTag != null ? Api30Impl.createAttributionContext(applicationContext, attributionTag) : applicationContext;
    }

    @Nullable
    public static Application getApplicationFromContext(@NonNull Context context) {
        for (Context applicationContext = getApplicationContext(context); applicationContext instanceof ContextWrapper; applicationContext = getBaseContext((ContextWrapper) applicationContext)) {
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
        }
        return null;
    }

    @NonNull
    public static Context getBaseContext(@NonNull ContextWrapper contextWrapper) {
        Context baseContext = contextWrapper.getBaseContext();
        String attributionTag = Api30Impl.getAttributionTag(contextWrapper);
        return attributionTag != null ? Api30Impl.createAttributionContext(baseContext, attributionTag) : baseContext;
    }
}
