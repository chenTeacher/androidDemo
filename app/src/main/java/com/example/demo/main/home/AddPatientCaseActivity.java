package com.example.demo.main.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.Calendar;

import cn.addapp.pickers.listeners.OnItemPickListener;
import cn.addapp.pickers.listeners.OnSingleWheelListener;
import cn.addapp.pickers.picker.DatePicker;
import cn.addapp.pickers.picker.SinglePicker;

/**
 * 添加患者信息Activity
 */
public class AddPatientCaseActivity extends Activity implements View.OnClickListener{
    private ImageButton close_button;
    private Button add_case_patient_doctor;
    private Button add_case_patient_start;
    private Button add_case_patient_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_case_patient);
        initView();
    }
    private void initView(){
        close_button = (ImageButton) findViewById(R.id.close_btn);
        add_case_patient_doctor = (Button) findViewById(R.id.add_case_patient_doctor);
        add_case_patient_start = (Button) findViewById(R.id.add_case_patient_state);
        add_case_patient_time = (Button) findViewById(R.id.add_case_patient_time);
        close_button.setOnClickListener(this);
        add_case_patient_doctor.setOnClickListener(this);
        add_case_patient_start.setOnClickListener(this);
        add_case_patient_time.setOnClickListener(this);
    }
    private void closeActivty(){
        finish();
    }
    private void add_case_patient_time(){
        Calendar calendar = Calendar.getInstance();
        final DatePicker picker = new DatePicker(this);
        picker.setCanLoop(false);
        picker.setWheelModeEnable(true);
        picker.setTopPadding(15);
        picker.setRangeStart(1900, 1, 1);
        picker.setRangeEnd(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
        picker.setSelectedItem(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
        picker.setWeightEnable(true);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                add_case_patient_time.setText(year+"-"+month+"-"+day);
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.show();
    }
    private void add_case_patient_start(){
        ArrayList<String> list = new ArrayList<>();
        list.add("首次面诊");
        list.add("复诊");
        list.add("住院");
        list.add("出院");
        list.add("回访");
        SinglePicker<String> picker = new SinglePicker<>(this, list);
        picker.setCanLoop(false);//不禁用循环
        picker.setLineVisible(true);
        picker.setShadowVisible(true);
        picker.setTextSize(18);
        picker.setSelectedIndex(0);
        picker.setWheelModeEnable(true);
        //启用权重 setWeightWidth 才起作用
        picker.setLabel("");
        picker.setWeightEnable(true);
        picker.setWeightWidth(1);
        picker.setSelectedTextColor(0xFF279BAA);//前四位值是透明度
        picker.setUnSelectedTextColor(0xFF999999);
        picker.setOnSingleWheelListener(new OnSingleWheelListener() {
            @Override
            public void onWheeled(int index, String item) {
            }
        });
        picker.setOnItemPickListener(new OnItemPickListener<String>() {
            @Override
            public void onItemPicked(int index, String item) {
                add_case_patient_start.setText(item);
            }
        });
        picker.show();
    }
    private void add_case_patient_doctor(){
        ArrayList<String> list = new ArrayList<>();
        list.add("王医师");
        list.add("李医师");
        SinglePicker<String> picker = new SinglePicker<>(this, list);
        picker.setCanLoop(false);//不禁用循环
        picker.setLineVisible(true);
        picker.setShadowVisible(true);
        picker.setTextSize(18);
        picker.setSelectedIndex(0);
        picker.setWheelModeEnable(true);
        //启用权重 setWeightWidth 才起作用
        picker.setLabel("");
        picker.setWeightEnable(true);
        picker.setWeightWidth(1);
        picker.setSelectedTextColor(0xFF279BAA);//前四位值是透明度
        picker.setUnSelectedTextColor(0xFF999999);
        picker.setOnSingleWheelListener(new OnSingleWheelListener() {
            @Override
            public void onWheeled(int index, String item) {
            }
        });
        picker.setOnItemPickListener(new OnItemPickListener<String>() {
            @Override
            public void onItemPicked(int index, String item) {
                add_case_patient_doctor.setText(item);
            }
        });
        picker.show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close_btn:
                closeActivty();
                break;
            case R.id.add_case_patient_doctor:
                add_case_patient_doctor();
                break;
            case R.id.add_case_patient_state:
                add_case_patient_start();
                break;
            case R.id.add_case_patient_time:
                add_case_patient_time();
                break;
        }

    }
}
