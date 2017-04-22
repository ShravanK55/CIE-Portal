package com.example.shravan.cieattportal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TeacherStudentDetailsPage extends Fragment {
    Button updateButton, uploadButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View studentDetailsPageView = inflater.inflate(R.layout.fragment_teacher_student_details, container, false);
        return studentDetailsPageView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        updateButton = (Button) getActivity().findViewById(R.id.teacherUpdateDetailsButton);
        uploadButton = (Button) getActivity().findViewById(R.id.teacherUploadDetailsButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add update details functionality.
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add update details functionality.
            }
        });
    }
}
