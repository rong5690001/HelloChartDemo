package com.rong.map.recyclerviewitemtouchhelper;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.rong.map.linechartview.*;
import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    private LineChartView mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        initView();
        setData2();
    }

    private void initView() {
        mChart = (LineChartView) findViewById(R.id.chart);
        mChart.setInteractive(true);
        mChart.setZoomEnabled(false);
//        mChart.setMaxZoom(1.5f);
        mChart.setScrollEnabled(true);
        mChart.setValueSelectionEnabled(true);
        Viewport v = new Viewport(mChart.getMaximumViewport());
        v.left = 0;
        v.right = 24;
        v.bottom = 25;
        v.top = 100;
        mChart.setMaximumViewport(v);
        mChart.setCurrentViewport(v);
        mChart.setViewportCalculationEnabled(false);//注意要固定坐標，這個一定要設置
    }

    private void setData2() {
//        String[] x = new String[] {"1/2\n2016","1/2","1/2","1/2","1/2","1/2"};
        String[] y = new String[]{"48", "49", "50"};
        final List<PointValue> values = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            values.add(new PointValue(i, 0));
        }

//        values.add(new PointValue(1f, 3f));
//        values.add(new PointValue(2f, 3f));
//        values.add(new PointValue(3f, 1f));
//        values.add(new PointValue(4f, 3f));
        Line line = new Line(values).setColor(Color.parseColor("#f9c614")).setCubic(true);
        line.setFilled(true);//区域填充
        line.setPointRadius(3);
        line.setHasGradientToTransparent(true);//渐变
        line.setPointColor(Color.parseColor("#f9c614"));
//        line.setPathEffect();
        line.setStrokeWidth(2);
        line.setHasLabels(true);
        List<Line> lines = new ArrayList<>();
        lines.add(line);
        data = new LineChartData();
//        data.setBaseValue(48);
        data.setValueLabelBackgroundColor(Color.TRANSPARENT);
        data.setLines(lines);
//        List<AxisValue> axisValuesX = new ArrayList<>();
//        for (int i = 0; i < values.size(); i++) {
//            AxisValue axisValue = new AxisValue(i);
////            axisValue.setLabel("1/" + i);
//            axisValuesX.add(axisValue);
//        }
        Axis axisBottom = new Axis();
        data.setAxisXBottom(axisBottom);
//        List<AxisValue> axisValuesY = new ArrayList<>();
//        for (int i = 0; i < values.size(); i++) {
//            AxisValue axisValue = new AxisValue(i * 10);
////            axisValue.setLabel(y[i]);
//            axisValuesY.add(axisValue);
//        }
        Axis axisY = Axis.generateAxisFromRange(20f, 100f, 10f)
//        Axis axisY = new Axis(axisValuesY)
                .setHasLines(true)
                .setPathEffect(new DashPathEffect(new float[] { 8, 10, 8, 10}, 20));
//                .setHasSeparationLine(true);
        data.setAxisYLeft(axisY);
        mChart.setLineChartData(data);

        prepareDataAnimation();
        mChart.startDataAnimation(1000);
//                        mChart.setZoomLevel(24, values.get(24).getY(), 2);
//                        mChart.setZoomType(ZoomType.HORIZONTAL);
        Viewport v = new Viewport(mChart.getMaximumViewport());
        v.left = 16;
        v.right = 24;
        v.bottom = 25;
        v.top = 100;
//                        mChart.setMaximumViewport(v);
        mChart.setCurrentViewport(v);

    }

    LineChartData data;
    List<PointValue> values;

    private void setData() {
        values = new ArrayList<PointValue>();
        values.add(new PointValue(0f, 48.1f));
//        values.add(new PointValue(1f, 49.3f));
        values.add(new PointValue(2f, 48.3f));
//        values.add(new PointValue(3f, 47.1f));
        values.add(new PointValue(4f, 48.1f));
//        values.add(new PointValue(5f, 46.1f));
//        values.add(new PointValue(6f, 45.1f));
//        values.add(new PointValue(7f, 46.1f));
        values.add(new PointValue(8f, 48.1f));
//        values.add(new PointValue(9f, 45.1f));
//        values.add(new PointValue(10f, 46.1f));
//        values.add(new PointValue(11f, 49.1f));
        values.add(new PointValue(12f, 48.1f));
//        values.add(new PointValue(13f, 49.3f));
//        values.add(new PointValue(14f, 48.3f));
//        values.add(new PointValue(15f, 47.1f));
        values.add(new PointValue(16f, 48.1f));
//        values.add(new PointValue(17f, 46.1f));
//        values.add(new PointValue(18f, 45.1f));
        values.add(new PointValue(19f, 46.1f));
//        values.add(new PointValue(20f, 48.1f));
//        values.add(new PointValue(21f, 45.1f));
//        values.add(new PointValue(22f, 46.1f));
        values.add(new PointValue(23f, 49.1f));

        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line = new Line(values).setColor(Color.parseColor("#f9c614")).setCubic(true);
        line.setFilled(true);//区域填充
        line.setPointRadius(3);
//        line.setHasGradientToTransparent();//渐变
        line.setPointColor(Color.parseColor("#f9c614"));
//        line.setPathEffect();
        line.setStrokeWidth(2);
        List<Line> lines = new ArrayList<>();
        lines.add(line);

        data = new LineChartData();
//        data.setBaseValue(48);
        data.setLines(lines);

        List<Float> axisValues = new ArrayList<>();
        axisValues.add(0f);
        axisValues.add(1f);
        axisValues.add(2f);
        axisValues.add(3f);
        axisValues.add(4f);
        axisValues.add(5f);
        axisValues.add(6f);
        axisValues.add(7f);
        List<String> axisValuesLabels = new ArrayList<>();
        axisValuesLabels.add("2/5");
        axisValuesLabels.add("3/30");
        axisValuesLabels.add("4/5");
        axisValuesLabels.add("5/5");
        axisValuesLabels.add("6/5");
        axisValuesLabels.add("7/5");
        axisValuesLabels.add("8/5");
        axisValuesLabels.add("9/5");
        List<AxisValue> axisAutoValues = new ArrayList<>();
        for (int i = 0; i < axisValues.size(); i++) {
            AxisValue axisValue = new AxisValue(i);
            axisValue.setLabel(axisValuesLabels.get(i));
            axisAutoValues.add(axisValue);
        }
//        Axis axisBottom = Axis.generateAxisFromCollection(axisValues, axisValuesLabels);
        Axis axisBottom = new Axis();
        axisBottom.setValues(axisAutoValues);
//        axisBottom.setAutoGenerated(true);
//        axisBottom.setLineColor(Color.parseColor("#d8d8d8"));
//        axisBottom.setMaxLabelChars(7);
//        axisBottom.setHasLines(true);
//        axisBottom.setHasTiltedLabels(true);
        axisBottom.setLineColor(Color.parseColor("#e7e7e7"));
        data.setAxisXBottom(axisBottom);
//        Axis axisLeft = Axis.generateAxisFromRange(40f, 51f, 1f);
        Axis axisLeft = new Axis();
        axisLeft.setAutoGenerated(true);
//        List<AxisValue> axisValuesLeft = new ArrayList<>();
//        axisValuesLeft.add(new AxisValue(0f));
//        axisValuesLeft.add(new AxisValue(48f));
//        axisValuesLeft.add(new AxisValue(49f));
//        axisValuesLeft.add(new AxisValue(50f));
//        axisLeft.setValues(axisValuesLeft);
        axisLeft.setHasLines(true);
        data.setAxisYLeft(axisLeft);

//        LineChartView chart = new LineChartView(this);
//        mChart.startDataAnimation(2000);
        mChart.setLineChartData(data);
//        mChart.setValueTouchEnabled(false);
    }
    private void prepareDataAnimation() {
        int i = 0;
        for (Line line : data.getLines()) {
            for (PointValue value : line.getValues()) {
                // Here I modify target only for Y values but it is OK to modify X targets as well.
                float y = (float) Math.random() * 100;
                y = Math.max(y, 30f);
                value.setTarget(value.getX(), y);
//                value.setLabel(String.valueOf(y));
                value.setLabel(String.valueOf(value.getX()));
                i++;
            }
        }
    }
}
