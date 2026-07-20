package k7;

import androidx.exifinterface.media.ExifInterface;
import com.transsion.atomiccore.support.host.AtomicDefaultSizeData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ad.b f6785a;

    public c(o5.c cVar) {
        this.f6785a = (ad.b) cVar.f8405a;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            ad.b bVar = this.f6785a;
            if (bVar != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    AtomicDefaultSizeData atomicDefaultSizeData = (AtomicDefaultSizeData) bVar.f92a;
                    if (atomicDefaultSizeData != null) {
                        jSONObject2.put(ExifInterface.LATITUDE_SOUTH, atomicDefaultSizeData.toJSONObject());
                    }
                    AtomicDefaultSizeData atomicDefaultSizeData2 = (AtomicDefaultSizeData) bVar.f93b;
                    if (atomicDefaultSizeData2 != null) {
                        jSONObject2.put("M", atomicDefaultSizeData2.toJSONObject());
                    }
                } catch (JSONException unused) {
                }
                jSONObject.put("island", jSONObject2);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }
}
