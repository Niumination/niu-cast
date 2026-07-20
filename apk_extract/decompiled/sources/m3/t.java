package m3;

import android.graphics.Bitmap;
import android.media.Image;
import com.transsion.iotcardsdk.bean.DeviceType;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {
    public static ByteBuffer a(w5.a aVar) throws l5.a {
        int i8 = aVar.f;
        int i9 = 0;
        if (i8 != -1) {
            if (i8 == 17) {
                u2.l.e(null);
                throw null;
            }
            if (i8 != 35) {
                if (i8 != 842094169) {
                    throw new l5.a("Unsupported image format", 13);
                }
                u2.l.e(null);
                throw null;
            }
            Image.Plane[] planeArrA = aVar.a();
            u2.l.e(planeArrA);
            int i10 = aVar.f10663c;
            int i11 = aVar.f10664d;
            int i12 = i10 * i11;
            int i13 = i12 / 4;
            byte[] bArr = new byte[i13 + i13 + i12];
            ByteBuffer buffer = planeArrA[1].getBuffer();
            ByteBuffer buffer2 = planeArrA[2].getBuffer();
            int iPosition = buffer2.position();
            int iLimit = buffer.limit();
            buffer2.position(iPosition + 1);
            buffer.limit(iLimit - 1);
            int i14 = (i12 + i12) / 4;
            boolean z2 = buffer2.remaining() == i14 + (-2) && buffer2.compareTo(buffer) == 0;
            buffer2.position(iPosition);
            buffer.limit(iLimit);
            if (z2) {
                planeArrA[0].getBuffer().get(bArr, 0, i12);
                ByteBuffer buffer3 = planeArrA[1].getBuffer();
                planeArrA[2].getBuffer().get(bArr, i12, 1);
                buffer3.get(bArr, i12 + 1, i14 - 1);
            } else {
                b(planeArrA[0], i10, i11, bArr, 0, 1);
                b(planeArrA[1], i10, i11, bArr, i12 + 1, 2);
                b(planeArrA[2], i10, i11, bArr, i12, 2);
            }
            return ByteBuffer.wrap(bArr);
        }
        Bitmap bitmapCopy = aVar.f10661a;
        u2.l.e(bitmapCopy);
        if (bitmapCopy.getConfig() == Bitmap.Config.HARDWARE) {
            bitmapCopy = bitmapCopy.copy(Bitmap.Config.ARGB_8888, bitmapCopy.isMutable());
        }
        Bitmap bitmap = bitmapCopy;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i15 = width * height;
        int[] iArr = new int[i15];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iCeil = (int) Math.ceil(((double) height) / 2.0d);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(((iCeil + iCeil) * ((int) Math.ceil(((double) width) / 2.0d))) + i15);
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < height) {
            int i19 = i9;
            while (i19 < width) {
                int i20 = iArr[i18];
                int i21 = i20 >> 16;
                int i22 = i20 >> 8;
                int i23 = i20 & 255;
                int i24 = i17 + 1;
                int i25 = i21 & 255;
                int i26 = i22 & 255;
                byteBufferAllocateDirect.put(i17, (byte) Math.min(255, ((((i23 * 25) + ((i26 * 129) + (i25 * 66))) + 128) >> 8) + 16));
                if (i16 % 2 == 0 && i18 % 2 == 0) {
                    int i27 = ((((i25 * DeviceType.INFRARED_HEATER) - (i26 * 94)) - (i23 * 18)) + 128) >> 8;
                    int i28 = (((((i25 * (-38)) - (i26 * 74)) + (i23 * DeviceType.INFRARED_HEATER)) + 128) >> 8) + 128;
                    int i29 = i15 + 1;
                    byteBufferAllocateDirect.put(i15, (byte) Math.min(255, i27 + 128));
                    i15 += 2;
                    byteBufferAllocateDirect.put(i29, (byte) Math.min(255, i28));
                }
                i18++;
                i19++;
                i17 = i24;
            }
            i16++;
            i9 = 0;
        }
        return byteBufferAllocateDirect;
    }

    public static final void b(Image.Plane plane, int i8, int i9, byte[] bArr, int i10, int i11) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int rowStride = ((plane.getRowStride() + buffer.limit()) - 1) / plane.getRowStride();
        if (rowStride == 0) {
            return;
        }
        int i12 = i8 / (i9 / rowStride);
        int rowStride2 = 0;
        for (int i13 = 0; i13 < rowStride; i13++) {
            int pixelStride = rowStride2;
            for (int i14 = 0; i14 < i12; i14++) {
                bArr[i10] = buffer.get(pixelStride);
                i10 += i11;
                pixelStride += plane.getPixelStride();
            }
            rowStride2 += plane.getRowStride();
        }
    }
}
