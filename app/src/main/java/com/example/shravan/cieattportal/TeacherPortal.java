package com.example.shravan.cieattportal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class TeacherPortal extends AppCompatActivity {
    enum PortalState { HOME, TESTS, ATTENDANCE, DETAILS, SETTINGS };
    PortalState portalState;

    FrameLayout homeContainer, marksContainer, attendanceContainer, studentDetailsContainer, settingsContainer, logoutContainer;
    ImageButton homeButton, marksButton, attendanceButton, studentDetailsButton, settingsButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_portal);

        Bundle teacherInfo = new Bundle();
        teacherInfo.putString("teacher_name_key", getIntent().getStringExtra("teacher_name_key"));
        Fragment homePage = new TeacherHomePage();
        homePage.setArguments(teacherInfo);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.teacherContentView, homePage);
        transaction.commit();

        homeButton = (ImageButton) findViewById(R.id.teacherHomeButton);
        marksButton = (ImageButton) findViewById(R.id.teacherMarksButton);
        attendanceButton = (ImageButton) findViewById(R.id.teacherAttButton);
        studentDetailsButton = (ImageButton) findViewById(R.id.teacherDetailsButton);
        settingsButton = (ImageButton) findViewById(R.id.teacherSettingsButton);
        logoutButton = (ImageButton) findViewById(R.id.teacherLogoutButton);

        homeContainer = (FrameLayout) findViewById(R.id.teacherHomeContainer);
        marksContainer = (FrameLayout) findViewById(R.id.teacherMarksContainer);
        attendanceContainer = (FrameLayout) findViewById(R.id.teacherAttContainer);
        studentDetailsContainer = (FrameLayout) findViewById(R.id.teacherDetailsContainer);
        settingsContainer = (FrameLayout) findViewById(R.id.teacherSettingsContainer);
        logoutContainer = (FrameLayout) findViewById(R.id.teacherLogoutContainer);

        homeButton.setOnClickListener(new HomeButtonListener());
        marksButton.setOnClickListener(new MarksButtonListener());
        attendanceButton.setOnClickListener(new AttendanceButtonListener());
        studentDetailsButton.setOnClickListener(new DetailsButtonListener());
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

    class MarksButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ToMarksPage();
        }
    }

    class AttendanceButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ToAttendancePage();
        }
    }

    class DetailsButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) { ToDetailsPage(); }
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
            Bundle teacherInfo = new Bundle();
            teacherInfo.putString("teacher_name_key", getIntent().getStringExtra("teacher_name_key"));
            Fragment homePage = new TeacherHomePage();
            homePage.setArguments(teacherInfo);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.teacherContentView, homePage);
            transaction.commit();

            UnhighlightButton();

            portalState = PortalState.HOME;
            homeContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
        }
    }

    public void ToMarksPage() {
        if (portalState != PortalState.TESTS) {
            Fragment marksPage = new TeacherMarksPage();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.teacherContentView, marksPage);
            transaction.commit();

            UnhighlightButton();

            portalState = PortalState.TESTS;
            marksContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
        }
    }

    public void ToAttendancePage() {
        if (portalState != PortalState.ATTENDANCE) {
            Fragment attendancePage = new TeacherAttendancePage();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.teacherContentView, attendancePage);
            transaction.commit();

            UnhighlightButton();

            portalState = PortalState.ATTENDANCE;
            attendanceContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
        }
    }

    public void ToDetailsPage() {
        if (portalState != PortalState.DETAILS) {
            Fragment detailsPage = new TeacherStudentDetailsPage();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.teacherContentView, detailsPage);
            transaction.commit();

            UnhighlightButton();

            portalState = PortalState.DETAILS;
            studentDetailsContainer.setBackgroundColor(getResources().getColor(R.color.highlightedBg));
        }
    }

    public void ToSettingsPage() {
        if (portalState != PortalState.SETTINGS) {
            Fragment settingsPage = new TeacherSettingsPage();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.teacherContentView, settingsPage);
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
                marksContainer.setBackgroundColor(getResources().getColor(R.color.transparentBg));
                break;
            case DETAILS:
                studentDetailsContainer.setBackgroundColor(getResources().getColor(R.color.transparentBg));
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
