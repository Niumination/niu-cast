package te;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.welink.protocol.nfc.NfcUtils$MapContentParcelable;
import kotlin.jvm.internal.Intrinsics;
import te.a;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new Parcelable(parcel) { // from class: com.welink.protocol.nfc.NfcUtils$MapContentParcelable
            public static final a CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final SparseArray f4210a;

            {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                SparseArray map = new SparseArray();
                int i8 = parcel.readInt();
                for (int i9 = 0; i9 < i8; i9++) {
                    map.put(parcel.readInt(), parcel.createByteArray());
                }
                Intrinsics.checkNotNullParameter(map, "map");
                this.f4210a = map;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NfcUtils$MapContentParcelable) && Intrinsics.areEqual(this.f4210a, ((NfcUtils$MapContentParcelable) obj).f4210a);
            }

            public final int hashCode() {
                return this.f4210a.hashCode();
            }

            public final String toString() {
                return "MapContentParcelable(map=" + this.f4210a + ")";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel2, int i8) {
                Intrinsics.checkNotNullParameter(parcel2, "parcel");
                SparseArray sparseArray = this.f4210a;
                parcel2.writeInt(sparseArray.size());
                int size = sparseArray.size();
                for (int i9 = 0; i9 < size; i9++) {
                    int iKeyAt = sparseArray.keyAt(i9);
                    byte[] bArr = (byte[]) sparseArray.valueAt(i9);
                    parcel2.writeInt(iKeyAt);
                    parcel2.writeByteArray(bArr);
                }
            }
        };
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new NfcUtils$MapContentParcelable[i8];
    }
}
