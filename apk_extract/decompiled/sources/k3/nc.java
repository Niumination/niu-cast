package k3;

import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class nc {
    /* JADX WARN: Code duplicated, block: B:74:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:? A[SYNTHETIC] */
    public static String a(File file, byte[] bArr) throws Throwable {
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        if (!file.exists() || !file.isFile()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int i8 = fileInputStream2.read(bArr2);
                            if (i8 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, i8);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray.length == 0) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e4) {
                                z6.a.c(e4.getMessage());
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e10) {
                                z6.a.c(e10.getMessage());
                            }
                            return "";
                        }
                        String str = new String(e(bArr, byteArray));
                        try {
                            fileInputStream2.close();
                        } catch (IOException e11) {
                            z6.a.c(e11.getMessage());
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e12) {
                            z6.a.c(e12.getMessage());
                        }
                        return str;
                    } catch (Exception e13) {
                        e = e13;
                        z6.a.c(Log.getStackTraceString(e));
                        throw e;
                    } catch (Throwable th3) {
                        th2 = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e14) {
                                z6.a.c(e14.getMessage());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            throw th2;
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th2;
                        } catch (IOException e15) {
                            z6.a.c(e15.getMessage());
                            throw th2;
                        }
                    }
                } catch (Exception e16) {
                    e = e16;
                }
            } catch (Throwable th4) {
                th2 = th4;
                byteArrayOutputStream = null;
            }
        } catch (Exception e17) {
            e = e17;
        } catch (Throwable th5) {
            th2 = th5;
            byteArrayOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                throw th2;
            }
            byteArrayOutputStream.close();
            throw th2;
        }
    }

    public static String b(String str, byte[] bArr) {
        try {
            if (bArr != null) {
                return new String(Base64.encode(d(str, bArr), 2));
            }
            z6.a.c("encryptEventData password is null");
            return null;
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }

    public static void c(File file, String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                byte[] bArrD = d(str, bArr);
                if (bArrD == null || bArrD.length == 0) {
                    throw new Exception("encode failed p = " + dd.k(bArr) + ", m = " + str.length());
                }
                if (!file.exists() && !file.createNewFile()) {
                    throw new IOException("createNewFile failed");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                FileOutputStream fileOutputStream3 = fileOutputStream2;
                fileOutputStream3.write(bArrD);
                fileOutputStream3.flush();
                try {
                    fileOutputStream3.close();
                } catch (IOException unused) {
                }
            } catch (Exception e) {
                z6.a.c(Log.getStackTraceString(e));
                throw e;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
    }

    public static byte[] d(String str, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(s6.d.f9550o));
        try {
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(s6.d.f9550o));
        try {
            return cipher.doFinal(bArr2);
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            throw e;
        }
    }

    public static String f(String str, byte[] bArr) {
        try {
            if (bArr != null) {
                return new String(e(bArr, Base64.decode(str, 2)));
            }
            z6.a.c("decryptEventData password is null");
            return null;
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }
}
