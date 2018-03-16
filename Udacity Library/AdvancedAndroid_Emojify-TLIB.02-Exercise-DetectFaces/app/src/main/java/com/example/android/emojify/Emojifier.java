package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by yasmeen on 2/28/2018.
 */

public class Emojifier {
    private static final String LOG_TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap  bitmap)
    {
        FaceDetector faceDetector = new
                FaceDetector.Builder(context).setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);
        Log.d(LOG_TAG, "detectFaces: number of faces = " + faces.size());
        if(faces.size()==0)
            Toast.makeText(context, "No Faces detected", Toast.LENGTH_SHORT).show();
        faceDetector.release();

    }
}
