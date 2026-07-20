package je;

import com.transsion.hubsdk.api.telephony.TranAlphaTag;
import com.transsion.hubsdk.api.telephony.TranUsimGroup;
import com.transsion.hubsdk.telephony.TranMtkIccPhoneBookManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements dh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranMtkIccPhoneBookManager f8675a = new TranMtkIccPhoneBookManager();

    @Override // dh.a
    public boolean a(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.hasSne(i10);
        }
        return false;
    }

    @Override // dh.a
    public int b(int i10, String str) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.insertUsimGroup(i10, str);
        }
        return -1;
    }

    @Override // dh.a
    public boolean c(int i10, int i11) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.removeUsimGroupById(i10, i11);
        }
        return false;
    }

    @Override // dh.a
    public int d(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.getUsimGrpMaxCount(i10);
        }
        return -1;
    }

    @Override // dh.a
    public int e(int i10, int i11, String str) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.updateUsimGroup(i10, i11, str);
        }
        return -1;
    }

    @Override // dh.a
    public boolean f(int i10, int i11, int[] iArr, int[] iArr2) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.moveContactFromGroupsToGroups(i10, i11, iArr, iArr2);
        }
        return false;
    }

    @Override // dh.a
    public List<TranAlphaTag> g(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        List<com.transsion.hubsdk.telephony.TranAlphaTag> usimAasList = tranMtkIccPhoneBookManager != null ? tranMtkIccPhoneBookManager.getUsimAasList(i10) : null;
        if (usimAasList == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (com.transsion.hubsdk.telephony.TranAlphaTag tranAlphaTag : usimAasList) {
            TranAlphaTag tranAlphaTag2 = new TranAlphaTag();
            tranAlphaTag2.i(tranAlphaTag.getRecordIndex());
            tranAlphaTag2.g(tranAlphaTag.getAlphaTag());
            tranAlphaTag2.h(tranAlphaTag.getPbrIndex());
            arrayList.add(tranAlphaTag2);
        }
        return arrayList;
    }

    @Override // dh.a
    public boolean h(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.isAdnAccessible(i10);
        }
        return false;
    }

    @Override // dh.a
    public int i(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.getSneRecordLen(i10);
        }
        return -1;
    }

    @Override // dh.a
    public boolean j(int i10, int i11, int i12) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.removeUsimAasById(i10, i11, i12);
        }
        return false;
    }

    @Override // dh.a
    public int k(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.getEmailCount(i10);
        }
        return -1;
    }

    @Override // dh.a
    public int l(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.getUsimGrpMaxNameLen(i10);
        }
        return -1;
    }

    @Override // dh.a
    public int m(int i10, String str) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.insertUsimAas(i10, str);
        }
        return -1;
    }

    @Override // dh.a
    public boolean n(int i10, int i11, int i12) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.addContactToGroup(i10, i11, i12);
        }
        return false;
    }

    @Override // dh.a
    public int o(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.getUsimAasMaxCount(i10);
        }
        return -1;
    }

    @Override // dh.a
    public boolean p(int i10, int i11, int i12) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.removeContactFromGroup(i10, i11, i12);
        }
        return false;
    }

    @Override // dh.a
    public int q(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.getAnrCount(i10);
        }
        return -1;
    }

    @Override // dh.a
    public String r(int i10, int i11) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.getUsimAasById(i10, i11);
        }
        return null;
    }

    @Override // dh.a
    public List<TranUsimGroup> s(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        List<com.transsion.hubsdk.telephony.TranUsimGroup> usimGroups = tranMtkIccPhoneBookManager != null ? tranMtkIccPhoneBookManager.getUsimGroups(i10) : null;
        if (usimGroups == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (com.transsion.hubsdk.telephony.TranUsimGroup tranUsimGroup : usimGroups) {
            TranUsimGroup tranUsimGroup2 = new TranUsimGroup();
            tranUsimGroup2.g(tranUsimGroup.getRecordIndex());
            tranUsimGroup2.f(tranUsimGroup.getAlphaTag());
            arrayList.add(tranUsimGroup2);
        }
        return arrayList;
    }

    @Override // dh.a
    public int t(int i10) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.getUsimAasMaxNameLen(i10);
        }
        return -1;
    }

    @Override // dh.a
    public boolean u(int i10, int i11, int i12, String str) {
        TranMtkIccPhoneBookManager tranMtkIccPhoneBookManager = this.f8675a;
        if (tranMtkIccPhoneBookManager != null) {
            return tranMtkIccPhoneBookManager.updateUsimAas(i10, i11, i12, str);
        }
        return false;
    }
}
