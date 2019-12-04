package com.mahdizareei.mztimepicker;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdizareei.mztimepicker.interfaces.OnTimeSelectedListener;
import com.mahdizareei.mztimepicker.timePicker.TimePickerDialogFragment;
import com.mahdizareei.mztimepicker.utils.FragmentFactory;

import static com.mahdizareei.mztimepicker.utils.FragmentFactory.FragmentName.TIME_PICKER_FRAGMENT;

public class MZTimePicker {

    private Context context;
    private OnTimeSelectedListener onTimeSelectedListener;
    private TimePickerDialogFragment timePickerDialogFragment;
    private TimePickerModel timePickerModel;

    public MZTimePicker(Context context) {
        this.context = context;
        timePickerModel = new TimePickerModel();
    }

    public MZTimePicker BuildTimePicker(OnTimeSelectedListener onTimeSelected) {
        this.onTimeSelectedListener = onTimeSelected;
        FragmentFactory fragmentFactory = new FragmentFactory((AppCompatActivity) context);
        timePickerDialogFragment = (TimePickerDialogFragment) fragmentFactory.dialogFragmentBuild(TIME_PICKER_FRAGMENT, true);
        timePickerDialogFragment.setOnTimeSelectedListener(new OnTimeSelectedListener() {
            @Override
            public void onTimeSelected(String fromHour, String fromMinute, String toHour, String toMinute) {
                onTimeSelectedListener.onTimeSelected(fromHour, fromMinute, toHour, toMinute);
            }
        });
        timePickerDialogFragment.setFromTitle(timePickerModel.getFromTitle());
        timePickerDialogFragment.setToTitle(timePickerModel.getToTitle());
        timePickerDialogFragment.setConfirmText(timePickerModel.getConfirmText());
        timePickerDialogFragment.setClearText(timePickerModel.getClearText());
        timePickerDialogFragment.setTabFont(timePickerModel.getFont());

        return this;
    }

    public MZTimePicker setFromTitle(String text) {
        this.timePickerModel.setFromTitle(text);
        return this;
    }

    public MZTimePicker setToTitle(String text) {
        this.timePickerModel.setToTitle(text);
        return this;
    }

    public MZTimePicker setTabFont(String fontName) {
        this.timePickerModel.setSetFont(fontName);
        return this;
    }

    public MZTimePicker setConfirmText(String text) {
        this.timePickerModel.setConfirmText(text);
        return this;
    }

    public MZTimePicker setClearText(String text) {
        this.timePickerModel.setClearText(text);
        return this;
    }

}
