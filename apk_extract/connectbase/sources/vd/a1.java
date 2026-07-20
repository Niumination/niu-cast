package vd;

import android.os.RemoteException;
import android.os.UserHandle;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.api.os.TranUserInfo;
import com.transsion.hubsdk.os.ITranUserManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a1 implements pg.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16904b = "a1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranUserManager f16905a = ITranUserManager.Stub.asInterface(TranServiceManager.getServiceIBinder("user_manager"));

    public final /* synthetic */ Object E(int i10, boolean z10) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        return iTranUserManager != null ? Boolean.valueOf(iTranUserManager.canAddMoreManagedProfiles(i10, z10)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object F(String str, int i10) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        return iTranUserManager != null ? Boolean.valueOf(iTranUserManager.canAddMoreProfilesToUser(str, i10)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object G(String str, String str2, int i10, int i11, String[] strArr) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager != null) {
            return iTranUserManager.createProfileForUserEvenWhenDisallowed(str, str2, i10, i11, strArr);
        }
        return null;
    }

    public final /* synthetic */ Object H() throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager != null) {
            return iTranUserManager.getAllProfiles();
        }
        return null;
    }

    public final /* synthetic */ Object I(int i10) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager != null) {
            return iTranUserManager.getProfiles(i10);
        }
        return null;
    }

    public final /* synthetic */ Object J(int i10) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager != null) {
            return iTranUserManager.getUserInfo(i10);
        }
        return null;
    }

    public final /* synthetic */ Object K(boolean z10) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager != null) {
            return iTranUserManager.getUsersExt(z10);
        }
        return null;
    }

    public final /* synthetic */ Object L() throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager != null) {
            return iTranUserManager.getUsers();
        }
        return null;
    }

    public final /* synthetic */ Object M() throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager != null) {
            return Boolean.valueOf(iTranUserManager.isAdminUser());
        }
        return null;
    }

    public final /* synthetic */ Object N(int i10) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        return iTranUserManager != null ? Boolean.valueOf(iTranUserManager.isManagedProfile(i10)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object O(int i10) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        return iTranUserManager != null ? Boolean.valueOf(iTranUserManager.isUserAdmin(i10)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object P(int i10) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        return iTranUserManager != null ? Boolean.valueOf(iTranUserManager.removeUserEvenWhenDisallowed(i10)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object Q(String str, boolean z10, UserHandle userHandle) throws RemoteException {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager == null) {
            return null;
        }
        iTranUserManager.setUserRestriction(str, z10, userHandle);
        return null;
    }

    @VisibleForTesting
    public void R(ITranUserManager iTranUserManager) {
        this.f16905a = iTranUserManager;
    }

    @Override // pg.q
    public TranUserInfo a(final int i10) {
        com.transsion.hubsdk.content.pm.TranUserInfo tranUserInfo = (com.transsion.hubsdk.content.pm.TranUserInfo) new zb.f().c(new zb.f.b() { // from class: vd.y0
            @Override // zb.f.b
            public final Object run() {
                return this.f17013a.J(i10);
            }
        }, "user_manager");
        dc.e.f(f16904b, "getUserInfo tranUserInfo:" + tranUserInfo);
        if (tranUserInfo == null) {
            return null;
        }
        TranUserInfo tranUserInfo2 = new TranUserInfo();
        tranUserInfo2.w(tranUserInfo.getId());
        tranUserInfo2.u(tranUserInfo.getFlags());
        tranUserInfo2.y(tranUserInfo.name);
        return tranUserInfo2;
    }

    @Override // pg.q
    public TranUserInfo b(final String str, final String str2, final int i10, final int i11, final String[] strArr) {
        com.transsion.hubsdk.content.pm.TranUserInfo tranUserInfo = (com.transsion.hubsdk.content.pm.TranUserInfo) new zb.f().c(new zb.f.b() { // from class: vd.n0
            @Override // zb.f.b
            public final Object run() {
                return this.f16961a.G(str, str2, i10, i11, strArr);
            }
        }, "user_manager");
        dc.e.f(f16904b, "createProfileForUserEvenWhenDisallowed tranUserInfo:" + tranUserInfo);
        if (tranUserInfo == null) {
            return null;
        }
        TranUserInfo tranUserInfo2 = new TranUserInfo();
        tranUserInfo2.f2220a = tranUserInfo.id;
        tranUserInfo2.f2221b = tranUserInfo.flags;
        tranUserInfo2.f2223d = tranUserInfo.name;
        tranUserInfo2.f2225f = tranUserInfo.iconPath;
        tranUserInfo2.f2222c = tranUserInfo.userType;
        tranUserInfo2.f2224e = tranUserInfo.serialNumber;
        tranUserInfo2.f2226g = tranUserInfo.creationTime;
        tranUserInfo2.f2227i = tranUserInfo.partial;
        tranUserInfo2.f2228n = tranUserInfo.preCreated;
        tranUserInfo2.f2231w = tranUserInfo.lastLoggedInFingerprint;
        tranUserInfo2.f2232x = tranUserInfo.profileBadge;
        tranUserInfo2.f2233y = tranUserInfo.restrictedProfileParentId;
        tranUserInfo2.t(tranUserInfo.isDualProfile());
        return tranUserInfo2;
    }

    @Override // pg.q
    public int[] c(int i10) {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager == null) {
            return null;
        }
        try {
            return iTranUserManager.getProfileIdsWithDisabled(i10);
        } catch (RemoteException e10) {
            j7.b.a("getCredentialOwnerProfile:", e10, f16904b);
            return null;
        }
    }

    @Override // pg.q
    public boolean d(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.u0
            @Override // zb.f.b
            public final Object run() {
                return this.f16993a.P(i10);
            }
        }, "user_manager")).booleanValue();
        ic.n0.a("removeUserEvenWhenDisallowed result:", zBooleanValue, f16904b);
        return zBooleanValue;
    }

    @Override // pg.q
    public UserHandle e(String str, String str2, String[] strArr) {
        try {
            ITranUserManager iTranUserManager = this.f16905a;
            if (iTranUserManager != null) {
                return iTranUserManager.createProfile(str, str2, strArr);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("createProfile fail: ", e10, f16904b);
            return null;
        }
    }

    @Override // pg.q
    public boolean f(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.t0
            @Override // zb.f.b
            public final Object run() {
                return this.f16989a.N(i10);
            }
        }, "user_manager")).booleanValue();
        ic.n0.a("isManagedProfile result: ", zBooleanValue, f16904b);
        return zBooleanValue;
    }

    @Override // pg.q
    public void g(final String str, final boolean z10, final UserHandle userHandle) {
        new zb.f().c(new zb.f.b() { // from class: vd.s0
            @Override // zb.f.b
            public final Object run() {
                return this.f16984a.Q(str, z10, userHandle);
            }
        }, "user_manager");
    }

    @Override // pg.q
    public int h(int i10) {
        ITranUserManager iTranUserManager = this.f16905a;
        if (iTranUserManager == null) {
            return 0;
        }
        try {
            return iTranUserManager.getCredentialOwnerProfile(i10);
        } catch (RemoteException e10) {
            j7.b.a("getCredentialOwnerProfile:", e10, f16904b);
            return 0;
        }
    }

    @Override // pg.q
    public boolean i(final int i10, final boolean z10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.q0
            @Override // zb.f.b
            public final Object run() {
                return this.f16974a.E(i10, z10);
            }
        }, "user_manager")).booleanValue();
        ic.n0.a("canAddMoreManagedProfiles result:", zBooleanValue, f16904b);
        return zBooleanValue;
    }

    @Override // pg.q
    public boolean j(final String str, final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.x0
            @Override // zb.f.b
            public final Object run() {
                return this.f17004a.F(str, i10);
            }
        }, "user_manager")).booleanValue();
        ic.n0.a("canAddMoreProfilesToUser result:", zBooleanValue, f16904b);
        return zBooleanValue;
    }

    @Override // pg.q
    public List<TranUserInfo> k() {
        List<com.transsion.hubsdk.content.pm.TranUserInfo> list = (List) new zb.f().c(new zb.f.b() { // from class: vd.p0
            @Override // zb.f.b
            public final Object run() {
                return this.f16972a.L();
            }
        }, "user_manager");
        dc.e.f(f16904b, "getUsers mTranUserInfo:" + list);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (com.transsion.hubsdk.content.pm.TranUserInfo tranUserInfo : list) {
            TranUserInfo tranUserInfo2 = new TranUserInfo();
            tranUserInfo2.f2223d = tranUserInfo.name;
            tranUserInfo2.f2225f = tranUserInfo.iconPath;
            tranUserInfo2.f2220a = tranUserInfo.id;
            tranUserInfo2.f2221b = tranUserInfo.flags;
            tranUserInfo2.f2222c = tranUserInfo.userType;
            tranUserInfo2.f2224e = tranUserInfo.serialNumber;
            tranUserInfo2.f2226g = tranUserInfo.creationTime;
            tranUserInfo2.f2231w = tranUserInfo.lastLoggedInFingerprint;
            tranUserInfo2.f2227i = tranUserInfo.partial;
            tranUserInfo2.f2228n = tranUserInfo.preCreated;
            tranUserInfo2.f2229p = tranUserInfo.lastLoggedInTime;
            tranUserInfo2.f2230v = tranUserInfo.convertedFromPreCreated;
            tranUserInfo2.f2234z = tranUserInfo.profileGroupId;
            tranUserInfo2.f2233y = tranUserInfo.restrictedProfileParentId;
            tranUserInfo2.I = tranUserInfo.guestToRemove;
            tranUserInfo2.f2232x = tranUserInfo.profileBadge;
            arrayList.add(tranUserInfo2);
        }
        return arrayList;
    }

    @Override // pg.q
    public List<UserHandle> l() {
        List<UserHandle> list = (List) new zb.f().c(new zb.f.b() { // from class: vd.z0
            @Override // zb.f.b
            public final Object run() {
                return this.f17015a.H();
            }
        }, "user_manager");
        dc.e.f(f16904b, "getAllProfiles");
        return list;
    }

    @Override // pg.q
    public TranUserInfo m(String str, String str2, int i10, int i11, String[] strArr) {
        com.transsion.hubsdk.content.pm.TranUserInfo tranUserInfoCreateProfileForUser;
        try {
            ITranUserManager iTranUserManager = this.f16905a;
            if (iTranUserManager == null || (tranUserInfoCreateProfileForUser = iTranUserManager.createProfileForUser(str, str2, i10, i11, strArr)) == null) {
                return null;
            }
            TranUserInfo tranUserInfo = new TranUserInfo();
            tranUserInfo.f2220a = tranUserInfoCreateProfileForUser.id;
            tranUserInfo.f2221b = tranUserInfoCreateProfileForUser.flags;
            tranUserInfo.f2223d = tranUserInfoCreateProfileForUser.name;
            tranUserInfo.f2225f = tranUserInfoCreateProfileForUser.iconPath;
            tranUserInfo.f2222c = tranUserInfoCreateProfileForUser.userType;
            tranUserInfo.f2224e = tranUserInfoCreateProfileForUser.serialNumber;
            tranUserInfo.f2226g = tranUserInfoCreateProfileForUser.creationTime;
            tranUserInfo.f2227i = tranUserInfoCreateProfileForUser.partial;
            tranUserInfo.f2228n = tranUserInfoCreateProfileForUser.preCreated;
            tranUserInfo.f2231w = tranUserInfoCreateProfileForUser.lastLoggedInFingerprint;
            tranUserInfo.f2232x = tranUserInfoCreateProfileForUser.profileBadge;
            tranUserInfo.f2233y = tranUserInfoCreateProfileForUser.restrictedProfileParentId;
            tranUserInfo.t(tranUserInfoCreateProfileForUser.isDualProfile());
            return tranUserInfo;
        } catch (RemoteException e10) {
            j7.b.a("createProfile fail: ", e10, f16904b);
        }
        return null;
    }

    @Override // pg.q
    public boolean n() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.v0
            @Override // zb.f.b
            public final Object run() {
                return this.f16996a.M();
            }
        }, "user_manager")).booleanValue();
        ic.n0.a("isAdminUser result: ", zBooleanValue, f16904b);
        return zBooleanValue;
    }

    @Override // pg.q
    public List<TranUserInfo> o(final boolean z10) {
        List<com.transsion.hubsdk.content.pm.TranUserInfo> list = (List) new zb.f().c(new zb.f.b() { // from class: vd.r0
            @Override // zb.f.b
            public final Object run() {
                return this.f16979a.K(z10);
            }
        }, "user_manager");
        dc.e.c(f16904b, "getUsers");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.transsion.hubsdk.content.pm.TranUserInfo tranUserInfo : list) {
                TranUserInfo tranUserInfo2 = new TranUserInfo();
                tranUserInfo2.f2223d = tranUserInfo.name;
                tranUserInfo2.f2225f = tranUserInfo.iconPath;
                tranUserInfo2.f2220a = tranUserInfo.id;
                tranUserInfo2.f2221b = tranUserInfo.flags;
                tranUserInfo2.f2222c = tranUserInfo.userType;
                tranUserInfo2.f2224e = tranUserInfo.serialNumber;
                tranUserInfo2.f2226g = tranUserInfo.creationTime;
                tranUserInfo2.f2231w = tranUserInfo.lastLoggedInFingerprint;
                tranUserInfo2.f2227i = tranUserInfo.partial;
                tranUserInfo2.f2228n = tranUserInfo.preCreated;
                tranUserInfo2.f2229p = tranUserInfo.lastLoggedInTime;
                tranUserInfo2.f2230v = tranUserInfo.convertedFromPreCreated;
                tranUserInfo2.f2234z = tranUserInfo.profileGroupId;
                tranUserInfo2.f2233y = tranUserInfo.restrictedProfileParentId;
                tranUserInfo2.I = tranUserInfo.guestToRemove;
                tranUserInfo2.f2232x = tranUserInfo.profileBadge;
                arrayList.add(tranUserInfo2);
            }
        }
        return arrayList;
    }

    @Override // pg.q
    public boolean p(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.w0
            @Override // zb.f.b
            public final Object run() {
                return this.f16999a.O(i10);
            }
        }, "user_manager")).booleanValue();
        ic.n0.a("isUserAdmin result:", zBooleanValue, f16904b);
        return zBooleanValue;
    }

    @Override // pg.q
    public List<TranUserInfo> q(final int i10) {
        List<com.transsion.hubsdk.content.pm.TranUserInfo> list = (List) new zb.f().c(new zb.f.b() { // from class: vd.o0
            @Override // zb.f.b
            public final Object run() {
                return this.f16968a.I(i10);
            }
        }, "user_manager");
        dc.e.f(f16904b, "getProfiles mTranUserInfo:" + list);
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.transsion.hubsdk.content.pm.TranUserInfo tranUserInfo : list) {
            TranUserInfo tranUserInfo2 = new TranUserInfo();
            tranUserInfo2.f2220a = tranUserInfo.id;
            tranUserInfo2.f2221b = tranUserInfo.flags;
            tranUserInfo2.f2223d = tranUserInfo.name;
            tranUserInfo2.f2225f = tranUserInfo.iconPath;
            tranUserInfo2.f2222c = tranUserInfo.userType;
            tranUserInfo2.f2234z = tranUserInfo.profileGroupId;
            tranUserInfo2.f2224e = tranUserInfo.serialNumber;
            tranUserInfo2.f2226g = tranUserInfo.creationTime;
            tranUserInfo2.f2227i = tranUserInfo.partial;
            tranUserInfo2.f2228n = tranUserInfo.preCreated;
            tranUserInfo2.f2231w = tranUserInfo.lastLoggedInFingerprint;
            tranUserInfo2.f2232x = tranUserInfo.profileBadge;
            tranUserInfo2.f2233y = tranUserInfo.restrictedProfileParentId;
            tranUserInfo2.t(tranUserInfo.isDualProfile());
            arrayList.add(tranUserInfo2);
        }
        return arrayList;
    }
}
