package utamo.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import utamo.fragment.ImageTransformFragment;
import utamo.fragment.InterpolatorFragment;
import utamo.fragment.ListFragment;
import utamo.fragment.R;
import utamo.fragment.RotateFragment;


public class MainActivity extends AppCompatActivity implements ListFragment.SampleListProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListFragment listFragment = new ListFragment();
        listFragment.setSampleListListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, listFragment)
                .commit();
    }

    @Override
    public void onSampleSelected(int index) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, createFragmentForPosition(index))
                .addToBackStack(String.valueOf(index))
                .commit();
    }

    @Override
    public int getSampleCount() {
        return 6;
    }

    @Override
    public String getTitleForPosition(int index) {
        switch (index) {
            case 0:
                return getString(R.string.using_interpolator_to_button);
            case 1:
                return getString(R.string.scale_image_view);
            case 2:
                return getString(R.string.rotate_image_view);
        }
        return null;
    }

    private Fragment createFragmentForPosition(int index) {
        switch (index) {
            case 0:
                return new InterpolatorFragment();
            case 1:
                return new ImageTransformFragment();
            case 2:
                return new RotateFragment();
        }
        return null;
    }
}
