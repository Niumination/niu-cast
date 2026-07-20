package ke;

import com.transsion.hubsdk.telephony.ims.feature.TranImsFeature;

/* JADX INFO: loaded from: classes2.dex */
public class a implements eh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranImsFeature f9176a = new TranImsFeature();

    @Override // eh.a
    public boolean a(Object obj, int i10) {
        TranImsFeature tranImsFeature = this.f9176a;
        if (tranImsFeature != null) {
            return tranImsFeature.isCapable(obj, i10);
        }
        return false;
    }
}
