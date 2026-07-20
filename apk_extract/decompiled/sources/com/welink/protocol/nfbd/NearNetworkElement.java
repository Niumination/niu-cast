package com.welink.protocol.nfbd;

import android.nfc.NdefRecord;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/welink/protocol/nfbd/NearNetworkElement;", "Landroid/os/Parcelable;", "Wifi", "BluetoothLe", "BluetoothClassic", "BluetoothPan", "Ethernet", "Nfc", "Uwb", "Lcom/welink/protocol/nfbd/NearNetworkElement$BluetoothClassic;", "Lcom/welink/protocol/nfbd/NearNetworkElement$BluetoothLe;", "Lcom/welink/protocol/nfbd/NearNetworkElement$BluetoothPan;", "Lcom/welink/protocol/nfbd/NearNetworkElement$Ethernet;", "Lcom/welink/protocol/nfbd/NearNetworkElement$Nfc;", "Lcom/welink/protocol/nfbd/NearNetworkElement$Uwb;", "Lcom/welink/protocol/nfbd/NearNetworkElement$Wifi;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class NearNetworkElement implements Parcelable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NearNetworkElement$BluetoothClassic;", "Lcom/welink/protocol/nfbd/NearNetworkElement;", "CREATOR", "com/welink/protocol/nfbd/q", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class BluetoothClassic extends NearNetworkElement {
        public static final q CREATOR = new q();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3918c;

        public BluetoothClassic(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i8 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            this.f3916a = i8;
            this.f3917b = string;
            this.f3918c = string2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BluetoothClassic)) {
                return false;
            }
            BluetoothClassic bluetoothClassic = (BluetoothClassic) obj;
            return this.f3916a == bluetoothClassic.f3916a && Intrinsics.areEqual(this.f3917b, bluetoothClassic.f3917b) && Intrinsics.areEqual(this.f3918c, bluetoothClassic.f3918c);
        }

        public final int hashCode() {
            int iHashCode = Integer.hashCode(this.f3916a) * 31;
            String str = this.f3917b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f3918c;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("BluetoothClassic(phyType=");
            sb2.append(this.f3916a);
            sb2.append(", name=");
            sb2.append(this.f3917b);
            sb2.append(", address=");
            return h0.a.n(sb2, this.f3918c, ")");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.f3916a);
            parcel.writeString(this.f3917b);
            parcel.writeString(this.f3918c);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NearNetworkElement$BluetoothLe;", "Lcom/welink/protocol/nfbd/NearNetworkElement;", "CREATOR", "com/welink/protocol/nfbd/r", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class BluetoothLe extends NearNetworkElement {
        public static final r CREATOR = new r();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3922d;

        public BluetoothLe(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i8 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i9 = parcel.readInt();
            this.f3919a = i8;
            this.f3920b = string;
            this.f3921c = string2;
            this.f3922d = i9;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BluetoothLe)) {
                return false;
            }
            BluetoothLe bluetoothLe = (BluetoothLe) obj;
            return this.f3919a == bluetoothLe.f3919a && Intrinsics.areEqual(this.f3920b, bluetoothLe.f3920b) && Intrinsics.areEqual(this.f3921c, bluetoothLe.f3921c) && this.f3922d == bluetoothLe.f3922d;
        }

        public final int hashCode() {
            int iHashCode = Integer.hashCode(this.f3919a) * 31;
            String str = this.f3920b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f3921c;
            return Integer.hashCode(this.f3922d) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
        }

        public final String toString() {
            return "BluetoothLe(phyType=" + this.f3919a + ", name=" + this.f3920b + ", address=" + this.f3921c + ", type=" + this.f3922d + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.f3919a);
            parcel.writeString(this.f3920b);
            parcel.writeString(this.f3921c);
            parcel.writeInt(this.f3922d);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NearNetworkElement$BluetoothPan;", "Lcom/welink/protocol/nfbd/NearNetworkElement;", "CREATOR", "com/welink/protocol/nfbd/s", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nNearNetworkElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NearNetworkElement.kt\ncom/welink/protocol/nfbd/NearNetworkElement$BluetoothPan\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,307:1\n9#2,4:308\n*S KotlinDebug\n*F\n+ 1 NearNetworkElement.kt\ncom/welink/protocol/nfbd/NearNetworkElement$BluetoothPan\n*L\n177#1:308,4\n*E\n"})
    public static final /* data */ class BluetoothPan extends NearNetworkElement {
        public static final s CREATOR = new s();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final NetworkParamsInformation f3926d;
        public final int e;

        public BluetoothPan(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i8 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            NetworkParamsInformation networkParamsInformation = (NetworkParamsInformation) ((Parcelable) parcel.readParcelable(NetworkParamsInformation.class.getClassLoader(), NetworkParamsInformation.class));
            int i9 = parcel.readInt();
            this.f3923a = i8;
            this.f3924b = string;
            this.f3925c = string2;
            this.f3926d = networkParamsInformation;
            this.e = i9;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BluetoothPan)) {
                return false;
            }
            BluetoothPan bluetoothPan = (BluetoothPan) obj;
            return this.f3923a == bluetoothPan.f3923a && Intrinsics.areEqual(this.f3924b, bluetoothPan.f3924b) && Intrinsics.areEqual(this.f3925c, bluetoothPan.f3925c) && Intrinsics.areEqual(this.f3926d, bluetoothPan.f3926d) && this.e == bluetoothPan.e;
        }

        public final int hashCode() {
            int iHashCode = Integer.hashCode(this.f3923a) * 31;
            String str = this.f3924b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f3925c;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            NetworkParamsInformation networkParamsInformation = this.f3926d;
            return Integer.hashCode(this.e) + ((iHashCode3 + (networkParamsInformation != null ? networkParamsInformation.hashCode() : 0)) * 31);
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("BluetoothPan(phyType=");
            sb2.append(this.f3923a);
            sb2.append(", name=");
            sb2.append(this.f3924b);
            sb2.append(", address=");
            sb2.append(this.f3925c);
            sb2.append(", networkParams=");
            sb2.append(this.f3926d);
            sb2.append(", type=");
            return h0.a.m(sb2, ")", this.e);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.f3923a);
            parcel.writeString(this.f3924b);
            parcel.writeString(this.f3925c);
            parcel.writeParcelable(this.f3926d, i8);
            parcel.writeInt(this.e);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NearNetworkElement$Ethernet;", "Lcom/welink/protocol/nfbd/NearNetworkElement;", "CREATOR", "com/welink/protocol/nfbd/t", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nNearNetworkElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NearNetworkElement.kt\ncom/welink/protocol/nfbd/NearNetworkElement$Ethernet\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,307:1\n9#2,4:308\n*S KotlinDebug\n*F\n+ 1 NearNetworkElement.kt\ncom/welink/protocol/nfbd/NearNetworkElement$Ethernet\n*L\n212#1:308,4\n*E\n"})
    public static final /* data */ class Ethernet extends NearNetworkElement {
        public static final t CREATOR = new t();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3930d;
        public final int e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final NetworkParamsInformation f3931h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f3932i;

        public Ethernet(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i8 = parcel.readInt();
            int i9 = parcel.readInt();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            NetworkParamsInformation networkParamsInformation = (NetworkParamsInformation) ((Parcelable) parcel.readParcelable(NetworkParamsInformation.class.getClassLoader(), NetworkParamsInformation.class));
            int i13 = parcel.readInt();
            this.f3927a = i8;
            this.f3928b = i9;
            this.f3929c = i10;
            this.f3930d = i11;
            this.e = i12;
            this.f3931h = networkParamsInformation;
            this.f3932i = i13;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ethernet)) {
                return false;
            }
            Ethernet ethernet = (Ethernet) obj;
            return this.f3927a == ethernet.f3927a && this.f3928b == ethernet.f3928b && this.f3929c == ethernet.f3929c && this.f3930d == ethernet.f3930d && this.e == ethernet.e && Intrinsics.areEqual(this.f3931h, ethernet.f3931h) && this.f3932i == ethernet.f3932i;
        }

        public final int hashCode() {
            int iC = a1.a.c(this.e, a1.a.c(this.f3930d, a1.a.c(this.f3929c, a1.a.c(this.f3928b, Integer.hashCode(this.f3927a) * 31, 31), 31), 31), 31);
            NetworkParamsInformation networkParamsInformation = this.f3931h;
            return Integer.hashCode(this.f3932i) + ((iC + (networkParamsInformation == null ? 0 : networkParamsInformation.hashCode())) * 31);
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("Ethernet(phyType=");
            sb2.append(this.f3927a);
            sb2.append(", speed=");
            sb2.append(this.f3928b);
            sb2.append(", port=");
            sb2.append(this.f3929c);
            sb2.append(", protocol=");
            sb2.append(this.f3930d);
            sb2.append(", version=");
            sb2.append(this.e);
            sb2.append(", networkParams=");
            sb2.append(this.f3931h);
            sb2.append(", type=");
            return h0.a.m(sb2, ")", this.f3932i);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.f3927a);
            parcel.writeInt(this.f3928b);
            parcel.writeInt(this.f3929c);
            parcel.writeInt(this.f3930d);
            parcel.writeInt(this.e);
            parcel.writeParcelable(this.f3931h, i8);
            parcel.writeInt(this.f3932i);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NearNetworkElement$Nfc;", "Lcom/welink/protocol/nfbd/NearNetworkElement;", "CREATOR", "com/welink/protocol/nfbd/u", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Nfc extends NearNetworkElement {
        public static final u CREATOR = new u();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f3934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f3935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f3936d;
        public final List e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f3937h;

        public Nfc(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i8 = parcel.readInt();
            byte[] bArrCreateByteArray = parcel.createByteArray();
            List<Byte> list = bArrCreateByteArray != null ? ArraysKt.toList(bArrCreateByteArray) : null;
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            List list2 = arrayListCreateStringArrayList != null ? CollectionsKt.toList(arrayListCreateStringArrayList) : null;
            long j8 = parcel.readLong();
            ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(NdefRecord.CREATOR);
            List list3 = arrayListCreateTypedArrayList != null ? CollectionsKt.toList(arrayListCreateTypedArrayList) : null;
            int i9 = parcel.readInt();
            this.f3933a = i8;
            this.f3934b = list;
            this.f3935c = list2;
            this.f3936d = j8;
            this.e = list3;
            this.f3937h = i9;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Nfc)) {
                return false;
            }
            Nfc nfc = (Nfc) obj;
            return this.f3933a == nfc.f3933a && Intrinsics.areEqual(this.f3934b, nfc.f3934b) && Intrinsics.areEqual(this.f3935c, nfc.f3935c) && this.f3936d == nfc.f3936d && Intrinsics.areEqual(this.e, nfc.e) && this.f3937h == nfc.f3937h;
        }

        public final int hashCode() {
            int iHashCode = Integer.hashCode(this.f3933a) * 31;
            List list = this.f3934b;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            List list2 = this.f3935c;
            int iF = a1.a.f(this.f3936d, (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31, 31);
            List list3 = this.e;
            return Integer.hashCode(this.f3937h) + ((iF + (list3 != null ? list3.hashCode() : 0)) * 31);
        }

        public final String toString() {
            return "Nfc(phyType=" + this.f3933a + ", tagId=" + this.f3934b + ", tagTechList=" + this.f3935c + ", cookie=" + this.f3936d + ", records=" + this.e + ", type=" + this.f3937h + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.f3933a);
            List list = this.f3934b;
            parcel.writeByteArray(list != null ? CollectionsKt.toByteArray(list) : null);
            parcel.writeStringList(this.f3935c);
            parcel.writeLong(this.f3936d);
            parcel.writeTypedList(this.e);
            parcel.writeInt(this.f3937h);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NearNetworkElement$Uwb;", "Lcom/welink/protocol/nfbd/NearNetworkElement;", "CREATOR", "com/welink/protocol/nfbd/v", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Uwb extends NearNetworkElement {
        public static final v CREATOR = new v();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f3939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3940c;

        public Uwb(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i8 = parcel.readInt();
            byte[] bArrCreateByteArray = parcel.createByteArray();
            List<Byte> list = bArrCreateByteArray != null ? ArraysKt.toList(bArrCreateByteArray) : null;
            int i9 = parcel.readInt();
            this.f3938a = i8;
            this.f3939b = list;
            this.f3940c = i9;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Uwb)) {
                return false;
            }
            Uwb uwb = (Uwb) obj;
            return this.f3938a == uwb.f3938a && Intrinsics.areEqual(this.f3939b, uwb.f3939b) && this.f3940c == uwb.f3940c;
        }

        public final int hashCode() {
            int iHashCode = Integer.hashCode(this.f3938a) * 31;
            List list = this.f3939b;
            return Integer.hashCode(this.f3940c) + ((iHashCode + (list == null ? 0 : list.hashCode())) * 31);
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("Uwb(phyType=");
            sb2.append(this.f3938a);
            sb2.append(", address=");
            sb2.append(this.f3939b);
            sb2.append(", type=");
            return h0.a.m(sb2, ")", this.f3940c);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i8) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.f3938a);
            List list = this.f3939b;
            dest.writeByteArray(list != null ? CollectionsKt.toByteArray(list) : null);
            dest.writeInt(this.f3940c);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NearNetworkElement$Wifi;", "Lcom/welink/protocol/nfbd/NearNetworkElement;", "CREATOR", "com/welink/protocol/nfbd/w", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nNearNetworkElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NearNetworkElement.kt\ncom/welink/protocol/nfbd/NearNetworkElement$Wifi\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,307:1\n1#2:308\n9#3,4:309\n*S KotlinDebug\n*F\n+ 1 NearNetworkElement.kt\ncom/welink/protocol/nfbd/NearNetworkElement$Wifi\n*L\n76#1:309,4\n*E\n"})
    public static final /* data */ class Wifi extends NearNetworkElement {
        public static final w CREATOR = new w();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f3943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f3944d;
        public final String e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f3945h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f3946i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f3947j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f3948k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final NetworkParamsInformation f3949l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f3950m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f3951n;

        public Wifi(int i8, String str, Integer num, Integer num2, String str2, Integer num3, Integer num4, int i9, int i10, NetworkParamsInformation networkParamsInformation, int i11, String str3) {
            this.f3941a = i8;
            this.f3942b = str;
            this.f3943c = num;
            this.f3944d = num2;
            this.e = str2;
            this.f3945h = num3;
            this.f3946i = num4;
            this.f3947j = i9;
            this.f3948k = i10;
            this.f3949l = networkParamsInformation;
            this.f3950m = i11;
            this.f3951n = str3;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wifi)) {
                return false;
            }
            Wifi wifi = (Wifi) obj;
            return this.f3941a == wifi.f3941a && Intrinsics.areEqual(this.f3942b, wifi.f3942b) && Intrinsics.areEqual(this.f3943c, wifi.f3943c) && Intrinsics.areEqual(this.f3944d, wifi.f3944d) && Intrinsics.areEqual(this.e, wifi.e) && Intrinsics.areEqual(this.f3945h, wifi.f3945h) && Intrinsics.areEqual(this.f3946i, wifi.f3946i) && this.f3947j == wifi.f3947j && this.f3948k == wifi.f3948k && Intrinsics.areEqual(this.f3949l, wifi.f3949l) && this.f3950m == wifi.f3950m && Intrinsics.areEqual(this.f3951n, wifi.f3951n);
        }

        public final int hashCode() {
            int iHashCode = Integer.hashCode(this.f3941a) * 31;
            String str = this.f3942b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.f3943c;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.f3944d;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str2 = this.e;
            int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num3 = this.f3945h;
            int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.f3946i;
            int iC = a1.a.c(this.f3948k, a1.a.c(this.f3947j, (iHashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31, 31), 31);
            NetworkParamsInformation networkParamsInformation = this.f3949l;
            int iC2 = a1.a.c(this.f3950m, (iC + (networkParamsInformation == null ? 0 : networkParamsInformation.hashCode())) * 31, 31);
            String str3 = this.f3951n;
            return iC2 + (str3 != null ? str3.hashCode() : 0);
        }

        public final String toString() {
            return "Wifi(phyType=" + this.f3941a + ", ssid=" + this.f3942b + ", band=" + this.f3943c + ", channel=" + this.f3944d + ", bssid=" + this.e + ", dataPort=" + this.f3945h + ", controlPort=" + this.f3946i + ", protocol=" + this.f3947j + ", version=" + this.f3948k + ", networkParams=" + this.f3949l + ", type=" + this.f3950m + ", interfaceName=" + this.f3951n + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i8) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.f3941a);
            dest.writeString(this.f3942b);
            Integer num = this.f3943c;
            dest.writeInt(num != null ? num.intValue() : -1);
            Integer num2 = this.f3944d;
            dest.writeInt(num2 != null ? num2.intValue() : -1);
            dest.writeString(this.e);
            Integer num3 = this.f3945h;
            dest.writeInt(num3 != null ? num3.intValue() : -1);
            Integer num4 = this.f3946i;
            dest.writeInt(num4 != null ? num4.intValue() : -1);
            dest.writeInt(this.f3947j);
            dest.writeInt(this.f3948k);
            dest.writeTypedObject(this.f3949l, i8);
            dest.writeInt(this.f3950m);
            dest.writeString(this.f3951n);
        }
    }
}
