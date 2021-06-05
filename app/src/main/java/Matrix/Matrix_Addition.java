package Matrix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.mathoperations.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Matrix_Addition extends Fragment {

    public Matrix_Addition() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matrix__addition, container, false);
    }
}
