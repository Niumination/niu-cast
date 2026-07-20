package x7;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.util.ArrayMap;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ig.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioManager f20102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x7.b f20103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayMap<oa.a.d, b> f20104d = new ArrayMap<>();

    /* JADX INFO: renamed from: x7.a$a, reason: collision with other inner class name */
    public class C0498a implements x7.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public oa.a.b f20105a;

        public C0498a(oa.a.b bVar) {
            this.f20105a = bVar;
        }

        @Override // x7.b.c
        public void a(int i10, String str) {
            this.f20105a.a(i10, str);
        }
    }

    public class b implements x7.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public oa.a.d f20107a;

        public b(oa.a.d dVar) {
            this.f20107a = dVar;
        }

        @Override // x7.b.d
        public void a(int i10, int i11) {
            this.f20107a.a(i10, i11);
        }
    }

    public a() {
        if (this.f20102b == null) {
            Context contextA = bc.a.a();
            this.f20101a = contextA;
            this.f20102b = (AudioManager) contextA.getSystemService("audio");
        }
    }

    @Override // ig.a
    public void A(String str, oa.a.b bVar) {
        f0().a(str, new C0498a(bVar));
    }

    @Override // ig.a
    public int B(int i10) {
        List list;
        Method methodG = cc.a.g(this.f20102b.getClass(), "getAudioProductStrategies", new Class[0]);
        Method methodG2 = cc.a.g(this.f20102b.getClass(), "getVolumeGroupIdForLegacyStreamType", Integer.TYPE);
        if (methodG != null && methodG2 != null && (list = (List) cc.a.j(methodG, this.f20102b, new Object[0])) != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object objJ = cc.a.j(methodG2, it.next(), Integer.valueOf(i10));
                int iIntValue = objJ == null ? -1 : ((Integer) objJ).intValue();
                if (iIntValue != -1) {
                    return iIntValue;
                }
            }
        }
        return -1;
    }

    @Override // ig.a
    public void C(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setIeqPreset", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Integer.valueOf(i10));
        }
    }

    @Override // ig.a
    public void D(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setProfile", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Integer.valueOf(i10));
        }
    }

    @Override // ig.a
    public boolean E() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "isDolbySupport", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f20102b, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // ig.a
    public boolean F() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getReverbReductionEnabled", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f20102b, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // ig.a
    public boolean G() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getSpeakerVirtualizerEnabled", new Class[0]);
        if (methodG != null) {
            return Boolean.TRUE.equals(cc.a.j(methodG, this.f20102b, new Object[0]));
        }
        return false;
    }

    @Override // ig.a
    public int H() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getReverbReductionAmount", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f20102b, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // ig.a
    public int I() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getVolumeLevelerAmount", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f20102b, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // ig.a
    public void J(boolean z10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setDialogEnhancerEnabled", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Boolean.valueOf(z10));
        }
    }

    @Override // ig.a
    public void K(int i10, int i11) {
        Class<?> cls = this.f20102b.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "setIeqPreset", cls2, cls2);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    @Override // ig.a
    public void L() throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public void M(oa.a.InterfaceC0309a interfaceC0309a) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public void N() throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public int O() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getIeqPreset", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f20102b, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // ig.a
    public void P(int i10, int i11) {
        Class<?> cls = this.f20102b.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "setStereoWideningAmount", cls2, cls2);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    @Override // ig.a
    public String Q() {
        Object objJ = cc.a.j(cc.a.g(this.f20102b.getClass(), "getCurrentAudioFocusPackageName", new Class[0]), this.f20102b, new Object[0]);
        if (objJ instanceof String) {
            return (String) objJ;
        }
        return null;
    }

    @Override // ig.a
    public boolean R(String str) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public boolean S() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "isMonoSpeaker", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f20102b, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // ig.a
    public void T(boolean z10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setDsOn", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Boolean.valueOf(z10));
        }
    }

    @Override // ig.a
    public int U() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getNumOfIeqPresets", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f20102b, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // ig.a
    public String V(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getIeqPresetName", Integer.TYPE);
        if (methodG != null) {
            return (String) cc.a.j(methodG, this.f20102b, Integer.valueOf(i10));
        }
        return null;
    }

    @Override // ig.a
    public int W() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getProfile", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f20102b, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // ig.a
    public boolean X() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getHeadphoneVirtualizerEnabled", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f20102b, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // ig.a
    public int Y() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getNumOfProfiles", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f20102b, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // ig.a
    public void Z(boolean z10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setSpeakerVirtualizerEnabled", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Boolean.valueOf(z10));
        }
    }

    @Override // ig.a
    public void a(oa.a.d dVar) {
        f0().d(this.f20104d.get(dVar));
    }

    @Override // ig.a
    public boolean a0(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "isGeqEnabled", Integer.TYPE);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f20102b, Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // ig.a
    public String b(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getSelectedTuningDevice", Integer.TYPE);
        if (methodG != null) {
            return (String) cc.a.j(methodG, this.f20102b, Integer.valueOf(i10));
        }
        return null;
    }

    @Override // ig.a
    public void b0(String str) {
        f0().c(str);
    }

    @Override // ig.a
    public String c(String str) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public String[] c0(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getTuningDevicesList", Integer.TYPE);
        return methodG != null ? (String[]) cc.a.j(methodG, this.f20102b, Integer.valueOf(i10)) : new String[0];
    }

    @Override // ig.a
    public boolean d() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getBassEnhancerEnabled", new Class[0]);
        if (methodG != null) {
            return Boolean.TRUE.equals(cc.a.j(methodG, this.f20102b, new Object[0]));
        }
        return false;
    }

    @Override // ig.a
    public boolean d0() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "hasControl", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f20102b, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // ig.a
    public void e(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setReverbReductionAmount", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Integer.valueOf(i10));
        }
    }

    @Override // ig.a
    public String e0() throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public boolean f(String str, String str2) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    public final x7.b f0() {
        if (this.f20103c == null) {
            this.f20103c = new x7.b(this.f20101a);
        }
        return this.f20103c;
    }

    @Override // ig.a
    public void g(int[] iArr) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setGeqBandGains", int[].class);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, iArr);
        }
    }

    @Override // ig.a
    public void h(boolean z10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setVolumeLevelerEnabled", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Boolean.valueOf(z10));
        }
    }

    @Override // ig.a
    public void i(oa.a.d dVar) {
        b bVar = new b(dVar);
        this.f20104d.put(dVar, bVar);
        f0().b(bVar);
    }

    @Override // ig.a
    public void j(boolean z10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setHeadphoneVirtualizerEnabled", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Boolean.valueOf(z10));
        }
    }

    @Override // ig.a
    public boolean k(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "isStreamAffectedByRingerMode", Integer.TYPE);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f20102b, Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // ig.a
    public boolean l() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getDsOn", new Class[0]);
        if (methodG != null) {
            return Boolean.TRUE.equals(cc.a.j(methodG, this.f20102b, new Object[0]));
        }
        return false;
    }

    @Override // ig.a
    public boolean m(String str) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public int[] n() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getGeqBandGains", new Class[0]);
        if (methodG != null) {
            return (int[]) cc.a.j(methodG, this.f20102b, new Object[0]);
        }
        return null;
    }

    @Override // ig.a
    public void o(oa.a.c cVar) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public boolean p() {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getDialogEnhancerEnabled", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f20102b, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // ig.a
    public void q(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setVolumeLevelerAmount", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Integer.valueOf(i10));
        }
    }

    @Override // ig.a
    public String r(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getProfileName", Integer.TYPE);
        if (methodG != null) {
            return (String) cc.a.j(methodG, this.f20102b, Integer.valueOf(i10));
        }
        return null;
    }

    @Override // ig.a
    public List<String> s() throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // ig.a
    public void t(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setDialogEnhancerAmount", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Integer.valueOf(i10));
        }
    }

    @Override // ig.a
    public void u(boolean z10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setBassEnhancerEnabled", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Boolean.valueOf(z10));
        }
    }

    @Override // ig.a
    public int v(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getStereoWideningAmount", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f20102b, Integer.valueOf(i10))).intValue();
        }
        return 0;
    }

    @Override // ig.a
    public int w(int i10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "getIeqPreset", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f20102b, Integer.valueOf(i10))).intValue();
        }
        return 0;
    }

    @Override // ig.a
    public void x(String str, int i10) {
        cc.a.j(cc.a.g(this.f20102b.getClass(), "setRingerModeInternal", Integer.TYPE), this.f20102b, Integer.valueOf(i10));
    }

    @Override // ig.a
    public void y(boolean z10) {
        Method methodG = cc.a.g(this.f20102b.getClass(), "setReverbReductionEnabled", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f20102b, Boolean.valueOf(z10));
        }
    }

    @Override // ig.a
    public AudioAttributes z(int i10) {
        List list;
        Method methodG = cc.a.g(this.f20102b.getClass(), "getAudioProductStrategies", new Class[0]);
        Method methodG2 = cc.a.g(this.f20102b.getClass(), "getAudioAttributesForLegacyStreamType", Integer.TYPE);
        if (methodG != null && methodG2 != null && (list = (List) cc.a.j(methodG, this.f20102b, new Object[0])) != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AudioAttributes audioAttributes = (AudioAttributes) cc.a.j(methodG2, it.next(), Integer.valueOf(i10));
                if (audioAttributes != null) {
                    return audioAttributes;
                }
            }
        }
        return null;
    }
}
