package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import b.a;
import in.n;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kn.l0;
import kn.w;
import lm.a1;
import lm.i0;
import lm.k;
import lm.t0;
import nm.c1;
import nm.d1;
import nm.h0;
import nm.k0;
import nm.r;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultContracts {

    @RequiresApi(33)
    public static final class Api33Impl {

        @l
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @DoNotInline
        public final int getPickImagesMaxLimit() {
            return MediaStore.getPickImagesMaxLimit();
        }
    }

    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@l Context context, @l Uri uri) {
            l0.p(context, "context");
            l0.p(uri, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l Uri uri) {
            l0.p(context, "context");
            l0.p(uri, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            l0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Boolean parseResult(int i10, @m Intent intent) {
            return Boolean.valueOf(i10 == -1);
        }
    }

    @RequiresApi(19)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {

        @l
        private final String mimeType;

        public CreateDocument(@l String str) {
            l0.p(str, "mimeType");
            this.mimeType = str;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@l Context context, @l String str) {
            l0.p(context, "context");
            l0.p(str, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l String str) {
            l0.p(context, "context");
            l0.p(str, "input");
            Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", str);
            l0.o(intentPutExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return intentPutExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final Uri parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @k(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @a1(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }
    }

    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@l Context context, @l String str) {
            l0.p(context, "context");
            l0.p(str, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l String str) {
            l0.p(context, "context");
            l0.p(str, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
            l0.o(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final Uri parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(18)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {

        @l
        public static final Companion Companion = new Companion(null);

        @RequiresApi(18)
        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @l
            public final List<Uri> getClipDataUris$activity_release(@l Intent intent) {
                l0.p(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return k0.INSTANCE;
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i10 = 0; i10 < itemCount; i10++) {
                        Uri uri = clipData.getItemAt(i10).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@l Context context, @l String str) {
            l0.p(context, "context");
            l0.p(str, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l String str) {
            l0.p(context, "context");
            l0.p(str, "input");
            Intent intentPutExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            l0.o(intentPutExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final List<Uri> parseResult(int i10, @m Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i10 != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = Companion.getClipDataUris$activity_release(intent)) == null) ? k0.INSTANCE : clipDataUris$activity_release;
        }
    }

    @RequiresApi(19)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@l Context context, @l String[] strArr) {
            l0.p(context, "context");
            l0.p(strArr, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l String[] strArr) {
            l0.p(context, "context");
            l0.p(strArr, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
            l0.o(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final Uri parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@l Context context, @m Uri uri) {
            l0.p(context, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @m Uri uri) {
            l0.p(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final Uri parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@l Context context, @l String[] strArr) {
            l0.p(context, "context");
            l0.p(strArr, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l String[] strArr) {
            l0.p(context, "context");
            l0.p(strArr, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            l0.o(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final List<Uri> parseResult(int i10, @m Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i10 != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) == null) ? k0.INSTANCE : clipDataUris$activity_release;
        }
    }

    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public Intent createIntent(@l Context context, @m Void r10) {
            l0.p(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            l0.o(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public Uri parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {

        @l
        public static final Companion Companion = new Companion(null);
        private final int maxItems;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            public final int getMaxItems$activity_release() {
                if (!PickVisualMedia.Companion.isPhotoPickerAvailable() || Build.VERSION.SDK_INT < 33) {
                    return Integer.MAX_VALUE;
                }
                return Api33Impl.INSTANCE.getPickImagesMaxLimit();
            }

            private Companion() {
            }
        }

        public PickMultipleVisualMedia() {
            this(0, 1, null);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@l Context context, @l PickVisualMediaRequest pickVisualMediaRequest) {
            l0.p(context, "context");
            l0.p(pickVisualMediaRequest, "input");
            return null;
        }

        public /* synthetic */ PickMultipleVisualMedia(int i10, int i11, w wVar) {
            this((i11 & 1) != 0 ? Companion.getMaxItems$activity_release() : i10);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l PickVisualMediaRequest pickVisualMediaRequest) {
            Intent intent;
            l0.p(context, "context");
            l0.p(pickVisualMediaRequest, "input");
            PickVisualMedia.Companion companion = PickVisualMedia.Companion;
            if (companion.isPhotoPickerAvailable()) {
                intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (Build.VERSION.SDK_INT >= 33 && this.maxItems > Api33Impl.INSTANCE.getPickImagesMaxLimit()) {
                    throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()");
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
            } else {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (intent.getType() == null) {
                    intent.setType("*/*");
                    intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final List<Uri> parseResult(int i10, @m Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i10 != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) == null) ? k0.INSTANCE : clipDataUris$activity_release;
        }

        public PickMultipleVisualMedia(int i10) {
            this.maxItems = i10;
            if (i10 <= 1) {
                throw new IllegalArgumentException("Max items must be higher than 1");
            }
        }
    }

    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {

        @l
        public static final Companion Companion = new Companion(null);

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @m
            public final String getVisualMimeType$activity_release(@l VisualMediaType visualMediaType) {
                l0.p(visualMediaType, "input");
                if (visualMediaType instanceof ImageOnly) {
                    return "image/*";
                }
                if (visualMediaType instanceof VideoOnly) {
                    return "video/*";
                }
                if (visualMediaType instanceof SingleMimeType) {
                    return ((SingleMimeType) visualMediaType).getMimeType();
                }
                if (visualMediaType instanceof ImageAndVideo) {
                    return null;
                }
                throw new i0();
            }

            @n
            @a({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable() {
                return Build.VERSION.SDK_INT >= 33 || SdkExtensions.getExtensionVersion(30) >= 2;
            }

            private Companion() {
            }
        }

        public static final class ImageAndVideo implements VisualMediaType {

            @l
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        public static final class ImageOnly implements VisualMediaType {

            @l
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        public static final class SingleMimeType implements VisualMediaType {

            @l
            private final String mimeType;

            public SingleMimeType(@l String str) {
                l0.p(str, "mimeType");
                this.mimeType = str;
            }

            @l
            public final String getMimeType() {
                return this.mimeType;
            }
        }

        public static final class VideoOnly implements VisualMediaType {

            @l
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        public interface VisualMediaType {
        }

        @n
        @a({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@l Context context, @l PickVisualMediaRequest pickVisualMediaRequest) {
            l0.p(context, "context");
            l0.p(pickVisualMediaRequest, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l PickVisualMediaRequest pickVisualMediaRequest) {
            l0.p(context, "context");
            l0.p(pickVisualMediaRequest, "input");
            Companion companion = Companion;
            if (companion.isPhotoPickerAvailable()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                return intent;
            }
            Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
            if (intent2.getType() != null) {
                return intent2;
            }
            intent2.setType("*/*");
            intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return intent2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final Uri parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {

        @l
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";

        @l
        public static final Companion Companion = new Companion(null);

        @l
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";

        @l
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @l
            public final Intent createIntent$activity_release(@l String[] strArr) {
                l0.p(strArr, "input");
                Intent intentPutExtra = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr);
                l0.o(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intentPutExtra;
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public Intent createIntent(@l Context context, @l String[] strArr) {
            l0.p(context, "context");
            l0.p(strArr, "input");
            return Companion.createIntent$activity_release(strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(@l Context context, @l String[] strArr) {
            l0.p(context, "context");
            l0.p(strArr, "input");
            if (strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(d1.z());
            }
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return null;
                }
            }
            int iJ = c1.j(strArr.length);
            if (iJ < 16) {
                iJ = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
            for (String str2 : strArr) {
                t0 t0Var = new t0(str2, Boolean.TRUE);
                linkedHashMap.put(t0Var.getFirst(), t0Var.getSecond());
            }
            return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public Map<String, Boolean> parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                return d1.z();
            }
            if (intent == null) {
                return d1.z();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return d1.z();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i11 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i11 == 0));
            }
            return d1.D0(h0.i6(r.Ta(stringArrayExtra), arrayList));
        }
    }

    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public Intent createIntent(@l Context context, @l String str) {
            l0.p(context, "context");
            l0.p(str, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{str});
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@l Context context, @l String str) {
            l0.p(context, "context");
            l0.p(str, "input");
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public Boolean parseResult(int i10, @m Intent intent) {
            if (intent == null || i10 != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            boolean z10 = false;
            if (intArrayExtra != null) {
                for (int i11 : intArrayExtra) {
                    if (i11 == 0) {
                        z10 = true;
                        break;
                    }
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public Intent createIntent(@l Context context, @l Intent intent) {
            l0.p(context, "context");
            l0.p(intent, "input");
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public ActivityResult parseResult(int i10, @m Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {

        @l
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";

        @l
        public static final Companion Companion = new Companion(null);

        @l
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";

        @l
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public Intent createIntent(@l Context context, @l IntentSenderRequest intentSenderRequest) {
            l0.p(context, "context");
            l0.p(intentSenderRequest, "input");
            Intent intentPutExtra = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            l0.o(intentPutExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return intentPutExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public ActivityResult parseResult(int i10, @m Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@l Context context, @l Uri uri) {
            l0.p(context, "context");
            l0.p(uri, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l Uri uri) {
            l0.p(context, "context");
            l0.p(uri, "input");
            Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
            l0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Boolean parseResult(int i10, @m Intent intent) {
            return Boolean.valueOf(i10 == -1);
        }
    }

    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@l Context context, @m Void r10) {
            l0.p(context, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @m Void r10) {
            l0.p(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final Bitmap parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @k(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@l Context context, @l Uri uri) {
            l0.p(context, "context");
            l0.p(uri, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @CallSuper
        @l
        public Intent createIntent(@l Context context, @l Uri uri) {
            l0.p(context, "context");
            l0.p(uri, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            l0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @m
        public final Bitmap parseResult(int i10, @m Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    private ActivityResultContracts() {
    }
}
