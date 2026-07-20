package com.transsion.content.pm;

import android.content.ComponentName;
import android.content.IntentSender;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManager {
    public static final int APPHIDE_STATE_DEFAULT = 0;
    public static final int APPHIDE_STATE_HIDDEN = 2;
    public static final int APPHIDE_STATE_UNHIDDEN = 1;
    public static final String OSFRAMEWORK_UPDATE_CONFIG_ACTIVE_IS_FACTORY = "active_is_Factory";
    public static final String OSFRAMEWORK_UPDATE_CONFIG_ACTIVE_MD5 = "active_md5";
    public static final String OSFRAMEWORK_UPDATE_CONFIG_ACTIVE_VERSION = "active_version";
    public static final String OSFRAMEWORK_UPDATE_CONFIG_DEP_VERSION = "system_dep_version";
    public static final String TAG = "os.package";

    private PackageManager() {
        throw new RuntimeException("Stub!");
    }

    public static String getFileMD5Base64(String str) {
        throw new RuntimeException("Stub!");
    }

    public static PackageManager instance() {
        throw new RuntimeException("Stub!");
    }

    public String[] getAllHiddenApps() throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    public int getApplicationHiddenState(String str) throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    public String getOSFrameworkUpdateConfig() throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    public int rollbackOSFramework(long j8) throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    public void setComponentEnabledSetting(ComponentName componentName, int i8) throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    public boolean setHideToSettingsServiceListingQuery(String str, String[] strArr, int i8) throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    public void updateOSFramework(ParcelFileDescriptor parcelFileDescriptor, String str, IntentSender intentSender) throws RemoteException {
        throw new RuntimeException("Stub!");
    }
}
