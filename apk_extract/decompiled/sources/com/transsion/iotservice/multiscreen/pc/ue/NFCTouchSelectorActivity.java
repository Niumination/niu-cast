package com.transsion.iotservice.multiscreen.pc.ue;

import ag.a;
import ag.d0;
import android.app.Application;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import eb.k1;
import eb.y;
import java.util.ArrayList;
import k3.gc;
import k3.o1;
import k3.pb;
import k3.ub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import li.l0;
import m3.q;
import m3.v;
import na.k;
import ob.b;
import pb.c;
import pb.d;
import se.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ue/NFCTouchSelectorActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NFCTouchSelectorActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2680b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f2681a;

    public final void init() {
        y yVar = y.f4799a;
        if (y.f != 0) {
            l0.p(LifecycleOwnerKt.getLifecycleScope(this), null, null, new d(this, new d0(this, 22), null), 3);
            return;
        }
        DeviceConnectState deviceConnectState = DeviceConnectState.INSTANCE;
        if (deviceConnectState.isConnecting()) {
            Intrinsics.checkNotNullParameter("NFCTouchSelectorActivity1", "tag");
            Intrinsics.checkNotNullParameter("PCManager.isDeviceConnecting finish", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("NFCTouchSelectorActivity1"), "PCManager.isDeviceConnecting finish");
            }
            k kVar = k.f8141a;
            String string = getString(R$string.module_pc_connecting);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.d(this, string);
        } else if (deviceConnectState.isConnected()) {
            Intrinsics.checkNotNullParameter("NFCTouchSelectorActivity1", "tag");
            Intrinsics.checkNotNullParameter("PCManager.isDeviceConnected finish", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("NFCTouchSelectorActivity1"), "PCManager.isDeviceConnected finish");
            }
            k kVar2 = k.f8141a;
            String string2 = getString(R$string.module_this_pc_using);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            kVar2.d(this, string2);
        } else if (ub.b()) {
            k kVar3 = k.f8141a;
            Application applicationA = pb.a();
            String string3 = pb.a().getResources().getString(R$string.module_pc_close_hotspot_conn_toast);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            kVar3.d(applicationA, string3);
        } else {
            k();
        }
        j();
    }

    public final void j() {
        l0.p(LifecycleOwnerKt.getLifecycleScope(this), null, null, new c(this, null), 3);
    }

    public final void k() {
        b.f8417b.getClass();
        Intrinsics.checkNotNullParameter("connect_by_nfc", "conType");
        b.f8423j = "connect_by_nfc";
        Intent intent = new Intent(this, (Class<?>) P2PConnectService.class);
        ArrayList<String> arrayList = this.f2681a;
        ArrayList arrayList2 = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNfcAddressInfo");
            arrayList = null;
        }
        intent.putStringArrayListExtra("remote_device_info", arrayList);
        ArrayList arrayList3 = this.f2681a;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNfcAddressInfo");
        } else {
            arrayList2 = arrayList3;
        }
        String log = "startP2PConnectService: mNfcAddressInfo = " + arrayList2;
        Intrinsics.checkNotNullParameter("NFCTouchSelectorActivity1", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("NFCTouchSelectorActivity1"), log);
        }
        intent.putExtra("connect_type", "nfc");
        k1 k1Var = k1.f4765a;
        k1.j("nfc");
        startService(intent);
    }

    /* JADX WARN: Code duplicated, block: B:85:0x024f  */
    /* JADX WARN: Code duplicated, block: B:87:0x025b  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        ArrayList<String> arrayList;
        String action;
        byte[] data;
        super.onCreate(bundle);
        gc.a("NFCTouchSelectorActivity1", "onCreate");
        getWindow().setStatusBarColor(0);
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().addFlags(512);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (bundle == null || (arrayList = bundle.getStringArrayList("address_key")) == null || arrayList.isEmpty()) {
            if (intent == null || (action = intent.getAction()) == null) {
                arrayList = new ArrayList<>();
            } else if (Intrinsics.areEqual("android.nfc.action.TAG_DISCOVERED", action) || Intrinsics.areEqual("android.nfc.action.TECH_DISCOVERED", action) || Intrinsics.areEqual("android.nfc.action.NDEF_DISCOVERED", action)) {
                NdefMessage[] ndefMessageArr = (NdefMessage[]) intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES", NdefMessage.class);
                byte[] bArr = null;
                if (ndefMessageArr == null || ndefMessageArr.length == 0) {
                    Intrinsics.checkNotNullParameter("NfcMsgDecode", "tag");
                    Intrinsics.checkNotNullParameter("rawMessage is null", "log");
                    if (gc.f6462a <= 6) {
                        Log.e(gc.f6463b.concat("NfcMsgDecode"), "rawMessage is null");
                    }
                } else {
                    NdefRecord[] records = ndefMessageArr[0].getRecords();
                    if (records == null || records.length == 0) {
                        Intrinsics.checkNotNullParameter("NfcMsgDecode", "tag");
                        Intrinsics.checkNotNullParameter("NFC msg records is null", "log");
                        if (gc.f6462a <= 6) {
                            Log.e(gc.f6463b.concat("NfcMsgDecode"), "NFC msg records is null");
                        }
                    } else {
                        data = records[0].getPayload();
                    }
                    if (data != null || data.length == 0) {
                        Intrinsics.checkNotNullParameter("NfcMsgDecode", "tag");
                        Intrinsics.checkNotNullParameter("payload is null", "log");
                        if (gc.f6462a <= 6) {
                            Log.e(gc.f6463b.concat("NfcMsgDecode"), "payload is null");
                        }
                        arrayList = new ArrayList<>();
                    } else {
                        byte[] key = {-17, -66, -83, -34, -67, -49, -70, -81, -58, -41, -72, -23, 66, 9, 53, -3};
                        gc.a("NfcMsgDecode", "Encode HEX RAW: " + q.j(data));
                        gc.a("NfcMsgDecode", "Decode ASCII RAW: " + q.h(data));
                        Intrinsics.checkNotNullParameter(data, "data");
                        Intrinsics.checkNotNullParameter(key, "key");
                        if ((data.length != 0 ? data : null) != null) {
                            int[] iArrA = v.a(data);
                            int[] iArrA2 = v.a(key);
                            int length = iArrA.length;
                            int i8 = length - 1;
                            if (i8 >= 1) {
                                int i9 = (52 / length) + 6;
                                int i10 = iArrA[0];
                                for (int i11 = i9 * (-1640531527); i11 != 0; i11 -= -1640531527) {
                                    int i12 = (i11 >>> 2) & 3;
                                    int i13 = i8;
                                    while (i13 > 0) {
                                        int i14 = iArrA[i13 - 1];
                                        i10 = iArrA[i13] - ((((i14 >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i14 << 4))) ^ ((i11 ^ i10) + (iArrA2[(i13 & 3) ^ i12] ^ i14)));
                                        iArrA[i13] = i10;
                                        i13--;
                                    }
                                    int i15 = iArrA[i8];
                                    i10 = iArrA[0] - ((((i15 >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i15 << 4))) ^ ((i11 ^ i10) + (iArrA2[(i13 & 3) ^ i12] ^ i15)));
                                    iArrA[0] = i10;
                                }
                            }
                            int length2 = iArrA.length << 2;
                            int i16 = iArrA[iArrA.length - 1];
                            int i17 = length2 - 4;
                            if (i16 >= length2 - 7 && i16 <= i17) {
                                bArr = new byte[i16];
                                for (int i18 = 0; i18 < i16; i18++) {
                                    bArr[i18] = (byte) (iArrA[i18 >>> 2] >>> ((i18 & 3) << 3));
                                }
                            }
                            if (bArr != null) {
                                data = bArr;
                            }
                        }
                        gc.a("NfcMsgDecode", "Decode HEX RAW: " + q.j(data));
                        String strH = q.h(data);
                        gc.a("NfcMsgDecode", "Decode String: " + strH);
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        if (new Regex("(\\w\\d){4}|\\S*|([0-9A-Fa-f]{2})(-[0-9A-Fa-f]{2}){5}|\\S*|\\S*").matches(strH)) {
                            for (String strSubstring : new Regex("\\|").split(strH, 0)) {
                                int length3 = strSubstring.length();
                                for (int i19 = 0; i19 < length3; i19++) {
                                    if (Intrinsics.compare((int) strSubstring.charAt(i19), 32) < 0) {
                                        strSubstring = strSubstring.substring(0, i19);
                                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                        break;
                                    }
                                }
                                String strN = o.d.n("parser payload: ", strSubstring, "NfcMsgDecode", "tag", "log");
                                if (gc.f6462a <= 3) {
                                    Log.d(gc.f6463b.concat("NfcMsgDecode"), strN);
                                }
                                arrayList2.add(strSubstring);
                            }
                        }
                        arrayList = arrayList2;
                    }
                }
                data = null;
                if (data != null) {
                    Intrinsics.checkNotNullParameter("NfcMsgDecode", "tag");
                    Intrinsics.checkNotNullParameter("payload is null", "log");
                    if (gc.f6462a <= 6) {
                        Log.e(gc.f6463b.concat("NfcMsgDecode"), "payload is null");
                    }
                    arrayList = new ArrayList<>();
                } else {
                    Intrinsics.checkNotNullParameter("NfcMsgDecode", "tag");
                    Intrinsics.checkNotNullParameter("payload is null", "log");
                    if (gc.f6462a <= 6) {
                        Log.e(gc.f6463b.concat("NfcMsgDecode"), "payload is null");
                    }
                    arrayList = new ArrayList<>();
                }
            } else {
                Intrinsics.checkNotNullParameter("NfcMsgDecode", "tag");
                Intrinsics.checkNotNullParameter("action error", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("NfcMsgDecode"), "action error");
                }
                arrayList = new ArrayList<>();
            }
        }
        if (arrayList.size() < 2) {
            Intrinsics.checkNotNullParameter("NFCTouchSelectorActivity1", "tag");
            Intrinsics.checkNotNullParameter("init: ill address info", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("NFCTouchSelectorActivity1"), "init: ill address info");
            }
            j();
            return;
        }
        this.f2681a = arrayList;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a4.b(this, 18));
        if (h.m(this, activityResultLauncherRegisterForActivityResult, 0)) {
            return;
        }
        o1.d(this, activityResultLauncherRegisterForActivityResult, new a(this, 6));
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Intrinsics.checkNotNullParameter("NFCTouchSelectorActivity1", "tag");
        Intrinsics.checkNotNullParameter("onSaveInstanceState", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("NFCTouchSelectorActivity1"), "onSaveInstanceState");
        }
        ArrayList<String> arrayList = this.f2681a;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNfcAddressInfo");
            arrayList = null;
        }
        outState.putStringArrayList("android.nfc.extra.NDEF_MESSAGES", arrayList);
    }
}
