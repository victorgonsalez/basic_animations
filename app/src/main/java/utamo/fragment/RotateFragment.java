package utamo.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import utamo.custom_transition.Rotate;


public class RotateFragment extends Fragment {

    private boolean mIsRotated;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rotate, container, false);

        final ViewGroup transitionsContainer = (ViewGroup) view.findViewById(R.id.transitions_container);
        final View icon = transitionsContainer.findViewById(R.id.icon);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(transitionsContainer, new Rotate());
                mIsRotated = !mIsRotated;
                icon.setRotation(mIsRotated ? 165 : 0);
            }
        });

        return view;
    }
}
