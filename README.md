# MZTimePicker two timepicker for androidx

[![](https://jitpack.io/v/mahdizareeii/MZTimePicker.svg)](https://jitpack.io/#mahdizareeii/MZTimePicker)

<p align="left">
  <img src="https://raw.githubusercontent.com/mahdizareeii/MZTimePicker/master/app/src/main/res/drawable/1.PNG" width="250" title="hover text">
  <img src="https://raw.githubusercontent.com/mahdizareeii/MZTimePicker/master/app/src/main/res/drawable/2.PNG" width="250" alt="accessibility text">
</p>


	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

	dependencies {
	        implementation 'com.github.mahdizareeii:MZTimePicker:1.8'
	}
	
how to use :

    MZTimePicker mzTimePicker = new MZTimePicker(this, new OnTimeSelectedListener() {
            @Override
            public void onTimeSelected(String fromHour, String fromMinute, String toHour, String toMinute) {
                Toast.makeText(MainActivity.this, fromHour + ":" + fromMinute + "  -  " + toHour + ":" + toMinute, Toast.LENGTH_SHORT).show();
            }
        });
	
    mzTimePicker.showTimePicker();
