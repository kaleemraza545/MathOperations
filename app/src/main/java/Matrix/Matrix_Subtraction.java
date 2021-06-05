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
public class Matrix_Subtraction extends Fragment {

    public Matrix_Subtraction() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matrix__subtraction, container, false);
    }
}
