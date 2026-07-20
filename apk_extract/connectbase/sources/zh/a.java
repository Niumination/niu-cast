package zh;

import android.util.Base64;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21927a;

    public a(String secret) {
        this.f21927a = secret;
    }

    @Override // zh.e
    public String a(d algo, String content) {
        try {
            Mac mac = Mac.getInstance(algo.name());
            mac.init(new SecretKeySpec(Base64.decode(this.f21927a, 2), algo.name()));
            return Base64.encodeToString(mac.doFinal(content.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (Exception e10) {
            e10.printStackTrace();
            ai.c.f217a.m(e10);
            return "";
        }
    }
}
