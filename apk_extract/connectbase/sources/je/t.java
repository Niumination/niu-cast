package je;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.telephony.ITranTelephony;
import com.transsion.hubsdk.telephony.TranServiceState;

/* JADX INFO: loaded from: classes2.dex */
public class t implements dh.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8705b = "t";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranTelephony f8706a = ITranTelephony.Stub.asInterface(TranServiceManager.getServiceIBinder("telephony"));

    public final /* synthetic */ Object D(int i10) throws RemoteException {
        ITranTelephony iTranTelephony = this.f8706a;
        if (iTranTelephony != null) {
            return Integer.valueOf(iTranTelephony.getNetworkType(i10));
        }
        return 0;
    }

    public final /* synthetic */ Object E() throws RemoteException {
        ITranTelephony iTranTelephony = this.f8706a;
        if (iTranTelephony != null) {
            return Integer.valueOf(iTranTelephony.getRadioPowerState());
        }
        return 0;
    }

    public final /* synthetic */ Object F(int i10) throws RemoteException {
        ITranTelephony iTranTelephony = this.f8706a;
        return iTranTelephony != null ? iTranTelephony.getSimOperatorNameExt(i10) : "";
    }

    public final /* synthetic */ Object G() throws RemoteException {
        ITranTelephony iTranTelephony = this.f8706a;
        if (iTranTelephony != null) {
            return Integer.valueOf(iTranTelephony.getSimState());
        }
        return 0;
    }

    public final /* synthetic */ Object H(int i10) throws RemoteException {
        ITranTelephony iTranTelephony = this.f8706a;
        if (iTranTelephony != null) {
            return Integer.valueOf(iTranTelephony.getSimStateForSlotIndex(i10));
        }
        return 0;
    }

    public final /* synthetic */ Object I() throws RemoteException {
        ITranTelephony iTranTelephony = this.f8706a;
        if (iTranTelephony != null) {
            return Integer.valueOf(iTranTelephony.getSlotIndex());
        }
        return -1;
    }

    public final /* synthetic */ Object J(int i10) throws RemoteException {
        ITranTelephony iTranTelephony = this.f8706a;
        return iTranTelephony != null ? Boolean.valueOf(iTranTelephony.isNetworkRoaming(i10)) : Boolean.FALSE;
    }

    @VisibleForTesting
    public void K(ITranTelephony iTranTelephony) {
        this.f8706a = iTranTelephony;
    }

    @Override // dh.f
    public String a(final int i10) {
        String str = (String) new zb.f().c(new zb.f.b() { // from class: je.s
            @Override // zb.f.b
            public final Object run() {
                return this.f8703a.F(i10);
            }
        }, "telephony");
        dc.e.f(f8705b, "getSimOperatorName subId:" + i10);
        return str;
    }

    @Override // dh.f
    public int b(final int i10) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: je.m
            @Override // zb.f.b
            public final Object run() {
                return this.f8694a.H(i10);
            }
        }, "telephony")).intValue();
        dc.e.f(f8705b, "getSimStateForSlotIndex subId:" + i10);
        return iIntValue;
    }

    @Override // dh.f
    public void c(boolean z10) {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                iTranTelephony.setDataEnabled(z10);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // dh.f
    public int d(final int i10) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: je.p
            @Override // zb.f.b
            public final Object run() {
                return this.f8698a.D(i10);
            }
        }, "telephony")).intValue();
        dc.e.f(f8705b, "getNetworkType");
        return iIntValue;
    }

    @Override // dh.f
    public boolean e(int i10, String str) {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.isRadioOnForSubscriber(i10, str);
            }
            return false;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // dh.f
    public int f() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: je.q
            @Override // zb.f.b
            public final Object run() {
                return this.f8700a.I();
            }
        }, "telephony")).intValue();
        dc.e.f(f8705b, "getSlotIndex");
        return iIntValue;
    }

    @Override // dh.f
    public boolean g(String str) {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.isPotentialEmergencyNumber(str);
            }
            return false;
        } catch (RemoteException e10) {
            j7.b.a("isPotentialEmergencyNumber fail:", e10, f8705b);
            return false;
        }
    }

    @Override // dh.f
    public String h() {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.getSimOperator();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getSimOperator fail:", e10, f8705b);
            return null;
        }
    }

    @Override // dh.f
    public String i() {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.getNai();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getNai fail:", e10, f8705b);
            return null;
        }
    }

    @Override // dh.f
    public String j(int i10) {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.getNaiForSlot(i10);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getNaiForSlot fail:", e10, f8705b);
            return null;
        }
    }

    @Override // dh.f
    public String k() {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.getLine1Number();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getLine1Number fail:", e10, f8705b);
            return null;
        }
    }

    @Override // dh.f
    public String l(int i10) {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.getLine1NumberBySubId(i10);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getLine1NumberBySubId fail:", e10, f8705b);
            return null;
        }
    }

    @Override // dh.f
    public jb.d m() {
        ITranTelephony iTranTelephony = this.f8706a;
        if (iTranTelephony == null) {
            return null;
        }
        try {
            TranServiceState serviceState = iTranTelephony.getServiceState();
            if (serviceState != null) {
                return new jb.d(serviceState.getState(), serviceState.getOperatorNumeric(), serviceState.getDataRoamingType());
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
        return null;
    }

    @Override // dh.f
    public int n() {
        int iIntValue = ((Integer) new zb.f().a(new zb.f.a() { // from class: je.o
            @Override // zb.f.a
            public final Object run() {
                return this.f8697a.E();
            }
        }, "telephony")).intValue();
        dc.e.f(f8705b, "getRadioPowerState state:" + iIntValue);
        return iIntValue;
    }

    @Override // dh.f
    public String o(int i10) {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.getSimOperatorNumeric(i10);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getSimOperatorNumeric fail:", e10, f8705b);
            return null;
        }
    }

    @Override // dh.f
    public boolean p() {
        ITranTelephony iTranTelephony = this.f8706a;
        if (iTranTelephony == null) {
            return false;
        }
        try {
            return iTranTelephony.getDataEnabled();
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // dh.f
    public void q(int i10, boolean z10) {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                iTranTelephony.setDataEnabledForSubId(i10, z10);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // dh.f
    public boolean r(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: je.r
            @Override // zb.f.b
            public final Object run() {
                return this.f8701a.J(i10);
            }
        }, "telephony")).booleanValue();
        dc.e.f(f8705b, "isNetworkRoaming subId: " + i10);
        return zBooleanValue;
    }

    @Override // dh.f
    public int s() {
        int iIntValue = ((Integer) new zb.f().a(new zb.f.a() { // from class: je.n
            @Override // zb.f.a
            public final Object run() {
                return this.f8696a.G();
            }
        }, "telephony")).intValue();
        dc.e.f(f8705b, "getSimState state:" + iIntValue);
        return iIntValue;
    }

    @Override // dh.f
    public String t() {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            return iTranTelephony != null ? iTranTelephony.getSubscriberId() : "";
        } catch (RemoteException e10) {
            j7.b.a("getSubscriberId fail:", e10, f8705b);
            return "";
        }
    }

    @Override // dh.f
    public String u() {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            if (iTranTelephony != null) {
                return iTranTelephony.getSimOperatorName();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getSimOperatorName fail:", e10, f8705b);
            return null;
        }
    }

    @Override // dh.f
    public String v() {
        try {
            ITranTelephony iTranTelephony = this.f8706a;
            return iTranTelephony != null ? iTranTelephony.getImei() : "";
        } catch (RemoteException e10) {
            j7.b.a("getImei fail:", e10, f8705b);
            return "";
        }
    }
}
