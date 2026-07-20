package com.transsion.iotservice.multiscreen.pc.global_search;

import a9.a;
import android.content.Context;
import android.database.MatrixCursor;
import android.os.UserManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.hubsdk.api.provider.TranSearchIndexablesProvider;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ue.PCConnectionSettingActivity;
import com.transsion.iotservice.multiscreen.pc.ui.copy.CopyPastActivity;
import com.transsion.iotservice.multiscreen.pc.ui.gesture.GestureActivity;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesActivity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/global_search/SearchIndexablesProvider;", "Lcom/transsion/hubsdk/api/provider/TranSearchIndexablesProvider;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nSearchIndexablesProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchIndexablesProvider.kt\ncom/transsion/iotservice/multiscreen/pc/global_search/SearchIndexablesProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,143:1\n1863#2,2:144\n1863#2,2:146\n*S KotlinDebug\n*F\n+ 1 SearchIndexablesProvider.kt\ncom/transsion/iotservice/multiscreen/pc/global_search/SearchIndexablesProvider\n*L\n61#1:144,2\n68#1:146,2\n*E\n"})
public final class SearchIndexablesProvider extends TranSearchIndexablesProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f2658c = {"key"};

    @Override // com.transsion.hubsdk.api.provider.TranSearchIndexablesProvider
    public final MatrixCursor a() {
        MatrixCursor matrixCursor = new MatrixCursor(f2658c);
        ArrayList arrayList = new ArrayList();
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("user") : null;
        UserManager userManager = systemService instanceof UserManager ? (UserManager) systemService : null;
        if (userManager != null && (userManager.hasUserRestriction("no_modify_accounts") || userManager.hasUserRestriction("no_install_apps") || !userManager.isSystemUser())) {
            arrayList.addAll(CollectionsKt.listOf((Object[]) new String[]{"key_multi_connect_setting_screen_interconnection", "key_multi_connect_mirror_gesture", "key_multi_copy_paste", "key_multi_trust_devices"}));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            matrixCursor.addRow(new Object[]{(String) it.next()});
        }
        return matrixCursor;
    }

    @Override // com.transsion.hubsdk.api.provider.TranSearchIndexablesProvider
    public final MatrixCursor b() {
        MatrixCursor matrixCursor = new MatrixCursor(a.f85a);
        Context context = getContext();
        Iterable<ab.a> arrayList = new ArrayList();
        if (context != null) {
            ab.a aVar = new ab.a();
            aVar.f86a = context.getString(R$string.md_multi_phone);
            aVar.f87b = context.getString(R$string.md_search_subtitle);
            aVar.f89d = context.getPackageName();
            aVar.e = PCConnectionSettingActivity.class.getName();
            aVar.f88c = "com.android.settings.action.EXTRA_SETTINGS";
            aVar.f = "key_multi_connect_setting_screen_interconnection";
            aVar.f90g = R$drawable.notification_logo;
            ab.a aVar2 = new ab.a();
            aVar2.f86a = context.getString(R$string.md_mirror_and_gesture);
            aVar2.f87b = context.getString(R$string.md_search_subtitle);
            aVar2.f89d = context.getPackageName();
            aVar2.e = GestureActivity.class.getName();
            aVar2.f88c = "com.transsion.pcconnect.action.MIRROR_GESTURE";
            aVar2.f = "key_multi_connect_mirror_gesture";
            aVar2.f90g = R$drawable.notification_logo;
            ab.a aVar3 = new ab.a();
            aVar3.f86a = context.getString(R$string.md_paste_from_other_device);
            aVar3.f87b = context.getString(R$string.md_search_subtitle);
            aVar3.f89d = context.getPackageName();
            aVar3.e = CopyPastActivity.class.getName();
            aVar3.f88c = "com.transsion.pcconnect.action.COPY_PAST";
            aVar3.f = "key_multi_copy_paste";
            aVar3.f90g = R$drawable.notification_logo;
            ab.a aVar4 = new ab.a();
            aVar4.f86a = context.getString(R$string.md_trust_device2);
            aVar4.f87b = context.getString(R$string.md_search_subtitle);
            aVar4.f89d = context.getPackageName();
            aVar4.e = TrustDevicesActivity.class.getName();
            aVar4.f88c = "com.transsion.pcconnect.action.TRUST_DEVICES";
            aVar4.f = "key_multi_trust_devices";
            aVar4.f90g = R$drawable.notification_logo;
            arrayList = CollectionsKt.mutableListOf(aVar, aVar4, aVar3, aVar2);
        }
        for (ab.a aVar5 : arrayList) {
            Object[] objArr = new Object[16];
            objArr[1] = aVar5.f86a;
            objArr[6] = aVar5.f87b;
            objArr[8] = Integer.valueOf(aVar5.f90g);
            objArr[9] = aVar5.f88c;
            objArr[10] = aVar5.f89d;
            objArr[11] = aVar5.e;
            objArr[12] = aVar5.f;
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }
}
