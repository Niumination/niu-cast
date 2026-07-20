package k4;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8928a = "AssetsUtils";

    public static String a(Context context, String str) throws Throwable {
        BufferedReader bufferedReader;
        IOException e10;
        InputStream inputStreamOpen;
        StringBuilder sb2 = new StringBuilder();
        InputStream inputStream = null;
        try {
            AssetManager assets = context.getAssets();
            if (assets == null) {
                d.b(null, null);
                return null;
            }
            inputStreamOpen = assets.open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb2.append(line);
                        } catch (IOException e11) {
                            e10 = e11;
                            m.d(f8928a, e10);
                            d.b(inputStreamOpen, bufferedReader);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamOpen;
                        d.b(inputStream, bufferedReader);
                        throw th;
                    }
                }
                d.b(inputStreamOpen, bufferedReader);
            } catch (IOException e12) {
                e10 = e12;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                inputStream = inputStreamOpen;
                d.b(inputStream, bufferedReader);
                throw th;
            }
            return sb2.toString();
        } catch (IOException e13) {
            bufferedReader = null;
            e10 = e13;
            inputStreamOpen = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            d.b(inputStream, bufferedReader);
            throw th;
        }
        m.d(f8928a, e10);
        d.b(inputStreamOpen, bufferedReader);
        return sb2.toString();
    }
}
