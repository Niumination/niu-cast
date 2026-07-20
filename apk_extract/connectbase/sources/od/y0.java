package od;

import android.media.AudioAttributes;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.media.ITranAudioDynamicChangeListener;
import com.transsion.hubsdk.media.ITranAudioManager;
import com.transsion.hubsdk.media.ITranAudioModeChangeListener;
import com.transsion.hubsdk.media.ITranAudioVPEventListener;
import com.transsion.hubsdk.media.ITranVolumeGroupCallback;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class y0 implements ig.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12258f = "y0";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f12260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f12261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f12262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<oa.a.d, ITranVolumeGroupCallback> f12263e = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAudioManager f12259a = ITranAudioManager.Stub.asInterface(TranServiceManager.getServiceIBinder("audio_manager"));

    public class a extends ITranAudioDynamicChangeListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public oa.a.InterfaceC0309a f12264a;

        public a(oa.a.InterfaceC0309a interfaceC0309a) {
            this.f12264a = interfaceC0309a;
        }

        public void a() {
            this.f12264a.c();
        }

        public boolean b() {
            return this.f12264a.a();
        }

        public void c(String[] strArr, String str, String str2, boolean z10, String str3) throws RemoteException {
            this.f12264a.b(strArr, str, str2, z10, str3);
        }
    }

    public class b extends ITranAudioModeChangeListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public oa.a.b f12266a;

        public b(oa.a.b bVar) {
            this.f12266a = bVar;
        }

        public void a(int i10, String str) throws RemoteException {
            this.f12266a.a(i10, str);
        }
    }

    public class c extends ITranAudioVPEventListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public oa.a.c f12268a;

        public c(oa.a.c cVar) {
            this.f12268a = cVar;
        }

        public void a(int i10) throws RemoteException {
            this.f12268a.a(i10);
        }
    }

    public class d extends ITranVolumeGroupCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public oa.a.d f12270a;

        public d(oa.a.d dVar) {
            this.f12270a = dVar;
        }

        public void a(int i10, int i11) {
            this.f12270a.a(i10, i11);
        }
    }

    @Override // ig.a
    public void A(String str, oa.a.b bVar) {
        try {
            b bVar2 = new b(bVar);
            this.f12260b = bVar2;
            this.f12259a.registerAudioModeChangeListeners(str, bVar2);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public final /* synthetic */ Object A1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.getSpeakerVirtualizerEnabled());
        }
        return null;
    }

    @Override // ig.a
    public int B(final int i10) {
        return ((Integer) new zb.f().c(new zb.f.b() { // from class: od.u
            @Override // zb.f.b
            public final Object run() {
                return this.f12243a.D1(i10);
            }
        }, "audio_manager")).intValue();
    }

    public final /* synthetic */ Object B1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Integer.valueOf(iTranAudioManager.getStereoWideningAmount(i10));
        }
        return null;
    }

    @Override // ig.a
    public void C(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: od.d0
            @Override // zb.f.b
            public final Object run() {
                return this.f12187a.R1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setIeqPreset preset: " + i10);
    }

    public final /* synthetic */ Object C1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.getTuningDevicesList(i10);
        }
        return null;
    }

    @Override // ig.a
    public void D(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: od.n
            @Override // zb.f.b
            public final Object run() {
                return this.f12222a.T1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setProfile profile: " + i10);
    }

    public final /* synthetic */ Object D1(int i10) throws RemoteException {
        try {
            ITranAudioManager iTranAudioManager = this.f12259a;
            if (iTranAudioManager != null) {
                return Integer.valueOf(iTranAudioManager.getVolumeGroupIdForLegacyStreamType(i10));
            }
        } catch (RemoteException e10) {
            j7.b.a("getVolumeGroupIdForLegacyStreamType fail:", e10, f12258f);
        }
        return -1;
    }

    @Override // ig.a
    public boolean E() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.t0
            @Override // zb.f.b
            public final Object run() {
                return this.f12242a.G1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "isDolbySupport");
        return zBooleanValue;
    }

    public final /* synthetic */ Object E1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Integer.valueOf(iTranAudioManager.getVolumeLevelerAmount());
        }
        return null;
    }

    @Override // ig.a
    public boolean F() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.d
            @Override // zb.f.b
            public final Object run() {
                return this.f12186a.y1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "getReverbReductionEnabled");
        return zBooleanValue;
    }

    public final /* synthetic */ Object F1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.hasControl());
        }
        return null;
    }

    @Override // ig.a
    public boolean G() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.s0
            @Override // zb.f.b
            public final Object run() {
                return this.f12239a.A1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "getSpeakerVirtualizerEnabled");
        return zBooleanValue;
    }

    public final /* synthetic */ Object G1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.isDolbySupport());
        }
        return null;
    }

    @Override // ig.a
    public int H() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: od.p0
            @Override // zb.f.b
            public final Object run() {
                return this.f12232a.x1();
            }
        }, "audio_manager")).intValue();
        dc.e.a(f12258f, "getReverbReductionAmount");
        return iIntValue;
    }

    public final /* synthetic */ Object H1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.isGeqEnabled(i10));
        }
        return null;
    }

    @Override // ig.a
    public int I() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: od.s
            @Override // zb.f.b
            public final Object run() {
                return this.f12238a.E1();
            }
        }, "audio_manager")).intValue();
        dc.e.a(f12258f, "getVolumeLevelerAmount");
        return iIntValue;
    }

    public final /* synthetic */ Object I1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.isMonoSpeaker());
        }
        return null;
    }

    @Override // ig.a
    public void J(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: od.v
            @Override // zb.f.b
            public final Object run() {
                return this.f12246a.N1(z10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setDialogEnhancerEnabled");
    }

    public final /* synthetic */ Object J1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.isStreamAffectedByRingerMode(i10));
        }
        return null;
    }

    @Override // ig.a
    public void K(final int i10, final int i11) {
        new zb.f().c(new zb.f.b() { // from class: od.w
            @Override // zb.f.b
            public final Object run() {
                return this.f12249a.S1(i10, i11);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setIeqPreset preset: " + i10 + ",port: " + i11);
    }

    public final /* synthetic */ Object K1(oa.a.d dVar) throws RemoteException {
        if (this.f12259a == null) {
            return null;
        }
        ITranVolumeGroupCallback dVar2 = new d(dVar);
        this.f12263e.put(dVar, dVar2);
        this.f12259a.registerVolumeGroupCallback(dVar2);
        return null;
    }

    @Override // ig.a
    public void L() {
        try {
            this.f12259a.unregisterAudioVPEventListeners();
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public final /* synthetic */ Object L1(boolean z10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setBassEnhancerEnabled(z10);
        return null;
    }

    @Override // ig.a
    public void M(oa.a.InterfaceC0309a interfaceC0309a) {
        try {
            a aVar = new a(interfaceC0309a);
            this.f12261c = aVar;
            this.f12259a.registerAudioDynamicChangeListeners(aVar);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public final /* synthetic */ Object M1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setDialogEnhancerAmount(i10);
        return null;
    }

    @Override // ig.a
    public void N() {
        try {
            this.f12259a.unregisterAudioDynamicChangeListeners();
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public final /* synthetic */ Object N1(boolean z10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setDialogEnhancerEnabled(z10);
        return null;
    }

    @Override // ig.a
    public int O() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: od.c0
            @Override // zb.f.b
            public final Object run() {
                return this.f12183a.q1();
            }
        }, "audio_manager")).intValue();
        dc.e.a(f12258f, "getIeqPreset");
        return iIntValue;
    }

    public final /* synthetic */ Object O1(boolean z10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setDsOn(z10);
        return null;
    }

    @Override // ig.a
    public void P(final int i10, final int i11) {
        new zb.f().c(new zb.f.b() { // from class: od.n0
            @Override // zb.f.b
            public final Object run() {
                return this.f12224a.X1(i10, i11);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setStereoWideningAmount amount: " + i10 + ",port: " + i11);
    }

    public final /* synthetic */ Object P1(int[] iArr) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setGeqBandGains(iArr);
        return null;
    }

    @Override // ig.a
    public String Q() {
        String str = (String) new zb.f().c(new zb.f.b() { // from class: od.b
            @Override // zb.f.b
            public final Object run() {
                return this.f12176a.k1();
            }
        }, "audio_manager");
        dc.e.a(f12258f, "getCurrentAudioFocusPackageName packageName:" + str);
        return str;
    }

    public final /* synthetic */ Object Q1(boolean z10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setHeadphoneVirtualizerEnabled(z10);
        return null;
    }

    @Override // ig.a
    public boolean R(final String str) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.l
            @Override // zb.f.b
            public final Object run() {
                return this.f12215a.d1(str);
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "CurrentEnabledVPChange");
        return zBooleanValue;
    }

    public final /* synthetic */ Object R1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setIeqPreset(i10);
        return null;
    }

    @Override // ig.a
    public boolean S() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.e
            @Override // zb.f.b
            public final Object run() {
                return this.f12189a.I1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "isMonoSpeaker");
        return zBooleanValue;
    }

    public final /* synthetic */ Object S1(int i10, int i11) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setIeqPresetExt(i10, i11);
        return null;
    }

    @Override // ig.a
    public void T(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: od.o0
            @Override // zb.f.b
            public final Object run() {
                return this.f12229a.O1(z10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setDsOn");
    }

    public final /* synthetic */ Object T1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setProfile(i10);
        return null;
    }

    @Override // ig.a
    public int U() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: od.m
            @Override // zb.f.b
            public final Object run() {
                return this.f12219a.t1();
            }
        }, "audio_manager")).intValue();
        dc.e.a(f12258f, "getNumOfIeqPresets");
        return iIntValue;
    }

    public final /* synthetic */ Object U1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setReverbReductionAmount(i10);
        return null;
    }

    @Override // ig.a
    public String V(final int i10) {
        String str = (String) new zb.f().c(new zb.f.b() { // from class: od.g0
            @Override // zb.f.b
            public final Object run() {
                return this.f12197a.s1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "getIeqPresetName");
        return str;
    }

    public final /* synthetic */ Object V1(boolean z10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setReverbReductionEnabled(z10);
        return null;
    }

    @Override // ig.a
    public int W() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: od.q
            @Override // zb.f.b
            public final Object run() {
                return this.f12233a.v1();
            }
        }, "audio_manager")).intValue();
        dc.e.a(f12258f, "getProfile");
        return iIntValue;
    }

    public final /* synthetic */ Object W1(boolean z10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setSpeakerVirtualizerEnabled(z10);
        return null;
    }

    @Override // ig.a
    public boolean X() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.b0
            @Override // zb.f.b
            public final Object run() {
                return this.f12177a.p1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "getHeadphoneVirtualizerEnabled");
        return zBooleanValue;
    }

    public final /* synthetic */ Object X1(int i10, int i11) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setStereoWideningAmount(i10, i11);
        return null;
    }

    @Override // ig.a
    public int Y() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: od.r
            @Override // zb.f.b
            public final Object run() {
                return this.f12235a.u1();
            }
        }, "audio_manager")).intValue();
        dc.e.a(f12258f, "getNumOfProfiles");
        return iIntValue;
    }

    public final /* synthetic */ Object Y1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setVolumeLevelerAmount(i10);
        return null;
    }

    @Override // ig.a
    public void Z(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: od.t
            @Override // zb.f.b
            public final Object run() {
                return this.f12240a.W1(z10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setSpeakerVirtualizerEnabled");
    }

    public final /* synthetic */ Object Z1(boolean z10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager == null) {
            return null;
        }
        iTranAudioManager.setVolumeLevelerEnabled(z10);
        return null;
    }

    @Override // ig.a
    public void a(final oa.a.d dVar) {
        new zb.f().c(new zb.f.b() { // from class: od.i
            @Override // zb.f.b
            public final Object run() {
                return this.f12203a.a2(dVar);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "unregisterVolumeGroupCallback");
    }

    @Override // ig.a
    public boolean a0(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.f0
            @Override // zb.f.b
            public final Object run() {
                return this.f12193a.H1(i10);
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "isGeqEnabled");
        return zBooleanValue;
    }

    public final /* synthetic */ Object a2(oa.a.d dVar) throws RemoteException {
        Map<oa.a.d, ITranVolumeGroupCallback> map;
        ITranVolumeGroupCallback iTranVolumeGroupCallback;
        if (this.f12259a == null || (map = this.f12263e) == null || (iTranVolumeGroupCallback = map.get(dVar)) == null) {
            return null;
        }
        this.f12259a.unregisterVolumeGroupCallback(iTranVolumeGroupCallback);
        this.f12263e.remove(dVar);
        return null;
    }

    @Override // ig.a
    public String b(final int i10) {
        String str = (String) new zb.f().c(new zb.f.b() { // from class: od.a0
            @Override // zb.f.b
            public final Object run() {
                return this.f12173a.z1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "getSelectedTuningDevice");
        return str;
    }

    @Override // ig.a
    public void b0(String str) {
        try {
            this.f12259a.unregisterAudioModeChangeListeners(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @VisibleForTesting
    public void b2(ITranAudioManager iTranAudioManager) {
        this.f12259a = iTranAudioManager;
    }

    @Override // ig.a
    public String c(final String str) {
        String str2 = (String) new zb.f().c(new zb.f.b() { // from class: od.o
            @Override // zb.f.b
            public final Object run() {
                return this.f12227a.e1(str);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "VPEnroll");
        return str2;
    }

    @Override // ig.a
    public String[] c0(final int i10) {
        String[] strArr = (String[]) new zb.f().c(new zb.f.b() { // from class: od.y
            @Override // zb.f.b
            public final Object run() {
                return this.f12256a.C1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "getTuningDevicesList");
        return strArr;
    }

    @Override // ig.a
    public boolean d() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.w0
            @Override // zb.f.b
            public final Object run() {
                return this.f12252a.j1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "getBassEnhancerEnabled");
        return zBooleanValue;
    }

    @Override // ig.a
    public boolean d0() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.e0
            @Override // zb.f.b
            public final Object run() {
                return this.f12190a.F1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "hasControl");
        return zBooleanValue;
    }

    public final /* synthetic */ Object d1(String str) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.CurrentEnabledVPChange(str));
        }
        return null;
    }

    @Override // ig.a
    public void e(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: od.j
            @Override // zb.f.b
            public final Object run() {
                return this.f12207a.U1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setReverbReductionAmount amount: " + i10);
    }

    @Override // ig.a
    public String e0() {
        String str = (String) new zb.f().c(new zb.f.b() { // from class: od.u0
            @Override // zb.f.b
            public final Object run() {
                return this.f12245a.l1();
            }
        }, "audio_manager");
        dc.e.a(f12258f, "getCurrentEnabledVP");
        return str;
    }

    public final /* synthetic */ Object e1(String str) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.VPEnroll(str);
        }
        return null;
    }

    @Override // ig.a
    public boolean f(final String str, final String str2) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.c
            @Override // zb.f.b
            public final Object run() {
                return this.f12180a.g1(str, str2);
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "VPNameChange");
        return zBooleanValue;
    }

    public final /* synthetic */ Object f1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.VPEnrollInfoQuery();
        }
        return null;
    }

    @Override // ig.a
    public void g(final int[] iArr) {
        new zb.f().c(new zb.f.b() { // from class: od.k
            @Override // zb.f.b
            public final Object run() {
                return this.f12211a.P1(iArr);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setGeqBandGains");
    }

    public final /* synthetic */ Object g1(String str, String str2) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.VPNameChange(str, str2));
        }
        return null;
    }

    @Override // ig.a
    public void h(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: od.h0
            @Override // zb.f.b
            public final Object run() {
                return this.f12201a.Z1(z10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setVolumeLevelerEnabled");
    }

    public final /* synthetic */ Object h1(String str) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.VPTemplateDelete(str));
        }
        return null;
    }

    @Override // ig.a
    public void i(final oa.a.d dVar) {
        new zb.f().c(new zb.f.b() { // from class: od.f
            @Override // zb.f.b
            public final Object run() {
                return this.f12191a.K1(dVar);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "registerVolumeGroupCallback");
    }

    public final /* synthetic */ Object i1(int i10) throws RemoteException {
        try {
            ITranAudioManager iTranAudioManager = this.f12259a;
            if (iTranAudioManager != null) {
                return iTranAudioManager.getAudioAttributesForLegacyStreamType(i10);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getAudioAttributesForLegacyStreamType fail:", e10, f12258f);
            return null;
        }
    }

    @Override // ig.a
    public void j(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: od.m0
            @Override // zb.f.b
            public final Object run() {
                return this.f12220a.Q1(z10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setHeadphoneVirtualizerEnabled");
    }

    public final /* synthetic */ Object j1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.getBassEnhancerEnabled());
        }
        return null;
    }

    @Override // ig.a
    public boolean k(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.i0
            @Override // zb.f.b
            public final Object run() {
                return this.f12205a.J1(i10);
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "isStreamAffectedByRingerMode");
        return zBooleanValue;
    }

    public final /* synthetic */ Object k1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.getCurrentAudioFocusPackageName();
        }
        return null;
    }

    @Override // ig.a
    public boolean l() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.x
            @Override // zb.f.b
            public final Object run() {
                return this.f12253a.n1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "getDsOn");
        return zBooleanValue;
    }

    public final /* synthetic */ Object l1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.getCurrentEnabledVP();
        }
        return null;
    }

    @Override // ig.a
    public boolean m(final String str) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.g
            @Override // zb.f.b
            public final Object run() {
                return this.f12195a.h1(str);
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "VPTemplateDelete");
        return zBooleanValue;
    }

    public final /* synthetic */ Object m1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.getDialogEnhancerEnabled());
        }
        return null;
    }

    @Override // ig.a
    public int[] n() {
        int[] iArr = (int[]) new zb.f().c(new zb.f.b() { // from class: od.q0
            @Override // zb.f.b
            public final Object run() {
                return this.f12234a.o1();
            }
        }, "audio_manager");
        dc.e.a(f12258f, "getGeqBandGains");
        return iArr;
    }

    public final /* synthetic */ Object n1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.getDsOn());
        }
        return null;
    }

    @Override // ig.a
    public void o(oa.a.c cVar) {
        try {
            c cVar2 = new c(cVar);
            this.f12262d = cVar2;
            this.f12259a.registerAudioVPEventListeners(cVar2);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public final /* synthetic */ Object o1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.getGeqBandGains();
        }
        return null;
    }

    @Override // ig.a
    public boolean p() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: od.p
            @Override // zb.f.b
            public final Object run() {
                return this.f12231a.m1();
            }
        }, "audio_manager")).booleanValue();
        dc.e.a(f12258f, "getDialogEnhancerEnabled");
        return zBooleanValue;
    }

    public final /* synthetic */ Object p1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.getHeadphoneVirtualizerEnabled());
        }
        return null;
    }

    @Override // ig.a
    public void q(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: od.k0
            @Override // zb.f.b
            public final Object run() {
                return this.f12213a.Y1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setVolumeLevelerAmount");
    }

    public final /* synthetic */ Object q1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Integer.valueOf(iTranAudioManager.getIeqPreset());
        }
        return null;
    }

    @Override // ig.a
    public String r(final int i10) {
        String str = (String) new zb.f().c(new zb.f.b() { // from class: od.z
            @Override // zb.f.b
            public final Object run() {
                return this.f12272a.w1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "getProfileName");
        return str;
    }

    public final /* synthetic */ Object r1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Integer.valueOf(iTranAudioManager.getIeqPresetExt(i10));
        }
        return null;
    }

    @Override // ig.a
    public List<String> s() {
        List<String> list = (List) new zb.f().c(new zb.f.b() { // from class: od.v0
            @Override // zb.f.b
            public final Object run() {
                return this.f12248a.f1();
            }
        }, "audio_manager");
        dc.e.a(f12258f, "VPEnrollInfoQuery");
        return list;
    }

    public final /* synthetic */ Object s1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.getIeqPresetName(i10);
        }
        return null;
    }

    @Override // ig.a
    public void t(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: od.a
            @Override // zb.f.b
            public final Object run() {
                return this.f12171a.M1(i10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setDialogEnhancerAmount");
    }

    public final /* synthetic */ Object t1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Integer.valueOf(iTranAudioManager.getNumOfIeqPresets());
        }
        return null;
    }

    @Override // ig.a
    public void u(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: od.l0
            @Override // zb.f.b
            public final Object run() {
                return this.f12217a.L1(z10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setBassEnhancerEnabled");
    }

    public final /* synthetic */ Object u1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Integer.valueOf(iTranAudioManager.getNumOfProfiles());
        }
        return null;
    }

    @Override // ig.a
    public int v(final int i10) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: od.x0
            @Override // zb.f.b
            public final Object run() {
                return this.f12254a.B1(i10);
            }
        }, "audio_manager")).intValue();
        dc.e.a(f12258f, "getStereoWideningAmount");
        return iIntValue;
    }

    public final /* synthetic */ Object v1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Integer.valueOf(iTranAudioManager.getProfile());
        }
        return null;
    }

    @Override // ig.a
    public int w(final int i10) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: od.r0
            @Override // zb.f.b
            public final Object run() {
                return this.f12236a.r1(i10);
            }
        }, "audio_manager")).intValue();
        dc.e.a(f12258f, "getIeqPreset port: " + i10);
        return iIntValue;
    }

    public final /* synthetic */ Object w1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.getProfileName(i10);
        }
        return null;
    }

    @Override // ig.a
    public void x(String str, int i10) {
        try {
            this.f12259a.setRingerModeInternal(str, i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public final /* synthetic */ Object x1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Integer.valueOf(iTranAudioManager.getReverbReductionAmount());
        }
        return null;
    }

    @Override // ig.a
    public void y(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: od.h
            @Override // zb.f.b
            public final Object run() {
                return this.f12199a.V1(z10);
            }
        }, "audio_manager");
        dc.e.a(f12258f, "setReverbReductionEnabled enable: " + z10);
    }

    public final /* synthetic */ Object y1() throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return Boolean.valueOf(iTranAudioManager.getReverbReductionEnabled());
        }
        return null;
    }

    @Override // ig.a
    public AudioAttributes z(final int i10) {
        return (AudioAttributes) new zb.f().c(new zb.f.b() { // from class: od.j0
            @Override // zb.f.b
            public final Object run() {
                return this.f12209a.i1(i10);
            }
        }, "audio_manager");
    }

    public final /* synthetic */ Object z1(int i10) throws RemoteException {
        ITranAudioManager iTranAudioManager = this.f12259a;
        if (iTranAudioManager != null) {
            return iTranAudioManager.getSelectedTuningDevice(i10);
        }
        return null;
    }
}
