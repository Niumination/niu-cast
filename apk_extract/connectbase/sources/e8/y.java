package e8;

import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.api.os.TranUserInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class y implements pg.q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f4158e = "y";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f4159f = cc.a.a("android.os.UserManager");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f4160g = cc.a.a("android.content.pm.UserInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f4162b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4163c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UserManager f4164d;

    public y() {
        Context contextA = bc.a.a();
        this.f4161a = contextA;
        this.f4164d = (UserManager) contextA.getSystemService("user");
    }

    @Override // pg.q
    public TranUserInfo a(int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "getUserInfo", Integer.TYPE), this.f4164d, Integer.valueOf(i10));
        TranUserInfo tranUserInfo = new TranUserInfo();
        if (objJ == null) {
            return tranUserInfo;
        }
        if (f4160g.isInstance(objJ)) {
            dc.e.a(f4158e, "Object :" + objJ);
        }
        try {
            int i11 = cc.a.d(f4160g, dc.d.f3692w).getInt(objJ);
            int i12 = cc.a.d(f4160g, "flags").getInt(objJ);
            Object obj = cc.a.d(f4160g, "name").get(objJ);
            String str = obj instanceof String ? (String) obj : null;
            tranUserInfo.f2220a = i11;
            tranUserInfo.f2221b = i12;
            tranUserInfo.f2223d = str;
        } catch (Exception e10) {
            p6.b.a("getUserInfo fail.", e10, f4158e);
        }
        return tranUserInfo;
    }

    @Override // pg.q
    public TranUserInfo b(String str, String str2, int i10, int i11, String[] strArr) {
        Class<?> cls = this.f4164d.getClass();
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "createProfileForUserEvenWhenDisallowed", String.class, String.class, cls2, cls2, String[].class), this.f4164d, str, str2, Integer.valueOf(i10), Integer.valueOf(i11), strArr);
        TranUserInfo tranUserInfo = new TranUserInfo();
        if (objJ == null) {
            return tranUserInfo;
        }
        try {
            int i12 = cc.a.d(f4160g, dc.d.f3692w).getInt(objJ);
            int i13 = cc.a.d(f4160g, "flags").getInt(objJ);
            String str3 = (String) cc.a.d(f4160g, "name").get(objJ);
            String str4 = (String) cc.a.d(f4160g, "iconPath").get(objJ);
            String str5 = (String) cc.a.d(f4160g, "userType").get(objJ);
            int i14 = cc.a.d(f4160g, "serialNumber").getInt(objJ);
            long j10 = cc.a.d(f4160g, "creationTime").getLong(objJ);
            boolean z10 = cc.a.d(f4160g, "partial").getBoolean(objJ);
            boolean z11 = cc.a.d(f4160g, "preCreated").getBoolean(objJ);
            String str6 = (String) cc.a.d(f4160g, "lastLoggedInFingerprint").get(objJ);
            int i15 = cc.a.d(f4160g, "profileBadge").getInt(objJ);
            int i16 = cc.a.d(f4160g, "restrictedProfileParentId").getInt(objJ);
            tranUserInfo.f2220a = i12;
            tranUserInfo.f2221b = i13;
            tranUserInfo.f2223d = str3;
            tranUserInfo.f2225f = str4;
            tranUserInfo.f2222c = str5;
            tranUserInfo.f2224e = i14;
            tranUserInfo.f2226g = j10;
            tranUserInfo.f2227i = z10;
            tranUserInfo.f2228n = z11;
            tranUserInfo.f2231w = str6;
            tranUserInfo.f2232x = i15;
            tranUserInfo.f2233y = i16;
            tranUserInfo.H = TranUserInfo.X.equals(str5);
        } catch (Exception unused) {
            dc.e.c(f4158e, "createProfileForUserEvenWhenDisallowed fail.");
        }
        return tranUserInfo;
    }

    @Override // pg.q
    public int[] c(int i10) {
        try {
            UserManager userManager = (UserManager) this.f4161a.getSystemService("user");
            Method methodG = cc.a.g(userManager.getClass(), "getProfileIdsWithDisabled", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(userManager, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof int[])) {
                return null;
            }
            return (int[]) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getProfileIdsWithDisabled fail ", th2, f4158e);
            return null;
        }
    }

    @Override // pg.q
    public boolean d(int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "removeUserEvenWhenDisallowed", Integer.TYPE), this.f4164d, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // pg.q
    public UserHandle e(String str, String str2, String[] strArr) {
        return (UserHandle) cc.a.j(cc.a.g(this.f4164d.getClass(), "createProfile", String.class, String.class, Set.class), this.f4164d, str, str2, new HashSet(Arrays.asList(strArr)));
    }

    @Override // pg.q
    public boolean f(int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "isManagedProfile", Integer.TYPE), this.f4164d, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // pg.q
    public void g(String str, boolean z10, UserHandle userHandle) {
        cc.a.j(cc.a.g(this.f4164d.getClass(), "setUserRestriction", String.class, Boolean.TYPE, UserHandle.class), this.f4164d, str, Boolean.valueOf(z10), userHandle);
    }

    @Override // pg.q
    public int h(int i10) {
        if (this.f4162b == null) {
            Method methodG = cc.a.g(f4159f, "get", Context.class);
            this.f4162b = methodG;
            methodG.setAccessible(true);
        }
        try {
            if (this.f4163c == null) {
                this.f4163c = this.f4162b.invoke(f4159f, this.f4161a);
            }
            Object objInvoke = cc.a.g(this.f4163c.getClass(), "getCredentialOwnerProfile", Integer.TYPE).invoke(this.f4163c, Integer.valueOf(i10));
            int iIntValue = (objInvoke == null || !(objInvoke instanceof Integer)) ? 0 : ((Integer) objInvoke).intValue();
            dc.e.a(f4158e, "getCredentialOwnerProfile user" + iIntValue);
            return iIntValue;
        } catch (Throwable th2) {
            m7.a.a("getCredentialOwnerProfile fail ", th2, f4158e);
            return 0;
        }
    }

    @Override // pg.q
    public boolean i(int i10, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "canAddMoreManagedProfiles", Integer.TYPE, Boolean.TYPE), this.f4164d, Integer.valueOf(i10), Boolean.valueOf(z10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // pg.q
    public boolean j(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "canAddMoreProfilesToUser", String.class, Integer.TYPE), this.f4164d, str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // pg.q
    public List<TranUserInfo> k() {
        Iterator it;
        ArrayList arrayList;
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "getUsers", new Class[0]), this.f4164d, new Object[0]);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (objJ instanceof List) {
            Iterator it2 = ((List) objJ).iterator();
            while (it2.hasNext()) {
                arrayList2.add(f4160g.cast(it2.next()));
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList3;
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Object next = it3.next();
            try {
                int i10 = cc.a.d(f4160g, dc.d.f3692w).getInt(next);
                int i11 = cc.a.d(f4160g, "flags").getInt(next);
                String str = (String) cc.a.d(f4160g, "name").get(next);
                String str2 = (String) cc.a.d(f4160g, "iconPath").get(next);
                String str3 = (String) cc.a.d(f4160g, "userType").get(next);
                int i12 = cc.a.d(f4160g, "serialNumber").getInt(next);
                long j10 = cc.a.d(f4160g, "creationTime").getLong(next);
                boolean z10 = cc.a.d(f4160g, "partial").getBoolean(next);
                boolean z11 = cc.a.d(f4160g, "preCreated").getBoolean(next);
                String str4 = (String) cc.a.d(f4160g, "lastLoggedInFingerprint").get(next);
                int i13 = cc.a.d(f4160g, "profileBadge").getInt(next);
                it = it3;
                try {
                    int i14 = cc.a.d(f4160g, "restrictedProfileParentId").getInt(next);
                    ArrayList arrayList4 = arrayList3;
                    try {
                        int i15 = cc.a.d(f4160g, "profileGroupId").getInt(next);
                        long j11 = cc.a.d(f4160g, "lastLoggedInTime").getLong(next);
                        boolean z12 = cc.a.d(f4160g, "convertedFromPreCreated").getBoolean(next);
                        boolean z13 = cc.a.d(f4160g, "guestToRemove").getBoolean(next);
                        TranUserInfo tranUserInfo = new TranUserInfo();
                        tranUserInfo.f2220a = i10;
                        tranUserInfo.f2221b = i11;
                        tranUserInfo.f2223d = str;
                        tranUserInfo.f2225f = str2;
                        tranUserInfo.f2222c = str3;
                        tranUserInfo.f2224e = i12;
                        tranUserInfo.f2226g = j10;
                        tranUserInfo.f2227i = z10;
                        tranUserInfo.f2228n = z11;
                        tranUserInfo.f2231w = str4;
                        tranUserInfo.f2232x = i13;
                        tranUserInfo.f2233y = i14;
                        tranUserInfo.f2234z = i15;
                        tranUserInfo.f2229p = j11;
                        tranUserInfo.f2230v = z12;
                        tranUserInfo.I = z13;
                        arrayList = arrayList4;
                        try {
                            arrayList.add(tranUserInfo);
                        } catch (Exception unused) {
                            dc.e.c(f4158e, "getProfiles fail.");
                        }
                    } catch (Exception unused2) {
                        arrayList = arrayList4;
                    }
                } catch (Exception unused3) {
                    arrayList = arrayList3;
                    dc.e.c(f4158e, "getProfiles fail.");
                    arrayList3 = arrayList;
                    it3 = it;
                }
            } catch (Exception unused4) {
                it = it3;
            }
            arrayList3 = arrayList;
            it3 = it;
        }
        return arrayList3;
    }

    @Override // pg.q
    public List<UserHandle> l() {
        return (List) cc.a.j(cc.a.g(this.f4164d.getClass(), "getAllProfiles", new Class[0]), this.f4164d, new Object[0]);
    }

    @Override // pg.q
    public TranUserInfo m(String str, String str2, int i10, int i11, String[] strArr) {
        Class<?> cls = this.f4164d.getClass();
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "createProfileForUser", String.class, String.class, cls2, cls2, String[].class), this.f4164d, str, str2, Integer.valueOf(i10), Integer.valueOf(i11), strArr);
        TranUserInfo tranUserInfo = new TranUserInfo();
        if (objJ == null) {
            return tranUserInfo;
        }
        try {
            int i12 = cc.a.d(f4160g, dc.d.f3692w).getInt(objJ);
            int i13 = cc.a.d(f4160g, "flags").getInt(objJ);
            String str3 = (String) cc.a.d(f4160g, "name").get(objJ);
            String str4 = (String) cc.a.d(f4160g, "iconPath").get(objJ);
            String str5 = (String) cc.a.d(f4160g, "userType").get(objJ);
            int i14 = cc.a.d(f4160g, "serialNumber").getInt(objJ);
            long j10 = cc.a.d(f4160g, "creationTime").getLong(objJ);
            boolean z10 = cc.a.d(f4160g, "partial").getBoolean(objJ);
            boolean z11 = cc.a.d(f4160g, "preCreated").getBoolean(objJ);
            String str6 = (String) cc.a.d(f4160g, "lastLoggedInFingerprint").get(objJ);
            int i15 = cc.a.d(f4160g, "profileBadge").getInt(objJ);
            int i16 = cc.a.d(f4160g, "restrictedProfileParentId").getInt(objJ);
            tranUserInfo.f2220a = i12;
            tranUserInfo.f2221b = i13;
            tranUserInfo.f2223d = str3;
            tranUserInfo.f2225f = str4;
            tranUserInfo.f2222c = str5;
            tranUserInfo.f2224e = i14;
            tranUserInfo.f2226g = j10;
            tranUserInfo.f2227i = z10;
            tranUserInfo.f2228n = z11;
            tranUserInfo.f2231w = str6;
            tranUserInfo.f2232x = i15;
            tranUserInfo.f2233y = i16;
            tranUserInfo.H = TranUserInfo.X.equals(str5);
        } catch (Exception unused) {
            dc.e.c(f4158e, "createProfileForUser fail.");
        }
        return tranUserInfo;
    }

    @Override // pg.q
    public boolean n() {
        return ((Boolean) cc.a.j(cc.a.g(this.f4164d.getClass(), "isAdminUser", new Class[0]), this.f4164d, new Object[0])).booleanValue();
    }

    @Override // pg.q
    public List<TranUserInfo> o(boolean z10) {
        Iterator it;
        ArrayList arrayList;
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "getUsers", Boolean.TYPE), this.f4164d, Boolean.valueOf(z10));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (objJ instanceof List) {
            Iterator it2 = ((List) objJ).iterator();
            while (it2.hasNext()) {
                arrayList2.add(f4160g.cast(it2.next()));
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList3;
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Object next = it3.next();
            try {
                int i10 = cc.a.d(f4160g, dc.d.f3692w).getInt(next);
                int i11 = cc.a.d(f4160g, "flags").getInt(next);
                String str = (String) cc.a.d(f4160g, "name").get(next);
                String str2 = (String) cc.a.d(f4160g, "iconPath").get(next);
                String str3 = (String) cc.a.d(f4160g, "userType").get(next);
                int i12 = cc.a.d(f4160g, "serialNumber").getInt(next);
                long j10 = cc.a.d(f4160g, "creationTime").getLong(next);
                boolean z11 = cc.a.d(f4160g, "partial").getBoolean(next);
                boolean z12 = cc.a.d(f4160g, "preCreated").getBoolean(next);
                String str4 = (String) cc.a.d(f4160g, "lastLoggedInFingerprint").get(next);
                int i13 = cc.a.d(f4160g, "profileBadge").getInt(next);
                it = it3;
                try {
                    int i14 = cc.a.d(f4160g, "restrictedProfileParentId").getInt(next);
                    ArrayList arrayList4 = arrayList3;
                    try {
                        int i15 = cc.a.d(f4160g, "profileGroupId").getInt(next);
                        long j11 = cc.a.d(f4160g, "lastLoggedInTime").getLong(next);
                        boolean z13 = cc.a.d(f4160g, "convertedFromPreCreated").getBoolean(next);
                        boolean z14 = cc.a.d(f4160g, "guestToRemove").getBoolean(next);
                        TranUserInfo tranUserInfo = new TranUserInfo();
                        tranUserInfo.f2220a = i10;
                        tranUserInfo.f2221b = i11;
                        tranUserInfo.f2223d = str;
                        tranUserInfo.f2225f = str2;
                        tranUserInfo.f2222c = str3;
                        tranUserInfo.f2224e = i12;
                        tranUserInfo.f2226g = j10;
                        tranUserInfo.f2227i = z11;
                        tranUserInfo.f2228n = z12;
                        tranUserInfo.f2231w = str4;
                        tranUserInfo.f2232x = i13;
                        tranUserInfo.f2233y = i14;
                        tranUserInfo.f2234z = i15;
                        tranUserInfo.f2229p = j11;
                        tranUserInfo.f2230v = z13;
                        tranUserInfo.I = z14;
                        arrayList = arrayList4;
                        try {
                            arrayList.add(tranUserInfo);
                        } catch (Exception e10) {
                            e = e10;
                            p6.b.a("getUsers fail:", e, f4158e);
                        }
                    } catch (Exception e11) {
                        e = e11;
                        arrayList = arrayList4;
                    }
                } catch (Exception e12) {
                    e = e12;
                    arrayList = arrayList3;
                    p6.b.a("getUsers fail:", e, f4158e);
                    arrayList3 = arrayList;
                    it3 = it;
                }
            } catch (Exception e13) {
                e = e13;
                it = it3;
            }
            arrayList3 = arrayList;
            it3 = it;
        }
        return arrayList3;
    }

    @Override // pg.q
    public boolean p(int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "isUserAdmin", Integer.TYPE), this.f4164d, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // pg.q
    public List<TranUserInfo> q(int i10) {
        Iterator it;
        ArrayList arrayList;
        Object objJ = cc.a.j(cc.a.g(this.f4164d.getClass(), "getProfiles", Integer.TYPE), this.f4164d, Integer.valueOf(i10));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (objJ instanceof List) {
            Iterator it2 = ((List) objJ).iterator();
            while (it2.hasNext()) {
                arrayList2.add(f4160g.cast(it2.next()));
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList3;
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Object next = it3.next();
            try {
                int i11 = cc.a.d(f4160g, dc.d.f3692w).getInt(next);
                int i12 = cc.a.d(f4160g, "flags").getInt(next);
                String str = (String) cc.a.d(f4160g, "name").get(next);
                String str2 = (String) cc.a.d(f4160g, "iconPath").get(next);
                String str3 = (String) cc.a.d(f4160g, "userType").get(next);
                int i13 = cc.a.d(f4160g, "serialNumber").getInt(next);
                long j10 = cc.a.d(f4160g, "creationTime").getLong(next);
                boolean z10 = cc.a.d(f4160g, "partial").getBoolean(next);
                boolean z11 = cc.a.d(f4160g, "preCreated").getBoolean(next);
                String str4 = (String) cc.a.d(f4160g, "lastLoggedInFingerprint").get(next);
                int i14 = cc.a.d(f4160g, "profileBadge").getInt(next);
                it = it3;
                try {
                    int i15 = cc.a.d(f4160g, "restrictedProfileParentId").getInt(next);
                    ArrayList arrayList4 = arrayList3;
                    try {
                        int i16 = cc.a.d(f4160g, "profileGroupId").getInt(next);
                        TranUserInfo tranUserInfo = new TranUserInfo();
                        tranUserInfo.f2220a = i11;
                        tranUserInfo.f2221b = i12;
                        tranUserInfo.f2223d = str;
                        tranUserInfo.f2225f = str2;
                        tranUserInfo.f2222c = str3;
                        tranUserInfo.f2224e = i13;
                        tranUserInfo.f2226g = j10;
                        tranUserInfo.f2227i = z10;
                        tranUserInfo.f2228n = z11;
                        tranUserInfo.f2231w = str4;
                        tranUserInfo.f2232x = i14;
                        tranUserInfo.f2233y = i15;
                        tranUserInfo.f2234z = i16;
                        tranUserInfo.H = TranUserInfo.X.equals(str3);
                        arrayList = arrayList4;
                        try {
                            arrayList.add(tranUserInfo);
                        } catch (Exception unused) {
                            dc.e.c(f4158e, "getProfiles fail.");
                        }
                    } catch (Exception unused2) {
                        arrayList = arrayList4;
                    }
                } catch (Exception unused3) {
                    arrayList = arrayList3;
                    dc.e.c(f4158e, "getProfiles fail.");
                    arrayList3 = arrayList;
                    it3 = it;
                }
            } catch (Exception unused4) {
                it = it3;
            }
            arrayList3 = arrayList;
            it3 = it;
        }
        return arrayList3;
    }

    @VisibleForTesting
    public void r(Object obj) {
        this.f4163c = obj;
    }

    @VisibleForTesting
    public void s(Context context) {
        this.f4161a = context;
    }
}
