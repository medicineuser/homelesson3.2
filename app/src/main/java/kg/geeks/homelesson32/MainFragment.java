package kg.geeks.homelesson32;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainFragment extends Fragment {
    private Button NextFragment;
    private Button PlusNumber;
    private Button MinusNumber;
    private TextView TextViewNum;

    int num;
    String s;
    int value;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private void initListener(){

        NextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SecondFragment()).commit();
            }
        });

        MinusNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value-=1;
                s = String.valueOf(value);
                TextViewNum.setText(s);
            }
        });

        PlusNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                value+=1;
                s = String.valueOf(value);
                TextViewNum.setText(s);
            }
        });
    }

    private void initView(){
        NextFragment = requireActivity().findViewById(R.id.btn_changeView);
        PlusNumber = requireActivity().findViewById(R.id.plus_number);
        TextViewNum = requireActivity().findViewById(R.id.text_view);
        MinusNumber = requireActivity().findViewById(R.id.minus_click);
    }
}