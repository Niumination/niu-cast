package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Parcelable;
import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.utils.DeviceData;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.LinkedHashSet;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Parcelable f9905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9907d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f9908h;

    public /* synthetic */ o0(DeviceData deviceData, int i8, NearDevice nearDevice, com.welink.protocol.nfbd.z zVar, int i9) {
        this.f9904a = 2;
        this.f9908h = deviceData;
        this.f9907d = i8;
        this.f9905b = nearDevice;
        this.f9906c = zVar;
        this.e = i9;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        BluetoothGattService service;
        BluetoothDevice bluetoothDevice;
        BluetoothDevice bluetoothDevice2;
        String mes;
        String str;
        String str2;
        switch (this.f9904a) {
            case 0:
                com.welink.protocol.nfbd.f fVar = (com.welink.protocol.nfbd.f) this.f9908h;
                fVar.getClass();
                JSONObject jSONObject = new JSONObject();
                com.welink.protocol.nfbd.d dVar = fVar.f4101d;
                String str3 = (String) this.f9906c;
                if (str3 == null) {
                    str3 = dVar != null ? "1.0" : null;
                }
                jSONObject.put("Version", str3);
                jSONObject.put("Encrypt", this.f9907d);
                jSONObject.put("ReqType", 47873);
                jSONObject.put("DeviceId", dVar != null ? dVar.o() : null);
                jSONObject.put("Mac", dVar != null ? dVar.p() : null);
                jSONObject.put("state", this.e);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                LinkedHashSet linkedHashSet = fVar.f4109n;
                BluetoothDevice bluetoothDevice3 = (BluetoothDevice) this.f9905b;
                if (!linkedHashSet.contains(bluetoothDevice3)) {
                    String strN = o.d.n("Device not registered for notifications: ", bluetoothDevice3.getAddress(), "NearBluetoothServer", "tag", "mes");
                    if (lb.f6529c >= 1) {
                        h0.a.x("TransConnect:", strN, "NearBluetoothServer", null);
                    }
                } else {
                    fVar.t(bluetoothDevice3, 0, bytes);
                }
                break;
            case 1:
                com.welink.protocol.nfbd.l lVar = (com.welink.protocol.nfbd.l) this.f9908h;
                lVar.getClass();
                JSONObject jSONObject2 = new JSONObject();
                com.welink.protocol.nfbd.a aVar = lVar.f;
                String str4 = (String) this.f9906c;
                if (str4 == null) {
                    str4 = aVar != null ? "1.0" : null;
                }
                jSONObject2.put("Version", str4);
                jSONObject2.put("Encrypt", this.f9907d);
                jSONObject2.put("ReqType", 47873);
                jSONObject2.put("DeviceId", aVar != null ? aVar.n() : null);
                jSONObject2.put("Mac", aVar != null ? aVar.o() : null);
                jSONObject2.put("state", this.e);
                String string2 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                byte[] bytes2 = string2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                LinkedHashSet linkedHashSet2 = lVar.f4156j;
                BluetoothDevice bluetoothDevice4 = (BluetoothDevice) this.f9905b;
                if (!linkedHashSet2.contains(bluetoothDevice4)) {
                    String strN2 = o.d.n("Device not registered for notifications: ", bluetoothDevice4.getAddress(), "NearGattService", "tag", "mes");
                    if (lb.f6529c >= 1) {
                        h0.a.x("TransConnect:", strN2, "NearGattService", null);
                    }
                } else {
                    BluetoothGattServer bluetoothGattServer = lVar.e;
                    lVar.v(bluetoothDevice4, (bluetoothGattServer == null || (service = bluetoothGattServer.getService(c6.f9688a)) == null) ? null : service.getCharacteristic(c6.f9691d), 0, 0, bytes2);
                }
                break;
            default:
                DeviceData deviceData = (DeviceData) this.f9908h;
                we.c cVar = deviceData != null ? deviceData.f4213a : null;
                int i8 = cVar == null ? -1 : l5.$EnumSwitchMapping$0[cVar.ordinal()];
                int i9 = this.f9907d;
                NearDevice nearDevice = (NearDevice) this.f9905b;
                com.welink.protocol.nfbd.z zVar = (com.welink.protocol.nfbd.z) this.f9906c;
                int i10 = this.e;
                switch (i8) {
                    case 1:
                    case 2:
                        if (i9 == 1008) {
                            if (nearDevice == null || (bluetoothDevice = deviceData.f4216d) == null) {
                                BluetoothDevice bluetoothDevice5 = deviceData.f4216d;
                                if (bluetoothDevice5 == null) {
                                    Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
                                    Intrinsics.checkNotNullParameter("Device Ble connected,but info is null", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TranConnectionManager", "TransConnect:Device Ble connected,but info is null", null);
                                    }
                                } else {
                                    zVar.l(i10, bluetoothDevice5, null);
                                }
                            } else {
                                zVar.l(i10, bluetoothDevice, nearDevice);
                            }
                            break;
                        } else if (i9 == 1010) {
                            if (nearDevice == null || (bluetoothDevice2 = deviceData.f4216d) == null) {
                                BluetoothDevice bluetoothDevice6 = deviceData.f4216d;
                                if (bluetoothDevice6 == null) {
                                    Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
                                    Intrinsics.checkNotNullParameter("Device Ble disconnected,but info is null", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TranConnectionManager", "TransConnect:Device Ble disconnected,but info is null", null);
                                    }
                                } else {
                                    zVar.m(i10, bluetoothDevice6, null);
                                }
                            } else {
                                zVar.m(i10, bluetoothDevice2, nearDevice);
                            }
                            break;
                        } else {
                            mes = o.d.m("Bluetooth Unknown device state: ", "TranConnectionManager", "tag", "mes", i9);
                            if (lb.f6529c < 1) {
                            }
                        }
                        break;
                    case 3:
                        if (i9 == 1031) {
                            if (nearDevice != null) {
                                LanNetworkInfo lanNetworkInfo = deviceData.f4215c;
                                if ((lanNetworkInfo != null ? lanNetworkInfo.f4237a : null) != null && (str = lanNetworkInfo.f4238b) != null) {
                                    zVar.n(lanNetworkInfo.f4237a, str, nearDevice);
                                }
                            }
                            LanNetworkInfo lanNetworkInfo2 = deviceData.f4215c;
                            if ((lanNetworkInfo2 != null ? lanNetworkInfo2.f4237a : null) != null) {
                                zVar.n(lanNetworkInfo2.f4237a, nearDevice != null ? nearDevice.l() : null, nearDevice);
                            } else if ((nearDevice != null ? nearDevice.s() : null) == null) {
                                Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
                                Intrinsics.checkNotNullParameter("Device Lan connected, but remote or local address is null", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("TranConnectionManager", "TransConnect:Device Lan connected, but remote or local address is null", null);
                                }
                            } else {
                                String strS = nearDevice.s();
                                Intrinsics.checkNotNull(strS);
                                zVar.n(strS, nearDevice.l(), nearDevice);
                            }
                            break;
                        } else if (i9 == 1032) {
                            if (nearDevice != null) {
                                LanNetworkInfo lanNetworkInfo3 = deviceData.f4215c;
                                if ((lanNetworkInfo3 != null ? lanNetworkInfo3.f4237a : null) != null && (str2 = lanNetworkInfo3.f4238b) != null) {
                                    zVar.o(lanNetworkInfo3.f4237a, str2, nearDevice, i10);
                                }
                            }
                            LanNetworkInfo lanNetworkInfo4 = deviceData.f4215c;
                            if ((lanNetworkInfo4 != null ? lanNetworkInfo4.f4237a : null) == null) {
                                Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
                                Intrinsics.checkNotNullParameter("Device Lan disconnected, but remote or local address is null", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("TranConnectionManager", "TransConnect:Device Lan disconnected, but remote or local address is null", null);
                                }
                                LanNetworkInfo lanNetworkInfo5 = deviceData.f4215c;
                                zVar.o("127.0.0.1", lanNetworkInfo5 != null ? lanNetworkInfo5.f4238b : null, nearDevice, i10);
                            } else {
                                zVar.o(lanNetworkInfo4.f4237a, lanNetworkInfo4.f4238b, nearDevice, i10);
                            }
                            break;
                        } else {
                            mes = o.d.m("WLAN Unknown device state: ", "TranConnectionManager", "tag", "mes", i9);
                            if (lb.f6529c < 1) {
                            }
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        we.h.j("TranConnectionManager", "Unsupported device type: " + deviceData.f4213a);
                        break;
                    default:
                        mes = "Unknown device type: " + (deviceData != null ? deviceData.f4213a : null);
                        Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c < 1) {
                        }
                        break;
                }
                h0.a.x("TransConnect:", mes, "TranConnectionManager", null);
                break;
        }
    }

    public /* synthetic */ o0(we.g gVar, BluetoothDevice bluetoothDevice, String str, int i8, int i9, int i10) {
        this.f9904a = i10;
        this.f9908h = gVar;
        this.f9905b = bluetoothDevice;
        this.f9906c = str;
        this.f9907d = i8;
        this.e = i9;
    }
}
