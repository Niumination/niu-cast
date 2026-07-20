package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.message.bank.MessageBank;
import com.transsion.pcconnect.invoke.bridge.Device;
import java.util.ArrayList;
import java.util.Iterator;
import k3.pb;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR.\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/ConnectedDevice;", "", "id", "", "name", MessageBank.KEY_TYPE, "subTitle", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "getSubTitle", "()Ljava/util/ArrayList;", "setSubTitle", "(Ljava/util/ArrayList;)V", "changeSubTitle", "", "select", "isAdd", "", "getSubTitleForString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nConnectedDevice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectedDevice.kt\ncom/transsion/iotservice/multiscreen/pc/bean/ConnectedDevice\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n1557#2:50\n1628#2,3:51\n*S KotlinDebug\n*F\n+ 1 ConnectedDevice.kt\ncom/transsion/iotservice/multiscreen/pc/bean/ConnectedDevice\n*L\n45#1:50\n45#1:51,3\n*E\n"})
public final /* data */ class ConnectedDevice {

    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;

    @SerializedName("subTitle")
    private ArrayList<Integer> subTitle;

    @SerializedName(MessageBank.KEY_TYPE)
    private final String type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SUBTITLE_CONNECTED = R$string.md_connected2;
    private static final int SUBTITLE_MIRROR_CAST = R$string.pad_phone_mirror;
    private static final int SUBTITLE_SHARE_NETWORK = R$string.md_share_network;
    private static final int SUBTITLE_PHONE_EXTEND = R$string.md_phone_extend;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/ConnectedDevice$Companion;", "", "<init>", "()V", "SUBTITLE_CONNECTED", "", "getSUBTITLE_CONNECTED", "()I", "SUBTITLE_MIRROR_CAST", "getSUBTITLE_MIRROR_CAST", "SUBTITLE_SHARE_NETWORK", "getSUBTITLE_SHARE_NETWORK", "SUBTITLE_PHONE_EXTEND", "getSUBTITLE_PHONE_EXTEND", "create", "Lcom/transsion/iotservice/multiscreen/pc/bean/ConnectedDevice;", "device", "Lcom/transsion/pcconnect/invoke/bridge/Device;", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConnectedDevice create(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            return new ConnectedDevice(device.f2947a, device.f2948b, device.f2949c, CollectionsKt.arrayListOf(Integer.valueOf(getSUBTITLE_CONNECTED())));
        }

        public final int getSUBTITLE_CONNECTED() {
            return ConnectedDevice.SUBTITLE_CONNECTED;
        }

        public final int getSUBTITLE_MIRROR_CAST() {
            return ConnectedDevice.SUBTITLE_MIRROR_CAST;
        }

        public final int getSUBTITLE_PHONE_EXTEND() {
            return ConnectedDevice.SUBTITLE_PHONE_EXTEND;
        }

        public final int getSUBTITLE_SHARE_NETWORK() {
            return ConnectedDevice.SUBTITLE_SHARE_NETWORK;
        }

        private Companion() {
        }
    }

    public ConnectedDevice(String id2, String name, String type, ArrayList<Integer> subTitle) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        this.id = id2;
        this.name = name;
        this.type = type;
        this.subTitle = subTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConnectedDevice copy$default(ConnectedDevice connectedDevice, String str, String str2, String str3, ArrayList arrayList, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = connectedDevice.id;
        }
        if ((i8 & 2) != 0) {
            str2 = connectedDevice.name;
        }
        if ((i8 & 4) != 0) {
            str3 = connectedDevice.type;
        }
        if ((i8 & 8) != 0) {
            arrayList = connectedDevice.subTitle;
        }
        return connectedDevice.copy(str, str2, str3, arrayList);
    }

    public final void changeSubTitle(int select, boolean isAdd) {
        if (isAdd) {
            this.subTitle.remove(Integer.valueOf(SUBTITLE_CONNECTED));
            if (this.subTitle.contains(Integer.valueOf(select))) {
                return;
            }
            this.subTitle.add(Integer.valueOf(select));
            return;
        }
        this.subTitle.remove(Integer.valueOf(select));
        if (this.subTitle.isEmpty()) {
            this.subTitle.add(Integer.valueOf(SUBTITLE_CONNECTED));
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ArrayList<Integer> component4() {
        return this.subTitle;
    }

    public final ConnectedDevice copy(String id2, String name, String type, ArrayList<Integer> subTitle) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        return new ConnectedDevice(id2, name, type, subTitle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedDevice)) {
            return false;
        }
        ConnectedDevice connectedDevice = (ConnectedDevice) other;
        return Intrinsics.areEqual(this.id, connectedDevice.id) && Intrinsics.areEqual(this.name, connectedDevice.name) && Intrinsics.areEqual(this.type, connectedDevice.type) && Intrinsics.areEqual(this.subTitle, connectedDevice.subTitle);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<Integer> getSubTitle() {
        return this.subTitle;
    }

    public final String getSubTitleForString() {
        ArrayList<Integer> arrayList = this.subTitle;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(arrayList));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(pb.a().getString(((Number) it.next()).intValue()));
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null);
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.subTitle.hashCode() + a.e(a.e(this.id.hashCode() * 31, 31, this.name), 31, this.type);
    }

    public final void setSubTitle(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.subTitle = arrayList;
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        String str3 = this.type;
        ArrayList<Integer> arrayList = this.subTitle;
        StringBuilder sbP = h0.a.p("ConnectedDevice(id=", str, ", name=", str2, ", type=");
        sbP.append(str3);
        sbP.append(", subTitle=");
        sbP.append(arrayList);
        sbP.append(")");
        return sbP.toString();
    }
}
