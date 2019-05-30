package com.example.calc;

import android.support.v4.math.MathUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView textView;
    String Ans="";
    String vtor_chislo="";
    int operation_check=0;
    double chislo=0;
    int visible=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.textView);
//Присваиваем кнопки
        final Button button0 = (Button)findViewById(R.id.button17);
        final Button button1 = (Button)findViewById(R.id.button16);
        final Button button2 = (Button)findViewById(R.id.button15);
        final Button button3 = (Button)findViewById(R.id.button13);
        final Button button4 = (Button)findViewById(R.id.button7);
        final Button button5 = (Button)findViewById(R.id.button14);
        final Button button6 = (Button)findViewById(R.id.button8);
        final Button button7 = (Button)findViewById(R.id.button11);
        final Button button8 = (Button)findViewById(R.id.button10);
        final Button button9 = (Button)findViewById(R.id.button9);
        final Button button_c = (Button)findViewById(R.id.button);
        final Button button_del = (Button)findViewById(R.id.button20);
        final Button button_equal = (Button)findViewById(R.id.button21);
        final Button button_plus = (Button)findViewById(R.id.button6);
        final Button button_minus = (Button)findViewById(R.id.button5);
        final Button button_devide = (Button)findViewById(R.id.button3);
        final Button button_mult = (Button)findViewById(R.id.button4);
        final Button button_dot = (Button)findViewById(R.id.button19);
        final Button button_percent = (Button)findViewById(R.id.button2);

        final Button button_cos = (Button)findViewById(R.id.button18);
        final Button button_tg = (Button)findViewById(R.id.button26);
        final Button button_sin = (Button)findViewById(R.id.button25);
        final Button button_ctg = (Button)findViewById(R.id.button27);
        final Button button_visible = (Button)findViewById(R.id.button24);

//Обработка событий
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button_c.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_equal.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_devide.setOnClickListener(this);
        button_mult.setOnClickListener(this);
        button_percent.setOnClickListener(this);
        button_dot.setOnClickListener(this);
        button_cos.setOnClickListener(this);
        button_sin.setOnClickListener(this);
        button_tg.setOnClickListener(this);
        button_ctg.setOnClickListener(this);
        button_visible.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        //Ввод символов
            case R.id.button17:  enter("0"); break;
            case R.id.button16: enter("1"); break;
            case R.id.button15: enter("2"); break;
            case R.id.button13: enter("3"); break;
            case R.id.button7: enter("4"); break;
            case R.id.button14: enter("5"); break;
            case R.id.button8: enter("6"); break;
            case R.id.button11:enter("7"); break;
            case R.id.button10: enter("8"); break;
            case R.id.button9: enter("9");  break;
            case R.id.button24:  if(visible==1)  invisible(); else visible();            break;     //Доп клавиши

            case R.id.button18:     //cos
                Ans="cos(";
                operation_check=5;
                textView.setText(Ans);
                break;

            case R.id.button25:     //sin
                Ans="sin(";
                operation_check=6;
                textView.setText(Ans);
                break;

            case R.id.button26:     //tg
                Ans="tg(";
                operation_check=7;
                textView.setText(Ans);
                break;

            case R.id.button27:     //tg
                Ans="ctg(";
                operation_check=8;
                textView.setText(Ans);
                break;

            case R.id.button19:{            //Dot
                if(Ans.length()>0 && operation_check==0 && !Ans.contains(".")){
                Ans+=".";    }
                else if(operation_check!=0 && vtor_chislo.length()>0 && !vtor_chislo.contains(".")){
                    Ans+=".";
                    vtor_chislo+=".";}
                    textView.setText(Ans); break;}

            case R.id.button2:                  //Percent
                if(operation_check==0 && Ans.length()>0){
                Ans=Double.toString(Double.parseDouble(Ans)/100);
                if(Ans.substring(Ans.length()-2,Ans.length()).equals(".0"))
                    Ans=Ans.substring(0,Ans.length()-2);}
                textView.setText(Ans); break;

            case R.id.button:  Ans="";    operation_check=0;  textView.setText(Ans); break;       //C

            case R.id.button20:     //del
                if(Ans.length()>0){
                    if(Ans.matches("[\\d]+")){           //Удаление первой чати
                        Ans=Ans.substring(0,Ans.length()-1);
                         }
                    else if(Ans.substring(Ans.length()-1).equals("(")){   //Удаление триг.функций
                        Ans="";
                        operation_check=0;
                    }
                    else{                                   //Удаление второй части
                        Ans=Ans.substring(0,Ans.length()-1);
                        if(vtor_chislo.length()>0)
                        vtor_chislo=vtor_chislo.substring(0,vtor_chislo.length()-1);
                        if(Ans.matches("[\\d]+"))
                        operation_check=0;
                    }
                    textView.setText(Ans); break;}

            case R.id.button21:       //Equals
                if(Ans.length()>0 ){
                    //Plus
                    if(operation_check==1 && vtor_chislo.length()>0){
                        chislo=chislo+Double.parseDouble(vtor_chislo);
                        Ans=Double.toString(chislo);
                        chislo=0;
                        vtor_chislo="";
                        operation_check=0;

                    }
                    //Minus
                    if(operation_check==2 && vtor_chislo.length()>0){
                        chislo=chislo-Double.parseDouble(vtor_chislo);
                        Ans=Double.toString(chislo);
                        chislo=0;
                        vtor_chislo="";
                        operation_check=0;


                    }
                    //Delete
                    if(operation_check==3 && vtor_chislo.length()>0){
                        if(vtor_chislo.equals("0")){
                            Ans="";
                            chislo=0;
                            vtor_chislo="";
                            operation_check=0;
                            textView.setText("Деление на 0");
                            break;
                        }
                        else{
                        chislo=chislo/Double.parseDouble(vtor_chislo);
                        chislo=(double)Math.round(chislo*1000000)/1000000;
                        Ans=Double.toString(chislo);
                        chislo=0;
                        vtor_chislo="";
                        operation_check=0;


                    }}
                    //Multiplication
                    if(operation_check==4 && vtor_chislo.length()>0){
                        chislo=chislo*Double.parseDouble(vtor_chislo);
                        Ans=Double.toString(chislo);
                        chislo=0;
                        vtor_chislo="";
                        operation_check=0;


                    }
                    //Cos
                    if((operation_check==5 || operation_check==99) && vtor_chislo.length()>0){
                        chislo=Math.toRadians(Double.parseDouble(vtor_chislo));
                        Ans=Double.toString(Math.cos(Math.toRadians(Double.parseDouble(vtor_chislo))));

                        if(Double.parseDouble(vtor_chislo)%90==0 ){         //Значения нуля
                            chislo=Double.parseDouble(vtor_chislo)/90;
                            if(chislo%2!=0)
                                Ans="0";}
                        chislo=0;
                        vtor_chislo="";
                        operation_check=0;
                    }
                    //Sin
                    if((operation_check==6 || operation_check==98) && vtor_chislo.length()>0){
                        chislo=Math.toRadians(Double.parseDouble(vtor_chislo));
                        Ans=Double.toString(Math.sin(Math.toRadians(Double.parseDouble(vtor_chislo))));

                        if(Double.parseDouble(vtor_chislo)%180==0 ){         //Значения нуля
                                Ans="0";}
                        chislo=0;
                        vtor_chislo="";
                        operation_check=0;
                    }
                    //Tg
                    if((operation_check==7 || operation_check==97) && vtor_chislo.length()>0){
                        chislo=Math.toRadians(Double.parseDouble(vtor_chislo));
                        Ans=Double.toString(Math.tan(Math.toRadians(Double.parseDouble(vtor_chislo))));



                        chislo=0;
                        vtor_chislo="";
                        operation_check=0;
                    }
                    //Ctg
                    if((operation_check==8 || operation_check==96) && vtor_chislo.length()>0){
                        chislo=Math.toRadians(Double.parseDouble(vtor_chislo));
                        Ans=Double.toString(1/(Math.tan(Math.toRadians(Double.parseDouble(vtor_chislo)))));


                        chislo=0;
                        vtor_chislo="";
                        operation_check=0;
                    }

                    if(Ans.length()>2){
                    if(Ans.substring(Ans.length()-2,Ans.length()).equals(".0"))
                        Ans=Ans.substring(0,Ans.length()-2);}

                    textView.setText(Ans);
                    break;}

            //Plus
            case R.id.button6:
                if(Ans.length()>0){
                    if(operation_check==0 ){ operation_check=1;
                        chislo=Double.parseDouble(Ans);
                    Ans+="+";
                    textView.setText(Ans); break;}}

            //Minus
            case R.id.button5:
                if(Ans.length()>0){
                    if(operation_check==0){ operation_check=2;
                        chislo=Double.parseDouble(Ans);
                        Ans+="-";}
                        //Обработка минуса в тригоном функциях
                    minus_trigonom(5);
                    minus_trigonom(6);
                    minus_trigonom(7);
                        textView.setText(Ans); break;}

            //Division
            case R.id.button3:
                if(Ans.length()>0){
                    if(operation_check==0 ){ operation_check=3;
                        chislo=Double.parseDouble(Ans);
                        Ans+="/";
                        textView.setText(Ans); break;}}
            //Multiplication
            case R.id.button4:
                if(Ans.length()>0){
                    if(operation_check==0){ operation_check=4;
                        chislo=Double.parseDouble(Ans);
                        Ans+="x";
                        textView.setText(Ans); break;}}

        }
    }

    //Ввод чисел
    public void enter(String s){
        if(Ans.equals("0"))
            Ans=s;
        else
            Ans+=s;
        if(operation_check!=0) {
            vtor_chislo+=s;
        }
        textView.setText(Ans);
    }

    //Скрытие кнопок
    public void invisible(){
        findViewById(R.id.button18).setVisibility(View.INVISIBLE);
        findViewById(R.id.button25).setVisibility(View.INVISIBLE);
        findViewById(R.id.button26).setVisibility(View.INVISIBLE);
        findViewById(R.id.button27).setVisibility(View.INVISIBLE);

        visible=0;



    }
    //Показ скрытых кнопок
    public void visible(){
        findViewById(R.id.button18).setVisibility(View.VISIBLE);
        findViewById(R.id.button25).setVisibility(View.VISIBLE);
        findViewById(R.id.button26).setVisibility(View.VISIBLE);
        findViewById(R.id.button27).setVisibility(View.VISIBLE);

        visible=1;
    }

    //Обработка тригоном. минуса
    public void minus_trigonom(int n){
        if(operation_check==n && vtor_chislo.length()==0){
            operation_check=104-n;
            Ans+="-";
            vtor_chislo+="-";
        }
    }

}
