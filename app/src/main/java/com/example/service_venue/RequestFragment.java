package com.example.service_venue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.service_venue.fragment.UpComingFragment;
import com.example.service_venue.fragment.CompletedFragment;
import com.google.android.material.tabs.TabLayout;

public class RequestFragment extends Fragment {

    private FrameLayout frameLayout;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request, container, false);

        // Initialize views
        frameLayout = view.findViewById(R.id.frame_layout);
        tabLayout = view.findViewById(R.id.tab_layout);

        // Initialize default fragment
        replaceFragment(new UpComingFragment());

        // Setup tab selection listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new UpComingFragment();
                        break;
                    case 1:
                        fragment = new CompletedFragment();
                        break;
                }
                replaceFragment(fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
