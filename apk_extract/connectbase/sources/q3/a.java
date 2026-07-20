package q3;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.List;
import org.json.JSONObject;
import s3.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ByteBuffer f13811b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f13812a;

    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ae A[Catch: IOException -> 0x00aa, TRY_LEAVE, TryCatch #1 {IOException -> 0x00aa, blocks: (B:39:0x00a6, B:43:0x00ae), top: B:84:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d7 A[Catch: IOException -> 0x00d3, TRY_LEAVE, TryCatch #6 {IOException -> 0x00d3, blocks: (B:55:0x00cf, B:59:0x00d7), top: B:90:0x00cf }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00e4 A[Catch: IOException -> 0x00bf, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x00bf, blocks: (B:47:0x00bb, B:63:0x00e4), top: B:95:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00fe A[Catch: IOException -> 0x00fa, TRY_LEAVE, TryCatch #0 {IOException -> 0x00fa, blocks: (B:69:0x00f6, B:73:0x00fe), top: B:82:0x00f6 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public a(String str) throws Throwable {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        Exception e10;
        FileChannel channel;
        RandomAccessFile randomAccessFile2;
        Throwable th2;
        FileLock fileLock;
        File file = new File(str);
        this.f13812a = file;
        if (!file.exists()) {
            try {
                if (this.f13812a.createNewFile()) {
                    y3.b.f("EncryptFile created");
                }
            } catch (Exception e11) {
                y3.b.d(Log.getStackTraceString(e11));
            }
        }
        if (f13811b == null) {
            f13811b = ByteBuffer.allocate(32808);
        }
        FileLock fileLock2 = null;
        fileLock2 = null;
        fileLockLock = null;
        FileChannel fileChannel2 = null;
        fileLock2 = null;
        FileLock fileLockLock = null;
        fileLock2 = null;
        try {
            try {
                if (this.f13812a.length() < 8192) {
                    randomAccessFile2 = new RandomAccessFile(this.f13812a, "rw");
                    try {
                        channel = randomAccessFile2.getChannel();
                        try {
                            try {
                                fileLockLock = channel.lock();
                                f13811b.putInt(0, 0);
                                f13811b.putInt(4, ((Integer) n3.b.l().u().first).intValue());
                                for (int i10 = 0; i10 < 8192; i10 += 4) {
                                    f13811b.putInt((i10 + 10) * 4, i10);
                                }
                                randomAccessFile2.seek(0L);
                                randomAccessFile2.write(f13811b.array());
                            } catch (Exception e12) {
                                e10 = e12;
                                FileLock fileLock3 = fileLockLock;
                                fileChannel2 = channel;
                                fileLock = fileLock3;
                                FileChannel fileChannel3 = fileChannel2;
                                fileLock2 = fileLock;
                                channel = fileChannel3;
                                y3.b.d(Log.getStackTraceString(e10));
                                if (fileLock2 != null) {
                                    try {
                                        fileLock2.release();
                                        if (channel != null) {
                                            channel.close();
                                        }
                                    } catch (IOException e13) {
                                        y3.b.d(Log.getStackTraceString(e13));
                                        if (randomAccessFile2 == null) {
                                            randomAccessFile2.close();
                                        }
                                        return;
                                    }
                                } else if (channel != null) {
                                    channel.close();
                                }
                                if (randomAccessFile2 == null) {
                                    return;
                                } else {
                                    randomAccessFile2.close();
                                }
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            RandomAccessFile randomAccessFile3 = randomAccessFile2;
                            fileChannel = channel;
                            th = th2;
                            randomAccessFile = randomAccessFile3;
                            if (fileLock2 != null) {
                                try {
                                    fileLock2.release();
                                    if (fileChannel != null) {
                                        fileChannel.close();
                                    }
                                } catch (IOException e14) {
                                    y3.b.d(Log.getStackTraceString(e14));
                                    if (randomAccessFile != null) {
                                        throw th;
                                    }
                                    try {
                                        randomAccessFile.close();
                                        throw th;
                                    } catch (IOException e15) {
                                        y3.b.d(Log.getStackTraceString(e15));
                                        throw th;
                                    }
                                }
                            } else if (fileChannel != null) {
                                fileChannel.close();
                            }
                            if (randomAccessFile != null) {
                                throw th;
                            }
                            randomAccessFile.close();
                            throw th;
                        }
                    } catch (Exception e16) {
                        e10 = e16;
                        fileLock = null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        channel = null;
                        RandomAccessFile randomAccessFile4 = randomAccessFile2;
                        fileChannel = channel;
                        th = th2;
                        randomAccessFile = randomAccessFile4;
                        if (fileLock2 != null) {
                            fileLock2.release();
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                        } else if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (randomAccessFile != null) {
                            throw th;
                        }
                        randomAccessFile.close();
                        throw th;
                    }
                } else {
                    channel = null;
                    randomAccessFile2 = null;
                }
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                        if (channel != null) {
                            channel.close();
                        }
                    } catch (IOException e17) {
                        y3.b.d(Log.getStackTraceString(e17));
                    }
                } else if (channel != null) {
                    channel.close();
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (IOException e18) {
                y3.b.d(Log.getStackTraceString(e18));
            }
        } catch (Exception e19) {
            e10 = e19;
            channel = null;
            randomAccessFile2 = null;
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
            randomAccessFile = null;
            if (fileLock2 != null) {
                fileLock2.release();
                if (fileChannel != null) {
                    fileChannel.close();
                }
            } else if (fileChannel != null) {
                fileChannel.close();
            }
            if (randomAccessFile != null) {
                throw th;
            }
            randomAccessFile.close();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0115 A[Catch: IOException -> 0x0111, TRY_LEAVE, TryCatch #3 {IOException -> 0x0111, blocks: (B:64:0x010d, B:68:0x0115), top: B:94:0x010d }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0122 A[Catch: IOException -> 0x00e1, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x00e1, blocks: (B:44:0x00dd, B:72:0x0122), top: B:105:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:82:0x013d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x013f A[Catch: IOException -> 0x013b, TRY_LEAVE, TryCatch #13 {IOException -> 0x013b, blocks: (B:79:0x0137, B:83:0x013f), top: B:108:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String a() throws Throwable {
        FileChannel fileChannel;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileLock fileLock2;
        byte[] bArr;
        StringBuilder sb2 = new StringBuilder();
        List<byte[]> listO = n3.b.l().o();
        if (e.j(listO)) {
            y3.b.b("readBuffer passwords is empty");
            return "";
        }
        RandomAccessFile randomAccessFile2 = null;
        fileLockLock = null;
        FileLock fileLockLock = null;
        fileChannel = null;
        FileChannel fileChannel2 = null;
        FileChannel fileChannel3 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(this.f13812a, "rw");
                try {
                    channel = randomAccessFile.getChannel();
                    try {
                        try {
                            fileLockLock = channel.lock();
                            randomAccessFile.seek(0L);
                            randomAccessFile.read(f13811b.array(), 0, 32808);
                            byte[] bArr2 = listO.get(f13811b.getInt(4));
                            if (bArr2 != null) {
                                c cVar = new c(bArr2);
                                boolean z10 = true;
                                for (int i10 = 0; i10 < f13811b.getInt(0); i10++) {
                                    if (i10 == 0) {
                                        int i11 = f13811b.getInt((i10 + 10) * 4);
                                        bArr = new byte[i11];
                                        randomAccessFile.read(bArr, 0, i11);
                                    } else {
                                        int i12 = f13811b.getInt((i10 + 10) * 4) - f13811b.getInt((i10 + 9) * 4);
                                        bArr = new byte[i12];
                                        randomAccessFile.read(bArr, 0, i12);
                                    }
                                    String str = new String(cVar.b(bArr));
                                    try {
                                        try {
                                            JSONObject jSONObject = new JSONObject(str);
                                            if (jSONObject.has("tid") && jSONObject.has(NotificationCompat.CATEGORY_EVENT)) {
                                                if (!z10) {
                                                    sb2.append("\n");
                                                }
                                                sb2.append(str);
                                                z10 = false;
                                            }
                                        } catch (Exception e10) {
                                            y3.b.d(Log.getStackTraceString(e10));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (fileLockLock != null) {
                                            try {
                                                fileLockLock.release();
                                                if (channel != null) {
                                                    channel.close();
                                                }
                                            } catch (IOException e11) {
                                                y3.b.d(Log.getStackTraceString(e11));
                                                if (randomAccessFile == null) {
                                                    throw th;
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                    throw th;
                                                } catch (IOException e12) {
                                                    y3.b.d(Log.getStackTraceString(e12));
                                                    throw th;
                                                }
                                            }
                                        } else if (channel != null) {
                                            channel.close();
                                        }
                                        if (randomAccessFile == null) {
                                            throw th;
                                        }
                                        randomAccessFile.close();
                                        throw th;
                                    }
                                }
                            }
                            if (fileLockLock != null) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e13) {
                                    y3.b.d(Log.getStackTraceString(e13));
                                }
                            }
                            channel.close();
                            randomAccessFile.close();
                        } catch (Exception e14) {
                            e = e14;
                            fileLock = fileLockLock;
                            fileChannel3 = channel;
                            try {
                                y3.b.d(Log.getStackTraceString(e));
                                if (this.f13812a.delete()) {
                                    y3.b.f("file deleted");
                                }
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                        if (fileChannel3 != null) {
                                            fileChannel3.close();
                                        }
                                    } catch (IOException e15) {
                                        y3.b.d(Log.getStackTraceString(e15));
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                        return sb2.toString();
                                    }
                                } else if (fileChannel3 != null) {
                                    fileChannel3.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                return sb2.toString();
                            } catch (Throwable th3) {
                                th = th3;
                                fileChannel = fileChannel3;
                                randomAccessFile2 = randomAccessFile;
                                randomAccessFile = randomAccessFile2;
                                fileLockLock = fileLock;
                                channel = fileChannel;
                                if (fileLockLock != null) {
                                    fileLockLock.release();
                                    if (channel != null) {
                                        channel.close();
                                    }
                                } else if (channel != null) {
                                    channel.close();
                                }
                                if (randomAccessFile == null) {
                                    throw th;
                                }
                                randomAccessFile.close();
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileLock2 = fileLockLock;
                        fileChannel2 = channel;
                        channel = fileChannel2;
                        fileLockLock = fileLock2;
                        if (fileLockLock != null) {
                            fileLockLock.release();
                            if (channel != null) {
                                channel.close();
                            }
                        } else if (channel != null) {
                            channel.close();
                        }
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        randomAccessFile.close();
                        throw th;
                    }
                } catch (Exception e16) {
                    e = e16;
                    fileLock = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileLock2 = null;
                }
            } catch (IOException e17) {
                y3.b.d(Log.getStackTraceString(e17));
            }
        } catch (Exception e18) {
            e = e18;
            randomAccessFile = null;
            fileLock = null;
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
            fileLock = null;
            randomAccessFile = randomAccessFile2;
            fileLockLock = fileLock;
            channel = fileChannel;
            if (fileLockLock != null) {
                fileLockLock.release();
                if (channel != null) {
                    channel.close();
                }
            } else if (channel != null) {
                channel.close();
            }
            if (randomAccessFile == null) {
                throw th;
            }
            randomAccessFile.close();
            throw th;
        }
        return sb2.toString();
    }
}
