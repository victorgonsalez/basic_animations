package utamo.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;


public class InterpolatorFragment extends Fragment {
    private ViewGroup transitionsContainer = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interpolator, container, false);

        transitionsContainer = (ViewGroup) view.findViewById(R.id.transitions_container);
        final View buttonAnticipate = transitionsContainer.findViewById(R.id.buttonAnticipate);
        buttonAnticipate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTransition(v, 1);
            }
        });

        final View buttonDecelerate = transitionsContainer.findViewById(R.id.buttonDecelerate);

        buttonDecelerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTransition(v, 2);
            }
        });

        final View buttonAccelerate = transitionsContainer.findViewById(R.id.buttonAccelerate);

        buttonAccelerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTransition(v, 3);
            }
        });

        final View buttonAccelerateDecelerate = transitionsContainer.findViewById(R.id.buttonAccelerateDecelerate);

        buttonAccelerateDecelerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTransition(v, 4);
            }
        });

        final View buttonCycle = transitionsContainer.findViewById(R.id.buttonCycle);

        buttonCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTransition(v, 5);
            }
        });

        return view;
    }

    private void setTransition(View button, int interpolatorType) {

        Transition transition = new ChangeBounds();
        transition.setDuration(1000);
        switch (interpolatorType) {
            case 1:
                transition.setInterpolator(new AnticipateInterpolator());
                break;
            case 2:
                transition.setInterpolator(new DecelerateInterpolator());
                break;
            case 3:
                transition.setInterpolator(new AccelerateInterpolator());
                break;
            case 4:
                transition.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case 5:
                transition.setInterpolator(new CycleInterpolator(5));
                break;
        }
        transition.setStartDelay(100);
        TransitionManager.beginDelayedTransition(transitionsContainer, transition);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.gravity = params.gravity == (Gravity.START) ? (Gravity.END) : (Gravity.START);
        button.setLayoutParams(params);
    }
}
