package com.example.vubuntu.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import static com.example.vubuntu.tictactoe.R.id.linearLayout;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer = 0;
    //0 for cross 1 for round

    int[] myGameState={2,2,2,2,2,2,2,2,2};

    public void imageTapped(View view){
        ImageView myTapped = (ImageView) view;
        //Log.i("tag is ",myTapped.getTag().toString());
        int tappedValue = Integer.parseInt(myTapped.getTag().toString());
        if(myGameState[tappedValue]==2){
            myGameState[tappedValue] = myActivePlayer;
            if(myActivePlayer==0){
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer=1;
            }
            else{
                myTapped.setImageResource(R.drawable.circle);
                myActivePlayer=0;
            }
        }
        else {
            Toast.makeText(this, "This is filled already!",
                    Toast.LENGTH_LONG).show();
        }

        //////// main logic for winning

        if(tappedValue==0){

            if(myGameState[0]==myGameState[1] && myGameState[1]==myGameState[2]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
            else if(myGameState[0]==myGameState[3] && myGameState[3]==myGameState[6]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
            else if(myGameState[0] == myGameState[4] && myGameState[4]==myGameState[8]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }

        }
//
        else if(tappedValue==1){
            if(myGameState[0]==myGameState[1] && myGameState[2]==myGameState[0]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
            else if(myGameState[1]==myGameState[4] && myGameState[1]==myGameState[7]) {
                Toast.makeText(this, "Congrats! Player " + myActivePlayer + " has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
        }
//
        else if(tappedValue==2){
            if(myGameState[0]==myGameState[1] && myGameState[2]==myGameState[0]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
//            else if(myGameState[2]==myGameState[5] && myGameState[2]==myGameState[8]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
//            else if(myGameState[2] == myGameState[4] && myGameState[2]==myGameState[6]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
//
        }
//
        else if(tappedValue==3){
//            if(myGameState[3]==myGameState[4] && myGameState[3]==myGameState[4]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
            //else
            if(myGameState[0]==myGameState[3] && myGameState[3]==myGameState[6]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
        }
//
        else if(tappedValue==4){
//            if(myGameState[3]==myGameState[4] && myGameState[3]==myGameState[4]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
//            else
            if(myGameState[1]==myGameState[4] && myGameState[4]==myGameState[7]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
            else if(myGameState[0] == myGameState[4] && myGameState[0]==myGameState[8]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
//            else if(myGameState[2] == myGameState[4] && myGameState[2]==myGameState[6]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
        }
//
//        else if(tappedValue==5){
//            if(myGameState[5]==myGameState[2] && myGameState[2]==myGameState[8]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
//            else if(myGameState[5]==myGameState[3] && myGameState[3]==myGameState[4]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
//        }
//
        else if(tappedValue==6){
//            if(myGameState[6]==myGameState[7] && myGameState[7]==myGameState[8]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
            //else
            if(myGameState[0]==myGameState[3] && myGameState[3]==myGameState[6]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
//            else if(myGameState[2] == myGameState[4] && myGameState[2]==myGameState[6]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
//
        }
//
        else if(tappedValue==7){
//            if(myGameState[6]==myGameState[7] && myGameState[7]==myGameState[8]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
            }
            //else
            if(myGameState[1]==myGameState[4] && myGameState[4]==myGameState[7]) {
                Toast.makeText(this, "Congrats! Player " + myActivePlayer + " has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
//        }
//
        else if(tappedValue==8){
//            if(myGameState[6]==myGameState[7] && myGameState[7]==myGameState[8]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
//            else if(myGameState[2]==myGameState[5] && myGameState[5]==myGameState[8]){
//                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
            //else
            if(myGameState[0] == myGameState[4] && myGameState[0]==myGameState[8]){
                Toast.makeText(this, "Congrats! Player "+myActivePlayer+" has won!",
                        Toast.LENGTH_LONG).show();
                return;
            }
//
        }

        ///////////

    }

//    public void buttonTapped(View view){
//
//        myActivePlayer = 0;
//
//        for(int i=0;i<myGameState.length;i++){
//            myGameState[i]=2;
//        }
//
//        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.line1);
//        for(int i=0; i<linearLayout1.getChildCount();i++) {
//            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
//
//        }
//
//        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.line2);
//        for(int i=0; i<linearLayout2.getChildCount();i++) {
//            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
//
//        }
//
//        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.line3);
//        for(int i=0; i<linearLayout3.getChildCount();i++) {
//            ((ImageView) linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
//
//        }
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
