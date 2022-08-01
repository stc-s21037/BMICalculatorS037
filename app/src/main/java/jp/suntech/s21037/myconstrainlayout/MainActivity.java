package jp.suntech.s21037.myconstrainlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btKeisan = findViewById(R.id.btKeisan);
        Button btCear=findViewById(R.id.btClear);
        HelloListener listener = new HelloListener();
        ButtonClearListener clearlistener = new ButtonClearListener();
        btKeisan.setOnClickListener(listener);
        btCear.setOnClickListener(clearlistener);
    }

    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            EditText old =findViewById(R.id.et_old);
            EditText height =findViewById(R.id.etHeight);
            EditText weight =findViewById(R.id.etWeight);
            TextView inputcomment =findViewById(R.id.tvAnatano);
            TextView Taijyu =findViewById(R.id.tvTaijyu);
            TextView Kg =findViewById(R.id.tvKg);
            TextView kg =findViewById(R.id.tvkg);
            TextView tekisei =findViewById(R.id.tvTekisei);
            tekisei.setText("あなたの適正体重は");
            kg.setText("kg");
            inputcomment.setText("あなたの肥満度は");
            String height_st=height.getText().toString();
            String weight_st=weight.getText().toString();
            String old_st=old.getText().toString();


            double old_double=Float.parseFloat(old_st);
            double height_double=Float.parseFloat(height_st);
            double wegith_double=Float.parseFloat(weight_st);

            double BMI;

            if(old_double<6){
                BMI=10*(wegith_double*1000)/(height_double*height_double);
            }else if(old_double<16){
                BMI=(wegith_double)/(height_double*height_double*height_double)*10000000;
            }else {
                BMI = wegith_double / ((height_double / 100) * (height_double / 100));
            }

            double tekiseitaijyu;

            if(old_double<6||old_double>=16) {
                if (BMI < 18.5) {
                    Taijyu.setText("低体重");
                    Taijyu.setTextColor(Color.parseColor("#0000ff"));

                } else if (BMI < 25) {
                    Taijyu.setText("普通体重");
                    Taijyu.setTextColor(Color.parseColor("#7fff00"));
                } else if (BMI < 30) {
                    Taijyu.setText("肥満（１度）");
                    Taijyu.setTextColor(Color.parseColor("#f5deb3"));
                } else if (BMI < 35) {
                    Taijyu.setText("肥満（２度）");
                    Taijyu.setTextColor(Color.parseColor(
                            "#ffd700"));
                } else if (BMI < 40) {
                    Taijyu.setText("肥満（３度）");
                    Taijyu.setTextColor(Color.parseColor("#ff8c00"));
                } else {
                    Taijyu.setText("肥満(４度）");
                    Taijyu.setTextColor(Color.parseColor("#ff0000"));
                }


                tekiseitaijyu = 22 * ((height_double / 100) * (height_double / 100));
                Kg.setText(String.format("%.1f",tekiseitaijyu));
            }else{

                if (BMI < 115) {
                    Taijyu.setText("低体重");
                    Taijyu.setTextColor(Color.parseColor("#0000ff"));
                } else if (BMI < 135) {
                    Taijyu.setText("普通体重");
                    Taijyu.setTextColor(Color.parseColor("#7fff00"));
                } else if (BMI < 145) {
                    Taijyu.setText("肥満（１度）");
                    Taijyu.setTextColor(Color.parseColor("#f5deb3"));
                } else if (BMI < 155) {
                    Taijyu.setText("肥満（２度）");
                    Taijyu.setTextColor(Color.parseColor(
                            "#ffd700"));
                } else if (BMI < 160) {
                    Taijyu.setText("肥満（３度）");
                    Taijyu.setTextColor(Color.parseColor("#ff8c00"));
                } else {
                    Taijyu.setText("肥満(４度）");
                    Taijyu.setTextColor(Color.parseColor("#ff0000"));
                }
                tekiseitaijyu=130*(height_double*height_double*height_double)/10000000;
                Kg.setText(String.format("(ローレル)%.1f",tekiseitaijyu));
            }


                if(old_double<16){
                      OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                      dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                }
                 }
        }


    private class ButtonClearListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            TextView inputcomment =findViewById(R.id.tvAnatano);
            TextView Taijyu =findViewById(R.id.tvTaijyu);
            TextView Kg =findViewById(R.id.tvKg);
            TextView kg =findViewById(R.id.tvkg);
            TextView tekisei =findViewById(R.id.tvTekisei);
            EditText old =findViewById(R.id.et_old);
            EditText height =findViewById(R.id.etHeight);
            EditText weight =findViewById(R.id.etWeight);
            old.setText("");
            inputcomment.setText("");
            height.setText("");
            weight.setText("");
            Taijyu.setText("");
            Kg.setText("");
            kg.setText("");
            tekisei.setText("");

        }
    }
    }





