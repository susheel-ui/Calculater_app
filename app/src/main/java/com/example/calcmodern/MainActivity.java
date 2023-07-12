package com.example.calcmodern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.example.calcmodern.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    View.OnClickListener btnclicklistner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                Button btn = (Button) v;
                String btntxt = btn.getText().toString();
                String datatocalculate =binding.textBase.getText().toString();
                if(btntxt.equals("AC")){
                    binding.textBase.setText("");
                    return;
                }
                else if(btntxt.equals("C")){
                    if(datatocalculate.length()>0)
                       datatocalculate = datatocalculate.substring(0,datatocalculate.length()-1);

                }
                else if (btntxt.equals("=")){
                   String result = getresult(datatocalculate);
                   if(result.endsWith(".0")){
                      result = result.substring(0,result.length()-2);

                   }
                   String temp = binding.textBase.getText().toString();

                    binding.textTop.setText(temp);
                    binding.textBase.setText(result);
                    return;
                }else{
                    datatocalculate += btntxt;
                }

               binding.textBase.setText(datatocalculate);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAC.setOnClickListener(btnclicklistner);
        binding.btnC.setOnClickListener(btnclicklistner);
        binding.btnAddition.setOnClickListener(btnclicklistner);
        binding.btnsubstact.setOnClickListener(btnclicklistner);
        binding.btnMultiply.setOnClickListener(btnclicklistner);
        binding.btnDivid.setOnClickListener(btnclicklistner);
        binding.btnEqual.setOnClickListener(btnclicklistner);
        binding.btnPercentage.setOnClickListener(btnclicklistner);
        binding.btnOne.setOnClickListener(btnclicklistner);
        binding.btnTwo.setOnClickListener(btnclicklistner);
        binding.btnThree.setOnClickListener(btnclicklistner);
        binding.btnFour.setOnClickListener(btnclicklistner);
        binding.btnFive.setOnClickListener(btnclicklistner);
        binding.btnSix.setOnClickListener(btnclicklistner);
        binding.btnSeven.setOnClickListener(btnclicklistner);
        binding.btnEight.setOnClickListener(btnclicklistner);
        binding.btnNine.setOnClickListener(btnclicklistner);
        binding.btnZero.setOnClickListener(btnclicklistner);
        binding.btnDecimal.setOnClickListener(btnclicklistner);


    }

    public String getresult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
           String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
           return finalResult;
        }catch (Exception e){
            return "Err";
        }


    }

}