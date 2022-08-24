package com.example.calculator;

import android.widget.TextView;
import java.text.DecimalFormat;
import java.lang.Math;
public class Calculator {
    //two numbers used in operation
    String input = ""; //Input holds whatever user created as a number, but as a string form
    double firstNum;
    double lastNum;
    double tempVariable;
    String stringTempVariable;
    int flagInputString = 0; //Used for creating number when pressing number buttons, deciding to clear input string or not
    //operation variable
    int operation; //no operation = 0, Flag used to decide whether we come from complete operation, or still in operation
    //actual text space, showing numbers
    TextView workspace;
    //tool to help round numbers to 7 decimals

    DecimalFormat df = new DecimalFormat("#######.#######"); //Format output to 7 decimals


    //Method to format the output before displayed
    public String cleanOutput(double output){
            String tempVar;
            tempVar = df.format(output); //Turns double output to string
        return(tempVar);
    }
    //constructor
    public Calculator(){
        firstNum = 0;

    }
    //Return status if flaginputstring so that MainActivity.java can access this value
    public int whatIsFlagInputString(){
        return(flagInputString);
    }

    public void convertToDouble(){
        //If no op then convert vaue of input string into double in firstnum, else we are in mid op so put in lastnum
        if(operation == 0) {
            if(flagInputString != 0) { //FirstNum has result, no input
                firstNum = Double.parseDouble(input);
            }
        }
        else{
            lastNum = Double.parseDouble(input);
        }
    }
    public String addToString(String userInput){
        flagInputString = 1; //Adding string means we are in process of creating a number
        input = input + userInput;

        return(input);
    }
    public String makeInputPercent(){
        //Divide by 100 to turn input into a percent, and use double conversion
        if(flagInputString == 0){//Just completed an operation, nothing added to string
            firstNum = (firstNum/100);
            input = ("" + firstNum);
            return(input);
        }
        else { //Coming from entering a new number
            tempVariable = Double.parseDouble(input);
            tempVariable = (tempVariable/100);
            input = ("" + tempVariable);
            return (input);
        }
    }
    //Convert to negative
    public String addNegativeToString(){
        //Conversion of input to double to convert to negative or positive number,
        //using conversion to avoid maintaining a state flag
        if(flagInputString == 0){//Just completed an operation, nothing added to string
            firstNum = (firstNum * -1);
            input = ("" + firstNum);
            return(input);
        }
        else { //Coming from entering a new number
            tempVariable = Double.parseDouble(input);
            tempVariable = (tempVariable * -1);
            input = ("" + tempVariable);
            return (input);
        }
    }
    //Method to clear the values of firstnum and lastnum
    public void clearValues(){
        //operation = 0;
        firstNum = 0;
        lastNum = 0;
    }
    //Put string back to null state
    public String clearString(){

        input = "";
        return(input);
    }

    public int stateOfOperation(int whatOperation){
        //Each number for operation signifies a specific operation
        //1 = add
        //2 = multiply
        //3 = Subtract
        //4 = Divide
        //5 xSquared
        //6 xtoPowerY
        operation = whatOperation;
        return(operation);
    }


    //Creating the operation methods
    //Add Button functionality
    public double addValues(){
            return(firstNum + lastNum);
    }
    //Multiply Button Functionality
    public double multiplyValues(){
        return(firstNum * lastNum);
    }
    //Subtract Button Functionality
    public double subtractValues(){
        return(firstNum - lastNum);
    }
    //X to power Functionality
    public double xToPowerY(){
        return(Math.pow(firstNum,lastNum));
    }
    //Divide Button Functionality
    public String divideValues(){

        if(lastNum == 0){
            return("Error"); //Cant Divide by 0 return error
        }
        else{
            return("" + (firstNum/lastNum));
        }
    }

    public String quickXSquared(){
        //Can type number and click square button, but cannot click square and input number then equals
        //or have a result from operation and perform square on that number
        firstNum = (firstNum * firstNum);
        flagInputString = 0;
        input = ("" + firstNum); //Keep input with updated info for continual operations
        return(cleanOutput(firstNum));
    }
    public String quickSquareRoot(){
        //Can type number and click squareroot, but cannot click squareoot and input number then equals
        //or have a result from operation and perform squareoot on that number
        firstNum = Math.sqrt(firstNum);
        flagInputString = 0;
        input = ("" + firstNum); //Keep input with updated info for continual operations
        return(cleanOutput(firstNum));
    }
    public String quickNaturalLog(){
        //Can type number and click ln, but cannot click ln and input number then equals
        //or have a result from operation and perform squareoot on that number
        firstNum = Math.log(firstNum);
        flagInputString = 0;
        input = ("" + firstNum); //Keep input with updated info for continual operations
        return(cleanOutput(firstNum));
    }
    //xSquared Button Functionality
    public double xSquared(){
        firstNum= (firstNum * firstNum);

        return(firstNum);

    }

    public String completeOperation(){
        //Method Called when we click equals button on calculator to finish the operation

        if(operation == 1){
            convertToDouble(); //Convert second string into the double value
            operation = 0; //Completed operation return back (no pending op)
            tempVariable = addValues();
            firstNum = tempVariable;
            lastNum = 0;
            flagInputString = 0;
            clearString();
            return(cleanOutput(tempVariable)); //Call Addvalues to add the two values and return it as a string
        }
        if(operation == 2){
            convertToDouble(); //Convert second string into the double value
            operation = 0; //Completed Op
            tempVariable = multiplyValues();
            firstNum = tempVariable;
            lastNum = 0;
            flagInputString = 0;
            clearString();
            return(cleanOutput(tempVariable));
        }
        if(operation == 3){
            convertToDouble(); //Convert second string into the double value
            operation = 0;//Completed op
            tempVariable = subtractValues();
            firstNum = tempVariable;
            lastNum = 0;
            flagInputString = 0;
            clearString();
            return(cleanOutput(tempVariable));
        }
        if(operation == 4){
            convertToDouble(); //Convert second string into the double value
            operation = 0;
            stringTempVariable = divideValues();
            if(stringTempVariable == "Error"){
                clearValues();
                flagInputString = 0;
                clearString();
                return("Error");

            }
            else {
                firstNum = Double.parseDouble(stringTempVariable);
                lastNum = 0;
                flagInputString = 0;
                clearString();
                return ("" + stringTempVariable);
            }
        }
        if(operation == 5){
            //Create flag to tell to set input to firstnum, or use what is in firstum
            //if(flag = 1)???


            /*input = ("" + firstNum); DID not finish Implementation
            convertToDouble();
            operation = 0;
            tempVariable = xSquared();
            input = ("" + tempVariable);
            firstNum = tempVariable;
            lastNum = 0;
            flagInputString = 0;
            clearString();
            return("" + tempVariable);*/
        }

        if(operation == 6){
            convertToDouble(); //Convert second string into the double value
            operation = 0; //Completed operation return back (no pending op)
            tempVariable = xToPowerY();
            firstNum = tempVariable;
            lastNum = 0;
            flagInputString = 0;
            clearString();
            return(cleanOutput(tempVariable));
        }
        return("");
    }
}
