package t8;

import android.os.IBinder;
import com.transsion.hubsdk.api.telephony.TranAlphaTag;
import com.transsion.hubsdk.api.telephony.TranUsimGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements dh.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15522c = "Calling this method is prohibited, please implement it yourself.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f15523a = cc.a.a("com.mediatek.internal.telephony.phb.IMtkIccPhoneBook$Stub");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f15524b;

    @Override // dh.a
    public boolean a(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "hasSne", Integer.TYPE);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // dh.a
    public int b(int i10, String str) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "insertUsimGroup", Integer.TYPE, String.class);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), str)).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public boolean c(int i10, int i11) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Class<?> cls = obj.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "removeUsimGroupById", cls2, cls2);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), Integer.valueOf(i11))).booleanValue();
        }
        return false;
    }

    @Override // dh.a
    public int d(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getUsimGrpMaxCount", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public int e(int i10, int i11, String str) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Class<?> cls = obj.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "updateUsimGroup", cls2, cls2, String.class);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), Integer.valueOf(i11), str)).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public boolean f(int i10, int i11, int[] iArr, int[] iArr2) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Class<?> cls = obj.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "moveContactFromGroupsToGroups", cls2, cls2, int[].class, int[].class);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), Integer.valueOf(i11), iArr, iArr2)).booleanValue();
        }
        return false;
    }

    @Override // dh.a
    public List<TranAlphaTag> g(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        ArrayList arrayList = new ArrayList();
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getUsimAasList", Integer.TYPE);
        if (methodG != null) {
            Object objJ = cc.a.j(methodG, this.f15524b, Integer.valueOf(i10));
            if (!(objJ instanceof List)) {
                return null;
            }
            for (Object obj2 : (List) objJ) {
                TranAlphaTag tranAlphaTag = new TranAlphaTag();
                Field fieldD = cc.a.d(obj2.getClass(), "mRecordNumber");
                Field fieldD2 = cc.a.d(obj2.getClass(), "mAlphaTag");
                Field fieldD3 = cc.a.d(obj2.getClass(), "mPbrIndex");
                if (fieldD != null) {
                    tranAlphaTag.f2250a = ((Integer) cc.a.f(fieldD, obj2)).intValue();
                }
                if (fieldD2 != null) {
                    tranAlphaTag.f2251b = (String) cc.a.f(fieldD2, obj2);
                }
                if (fieldD3 != null) {
                    tranAlphaTag.f2252c = ((Integer) cc.a.f(fieldD3, obj2)).intValue();
                }
                arrayList.add(tranAlphaTag);
            }
        }
        return arrayList;
    }

    @Override // dh.a
    public boolean h(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "isAdnAccessible", Integer.TYPE);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // dh.a
    public int i(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getSneRecordLen", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public boolean j(int i10, int i11, int i12) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Class<?> cls = obj.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "removeUsimAasById", cls2, cls2, cls2);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12))).booleanValue();
        }
        return false;
    }

    @Override // dh.a
    public int k(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getEmailCount", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public int l(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getUsimGrpMaxNameLen", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public int m(int i10, String str) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "insertUsimAas", Integer.TYPE, String.class);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), str)).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public boolean n(int i10, int i11, int i12) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Class<?> cls = obj.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "addContactToGroup", cls2, cls2, cls2);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12))).booleanValue();
        }
        return false;
    }

    @Override // dh.a
    public int o(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getUsimAasMaxCount", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public boolean p(int i10, int i11, int i12) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Class<?> cls = obj.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "removeContactFromGroup", cls2, cls2, cls2);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12))).booleanValue();
        }
        return false;
    }

    @Override // dh.a
    public int q(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getAnrCount", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public String r(int i10, int i11) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Class<?> cls = obj.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "getUsimAasById", cls2, cls2);
        if (methodG != null) {
            return (String) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        return null;
    }

    @Override // dh.a
    public List<TranUsimGroup> s(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        ArrayList arrayList = new ArrayList();
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getUsimGroups", Integer.TYPE);
        if (methodG != null) {
            Object objJ = cc.a.j(methodG, this.f15524b, Integer.valueOf(i10));
            if (!(objJ instanceof List)) {
                return null;
            }
            for (Object obj2 : (List) objJ) {
                TranUsimGroup tranUsimGroup = new TranUsimGroup();
                Field fieldD = cc.a.d(obj2.getClass(), "mRecordNumber");
                Field fieldD2 = cc.a.d(obj2.getClass(), "mAlphaTag");
                if (fieldD != null) {
                    tranUsimGroup.f2254b = ((Integer) cc.a.f(fieldD, obj2)).intValue();
                }
                if (fieldD2 != null) {
                    tranUsimGroup.f2253a = (String) cc.a.f(fieldD2, obj2);
                }
                arrayList.add(tranUsimGroup);
            }
        }
        return arrayList;
    }

    @Override // dh.a
    public int t(int i10) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Method methodG = cc.a.g(obj.getClass(), "getUsimAasMaxNameLen", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10))).intValue();
        }
        return -1;
    }

    @Override // dh.a
    public boolean u(int i10, int i11, int i12, String str) throws ac.a {
        if (this.f15524b == null) {
            this.f15524b = v();
        }
        Object obj = this.f15524b;
        if (obj == null) {
            throw new ac.a("Calling this method is prohibited, please implement it yourself.");
        }
        Class<?> cls = obj.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "updateUsimAas", cls2, cls2, cls2, String.class);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15524b, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), str)).booleanValue();
        }
        return false;
    }

    public final Object v() {
        Method methodG;
        Class clsA = cc.a.a("android.os.ServiceManager");
        Object objJ = cc.a.j(cc.a.g(clsA, "getService", String.class), clsA, "mtksimphonebook");
        Class<?> cls = this.f15523a;
        if (cls == null || (methodG = cc.a.g(cls, "asInterface", IBinder.class)) == null || objJ == null) {
            return null;
        }
        return cc.a.j(methodG, null, objJ);
    }
}
