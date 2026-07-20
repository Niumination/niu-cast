package oe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import k3.hc;
import k3.lb;
import kotlin.Triple;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qe.f;
import qe.i;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final UUID f8449m = UUID.fromString("0000FD35-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final UUID f8450n = UUID.fromString("00009231-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final UUID f8451o = UUID.fromString("00003166-0000-1000-8000-00805f9b34fb");
    public static int p = 15;
    public static final int q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ArrayBlockingQueue f8452r = new ArrayBlockingQueue(20);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final f f8453s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f8454t;
    public static int u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f8456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BluetoothAdapter f8457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothGatt f8458d;
    public BluetoothGattCharacteristic e;
    public BluetoothDevice f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f8459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f8463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8464l;

    static {
        f fVar = new f();
        fVar.f9013a = (byte) -1;
        fVar.f9014b = true;
        fVar.f9015c = -1;
        fVar.f9016d = 0;
        f8453s = fVar;
    }

    public c(String str, Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f8455a = str;
        this.f8456b = mContext;
        this.f8457c = BluetoothAdapter.getDefaultAdapter();
        this.f8459g = new ArrayList();
        this.f8462j = true;
        int i8 = 0;
        new b(this, i8);
        this.f8463k = new a(this, i8);
    }

    public static final void a(c cVar, byte[] bArr) {
        cVar.getClass();
        List<Byte> listAsList = ArraysKt.asList(bArr);
        int length = bArr.length;
        if (length == 0) {
            Intrinsics.checkNotNullParameter("receiveData size is 0", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "receiveData size is 0", null);
                return;
            }
            return;
        }
        if (length == 1) {
            if (bArr[0] == -18) {
                Intrinsics.checkNotNullParameter("receiveData has HEADER_IDENTIFY only", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "receiveData has HEADER_IDENTIFY only", null);
                }
                cVar.f8459g.clear();
                cVar.f8459g.addAll(listAsList);
                return;
            }
            if (cVar.f8459g.isEmpty()) {
                return;
            }
            Intrinsics.checkNotNullParameter("receiveData hasn't HEADER_IDENTIFY,but buffer no empty", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "receiveData hasn't HEADER_IDENTIFY,but buffer no empty", null);
            }
            cVar.f8459g.addAll(listAsList);
            cVar.h();
            return;
        }
        if (bArr[0] != -18) {
            if (!cVar.f8459g.isEmpty()) {
                Intrinsics.checkNotNullParameter("buffer not empty,add in the last", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "buffer not empty,add in the last", null);
                }
                cVar.f8459g.addAll(listAsList);
                cVar.h();
                return;
            }
            if (!listAsList.contains((byte) -18)) {
                Intrinsics.checkNotNullParameter("receiveData hasn't HEADER_IDENTIFY", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "receiveData hasn't HEADER_IDENTIFY", null);
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullParameter("receiveData has HEADER_IDENTIFY,but not on the first", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "receiveData has HEADER_IDENTIFY,but not on the first", null);
            }
            cVar.f8459g.addAll(listAsList.subList(listAsList.indexOf((byte) -18), listAsList.size()));
            cVar.h();
            return;
        }
        int length2 = bArr.length;
        int i8 = q;
        if (length2 < i8) {
            String strH = o.d.h(bArr.length, "receiveData size is wrong: ", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", strH, null);
                return;
            }
            return;
        }
        int iM177constructorimpl = ((((UByte.m177constructorimpl(bArr[3]) & 32) >> 5) << 9) | (((UByte.m177constructorimpl(bArr[3]) & 16) >> 4) << 8) | (UByte.m177constructorimpl(bArr[1]) & UByte.MAX_VALUE)) + i8;
        if (bArr.length == iM177constructorimpl) {
            cVar.g(listAsList);
            return;
        }
        if (bArr.length < iM177constructorimpl) {
            Intrinsics.checkNotNullParameter("receiveData short", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "receiveData short", null);
            }
            cVar.f8459g.clear();
            cVar.f8459g.addAll(listAsList);
            return;
        }
        Intrinsics.checkNotNullParameter("receiveData long", "mes");
        if (lb.f6529c >= 1) {
            Log.e("welinkBLE", "receiveData long", null);
        }
        cVar.g(listAsList.subList(0, iM177constructorimpl));
        if (listAsList.get(iM177constructorimpl).byteValue() == -18) {
            cVar.f8459g.clear();
            cVar.f8459g.addAll(listAsList.subList(iM177constructorimpl, listAsList.size()));
            cVar.h();
        }
    }

    public static void c(BluetoothGatt gatt) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        gatt.requestConnectionPriority(0);
        try {
            Method declaredMethod = gatt.getClass().getDeclaredMethod("refresh", null);
            h.g("now refresh gatt! result is " + (declaredMethod != null ? declaredMethod.invoke(gatt, null) : null) + " gatt is " + gatt);
        } catch (Exception e) {
            e.printStackTrace();
            String mes = "refresh: error!!!" + e.getMessage();
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", mes, null);
            }
        }
        gatt.close();
        hc.b();
    }

    public final void b() {
        this.f8462j = false;
        h.g("主动断开gatt，后续不再自动回连gatt, mBluetoothGatt is " + this.f8458d);
        BluetoothGatt bluetoothGatt = this.f8458d;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
    }

    public final void d(byte[] bArr) {
        h.g("handleSendData: size is : " + bArr.length + ", data is: ");
        h.g("handleSendData: This package does not need response confirm, now send data is ");
        h.g("finalSendData: mReadWriteCharacteristic " + this.e + "  mIsDevice is false ");
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.e;
        int i8 = 0;
        if (bluetoothGattCharacteristic != null) {
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            h.g("finalSendData: Phone: now in finalSendData, send writeCharacter to phone, send value is:");
            BluetoothGatt bluetoothGatt = this.f8458d;
            if (bluetoothGatt != null) {
                this.f8464l = false;
                while (!this.f8464l && this.f8461i && this.f8460h && !bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic)) {
                    int i9 = i8 + 1;
                    if (i8 >= 5000) {
                        i8 = i9;
                        break;
                    } else {
                        Thread.sleep(1L);
                        i8 = i9;
                    }
                }
                if (i8 >= 5000) {
                    String mes = "finalSendData: Phone: send maybe error, mIsLastSendOK: " + this.f8464l + " retry time: " + i8 + "!";
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", mes, null);
                    }
                }
            }
        }
        if (i8 >= 5000) {
            Intrinsics.checkNotNullParameter("finalSendData: Error: local send error by retry timeout!", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "finalSendData: Error: local send error by retry timeout!", null);
                return;
            }
            return;
        }
        boolean z2 = this.f8461i;
        if (z2 && this.f8460h) {
            h.g("finalSendData: local send finish!");
            f fVar = f8453s;
            fVar.f9014b = true;
            int iM177constructorimpl = UByte.m177constructorimpl(bArr[4]) & UByte.MAX_VALUE;
            fVar.f9015c = iM177constructorimpl;
            h.g("finalSendData: This send package does not need response, mHugeDataModel.dataPackageIndex is " + iM177constructorimpl + "!");
            return;
        }
        String mes2 = "finalSendData: Error: send error!!! GattConnect is " + z2 + ", DescriptorWriteStatus is " + this.f8460h + "!";
        Intrinsics.checkNotNullParameter(mes2, "mes");
        if (lb.f6529c >= 1) {
            Log.e("welinkBLE", mes2, null);
        }
    }

    public final void e(byte b9, int i8) {
        byte[] bArr = {(byte) i8, 1};
        Intrinsics.checkNotNullParameter("ResponseReceivedError", "mes");
        if (lb.f6529c >= 1) {
            Log.e("welinkBLE", "ResponseReceivedError", null);
        }
        f(b9, true, bArr);
    }

    public final void f(byte b9, boolean z2, byte[] sendArray) {
        Intrinsics.checkNotNullParameter(sendArray, "sendArray");
        f8452r.add(new Triple(1, new i(b9, z2, sendArray), this));
    }

    public final void g(List list) {
        int size = list.size();
        int i8 = q;
        if (size < i8) {
            Intrinsics.checkNotNullParameter("receiveData's size is wrong, smaller than FRAME_HEAD_LENGTH", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "receiveData's size is wrong, smaller than FRAME_HEAD_LENGTH", null);
                return;
            }
            return;
        }
        byte bByteValue = ((Number) list.get(0)).byteValue();
        byte bByteValue2 = ((Number) list.get(2)).byteValue();
        boolean z2 = ((byte) (((Number) list.get(3)).byteValue() & 1)) == 1;
        boolean z3 = (((byte) (((Number) list.get(3)).byteValue() & 2)) >> 1) == 1;
        boolean z5 = (((byte) (((Number) list.get(3)).byteValue() & 4)) >> 2) == 1;
        int iM177constructorimpl = UByte.m177constructorimpl(((Number) list.get(4)).byteValue()) & UByte.MAX_VALUE;
        if (bByteValue != -18) {
            String strH = o.d.h(bByteValue, "This is not our packet, packetHeardFlag is ", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", strH, null);
                return;
            }
            return;
        }
        int iM177constructorimpl2 = (((UByte.m177constructorimpl(((Number) list.get(3)).byteValue()) & 16) >> 4) << 8) | (((UByte.m177constructorimpl(((Number) list.get(3)).byteValue()) & 32) >> 5) << 9) | (UByte.m177constructorimpl(((Number) list.get(1)).byteValue()) & UByte.MAX_VALUE);
        h.g("completeDataLength is " + iM177constructorimpl2);
        if (iM177constructorimpl2 != list.size() - i8 || list.size() - i8 > p) {
            h.g("The length of the data is wrong, packetDataLen is " + (list.size() - p));
            if (z5) {
                e(bByteValue2, iM177constructorimpl);
                return;
            }
            return;
        }
        if (z2) {
            int iM177constructorimpl3 = UByte.m177constructorimpl(((Number) list.get(i8)).byteValue()) & UByte.MAX_VALUE;
            boolean z10 = (UByte.m177constructorimpl(((Number) list.get(i8 + 1)).byteValue()) & UByte.MAX_VALUE) == 0;
            f fVar = f8453s;
            h.g("responseSuccessPackageIndex is " + iM177constructorimpl3 + ", respondReceivedSuccess is " + z10 + " mHugeDataModel.dataPackageIndex is " + fVar.f9015c);
            if ((UByte.m177constructorimpl(fVar.f9013a) & UByte.MAX_VALUE) == (UByte.m177constructorimpl(bByteValue2) & UByte.MAX_VALUE) && iM177constructorimpl3 == fVar.f9015c) {
                if (z10) {
                    fVar.f9014b = true;
                    h.g("Success: in receive : mIsRemoteReceivedSuccess is true");
                } else {
                    fVar.f9014b = false;
                    h.d("Error: in receive  : mIsRemoteReceivedSuccess is false", null);
                }
            }
        }
        i(bByteValue2, iM177constructorimpl, z3, z5, CollectionsKt.drop(list, i8));
    }

    public final void h() {
        if (this.f8459g.size() >= 2) {
            if (((Number) this.f8459g.get(0)).byteValue() != -18) {
                h.g("mDataBuff first is not HEADER_IDENTIFY");
                return;
            }
            int size = this.f8459g.size();
            int i8 = q;
            if (size < i8) {
                Intrinsics.checkNotNullParameter("mDataBuff's size is wrong, smaller than FRAME_HEAD_LENGTH", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "mDataBuff's size is wrong, smaller than FRAME_HEAD_LENGTH", null);
                    return;
                }
                return;
            }
            int iM177constructorimpl = ((((UByte.m177constructorimpl(((Number) this.f8459g.get(3)).byteValue()) & 16) >> 4) << 8) | (((UByte.m177constructorimpl(((Number) this.f8459g.get(3)).byteValue()) & 32) >> 5) << 9) | (UByte.m177constructorimpl(((Number) this.f8459g.get(1)).byteValue()) & UByte.MAX_VALUE)) + i8;
            while (this.f8459g.size() >= iM177constructorimpl) {
                if (this.f8459g.size() == iM177constructorimpl) {
                    g(this.f8459g);
                    this.f8459g.clear();
                } else if (this.f8459g.size() > iM177constructorimpl) {
                    List list = this.f8459g;
                    g(list.subList(0, list.indexOf((byte) -18)));
                    List list2 = this.f8459g;
                    if (((Number) list2.get(list2.indexOf((byte) -18))).byteValue() == -18) {
                        List list3 = this.f8459g;
                        this.f8459g = list3.subList(list3.indexOf((byte) -18), this.f8459g.size());
                    } else {
                        this.f8459g.clear();
                    }
                }
            }
        }
    }

    public abstract void i(byte b9, int i8, boolean z2, boolean z3, List list);
}
