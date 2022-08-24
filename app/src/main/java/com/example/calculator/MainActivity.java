package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int i;
    //Waiting operation is a flag to tell if we are in middle of operation or not
    //0 means we are not in operation
    int waitingOperation = 0;
    TextView title;
    Button SquareRoot;
    Button xSquared;
    Button xToY;
    Button NaturalLog;
    Button AllClear;
    Button PlusMinus;
    Button Percentage;
    Button Divide;
    Button Multiply;
    Button Subtract;
    Button Add;
    Button Equals;
    Button One;
    Button Two;
    Button Three;
    Button Four;
    Button Five;
    Button Six;
    Button Seven;
    Button Eight;
    Button Nine;
    Button Zero;
    Button Dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set MainActivity to your layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create calculator object and connect workspace to layout workspace and initialize to 0
        final Calculator calc = new Calculator();
        //Connecting the buttonIDS to their calling objects
        title = (TextView)  findViewById(R.id.CalcOutput);

        SquareRoot = (Button) findViewById(R.id.buttonSR);
        xSquared = (Button) findViewById(R.id.buttonX2);
        xToY = (Button) findViewById(R.id.buttonXY);
        NaturalLog = (Button) findViewById(R.id.buttonLN);

        AllClear = (Button) findViewById(R.id.buttonAC);
        PlusMinus = (Button) findViewById(R.id.buttonPM);
        Percentage = (Button) findViewById(R.id.buttonPercent);
        Divide = (Button) findViewById(R.id.buttonDivide);

        Multiply = (Button) findViewById(R.id.buttonMultiply);
        Subtract = (Button) findViewById(R.id.buttonMinus);
        Add = (Button) findViewById(R.id.buttonAdd);
        Equals = (Button) findViewById(R.id.buttonEquals);

        One = (Button) findViewById(R.id.button1);
        Two = (Button) findViewById(R.id.button2);
        Three = (Button) findViewById(R.id.button3);
        Four = (Button) findViewById(R.id.button4);
        Five = (Button) findViewById(R.id.button5);
        Six = (Button) findViewById(R.id.button6);
        Seven = (Button) findViewById(R.id.button7);
        Eight = (Button) findViewById(R.id.button8);
        Nine = (Button) findViewById(R.id.button9);
        Zero = (Button) findViewById(R.id.button0);
        Dot = (Button) findViewById(R.id.buttonDot);

        Calculator myCalc = new Calculator();
        title.setText("0");
        //Each Method below is listening for next input from user, and will call methods in Calcultor.java
        //to perform the operation specified
        SquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("SquareRoot Pressed");
                //For The top 4 functions have to check if doing the operation
                //before a number is inputted or after,
                //I did not complete the part where you can press the operation then type a number
                //but my calculator can type number then perform operation for sqrt,x^2, and ln
                //All other operations (add/sub/etc) work as intended
                if(myCalc.whatIsFlagInputString() == 1){
                    myCalc.convertToDouble();
                    title.setText(myCalc.quickSquareRoot());
                    waitingOperation = 7;
                }
                else {
                    title.setText("Did Not Complete");
                    //waitingOperation = myCalc.stateOfOperation(5);
                }
            }
        });
        xSquared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("x Squared Pressed");

                if(myCalc.whatIsFlagInputString() == 1){
                    myCalc.convertToDouble();
                    title.setText(myCalc.quickXSquared());
                    waitingOperation = 6;
                }
                else {
                    title.setText("Did Not Complete");
                    //waitingOperation = myCalc.stateOfOperation(5);
                }
            }
        });
        xToY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("X to Power Y  Pressed");
                myCalc.convertToDouble();
                waitingOperation = myCalc.stateOfOperation(6);
            }
        });
        NaturalLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("NaturalLog Pressed");
                if(myCalc.whatIsFlagInputString() == 1){
                    myCalc.convertToDouble();
                    title.setText(myCalc.quickNaturalLog());
                    waitingOperation = 8;
                }
                else {
                    title.setText("Did Not Complete");
                    //waitingOperation = myCalc.stateOfOperation(5);
                }
            }
        });

        //Second Row
        AllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCalc.clearString();
                myCalc.clearValues();
                title.setText("0");;
            }
        });
        PlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("Plus Minus Pressed");
                title.setText(myCalc.addNegativeToString());
            }
        });
        Percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("Percentage Pressed");
                title.setText(myCalc.makeInputPercent());
            }
        });
        Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("Divide Pressed");
                myCalc.convertToDouble(); //Convert first string to double
                waitingOperation = myCalc.stateOfOperation(4);
            }
        });
        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("Multiply Pressed");
                myCalc.convertToDouble(); //Convert first String to double
                waitingOperation = myCalc.stateOfOperation(2);
            }
        });
        Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("Subtract Pressed");
                myCalc.convertToDouble();
                waitingOperation = myCalc.stateOfOperation(3);
            }
        });
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //title.setText("Add Pressed");
                myCalc.convertToDouble();
                waitingOperation = myCalc.stateOfOperation(1);
            }
        });
        Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                title.setText(myCalc.completeOperation());
            }
        });

        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("1"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("1"));
                }
            }
        });
        Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {//Checking if there is active operation, if there is a current op clear input string
                    title.setText(myCalc.addToString("2"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("2"));
                }
            }

        });

        Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("3"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("3"));
                }
            }

        });
        Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("4"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("4"));
                }
            }

        });
        Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("5"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("5"));
                }
            }
        });
        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("6"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("6"));
                }
            }
        });
        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("7"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("7"));
                }
            }
        });
        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("8"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("8"));
                }
            }
        });
        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("9"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("9"));
                }
            }
        });
        Zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("0"));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("0"));
                }
            }
        });
        Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waitingOperation == 0) {
                    title.setText(myCalc.addToString("."));
                }
                else{
                    myCalc.clearString();
                    waitingOperation = 0;
                    title.setText(myCalc.addToString("."));
                }
            }
        });
    }
}
