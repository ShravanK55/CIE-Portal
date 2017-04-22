package com.example.shravan.cieattportal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class StudentPortal extends AppCompatActivity {
    enum PortalState { HOME, TESTS, ATTENDANCE, SETTINGS };
    PortalState portalState;

    FrameLayout homeContainer, testsContainer, attendanceContainer, settingsContainer, logoutContainer;
    ImageButton homeButton, testsButton, attendanceButton, settingsButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal);

        Bundle studentInfo = new Bundle();
        studentInfo.putString("student_name_key", getIntent().getStringExtra("student_name_key"));
        Fragment homePage = new StudentHomePage();
        homePage.setArguments(studentInfo);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentView, homePage);
        transaction.commit();

        homeButton = (ImageButton) findViewById(R.id.homeButton);
        testsButton = (ImageButton) findViewById(R.id.marksButton);
        attendanceButton = (ImageButton) findViewById(R.id.attButton);
        settingsButton = (ImageButton) findViewById(R.id.settingsButton);
        logoutButton = (ImageButton) findViewById(R.id.logoutButton);

        homeContainer = (FrameLayout) findViewById(R.id.homeContainer);
        testsContainer = (FrameLayout) findViewById(R.id.marksContainer);
        attendanceContainer = (FrameLayout) findViewById(R.id.attContainer);
        settingsContainer = (FrameLayout) findViewById(R.id.settingsContainer);
        logoutContainer = (FrameLayout) findViewById(R.id.logoutContainer);

        homeButton.setOnClickListener(new HomeButtonListener());
        testsButton.setOnClickListener(new TestsButtonListener());
        attendanceButton.setOnClickListener(new AttendanceButtonListener());
        settingsButton.setOnClickListener(new SettingsButtonListener());
        logoutButton.setOnClickListener(new LogoutButtonListener());

        portalState = PortalState.HOME;
        homeContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
    }

    class HomeButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ToHomePage();
        }
    }

    class TestsButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ToTestsPage();
        }
    }

    class AttendanceButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ToAttendancePage();
        }
    }

    class SettingsButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ToSettingsPage();
        }
    }

    class LogoutButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    public void ToHomePage() {
        if (portalState != PortalState.HOME) {
            Bundle studentInfo = new Bundle();
            studentInfo.putString("student_name_key", getIntent().getStringExtra("student_name_key"));
            Fragment homePage = new StudentHomePage();
            homePage.setArguments(studentInfo);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentView, homePage);
            transaction.commit();

            UnhighlightButton();

            portalState = PortalState.HOME;
            homeContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
        }
    }

    public void ToTestsPage() {
        if (portalState != PortalState.TESTS) {
            Fragment testsPage = new StudentMarksPage();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentView, testsPage);
            transaction.commit();

            UnhighlightButton();

            portalState = PortalState.TESTS;
            testsContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
        }
    }

    public void ToAttendancePage() {
        if (portalState != PortalState.ATTENDANCE) {
            Fragment attendancePage = new StudentAttendancePage();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentView, attendancePage);
            transaction.commit();

            UnhighlightButton();

            portalState = PortalState.ATTENDANCE;
            attendanceContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
        }
    }

    public void ToSettingsPage() {
        if (portalState != PortalState.SETTINGS) {
            Fragment settingsPage = new StudentSettingsPage();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentView, settingsPage);
            transaction.commit();

            UnhighlightButton();

            portalState = PortalState.SETTINGS;
            settingsContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
        }
    }

    private void UnhighlightButton() {
        switch (portalState) {
            case HOME:
                homeContainer.setBackgroundColor(getResources().getColor(R.color.transparentBg));
                break;
            case TESTS:
                testsContainer.setBackgroundColor(getResources().getColor(R.color.transparentBg));
                break;
            case ATTENDANCE:
                attendanceContainer.setBackgroundColor(getResources().getColor(R.color.transparentBg));
                break;
            case SETTINGS:
                settingsContainer.setBackgroundColor(getResources().getColor(R.color.transparentBg));
                break;
        }
    }
}
