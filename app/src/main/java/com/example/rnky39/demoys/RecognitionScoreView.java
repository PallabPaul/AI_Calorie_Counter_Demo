/* Copyright 2015 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.rnky39.demoys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.rnky39.demoys.Classifier.Recognition;

import java.util.List;

public class RecognitionScoreView extends View implements ResultsView {
    private static final float TEXT_SIZE_DIP = 25;
    private List<Recognition> results;
    private final float textSizePx;
    private final Paint fgPaint;
    private final Paint bgPaint;

    public RecognitionScoreView(final Context context, final AttributeSet set) {
        super(context, set);

        textSizePx =
                TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_DIP, getResources().getDisplayMetrics());
        fgPaint = new Paint();
        fgPaint.setTextSize(textSizePx);

        bgPaint = new Paint();
        bgPaint.setColor(0xFF9999a3);
    }

    @Override
    public void setResults(final List<Recognition> results) {
        this.results = results;
        postInvalidate();
    }
    public List<Recognition> getResults(){
        return this.results;
    }

    @Override
    public void onDraw(final Canvas canvas) {
        final int x = 10;
        int y = (int) (fgPaint.getTextSize() * 1.5f);

        canvas.drawPaint(bgPaint);

        if (results != null) {
            for (final Recognition recog : results) {

                if (recog.getTitle().equals("apple")) {
                    String calories = "95";

                    canvas.drawText("This " + recog.getTitle() + " has " + calories + " calories",/*": " + recog.getConfidence(),*/ x, y, fgPaint);
                    y += fgPaint.getTextSize() * 1.5f;
                }

                if (recog.getTitle().equals("banana")) {
                    String calories = "30";

                    canvas.drawText("This " + recog.getTitle() + " has " + calories + " calories",/*": " + recog.getConfidence(),*/ x, y, fgPaint);
                    y += fgPaint.getTextSize() * 1.5f;
                }

                if (recog.getTitle().equals("water bottle")) {
                    String calories = "0";

                    canvas.drawText("This " + recog.getTitle() + " has " + calories + " calories",/*": " + recog.getConfidence(),*/ x, y, fgPaint);
                    y += fgPaint.getTextSize() * 1.5f;
                }

                if (recog.getTitle().equals("broccoli")) {
                    String calories = "40";

                    canvas.drawText("This " + recog.getTitle() + " has " + calories + " calories",/*": " + recog.getConfidence(),*/ x, y, fgPaint);
                    y += fgPaint.getTextSize() * 1.5f;
                }

                if (recog.getTitle().equals("chips")) {
                    String calories = "120";

                    canvas.drawText("This " + recog.getTitle() + " has " + calories + " calories",/*": " + recog.getConfidence(),*/ x, y, fgPaint);
                    y += fgPaint.getTextSize() * 1.5f;
                }

                if (recog.getTitle().equals("cookies")) {
                    String calories = "150";

                    canvas.drawText("This " + recog.getTitle() + " has " + calories + " calories",/*": " + recog.getConfidence(),*/ x, y, fgPaint);
                    y += fgPaint.getTextSize() * 1.5f;
                }

                if (recog.getTitle().equals("pizza")) {
                    String calories = "200";

                    canvas.drawText("This " + recog.getTitle() + " has " + calories + " calories",/*": " + recog.getConfidence(),*/ x, y, fgPaint);
                    y += fgPaint.getTextSize() * 1.5f;
                }

                if (recog.getTitle().equals("soda can")) {
                    String calories = "80";

                    canvas.drawText("This " + recog.getTitle() + " has " + calories + " calories",/*": " + recog.getConfidence(),*/ x, y, fgPaint);
                    y += fgPaint.getTextSize() * 1.5f;
                }
            }
        }
    }
}