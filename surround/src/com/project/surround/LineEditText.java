package com.project.surround;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class LineEditText extends EditText {
    // ���� �������»���
    private Paint paint;

    public LineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        // ��������� �Ϻ��ڴ�
        //paint.setAntiAlias(true);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // �õ�������
        //int lineCount = getLineCount();
        int height = this.getHeight();
        // �õ�ÿ�еĸ߶�
        float lineHeight = getLineHeight() + 8.0f;
        float lineSpace = getLineSpacingExtra();
        float linePadding = lineHeight + lineSpace;
        int lineCount = (int)((float)height / linePadding);
        //Log.v("height", String.valueOf(lineHeight));
        // ��������ѭ������
        for (int i = 0; i < lineCount; i++) {
            float lineY = (i + 1) * (linePadding);
            canvas.drawLine(0, lineY, this.getWidth(), lineY, paint);
        }

    }

}
