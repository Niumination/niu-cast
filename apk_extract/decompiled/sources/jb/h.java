package jb;

import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Permission f6138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Permission f6139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Permission f6140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Permission f6141d;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.POST_NOTIFICATIONS");
        Permission permission = new Permission(arrayList, "transferPermission", R$string.permission_post_notification_desc);
        f6138a = permission;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("android.permission.BLUETOOTH_SCAN");
        arrayList2.add("android.permission.BLUETOOTH_ADVERTISE");
        arrayList2.add("android.permission.BLUETOOTH_CONNECT");
        arrayList2.add("android.permission.NEARBY_WIFI_DEVICES");
        Permission permission2 = new Permission(arrayList2, "scanAndConnectPermission", R$string.pemission_nearby_wifi_device_desc);
        f6139b = permission2;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("android.permission.CAMERA");
        Permission permission3 = new Permission(arrayList3, "scanAndConnectPermission", R$string.pemission_nearby_wifi_device_desc);
        f6140c = permission3;
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("android.permission.READ_MEDIA_IMAGES");
        Permission permission4 = new Permission(arrayList4, "readImages", R$string.permission_read_external_storage);
        f6141d = permission4;
        CollectionsKt.arrayListOf(permission3, permission, permission2, permission4);
    }
}
