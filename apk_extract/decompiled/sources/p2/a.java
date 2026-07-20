package p2;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.common.api.GoogleApiActivity;
import k3.f1;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8647c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8648d = new a();

    public static AlertDialog e(Activity activity, int i8, u2.h hVar, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i8 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(u2.g.b(activity, i8));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i8 == 1) {
            string = resources.getString(R$string.common_google_play_services_install_button);
        } else if (i8 != 2) {
            string = i8 != 3 ? resources.getString(R.string.ok) : resources.getString(R$string.common_google_play_services_enable_button);
        } else {
            string = resources.getString(R$string.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, hVar);
        }
        String strC = u2.g.c(activity, i8);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", a1.a.o(i8, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void f(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
                l.f(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                supportErrorDialogFragment.f1811a = alertDialog;
                if (onCancelListener != null) {
                    supportErrorDialogFragment.f1812b = onCancelListener;
                }
                supportErrorDialogFragment.show(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        l.f(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        errorDialogFragment.f1801a = alertDialog;
        if (onCancelListener != null) {
            errorDialogFragment.f1802b = onCancelListener;
        }
        errorDialogFragment.show(fragmentManager, str);
    }

    public final void d(GoogleApiActivity googleApiActivity, int i8, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogE = e(googleApiActivity, i8, new u2.h(super.b(googleApiActivity, i8, "d"), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogE == null) {
            return;
        }
        f(googleApiActivity, alertDialogE, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void g(Context context, int i8, PendingIntent pendingIntent) {
        int i9;
        Log.w("GoogleApiAvailability", h0.a.h(i8, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i8 == 18) {
            new e(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i8 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i8 == 6 ? u2.g.e(context, "common_google_play_services_resolution_required_title") : u2.g.c(context, i8);
        if (strE == null) {
            strE = context.getResources().getString(R$string.common_google_play_services_notification_ticker);
        }
        String strD = (i8 == 6 || i8 == 19) ? u2.g.d(context, "common_google_play_services_resolution_required_text", u2.g.a(context)) : u2.g.b(context, i8);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        l.e(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strE).setStyle(new NotificationCompat.BigTextStyle().bigText(strD));
        if (f1.a(context)) {
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (f1.b(context)) {
                style.addAction(R$drawable.common_full_open_on_phone, resources.getString(R$string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(R$string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strD);
        }
        synchronized (f8647c) {
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String string = context.getResources().getString(R$string.common_google_play_services_notification_channel_name);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
        } else if (!string.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(string);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        style.setChannelId("com.google.android.gms.availability");
        Notification notificationBuild = style.build();
        if (i8 == 1 || i8 == 2 || i8 == 3) {
            c.f8651a.set(false);
            i9 = 10436;
        } else {
            i9 = 39789;
        }
        notificationManager.notify(i9, notificationBuild);
    }

    public final void h(Activity activity, r2.e eVar, int i8, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogE = e(activity, i8, new u2.h(super.b(activity, i8, "d"), eVar, 1), onCancelListener);
        if (alertDialogE == null) {
            return;
        }
        f(activity, alertDialogE, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
