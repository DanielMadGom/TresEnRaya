package com.example.tresenraya;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NivelFacil extends AppCompatActivity implements View.OnClickListener {

    int[] board = new int[9];
    ImageView button1,button2,button3,button4,button5,button6,button7,button8,button9;
    int spins=0,random=0;
    boolean winUser,winIA;
    private static int you=0,ia=0;
    private TextView scoreYou,scoreIA;
    private Button Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nivel_facil);
        button1=findViewById(R.id.buttonImage1);
        button2=findViewById(R.id.buttonImage2);
        button3=findViewById(R.id.buttonImage3);
        button4=findViewById(R.id.buttonImage4);
        button5=findViewById(R.id.buttonImage5);
        button6=findViewById(R.id.buttonImage6);
        button7=findViewById(R.id.buttonImage7);
        button8=findViewById(R.id.buttonImage8);
        button9=findViewById(R.id.buttonImage9);

        scoreYou=findViewById(R.id.ScoreOfYou);
        scoreIA=findViewById(R.id.ScoreAndroid);

        Reset=findViewById(R.id.Reset);

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setImageDrawable(null);
                button2.setImageDrawable(null);
                button3.setImageDrawable(null);
                button4.setImageDrawable(null);
                button5.setImageDrawable(null);
                button6.setImageDrawable(null);
                button7.setImageDrawable(null);
                button8.setImageDrawable(null);
                button9.setImageDrawable(null);
                resetValues();
                you=0;
                ia=0;
                scoreYou.setText("Score YOU : "+String.valueOf(you));
                scoreIA.setText("Score IA : "+String.valueOf(ia));
            }
        });

        for(int i=0; i<=8; i++){
            board[i]=0;
        }
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        random = (int) (8*Math.random()) + 1;
        updateScore();
    }

    @Override
    public void onClick(View v){
        boolean tiro = false;
        switch (v.getId()){
            case R.id.buttonImage1:
                if (board[0] == 0){
                    button1.setImageResource(R.drawable.user);
                    board[0] = 1;
                    spins++;
                    tiro = true;
                }
                break;

            case R.id.buttonImage2:
                if (board[1] == 0){
                    button2.setImageResource(R.drawable.user);
                    board[1] = 1;
                    spins++;
                    tiro = true;
                }
                break;

            case R.id.buttonImage3:
                if (board[2] == 0){
                    button3.setImageResource(R.drawable.user);
                    board[2] = 1;
                    spins++;
                    tiro = true;
                }
                break;

            case R.id.buttonImage4:
                if (board[3] == 0){
                    button4.setImageResource(R.drawable.user);
                    board[3] = 1;
                    spins++;
                    tiro = true;
                }
                break;

            case R.id.buttonImage5:
                if (board[4] == 0){
                    button5.setImageResource(R.drawable.user);
                    board[4] = 1;
                    spins++;
                    tiro = true;
                }
                break;

            case R.id.buttonImage6:
                if (board[5] == 0){
                    button6.setImageResource(R.drawable.user);
                    board[5] = 1;
                    spins++;
                    tiro = true;
                }
                break;

            case R.id.buttonImage7:
                if (board[6] == 0){
                    button7.setImageResource(R.drawable.user);
                    board[6] = 1;
                    spins++;
                    tiro = true;
                }
                break;

            case R.id.buttonImage8:
                if (board[7] == 0){
                    button8.setImageResource(R.drawable.user);
                    board[7] = 1;
                    spins++;
                    tiro = true;
                }
                break;

            case R.id.buttonImage9:
                if (board[8] == 0){
                    button9.setImageResource(R.drawable.user);
                    board[8] = 1;
                    spins++;
                    tiro = true;
                }
                break;
        }
        if(tiro == true){
            checkWinner();
            if(spins < 5 && winUser == false && winIA == false){
                turnIA();
            }
            checkWinner();
            check();
        }
    }

    public void turnIA(){
        random = (int)(8*Math.random())+1;
        if(board[random]==0){
            board[random]=2;
            switch (random){
                case 0:
                    button1.setImageResource(R.drawable.ia);
                    break;

                case 1:
                    button2.setImageResource(R.drawable.ia);
                    break;

                case 2:
                    button3.setImageResource(R.drawable.ia);
                    break;

                case 3:
                    button4.setImageResource(R.drawable.ia);
                    break;

                case 4:
                    button5.setImageResource(R.drawable.ia);
                    break;

                case 5:
                    button6.setImageResource(R.drawable.ia);
                    break;

                case 6:
                    button7.setImageResource(R.drawable.ia);
                    break;

                case 7:
                    button8.setImageResource(R.drawable.ia);
                    break;

                case 8:
                    button9.setImageResource(R.drawable.ia);
                    break;

                default:
                    break;
            }
        } else {
            turnIA();
        }
    }

    public void updateScore(){
        scoreYou.setText("Score YOU : "+String.valueOf(you));
        scoreIA.setText("Score IA : "+String.valueOf(ia));
    }

    public void check() {
        if(winUser ==true){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Has ganado").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    resetValues();
                }
            });

            AlertDialog alertDialog=builder.create();
            alertDialog.show();
            you++;
            scoreYou.setText("Score YOU : "+String.valueOf(you));
        }
        if(winIA ==true){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Gana la IA").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    resetValues();
                }
            });

            AlertDialog alertDialog=builder.create();
            alertDialog.show();
            ia++;
            scoreIA.setText("Score IA : "+String.valueOf(ia));
        }

        if(spins ==5 && winIA == false && winUser == false){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Hay empate").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();

        }
    }

    public static void reiniciarActivity(Activity activity){
        Intent intent = new Intent();
        intent.setClass(activity, activity.getClass());
        activity.startActivity(intent);
        activity.finish();
    }

    public void checkWinner(){
        //Gana el Jugador
        if(board[0]==1 && board[1]==1 && board[2]==1){
            winUser = true;
        }
        if(board[3]==1 && board[4]==1 && board[5]==1){
            winUser = true;
        }
        if(board[6]==1 && board[7]==1 && board[8]==1){
            winUser = true;
        }
        if(board[0]==1 && board[3]==1 && board[6]==1){
            winUser = true;
        }
        if(board[1]==1 && board[4]==1 && board[7]==1){
            winUser = true;
        }
        if(board[2]==1 && board[5]==1 && board[8]==1){
            winUser = true;
        }
        if(board[0]==1 && board[4]==1 && board[8]==1){
            winUser = true;
        }
        if(board[2]==1 && board[4]==1 && board[6]==1){
            winUser = true;
        }

        //Gana la IA
        if(board[0]==2 && board[1]==2 && board[2]==2){
            winIA = true;
        }
        if(board[3]==2 && board[4]==2 && board[5]==2){
            winIA = true;
        }
        if(board[6]==2 && board[7]==2 && board[8]==2){
            winIA = true;
        }
        if(board[0]==2 && board[3]==2 && board[6]==2){
            winIA = true;
        }
        if(board[1]==2 && board[4]==2 && board[7]==2){
            winIA = true;
        }
        if(board[2]==2 && board[5]==2 && board[8]==2){
            winIA = true;
        }
        if(board[0]==2 && board[4]==2 && board[8]==2){
            winIA = true;
        }
        if(board[2]==2 && board[4]==2 && board[6]==2){
            winIA = true;
        }
    }

    private void resetValues() {

        reiniciarActivity(this);

        board[0]=0;
        board[1]=0;
        board[2]=0;
        board[3]=0;
        board[4]=0;
        board[5]=0;
        board[6]=0;
        board[7]=0;
        board[8]=0;

        spins=0;
    }
}
